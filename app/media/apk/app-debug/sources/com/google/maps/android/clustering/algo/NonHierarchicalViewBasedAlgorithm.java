package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public class NonHierarchicalViewBasedAlgorithm<T extends ClusterItem> extends NonHierarchicalDistanceBasedAlgorithm<T> implements ScreenBasedAlgorithm<T> {
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private LatLng mMapCenter;
    private int mViewHeight;
    private int mViewWidth;

    public NonHierarchicalViewBasedAlgorithm(int screenWidth, int screenHeight) {
        this.mViewWidth = screenWidth;
        this.mViewHeight = screenHeight;
    }

    @Override // com.google.maps.android.clustering.algo.ScreenBasedAlgorithm
    public void onCameraChange(CameraPosition cameraPosition) {
        this.mMapCenter = cameraPosition.target;
    }

    @Override // com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm
    protected Collection<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> getClusteringItems(PointQuadTree<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> quadTree, float zoom) {
        Bounds visibleBounds = getVisibleBounds(zoom);
        Collection<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> items = new ArrayList<>();
        if (visibleBounds.minX < 0.0d) {
            Bounds wrappedBounds = new Bounds(visibleBounds.minX + 1.0d, 1.0d, visibleBounds.minY, visibleBounds.maxY);
            items.addAll(quadTree.search(wrappedBounds));
            visibleBounds = new Bounds(0.0d, visibleBounds.maxX, visibleBounds.minY, visibleBounds.maxY);
        }
        if (visibleBounds.maxX > 1.0d) {
            Bounds wrappedBounds2 = new Bounds(0.0d, visibleBounds.maxX - 1.0d, visibleBounds.minY, visibleBounds.maxY);
            items.addAll(quadTree.search(wrappedBounds2));
            visibleBounds = new Bounds(visibleBounds.minX, 1.0d, visibleBounds.minY, visibleBounds.maxY);
        }
        items.addAll(quadTree.search(visibleBounds));
        return items;
    }

    @Override // com.google.maps.android.clustering.algo.ScreenBasedAlgorithm
    public boolean shouldReclusterOnMapMovement() {
        return true;
    }

    public void updateViewSize(int width, int height) {
        this.mViewWidth = width;
        this.mViewHeight = height;
    }

    private Bounds getVisibleBounds(float zoom) {
        LatLng latLng = this.mMapCenter;
        if (latLng == null) {
            return new Bounds(0.0d, 0.0d, 0.0d, 0.0d);
        }
        Point p = PROJECTION.toPoint(latLng);
        double halfWidthSpan = ((this.mViewWidth / Math.pow(2.0d, zoom)) / 256.0d) / 2.0d;
        double halfHeightSpan = ((this.mViewHeight / Math.pow(2.0d, zoom)) / 256.0d) / 2.0d;
        return new Bounds(p.x - halfWidthSpan, p.x + halfWidthSpan, p.y - halfHeightSpan, p.y + halfHeightSpan);
    }
}
