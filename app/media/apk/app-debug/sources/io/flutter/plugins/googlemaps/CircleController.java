package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes2.dex */
class CircleController implements CircleOptionsSink {
    private final Circle circle;
    private boolean consumeTapEvents;
    private final float density;
    private final String googleMapsCircleId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleController(Circle circle, boolean consumeTapEvents, float density) {
        this.circle = circle;
        this.consumeTapEvents = consumeTapEvents;
        this.density = density;
        this.googleMapsCircleId = circle.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        this.circle.remove();
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
        this.circle.setClickable(consumeTapEvents);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setStrokeColor(int strokeColor) {
        this.circle.setStrokeColor(strokeColor);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setFillColor(int fillColor) {
        this.circle.setFillColor(fillColor);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setCenter(LatLng center) {
        this.circle.setCenter(center);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setRadius(double radius) {
        this.circle.setRadius(radius);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setVisible(boolean visible) {
        this.circle.setVisible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setStrokeWidth(float strokeWidth) {
        this.circle.setStrokeWidth(this.density * strokeWidth);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setZIndex(float zIndex) {
        this.circle.setZIndex(zIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getGoogleMapsCircleId() {
        return this.googleMapsCircleId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }
}
