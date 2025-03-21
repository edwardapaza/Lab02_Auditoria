package io.flutter.plugins.googlemaps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.collections.MarkerManager;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ClusterManagersController implements GoogleMap.OnCameraIdleListener, ClusterManager.OnClusterClickListener<MarkerBuilder> {
    private ClusterManager.OnClusterItemClickListener<MarkerBuilder> clusterItemClickListener;
    private OnClusterItemRendered<MarkerBuilder> clusterItemRenderedListener;
    private final HashMap<String, ClusterManager<MarkerBuilder>> clusterManagerIdToManager = new HashMap<>();
    private final Context context;
    private GoogleMap googleMap;
    private MarkerManager markerManager;
    private final MethodChannel methodChannel;

    /* loaded from: classes2.dex */
    public interface OnClusterItemRendered<T extends ClusterItem> {
        void onClusterItemRendered(T t, Marker marker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClusterManagersController(MethodChannel methodChannel, Context context) {
        this.context = context;
        this.methodChannel = methodChannel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(GoogleMap googleMap, MarkerManager markerManager) {
        this.markerManager = markerManager;
        this.googleMap = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClusterItemClickListener(ClusterManager.OnClusterItemClickListener<MarkerBuilder> listener) {
        this.clusterItemClickListener = listener;
        initListenersForClusterManagers();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClusterItemRenderedListener(OnClusterItemRendered<MarkerBuilder> listener) {
        this.clusterItemRenderedListener = listener;
    }

    private void initListenersForClusterManagers() {
        for (Map.Entry<String, ClusterManager<MarkerBuilder>> entry : this.clusterManagerIdToManager.entrySet()) {
            initListenersForClusterManager(entry.getValue(), this, this.clusterItemClickListener);
        }
    }

    private void initListenersForClusterManager(ClusterManager<MarkerBuilder> clusterManager, ClusterManager.OnClusterClickListener<MarkerBuilder> clusterClickListener, ClusterManager.OnClusterItemClickListener<MarkerBuilder> clusterItemClickListener) {
        clusterManager.setOnClusterClickListener(clusterClickListener);
        clusterManager.setOnClusterItemClickListener(clusterItemClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addClusterManagers(List<Object> clusterManagersToAdd) {
        for (Object clusterToAdd : clusterManagersToAdd) {
            addClusterManager(clusterToAdd);
        }
    }

    void addClusterManager(Object clusterManagerData) {
        String clusterManagerId = getClusterManagerId(clusterManagerData);
        if (clusterManagerId == null) {
            throw new IllegalArgumentException("clusterManagerId was null");
        }
        ClusterManager<MarkerBuilder> clusterManager = new ClusterManager<>(this.context, this.googleMap, this.markerManager);
        ClusterRenderer<MarkerBuilder> clusterRenderer = new ClusterRenderer<>(this.context, this.googleMap, clusterManager, this);
        clusterManager.setRenderer(clusterRenderer);
        initListenersForClusterManager(clusterManager, this, this.clusterItemClickListener);
        this.clusterManagerIdToManager.put(clusterManagerId, clusterManager);
    }

    public void removeClusterManagers(List<Object> clusterManagerIdsToRemove) {
        for (Object rawClusterManagerId : clusterManagerIdsToRemove) {
            if (rawClusterManagerId != null) {
                String clusterManagerId = (String) rawClusterManagerId;
                removeClusterManager(clusterManagerId);
            }
        }
    }

    private void removeClusterManager(Object clusterManagerId) {
        ClusterManager<MarkerBuilder> clusterManager = this.clusterManagerIdToManager.remove(clusterManagerId);
        if (clusterManager == null) {
            return;
        }
        initListenersForClusterManager(clusterManager, null, null);
        clusterManager.clearItems();
        clusterManager.cluster();
    }

    public void addItem(MarkerBuilder item) {
        ClusterManager<MarkerBuilder> clusterManager = this.clusterManagerIdToManager.get(item.clusterManagerId());
        if (clusterManager != null) {
            clusterManager.addItem(item);
            clusterManager.cluster();
        }
    }

    public void removeItem(MarkerBuilder item) {
        ClusterManager<MarkerBuilder> clusterManager = this.clusterManagerIdToManager.get(item.clusterManagerId());
        if (clusterManager != null) {
            clusterManager.removeItem(item);
            clusterManager.cluster();
        }
    }

    void onClusterItemRendered(MarkerBuilder item, Marker marker) {
        OnClusterItemRendered<MarkerBuilder> onClusterItemRendered = this.clusterItemRenderedListener;
        if (onClusterItemRendered != null) {
            onClusterItemRendered.onClusterItemRendered(item, marker);
        }
    }

    private static String getClusterManagerId(Object clusterManagerData) {
        Map<String, Object> clusterMap = (Map) clusterManagerData;
        return (String) clusterMap.get("clusterManagerId");
    }

    public void getClustersWithClusterManagerId(String clusterManagerId, MethodChannel.Result result) {
        ClusterManager<MarkerBuilder> clusterManager = this.clusterManagerIdToManager.get(clusterManagerId);
        if (clusterManager == null) {
            result.error("Invalid clusterManagerId", "getClusters called with invalid clusterManagerId:" + clusterManagerId, null);
            return;
        }
        Set<? extends Cluster<MarkerBuilder>> clusters = clusterManager.getAlgorithm().getClusters(this.googleMap.getCameraPosition().zoom);
        result.success(Convert.clustersToJson(clusterManagerId, clusters));
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public void onCameraIdle() {
        for (Map.Entry<String, ClusterManager<MarkerBuilder>> entry : this.clusterManagerIdToManager.entrySet()) {
            entry.getValue().onCameraIdle();
        }
    }

    @Override // com.google.maps.android.clustering.ClusterManager.OnClusterClickListener
    public boolean onClusterClick(Cluster<MarkerBuilder> cluster) {
        if (cluster.getSize() > 0) {
            MarkerBuilder[] builders = (MarkerBuilder[]) cluster.getItems().toArray(new MarkerBuilder[0]);
            String clusterManagerId = builders[0].clusterManagerId();
            this.methodChannel.invokeMethod("cluster#onTap", Convert.clusterToJson(clusterManagerId, cluster));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ClusterRenderer<T extends MarkerBuilder> extends DefaultClusterRenderer<T> {
        private final ClusterManagersController clusterManagersController;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
        protected /* bridge */ /* synthetic */ void onBeforeClusterItemRendered(ClusterItem clusterItem, MarkerOptions markerOptions) {
            onBeforeClusterItemRendered((ClusterRenderer<T>) ((MarkerBuilder) clusterItem), markerOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
        public /* bridge */ /* synthetic */ void onClusterItemRendered(ClusterItem clusterItem, Marker marker) {
            onClusterItemRendered((ClusterRenderer<T>) ((MarkerBuilder) clusterItem), marker);
        }

        public ClusterRenderer(Context context, GoogleMap map, ClusterManager<T> clusterManager, ClusterManagersController clusterManagersController) {
            super(context, map, clusterManager);
            this.clusterManagersController = clusterManagersController;
        }

        protected void onBeforeClusterItemRendered(T item, MarkerOptions markerOptions) {
            item.update(markerOptions);
        }

        protected void onClusterItemRendered(T item, Marker marker) {
            super.onClusterItemRendered((ClusterRenderer<T>) item, marker);
            this.clusterManagersController.onClusterItemRendered(item, marker);
        }
    }
}
