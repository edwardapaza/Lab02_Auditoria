package com.baseflow.geolocator.location;

import android.location.Location;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class LocationMapper {
    public static Map<String, Object> toHashMap(Location location) {
        if (location == null) {
            return null;
        }
        Map<String, Object> position = new HashMap<>();
        position.put("latitude", Double.valueOf(location.getLatitude()));
        position.put("longitude", Double.valueOf(location.getLongitude()));
        position.put("timestamp", Long.valueOf(location.getTime()));
        position.put("is_mocked", Boolean.valueOf(isMocked(location)));
        if (location.hasAltitude()) {
            position.put("altitude", Double.valueOf(location.getAltitude()));
        }
        if (Build.VERSION.SDK_INT >= 26 && location.hasVerticalAccuracy()) {
            position.put("altitude_accuracy", Float.valueOf(location.getVerticalAccuracyMeters()));
        }
        if (location.hasAccuracy()) {
            position.put("accuracy", Double.valueOf(location.getAccuracy()));
        }
        if (location.hasBearing()) {
            position.put("heading", Double.valueOf(location.getBearing()));
        }
        if (Build.VERSION.SDK_INT >= 26 && location.hasBearingAccuracy()) {
            position.put("heading_accuracy", Float.valueOf(location.getBearingAccuracyDegrees()));
        }
        if (location.hasSpeed()) {
            position.put("speed", Double.valueOf(location.getSpeed()));
        }
        if (Build.VERSION.SDK_INT >= 26 && location.hasSpeedAccuracy()) {
            position.put("speed_accuracy", Double.valueOf(location.getSpeedAccuracyMetersPerSecond()));
        }
        if (location.getExtras() != null) {
            if (location.getExtras().containsKey(NmeaClient.NMEA_ALTITUDE_EXTRA)) {
                Double mslAltitude = Double.valueOf(location.getExtras().getDouble(NmeaClient.NMEA_ALTITUDE_EXTRA));
                position.put("altitude", mslAltitude);
            }
            if (location.getExtras().containsKey(NmeaClient.GNSS_SATELLITE_COUNT_EXTRA)) {
                Double mslSatelliteCount = Double.valueOf(location.getExtras().getDouble(NmeaClient.GNSS_SATELLITE_COUNT_EXTRA));
                position.put("gnss_satellite_count", mslSatelliteCount);
            }
            if (location.getExtras().containsKey(NmeaClient.GNSS_SATELLITES_USED_IN_FIX_EXTRA)) {
                Double mslSatellitesUsedInFix = Double.valueOf(location.getExtras().getDouble(NmeaClient.GNSS_SATELLITES_USED_IN_FIX_EXTRA));
                position.put("gnss_satellites_used_in_fix", mslSatellitesUsedInFix);
            }
            if (Build.VERSION.SDK_INT >= 34 && location.hasMslAltitude()) {
                double mslAltitude2 = location.getMslAltitudeMeters();
                position.put("altitude", Double.valueOf(mslAltitude2));
                if (location.hasMslAltitudeAccuracy()) {
                    float mslAccuracy = location.getMslAltitudeAccuracyMeters();
                    position.put("altitude_accuracy", Float.valueOf(mslAccuracy));
                }
            }
        }
        return position;
    }

    private static boolean isMocked(Location location) {
        if (Build.VERSION.SDK_INT >= 31) {
            return location.isMock();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return location.isFromMockProvider();
        }
        return false;
    }
}
