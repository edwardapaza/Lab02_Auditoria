package com.baseflow.geolocator;

import android.app.Activity;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.location.BackgroundNotification;
import com.baseflow.geolocator.location.ForegroundNotificationOptions;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationClient;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.LocationOptions;
import com.baseflow.geolocator.location.PositionChangedCallback;
import io.flutter.plugin.common.EventChannel;
/* loaded from: classes2.dex */
public class GeolocatorLocationService extends Service {
    private static final String CHANNEL_ID = "geolocator_channel_01";
    private static final int ONGOING_NOTIFICATION_ID = 75415;
    private static final String TAG = "FlutterGeolocator";
    private LocationClient locationClient;
    private final String WAKELOCK_TAG = "GeolocatorLocationService:Wakelock";
    private final String WIFILOCK_TAG = "GeolocatorLocationService:WifiLock";
    private final LocalBinder binder = new LocalBinder(this);
    private boolean isForeground = false;
    private int connectedEngines = 0;
    private int listenerCount = 0;
    private Activity activity = null;
    private GeolocationManager geolocationManager = null;
    private PowerManager.WakeLock wakeLock = null;
    private WifiManager.WifiLock wifiLock = null;
    private BackgroundNotification backgroundNotification = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Creating service.");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Binding to location service.");
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "Unbinding from location service.");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(TAG, "Destroying location service.");
        stopLocationService();
        disableBackgroundMode();
        this.geolocationManager = null;
        this.backgroundNotification = null;
        Log.d(TAG, "Destroyed location service.");
        super.onDestroy();
    }

    public boolean canStopLocationService(boolean cancellationRequested) {
        return cancellationRequested ? this.listenerCount == 1 : this.connectedEngines == 0;
    }

    public void flutterEngineConnected() {
        this.connectedEngines++;
        Log.d(TAG, "Flutter engine connected. Connected engine count " + this.connectedEngines);
    }

    public void flutterEngineDisconnected() {
        this.connectedEngines--;
        Log.d(TAG, "Flutter engine disconnected. Connected engine count " + this.connectedEngines);
    }

    public void startLocationService(boolean forceLocationManager, LocationOptions locationOptions, final EventChannel.EventSink events) {
        this.listenerCount++;
        GeolocationManager geolocationManager = this.geolocationManager;
        if (geolocationManager != null) {
            LocationClient createLocationClient = geolocationManager.createLocationClient(getApplicationContext(), Boolean.TRUE.equals(Boolean.valueOf(forceLocationManager)), locationOptions);
            this.locationClient = createLocationClient;
            this.geolocationManager.startPositionUpdates(createLocationClient, this.activity, new PositionChangedCallback() { // from class: com.baseflow.geolocator.GeolocatorLocationService$$ExternalSyntheticLambda0
                @Override // com.baseflow.geolocator.location.PositionChangedCallback
                public final void onPositionChanged(Location location) {
                    EventChannel.EventSink.this.success(LocationMapper.toHashMap(location));
                }
            }, new ErrorCallback() { // from class: com.baseflow.geolocator.GeolocatorLocationService$$ExternalSyntheticLambda1
                @Override // com.baseflow.geolocator.errors.ErrorCallback
                public final void onError(ErrorCodes errorCodes) {
                    EventChannel.EventSink.this.error(errorCodes.toString(), errorCodes.toDescription(), null);
                }
            });
        }
    }

    public void stopLocationService() {
        GeolocationManager geolocationManager;
        this.listenerCount--;
        Log.d(TAG, "Stopping location service.");
        LocationClient locationClient = this.locationClient;
        if (locationClient != null && (geolocationManager = this.geolocationManager) != null) {
            geolocationManager.stopPositionUpdates(locationClient);
        }
    }

    public void enableBackgroundMode(ForegroundNotificationOptions options) {
        if (this.backgroundNotification != null) {
            Log.d(TAG, "Service already in foreground mode.");
            changeNotificationOptions(options);
        } else {
            Log.d(TAG, "Start service in foreground mode.");
            BackgroundNotification backgroundNotification = new BackgroundNotification(getApplicationContext(), CHANNEL_ID, Integer.valueOf((int) ONGOING_NOTIFICATION_ID), options);
            this.backgroundNotification = backgroundNotification;
            backgroundNotification.updateChannel(options.getNotificationChannelName());
            Notification notification = this.backgroundNotification.build();
            startForeground(ONGOING_NOTIFICATION_ID, notification);
            this.isForeground = true;
        }
        obtainWakeLocks(options);
    }

    public void disableBackgroundMode() {
        if (this.isForeground) {
            Log.d(TAG, "Stop service in foreground.");
            if (Build.VERSION.SDK_INT >= 24) {
                stopForeground(1);
            } else {
                stopForeground(true);
            }
            releaseWakeLocks();
            this.isForeground = false;
            this.backgroundNotification = null;
        }
    }

    public void changeNotificationOptions(ForegroundNotificationOptions options) {
        BackgroundNotification backgroundNotification = this.backgroundNotification;
        if (backgroundNotification != null) {
            backgroundNotification.updateOptions(options, this.isForeground);
            obtainWakeLocks(options);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setGeolocationManager(GeolocationManager geolocationManager) {
        this.geolocationManager = geolocationManager;
    }

    private void releaseWakeLocks() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakeLock.release();
            this.wakeLock = null;
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (wifiLock != null && wifiLock.isHeld()) {
            this.wifiLock.release();
            this.wifiLock = null;
        }
    }

    private void obtainWakeLocks(ForegroundNotificationOptions options) {
        WifiManager wifiManager;
        PowerManager powerManager;
        releaseWakeLocks();
        if (options.isEnableWakeLock() && (powerManager = (PowerManager) getApplicationContext().getSystemService("power")) != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "GeolocatorLocationService:Wakelock");
            this.wakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            this.wakeLock.acquire();
        }
        if (options.isEnableWifiLock() && (wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi")) != null) {
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(getWifiLockType(), "GeolocatorLocationService:WifiLock");
            this.wifiLock = createWifiLock;
            createWifiLock.setReferenceCounted(false);
            this.wifiLock.acquire();
        }
    }

    private int getWifiLockType() {
        if (Build.VERSION.SDK_INT < 29) {
            return 3;
        }
        return 4;
    }

    /* loaded from: classes2.dex */
    class LocalBinder extends Binder {
        private final GeolocatorLocationService locationService;

        LocalBinder(GeolocatorLocationService locationService) {
            this.locationService = locationService;
        }

        public GeolocatorLocationService getLocationService() {
            return this.locationService;
        }
    }
}
