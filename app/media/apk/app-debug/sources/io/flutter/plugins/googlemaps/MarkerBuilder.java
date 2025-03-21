package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterItem;
/* loaded from: classes2.dex */
class MarkerBuilder implements MarkerOptionsSink, ClusterItem {
    private String clusterManagerId;
    private boolean consumeTapEvents;
    private String markerId;
    private final MarkerOptions markerOptions = new MarkerOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerBuilder(String markerId, String clusterManagerId) {
        this.markerId = markerId;
        this.clusterManagerId = clusterManagerId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerOptions build() {
        return this.markerOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(MarkerOptions markerOptionsToUpdate) {
        markerOptionsToUpdate.alpha(this.markerOptions.getAlpha());
        markerOptionsToUpdate.anchor(this.markerOptions.getAnchorU(), this.markerOptions.getAnchorV());
        markerOptionsToUpdate.draggable(this.markerOptions.isDraggable());
        markerOptionsToUpdate.flat(this.markerOptions.isFlat());
        markerOptionsToUpdate.icon(this.markerOptions.getIcon());
        markerOptionsToUpdate.infoWindowAnchor(this.markerOptions.getInfoWindowAnchorU(), this.markerOptions.getInfoWindowAnchorV());
        markerOptionsToUpdate.title(this.markerOptions.getTitle());
        markerOptionsToUpdate.snippet(this.markerOptions.getSnippet());
        markerOptionsToUpdate.position(this.markerOptions.getPosition());
        markerOptionsToUpdate.rotation(this.markerOptions.getRotation());
        markerOptionsToUpdate.visible(this.markerOptions.isVisible());
        markerOptionsToUpdate.zIndex(this.markerOptions.getZIndex());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String clusterManagerId() {
        return this.clusterManagerId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String markerId() {
        return this.markerId;
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setAlpha(float alpha) {
        this.markerOptions.alpha(alpha);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setAnchor(float u, float v) {
        this.markerOptions.anchor(u, v);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setDraggable(boolean draggable) {
        this.markerOptions.draggable(draggable);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setFlat(boolean flat) {
        this.markerOptions.flat(flat);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.markerOptions.icon(bitmapDescriptor);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setInfoWindowAnchor(float u, float v) {
        this.markerOptions.infoWindowAnchor(u, v);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setInfoWindowText(String title, String snippet) {
        this.markerOptions.title(title);
        this.markerOptions.snippet(snippet);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setPosition(LatLng position) {
        this.markerOptions.position(position);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setRotation(float rotation) {
        this.markerOptions.rotation(rotation);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setVisible(boolean visible) {
        this.markerOptions.visible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setZIndex(float zIndex) {
        this.markerOptions.zIndex(zIndex);
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public LatLng getPosition() {
        return this.markerOptions.getPosition();
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public String getTitle() {
        return this.markerOptions.getTitle();
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public String getSnippet() {
        return this.markerOptions.getSnippet();
    }

    @Override // com.google.maps.android.clustering.ClusterItem
    public Float getZIndex() {
        return Float.valueOf(this.markerOptions.getZIndex());
    }
}
