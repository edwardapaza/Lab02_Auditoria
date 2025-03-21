package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import com.baseflow.geolocator.location.ForegroundNotificationOptions;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationClient;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.LocationOptions;
import com.baseflow.geolocator.location.PositionChangedCallback;
import com.baseflow.geolocator.permission.PermissionManager;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;
/* loaded from: classes2.dex */
class StreamHandlerImpl implements EventChannel.StreamHandler {
    private static final String TAG = "FlutterGeolocator";
    private Activity activity;
    private EventChannel channel;
    private Context context;
    private GeolocatorLocationService foregroundLocationService;
    private GeolocationManager geolocationManager;
    private LocationClient locationClient;
    private final PermissionManager permissionManager;

    public StreamHandlerImpl(PermissionManager permissionManager, GeolocationManager geolocationManager) {
        this.permissionManager = permissionManager;
        this.geolocationManager = geolocationManager;
    }

    public void setForegroundLocationService(GeolocatorLocationService foregroundLocationService) {
        this.foregroundLocationService = foregroundLocationService;
    }

    public void setActivity(Activity activity) {
        if (activity == null && this.locationClient != null && this.channel != null) {
            stopListening();
        }
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(Context context, BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a event call handler before the last was disposed.");
            stopListening();
        }
        EventChannel eventChannel = new EventChannel(messenger, "flutter.baseflow.com/geolocator_updates_android");
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        if (this.channel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        disposeListeners(false);
        this.channel.setStreamHandler(null);
        this.channel = null;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object arguments, final EventChannel.EventSink events) {
        try {
            if (!this.permissionManager.hasPermission(this.context)) {
                events.error(ErrorCodes.permissionDenied.toString(), ErrorCodes.permissionDenied.toDescription(), null);
            } else if (this.foregroundLocationService == null) {
                Log.e(TAG, "Location background service has not started correctly");
            } else {
                Map<String, Object> map = (Map) arguments;
                boolean forceLocationManager = false;
                if (map != null && map.get("forceLocationManager") != null) {
                    forceLocationManager = ((Boolean) map.get("forceLocationManager")).booleanValue();
                }
                LocationOptions locationOptions = LocationOptions.parseArguments(map);
                ForegroundNotificationOptions foregroundNotificationOptions = null;
                if (map != null) {
                    foregroundNotificationOptions = ForegroundNotificationOptions.parseArguments((Map) map.get("foregroundNotificationConfig"));
                }
                if (foregroundNotificationOptions != null) {
                    Log.e(TAG, "Geolocator position updates started using Android foreground service");
                    this.foregroundLocationService.startLocationService(forceLocationManager, locationOptions, events);
                    this.foregroundLocationService.enableBackgroundMode(foregroundNotificationOptions);
                    return;
                }
                Log.e(TAG, "Geolocator position updates started");
                LocationClient createLocationClient = this.geolocationManager.createLocationClient(this.context, Boolean.TRUE.equals(Boolean.valueOf(forceLocationManager)), locationOptions);
                this.locationClient = createLocationClient;
                this.geolocationManager.startPositionUpdates(createLocationClient, this.activity, new PositionChangedCallback() { // from class: com.baseflow.geolocator.StreamHandlerImpl$$ExternalSyntheticLambda0
                    @Override // com.baseflow.geolocator.location.PositionChangedCallback
                    public final void onPositionChanged(Location location) {
                        EventChannel.EventSink.this.success(LocationMapper.toHashMap(location));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.geolocator.StreamHandlerImpl$$ExternalSyntheticLambda1
                    @Override // com.baseflow.geolocator.errors.ErrorCallback
                    public final void onError(ErrorCodes errorCodes) {
                        EventChannel.EventSink.this.error(errorCodes.toString(), errorCodes.toDescription(), null);
                    }
                });
            }
        } catch (PermissionUndefinedException e) {
            events.error(ErrorCodes.permissionDefinitionsNotFound.toString(), ErrorCodes.permissionDefinitionsNotFound.toDescription(), null);
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object arguments) {
        disposeListeners(true);
    }

    private void disposeListeners(boolean cancelled) {
        GeolocationManager geolocationManager;
        Log.e(TAG, "Geolocator position updates stopped");
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService == null || !geolocatorLocationService.canStopLocationService(cancelled)) {
            Log.e(TAG, "There is still another flutter engine connected, not stopping location service");
        } else {
            this.foregroundLocationService.stopLocationService();
            this.foregroundLocationService.disableBackgroundMode();
        }
        LocationClient locationClient = this.locationClient;
        if (locationClient != null && (geolocationManager = this.geolocationManager) != null) {
            geolocationManager.stopPositionUpdates(locationClient);
            this.locationClient = null;
        }
    }
}
