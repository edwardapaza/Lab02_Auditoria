package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GeoJsonMultiLineString extends MultiGeometry {
    public GeoJsonMultiLineString(List<GeoJsonLineString> geoJsonLineStrings) {
        super(geoJsonLineStrings);
        setGeometryType("MultiLineString");
    }

    public String getType() {
        return getGeometryType();
    }

    public List<GeoJsonLineString> getLineStrings() {
        List<Geometry> geometryList = getGeometryObject();
        ArrayList<GeoJsonLineString> geoJsonLineStrings = new ArrayList<>();
        for (Geometry geometry : geometryList) {
            GeoJsonLineString lineString = (GeoJsonLineString) geometry;
            geoJsonLineStrings.add(lineString);
        }
        return geoJsonLineStrings;
    }
}
