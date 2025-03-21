package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.DataPolygon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public class KmlPolygon implements DataPolygon<ArrayList<ArrayList<LatLng>>> {
    public static final String GEOMETRY_TYPE = "Polygon";
    private final List<List<LatLng>> mInnerBoundaryCoordinates;
    private final List<LatLng> mOuterBoundaryCoordinates;

    public KmlPolygon(List<LatLng> outerBoundaryCoordinates, List<List<LatLng>> innerBoundaryCoordinates) {
        if (outerBoundaryCoordinates == null) {
            throw new IllegalArgumentException("Outer boundary coordinates cannot be null");
        }
        this.mOuterBoundaryCoordinates = outerBoundaryCoordinates;
        this.mInnerBoundaryCoordinates = innerBoundaryCoordinates;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    @Override // com.google.maps.android.data.Geometry
    public List<List<LatLng>> getGeometryObject() {
        List<List<LatLng>> coordinates = new ArrayList<>();
        coordinates.add(this.mOuterBoundaryCoordinates);
        Collection<? extends List<LatLng>> collection = this.mInnerBoundaryCoordinates;
        if (collection != null) {
            coordinates.addAll(collection);
        }
        return coordinates;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public List<LatLng> getOuterBoundaryCoordinates() {
        return this.mOuterBoundaryCoordinates;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public List<List<LatLng>> getInnerBoundaryCoordinates() {
        return this.mInnerBoundaryCoordinates;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE).append("{");
        sb.append("\n outer coordinates=").append(this.mOuterBoundaryCoordinates);
        sb.append(",\n inner coordinates=").append(this.mInnerBoundaryCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }
}
