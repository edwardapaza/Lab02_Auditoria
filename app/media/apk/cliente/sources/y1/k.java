package y1;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import y1.o;
/* loaded from: classes.dex */
public final class k implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8417a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f8418b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f8419c;

    /* renamed from: d  reason: collision with root package name */
    private final List<z1.n<o.a>> f8420d = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f8421a;

        a(AtomicBoolean atomicBoolean) {
            this.f8421a = atomicBoolean;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f8421a.compareAndSet(true, false)) {
                k.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (this.f8421a.compareAndSet(true, false)) {
                k.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f8421a.compareAndSet(true, false)) {
                k.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ComponentCallbacks2 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f8423a;

        b(AtomicBoolean atomicBoolean) {
            this.f8423a = atomicBoolean;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i5) {
            if (i5 == 20) {
                this.f8423a.set(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends ConnectivityManager.NetworkCallback {
        private c() {
        }

        /* synthetic */ c(k kVar, a aVar) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            k.this.k(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            k.this.k(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private boolean f8426a;

        private d() {
            this.f8426a = false;
        }

        /* synthetic */ d(k kVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k kVar;
            boolean z4;
            boolean h5 = k.this.h();
            if (!k.this.h() || this.f8426a) {
                if (!h5 && this.f8426a) {
                    kVar = k.this;
                    z4 = false;
                }
                this.f8426a = h5;
            }
            kVar = k.this;
            z4 = true;
            kVar.k(z4);
            this.f8426a = h5;
        }
    }

    public k(Context context) {
        z1.b.d(context != null, "Context must be non-null", new Object[0]);
        this.f8417a = context;
        this.f8418b = (ConnectivityManager) context.getSystemService("connectivity");
        f();
        g();
    }

    private void f() {
        Application application = (Application) this.f8417a.getApplicationContext();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        application.registerActivityLifecycleCallbacks(new a(atomicBoolean));
        application.registerComponentCallbacks(new b(atomicBoolean));
    }

    private void g() {
        Runnable runnable;
        if (Build.VERSION.SDK_INT < 24 || this.f8418b == null) {
            final d dVar = new d(this, null);
            this.f8417a.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            runnable = new Runnable() { // from class: y1.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.j(dVar);
                }
            };
        } else {
            final c cVar = new c(this, null);
            this.f8418b.registerDefaultNetworkCallback(cVar);
            runnable = new Runnable() { // from class: y1.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.i(cVar);
                }
            };
        }
        this.f8419c = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8417a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(c cVar) {
        this.f8418b.unregisterNetworkCallback(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(d dVar) {
        this.f8417a.unregisterReceiver(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z4) {
        synchronized (this.f8420d) {
            for (z1.n<o.a> nVar : this.f8420d) {
                nVar.accept(z4 ? o.a.REACHABLE : o.a.UNREACHABLE);
            }
        }
    }

    @Override // y1.o
    public void a(z1.n<o.a> nVar) {
        synchronized (this.f8420d) {
            this.f8420d.add(nVar);
        }
    }

    public void l() {
        z1.w.a("AndroidConnectivityMonitor", "App has entered the foreground.", new Object[0]);
        if (h()) {
            k(true);
        }
    }

    @Override // y1.o
    public void shutdown() {
        Runnable runnable = this.f8419c;
        if (runnable != null) {
            runnable.run();
            this.f8419c = null;
        }
    }
}
