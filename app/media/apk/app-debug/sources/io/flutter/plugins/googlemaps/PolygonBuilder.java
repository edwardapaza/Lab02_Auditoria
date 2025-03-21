package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.List;
/* loaded from: classes2.dex */
class PolygonBuilder implements PolygonOptionsSink {
    private boolean consumeTapEvents;
    private final float density;
    private final PolygonOptions polygonOptions = new PolygonOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonBuilder(float density) {
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonOptions build() {
        return this.polygonOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setFillColor(int color) {
        this.polygonOptions.fillColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setStrokeColor(int color) {
        this.polygonOptions.strokeColor(color);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setPoints(List<LatLng> points) {
        this.polygonOptions.addAll(points);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setHoles(List<List<LatLng>> holes) {
        for (List<LatLng> hole : holes) {
            this.polygonOptions.addHole(hole);
        }
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        this.consumeTapEvents = consumeTapEvents;
        this.polygonOptions.clickable(consumeTapEvents);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setGeodesic(boolean geodisc) {
        this.polygonOptions.geodesic(geodisc);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setVisible(boolean visible) {
        this.polygonOptions.visible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setStrokeWidth(float width) {
        this.polygonOptions.strokeWidth(this.density * width);
    }

    @Override // io.flutter.plugins.googlemaps.PolygonOptionsSink
    public void setZIndex(float zIndex) {
        this.polygonOptions.zIndex(zIndex);
    }
}
