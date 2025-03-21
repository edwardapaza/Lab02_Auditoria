package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import com.baseflow.geolocator.errors.ErrorCallback;
/* loaded from: classes2.dex */
public interface LocationClient {
    boolean checkLocationService(Context context);

    void getLastKnownPosition(PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback);

    void isLocationServiceEnabled(LocationServiceListener locationServiceListener);

    boolean onActivityResult(int i, int i2);

    void startPositionUpdates(Activity activity, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback);

    void stopPositionUpdates();

    /* renamed from: com.baseflow.geolocator.location.LocationClient$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$checkLocationService(LocationClient _this, Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean gps_enabled = locationManager.isProviderEnabled("gps");
            boolean network_enabled = locationManager.isProviderEnabled("network");
            return gps_enabled || network_enabled;
        }
    }
}
