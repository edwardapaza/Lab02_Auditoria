package v0;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;
import l0.g;
import l0.h;
import l0.k;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g f8099a = g.e();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f8100b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Method f8101c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f8102d = null;

    public static void a(Context context) {
        Context context2;
        q.l(context, "Context must not be null");
        f8099a.j(context, 11925000);
        synchronized (f8100b) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.c(context, DynamiteModule.f1224f, "com.google.android.gms.providerinstaller.dynamite").b();
            } catch (DynamiteModule.a e5) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e5.getMessage())));
                context2 = null;
            }
            if (context2 != null) {
                c(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            Context c5 = k.c(context);
            if (c5 != null) {
                try {
                    if (f8102d == null) {
                        Class cls = Long.TYPE;
                        f8102d = b(c5, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                    }
                    f8102d.invoke(null, context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2));
                } catch (Exception e6) {
                    Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e6.getMessage())));
                }
            }
            if (c5 != null) {
                c(c5, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new h(8);
            }
        }
    }

    private static Method b(Context context, String str, String str2, Class[] clsArr) {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    private static void c(Context context, Context context2, String str) {
        try {
            if (f8101c == null) {
                f8101c = b(context, str, "insertProvider", new Class[]{Context.class});
            }
            f8101c.invoke(null, context);
        } catch (Exception e5) {
            Throwable cause = e5.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e5.getMessage() : cause.getMessage())));
            }
            throw new h(8);
        }
    }
}
