package y1;

import i3.j1;
import i3.y0;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import y1.c;
import y1.u0;
import z1.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c<ReqT, RespT, CallbackT extends u0> {

    /* renamed from: n  reason: collision with root package name */
    private static final long f8363n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f8364o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f8365p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f8366q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f8367r;

    /* renamed from: a  reason: collision with root package name */
    private g.b f8368a;

    /* renamed from: b  reason: collision with root package name */
    private g.b f8369b;

    /* renamed from: c  reason: collision with root package name */
    private final z f8370c;

    /* renamed from: d  reason: collision with root package name */
    private final i3.z0<ReqT, RespT> f8371d;

    /* renamed from: f  reason: collision with root package name */
    private final z1.g f8373f;

    /* renamed from: g  reason: collision with root package name */
    private final g.d f8374g;

    /* renamed from: h  reason: collision with root package name */
    private final g.d f8375h;

    /* renamed from: k  reason: collision with root package name */
    private i3.g<ReqT, RespT> f8378k;

    /* renamed from: l  reason: collision with root package name */
    final z1.r f8379l;

    /* renamed from: m  reason: collision with root package name */
    final CallbackT f8380m;

    /* renamed from: i  reason: collision with root package name */
    private t0 f8376i = t0.Initial;

    /* renamed from: j  reason: collision with root package name */
    private long f8377j = 0;

    /* renamed from: e  reason: collision with root package name */
    private final c<ReqT, RespT, CallbackT>.b f8372e = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private final long f8381a;

        a(long j5) {
            this.f8381a = j5;
        }

        void a(Runnable runnable) {
            c.this.f8373f.w();
            if (c.this.f8377j == this.f8381a) {
                runnable.run();
            } else {
                z1.w.a(c.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130c implements k0<RespT> {

        /* renamed from: a  reason: collision with root package name */
        private final c<ReqT, RespT, CallbackT>.a f8384a;

        C0130c(c<ReqT, RespT, CallbackT>.a aVar) {
            this.f8384a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(j1 j1Var) {
            if (j1Var.o()) {
                z1.w.a(c.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(c.this)));
            } else {
                z1.w.e(c.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(c.this)), j1Var);
            }
            c.this.k(j1Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(i3.y0 y0Var) {
            if (z1.w.c()) {
                HashMap hashMap = new HashMap();
                for (String str : y0Var.j()) {
                    if (r.f8478e.contains(str.toLowerCase(Locale.ENGLISH))) {
                        hashMap.put(str, (String) y0Var.g(y0.g.e(str, i3.y0.f3588e)));
                    }
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                z1.w.a(c.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(c.this)), hashMap);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(Object obj) {
            if (z1.w.c()) {
                z1.w.a(c.this.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(c.this)), obj);
            }
            c.this.r(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            z1.w.a(c.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(c.this)));
            c.this.s();
        }

        @Override // y1.k0
        public void a() {
            this.f8384a.a(new Runnable() { // from class: y1.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0130c.this.l();
                }
            });
        }

        @Override // y1.k0
        public void b(final j1 j1Var) {
            this.f8384a.a(new Runnable() { // from class: y1.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0130c.this.i(j1Var);
                }
            });
        }

        @Override // y1.k0
        public void c(final i3.y0 y0Var) {
            this.f8384a.a(new Runnable() { // from class: y1.g
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0130c.this.j(y0Var);
                }
            });
        }

        @Override // y1.k0
        public void d(final RespT respt) {
            this.f8384a.a(new Runnable() { // from class: y1.f
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0130c.this.k(respt);
                }
            });
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f8363n = timeUnit.toMillis(1L);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        f8364o = timeUnit2.toMillis(1L);
        f8365p = timeUnit2.toMillis(1L);
        f8366q = timeUnit.toMillis(10L);
        f8367r = timeUnit.toMillis(10L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(z zVar, i3.z0<ReqT, RespT> z0Var, z1.g gVar, g.d dVar, g.d dVar2, g.d dVar3, CallbackT callbackt) {
        this.f8370c = zVar;
        this.f8371d = z0Var;
        this.f8373f = gVar;
        this.f8374g = dVar2;
        this.f8375h = dVar3;
        this.f8380m = callbackt;
        this.f8379l = new z1.r(gVar, dVar, f8363n, 1.5d, f8364o);
    }

    private void g() {
        g.b bVar = this.f8368a;
        if (bVar != null) {
            bVar.c();
            this.f8368a = null;
        }
    }

    private void h() {
        g.b bVar = this.f8369b;
        if (bVar != null) {
            bVar.c();
            this.f8369b = null;
        }
    }

    private void i(t0 t0Var, j1 j1Var) {
        z1.b.d(n(), "Only started streams should be closed.", new Object[0]);
        t0 t0Var2 = t0.Error;
        z1.b.d(t0Var == t0Var2 || j1Var.o(), "Can't provide an error when not in an error state.", new Object[0]);
        this.f8373f.w();
        if (r.j(j1Var)) {
            z1.h0.p(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", j1Var.l()));
        }
        h();
        g();
        this.f8379l.c();
        this.f8377j++;
        j1.b m5 = j1Var.m();
        if (m5 == j1.b.OK) {
            this.f8379l.f();
        } else if (m5 == j1.b.RESOURCE_EXHAUSTED) {
            z1.w.a(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.f8379l.g();
        } else if (m5 == j1.b.UNAUTHENTICATED && this.f8376i != t0.Healthy) {
            this.f8370c.h();
        } else if (m5 == j1.b.UNAVAILABLE && ((j1Var.l() instanceof UnknownHostException) || (j1Var.l() instanceof ConnectException))) {
            this.f8379l.h(f8367r);
        }
        if (t0Var != t0Var2) {
            z1.w.a(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            w();
        }
        if (this.f8378k != null) {
            if (j1Var.o()) {
                z1.w.a(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f8378k.b();
            }
            this.f8378k = null;
        }
        this.f8376i = t0Var;
        this.f8380m.b(j1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (m()) {
            i(t0.Initial, j1.f3432f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (m()) {
            this.f8376i = t0.Healthy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        t0 t0Var = this.f8376i;
        z1.b.d(t0Var == t0.Backoff, "State should still be backoff but was %s", t0Var);
        this.f8376i = t0.Initial;
        u();
        z1.b.d(n(), "Stream should have started", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f8376i = t0.Open;
        this.f8380m.a();
        if (this.f8368a == null) {
            this.f8368a = this.f8373f.k(this.f8375h, f8366q, new Runnable() { // from class: y1.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.o();
                }
            });
        }
    }

    private void t() {
        z1.b.d(this.f8376i == t0.Error, "Should only perform backoff in an error state", new Object[0]);
        this.f8376i = t0.Backoff;
        this.f8379l.b(new Runnable() { // from class: y1.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.p();
            }
        });
    }

    void k(j1 j1Var) {
        z1.b.d(n(), "Can't handle server close on non-started stream!", new Object[0]);
        i(t0.Error, j1Var);
    }

    public void l() {
        z1.b.d(!n(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f8373f.w();
        this.f8376i = t0.Initial;
        this.f8379l.f();
    }

    public boolean m() {
        this.f8373f.w();
        t0 t0Var = this.f8376i;
        return t0Var == t0.Open || t0Var == t0.Healthy;
    }

    public boolean n() {
        this.f8373f.w();
        t0 t0Var = this.f8376i;
        return t0Var == t0.Starting || t0Var == t0.Backoff || m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        if (m() && this.f8369b == null) {
            this.f8369b = this.f8373f.k(this.f8374g, f8365p, this.f8372e);
        }
    }

    public abstract void r(RespT respt);

    public void u() {
        this.f8373f.w();
        z1.b.d(this.f8378k == null, "Last call still set", new Object[0]);
        z1.b.d(this.f8369b == null, "Idle timer still set", new Object[0]);
        t0 t0Var = this.f8376i;
        if (t0Var == t0.Error) {
            t();
            return;
        }
        z1.b.d(t0Var == t0.Initial, "Already started", new Object[0]);
        this.f8378k = this.f8370c.m(this.f8371d, new C0130c(new a(this.f8377j)));
        this.f8376i = t0.Starting;
    }

    public void v() {
        if (n()) {
            i(t0.Initial, j1.f3432f);
        }
    }

    protected void w() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(ReqT reqt) {
        this.f8373f.w();
        z1.w.a(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        h();
        this.f8378k.d(reqt);
    }
}
