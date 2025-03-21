package com.baseflow.geolocator.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;
import com.baseflow.geolocator.errors.PermissionUndefinedException;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class PermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private static final int PERMISSION_REQUEST_CODE = 109;
    private static PermissionManager permissionManagerInstance = null;
    private Activity activity;
    private ErrorCallback errorCallback;
    private PermissionResultCallback resultCallback;

    private PermissionManager() {
    }

    public static synchronized PermissionManager getInstance() {
        PermissionManager permissionManager;
        synchronized (PermissionManager.class) {
            if (permissionManagerInstance == null) {
                permissionManagerInstance = new PermissionManager();
            }
            permissionManager = permissionManagerInstance;
        }
        return permissionManager;
    }

    public LocationPermission checkPermissionStatus(Context context) throws PermissionUndefinedException {
        List<String> permissions = getLocationPermissionsFromManifest(context);
        if (Build.VERSION.SDK_INT < 23) {
            return LocationPermission.always;
        }
        int permissionStatus = -1;
        Iterator<String> it = permissions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String permission = it.next();
            if (ContextCompat.checkSelfPermission(context, permission) == 0) {
                permissionStatus = 0;
                break;
            }
        }
        if (permissionStatus == -1) {
            return LocationPermission.denied;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return LocationPermission.always;
        }
        boolean wantsBackgroundLocation = PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_BACKGROUND_LOCATION");
        if (!wantsBackgroundLocation) {
            return LocationPermission.whileInUse;
        }
        int permissionStatusBackground = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION");
        if (permissionStatusBackground == 0) {
            return LocationPermission.always;
        }
        return LocationPermission.whileInUse;
    }

    public void requestPermission(Activity activity, PermissionResultCallback resultCallback, ErrorCallback errorCallback) throws PermissionUndefinedException {
        if (activity == null) {
            errorCallback.onError(ErrorCodes.activityMissing);
        } else if (Build.VERSION.SDK_INT < 23) {
            resultCallback.onResult(LocationPermission.always);
        } else {
            List<String> permissionsToRequest = getLocationPermissionsFromManifest(activity);
            if (Build.VERSION.SDK_INT >= 29 && PermissionUtils.hasPermissionInManifest(activity, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                LocationPermission permissionStatus = checkPermissionStatus(activity);
                if (permissionStatus == LocationPermission.whileInUse) {
                    permissionsToRequest.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                }
            }
            this.errorCallback = errorCallback;
            this.resultCallback = resultCallback;
            this.activity = activity;
            ActivityCompat.requestPermissions(activity, (String[]) permissionsToRequest.toArray(new String[0]), PERMISSION_REQUEST_CODE);
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        LocationPermission locationPermission;
        if (requestCode != PERMISSION_REQUEST_CODE) {
            return false;
        }
        Activity activity = this.activity;
        if (activity == null) {
            Log.e("Geolocator", "Trying to process permission result without an valid Activity instance");
            ErrorCallback errorCallback = this.errorCallback;
            if (errorCallback != null) {
                errorCallback.onError(ErrorCodes.activityMissing);
            }
            return false;
        }
        try {
            List<String> requestedPermissions = getLocationPermissionsFromManifest(activity);
            if (grantResults.length == 0) {
                Log.i("Geolocator", "The grantResults array is empty. This can happen when the user cancels the permission request");
                return false;
            }
            LocationPermission locationPermission2 = LocationPermission.denied;
            int grantedResult = -1;
            boolean shouldShowRationale = false;
            boolean permissionsPartOfPermissionsResult = false;
            for (String permission : requestedPermissions) {
                int requestedPermissionIndex = indexOf(permissions, permission);
                if (requestedPermissionIndex >= 0) {
                    permissionsPartOfPermissionsResult = true;
                }
                if (grantResults[requestedPermissionIndex] == 0) {
                    grantedResult = 0;
                }
                if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, permission)) {
                    shouldShowRationale = true;
                }
            }
            if (!permissionsPartOfPermissionsResult) {
                Log.w("Geolocator", "Location permissions not part of permissions send to onRequestPermissionsResult method.");
                return false;
            }
            if (grantedResult == 0) {
                if (Build.VERSION.SDK_INT < 29 || hasBackgroundAccess(permissions, grantResults)) {
                    locationPermission = LocationPermission.always;
                } else {
                    locationPermission = LocationPermission.whileInUse;
                }
                locationPermission2 = locationPermission;
            } else if (!shouldShowRationale) {
                locationPermission2 = LocationPermission.deniedForever;
            }
            PermissionResultCallback permissionResultCallback = this.resultCallback;
            if (permissionResultCallback != null) {
                permissionResultCallback.onResult(locationPermission2);
                return true;
            }
            return true;
        } catch (PermissionUndefinedException e) {
            ErrorCallback errorCallback2 = this.errorCallback;
            if (errorCallback2 != null) {
                errorCallback2.onError(ErrorCodes.permissionDefinitionsNotFound);
            }
            return false;
        }
    }

    private boolean hasBackgroundAccess(String[] permissions, int[] grantResults) {
        int backgroundPermissionIndex = indexOf(permissions, "android.permission.ACCESS_BACKGROUND_LOCATION");
        return backgroundPermissionIndex >= 0 && grantResults[backgroundPermissionIndex] == 0;
    }

    private static <T> int indexOf(T[] arr, T val) {
        return Arrays.asList(arr).indexOf(val);
    }

    private static List<String> getLocationPermissionsFromManifest(Context context) throws PermissionUndefinedException {
        boolean fineLocationPermissionExists = PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean coarseLocationPermissionExists = PermissionUtils.hasPermissionInManifest(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (!fineLocationPermissionExists && !coarseLocationPermissionExists) {
            throw new PermissionUndefinedException();
        }
        List<String> permissions = new ArrayList<>();
        if (fineLocationPermissionExists) {
            permissions.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (coarseLocationPermissionExists) {
            permissions.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        return permissions;
    }

    public boolean hasPermission(Context context) throws PermissionUndefinedException {
        LocationPermission locationPermission = checkPermissionStatus(context);
        return locationPermission == LocationPermission.whileInUse || locationPermission == LocationPermission.always;
    }
}
