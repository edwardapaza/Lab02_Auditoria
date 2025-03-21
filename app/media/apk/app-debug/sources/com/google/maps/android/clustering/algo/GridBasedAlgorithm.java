package com.google.maps.android.clustering.algo;

import androidx.collection.LongSparseArray;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class GridBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_GRID_SIZE = 100;
    private int mGridSize = 100;
    private final Set<T> mItems = Collections.synchronizedSet(new HashSet());

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T item) {
        return this.mItems.add(item);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> items) {
        return this.mItems.addAll(items);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.mItems.clear();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T item) {
        return this.mItems.remove(item);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> items) {
        return this.mItems.removeAll(items);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T item) {
        boolean result;
        synchronized (this.mItems) {
            result = removeItem(item);
            if (result) {
                result = addItem(item);
            }
        }
        return result;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int maxDistance) {
        this.mGridSize = maxDistance;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mGridSize;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float zoom) {
        long numCells;
        long numCells2 = (long) Math.ceil((Math.pow(2.0d, zoom) * 256.0d) / this.mGridSize);
        SphericalMercatorProjection proj = new SphericalMercatorProjection(numCells2);
        HashSet<Cluster<T>> clusters = new HashSet<>();
        LongSparseArray<StaticCluster<T>> sparseArray = new LongSparseArray<>();
        synchronized (this.mItems) {
            try {
                try {
                    Iterator<T> it = this.mItems.iterator();
                    while (it.hasNext()) {
                        T item = it.next();
                        Point p = proj.toPoint(item.getPosition());
                        Iterator<T> it2 = it;
                        long coord = getCoord(numCells2, p.x, p.y);
                        StaticCluster<T> cluster = sparseArray.get(coord);
                        if (cluster != null) {
                            numCells = numCells2;
                        } else {
                            numCells = numCells2;
                            cluster = new StaticCluster<>(proj.toLatLng(new Point(Math.floor(p.x) + 0.5d, Math.floor(p.y) + 0.5d)));
                            sparseArray.put(coord, cluster);
                            clusters.add(cluster);
                        }
                        cluster.add(item);
                        it = it2;
                        numCells2 = numCells;
                    }
                    return clusters;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.mItems;
    }

    private static long getCoord(long numCells, double x, double y) {
        return (long) ((numCells * Math.floor(x)) + Math.floor(y));
    }
}
