package com.baseflow.geolocator.location;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.location.LocationClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.security.SecureRandom;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FusedLocationClient implements LocationClient {
    private static final String TAG = "FlutterGeolocator";
    private final int activityRequestCode = generateActivityRequestCode();
    private final Context context;
    private ErrorCallback errorCallback;
    private final FusedLocationProviderClient fusedLocationProviderClient;
    private final LocationCallback locationCallback;
    private final LocationOptions locationOptions;
    private final NmeaClient nmeaClient;
    private PositionChangedCallback positionChangedCallback;

    @Override // com.baseflow.geolocator.location.LocationClient
    public /* synthetic */ boolean checkLocationService(Context context) {
        return LocationClient.CC.$default$checkLocationService(this, context);
    }

    public FusedLocationClient(final Context context, final LocationOptions locationOptions) {
        this.context = context;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        this.locationOptions = locationOptions;
        this.nmeaClient = new NmeaClient(context, locationOptions);
        this.locationCallback = new LocationCallback() { // from class: com.baseflow.geolocator.location.FusedLocationClient.1
            @Override // com.google.android.gms.location.LocationCallback
            public synchronized void onLocationResult(LocationResult locationResult) {
                if (FusedLocationClient.this.positionChangedCallback == null) {
                    Log.e(FusedLocationClient.TAG, "LocationCallback was called with empty locationResult or no positionChangedCallback was registered.");
                    FusedLocationClient.this.fusedLocationProviderClient.removeLocationUpdates(FusedLocationClient.this.locationCallback);
                    if (FusedLocationClient.this.errorCallback != null) {
                        FusedLocationClient.this.errorCallback.onError(ErrorCodes.errorWhileAcquiringPosition);
                    }
                    return;
                }
                Location location = locationResult.getLastLocation();
                if (location == null) {
                    return;
                }
                if (location.getExtras() == null) {
                    location.setExtras(Bundle.EMPTY);
                }
                if (locationOptions != null) {
                    location.getExtras().putBoolean(LocationOptions.USE_MSL_ALTITUDE_EXTRA, locationOptions.isUseMSLAltitude());
                }
                FusedLocationClient.this.nmeaClient.enrichExtrasWithNmea(location);
                FusedLocationClient.this.positionChangedCallback.onPositionChanged(location);
            }

            @Override // com.google.android.gms.location.LocationCallback
            public synchronized void onLocationAvailability(LocationAvailability locationAvailability) {
                if (!locationAvailability.isLocationAvailable() && !FusedLocationClient.this.checkLocationService(context) && FusedLocationClient.this.errorCallback != null) {
                    FusedLocationClient.this.errorCallback.onError(ErrorCodes.locationServicesDisabled);
                }
            }
        };
    }

    private static LocationRequest buildLocationRequest(LocationOptions options) {
        if (Build.VERSION.SDK_INT < 33) {
            return buildLocationRequestDeprecated(options);
        }
        LocationRequest.Builder builder = new LocationRequest.Builder(0L);
        if (options != null) {
            builder.setPriority(toPriority(options.getAccuracy()));
            builder.setIntervalMillis(options.getTimeInterval());
            builder.setMinUpdateIntervalMillis(options.getTimeInterval());
            builder.setMinUpdateDistanceMeters((float) options.getDistanceFilter());
        }
        return builder.build();
    }

    private static LocationRequest buildLocationRequestDeprecated(LocationOptions options) {
        LocationRequest locationRequest = LocationRequest.create();
        if (options != null) {
            locationRequest.setPriority(toPriority(options.getAccuracy()));
            locationRequest.setInterval(options.getTimeInterval());
            locationRequest.setFastestInterval(options.getTimeInterval() / 2);
            locationRequest.setSmallestDisplacement((float) options.getDistanceFilter());
        }
        return locationRequest;
    }

    private static LocationSettingsRequest buildLocationSettingsRequest(LocationRequest locationRequest) {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baseflow.geolocator.location.FusedLocationClient$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
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
                $SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[LocationAccuracy.medium.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static int toPriority(LocationAccuracy locationAccuracy) {
        switch (AnonymousClass2.$SwitchMap$com$baseflow$geolocator$location$LocationAccuracy[locationAccuracy.ordinal()]) {
            case 1:
                return 105;
            case 2:
                return 104;
            case 3:
                return 102;
            default:
                return 100;
        }
    }

    private synchronized int generateActivityRequestCode() {
        SecureRandom random;
        random = new SecureRandom();
        return random.nextInt(65536);
    }

    private void requestPositionUpdates(LocationOptions locationOptions) {
        LocationRequest locationRequest = buildLocationRequest(locationOptions);
        this.nmeaClient.start();
        this.fusedLocationProviderClient.requestLocationUpdates(locationRequest, this.locationCallback, Looper.getMainLooper());
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void isLocationServiceEnabled(final LocationServiceListener listener) {
        LocationServices.getSettingsClient(this.context).checkLocationSettings(new LocationSettingsRequest.Builder().build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.baseflow.geolocator.location.FusedLocationClient$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FusedLocationClient.lambda$isLocationServiceEnabled$0(LocationServiceListener.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$isLocationServiceEnabled$0(LocationServiceListener listener, Task response) {
        if (!response.isSuccessful()) {
            listener.onLocationServiceError(ErrorCodes.locationServicesDisabled);
        }
        LocationSettingsResponse lsr = (LocationSettingsResponse) response.getResult();
        if (lsr != null) {
            LocationSettingsStates settingsStates = lsr.getLocationSettingsStates();
            boolean z = true;
            boolean isGpsUsable = settingsStates != null && settingsStates.isGpsUsable();
            boolean isNetworkUsable = settingsStates != null && settingsStates.isNetworkLocationUsable();
            if (!isGpsUsable && !isNetworkUsable) {
                z = false;
            }
            listener.onLocationServiceResult(z);
            return;
        }
        listener.onLocationServiceError(ErrorCodes.locationServicesDisabled);
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void getLastKnownPosition(final PositionChangedCallback positionChangedCallback, final ErrorCallback errorCallback) {
        Task<Location> lastLocation = this.fusedLocationProviderClient.getLastLocation();
        Objects.requireNonNull(positionChangedCallback);
        lastLocation.addOnSuccessListener(new OnSuccessListener() { // from class: com.baseflow.geolocator.location.FusedLocationClient$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                PositionChangedCallback.this.onPositionChanged((Location) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.baseflow.geolocator.location.FusedLocationClient$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FusedLocationClient.lambda$getLastKnownPosition$1(ErrorCallback.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getLastKnownPosition$1(ErrorCallback errorCallback, Exception e) {
        Log.e("Geolocator", "Error trying to get last the last known GPS location");
        if (errorCallback != null) {
            errorCallback.onError(ErrorCodes.errorWhileAcquiringPosition);
        }
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public boolean onActivityResult(int requestCode, int resultCode) {
        if (requestCode == this.activityRequestCode) {
            if (resultCode == -1) {
                LocationOptions locationOptions = this.locationOptions;
                if (locationOptions == null || this.positionChangedCallback == null || this.errorCallback == null) {
                    return false;
                }
                requestPositionUpdates(locationOptions);
                return true;
            }
            ErrorCallback errorCallback = this.errorCallback;
            if (errorCallback != null) {
                errorCallback.onError(ErrorCodes.locationServicesDisabled);
            }
        }
        return false;
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void startPositionUpdates(final Activity activity, PositionChangedCallback positionChangedCallback, final ErrorCallback errorCallback) {
        this.positionChangedCallback = positionChangedCallback;
        this.errorCallback = errorCallback;
        LocationRequest locationRequest = buildLocationRequest(this.locationOptions);
        LocationSettingsRequest settingsRequest = buildLocationSettingsRequest(locationRequest);
        SettingsClient settingsClient = LocationServices.getSettingsClient(this.context);
        settingsClient.checkLocationSettings(settingsRequest).addOnSuccessListener(new OnSuccessListener() { // from class: com.baseflow.geolocator.location.FusedLocationClient$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FusedLocationClient.this.m54x2c9cec4b((LocationSettingsResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.baseflow.geolocator.location.FusedLocationClient$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FusedLocationClient.this.m55x46b86aea(activity, errorCallback, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startPositionUpdates$2$com-baseflow-geolocator-location-FusedLocationClient  reason: not valid java name */
    public /* synthetic */ void m54x2c9cec4b(LocationSettingsResponse locationSettingsResponse) {
        requestPositionUpdates(this.locationOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startPositionUpdates$3$com-baseflow-geolocator-location-FusedLocationClient  reason: not valid java name */
    public /* synthetic */ void m55x46b86aea(Activity activity, ErrorCallback errorCallback, Exception e) {
        if (e instanceof ResolvableApiException) {
            if (activity == null) {
                errorCallback.onError(ErrorCodes.locationServicesDisabled);
                return;
            }
            ResolvableApiException rae = (ResolvableApiException) e;
            int statusCode = rae.getStatusCode();
            if (statusCode == 6) {
                try {
                    rae.startResolutionForResult(activity, this.activityRequestCode);
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    errorCallback.onError(ErrorCodes.locationServicesDisabled);
                    return;
                }
            }
            errorCallback.onError(ErrorCodes.locationServicesDisabled);
            return;
        }
        ApiException ae = (ApiException) e;
        int statusCode2 = ae.getStatusCode();
        if (statusCode2 == 8502) {
            requestPositionUpdates(this.locationOptions);
        } else {
            errorCallback.onError(ErrorCodes.locationServicesDisabled);
        }
    }

    @Override // com.baseflow.geolocator.location.LocationClient
    public void stopPositionUpdates() {
        this.nmeaClient.stop();
        this.fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
    }
}
