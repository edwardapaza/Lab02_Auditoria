package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f335c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static Set<String> f336d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f337e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f338a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f339b;

    /* loaded from: classes.dex */
    static class a {
        static boolean a(NotificationManager notificationManager) {
            boolean areNotificationsEnabled;
            areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            return areNotificationsEnabled;
        }

        static int b(NotificationManager notificationManager) {
            int importance;
            importance = notificationManager.getImportance();
            return importance;
        }
    }

    private q0(Context context) {
        this.f338a = context;
        this.f339b = (NotificationManager) context.getSystemService("notification");
    }

    public static q0 b(Context context) {
        return new q0(context);
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f339b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f338a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f338a.getApplicationInfo();
        String packageName = this.f338a.getApplicationContext().getPackageName();
        int i5 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i5), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
