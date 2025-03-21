package q0;

import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6927a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f6928b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f6929c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f6930d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f6930d == null) {
            boolean z4 = false;
            if (j.g() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z4 = true;
            }
            f6930d = Boolean.valueOf(z4);
        }
        return f6930d.booleanValue();
    }

    public static boolean b(Context context) {
        return f(context.getPackageManager());
    }

    public static boolean c(Context context) {
        if (!b(context) || j.f()) {
            if (d(context)) {
                return !j.g() || j.i();
            }
            return false;
        }
        return true;
    }

    public static boolean d(Context context) {
        if (f6928b == null) {
            boolean z4 = false;
            if (j.e() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z4 = true;
            }
            f6928b = Boolean.valueOf(z4);
        }
        return f6928b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f6929c == null) {
            boolean z4 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z4 = false;
            }
            f6929c = Boolean.valueOf(z4);
        }
        return f6929c.booleanValue();
    }

    public static boolean f(PackageManager packageManager) {
        if (f6927a == null) {
            boolean z4 = false;
            if (j.d() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z4 = true;
            }
            f6927a = Boolean.valueOf(z4);
        }
        return f6927a.booleanValue();
    }
}
