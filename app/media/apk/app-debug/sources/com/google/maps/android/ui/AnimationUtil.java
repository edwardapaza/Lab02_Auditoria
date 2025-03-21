package com.google.maps.android.ui;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
/* loaded from: classes.dex */
public class AnimationUtil {
    public static void animateMarkerTo(final Marker marker, final LatLng finalPosition) {
        final LatLngInterpolator latLngInterpolator = new LatLngInterpolator.Linear();
        final LatLng startPosition = marker.getPosition();
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final Interpolator interpolator = new AccelerateDecelerateInterpolator();
        handler.post(new Runnable() { // from class: com.google.maps.android.ui.AnimationUtil.1
            long elapsed;
            float t;
            float v;

            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis() - start;
                this.elapsed = uptimeMillis;
                float f = ((float) uptimeMillis) / 2000.0f;
                this.t = f;
                float interpolation = interpolator.getInterpolation(f);
                this.v = interpolation;
                marker.setPosition(latLngInterpolator.interpolate(interpolation, startPosition, finalPosition));
                if (this.t < 1.0f) {
                    handler.postDelayed(this, 16L);
                }
            }
        });
    }

    /* loaded from: classes.dex */
    interface LatLngInterpolator {
        LatLng interpolate(float f, LatLng latLng, LatLng latLng2);

        /* loaded from: classes.dex */
        public static class Linear implements LatLngInterpolator {
            @Override // com.google.maps.android.ui.AnimationUtil.LatLngInterpolator
            public LatLng interpolate(float fraction, LatLng a, LatLng b) {
                double lat = ((b.latitude - a.latitude) * fraction) + a.latitude;
                double lngDelta = b.longitude - a.longitude;
                if (Math.abs(lngDelta) > 180.0d) {
                    lngDelta -= Math.signum(lngDelta) * 360.0d;
                }
                double lng = (fraction * lngDelta) + a.longitude;
                return new LatLng(lat, lng);
            }
        }
    }
}
