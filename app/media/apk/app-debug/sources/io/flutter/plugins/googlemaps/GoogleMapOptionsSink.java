package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
interface GoogleMapOptionsSink {
    void setBuildingsEnabled(boolean z);

    void setCameraTargetBounds(LatLngBounds latLngBounds);

    void setCompassEnabled(boolean z);

    void setIndoorEnabled(boolean z);

    void setInitialCircles(Object obj);

    void setInitialClusterManagers(Object obj);

    void setInitialMarkers(Object obj);

    void setInitialPolygons(Object obj);

    void setInitialPolylines(Object obj);

    void setInitialTileOverlays(List<Map<String, ?>> list);

    void setLiteModeEnabled(boolean z);

    void setMapStyle(String str);

    void setMapToolbarEnabled(boolean z);

    void setMapType(int i);

    void setMinMaxZoomPreference(Float f, Float f2);

    void setMyLocationButtonEnabled(boolean z);

    void setMyLocationEnabled(boolean z);

    void setPadding(float f, float f2, float f3, float f4);

    void setRotateGesturesEnabled(boolean z);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setTrackCameraPosition(boolean z);

    void setTrafficEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);
}
