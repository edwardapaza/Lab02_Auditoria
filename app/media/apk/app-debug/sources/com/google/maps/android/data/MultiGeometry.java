package com.google.maps.android.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MultiGeometry implements Geometry {
    private String geometryType = "MultiGeometry";
    private List<Geometry> mGeometries;

    public MultiGeometry(List<? extends Geometry> geometries) {
        if (geometries == null) {
            throw new IllegalArgumentException("Geometries cannot be null");
        }
        ArrayList geometriesList = new ArrayList();
        for (Geometry geometry : geometries) {
            geometriesList.add(geometry);
        }
        this.mGeometries = geometriesList;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return this.geometryType;
    }

    @Override // com.google.maps.android.data.Geometry
    public List<Geometry> getGeometryObject() {
        return this.mGeometries;
    }

    public void setGeometryType(String type) {
        this.geometryType = type;
    }

    public String toString() {
        String typeString = "Geometries=";
        if (this.geometryType.equals("MultiPoint")) {
            typeString = "LineStrings=";
        }
        if (this.geometryType.equals("MultiLineString")) {
            typeString = "points=";
        }
        if (this.geometryType.equals("MultiPolygon")) {
            typeString = "Polygons=";
        }
        StringBuilder sb = new StringBuilder(getGeometryType()).append("{");
        sb.append("\n " + typeString).append(getGeometryObject());
        sb.append("\n}\n");
        return sb.toString();
    }
}
