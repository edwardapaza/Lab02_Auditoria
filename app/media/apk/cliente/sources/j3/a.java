package j3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import i3.g;
import i3.p;
import i3.u0;
import i3.v0;
import i3.w0;
import i3.y;
import i3.z0;
import java.util.concurrent.TimeUnit;
import z0.k;
/* loaded from: classes.dex */
public final class a extends y<a> {

    /* renamed from: c  reason: collision with root package name */
    private static final w0 f5518c = j();

    /* renamed from: a  reason: collision with root package name */
    private final v0<?> f5519a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5520b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends u0 {

        /* renamed from: a  reason: collision with root package name */
        private final u0 f5521a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f5522b;

        /* renamed from: c  reason: collision with root package name */
        private final ConnectivityManager f5523c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f5524d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Runnable f5525e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0081a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f5526a;

            RunnableC0081a(c cVar) {
                this.f5526a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f5523c.unregisterNetworkCallback(this.f5526a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j3.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0082b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f5528a;

            RunnableC0082b(d dVar) {
                this.f5528a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f5522b.unregisterReceiver(this.f5528a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class c extends ConnectivityManager.NetworkCallback {
            private c() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b.this.f5521a.j();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onBlockedStatusChanged(Network network, boolean z4) {
                if (z4) {
                    return;
                }
                b.this.f5521a.j();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class d extends BroadcastReceiver {

            /* renamed from: a  reason: collision with root package name */
            private boolean f5531a;

            private d() {
                this.f5531a = false;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z4 = this.f5531a;
                boolean z5 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.f5531a = z5;
                if (!z5 || z4) {
                    return;
                }
                b.this.f5521a.j();
            }
        }

        b(u0 u0Var, Context context) {
            this.f5521a = u0Var;
            this.f5522b = context;
            if (context == null) {
                this.f5523c = null;
                return;
            }
            this.f5523c = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                r();
            } catch (SecurityException e5) {
                Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e5);
            }
        }

        private void r() {
            Runnable runnableC0082b;
            if (Build.VERSION.SDK_INT < 24 || this.f5523c == null) {
                d dVar = new d();
                this.f5522b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                runnableC0082b = new RunnableC0082b(dVar);
            } else {
                c cVar = new c();
                this.f5523c.registerDefaultNetworkCallback(cVar);
                runnableC0082b = new RunnableC0081a(cVar);
            }
            this.f5525e = runnableC0082b;
        }

        private void s() {
            synchronized (this.f5524d) {
                Runnable runnable = this.f5525e;
                if (runnable != null) {
                    runnable.run();
                    this.f5525e = null;
                }
            }
        }

        @Override // i3.d
        public String a() {
            return this.f5521a.a();
        }

        @Override // i3.d
        public <RequestT, ResponseT> g<RequestT, ResponseT> d(z0<RequestT, ResponseT> z0Var, i3.c cVar) {
            return this.f5521a.d(z0Var, cVar);
        }

        @Override // i3.u0
        public boolean i(long j5, TimeUnit timeUnit) {
            return this.f5521a.i(j5, timeUnit);
        }

        @Override // i3.u0
        public void j() {
            this.f5521a.j();
        }

        @Override // i3.u0
        public p k(boolean z4) {
            return this.f5521a.k(z4);
        }

        @Override // i3.u0
        public void l(p pVar, Runnable runnable) {
            this.f5521a.l(pVar, runnable);
        }

        @Override // i3.u0
        public u0 m() {
            s();
            return this.f5521a.m();
        }

        @Override // i3.u0
        public u0 n() {
            s();
            return this.f5521a.n();
        }
    }

    private a(v0<?> v0Var) {
        this.f5519a = (v0) k.o(v0Var, "delegateBuilder");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x0035
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static i3.w0 j() {
        /*
            java.lang.String r0 = "AndroidChannelBuilder"
            r1 = 0
            java.lang.Class<k3.g> r2 = k3.g.class
            java.lang.Class<i3.w0> r3 = i3.w0.class
            java.lang.Class r2 = r2.asSubclass(r3)     // Catch: java.lang.ClassCastException -> L2e
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L27
            java.lang.reflect.Constructor r2 = r2.getConstructor(r4)     // Catch: java.lang.Exception -> L27
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L27
            java.lang.Object r2 = r2.newInstance(r3)     // Catch: java.lang.Exception -> L27
            i3.w0 r2 = (i3.w0) r2     // Catch: java.lang.Exception -> L27
            boolean r3 = i3.k0.a(r2)
            if (r3 != 0) goto L26
            java.lang.String r2 = "OkHttpChannelProvider.isAvailable() returned false"
            android.util.Log.w(r0, r2)
            return r1
        L26:
            return r2
        L27:
            r2 = move-exception
            java.lang.String r3 = "Failed to construct OkHttpChannelProvider"
            android.util.Log.w(r0, r3, r2)
            return r1
        L2e:
            r2 = move-exception
            java.lang.String r3 = "Couldn't cast OkHttpChannelProvider to ManagedChannelProvider"
            android.util.Log.w(r0, r3, r2)
            return r1
        L35:
            r2 = move-exception
            java.lang.String r3 = "Failed to find OkHttpChannelProvider"
            android.util.Log.w(r0, r3, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.a.j():i3.w0");
    }

    public static a k(v0<?> v0Var) {
        return new a(v0Var);
    }

    @Override // i3.v0
    public u0 a() {
        return new b(this.f5519a.a(), this.f5520b);
    }

    @Override // i3.y
    protected v0<?> e() {
        return this.f5519a;
    }

    public a i(Context context) {
        this.f5520b = context;
        return this;
    }
}
