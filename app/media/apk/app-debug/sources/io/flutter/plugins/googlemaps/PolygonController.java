package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import java.util.List;
/* loaded from: classes2.dex */
class PolygonController implements PolygonOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsPolygonId;
    private final Polygon polygon;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonController(Polygon polygon, boolean consumeTapEvents, float density) {
        this.polygon = polygon;
        this.density = density;
        this.consumeTapEvents = consumeTapEvents;
        this.googleMapsPolygonId = polygon.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        this.polygon.remove();
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
        this.polygon.setClickable(consumeTapEvents);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setFillColor(int color) {
        this.polygon.setFillColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setStrokeColor(int color) {
        this.polygon.setStrokeColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setGeodesic(boolean geodesic) {
        this.polygon.setGeodesic(geodesic);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setPoints(List<LatLng> points) {
        this.polygon.setPoints(points);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setHoles(List<List<LatLng>> holes) {
        this.polygon.setHoles(holes);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setVisible(boolean visible) {
        this.polygon.setVisible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setStrokeWidth(float width) {
        this.polygon.setStrokeWidth(this.density * width);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setZIndex(float zIndex) {
        this.polygon.setZIndex(zIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getGoogleMapsPolygonId() {
        return this.googleMapsPolygonId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }
}
