package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.Point;
/* loaded from: classes.dex */
public class KmlPoint extends Point {
    private final Double mAltitude;

    public KmlPoint(LatLng coordinates) {
        this(coordinates, null);
    }

    public KmlPoint(LatLng coordinates, Double altitude) {
        super(coordinates);
        this.mAltitude = altitude;
    }

    public Double getAltitude() {
        return this.mAltitude;
    }
}
