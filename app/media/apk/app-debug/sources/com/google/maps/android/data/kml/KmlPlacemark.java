package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import java.util.Map;
/* loaded from: classes.dex */
public class KmlPlacemark extends Feature {
    private final KmlStyle mInlineStyle;
    private final String mStyle;

    public KmlPlacemark(Geometry geometry, String style, KmlStyle inlineStyle, Map<String, String> properties) {
        super(geometry, style, properties);
        this.mStyle = style;
        this.mInlineStyle = inlineStyle;
    }

    public String getStyleId() {
        return super.getId();
    }

    public KmlStyle getInlineStyle() {
        return this.mInlineStyle;
    }

    public PolygonOptions getPolygonOptions() {
        KmlStyle kmlStyle = this.mInlineStyle;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.getPolygonOptions();
    }

    public MarkerOptions getMarkerOptions() {
        KmlStyle kmlStyle = this.mInlineStyle;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.getMarkerOptions();
    }

    public PolylineOptions getPolylineOptions() {
        KmlStyle kmlStyle = this.mInlineStyle;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.getPolylineOptions();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Placemark").append("{");
        sb.append("\n style id=").append(this.mStyle);
        sb.append(",\n inline style=").append(this.mInlineStyle);
        sb.append("\n}\n");
        return sb.toString();
    }
}
