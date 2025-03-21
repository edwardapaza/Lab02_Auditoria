package io.grpc.internal;

import i3.f;
import i3.n1;
import io.grpc.internal.k;
import io.grpc.internal.m1;
import io.grpc.internal.t;
import io.grpc.internal.v;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 implements i3.i0<Object>, s2 {

    /* renamed from: a  reason: collision with root package name */
    private final i3.j0 f4361a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4362b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4363c;

    /* renamed from: d  reason: collision with root package name */
    private final k.a f4364d;

    /* renamed from: e  reason: collision with root package name */
    private final j f4365e;

    /* renamed from: f  reason: collision with root package name */
    private final v f4366f;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f4367g;

    /* renamed from: h  reason: collision with root package name */
    private final i3.d0 f4368h;

    /* renamed from: i  reason: collision with root package name */
    private final o f4369i;

    /* renamed from: j  reason: collision with root package name */
    private final q f4370j;

    /* renamed from: k  reason: collision with root package name */
    private final i3.f f4371k;

    /* renamed from: l  reason: collision with root package name */
    private final i3.n1 f4372l;

    /* renamed from: m  reason: collision with root package name */
    private final k f4373m;

    /* renamed from: n  reason: collision with root package name */
    private volatile List<i3.x> f4374n;

    /* renamed from: o  reason: collision with root package name */
    private io.grpc.internal.k f4375o;

    /* renamed from: p  reason: collision with root package name */
    private final z0.m f4376p;

    /* renamed from: q  reason: collision with root package name */
    private n1.d f4377q;

    /* renamed from: r  reason: collision with root package name */
    private n1.d f4378r;

    /* renamed from: s  reason: collision with root package name */
    private m1 f4379s;

    /* renamed from: v  reason: collision with root package name */
    private x f4382v;

    /* renamed from: w  reason: collision with root package name */
    private volatile m1 f4383w;

    /* renamed from: y  reason: collision with root package name */
    private i3.j1 f4385y;

    /* renamed from: t  reason: collision with root package name */
    private final Collection<x> f4380t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private final y0<x> f4381u = new a();

    /* renamed from: x  reason: collision with root package name */
    private volatile i3.q f4384x = i3.q.a(i3.p.IDLE);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y0<x> {
        a() {
        }

        @Override // io.grpc.internal.y0
        protected void b() {
            a1.this.f4365e.a(a1.this);
        }

        @Override // io.grpc.internal.y0
        protected void c() {
            a1.this.f4365e.b(a1.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.f4377q = null;
            a1.this.f4371k.a(f.a.INFO, "CONNECTING after backoff");
            a1.this.N(i3.p.CONNECTING);
            a1.this.T();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a1.this.f4384x.c() == i3.p.IDLE) {
                a1.this.f4371k.a(f.a.INFO, "CONNECTING as requested");
                a1.this.N(i3.p.CONNECTING);
                a1.this.T();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f4389a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m1 m1Var = a1.this.f4379s;
                a1.this.f4378r = null;
                a1.this.f4379s = null;
                m1Var.f(i3.j1.f3447u.q("InternalSubchannel closed transport due to address change"));
            }
        }

        d(List list) {
            this.f4389a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                io.grpc.internal.a1$k r0 = io.grpc.internal.a1.I(r0)
                java.net.SocketAddress r0 = r0.a()
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1$k r1 = io.grpc.internal.a1.I(r1)
                java.util.List r2 = r7.f4389a
                r1.h(r2)
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                java.util.List r2 = r7.f4389a
                io.grpc.internal.a1.J(r1, r2)
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                i3.q r1 = io.grpc.internal.a1.i(r1)
                i3.p r1 = r1.c()
                i3.p r2 = i3.p.READY
                r3 = 0
                if (r1 == r2) goto L39
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                i3.q r1 = io.grpc.internal.a1.i(r1)
                i3.p r1 = r1.c()
                i3.p r4 = i3.p.CONNECTING
                if (r1 != r4) goto L91
            L39:
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1$k r1 = io.grpc.internal.a1.I(r1)
                boolean r0 = r1.g(r0)
                if (r0 != 0) goto L91
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                i3.q r0 = io.grpc.internal.a1.i(r0)
                i3.p r0 = r0.c()
                if (r0 != r2) goto L6d
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                io.grpc.internal.m1 r0 = io.grpc.internal.a1.j(r0)
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1.k(r1, r3)
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1$k r1 = io.grpc.internal.a1.I(r1)
                r1.f()
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                i3.p r2 = i3.p.IDLE
                io.grpc.internal.a1.E(r1, r2)
                goto L92
            L6d:
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                io.grpc.internal.x r0 = io.grpc.internal.a1.l(r0)
                i3.j1 r1 = i3.j1.f3447u
                java.lang.String r2 = "InternalSubchannel closed pending transport due to address change"
                i3.j1 r1 = r1.q(r2)
                r0.f(r1)
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                io.grpc.internal.a1.m(r0, r3)
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                io.grpc.internal.a1$k r0 = io.grpc.internal.a1.I(r0)
                r0.f()
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                io.grpc.internal.a1.F(r0)
            L91:
                r0 = r3
            L92:
                if (r0 == 0) goto Le1
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                i3.n1$d r1 = io.grpc.internal.a1.n(r1)
                if (r1 == 0) goto Lc0
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.m1 r1 = io.grpc.internal.a1.p(r1)
                i3.j1 r2 = i3.j1.f3447u
                java.lang.String r4 = "InternalSubchannel closed transport early due to address change"
                i3.j1 r2 = r2.q(r4)
                r1.f(r2)
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                i3.n1$d r1 = io.grpc.internal.a1.n(r1)
                r1.a()
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1.o(r1, r3)
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1.q(r1, r3)
            Lc0:
                io.grpc.internal.a1 r1 = io.grpc.internal.a1.this
                io.grpc.internal.a1.q(r1, r0)
                io.grpc.internal.a1 r0 = io.grpc.internal.a1.this
                i3.n1 r1 = io.grpc.internal.a1.s(r0)
                io.grpc.internal.a1$d$a r2 = new io.grpc.internal.a1$d$a
                r2.<init>()
                r3 = 5
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
                io.grpc.internal.a1 r6 = io.grpc.internal.a1.this
                java.util.concurrent.ScheduledExecutorService r6 = io.grpc.internal.a1.r(r6)
                i3.n1$d r1 = r1.c(r2, r3, r5, r6)
                io.grpc.internal.a1.o(r0, r1)
            Le1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.a1.d.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.j1 f4392a;

        e(i3.j1 j1Var) {
            this.f4392a = j1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            i3.p c5 = a1.this.f4384x.c();
            i3.p pVar = i3.p.SHUTDOWN;
            if (c5 == pVar) {
                return;
            }
            a1.this.f4385y = this.f4392a;
            m1 m1Var = a1.this.f4383w;
            x xVar = a1.this.f4382v;
            a1.this.f4383w = null;
            a1.this.f4382v = null;
            a1.this.N(pVar);
            a1.this.f4373m.f();
            if (a1.this.f4380t.isEmpty()) {
                a1.this.P();
            }
            a1.this.K();
            if (a1.this.f4378r != null) {
                a1.this.f4378r.a();
                a1.this.f4379s.f(this.f4392a);
                a1.this.f4378r = null;
                a1.this.f4379s = null;
            }
            if (m1Var != null) {
                m1Var.f(this.f4392a);
            }
            if (xVar != null) {
                xVar.f(this.f4392a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.f4371k.a(f.a.INFO, "Terminated");
            a1.this.f4365e.d(a1.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f4395a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f4396b;

        g(x xVar, boolean z4) {
            this.f4395a = xVar;
            this.f4396b = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            a1.this.f4381u.e(this.f4395a, this.f4396b);
        }
    }

    /* loaded from: classes.dex */
    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.j1 f4398a;

        h(i3.j1 j1Var) {
            this.f4398a = j1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (m1 m1Var : new ArrayList(a1.this.f4380t)) {
                m1Var.h(this.f4398a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class i extends m0 {

        /* renamed from: a  reason: collision with root package name */
        private final x f4400a;

        /* renamed from: b  reason: collision with root package name */
        private final o f4401b;

        /* loaded from: classes.dex */
        class a extends k0 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s f4402a;

            /* renamed from: io.grpc.internal.a1$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0075a extends l0 {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ t f4404a;

                C0075a(t tVar) {
                    this.f4404a = tVar;
                }

                @Override // io.grpc.internal.l0, io.grpc.internal.t
                public void d(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
                    i.this.f4401b.a(j1Var.o());
                    super.d(j1Var, aVar, y0Var);
                }

                @Override // io.grpc.internal.l0
                protected t e() {
                    return this.f4404a;
                }
            }

            a(s sVar) {
                this.f4402a = sVar;
            }

            @Override // io.grpc.internal.k0, io.grpc.internal.s
            public void f(t tVar) {
                i.this.f4401b.b();
                super.f(new C0075a(tVar));
            }

            @Override // io.grpc.internal.k0
            protected s o() {
                return this.f4402a;
            }
        }

        private i(x xVar, o oVar) {
            this.f4400a = xVar;
            this.f4401b = oVar;
        }

        /* synthetic */ i(x xVar, o oVar, a aVar) {
            this(xVar, oVar);
        }

        @Override // io.grpc.internal.m0
        protected x a() {
            return this.f4400a;
        }

        @Override // io.grpc.internal.m0, io.grpc.internal.u
        public s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
            return new a(super.c(z0Var, y0Var, cVar, kVarArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class j {
        abstract void a(a1 a1Var);

        abstract void b(a1 a1Var);

        abstract void c(a1 a1Var, i3.q qVar);

        abstract void d(a1 a1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        private List<i3.x> f4406a;

        /* renamed from: b  reason: collision with root package name */
        private int f4407b;

        /* renamed from: c  reason: collision with root package name */
        private int f4408c;

        public k(List<i3.x> list) {
            this.f4406a = list;
        }

        public SocketAddress a() {
            return this.f4406a.get(this.f4407b).a().get(this.f4408c);
        }

        public i3.a b() {
            return this.f4406a.get(this.f4407b).b();
        }

        public void c() {
            int i5 = this.f4408c + 1;
            this.f4408c = i5;
            if (i5 >= this.f4406a.get(this.f4407b).a().size()) {
                this.f4407b++;
                this.f4408c = 0;
            }
        }

        public boolean d() {
            return this.f4407b == 0 && this.f4408c == 0;
        }

        public boolean e() {
            return this.f4407b < this.f4406a.size();
        }

        public void f() {
            this.f4407b = 0;
            this.f4408c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            for (int i5 = 0; i5 < this.f4406a.size(); i5++) {
                int indexOf = this.f4406a.get(i5).a().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.f4407b = i5;
                    this.f4408c = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List<i3.x> list) {
            this.f4406a = list;
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class l implements m1.a {

        /* renamed from: a  reason: collision with root package name */
        final x f4409a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4410b = false;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a1.this.f4375o = null;
                if (a1.this.f4385y != null) {
                    z0.k.u(a1.this.f4383w == null, "Unexpected non-null activeTransport");
                    l lVar = l.this;
                    lVar.f4409a.f(a1.this.f4385y);
                    return;
                }
                x xVar = a1.this.f4382v;
                l lVar2 = l.this;
                x xVar2 = lVar2.f4409a;
                if (xVar == xVar2) {
                    a1.this.f4383w = xVar2;
                    a1.this.f4382v = null;
                    a1.this.N(i3.p.READY);
                }
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.j1 f4413a;

            b(i3.j1 j1Var) {
                this.f4413a = j1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a1.this.f4384x.c() == i3.p.SHUTDOWN) {
                    return;
                }
                m1 m1Var = a1.this.f4383w;
                l lVar = l.this;
                if (m1Var == lVar.f4409a) {
                    a1.this.f4383w = null;
                    a1.this.f4373m.f();
                    a1.this.N(i3.p.IDLE);
                    return;
                }
                x xVar = a1.this.f4382v;
                l lVar2 = l.this;
                if (xVar == lVar2.f4409a) {
                    z0.k.w(a1.this.f4384x.c() == i3.p.CONNECTING, "Expected state is CONNECTING, actual state is %s", a1.this.f4384x.c());
                    a1.this.f4373m.c();
                    if (a1.this.f4373m.e()) {
                        a1.this.T();
                        return;
                    }
                    a1.this.f4382v = null;
                    a1.this.f4373m.f();
                    a1.this.S(this.f4413a);
                }
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a1.this.f4380t.remove(l.this.f4409a);
                if (a1.this.f4384x.c() == i3.p.SHUTDOWN && a1.this.f4380t.isEmpty()) {
                    a1.this.P();
                }
            }
        }

        l(x xVar) {
            this.f4409a = xVar;
        }

        @Override // io.grpc.internal.m1.a
        public void a() {
            z0.k.u(this.f4410b, "transportShutdown() must be called before transportTerminated().");
            a1.this.f4371k.b(f.a.INFO, "{0} Terminated", this.f4409a.e());
            a1.this.f4368h.i(this.f4409a);
            a1.this.Q(this.f4409a, false);
            a1.this.f4372l.execute(new c());
        }

        @Override // io.grpc.internal.m1.a
        public void b(boolean z4) {
            a1.this.Q(this.f4409a, z4);
        }

        @Override // io.grpc.internal.m1.a
        public void c() {
            a1.this.f4371k.a(f.a.INFO, "READY");
            a1.this.f4372l.execute(new a());
        }

        @Override // io.grpc.internal.m1.a
        public void d(i3.j1 j1Var) {
            a1.this.f4371k.b(f.a.INFO, "{0} SHUTDOWN with {1}", this.f4409a.e(), a1.this.R(j1Var));
            this.f4410b = true;
            a1.this.f4372l.execute(new b(j1Var));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class m extends i3.f {

        /* renamed from: a  reason: collision with root package name */
        i3.j0 f4416a;

        m() {
        }

        @Override // i3.f
        public void a(f.a aVar, String str) {
            p.d(this.f4416a, aVar, str);
        }

        @Override // i3.f
        public void b(f.a aVar, String str, Object... objArr) {
            p.e(this.f4416a, aVar, str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(List<i3.x> list, String str, String str2, k.a aVar, v vVar, ScheduledExecutorService scheduledExecutorService, z0.o<z0.m> oVar, i3.n1 n1Var, j jVar, i3.d0 d0Var, o oVar2, q qVar, i3.j0 j0Var, i3.f fVar) {
        z0.k.o(list, "addressGroups");
        z0.k.e(!list.isEmpty(), "addressGroups is empty");
        L(list, "addressGroups contains null entry");
        List<i3.x> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f4374n = unmodifiableList;
        this.f4373m = new k(unmodifiableList);
        this.f4362b = str;
        this.f4363c = str2;
        this.f4364d = aVar;
        this.f4366f = vVar;
        this.f4367g = scheduledExecutorService;
        this.f4376p = oVar.get();
        this.f4372l = n1Var;
        this.f4365e = jVar;
        this.f4368h = d0Var;
        this.f4369i = oVar2;
        this.f4370j = (q) z0.k.o(qVar, "channelTracer");
        this.f4361a = (i3.j0) z0.k.o(j0Var, "logId");
        this.f4371k = (i3.f) z0.k.o(fVar, "channelLogger");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.f4372l.e();
        n1.d dVar = this.f4377q;
        if (dVar != null) {
            dVar.a();
            this.f4377q = null;
            this.f4375o = null;
        }
    }

    private static void L(List<?> list, String str) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            z0.k.o(it.next(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(i3.p pVar) {
        this.f4372l.e();
        O(i3.q.a(pVar));
    }

    private void O(i3.q qVar) {
        this.f4372l.e();
        if (this.f4384x.c() != qVar.c()) {
            boolean z4 = this.f4384x.c() != i3.p.SHUTDOWN;
            z0.k.u(z4, "Cannot transition out of SHUTDOWN to " + qVar);
            this.f4384x = qVar;
            this.f4365e.c(this, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.f4372l.execute(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(x xVar, boolean z4) {
        this.f4372l.execute(new g(xVar, z4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String R(i3.j1 j1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(j1Var.m());
        if (j1Var.n() != null) {
            sb.append("(");
            sb.append(j1Var.n());
            sb.append(")");
        }
        if (j1Var.l() != null) {
            sb.append("[");
            sb.append(j1Var.l());
            sb.append("]");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(i3.j1 j1Var) {
        this.f4372l.e();
        O(i3.q.b(j1Var));
        if (this.f4375o == null) {
            this.f4375o = this.f4364d.get();
        }
        long a5 = this.f4375o.a();
        z0.m mVar = this.f4376p;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long d5 = a5 - mVar.d(timeUnit);
        this.f4371k.b(f.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", R(j1Var), Long.valueOf(d5));
        z0.k.u(this.f4377q == null, "previous reconnectTask is not done");
        this.f4377q = this.f4372l.c(new b(), d5, timeUnit, this.f4367g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        InetSocketAddress inetSocketAddress;
        i3.c0 c0Var;
        this.f4372l.e();
        z0.k.u(this.f4377q == null, "Should have no reconnectTask scheduled");
        if (this.f4373m.d()) {
            this.f4376p.f().g();
        }
        SocketAddress a5 = this.f4373m.a();
        if (a5 instanceof i3.c0) {
            c0Var = (i3.c0) a5;
            inetSocketAddress = c0Var.c();
        } else {
            inetSocketAddress = a5;
            c0Var = null;
        }
        i3.a b5 = this.f4373m.b();
        String str = (String) b5.b(i3.x.f3577d);
        v.a aVar = new v.a();
        if (str == null) {
            str = this.f4362b;
        }
        v.a g5 = aVar.e(str).f(b5).h(this.f4363c).g(c0Var);
        m mVar = new m();
        mVar.f4416a = e();
        i iVar = new i(this.f4366f.y(inetSocketAddress, g5, mVar), this.f4369i, null);
        mVar.f4416a = iVar.e();
        this.f4368h.c(iVar);
        this.f4382v = iVar;
        this.f4380t.add(iVar);
        Runnable b6 = iVar.b(new l(iVar));
        if (b6 != null) {
            this.f4372l.b(b6);
        }
        this.f4371k.b(f.a.INFO, "Started transport {0}", mVar.f4416a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3.p M() {
        return this.f4384x.c();
    }

    public void U(List<i3.x> list) {
        z0.k.o(list, "newAddressGroups");
        L(list, "newAddressGroups contains null entry");
        z0.k.e(!list.isEmpty(), "newAddressGroups is empty");
        this.f4372l.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // io.grpc.internal.s2
    public u a() {
        m1 m1Var = this.f4383w;
        if (m1Var != null) {
            return m1Var;
        }
        this.f4372l.execute(new c());
        return null;
    }

    @Override // i3.p0
    public i3.j0 e() {
        return this.f4361a;
    }

    public void f(i3.j1 j1Var) {
        this.f4372l.execute(new e(j1Var));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(i3.j1 j1Var) {
        f(j1Var);
        this.f4372l.execute(new h(j1Var));
    }

    public String toString() {
        return z0.f.b(this).c("logId", this.f4361a.d()).d("addressGroups", this.f4374n).toString();
    }
}
