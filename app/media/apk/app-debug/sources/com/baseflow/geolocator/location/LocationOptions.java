package com.baseflow.geolocator.location;

import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Map;
/* loaded from: classes2.dex */
public class LocationOptions {
    public static final String USE_MSL_ALTITUDE_EXTRA = "geolocator_use_mslAltitude";
    private final LocationAccuracy accuracy;
    private final long distanceFilter;
    private final long timeInterval;
    private final boolean useMSLAltitude;

    private LocationOptions(LocationAccuracy accuracy, long distanceFilter, long timeInterval, boolean useMSLAltitude) {
        this.accuracy = accuracy;
        this.distanceFilter = distanceFilter;
        this.timeInterval = timeInterval;
        this.useMSLAltitude = useMSLAltitude;
    }

    public static LocationOptions parseArguments(Map<String, Object> arguments) {
        if (arguments == null) {
            return new LocationOptions(LocationAccuracy.best, 0L, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, false);
        }
        Integer accuracy = (Integer) arguments.get("accuracy");
        Integer distanceFilter = (Integer) arguments.get("distanceFilter");
        Integer timeInterval = (Integer) arguments.get("timeInterval");
        Boolean useMSLAltitude = (Boolean) arguments.get("useMSLAltitude");
        LocationAccuracy locationAccuracy = LocationAccuracy.best;
        if (accuracy != null) {
            switch (accuracy.intValue()) {
                case 0:
                    locationAccuracy = LocationAccuracy.lowest;
                    break;
                case 1:
                    locationAccuracy = LocationAccuracy.low;
                    break;
                case 2:
                    locationAccuracy = LocationAccuracy.medium;
                    break;
                case 3:
                    locationAccuracy = LocationAccuracy.high;
                    break;
                case 5:
                    locationAccuracy = LocationAccuracy.bestForNavigation;
                    break;
            }
        }
        return new LocationOptions(locationAccuracy, distanceFilter != null ? distanceFilter.intValue() : 0L, timeInterval != null ? timeInterval.intValue() : DeviceOrientationRequest.OUTPUT_PERIOD_FAST, useMSLAltitude != null && useMSLAltitude.booleanValue());
    }

    public LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    public long getDistanceFilter() {
        return this.distanceFilter;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }

    public boolean isUseMSLAltitude() {
        return this.useMSLAltitude;
    }
}
