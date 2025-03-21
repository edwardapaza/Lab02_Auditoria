package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;
/* loaded from: classes2.dex */
class PolylineBuilder implements PolylineOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final PolylineOptions polylineOptions = new PolylineOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylineBuilder(float density) {
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylineOptions build() {
        return this.polylineOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setColor(int color) {
        this.polylineOptions.color(color);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setEndCap(Cap endCap) {
        this.polylineOptions.endCap(endCap);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setJointType(int jointType) {
        this.polylineOptions.jointType(jointType);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setPattern(List<PatternItem> pattern) {
        this.polylineOptions.pattern(pattern);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setPoints(List<LatLng> points) {
        this.polylineOptions.addAll(points);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
        this.polylineOptions.clickable(consumeTapEvents);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setGeodesic(boolean geodisc) {
        this.polylineOptions.geodesic(geodisc);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setStartCap(Cap startCap) {
        this.polylineOptions.startCap(startCap);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setVisible(boolean visible) {
        this.polylineOptions.visible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setWidth(float width) {
        this.polylineOptions.width(this.density * width);
    }

    @Override // io.flutter.plugins.googlemaps.PolylineOptionsSink
    public void setZIndex(float zIndex) {
        this.polylineOptions.zIndex(zIndex);
    }
}
