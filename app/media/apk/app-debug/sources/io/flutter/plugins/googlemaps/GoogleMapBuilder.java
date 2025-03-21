package io.flutter.plugins.googlemaps;

import android.content.Context;
import android.graphics.Rect;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
class GoogleMapBuilder implements GoogleMapOptionsSink {
    private Object initialCircles;
    private Object initialClusterManagers;
    private Object initialMarkers;
    private Object initialPolygons;
    private Object initialPolylines;
    private List<Map<String, ?>> initialTileOverlays;
    private String style;
    private final GoogleMapOptions options = new GoogleMapOptions();
    private boolean trackCameraPosition = false;
    private boolean myLocationEnabled = false;
    private boolean myLocationButtonEnabled = false;
    private boolean indoorEnabled = true;
    private boolean trafficEnabled = false;
    private boolean buildingsEnabled = true;
    private Rect padding = new Rect(0, 0, 0, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapController build(int id, Context context, BinaryMessenger binaryMessenger, LifecycleProvider lifecycleProvider) {
        GoogleMapController controller = new GoogleMapController(id, context, binaryMessenger, lifecycleProvider, this.options);
        controller.init();
        controller.setMyLocationEnabled(this.myLocationEnabled);
        controller.setMyLocationButtonEnabled(this.myLocationButtonEnabled);
        controller.setIndoorEnabled(this.indoorEnabled);
        controller.setTrafficEnabled(this.trafficEnabled);
        controller.setBuildingsEnabled(this.buildingsEnabled);
        controller.setTrackCameraPosition(this.trackCameraPosition);
        controller.setInitialClusterManagers(this.initialClusterManagers);
        controller.setInitialMarkers(this.initialMarkers);
        controller.setInitialPolygons(this.initialPolygons);
        controller.setInitialPolylines(this.initialPolylines);
        controller.setInitialCircles(this.initialCircles);
        controller.setPadding(this.padding.top, this.padding.left, this.padding.bottom, this.padding.right);
        controller.setInitialTileOverlays(this.initialTileOverlays);
        controller.setMapStyle(this.style);
        return controller;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInitialCameraPosition(CameraPosition position) {
        this.options.camera(position);
    }

    public void setMapId(String mapId) {
        this.options.mapId(mapId);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setCompassEnabled(boolean compassEnabled) {
        this.options.compassEnabled(compassEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMapToolbarEnabled(boolean setMapToolbarEnabled) {
        this.options.mapToolbarEnabled(setMapToolbarEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setCameraTargetBounds(LatLngBounds bounds) {
        this.options.latLngBoundsForCameraTarget(bounds);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMapType(int mapType) {
        this.options.mapType(mapType);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMinMaxZoomPreference(Float min, Float max) {
        if (min != null) {
            this.options.minZoomPreference(min.floatValue());
        }
        if (max != null) {
            this.options.maxZoomPreference(max.floatValue());
        }
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setPadding(float top, float left, float bottom, float right) {
        this.padding = new Rect((int) left, (int) top, (int) right, (int) bottom);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setTrackCameraPosition(boolean trackCameraPosition) {
        this.trackCameraPosition = trackCameraPosition;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setRotateGesturesEnabled(boolean rotateGesturesEnabled) {
        this.options.rotateGesturesEnabled(rotateGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setScrollGesturesEnabled(boolean scrollGesturesEnabled) {
        this.options.scrollGesturesEnabled(scrollGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setTiltGesturesEnabled(boolean tiltGesturesEnabled) {
        this.options.tiltGesturesEnabled(tiltGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setZoomGesturesEnabled(boolean zoomGesturesEnabled) {
        this.options.zoomGesturesEnabled(zoomGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setLiteModeEnabled(boolean liteModeEnabled) {
        this.options.liteMode(liteModeEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setIndoorEnabled(boolean indoorEnabled) {
        this.indoorEnabled = indoorEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setTrafficEnabled(boolean trafficEnabled) {
        this.trafficEnabled = trafficEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setBuildingsEnabled(boolean buildingsEnabled) {
        this.buildingsEnabled = buildingsEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMyLocationEnabled(boolean myLocationEnabled) {
        this.myLocationEnabled = myLocationEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setZoomControlsEnabled(boolean zoomControlsEnabled) {
        this.options.zoomControlsEnabled(zoomControlsEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMyLocationButtonEnabled(boolean myLocationButtonEnabled) {
        this.myLocationButtonEnabled = myLocationButtonEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialMarkers(Object initialMarkers) {
        this.initialMarkers = initialMarkers;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialClusterManagers(Object initialClusterManagers) {
        this.initialClusterManagers = initialClusterManagers;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialPolygons(Object initialPolygons) {
        this.initialPolygons = initialPolygons;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialPolylines(Object initialPolylines) {
        this.initialPolylines = initialPolylines;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialCircles(Object initialCircles) {
        this.initialCircles = initialCircles;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialTileOverlays(List<Map<String, ?>> initialTileOverlays) {
        this.initialTileOverlays = initialTileOverlays;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMapStyle(String style) {
        this.style = style;
    }
}
