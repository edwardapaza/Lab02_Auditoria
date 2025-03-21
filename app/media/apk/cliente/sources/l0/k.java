package l0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.google.android.gms.common.internal.s0;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class k {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f5890a = 12451000;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    static final AtomicBoolean f5891b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicBoolean f5892c = new AtomicBoolean();

    @Deprecated
    public static void a(Context context, int i5) {
        int g5 = g.e().g(context, i5);
        if (g5 != 0) {
            Intent a5 = g.e().a(context, g5, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + g5);
            if (a5 != null) {
                throw new i(g5, "Google Play Services not available", a5);
            }
            throw new h(g5);
        }
    }

    @Deprecated
    public static String b(int i5) {
        return a.y(i5);
    }

    public static Context c(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int e(Context context, int i5) {
        String valueOf;
        String str;
        PackageInfo packageInfo;
        try {
            context.getResources().getString(m.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f5892c.get()) {
            int a5 = s0.a(context);
            if (a5 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (a5 != f5890a) {
                throw new GooglePlayServicesIncorrectManifestValueException(a5);
            }
        }
        boolean z4 = (q0.g.c(context) || q0.g.e(context)) ? false : true;
        com.google.android.gms.common.internal.q.a(i5 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z4) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                valueOf = String.valueOf(packageName);
                str = " requires the Google Play Store, but it is missing.";
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            l.a(context);
            if (l.c(packageInfo2, true)) {
                if (z4) {
                    com.google.android.gms.common.internal.q.k(packageInfo);
                    if (!l.c(packageInfo, true)) {
                        valueOf = String.valueOf(packageName);
                        str = " requires Google Play Store, but its signature is invalid.";
                    }
                }
                if (!z4 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    if (q0.n.a(packageInfo2.versionCode) >= q0.n.a(i5)) {
                        ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e5) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e5);
                                return 1;
                            }
                        }
                        return !applicationInfo.enabled ? 3 : 0;
                    }
                    int i6 = packageInfo2.versionCode;
                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i5 + " but found " + i6);
                    return 2;
                }
                valueOf = String.valueOf(packageName);
                str = " requires Google Play Store, but its signature doesn't match that of Google Play services.";
            } else {
                valueOf = String.valueOf(packageName);
                str = " requires Google Play services, but their signature is invalid.";
            }
            Log.w("GooglePlayServicesUtil", valueOf.concat(str));
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @Deprecated
    public static boolean f(Context context, int i5) {
        if (i5 == 18) {
            return true;
        }
        if (i5 == 1) {
            return i(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean g(Context context) {
        if (q0.j.c()) {
            Object systemService = context.getSystemService("user");
            com.google.android.gms.common.internal.q.k(systemService);
            Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
            return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
        }
        return false;
    }

    @Deprecated
    public static boolean h(int i5) {
        return i5 == 1 || i5 == 2 || i5 == 3 || i5 == 9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (q0.j.e()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return equals ? applicationInfo.enabled : applicationInfo.enabled && !g(context);
    }
}
