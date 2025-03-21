package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.LineString;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class KmlLineString extends LineString {
    private final ArrayList<Double> mAltitudes;

    public KmlLineString(ArrayList<LatLng> coordinates) {
        this(coordinates, null);
    }

    public KmlLineString(ArrayList<LatLng> coordinates, ArrayList<Double> altitudes) {
        super(coordinates);
        this.mAltitudes = altitudes;
    }

    public ArrayList<Double> getAltitudes() {
        return this.mAltitudes;
    }

    @Override // com.google.maps.android.data.LineString, com.google.maps.android.data.Geometry
    public List<LatLng> getGeometryObject() {
        List<LatLng> coordinatesList = super.getGeometryObject();
        return new ArrayList(coordinatesList);
    }
}
