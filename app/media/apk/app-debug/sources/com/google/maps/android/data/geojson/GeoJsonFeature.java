package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class GeoJsonFeature extends Feature implements Observer {
    private final LatLngBounds mBoundingBox;
    private GeoJsonLineStringStyle mLineStringStyle;
    private GeoJsonPointStyle mPointStyle;
    private GeoJsonPolygonStyle mPolygonStyle;

    public GeoJsonFeature(Geometry geometry, String id, HashMap<String, String> properties, LatLngBounds boundingBox) {
        super(geometry, id, properties);
        this.mId = id;
        this.mBoundingBox = boundingBox;
    }

    @Override // com.google.maps.android.data.Feature
    public String setProperty(String property, String propertyValue) {
        return super.setProperty(property, propertyValue);
    }

    @Override // com.google.maps.android.data.Feature
    public String removeProperty(String property) {
        return super.removeProperty(property);
    }

    public GeoJsonPointStyle getPointStyle() {
        return this.mPointStyle;
    }

    public void setPointStyle(GeoJsonPointStyle pointStyle) {
        if (pointStyle == null) {
            throw new IllegalArgumentException("Point style cannot be null");
        }
        GeoJsonPointStyle geoJsonPointStyle = this.mPointStyle;
        if (geoJsonPointStyle != null) {
            geoJsonPointStyle.deleteObserver(this);
        }
        this.mPointStyle = pointStyle;
        pointStyle.addObserver(this);
        checkRedrawFeature(this.mPointStyle);
    }

    public GeoJsonLineStringStyle getLineStringStyle() {
        return this.mLineStringStyle;
    }

    public void setLineStringStyle(GeoJsonLineStringStyle lineStringStyle) {
        if (lineStringStyle == null) {
            throw new IllegalArgumentException("Line string style cannot be null");
        }
        GeoJsonLineStringStyle geoJsonLineStringStyle = this.mLineStringStyle;
        if (geoJsonLineStringStyle != null) {
            geoJsonLineStringStyle.deleteObserver(this);
        }
        this.mLineStringStyle = lineStringStyle;
        lineStringStyle.addObserver(this);
        checkRedrawFeature(this.mLineStringStyle);
    }

    public GeoJsonPolygonStyle getPolygonStyle() {
        return this.mPolygonStyle;
    }

    public void setPolygonStyle(GeoJsonPolygonStyle polygonStyle) {
        if (polygonStyle == null) {
            throw new IllegalArgumentException("Polygon style cannot be null");
        }
        GeoJsonPolygonStyle geoJsonPolygonStyle = this.mPolygonStyle;
        if (geoJsonPolygonStyle != null) {
            geoJsonPolygonStyle.deleteObserver(this);
        }
        this.mPolygonStyle = polygonStyle;
        polygonStyle.addObserver(this);
        checkRedrawFeature(this.mPolygonStyle);
    }

    public PolygonOptions getPolygonOptions() {
        return this.mPolygonStyle.toPolygonOptions();
    }

    public MarkerOptions getMarkerOptions() {
        return this.mPointStyle.toMarkerOptions();
    }

    public PolylineOptions getPolylineOptions() {
        return this.mLineStringStyle.toPolylineOptions();
    }

    private void checkRedrawFeature(GeoJsonStyle style) {
        if (hasGeometry() && Arrays.asList(style.getGeometryType()).contains(getGeometry().getGeometryType())) {
            setChanged();
            notifyObservers();
        }
    }

    @Override // com.google.maps.android.data.Feature
    public void setGeometry(Geometry geometry) {
        super.setGeometry(geometry);
        setChanged();
        notifyObservers();
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Feature{");
        sb.append("\n bounding box=").append(this.mBoundingBox);
        sb.append(",\n geometry=").append(getGeometry());
        sb.append(",\n point style=").append(this.mPointStyle);
        sb.append(",\n line string style=").append(this.mLineStringStyle);
        sb.append(",\n polygon style=").append(this.mPolygonStyle);
        sb.append(",\n id=").append(this.mId);
        sb.append(",\n properties=").append(getProperties());
        sb.append("\n}\n");
        return sb.toString();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object data) {
        if (observable instanceof GeoJsonStyle) {
            checkRedrawFeature((GeoJsonStyle) observable);
        }
    }
}
