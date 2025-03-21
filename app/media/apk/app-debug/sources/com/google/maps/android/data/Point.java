package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public class Point implements Geometry {
    private static final String GEOMETRY_TYPE = "Point";
    private final LatLng mCoordinates;

    public Point(LatLng coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.mCoordinates = coordinates;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    @Override // com.google.maps.android.data.Geometry
    public LatLng getGeometryObject() {
        return this.mCoordinates;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE).append("{");
        sb.append("\n coordinates=").append(this.mCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }
}
