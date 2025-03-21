package com.baseflow.geolocator.permission;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
/* loaded from: classes2.dex */
public class PermissionUtils {
    public static boolean hasPermissionInManifest(Context context, String permission) {
        String[] strArr;
        try {
            PackageInfo info = getPackageInfo(context);
            if (info.requestedPermissions != null) {
                for (String p : info.requestedPermissions) {
                    if (p.equals(permission)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static PackageInfo getPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (Build.VERSION.SDK_INT < 33) {
            return packageManager.getPackageInfo(packageName, 4096);
        }
        return packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
    }
}
