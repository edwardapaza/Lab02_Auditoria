package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.location.LocationListenerCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.location.LocationRequestCompat;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.location.LocationClient;
import java.util.List;
/* loaded from: classes2.dex */
class LocationManagerClient implements LocationClient, LocationListenerCompat {
    private static final long TWO_MINUTES = 120000;
    public Context context;
    private Location currentBestLocation;
    private String currentLocationProvider;
    private ErrorCallback errorCallback;
    private boolean isListening = false;
    private final LocationManager locationManager;
    private final LocationOptions locationOptions;
    private final NmeaClient nmeaClient;
    private PositionChangedCallback positionChangedCallback;

    @Override // com.baseflow.geolocator.location.LocationClient
    public /* synthetic */ boolean checkLocationService(Context context) {
        return LocationClient.CC.$default$checkLocationService(this, context);
    }

    @Override // androidx.core.location.LocationListenerCompat, android.location.LocationListener
    public /* synthetic */ void onFlushComplete(int i) {
        LocationListenerCompat.CC.$default$onFlushComplete(this, i);
    }

    @Override // androidx.core.location.LocationListenerCompat, android.location.LocationListener
    public /* synthetic */ void onLocationChanged(List list) {
        LocationListenerCompat.CC.$default$onLocationChanged(this, list);
    }

    public LocationManagerClient(Context context, LocationOptions locationOptions) {
        this.locationManager = (LocationManager) context.getSystemService("location");
        this.locationOptions = locationOptions;
        this.context = context;
        this.nmeaClient = new NmeaClient(context, locationOptions);
    }

    static boolean isBetterLocation(Location location, Location bestLocation) {
        if (bestLocation == null) {
            return true;
        }
        long timeDelta = location.getTime() - bestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
        boolean isSignificantlyOlder = timeDelta < -120000;
        boolean isNewer = timeDelta > 0;
        if (isSignificantlyNewer) {
            return true;
        }
        if (isSignificantlyOlder) {
            return false;
        }
        float accuracyDelta = (int) (location.getAccuracy() - bestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0.0f;
        boolean isMoreAccurate = accuracyDelta < 0.0f;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200.0f;
        boolean isFromSameProvider = false;
        if (location.getProvider() != null) {
            isFromSameProvider = location.getProvider().equals(bestLocation.getProvider());
        }
        if (isMoreAccurate) {
            return true;
        }
        if (!isNewer || isLessAccurate) {
            return isNewer && !isSignificantlyLessAccurate && isFromSameProvider;
        }
        return true;
    }

    private static String determineProvider(LocationManager locationManager, LocationAccuracy accuracy) {
        List<String> enabledProviders = locationManager.getProviders(true);
        if (accuracy == LocationAccuracy.lowest) {
            return "passive";
        }
        if (enabledProviders.contains("fused") && Build.VERSION.SDK_INT >= 31) {
            return "fused";
        }
        if (enabledProviders.contains("gps")) {
            return "gps";
        }
        if (enabledProviders.contains("network")) {
            return "network";
        }
        if (!enabledProviders.isEmpty()) {
            return enabledProviders.get(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baseflow.geolocator.location.LocationManagerClient$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy = iArr;
            try {
                iArr[LocationAccuracy.lowest.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.low.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.high.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.best.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.bestForNavigation.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.medium.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static int accuracyToQuality(LocationAccuracy accuracy) {
        switch (AnonymousClass1.$SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[accuracy.ordinal()]) {
            case 1:
            case 2:
                return 104;
            case 3:
            case 4:
            case 5:
                return 100;
            default:
                return 102;
        }
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void isLocationServiceEnabled(LocationServiceListener listener) {
        if (this.locationManager == null) {
            listener.onLocationServiceResult(false);
        } else {
            listener.onLocationServiceResult(checkLocationService(this.context));
        }
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void getLastKnownPosition(PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        Location bestLocation = null;
        for (String provider : this.locationManager.getProviders(true)) {
            Location location = this.locationManager.getLastKnownLocation(provider);
            if (location != null && isBetterLocation(location, bestLocation)) {
                bestLocation = location;
            }
        }
        positionChangedCallback.onPositionChanged(bestLocation);
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public boolean onActivityResult(int requestCode, int resultCode) {
        return false;
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void startPositionUpdates(Activity activity, PositionChangedCallback positionChangedCallback, ErrorCallback errorCallback) {
        long timeInterval;
        if (!checkLocationService(this.context)) {
            errorCallback.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        this.positionChangedCallback = positionChangedCallback;
        this.errorCallback = errorCallback;
        LocationAccuracy accuracy = LocationAccuracy.best;
        long timeInterval2 = 0;
        float distanceFilter = 0.0f;
        int quality = 102;
        LocationOptions locationOptions = this.locationOptions;
        if (locationOptions != null) {
            distanceFilter = (float) locationOptions.getDistanceFilter();
            accuracy = this.locationOptions.getAccuracy();
            if (accuracy == LocationAccuracy.lowest) {
                timeInterval = Long.MAX_VALUE;
            } else {
                timeInterval = this.locationOptions.getTimeInterval();
            }
            timeInterval2 = timeInterval;
            quality = accuracyToQuality(accuracy);
        }
        String determineProvider = determineProvider(this.locationManager, accuracy);
        this.currentLocationProvider = determineProvider;
        if (determineProvider == null) {
            errorCallback.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        LocationRequestCompat locationRequest = new LocationRequestCompat.Builder(timeInterval2).setMinUpdateDistanceMeters(distanceFilter).setMinUpdateIntervalMillis(timeInterval2).setQuality(quality).build();
        this.isListening = true;
        this.nmeaClient.start();
        LocationManagerCompat.requestLocationUpdates(this.locationManager, this.currentLocationProvider, locationRequest, this, Looper.getMainLooper());
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void stopPositionUpdates() {
        this.isListening = false;
        this.nmeaClient.stop();
        this.locationManager.removeUpdates(this);
    }

    @Override // android.location.LocationListener
    public synchronized void onLocationChanged(Location location) {
        if (isBetterLocation(location, this.currentBestLocation)) {
            this.currentBestLocation = location;
            if (this.positionChangedCallback != null) {
                this.nmeaClient.enrichExtrasWithNmea(location);
                this.positionChangedCallback.onPositionChanged(this.currentBestLocation);
            }
        }
    }

    @Override // androidx.core.location.LocationListenerCompat, android.location.LocationListener
    public void onStatusChanged(String provider, int status, Bundle extras) {
        if (status == 2) {
            onProviderEnabled(provider);
        } else if (status == 0) {
            onProviderDisabled(provider);
        }
    }

    @Override // androidx.core.location.LocationListenerCompat, android.location.LocationListener
    public void onProviderEnabled(String provider) {
    }

    @Override // androidx.core.location.LocationListenerCompat, android.location.LocationListener
    public void onProviderDisabled(String provider) {
        if (provider.equals(this.currentLocationProvider)) {
            if (this.isListening) {
                this.locationManager.removeUpdates(this);
            }
            ErrorCallback errorCallback = this.errorCallback;
            if (errorCallback != null) {
                errorCallback.onError(ErrorCodes.locationServicesDisabled);
            }
            this.currentLocationProvider = null;
        }
    }
}
