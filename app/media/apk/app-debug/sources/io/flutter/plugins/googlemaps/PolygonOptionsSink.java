package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
interface PolygonOptionsSink {
    void setConsumeTapEvents(boolean z);

    void setFillColor(int i);

    void setGeodesic(boolean z);

    void setHoles(List<List<LatLng>> list);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
