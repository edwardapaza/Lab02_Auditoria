package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes2.dex */
class CircleBuilder implements CircleOptionsSink {
    private final CircleOptions circleOptions = new CircleOptions();
    private boolean consumeTapEvents;
    private final float density;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleBuilder(float density) {
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleOptions build() {
        return this.circleOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setFillColor(int color) {
        this.circleOptions.fillColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setStrokeColor(int color) {
        this.circleOptions.strokeColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setCenter(LatLng center) {
        this.circleOptions.center(center);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setRadius(double radius) {
        this.circleOptions.radius(radius);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
        this.circleOptions.clickable(consumeTapEvents);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setVisible(boolean visible) {
        this.circleOptions.visible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setStrokeWidth(float strokeWidth) {
        this.circleOptions.strokeWidth(this.density * strokeWidth);
    }

    @Override // io.flutter.plugins.googlemaps.CircleOptionsSink
    public void setZIndex(float zIndex) {
        this.circleOptions.zIndex(zIndex);
    }
}
