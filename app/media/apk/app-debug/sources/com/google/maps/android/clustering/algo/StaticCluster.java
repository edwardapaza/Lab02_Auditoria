package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    private final LatLng mCenter;
    private final Collection<T> mItems = new LinkedHashSet();

    public StaticCluster(LatLng center) {
        this.mCenter = center;
    }

    public boolean add(T t) {
        return this.mItems.add(t);
    }

    @Override // com.google.maps.android.clustering.Cluster
    public LatLng getPosition() {
        return this.mCenter;
    }

    public boolean remove(T t) {
        return this.mItems.remove(t);
    }

    @Override // com.google.maps.android.clustering.Cluster
    public Collection<T> getItems() {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public int getSize() {
        return this.mItems.size();
    }

    public String toString() {
        return "StaticCluster{mCenter=" + this.mCenter + ", mItems.size=" + this.mItems.size() + '}';
    }

    public int hashCode() {
        return this.mCenter.hashCode() + this.mItems.hashCode();
    }

    public boolean equals(Object other) {
        return (other instanceof StaticCluster) && ((StaticCluster) other).mCenter.equals(this.mCenter) && ((StaticCluster) other).mItems.equals(this.mItems);
    }
}
