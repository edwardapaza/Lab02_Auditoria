package com.baseflow.geolocator.location;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
/* loaded from: classes2.dex */
public class LocationAccuracyManager {
    private static LocationAccuracyManager locationAccuracyManagerInstance = null;

    private LocationAccuracyManager() {
    }

    public static synchronized LocationAccuracyManager getInstance() {
        LocationAccuracyManager locationAccuracyManager;
        synchronized (LocationAccuracyManager.class) {
            if (locationAccuracyManagerInstance == null) {
                locationAccuracyManagerInstance = new LocationAccuracyManager();
            }
            locationAccuracyManager = locationAccuracyManagerInstance;
        }
        return locationAccuracyManager;
    }

    public LocationAccuracyStatus getLocationAccuracy(Context context, ErrorCallback errorCallback) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return LocationAccuracyStatus.precise;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return LocationAccuracyStatus.reduced;
        }
        errorCallback.onError(ErrorCodes.permissionDenied);
        return null;
    }
}
