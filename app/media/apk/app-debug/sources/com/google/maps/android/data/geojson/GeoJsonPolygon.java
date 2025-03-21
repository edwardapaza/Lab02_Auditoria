package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.DataPolygon;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GeoJsonPolygon implements DataPolygon {
    private static final String GEOMETRY_TYPE = "Polygon";
    private static final int POLYGON_INNER_COORDINATE_INDEX = 1;
    private static final int POLYGON_OUTER_COORDINATE_INDEX = 0;
    private final List<? extends List<LatLng>> mCoordinates;

    public GeoJsonPolygon(List<? extends List<LatLng>> coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.mCoordinates = coordinates;
    }

    public String getType() {
        return "Polygon";
    }

    public List<? extends List<LatLng>> getCoordinates() {
        return this.mCoordinates;
    }

    @Override // com.google.maps.android.data.Geometry
    public List<? extends List<LatLng>> getGeometryObject() {
        return getCoordinates();
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return getType();
    }

    @Override // com.google.maps.android.data.DataPolygon
    public ArrayList<LatLng> getOuterBoundaryCoordinates() {
        return (ArrayList) getCoordinates().get(0);
    }

    @Override // com.google.maps.android.data.DataPolygon
    public ArrayList<ArrayList<LatLng>> getInnerBoundaryCoordinates() {
        ArrayList<ArrayList<LatLng>> innerBoundary = new ArrayList<>();
        for (int i = 1; i < getCoordinates().size(); i++) {
            innerBoundary.add((ArrayList) getCoordinates().get(i));
        }
        return innerBoundary;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon").append("{");
        sb.append("\n coordinates=").append(this.mCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }
}
