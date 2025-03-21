package s0;

import android.content.Context;
import q0.j;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7251a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f7252b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        boolean isInstantApp;
        Boolean bool2;
        synchronized (b.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f7251a;
            if (context2 != null && (bool2 = f7252b) != null && context2 == applicationContext) {
                return bool2.booleanValue();
            }
            f7252b = null;
            if (!j.g()) {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f7252b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    bool = Boolean.FALSE;
                }
                f7251a = applicationContext;
                return f7252b.booleanValue();
            }
            isInstantApp = applicationContext.getPackageManager().isInstantApp();
            bool = Boolean.valueOf(isInstantApp);
            f7252b = bool;
            f7251a = applicationContext;
            return f7252b.booleanValue();
        }
    }
}
