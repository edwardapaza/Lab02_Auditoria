package io.grpc.internal;

import i3.y0;
import io.grpc.internal.d;
import io.grpc.internal.o1;
import io.grpc.internal.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class a extends d implements s, o1.d {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f4335g = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final t2 f4336a;

    /* renamed from: b  reason: collision with root package name */
    private final r0 f4337b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4338c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4339d;

    /* renamed from: e  reason: collision with root package name */
    private i3.y0 f4340e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f4341f;

    /* renamed from: io.grpc.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0073a implements r0 {

        /* renamed from: a  reason: collision with root package name */
        private i3.y0 f4342a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4343b;

        /* renamed from: c  reason: collision with root package name */
        private final n2 f4344c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f4345d;

        public C0073a(i3.y0 y0Var, n2 n2Var) {
            this.f4342a = (i3.y0) z0.k.o(y0Var, "headers");
            this.f4344c = (n2) z0.k.o(n2Var, "statsTraceCtx");
        }

        @Override // io.grpc.internal.r0
        public r0 b(i3.n nVar) {
            return this;
        }

        @Override // io.grpc.internal.r0
        public void c(InputStream inputStream) {
            z0.k.u(this.f4345d == null, "writePayload should not be called multiple times");
            try {
                this.f4345d = b1.b.d(inputStream);
                this.f4344c.i(0);
                n2 n2Var = this.f4344c;
                byte[] bArr = this.f4345d;
                n2Var.j(0, bArr.length, bArr.length);
                this.f4344c.k(this.f4345d.length);
                this.f4344c.l(this.f4345d.length);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }

        @Override // io.grpc.internal.r0
        public void close() {
            this.f4343b = true;
            z0.k.u(this.f4345d != null, "Lack of request message. GET request is only supported for unary requests");
            a.this.u().c(this.f4342a, this.f4345d);
            this.f4345d = null;
            this.f4342a = null;
        }

        @Override // io.grpc.internal.r0
        public void e(int i5) {
        }

        @Override // io.grpc.internal.r0
        public void flush() {
        }

        @Override // io.grpc.internal.r0
        public boolean isClosed() {
            return this.f4343b;
        }
    }

    /* loaded from: classes.dex */
    protected interface b {
        void a(i3.j1 j1Var);

        void b(u2 u2Var, boolean z4, boolean z5, int i5);

        void c(i3.y0 y0Var, byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class c extends d.a {

        /* renamed from: i  reason: collision with root package name */
        private final n2 f4347i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f4348j;

        /* renamed from: k  reason: collision with root package name */
        private t f4349k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f4350l;

        /* renamed from: m  reason: collision with root package name */
        private i3.v f4351m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4352n;

        /* renamed from: o  reason: collision with root package name */
        private Runnable f4353o;

        /* renamed from: p  reason: collision with root package name */
        private volatile boolean f4354p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f4355q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f4356r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.grpc.internal.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0074a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.j1 f4357a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ t.a f4358b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ i3.y0 f4359c;

            RunnableC0074a(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
                this.f4357a = j1Var;
                this.f4358b = aVar;
                this.f4359c = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.C(this.f4357a, this.f4358b, this.f4359c);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public c(int i5, n2 n2Var, t2 t2Var) {
            super(i5, n2Var, t2Var);
            this.f4351m = i3.v.c();
            this.f4352n = false;
            this.f4347i = (n2) z0.k.o(n2Var, "statsTraceCtx");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            if (this.f4348j) {
                return;
            }
            this.f4348j = true;
            this.f4347i.m(j1Var);
            o().d(j1Var, aVar, y0Var);
            if (m() != null) {
                m().f(j1Var.o());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I(i3.v vVar) {
            z0.k.u(this.f4349k == null, "Already called start");
            this.f4351m = (i3.v) z0.k.o(vVar, "decompressorRegistry");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J(boolean z4) {
            this.f4350l = z4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void L() {
            this.f4354p = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void D(x1 x1Var) {
            z0.k.o(x1Var, "frame");
            try {
                if (!this.f4355q) {
                    l(x1Var);
                    return;
                }
                a.f4335g.log(Level.INFO, "Received data on closed stream");
                x1Var.close();
            } catch (Throwable th) {
                if (1 != 0) {
                    x1Var.close();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void E(i3.y0 r6) {
            /*
                r5 = this;
                boolean r0 = r5.f4355q
                r1 = 1
                r0 = r0 ^ r1
                java.lang.String r2 = "Received headers on closed stream"
                z0.k.u(r0, r2)
                io.grpc.internal.n2 r0 = r5.f4347i
                r0.a()
                i3.y0$g<java.lang.String> r0 = io.grpc.internal.t0.f5181g
                java.lang.Object r0 = r6.g(r0)
                java.lang.String r0 = (java.lang.String) r0
                boolean r2 = r5.f4350l
                r3 = 0
                if (r2 == 0) goto L4f
                if (r0 == 0) goto L4f
                java.lang.String r2 = "gzip"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 == 0) goto L2f
                io.grpc.internal.u0 r0 = new io.grpc.internal.u0
                r0.<init>()
                r5.w(r0)
                r0 = 1
                goto L50
            L2f:
                java.lang.String r2 = "identity"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 != 0) goto L4f
                i3.j1 r6 = i3.j1.f3446t
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r3] = r0
                java.lang.String r0 = "Can't find full stream decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r0, r1)
                i3.j1 r6 = r6.q(r0)
                i3.l1 r6 = r6.d()
                r5.b(r6)
                return
            L4f:
                r0 = 0
            L50:
                i3.y0$g<java.lang.String> r2 = io.grpc.internal.t0.f5179e
                java.lang.Object r2 = r6.g(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L93
                i3.v r4 = r5.f4351m
                i3.u r4 = r4.e(r2)
                if (r4 != 0) goto L7a
                i3.j1 r6 = i3.j1.f3446t
                java.lang.Object[] r0 = new java.lang.Object[r1]
                r0[r3] = r2
                java.lang.String r1 = "Can't find decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                i3.j1 r6 = r6.q(r0)
                i3.l1 r6 = r6.d()
                r5.b(r6)
                return
            L7a:
                i3.l r1 = i3.l.b.f3486a
                if (r4 == r1) goto L93
                if (r0 == 0) goto L90
                i3.j1 r6 = i3.j1.f3446t
                java.lang.String r0 = "Full stream and gRPC message encoding cannot both be set"
                i3.j1 r6 = r6.q(r0)
                i3.l1 r6 = r6.d()
                r5.b(r6)
                return
            L90:
                r5.v(r4)
            L93:
                io.grpc.internal.t r0 = r5.o()
                r0.c(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.a.c.E(i3.y0):void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void F(i3.y0 y0Var, i3.j1 j1Var) {
            z0.k.o(j1Var, "status");
            z0.k.o(y0Var, "trailers");
            if (this.f4355q) {
                a.f4335g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{j1Var, y0Var});
                return;
            }
            this.f4347i.b(y0Var);
            N(j1Var, false, y0Var);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean G() {
            return this.f4354p;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.d.a
        /* renamed from: H */
        public final t o() {
            return this.f4349k;
        }

        public final void K(t tVar) {
            z0.k.u(this.f4349k == null, "Already called setListener");
            this.f4349k = (t) z0.k.o(tVar, "listener");
        }

        public final void M(i3.j1 j1Var, t.a aVar, boolean z4, i3.y0 y0Var) {
            z0.k.o(j1Var, "status");
            z0.k.o(y0Var, "trailers");
            if (!this.f4355q || z4) {
                this.f4355q = true;
                this.f4356r = j1Var.o();
                s();
                if (this.f4352n) {
                    this.f4353o = null;
                    C(j1Var, aVar, y0Var);
                    return;
                }
                this.f4353o = new RunnableC0074a(j1Var, aVar, y0Var);
                k(z4);
            }
        }

        public final void N(i3.j1 j1Var, boolean z4, i3.y0 y0Var) {
            M(j1Var, t.a.PROCESSED, z4, y0Var);
        }

        @Override // io.grpc.internal.n1.b
        public void e(boolean z4) {
            z0.k.u(this.f4355q, "status should have been reported on deframer closed");
            this.f4352n = true;
            if (this.f4356r && z4) {
                N(i3.j1.f3446t.q("Encountered end-of-stream mid-frame"), true, new i3.y0());
            }
            Runnable runnable = this.f4353o;
            if (runnable != null) {
                runnable.run();
                this.f4353o = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(v2 v2Var, n2 n2Var, t2 t2Var, i3.y0 y0Var, i3.c cVar, boolean z4) {
        z0.k.o(y0Var, "headers");
        this.f4336a = (t2) z0.k.o(t2Var, "transportTracer");
        this.f4338c = t0.o(cVar);
        this.f4339d = z4;
        if (z4) {
            this.f4337b = new C0073a(y0Var, n2Var);
            return;
        }
        this.f4337b = new o1(this, v2Var, n2Var);
        this.f4340e = y0Var;
    }

    @Override // io.grpc.internal.s
    public final void a(i3.j1 j1Var) {
        z0.k.e(!j1Var.o(), "Should not cancel with OK status");
        this.f4341f = true;
        u().a(j1Var);
    }

    @Override // io.grpc.internal.s
    public void d(int i5) {
        t().x(i5);
    }

    @Override // io.grpc.internal.s
    public void e(int i5) {
        this.f4337b.e(i5);
    }

    @Override // io.grpc.internal.s
    public final void f(t tVar) {
        t().K(tVar);
        if (this.f4339d) {
            return;
        }
        u().c(this.f4340e, null);
        this.f4340e = null;
    }

    @Override // io.grpc.internal.s
    public void g(i3.t tVar) {
        i3.y0 y0Var = this.f4340e;
        y0.g<Long> gVar = t0.f5178d;
        y0Var.e(gVar);
        this.f4340e.p(gVar, Long.valueOf(Math.max(0L, tVar.o(TimeUnit.NANOSECONDS))));
    }

    @Override // io.grpc.internal.s
    public final void h(i3.v vVar) {
        t().I(vVar);
    }

    @Override // io.grpc.internal.d, io.grpc.internal.o2
    public final boolean i() {
        return super.i() && !this.f4341f;
    }

    @Override // io.grpc.internal.s
    public final void l(z0 z0Var) {
        z0Var.b("remote_addr", getAttributes().b(i3.b0.f3340a));
    }

    @Override // io.grpc.internal.s
    public final void n() {
        if (t().G()) {
            return;
        }
        t().L();
        q();
    }

    @Override // io.grpc.internal.o1.d
    public final void o(u2 u2Var, boolean z4, boolean z5, int i5) {
        z0.k.e(u2Var != null || z4, "null frame before EOS");
        u().b(u2Var, z4, z5, i5);
    }

    @Override // io.grpc.internal.s
    public final void p(boolean z4) {
        t().J(z4);
    }

    @Override // io.grpc.internal.d
    protected final r0 r() {
        return this.f4337b;
    }

    protected abstract b u();

    /* JADX INFO: Access modifiers changed from: protected */
    public t2 w() {
        return this.f4336a;
    }

    public final boolean x() {
        return this.f4338c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.d
    /* renamed from: y */
    public abstract c t();
}
