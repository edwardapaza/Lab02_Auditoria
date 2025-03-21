package com.google.maps.android.clustering;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.Algorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator;
import com.google.maps.android.clustering.algo.ScreenBasedAlgorithm;
import com.google.maps.android.clustering.algo.ScreenBasedAlgorithmAdapter;
import com.google.maps.android.clustering.view.ClusterRenderer;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.collections.MarkerManager;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class ClusterManager<T extends ClusterItem> implements GoogleMap.OnCameraIdleListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {
    private ScreenBasedAlgorithm<T> mAlgorithm;
    private final MarkerManager.Collection mClusterMarkers;
    private ClusterManager<T>.ClusterTask mClusterTask;
    private final ReadWriteLock mClusterTaskLock;
    private GoogleMap mMap;
    private final MarkerManager mMarkerManager;
    private final MarkerManager.Collection mMarkers;
    private OnClusterClickListener<T> mOnClusterClickListener;
    private OnClusterInfoWindowClickListener<T> mOnClusterInfoWindowClickListener;
    private OnClusterInfoWindowLongClickListener<T> mOnClusterInfoWindowLongClickListener;
    private OnClusterItemClickListener<T> mOnClusterItemClickListener;
    private OnClusterItemInfoWindowClickListener<T> mOnClusterItemInfoWindowClickListener;
    private OnClusterItemInfoWindowLongClickListener<T> mOnClusterItemInfoWindowLongClickListener;
    private CameraPosition mPreviousCameraPosition;
    private ClusterRenderer<T> mRenderer;

    /* loaded from: classes.dex */
    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    /* loaded from: classes.dex */
    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
        void onClusterInfoWindowClick(Cluster<T> cluster);
    }

    /* loaded from: classes.dex */
    public interface OnClusterInfoWindowLongClickListener<T extends ClusterItem> {
        void onClusterInfoWindowLongClick(Cluster<T> cluster);
    }

    /* loaded from: classes.dex */
    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    /* loaded from: classes.dex */
    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowClick(T t);
    }

    /* loaded from: classes.dex */
    public interface OnClusterItemInfoWindowLongClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowLongClick(T t);
    }

    public ClusterManager(Context context, GoogleMap map) {
        this(context, map, new MarkerManager(map));
    }

    public ClusterManager(Context context, GoogleMap map, MarkerManager markerManager) {
        this.mClusterTaskLock = new ReentrantReadWriteLock();
        this.mMap = map;
        this.mMarkerManager = markerManager;
        this.mClusterMarkers = markerManager.newCollection();
        this.mMarkers = markerManager.newCollection();
        this.mRenderer = new DefaultClusterRenderer(context, map, this);
        this.mAlgorithm = new ScreenBasedAlgorithmAdapter(new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm()));
        this.mClusterTask = new ClusterTask();
        this.mRenderer.onAdd();
    }

    public MarkerManager.Collection getMarkerCollection() {
        return this.mMarkers;
    }

    public MarkerManager.Collection getClusterMarkerCollection() {
        return this.mClusterMarkers;
    }

    public MarkerManager getMarkerManager() {
        return this.mMarkerManager;
    }

    public void setRenderer(ClusterRenderer<T> renderer) {
        this.mRenderer.setOnClusterClickListener(null);
        this.mRenderer.setOnClusterItemClickListener(null);
        this.mClusterMarkers.clear();
        this.mMarkers.clear();
        this.mRenderer.onRemove();
        this.mRenderer = renderer;
        renderer.onAdd();
        this.mRenderer.setOnClusterClickListener(this.mOnClusterClickListener);
        this.mRenderer.setOnClusterInfoWindowClickListener(this.mOnClusterInfoWindowClickListener);
        this.mRenderer.setOnClusterInfoWindowLongClickListener(this.mOnClusterInfoWindowLongClickListener);
        this.mRenderer.setOnClusterItemClickListener(this.mOnClusterItemClickListener);
        this.mRenderer.setOnClusterItemInfoWindowClickListener(this.mOnClusterItemInfoWindowClickListener);
        this.mRenderer.setOnClusterItemInfoWindowLongClickListener(this.mOnClusterItemInfoWindowLongClickListener);
        cluster();
    }

    public void setAlgorithm(Algorithm<T> algorithm) {
        if (algorithm instanceof ScreenBasedAlgorithm) {
            setAlgorithm((ScreenBasedAlgorithm) ((ScreenBasedAlgorithm) algorithm));
        } else {
            setAlgorithm((ScreenBasedAlgorithm) new ScreenBasedAlgorithmAdapter(algorithm));
        }
    }

    public void setAlgorithm(ScreenBasedAlgorithm<T> algorithm) {
        algorithm.lock();
        try {
            Algorithm<T> oldAlgorithm = getAlgorithm();
            this.mAlgorithm = algorithm;
            if (oldAlgorithm != null) {
                oldAlgorithm.lock();
                algorithm.addItems(oldAlgorithm.getItems());
                oldAlgorithm.unlock();
            }
            algorithm.unlock();
            if (this.mAlgorithm.shouldReclusterOnMapMovement()) {
                this.mAlgorithm.onCameraChange(this.mMap.getCameraPosition());
            }
            cluster();
        } catch (Throwable th) {
            algorithm.unlock();
            throw th;
        }
    }

    public void setAnimation(boolean animate) {
        this.mRenderer.setAnimation(animate);
    }

    public ClusterRenderer<T> getRenderer() {
        return this.mRenderer;
    }

    public Algorithm<T> getAlgorithm() {
        return this.mAlgorithm;
    }

    public void clearItems() {
        Algorithm<T> algorithm = getAlgorithm();
        algorithm.lock();
        try {
            algorithm.clearItems();
        } finally {
            algorithm.unlock();
        }
    }

    public boolean addItems(Collection<T> items) {
        Algorithm<T> algorithm = getAlgorithm();
        algorithm.lock();
        try {
            return algorithm.addItems(items);
        } finally {
            algorithm.unlock();
        }
    }

    public boolean addItem(T myItem) {
        Algorithm<T> algorithm = getAlgorithm();
        algorithm.lock();
        try {
            return algorithm.addItem(myItem);
        } finally {
            algorithm.unlock();
        }
    }

    public boolean removeItems(Collection<T> items) {
        Algorithm<T> algorithm = getAlgorithm();
        algorithm.lock();
        try {
            return algorithm.removeItems(items);
        } finally {
            algorithm.unlock();
        }
    }

    public boolean removeItem(T item) {
        Algorithm<T> algorithm = getAlgorithm();
        algorithm.lock();
        try {
            return algorithm.removeItem(item);
        } finally {
            algorithm.unlock();
        }
    }

    public boolean updateItem(T item) {
        Algorithm<T> algorithm = getAlgorithm();
        algorithm.lock();
        try {
            return algorithm.updateItem(item);
        } finally {
            algorithm.unlock();
        }
    }

    public void cluster() {
        this.mClusterTaskLock.writeLock().lock();
        try {
            this.mClusterTask.cancel(true);
            ClusterManager<T>.ClusterTask clusterTask = new ClusterTask();
            this.mClusterTask = clusterTask;
            clusterTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Float.valueOf(this.mMap.getCameraPosition().zoom));
        } finally {
            this.mClusterTaskLock.writeLock().unlock();
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public void onCameraIdle() {
        ClusterRenderer<T> clusterRenderer = this.mRenderer;
        if (clusterRenderer instanceof GoogleMap.OnCameraIdleListener) {
            ((GoogleMap.OnCameraIdleListener) clusterRenderer).onCameraIdle();
        }
        this.mAlgorithm.onCameraChange(this.mMap.getCameraPosition());
        if (this.mAlgorithm.shouldReclusterOnMapMovement()) {
            cluster();
            return;
        }
        CameraPosition cameraPosition = this.mPreviousCameraPosition;
        if (cameraPosition == null || cameraPosition.zoom != this.mMap.getCameraPosition().zoom) {
            this.mPreviousCameraPosition = this.mMap.getCameraPosition();
            cluster();
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        return getMarkerManager().onMarkerClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        getMarkerManager().onInfoWindowClick(marker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ClusterTask extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        private ClusterTask() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            onPostExecute((Set) ((Set) obj));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Set<? extends Cluster<T>> doInBackground(Float... zoom) {
            Algorithm<T> algorithm = ClusterManager.this.getAlgorithm();
            algorithm.lock();
            try {
                return algorithm.getClusters(zoom[0].floatValue());
            } finally {
                algorithm.unlock();
            }
        }

        protected void onPostExecute(Set<? extends Cluster<T>> clusters) {
            ClusterManager.this.mRenderer.onClustersChanged(clusters);
        }
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> listener) {
        this.mOnClusterClickListener = listener;
        this.mRenderer.setOnClusterClickListener(listener);
    }

    public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> listener) {
        this.mOnClusterInfoWindowClickListener = listener;
        this.mRenderer.setOnClusterInfoWindowClickListener(listener);
    }

    public void setOnClusterInfoWindowLongClickListener(OnClusterInfoWindowLongClickListener<T> listener) {
        this.mOnClusterInfoWindowLongClickListener = listener;
        this.mRenderer.setOnClusterInfoWindowLongClickListener(listener);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> listener) {
        this.mOnClusterItemClickListener = listener;
        this.mRenderer.setOnClusterItemClickListener(listener);
    }

    public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> listener) {
        this.mOnClusterItemInfoWindowClickListener = listener;
        this.mRenderer.setOnClusterItemInfoWindowClickListener(listener);
    }

    public void setOnClusterItemInfoWindowLongClickListener(OnClusterItemInfoWindowLongClickListener<T> listener) {
        this.mOnClusterItemInfoWindowLongClickListener = listener;
        this.mRenderer.setOnClusterItemInfoWindowLongClickListener(listener);
    }
}
