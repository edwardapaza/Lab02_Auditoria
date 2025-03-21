package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.activity.result.contract.ActivityResultContracts;
import io.flutter.plugins.imagepicker.Messages;
import java.util.Arrays;
/* loaded from: classes2.dex */
final class ImagePickerUtils {
    ImagePickerUtils() {
    }

    private static boolean isPermissionPresentInManifest(Context context, String permissionName) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
            } else {
                packageInfo = getPermissionsPackageInfoPreApi33(packageManager, context.getPackageName());
            }
            String[] requestedPermissions = packageInfo.requestedPermissions;
            return Arrays.asList(requestedPermissions).contains(permissionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static PackageInfo getPermissionsPackageInfoPreApi33(PackageManager packageManager, String packageName) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(packageName, 4096);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean needRequestCameraPermission(Context context) {
        boolean greatOrEqualM = Build.VERSION.SDK_INT >= 23;
        return greatOrEqualM && isPermissionPresentInManifest(context, "android.permission.CAMERA");
    }

    static int getMaxItems() {
        boolean isSystemPickerAvailable$activity_release;
        isSystemPickerAvailable$activity_release = ActivityResultContracts.PickVisualMedia.Companion.isSystemPickerAvailable$activity_release();
        if (isSystemPickerAvailable$activity_release) {
            return MediaStore.getPickImagesMaxLimit();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLimitFromOption(Messages.GeneralOptions generalOptions) {
        Long limit = generalOptions.getLimit();
        int effectiveLimit = getMaxItems();
        if (limit != null && limit.longValue() < effectiveLimit) {
            return ImagePickerUtils$$ExternalSyntheticBackport0.m(limit.longValue());
        }
        return effectiveLimit;
    }
}
