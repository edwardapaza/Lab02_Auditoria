package p0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.l1;
import com.google.android.gms.common.internal.q;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import q0.j;
import s0.d;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f6877b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f6878c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f6879a = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f6878c == null) {
            synchronized (f6877b) {
                if (f6878c == null) {
                    f6878c = new b();
                }
            }
        }
        b bVar = f6878c;
        q.k(bVar);
        return bVar;
    }

    private static void d(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i5, boolean z4, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((d.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (f(serviceConnection)) {
            ServiceConnection serviceConnection2 = (ServiceConnection) this.f6879a.putIfAbsent(serviceConnection, serviceConnection);
            if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                boolean g5 = g(context, intent, serviceConnection, i5, executor);
                if (g5) {
                    return g5;
                }
                return false;
            } finally {
                this.f6879a.remove(serviceConnection, serviceConnection);
            }
        }
        return g(context, intent, serviceConnection, i5, executor);
    }

    private static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof l1);
    }

    private static final boolean g(Context context, Intent intent, ServiceConnection serviceConnection, int i5, Executor executor) {
        boolean bindService;
        if (executor == null) {
            executor = null;
        }
        if (!j.h() || executor == null) {
            return context.bindService(intent, serviceConnection, i5);
        }
        bindService = context.bindService(intent, i5, executor, serviceConnection);
        return bindService;
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        if (!f(serviceConnection) || !this.f6879a.containsKey(serviceConnection)) {
            d(context, serviceConnection);
            return;
        }
        try {
            d(context, (ServiceConnection) this.f6879a.get(serviceConnection));
        } finally {
            this.f6879a.remove(serviceConnection);
        }
    }

    @ResultIgnorabilityUnspecified
    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i5, Executor executor) {
        return e(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
