package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback$OnSharedElementsReadyListener;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: a  reason: collision with root package name */
    private static d f261a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0012a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f264c;

        RunnableC0012a(String[] strArr, Activity activity, int i5) {
            this.f262a = strArr;
            this.f263b = activity;
            this.f264c = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f262a.length];
            PackageManager packageManager = this.f263b.getPackageManager();
            String packageName = this.f263b.getPackageName();
            int length = this.f262a.length;
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = packageManager.checkPermission(this.f262a[i5], packageName);
            }
            ((c) this.f263b).onRequestPermissionsResult(this.f264c, this.f262a, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static void a(Object obj) {
            ((SharedElementCallback$OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i5) {
            activity.requestPermissions(strArr, i5);
        }

        static boolean c(Activity activity, String str) {
            boolean shouldShowRequestPermissionRationale;
            shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
            return shouldShowRequestPermissionRationale;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(Activity activity, String[] strArr, int i5);
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(int i5);
    }

    public static void a(Activity activity, String[] strArr, int i5) {
        d dVar = f261a;
        if (dVar == null || !dVar.a(activity, strArr, i5)) {
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (TextUtils.isEmpty(strArr[i6])) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i6], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i6));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
            if (size > 0) {
                if (size == strArr.length) {
                    return;
                }
                int i7 = 0;
                for (int i8 = 0; i8 < strArr.length; i8++) {
                    if (!hashSet.contains(Integer.valueOf(i8))) {
                        strArr2[i7] = strArr[i8];
                        i7++;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof e) {
                    ((e) activity).b(i5);
                }
                b.b(activity, strArr, i5);
            } else if (activity instanceof c) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0012a(strArr2, activity, i5));
            }
        }
    }

    public static void b(Activity activity, Intent intent, int i5, Bundle bundle) {
        activity.startActivityForResult(intent, i5, bundle);
    }

    public static void c(Activity activity, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }
}
