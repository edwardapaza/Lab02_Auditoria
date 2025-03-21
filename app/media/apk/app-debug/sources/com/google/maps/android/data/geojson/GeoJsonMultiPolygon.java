package com.google.maps.android.data.geojson;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GeoJsonMultiPolygon extends MultiGeometry {
    public GeoJsonMultiPolygon(List<GeoJsonPolygon> geoJsonPolygons) {
        super(geoJsonPolygons);
        setGeometryType("MultiPolygon");
    }

    public String getType() {
        return getGeometryType();
    }

    public List<GeoJsonPolygon> getPolygons() {
        List<Geometry> geometryList = getGeometryObject();
        ArrayList<GeoJsonPolygon> geoJsonPolygon = new ArrayList<>();
        for (Geometry geometry : geometryList) {
            GeoJsonPolygon polygon = (GeoJsonPolygon) geometry;
            geoJsonPolygon.add(polygon);
        }
        return geoJsonPolygon;
    }
}
