package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class GeoJsonLineStringStyle extends Style implements GeoJsonStyle {
    private static final String[] GEOMETRY_TYPE = {"LineString", "MultiLineString", "GeometryCollection"};

    public GeoJsonLineStringStyle() {
        this.mPolylineOptions = new PolylineOptions();
        this.mPolylineOptions.clickable(true);
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public String[] getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public int getColor() {
        return this.mPolylineOptions.getColor();
    }

    public void setColor(int color) {
        this.mPolylineOptions.color(color);
        styleChanged();
    }

    public boolean isClickable() {
        return this.mPolylineOptions.isClickable();
    }

    public void setClickable(boolean clickable) {
        this.mPolylineOptions.clickable(clickable);
        styleChanged();
    }

    public boolean isGeodesic() {
        return this.mPolylineOptions.isGeodesic();
    }

    public void setGeodesic(boolean geodesic) {
        this.mPolylineOptions.geodesic(geodesic);
        styleChanged();
    }

    public float getWidth() {
        return this.mPolylineOptions.getWidth();
    }

    public void setWidth(float width) {
        setLineStringWidth(width);
        styleChanged();
    }

    public float getZIndex() {
        return this.mPolylineOptions.getZIndex();
    }

    public void setZIndex(float zIndex) {
        this.mPolylineOptions.zIndex(zIndex);
        styleChanged();
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public boolean isVisible() {
        return this.mPolylineOptions.isVisible();
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public void setVisible(boolean visible) {
        this.mPolylineOptions.visible(visible);
        styleChanged();
    }

    private void styleChanged() {
        setChanged();
        notifyObservers();
    }

    public PolylineOptions toPolylineOptions() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(this.mPolylineOptions.getColor());
        polylineOptions.clickable(this.mPolylineOptions.isClickable());
        polylineOptions.geodesic(this.mPolylineOptions.isGeodesic());
        polylineOptions.visible(this.mPolylineOptions.isVisible());
        polylineOptions.width(this.mPolylineOptions.getWidth());
        polylineOptions.zIndex(this.mPolylineOptions.getZIndex());
        polylineOptions.pattern(getPattern());
        return polylineOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LineStringStyle{");
        sb.append("\n geometry type=").append(Arrays.toString(GEOMETRY_TYPE));
        sb.append(",\n color=").append(getColor());
        sb.append(",\n clickable=").append(isClickable());
        sb.append(",\n geodesic=").append(isGeodesic());
        sb.append(",\n visible=").append(isVisible());
        sb.append(",\n width=").append(getWidth());
        sb.append(",\n z index=").append(getZIndex());
        sb.append(",\n pattern=").append(getPattern());
        sb.append("\n}\n");
        return sb.toString();
    }

    public List<PatternItem> getPattern() {
        return this.mPolylineOptions.getPattern();
    }

    public void setPattern(List<PatternItem> pattern) {
        this.mPolylineOptions.pattern(pattern);
        styleChanged();
    }
}
