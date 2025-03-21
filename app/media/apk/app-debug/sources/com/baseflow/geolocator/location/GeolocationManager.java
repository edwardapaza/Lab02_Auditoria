package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.google.android.gms.common.GoogleApiAvailability;
import io.flutter.plugin.common.PluginRegistry;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class GeolocationManager implements PluginRegistry.ActivityResultListener {
    private static GeolocationManager geolocationManagerInstance = null;
    private final List<LocationClient> locationClients = new CopyOnWriteArrayList();

    private GeolocationManager() {
    }

    public static synchronized GeolocationManager getInstance() {
        GeolocationManager geolocationManager;
        synchronized (GeolocationManager.class) {
            if (geolocationManagerInstance == null) {
                geolocationManagerInstance = new GeolocationManager();
            }
            geolocationManager = geolocationManagerInstance;
        }
        return geolocationManager;
    }

    public void getLastKnownPosition(Context context, boolean forceLocationManager, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        LocationClient locationClient = createLocationClient(context, forceLocationManager, null);
        locationClient.getLastKnownPosition(positionChangedCallback, errorCallback);
    }

    public void isLocationServiceEnabled(Context context, LocationServiceListener listener) {
        if (context == null) {
            listener.onLocationServiceError(ErrorCodes.locationServicesDisabled);
        }
        LocationClient locationClient = createLocationClient(context, false, null);
        locationClient.isLocationServiceEnabled(listener);
    }

    public void startPositionUpdates(LocationClient locationClient, Activity activity, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        this.locationClients.add(locationClient);
        locationClient.startPositionUpdates(activity, positionChangedCallback, errorCallback);
    }

    public void stopPositionUpdates(LocationClient locationClient) {
        this.locationClients.remove(locationClient);
        locationClient.stopPositionUpdates();
    }

    public LocationClient createLocationClient(Context context, boolean forceAndroidLocationManager, LocationOptions locationOptions) {
        if (forceAndroidLocationManager) {
            return new LocationManagerClient(context, locationOptions);
        }
        if (isGooglePlayServicesAvailable(context)) {
            return new FusedLocationClient(context, locationOptions);
        }
        return new LocationManagerClient(context, locationOptions);
    }

    private boolean isGooglePlayServicesAvailable(Context context) {
        try {
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context);
            return resultCode == 0;
        } catch (NoClassDefFoundError e) {
            return false;
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        for (LocationClient client : this.locationClients) {
            if (client.onActivityResult(requestCode, resultCode)) {
                return true;
            }
        }
        return false;
    }
}
