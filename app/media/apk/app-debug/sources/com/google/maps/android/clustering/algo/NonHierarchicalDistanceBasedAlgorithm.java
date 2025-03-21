package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_MAX_DISTANCE_AT_ZOOM = 100;
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private int mMaxDistance = 100;
    private final Collection<QuadItem<T>> mItems = new LinkedHashSet();
    private final PointQuadTree<QuadItem<T>> mQuadTree = new PointQuadTree<>(0.0d, 1.0d, 0.0d, 1.0d);

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T item) {
        boolean result;
        QuadItem<T> quadItem = new QuadItem<>(item);
        synchronized (this.mQuadTree) {
            result = this.mItems.add(quadItem);
            if (result) {
                this.mQuadTree.add(quadItem);
            }
        }
        return result;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> items) {
        boolean result = false;
        for (T item : items) {
            boolean individualResult = addItem(item);
            if (individualResult) {
                result = true;
            }
        }
        return result;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        synchronized (this.mQuadTree) {
            this.mItems.clear();
            this.mQuadTree.clear();
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T item) {
        boolean result;
        QuadItem<T> quadItem = new QuadItem<>(item);
        synchronized (this.mQuadTree) {
            result = this.mItems.remove(quadItem);
            if (result) {
                this.mQuadTree.remove(quadItem);
            }
        }
        return result;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> items) {
        boolean result = false;
        synchronized (this.mQuadTree) {
            for (T item : items) {
                QuadItem<T> quadItem = new QuadItem<>(item);
                boolean individualResult = this.mItems.remove(quadItem);
                if (individualResult) {
                    this.mQuadTree.remove(quadItem);
                    result = true;
                }
            }
        }
        return result;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T item) {
        boolean result;
        synchronized (this.mQuadTree) {
            result = removeItem(item);
            if (result) {
                result = addItem(item);
            }
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float zoom) {
        double zoomSpecificSpan;
        NonHierarchicalDistanceBasedAlgorithm<T> nonHierarchicalDistanceBasedAlgorithm = this;
        int discreteZoom = (int) zoom;
        double zoomSpecificSpan2 = (nonHierarchicalDistanceBasedAlgorithm.mMaxDistance / Math.pow(2.0d, discreteZoom)) / 256.0d;
        Set<QuadItem<T>> visitedCandidates = new HashSet<>();
        Set<Cluster<T>> results = new HashSet<>();
        Map<QuadItem<T>, Double> distanceToCluster = new HashMap<>();
        HashMap hashMap = new HashMap();
        synchronized (nonHierarchicalDistanceBasedAlgorithm.mQuadTree) {
            try {
                Iterator<QuadItem<T>> it = nonHierarchicalDistanceBasedAlgorithm.getClusteringItems(nonHierarchicalDistanceBasedAlgorithm.mQuadTree, zoom).iterator();
                while (it.hasNext()) {
                    QuadItem<T> candidate = it.next();
                    if (!visitedCandidates.contains(candidate)) {
                        Bounds searchBounds = nonHierarchicalDistanceBasedAlgorithm.createBoundsFromSpan(candidate.getPoint(), zoomSpecificSpan2);
                        Collection<QuadItem<T>> clusterItems = nonHierarchicalDistanceBasedAlgorithm.mQuadTree.search(searchBounds);
                        if (clusterItems.size() == 1) {
                            try {
                                results.add(candidate);
                                visitedCandidates.add(candidate);
                                distanceToCluster.put(candidate, Double.valueOf(0.0d));
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } else {
                            StaticCluster staticCluster = new StaticCluster(((QuadItem) candidate).mClusterItem.getPosition());
                            results.add(staticCluster);
                            for (QuadItem<T> clusterItem : clusterItems) {
                                Iterator<QuadItem<T>> it2 = it;
                                Double existingDistance = distanceToCluster.get(clusterItem);
                                int discreteZoom2 = discreteZoom;
                                try {
                                    double distance = nonHierarchicalDistanceBasedAlgorithm.distanceSquared(clusterItem.getPoint(), candidate.getPoint());
                                    if (existingDistance == null) {
                                        zoomSpecificSpan = zoomSpecificSpan2;
                                    } else if (existingDistance.doubleValue() < distance) {
                                        it = it2;
                                        discreteZoom = discreteZoom2;
                                    } else {
                                        zoomSpecificSpan = zoomSpecificSpan2;
                                        try {
                                            ((StaticCluster) hashMap.get(clusterItem)).remove(((QuadItem) clusterItem).mClusterItem);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    }
                                    distanceToCluster.put(clusterItem, Double.valueOf(distance));
                                    staticCluster.add(((QuadItem) clusterItem).mClusterItem);
                                    hashMap.put(clusterItem, staticCluster);
                                    nonHierarchicalDistanceBasedAlgorithm = this;
                                    it = it2;
                                    discreteZoom = discreteZoom2;
                                    zoomSpecificSpan2 = zoomSpecificSpan;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            visitedCandidates.addAll(clusterItems);
                            nonHierarchicalDistanceBasedAlgorithm = this;
                            it = it;
                            discreteZoom = discreteZoom;
                            zoomSpecificSpan2 = zoomSpecificSpan2;
                        }
                    }
                }
                return results;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    protected Collection<QuadItem<T>> getClusteringItems(PointQuadTree<QuadItem<T>> quadTree, float zoom) {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.mQuadTree) {
            for (QuadItem<T> quadItem : this.mItems) {
                linkedHashSet.add(((QuadItem) quadItem).mClusterItem);
            }
        }
        return linkedHashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int maxDistance) {
        this.mMaxDistance = maxDistance;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mMaxDistance;
    }

    private double distanceSquared(Point a, Point b) {
        return ((a.x - b.x) * (a.x - b.x)) + ((a.y - b.y) * (a.y - b.y));
    }

    private Bounds createBoundsFromSpan(Point p, double span) {
        double halfSpan = span / 2.0d;
        return new Bounds(p.x - halfSpan, p.x + halfSpan, p.y - halfSpan, p.y + halfSpan);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class QuadItem<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        private final T mClusterItem;
        private final Point mPoint;
        private final LatLng mPosition;
        private Set<T> singletonSet;

        private QuadItem(T item) {
            this.mClusterItem = item;
            LatLng position = item.getPosition();
            this.mPosition = position;
            this.mPoint = NonHierarchicalDistanceBasedAlgorithm.PROJECTION.toPoint(position);
            this.singletonSet = Collections.singleton(item);
        }

        @Override // com.google.maps.android.quadtree.PointQuadTree.Item
        public Point getPoint() {
            return this.mPoint;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public LatLng getPosition() {
            return this.mPosition;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public Set<T> getItems() {
            return this.singletonSet;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public int getSize() {
            return 1;
        }

        public int hashCode() {
            return this.mClusterItem.hashCode();
        }

        public boolean equals(Object other) {
            if (!(other instanceof QuadItem)) {
                return false;
            }
            return ((QuadItem) other).mClusterItem.equals(this.mClusterItem);
        }
    }
}
