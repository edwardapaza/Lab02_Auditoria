package com.baseflow.geolocator.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class NmeaClient {
    public static final String GNSS_SATELLITES_USED_IN_FIX_EXTRA = "geolocator_mslSatellitesUsedInFix";
    public static final String GNSS_SATELLITE_COUNT_EXTRA = "geolocator_mslSatelliteCount";
    public static final String NMEA_ALTITUDE_EXTRA = "geolocator_mslAltitude";
    private final Context context;
    private GnssStatus.Callback gnssCallback;
    private double gnss_satellite_count;
    private double gnss_satellites_used_in_fix;
    private String lastNmeaMessage;
    private Calendar lastNmeaMessageTime;
    private boolean listenerAdded = false;
    private final LocationManager locationManager;
    private final LocationOptions locationOptions;
    private OnNmeaMessageListener nmeaMessageListener;

    static /* synthetic */ double access$104(NmeaClient x0) {
        double d = x0.gnss_satellites_used_in_fix + 1.0d;
        x0.gnss_satellites_used_in_fix = d;
        return d;
    }

    public NmeaClient(Context context, LocationOptions locationOptions) {
        this.context = context;
        this.locationOptions = locationOptions;
        this.locationManager = (LocationManager) context.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 24) {
            this.nmeaMessageListener = new OnNmeaMessageListener() { // from class: com.baseflow.geolocator.location.NmeaClient$$ExternalSyntheticLambda0
                @Override // android.location.OnNmeaMessageListener
                public final void onNmeaMessage(String str, long j) {
                    NmeaClient.this.m56lambda$new$0$combaseflowgeolocatorlocationNmeaClient(str, j);
                }
            };
            this.gnssCallback = new GnssStatus.Callback() { // from class: com.baseflow.geolocator.location.NmeaClient.1
                @Override // android.location.GnssStatus.Callback
                public void onSatelliteStatusChanged(GnssStatus status) {
                    NmeaClient.this.gnss_satellite_count = status.getSatelliteCount();
                    NmeaClient.this.gnss_satellites_used_in_fix = 0.0d;
                    for (int i = 0; i < NmeaClient.this.gnss_satellite_count; i++) {
                        if (status.usedInFix(i)) {
                            NmeaClient.access$104(NmeaClient.this);
                        }
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-baseflow-geolocator-location-NmeaClient  reason: not valid java name */
    public /* synthetic */ void m56lambda$new$0$combaseflowgeolocatorlocationNmeaClient(String message, long timestamp) {
        if (message.trim().matches("^\\$..GGA.*$")) {
            this.lastNmeaMessage = message;
            this.lastNmeaMessageTime = Calendar.getInstance();
        }
    }

    public void start() {
        LocationManager locationManager;
        if (!this.listenerAdded && this.locationOptions != null && Build.VERSION.SDK_INT >= 24 && (locationManager = this.locationManager) != null) {
            locationManager.addNmeaListener(this.nmeaMessageListener, (Handler) null);
            this.locationManager.registerGnssStatusCallback(this.gnssCallback, (Handler) null);
            this.listenerAdded = true;
        }
    }

    public void stop() {
        LocationManager locationManager;
        if (this.locationOptions != null && Build.VERSION.SDK_INT >= 24 && (locationManager = this.locationManager) != null) {
            locationManager.removeNmeaListener(this.nmeaMessageListener);
            this.locationManager.unregisterGnssStatusCallback(this.gnssCallback);
            this.listenerAdded = false;
        }
    }

    public void enrichExtrasWithNmea(Location location) {
        if (location == null) {
            return;
        }
        if (location.getExtras() == null) {
            location.setExtras(Bundle.EMPTY);
        }
        location.getExtras().putDouble(GNSS_SATELLITE_COUNT_EXTRA, this.gnss_satellite_count);
        location.getExtras().putDouble(GNSS_SATELLITES_USED_IN_FIX_EXTRA, this.gnss_satellites_used_in_fix);
        if (this.lastNmeaMessage != null && this.locationOptions != null && this.listenerAdded) {
            Calendar expiryDate = Calendar.getInstance();
            expiryDate.add(13, -5);
            Calendar calendar = this.lastNmeaMessageTime;
            if ((calendar == null || !calendar.before(expiryDate)) && this.locationOptions.isUseMSLAltitude()) {
                String[] tokens = this.lastNmeaMessage.split(",");
                String str = tokens[0];
                if (this.lastNmeaMessage.trim().matches("^\\$..GGA.*$") && tokens.length > 9 && !tokens[9].isEmpty()) {
                    double mslAltitude = Double.parseDouble(tokens[9]);
                    if (location.getExtras() == null) {
                        location.setExtras(Bundle.EMPTY);
                    }
                    location.getExtras().putDouble(NMEA_ALTITUDE_EXTRA, mslAltitude);
                }
            }
        }
    }
}
