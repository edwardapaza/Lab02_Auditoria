package com.google.maps.android.data.kml;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class KmlMultiGeometry extends MultiGeometry {
    public KmlMultiGeometry(ArrayList<Geometry> geometries) {
        super(geometries);
    }

    @Override // com.google.maps.android.data.MultiGeometry, com.google.maps.android.data.Geometry
    public ArrayList<Geometry> getGeometryObject() {
        List<Geometry> geometriesList = super.getGeometryObject();
        return new ArrayList<>(geometriesList);
    }

    @Override // com.google.maps.android.data.MultiGeometry
    public String toString() {
        StringBuilder sb = new StringBuilder(getGeometryType()).append("{");
        sb.append("\n geometries=").append(getGeometryObject());
        sb.append("\n}\n");
        return sb.toString();
    }
}
