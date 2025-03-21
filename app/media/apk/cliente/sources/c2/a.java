package c2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import p1.c;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f847a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f848b;

    /* renamed from: c  reason: collision with root package name */
    private final c f849c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f850d;

    public a(Context context, String str, c cVar) {
        Context a5 = a(context);
        this.f847a = a5;
        this.f848b = a5.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f849c = cVar;
        this.f850d = c();
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : androidx.core.content.a.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        return this.f848b.contains("firebase_data_collection_default_enabled") ? this.f848b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f847a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f847a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private synchronized void f(boolean z4) {
        if (this.f850d != z4) {
            this.f850d = z4;
            this.f849c.a(new p1.a<>(f1.b.class, new f1.b(z4)));
        }
    }

    public synchronized boolean b() {
        return this.f850d;
    }

    public synchronized void e(Boolean bool) {
        boolean equals;
        if (bool == null) {
            this.f848b.edit().remove("firebase_data_collection_default_enabled").apply();
            equals = d();
        } else {
            equals = Boolean.TRUE.equals(bool);
            this.f848b.edit().putBoolean("firebase_data_collection_default_enabled", equals).apply();
        }
        f(equals);
    }
}
