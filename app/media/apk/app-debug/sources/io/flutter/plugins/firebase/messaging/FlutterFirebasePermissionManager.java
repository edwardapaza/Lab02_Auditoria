package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
/* loaded from: classes2.dex */
class FlutterFirebasePermissionManager implements PluginRegistry.RequestPermissionsResultListener {
    private final int permissionCode = 240;
    private boolean requestInProgress = false;
    private RequestPermissionsSuccessCallback successCallback;

    @FunctionalInterface
    /* loaded from: classes2.dex */
    interface RequestPermissionsSuccessCallback {
        void onSuccess(int i);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        RequestPermissionsSuccessCallback requestPermissionsSuccessCallback;
        if (this.requestInProgress && requestCode == 240 && (requestPermissionsSuccessCallback = this.successCallback) != null) {
            this.requestInProgress = false;
            boolean granted = grantResults.length > 0 && grantResults[0] == 0;
            requestPermissionsSuccessCallback.onSuccess(granted ? 1 : 0);
            return true;
        }
        return false;
    }

    public void requestPermissions(Activity activity, RequestPermissionsSuccessCallback successCallback, ErrorCallback errorCallback) {
        if (this.requestInProgress) {
            errorCallback.onError("A request for permissions is already running, please wait for it to finish before doing another request.");
        } else if (activity == null) {
            errorCallback.onError("Unable to detect current Android Activity.");
        } else {
            this.successCallback = successCallback;
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add("android.permission.POST_NOTIFICATIONS");
            String[] requestNotificationPermission = (String[]) permissions.toArray(new String[0]);
            if (!this.requestInProgress) {
                ActivityCompat.requestPermissions(activity, requestNotificationPermission, 240);
                this.requestInProgress = true;
            }
        }
    }
}
