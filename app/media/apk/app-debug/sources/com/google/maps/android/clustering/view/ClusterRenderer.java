package com.google.maps.android.clustering.view;

import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import java.util.Set;
/* loaded from: classes.dex */
public interface ClusterRenderer<T extends ClusterItem> {
    int getClusterTextAppearance(int i);

    int getColor(int i);

    void onAdd();

    void onClustersChanged(Set<? extends Cluster<T>> set);

    void onRemove();

    void setAnimation(boolean z);

    void setAnimationDuration(long j);

    void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener);

    void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener);

    void setOnClusterInfoWindowLongClickListener(ClusterManager.OnClusterInfoWindowLongClickListener<T> onClusterInfoWindowLongClickListener);

    void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener);

    void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener);

    void setOnClusterItemInfoWindowLongClickListener(ClusterManager.OnClusterItemInfoWindowLongClickListener<T> onClusterItemInfoWindowLongClickListener);
}
