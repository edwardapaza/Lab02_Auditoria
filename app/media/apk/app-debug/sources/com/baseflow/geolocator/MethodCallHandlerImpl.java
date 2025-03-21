package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import com.baseflow.geolocator.location.FlutterLocationServiceListener;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationAccuracyManager;
import com.baseflow.geolocator.location.LocationAccuracyStatus;
import com.baseflow.geolocator.location.LocationClient;
import com.baseflow.geolocator.location.LocationMapper;
import com.baseflow.geolocator.location.LocationOptions;
import com.baseflow.geolocator.location.PositionChangedCallback;
import com.baseflow.geolocator.permission.LocationPermission;
import com.baseflow.geolocator.permission.PermissionManager;
import com.baseflow.geolocator.permission.PermissionResultCallback;
import com.baseflow.geolocator.utils.Utils;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    private Activity activity;
    private MethodChannel channel;
    private Context context;
    private final GeolocationManager geolocationManager;
    private final LocationAccuracyManager locationAccuracyManager;
    final Map<String, LocationClient> pendingCurrentPositionLocationClients = new HashMap();
    private final PermissionManager permissionManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodCallHandlerImpl(PermissionManager permissionManager, GeolocationManager geolocationManager, LocationAccuracyManager locationAccuracyManager) {
        this.permissionManager = permissionManager;
        this.geolocationManager = geolocationManager;
        this.locationAccuracyManager = locationAccuracyManager;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        char c;
        String str = call.method;
        switch (str.hashCode()) {
            case -1757019252:
                if (str.equals("getCurrentPosition")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1156770336:
                if (str.equals("getLastKnownPosition")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -821636766:
                if (str.equals("openLocationSettings")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 356040619:
                if (str.equals("isLocationServiceEnabled")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 686218487:
                if (str.equals("checkPermission")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 746581438:
                if (str.equals("requestPermission")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 877043524:
                if (str.equals("getLocationAccuracy")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1774650278:
                if (str.equals("cancelGetCurrentPosition")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                onCheckPermission(result);
                return;
            case 1:
                onIsLocationServiceEnabled(result);
                return;
            case 2:
                onRequestPermission(result);
                return;
            case 3:
                onGetLastKnownPosition(call, result);
                return;
            case 4:
                getLocationAccuracy(result, this.context);
                return;
            case 5:
                onGetCurrentPosition(call, result);
                return;
            case 6:
                onCancelGetCurrentPosition(call, result);
                return;
            case 7:
                boolean hasOpenedAppSettings = Utils.openAppSettings(this.context);
                result.success(Boolean.valueOf(hasOpenedAppSettings));
                return;
            case '\b':
                boolean hasOpenedLocationSettings = Utils.openLocationSettings(this.context);
                result.success(Boolean.valueOf(hasOpenedLocationSettings));
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(Context context, BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        MethodChannel methodChannel = new MethodChannel(messenger, "flutter.baseflow.com/geolocator_android");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        methodChannel.setMethodCallHandler(null);
        this.channel = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    private void onCheckPermission(MethodChannel.Result result) {
        try {
            LocationPermission permission = this.permissionManager.checkPermissionStatus(this.context);
            result.success(Integer.valueOf(permission.toInt()));
        } catch (PermissionUndefinedException e) {
            ErrorCodes errorCode = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCode.toString(), errorCode.toDescription(), null);
        }
    }

    private void onIsLocationServiceEnabled(MethodChannel.Result result) {
        this.geolocationManager.isLocationServiceEnabled(this.context, new FlutterLocationServiceListener(result));
    }

    private void onRequestPermission(final MethodChannel.Result result) {
        try {
            this.permissionManager.requestPermission(this.activity, new PermissionResultCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda3
                @Override // com.baseflow.geolocator.permission.PermissionResultCallback
                public final void onResult(LocationPermission locationPermission) {
                    MethodChannel.Result.this.success(Integer.valueOf(locationPermission.toInt()));
                }
            }, new ErrorCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda4
                @Override // com.baseflow.geolocator.errors.ErrorCallback
                public final void onError(ErrorCodes errorCodes) {
                    MethodChannel.Result.this.error(errorCodes.toString(), errorCodes.toDescription(), null);
                }
            });
        } catch (PermissionUndefinedException e) {
            ErrorCodes errorCode = ErrorCodes.permissionDefinitionsNotFound;
            result.error(errorCode.toString(), errorCode.toDescription(), null);
        }
    }

    private void getLocationAccuracy(final MethodChannel.Result result, Context context) {
        LocationAccuracyStatus status = this.locationAccuracyManager.getLocationAccuracy(context, new ErrorCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda2
            @Override // com.baseflow.geolocator.errors.ErrorCallback
            public final void onError(ErrorCodes errorCodes) {
                MethodChannel.Result.this.error(errorCodes.toString(), errorCodes.toDescription(), null);
            }
        });
        if (status != null) {
            result.success(Integer.valueOf(status.ordinal()));
        }
    }

    private void onGetLastKnownPosition(MethodCall call, final MethodChannel.Result result) {
        try {
            if (!this.permissionManager.hasPermission(this.context)) {
                result.error(ErrorCodes.permissionDenied.toString(), ErrorCodes.permissionDenied.toDescription(), null);
                return;
            }
            Boolean forceLocationManager = (Boolean) call.argument("forceLocationManager");
            this.geolocationManager.getLastKnownPosition(this.context, forceLocationManager != null && forceLocationManager.booleanValue(), new PositionChangedCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda0
                @Override // com.baseflow.geolocator.location.PositionChangedCallback
                public final void onPositionChanged(Location location) {
                    MethodChannel.Result.this.success(LocationMapper.toHashMap(location));
                }
            }, new ErrorCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda1
                @Override // com.baseflow.geolocator.errors.ErrorCallback
                public final void onError(ErrorCodes errorCodes) {
                    MethodChannel.Result.this.error(errorCodes.toString(), errorCodes.toDescription(), null);
                }
            });
        } catch (PermissionUndefinedException e) {
            result.error(ErrorCodes.permissionDefinitionsNotFound.toString(), ErrorCodes.permissionDefinitionsNotFound.toDescription(), null);
        }
    }

    private void onGetCurrentPosition(MethodCall call, final MethodChannel.Result result) {
        boolean forceLocationManager;
        try {
            if (!this.permissionManager.hasPermission(this.context)) {
                result.error(ErrorCodes.permissionDenied.toString(), ErrorCodes.permissionDenied.toDescription(), null);
                return;
            }
            Map<String, Object> map = (Map) call.arguments;
            if (map.get("forceLocationManager") == null) {
                forceLocationManager = false;
            } else {
                boolean forceLocationManager2 = ((Boolean) map.get("forceLocationManager")).booleanValue();
                forceLocationManager = forceLocationManager2;
            }
            LocationOptions locationOptions = LocationOptions.parseArguments(map);
            final String requestId = (String) map.get("requestId");
            final boolean[] replySubmitted = {false};
            final LocationClient locationClient = this.geolocationManager.createLocationClient(this.context, forceLocationManager, locationOptions);
            this.pendingCurrentPositionLocationClients.put(requestId, locationClient);
            this.geolocationManager.startPositionUpdates(locationClient, this.activity, new PositionChangedCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda5
                @Override // com.baseflow.geolocator.location.PositionChangedCallback
                public final void onPositionChanged(Location location) {
                    MethodCallHandlerImpl.this.m52xece4955a(replySubmitted, locationClient, requestId, result, location);
                }
            }, new ErrorCallback() { // from class: com.baseflow.geolocator.MethodCallHandlerImpl$$ExternalSyntheticLambda6
                @Override // com.baseflow.geolocator.errors.ErrorCallback
                public final void onError(ErrorCodes errorCodes) {
                    MethodCallHandlerImpl.this.m53x625ebb9b(replySubmitted, locationClient, requestId, result, errorCodes);
                }
            });
        } catch (PermissionUndefinedException e) {
            result.error(ErrorCodes.permissionDefinitionsNotFound.toString(), ErrorCodes.permissionDefinitionsNotFound.toDescription(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onGetCurrentPosition$5$com-baseflow-geolocator-MethodCallHandlerImpl  reason: not valid java name */
    public /* synthetic */ void m52xece4955a(boolean[] replySubmitted, LocationClient locationClient, String requestId, MethodChannel.Result result, Location location) {
        if (!replySubmitted[0]) {
            replySubmitted[0] = true;
            this.geolocationManager.stopPositionUpdates(locationClient);
            this.pendingCurrentPositionLocationClients.remove(requestId);
            result.success(LocationMapper.toHashMap(location));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onGetCurrentPosition$6$com-baseflow-geolocator-MethodCallHandlerImpl  reason: not valid java name */
    public /* synthetic */ void m53x625ebb9b(boolean[] replySubmitted, LocationClient locationClient, String requestId, MethodChannel.Result result, ErrorCodes errorCode) {
        if (!replySubmitted[0]) {
            replySubmitted[0] = true;
            this.geolocationManager.stopPositionUpdates(locationClient);
            this.pendingCurrentPositionLocationClients.remove(requestId);
            result.error(errorCode.toString(), errorCode.toDescription(), null);
        }
    }

    private void onCancelGetCurrentPosition(MethodCall call, MethodChannel.Result result) {
        Map<String, Object> arguments = (Map) call.arguments;
        String requestId = (String) arguments.get("requestId");
        LocationClient locationClient = this.pendingCurrentPositionLocationClients.get(requestId);
        if (locationClient != null) {
            locationClient.stopPositionUpdates();
        }
        this.pendingCurrentPositionLocationClients.remove(requestId);
        result.success(null);
    }
}
