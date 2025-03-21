package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
/* loaded from: classes.dex */
public class ScreenBasedAlgorithmAdapter<T extends ClusterItem> extends AbstractAlgorithm<T> implements ScreenBasedAlgorithm<T> {
    private Algorithm<T> mAlgorithm;

    public ScreenBasedAlgorithmAdapter(Algorithm<T> algorithm) {
        this.mAlgorithm = algorithm;
    }

    @Override // com.google.maps.android.clustering.algo.ScreenBasedAlgorithm
    public boolean shouldReclusterOnMapMovement() {
        return false;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T item) {
        return this.mAlgorithm.addItem(item);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> items) {
        return this.mAlgorithm.addItems(items);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.mAlgorithm.clearItems();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T item) {
        return this.mAlgorithm.removeItem(item);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> items) {
        return this.mAlgorithm.removeItems(items);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T item) {
        return this.mAlgorithm.updateItem(item);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float zoom) {
        return this.mAlgorithm.getClusters(zoom);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.mAlgorithm.getItems();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int maxDistance) {
        this.mAlgorithm.setMaxDistanceBetweenClusteredItems(maxDistance);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mAlgorithm.getMaxDistanceBetweenClusteredItems();
    }

    @Override // com.google.maps.android.clustering.algo.ScreenBasedAlgorithm
    public void onCameraChange(CameraPosition cameraPosition) {
    }
}
