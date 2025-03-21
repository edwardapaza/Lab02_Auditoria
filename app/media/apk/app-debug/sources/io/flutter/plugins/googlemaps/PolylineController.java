package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import java.util.List;
/* loaded from: classes2.dex */
class PolylineController implements PolylineOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsPolylineId;
    private final Polyline polyline;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylineController(Polyline polyline, boolean consumeTapEvents, float density) {
        this.polyline = polyline;
        this.consumeTapEvents = consumeTapEvents;
        this.density = density;
        this.googleMapsPolylineId = polyline.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        this.polyline.remove();
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
        this.polyline.setClickable(consumeTapEvents);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setColor(int color) {
        this.polyline.setColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setEndCap(Cap endCap) {
        this.polyline.setEndCap(endCap);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setGeodesic(boolean geodesic) {
        this.polyline.setGeodesic(geodesic);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setJointType(int jointType) {
        this.polyline.setJointType(jointType);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setPattern(List<PatternItem> pattern) {
        this.polyline.setPattern(pattern);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setPoints(List<LatLng> points) {
        this.polyline.setPoints(points);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setStartCap(Cap startCap) {
        this.polyline.setStartCap(startCap);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setVisible(boolean visible) {
        this.polyline.setVisible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setWidth(float width) {
        this.polyline.setWidth(this.density * width);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setZIndex(float zIndex) {
        this.polyline.setZIndex(zIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getGoogleMapsPolylineId() {
        return this.googleMapsPolylineId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }
}
