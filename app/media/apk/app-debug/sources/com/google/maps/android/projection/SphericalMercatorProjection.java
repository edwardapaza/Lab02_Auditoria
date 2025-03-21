package com.google.maps.android.projection;

import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public class SphericalMercatorProjection {
    final double mWorldWidth;

    public SphericalMercatorProjection(double worldWidth) {
        this.mWorldWidth = worldWidth;
    }

    public Point toPoint(LatLng latLng) {
        double x = (latLng.longitude / 360.0d) + 0.5d;
        double siny = Math.sin(Math.toRadians(latLng.latitude));
        double y = ((Math.log((siny + 1.0d) / (1.0d - siny)) * 0.5d) / (-6.283185307179586d)) + 0.5d;
        double d = this.mWorldWidth;
        return new Point(x * d, d * y);
    }

    public LatLng toLatLng(com.google.maps.android.geometry.Point point) {
        double x = (point.x / this.mWorldWidth) - 0.5d;
        double lng = 360.0d * x;
        double y = 0.5d - (point.y / this.mWorldWidth);
        double lat = 90.0d - Math.toDegrees(Math.atan(Math.exp(((-y) * 2.0d) * 3.141592653589793d)) * 2.0d);
        return new LatLng(lat, lng);
    }
}
