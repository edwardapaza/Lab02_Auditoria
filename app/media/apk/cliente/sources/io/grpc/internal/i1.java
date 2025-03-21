package io.grpc.internal;

import i3.a1;
import i3.e0;
import i3.f;
import i3.f0;
import i3.g;
import i3.k;
import i3.n1;
import i3.r0;
import io.grpc.internal.a1;
import io.grpc.internal.b2;
import io.grpc.internal.g0;
import io.grpc.internal.j;
import io.grpc.internal.k;
import io.grpc.internal.l1;
import io.grpc.internal.m1;
import io.grpc.internal.o;
import io.grpc.internal.r;
import java.lang.Thread;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i1 extends i3.u0 implements i3.i0<Object> {

    /* renamed from: l0  reason: collision with root package name */
    static final Logger f4791l0 = Logger.getLogger(i1.class.getName());

    /* renamed from: m0  reason: collision with root package name */
    static final Pattern f4792m0 = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* renamed from: n0  reason: collision with root package name */
    static final i3.j1 f4793n0;

    /* renamed from: o0  reason: collision with root package name */
    static final i3.j1 f4794o0;

    /* renamed from: p0  reason: collision with root package name */
    static final i3.j1 f4795p0;

    /* renamed from: q0  reason: collision with root package name */
    private static final l1 f4796q0;

    /* renamed from: r0  reason: collision with root package name */
    private static final i3.f0 f4797r0;

    /* renamed from: s0  reason: collision with root package name */
    private static final i3.g<Object, Object> f4798s0;
    private final i3.d A;
    private final String B;
    private i3.a1 C;
    private boolean D;
    private s E;
    private volatile r0.i F;
    private boolean G;
    private final Set<a1> H;
    private Collection<u.g<?, ?>> I;
    private final Object J;
    private final Set<s1> K;
    private final c0 L;
    private final y M;
    private final AtomicBoolean N;
    private boolean O;
    private boolean P;
    private volatile boolean Q;
    private final CountDownLatch R;
    private final o.b S;
    private final io.grpc.internal.o T;
    private final io.grpc.internal.q U;
    private final i3.f V;
    private final i3.d0 W;
    private final u X;
    private v Y;
    private l1 Z;

    /* renamed from: a  reason: collision with root package name */
    private final i3.j0 f4799a;

    /* renamed from: a0  reason: collision with root package name */
    private final l1 f4800a0;

    /* renamed from: b  reason: collision with root package name */
    private final String f4801b;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f4802b0;

    /* renamed from: c  reason: collision with root package name */
    private final String f4803c;

    /* renamed from: c0  reason: collision with root package name */
    private final boolean f4804c0;

    /* renamed from: d  reason: collision with root package name */
    private final i3.c1 f4805d;

    /* renamed from: d0  reason: collision with root package name */
    private final b2.t f4806d0;

    /* renamed from: e  reason: collision with root package name */
    private final a1.d f4807e;

    /* renamed from: e0  reason: collision with root package name */
    private final long f4808e0;

    /* renamed from: f  reason: collision with root package name */
    private final a1.b f4809f;

    /* renamed from: f0  reason: collision with root package name */
    private final long f4810f0;

    /* renamed from: g  reason: collision with root package name */
    private final io.grpc.internal.j f4811g;

    /* renamed from: g0  reason: collision with root package name */
    private final boolean f4812g0;

    /* renamed from: h  reason: collision with root package name */
    private final io.grpc.internal.v f4813h;

    /* renamed from: h0  reason: collision with root package name */
    private final m1.a f4814h0;

    /* renamed from: i  reason: collision with root package name */
    private final io.grpc.internal.v f4815i;

    /* renamed from: i0  reason: collision with root package name */
    final y0<Object> f4816i0;

    /* renamed from: j  reason: collision with root package name */
    private final io.grpc.internal.v f4817j;

    /* renamed from: j0  reason: collision with root package name */
    private final m f4818j0;

    /* renamed from: k  reason: collision with root package name */
    private final w f4819k;

    /* renamed from: k0  reason: collision with root package name */
    private final a2 f4820k0;

    /* renamed from: l  reason: collision with root package name */
    private final Executor f4821l;

    /* renamed from: m  reason: collision with root package name */
    private final r1<? extends Executor> f4822m;

    /* renamed from: n  reason: collision with root package name */
    private final r1<? extends Executor> f4823n;

    /* renamed from: o  reason: collision with root package name */
    private final p f4824o;

    /* renamed from: p  reason: collision with root package name */
    private final p f4825p;

    /* renamed from: q  reason: collision with root package name */
    private final q2 f4826q;

    /* renamed from: r  reason: collision with root package name */
    private final int f4827r;

    /* renamed from: s  reason: collision with root package name */
    final i3.n1 f4828s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4829t;

    /* renamed from: u  reason: collision with root package name */
    private final i3.v f4830u;

    /* renamed from: v  reason: collision with root package name */
    private final i3.o f4831v;

    /* renamed from: w  reason: collision with root package name */
    private final z0.o<z0.m> f4832w;

    /* renamed from: x  reason: collision with root package name */
    private final long f4833x;

    /* renamed from: y  reason: collision with root package name */
    private final io.grpc.internal.y f4834y;

    /* renamed from: z  reason: collision with root package name */
    private final k.a f4835z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends i3.f0 {
        a() {
        }

        @Override // i3.f0
        public f0.b a(r0.f fVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i1.this.v0(true);
        }
    }

    /* loaded from: classes.dex */
    final class c implements o.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q2 f4837a;

        c(q2 q2Var) {
            this.f4837a = q2Var;
        }

        @Override // io.grpc.internal.o.b
        public io.grpc.internal.o a() {
            return new io.grpc.internal.o(this.f4837a);
        }
    }

    /* loaded from: classes.dex */
    final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f4839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i3.p f4840b;

        d(Runnable runnable, i3.p pVar) {
            this.f4839a = runnable;
            this.f4840b = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i1.this.f4834y.c(this.f4839a, i1.this.f4821l, this.f4840b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class e extends r0.i {

        /* renamed from: a  reason: collision with root package name */
        private final r0.e f4842a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f4843b;

        e(Throwable th) {
            this.f4843b = th;
            this.f4842a = r0.e.e(i3.j1.f3446t.q("Panic! This is a bug!").p(th));
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return this.f4842a;
        }

        public String toString() {
            return z0.f.a(e.class).d("panicPickResult", this.f4842a).toString();
        }
    }

    /* loaded from: classes.dex */
    final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i1.this.N.get() || i1.this.E == null) {
                return;
            }
            i1.this.v0(false);
            i1.this.w0();
        }
    }

    /* loaded from: classes.dex */
    final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i1.this.x0();
            if (i1.this.F != null) {
                i1.this.F.b();
            }
            if (i1.this.E != null) {
                i1.this.E.f4869a.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i1.this.V.a(f.a.INFO, "Entering SHUTDOWN state");
            i1.this.f4834y.b(i3.p.SHUTDOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i1.this.O) {
                return;
            }
            i1.this.O = true;
            i1.this.B0();
        }
    }

    /* loaded from: classes.dex */
    class j implements Thread.UncaughtExceptionHandler {
        j() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Logger logger = i1.f4791l0;
            Level level = Level.SEVERE;
            logger.log(level, "[" + i1.this.e() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            i1.this.D0(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends p0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4850b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(i3.a1 a1Var, String str) {
            super(a1Var);
            this.f4850b = str;
        }

        @Override // io.grpc.internal.p0, i3.a1
        public String a() {
            return this.f4850b;
        }
    }

    /* loaded from: classes.dex */
    class l extends i3.g<Object, Object> {
        l() {
        }

        @Override // i3.g
        public void a(String str, Throwable th) {
        }

        @Override // i3.g
        public void b() {
        }

        @Override // i3.g
        public void c(int i5) {
        }

        @Override // i3.g
        public void d(Object obj) {
        }

        @Override // i3.g
        public void e(g.a<Object> aVar, i3.y0 y0Var) {
        }
    }

    /* loaded from: classes.dex */
    private final class m implements r.e {

        /* renamed from: a  reason: collision with root package name */
        volatile b2.d0 f4851a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i1.this.x0();
            }
        }

        /* loaded from: classes.dex */
        final class b<ReqT> extends b2<ReqT> {
            final /* synthetic */ i3.z0 E;
            final /* synthetic */ i3.y0 F;
            final /* synthetic */ i3.c G;
            final /* synthetic */ c2 H;
            final /* synthetic */ v0 I;
            final /* synthetic */ i3.r J;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(i3.z0 z0Var, i3.y0 y0Var, i3.c cVar, c2 c2Var, v0 v0Var, i3.r rVar) {
                super(z0Var, y0Var, i1.this.f4806d0, i1.this.f4808e0, i1.this.f4810f0, i1.this.y0(cVar), i1.this.f4815i.R(), c2Var, v0Var, m.this.f4851a);
                this.E = z0Var;
                this.F = y0Var;
                this.G = cVar;
                this.H = c2Var;
                this.I = v0Var;
                this.J = rVar;
            }

            @Override // io.grpc.internal.b2
            io.grpc.internal.s i0(i3.y0 y0Var, k.a aVar, int i5, boolean z4) {
                i3.c r5 = this.G.r(aVar);
                i3.k[] f5 = t0.f(r5, y0Var, i5, z4);
                io.grpc.internal.u c5 = m.this.c(new v1(this.E, y0Var, r5));
                i3.r b5 = this.J.b();
                try {
                    return c5.c(this.E, y0Var, r5, f5);
                } finally {
                    this.J.f(b5);
                }
            }

            @Override // io.grpc.internal.b2
            void j0() {
                i1.this.M.d(this);
            }

            @Override // io.grpc.internal.b2
            i3.j1 k0() {
                return i1.this.M.a(this);
            }
        }

        private m() {
        }

        /* synthetic */ m(i1 i1Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public io.grpc.internal.u c(r0.f fVar) {
            r0.i iVar = i1.this.F;
            if (!i1.this.N.get()) {
                if (iVar == null) {
                    i1.this.f4828s.execute(new a());
                } else {
                    io.grpc.internal.u j5 = t0.j(iVar.a(fVar), fVar.a().j());
                    if (j5 != null) {
                        return j5;
                    }
                }
            }
            return i1.this.L;
        }

        @Override // io.grpc.internal.r.e
        public io.grpc.internal.s a(i3.z0<?, ?> z0Var, i3.c cVar, i3.y0 y0Var, i3.r rVar) {
            if (i1.this.f4812g0) {
                l1.b bVar = (l1.b) cVar.h(l1.b.f4995g);
                return new b(z0Var, y0Var, cVar, bVar == null ? null : bVar.f5000e, bVar != null ? bVar.f5001f : null, rVar);
            }
            io.grpc.internal.u c5 = c(new v1(z0Var, y0Var, cVar));
            i3.r b5 = rVar.b();
            try {
                return c5.c(z0Var, y0Var, cVar, t0.f(cVar, y0Var, 0, false));
            } finally {
                rVar.f(b5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class n<ReqT, RespT> extends i3.z<ReqT, RespT> {

        /* renamed from: a  reason: collision with root package name */
        private final i3.f0 f4854a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.d f4855b;

        /* renamed from: c  reason: collision with root package name */
        private final Executor f4856c;

        /* renamed from: d  reason: collision with root package name */
        private final i3.z0<ReqT, RespT> f4857d;

        /* renamed from: e  reason: collision with root package name */
        private final i3.r f4858e;

        /* renamed from: f  reason: collision with root package name */
        private i3.c f4859f;

        /* renamed from: g  reason: collision with root package name */
        private i3.g<ReqT, RespT> f4860g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ g.a f4861b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ i3.j1 f4862c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g.a aVar, i3.j1 j1Var) {
                super(n.this.f4858e);
                this.f4861b = aVar;
                this.f4862c = j1Var;
            }

            @Override // io.grpc.internal.z
            public void a() {
                this.f4861b.a(this.f4862c, new i3.y0());
            }
        }

        n(i3.f0 f0Var, i3.d dVar, Executor executor, i3.z0<ReqT, RespT> z0Var, i3.c cVar) {
            this.f4854a = f0Var;
            this.f4855b = dVar;
            this.f4857d = z0Var;
            executor = cVar.e() != null ? cVar.e() : executor;
            this.f4856c = executor;
            this.f4859f = cVar.n(executor);
            this.f4858e = i3.r.e();
        }

        private void h(g.a<RespT> aVar, i3.j1 j1Var) {
            this.f4856c.execute(new a(aVar, j1Var));
        }

        @Override // i3.z, i3.d1, i3.g
        public void a(String str, Throwable th) {
            i3.g<ReqT, RespT> gVar = this.f4860g;
            if (gVar != null) {
                gVar.a(str, th);
            }
        }

        @Override // i3.z, i3.g
        public void e(g.a<RespT> aVar, i3.y0 y0Var) {
            f0.b a5 = this.f4854a.a(new v1(this.f4857d, y0Var, this.f4859f));
            i3.j1 c5 = a5.c();
            if (!c5.o()) {
                h(aVar, t0.n(c5));
                this.f4860g = i1.f4798s0;
                return;
            }
            i3.h b5 = a5.b();
            l1.b f5 = ((l1) a5.a()).f(this.f4857d);
            if (f5 != null) {
                this.f4859f = this.f4859f.q(l1.b.f4995g, f5);
            }
            this.f4860g = b5 != null ? b5.a(this.f4857d, this.f4859f, this.f4855b) : this.f4855b.d(this.f4857d, this.f4859f);
            this.f4860g.e(aVar, y0Var);
        }

        @Override // i3.z, i3.d1
        protected i3.g<ReqT, RespT> f() {
            return this.f4860g;
        }
    }

    /* loaded from: classes.dex */
    private final class o implements m1.a {
        private o() {
        }

        /* synthetic */ o(i1 i1Var, a aVar) {
            this();
        }

        @Override // io.grpc.internal.m1.a
        public void a() {
            z0.k.u(i1.this.N.get(), "Channel must have been shut down");
            i1.this.P = true;
            i1.this.H0(false);
            i1.this.B0();
            i1.this.C0();
        }

        @Override // io.grpc.internal.m1.a
        public void b(boolean z4) {
            i1 i1Var = i1.this;
            i1Var.f4816i0.e(i1Var.L, z4);
        }

        @Override // io.grpc.internal.m1.a
        public void c() {
        }

        @Override // io.grpc.internal.m1.a
        public void d(i3.j1 j1Var) {
            z0.k.u(i1.this.N.get(), "Channel must have been shut down");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class p implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final r1<? extends Executor> f4865a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f4866b;

        p(r1<? extends Executor> r1Var) {
            this.f4865a = (r1) z0.k.o(r1Var, "executorPool");
        }

        synchronized Executor a() {
            if (this.f4866b == null) {
                this.f4866b = (Executor) z0.k.p(this.f4865a.a(), "%s.getObject()", this.f4866b);
            }
            return this.f4866b;
        }

        synchronized void b() {
            Executor executor = this.f4866b;
            if (executor != null) {
                this.f4866b = this.f4865a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    /* loaded from: classes.dex */
    private final class q extends y0<Object> {
        private q() {
        }

        /* synthetic */ q(i1 i1Var, a aVar) {
            this();
        }

        @Override // io.grpc.internal.y0
        protected void b() {
            i1.this.x0();
        }

        @Override // io.grpc.internal.y0
        protected void c() {
            if (i1.this.N.get()) {
                return;
            }
            i1.this.F0();
        }
    }

    /* loaded from: classes.dex */
    private class r implements Runnable {
        private r() {
        }

        /* synthetic */ r(i1 i1Var, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i1.this.E == null) {
                return;
            }
            i1.this.w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class s extends r0.d {

        /* renamed from: a  reason: collision with root package name */
        j.b f4869a;

        /* loaded from: classes.dex */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i1.this.E0();
            }
        }

        /* loaded from: classes.dex */
        final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ r0.i f4872a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ i3.p f4873b;

            b(r0.i iVar, i3.p pVar) {
                this.f4872a = iVar;
                this.f4873b = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                s sVar = s.this;
                if (sVar != i1.this.E) {
                    return;
                }
                i1.this.J0(this.f4872a);
                if (this.f4873b != i3.p.SHUTDOWN) {
                    i1.this.V.b(f.a.INFO, "Entering {0} state with picker: {1}", this.f4873b, this.f4872a);
                    i1.this.f4834y.b(this.f4873b);
                }
            }
        }

        private s() {
        }

        /* synthetic */ s(i1 i1Var, a aVar) {
            this();
        }

        @Override // i3.r0.d
        public i3.f b() {
            return i1.this.V;
        }

        @Override // i3.r0.d
        public ScheduledExecutorService c() {
            return i1.this.f4819k;
        }

        @Override // i3.r0.d
        public i3.n1 d() {
            return i1.this.f4828s;
        }

        @Override // i3.r0.d
        public void e() {
            i1.this.f4828s.e();
            i1.this.f4828s.execute(new a());
        }

        @Override // i3.r0.d
        public void f(i3.p pVar, r0.i iVar) {
            i1.this.f4828s.e();
            z0.k.o(pVar, "newState");
            z0.k.o(iVar, "newPicker");
            i1.this.f4828s.execute(new b(iVar, pVar));
        }

        @Override // i3.r0.d
        /* renamed from: g */
        public io.grpc.internal.e a(r0.b bVar) {
            i1.this.f4828s.e();
            z0.k.u(!i1.this.P, "Channel is being terminated");
            return new x(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class t extends a1.e {

        /* renamed from: a  reason: collision with root package name */
        final s f4875a;

        /* renamed from: b  reason: collision with root package name */
        final i3.a1 f4876b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.j1 f4878a;

            a(i3.j1 j1Var) {
                this.f4878a = j1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                t.this.e(this.f4878a);
            }
        }

        /* loaded from: classes.dex */
        final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a1.g f4880a;

            b(a1.g gVar) {
                this.f4880a = gVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:50:0x0191  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 586
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.i1.t.b.run():void");
            }
        }

        t(s sVar, i3.a1 a1Var) {
            this.f4875a = (s) z0.k.o(sVar, "helperImpl");
            this.f4876b = (i3.a1) z0.k.o(a1Var, "resolver");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(i3.j1 j1Var) {
            i1.f4791l0.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{i1.this.e(), j1Var});
            i1.this.X.m();
            v vVar = i1.this.Y;
            v vVar2 = v.ERROR;
            if (vVar != vVar2) {
                i1.this.V.b(f.a.WARNING, "Failed to resolve name: {0}", j1Var);
                i1.this.Y = vVar2;
            }
            if (this.f4875a != i1.this.E) {
                return;
            }
            this.f4875a.f4869a.b(j1Var);
        }

        @Override // i3.a1.e, i3.a1.f
        public void a(i3.j1 j1Var) {
            z0.k.e(!j1Var.o(), "the error status must not be OK");
            i1.this.f4828s.execute(new a(j1Var));
        }

        @Override // i3.a1.e
        public void c(a1.g gVar) {
            i1.this.f4828s.execute(new b(gVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class u extends i3.d {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<i3.f0> f4882a;

        /* renamed from: b  reason: collision with root package name */
        private final String f4883b;

        /* renamed from: c  reason: collision with root package name */
        private final i3.d f4884c;

        /* loaded from: classes.dex */
        class a extends i3.d {
            a() {
            }

            @Override // i3.d
            public String a() {
                return u.this.f4883b;
            }

            @Override // i3.d
            public <RequestT, ResponseT> i3.g<RequestT, ResponseT> d(i3.z0<RequestT, ResponseT> z0Var, i3.c cVar) {
                return new io.grpc.internal.r(z0Var, i1.this.y0(cVar), cVar, i1.this.f4818j0, i1.this.Q ? null : i1.this.f4815i.R(), i1.this.T, null).C(i1.this.f4829t).B(i1.this.f4830u).A(i1.this.f4831v);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i1.this.I == null) {
                    if (u.this.f4882a.get() == i1.f4797r0) {
                        u.this.f4882a.set(null);
                    }
                    i1.this.M.b(i1.f4794o0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f4882a.get() == i1.f4797r0) {
                    u.this.f4882a.set(null);
                }
                if (i1.this.I != null) {
                    for (g gVar : i1.this.I) {
                        gVar.a("Channel is forcefully shutdown", null);
                    }
                }
                i1.this.M.c(i1.f4793n0);
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i1.this.x0();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
        /* loaded from: classes.dex */
        class e<ReqT, RespT> extends i3.g<ReqT, RespT> {
            e() {
            }

            @Override // i3.g
            public void a(String str, Throwable th) {
            }

            @Override // i3.g
            public void b() {
            }

            @Override // i3.g
            public void c(int i5) {
            }

            @Override // i3.g
            public void d(ReqT reqt) {
            }

            @Override // i3.g
            public void e(g.a<RespT> aVar, i3.y0 y0Var) {
                aVar.a(i1.f4794o0, new i3.y0());
            }
        }

        /* loaded from: classes.dex */
        class f implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f4891a;

            f(g gVar) {
                this.f4891a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (u.this.f4882a.get() != i1.f4797r0) {
                    this.f4891a.r();
                    return;
                }
                if (i1.this.I == null) {
                    i1.this.I = new LinkedHashSet();
                    i1 i1Var = i1.this;
                    i1Var.f4816i0.e(i1Var.J, true);
                }
                i1.this.I.add(this.f4891a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public final class g<ReqT, RespT> extends b0<ReqT, RespT> {

            /* renamed from: l  reason: collision with root package name */
            final i3.r f4893l;

            /* renamed from: m  reason: collision with root package name */
            final i3.z0<ReqT, RespT> f4894m;

            /* renamed from: n  reason: collision with root package name */
            final i3.c f4895n;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public class a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Runnable f4897a;

                a(Runnable runnable) {
                    this.f4897a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f4897a.run();
                    g gVar = g.this;
                    i1.this.f4828s.execute(new b());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes.dex */
            public final class b implements Runnable {
                b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i1.this.I != null) {
                        i1.this.I.remove(g.this);
                        if (i1.this.I.isEmpty()) {
                            i1 i1Var = i1.this;
                            i1Var.f4816i0.e(i1Var.J, false);
                            i1.this.I = null;
                            if (i1.this.N.get()) {
                                i1.this.M.b(i1.f4794o0);
                            }
                        }
                    }
                }
            }

            g(i3.r rVar, i3.z0<ReqT, RespT> z0Var, i3.c cVar) {
                super(i1.this.y0(cVar), i1.this.f4819k, cVar.d());
                this.f4893l = rVar;
                this.f4894m = z0Var;
                this.f4895n = cVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.grpc.internal.b0
            public void j() {
                super.j();
                i1.this.f4828s.execute(new b());
            }

            void r() {
                i3.r b5 = this.f4893l.b();
                try {
                    i3.g<ReqT, RespT> l5 = u.this.l(this.f4894m, this.f4895n.q(i3.k.f3476a, Boolean.TRUE));
                    this.f4893l.f(b5);
                    Runnable p5 = p(l5);
                    if (p5 == null) {
                        i1.this.f4828s.execute(new b());
                    } else {
                        i1.this.y0(this.f4895n).execute(new a(p5));
                    }
                } catch (Throwable th) {
                    this.f4893l.f(b5);
                    throw th;
                }
            }
        }

        private u(String str) {
            this.f4882a = new AtomicReference<>(i1.f4797r0);
            this.f4884c = new a();
            this.f4883b = (String) z0.k.o(str, "authority");
        }

        /* synthetic */ u(i1 i1Var, String str, a aVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> i3.g<ReqT, RespT> l(i3.z0<ReqT, RespT> z0Var, i3.c cVar) {
            i3.f0 f0Var = this.f4882a.get();
            if (f0Var != null) {
                if (!(f0Var instanceof l1.c)) {
                    return new n(f0Var, this.f4884c, i1.this.f4821l, z0Var, cVar);
                }
                l1.b f5 = ((l1.c) f0Var).f5002b.f(z0Var);
                if (f5 != null) {
                    cVar = cVar.q(l1.b.f4995g, f5);
                }
            }
            return this.f4884c.d(z0Var, cVar);
        }

        @Override // i3.d
        public String a() {
            return this.f4883b;
        }

        @Override // i3.d
        public <ReqT, RespT> i3.g<ReqT, RespT> d(i3.z0<ReqT, RespT> z0Var, i3.c cVar) {
            if (this.f4882a.get() != i1.f4797r0) {
                return l(z0Var, cVar);
            }
            i1.this.f4828s.execute(new d());
            if (this.f4882a.get() != i1.f4797r0) {
                return l(z0Var, cVar);
            }
            if (i1.this.N.get()) {
                return new e();
            }
            g gVar = new g(i3.r.e(), z0Var, cVar);
            i1.this.f4828s.execute(new f(gVar));
            return gVar;
        }

        void m() {
            if (this.f4882a.get() == i1.f4797r0) {
                p(null);
            }
        }

        void n() {
            i1.this.f4828s.execute(new b());
        }

        void o() {
            i1.this.f4828s.execute(new c());
        }

        void p(i3.f0 f0Var) {
            i3.f0 f0Var2 = this.f4882a.get();
            this.f4882a.set(f0Var);
            if (f0Var2 != i1.f4797r0 || i1.this.I == null) {
                return;
            }
            for (g gVar : i1.this.I) {
                gVar.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum v {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* loaded from: classes.dex */
    private static final class w implements ScheduledExecutorService {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f4904a;

        private w(ScheduledExecutorService scheduledExecutorService) {
            this.f4904a = (ScheduledExecutorService) z0.k.o(scheduledExecutorService, "delegate");
        }

        /* synthetic */ w(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j5, TimeUnit timeUnit) {
            return this.f4904a.awaitTermination(j5, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f4904a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.f4904a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
            return this.f4904a.invokeAll(collection, j5, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return (T) this.f4904a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
            return (T) this.f4904a.invokeAny(collection, j5, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f4904a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f4904a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j5, TimeUnit timeUnit) {
            return this.f4904a.schedule(runnable, j5, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j5, TimeUnit timeUnit) {
            return this.f4904a.schedule(callable, j5, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
            return this.f4904a.scheduleAtFixedRate(runnable, j5, j6, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
            return this.f4904a.scheduleWithFixedDelay(runnable, j5, j6, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.f4904a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t5) {
            return this.f4904a.submit(runnable, t5);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.f4904a.submit(callable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class x extends io.grpc.internal.e {

        /* renamed from: a  reason: collision with root package name */
        final r0.b f4905a;

        /* renamed from: b  reason: collision with root package name */
        final i3.j0 f4906b;

        /* renamed from: c  reason: collision with root package name */
        final io.grpc.internal.p f4907c;

        /* renamed from: d  reason: collision with root package name */
        final io.grpc.internal.q f4908d;

        /* renamed from: e  reason: collision with root package name */
        List<i3.x> f4909e;

        /* renamed from: f  reason: collision with root package name */
        a1 f4910f;

        /* renamed from: g  reason: collision with root package name */
        boolean f4911g;

        /* renamed from: h  reason: collision with root package name */
        boolean f4912h;

        /* renamed from: i  reason: collision with root package name */
        n1.d f4913i;

        /* loaded from: classes.dex */
        final class a extends a1.j {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ r0.j f4915a;

            a(r0.j jVar) {
                this.f4915a = jVar;
            }

            @Override // io.grpc.internal.a1.j
            void a(a1 a1Var) {
                i1.this.f4816i0.e(a1Var, true);
            }

            @Override // io.grpc.internal.a1.j
            void b(a1 a1Var) {
                i1.this.f4816i0.e(a1Var, false);
            }

            @Override // io.grpc.internal.a1.j
            void c(a1 a1Var, i3.q qVar) {
                z0.k.u(this.f4915a != null, "listener is null");
                this.f4915a.a(qVar);
            }

            @Override // io.grpc.internal.a1.j
            void d(a1 a1Var) {
                i1.this.H.remove(a1Var);
                i1.this.W.k(a1Var);
                i1.this.C0();
            }
        }

        /* loaded from: classes.dex */
        final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                x.this.f4910f.f(i1.f4795p0);
            }
        }

        x(r0.b bVar) {
            z0.k.o(bVar, "args");
            this.f4909e = bVar.a();
            if (i1.this.f4803c != null) {
                bVar = bVar.d().e(j(bVar.a())).b();
            }
            this.f4905a = bVar;
            i3.j0 b5 = i3.j0.b("Subchannel", i1.this.a());
            this.f4906b = b5;
            int i5 = i1.this.f4827r;
            long a5 = i1.this.f4826q.a();
            io.grpc.internal.q qVar = new io.grpc.internal.q(b5, i5, a5, "Subchannel for " + bVar.a());
            this.f4908d = qVar;
            this.f4907c = new io.grpc.internal.p(qVar, i1.this.f4826q);
        }

        private List<i3.x> j(List<i3.x> list) {
            ArrayList arrayList = new ArrayList();
            for (i3.x xVar : list) {
                arrayList.add(new i3.x(xVar.a(), xVar.b().d().c(i3.x.f3577d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override // i3.r0.h
        public List<i3.x> b() {
            i1.this.f4828s.e();
            z0.k.u(this.f4911g, "not started");
            return this.f4909e;
        }

        @Override // i3.r0.h
        public i3.a c() {
            return this.f4905a.b();
        }

        @Override // i3.r0.h
        public i3.f d() {
            return this.f4907c;
        }

        @Override // i3.r0.h
        public Object e() {
            z0.k.u(this.f4911g, "Subchannel is not started");
            return this.f4910f;
        }

        @Override // i3.r0.h
        public void f() {
            i1.this.f4828s.e();
            z0.k.u(this.f4911g, "not started");
            this.f4910f.a();
        }

        @Override // i3.r0.h
        public void g() {
            n1.d dVar;
            i1.this.f4828s.e();
            if (this.f4910f == null) {
                this.f4912h = true;
                return;
            }
            if (!this.f4912h) {
                this.f4912h = true;
            } else if (!i1.this.P || (dVar = this.f4913i) == null) {
                return;
            } else {
                dVar.a();
                this.f4913i = null;
            }
            if (i1.this.P) {
                this.f4910f.f(i1.f4794o0);
            } else {
                this.f4913i = i1.this.f4828s.c(new f1(new b()), 5L, TimeUnit.SECONDS, i1.this.f4815i.R());
            }
        }

        @Override // i3.r0.h
        public void h(r0.j jVar) {
            i1.this.f4828s.e();
            z0.k.u(!this.f4911g, "already started");
            z0.k.u(!this.f4912h, "already shutdown");
            z0.k.u(!i1.this.P, "Channel is being terminated");
            this.f4911g = true;
            a1 a1Var = new a1(this.f4905a.a(), i1.this.a(), i1.this.B, i1.this.f4835z, i1.this.f4815i, i1.this.f4815i.R(), i1.this.f4832w, i1.this.f4828s, new a(jVar), i1.this.W, i1.this.S.a(), this.f4908d, this.f4906b, this.f4907c);
            i1.this.U.e(new e0.a().b("Child Subchannel started").c(e0.b.CT_INFO).e(i1.this.f4826q.a()).d(a1Var).a());
            this.f4910f = a1Var;
            i1.this.W.e(a1Var);
            i1.this.H.add(a1Var);
        }

        @Override // i3.r0.h
        public void i(List<i3.x> list) {
            i1.this.f4828s.e();
            this.f4909e = list;
            if (i1.this.f4803c != null) {
                list = j(list);
            }
            this.f4910f.U(list);
        }

        public String toString() {
            return this.f4906b.toString();
        }
    }

    /* loaded from: classes.dex */
    private final class y {

        /* renamed from: a  reason: collision with root package name */
        final Object f4918a;

        /* renamed from: b  reason: collision with root package name */
        Collection<io.grpc.internal.s> f4919b;

        /* renamed from: c  reason: collision with root package name */
        i3.j1 f4920c;

        private y() {
            this.f4918a = new Object();
            this.f4919b = new HashSet();
        }

        /* synthetic */ y(i1 i1Var, a aVar) {
            this();
        }

        i3.j1 a(b2<?> b2Var) {
            synchronized (this.f4918a) {
                i3.j1 j1Var = this.f4920c;
                if (j1Var != null) {
                    return j1Var;
                }
                this.f4919b.add(b2Var);
                return null;
            }
        }

        void b(i3.j1 j1Var) {
            synchronized (this.f4918a) {
                if (this.f4920c != null) {
                    return;
                }
                this.f4920c = j1Var;
                boolean isEmpty = this.f4919b.isEmpty();
                if (isEmpty) {
                    i1.this.L.f(j1Var);
                }
            }
        }

        void c(i3.j1 j1Var) {
            ArrayList<io.grpc.internal.s> arrayList;
            b(j1Var);
            synchronized (this.f4918a) {
                arrayList = new ArrayList(this.f4919b);
            }
            for (io.grpc.internal.s sVar : arrayList) {
                sVar.a(j1Var);
            }
            i1.this.L.h(j1Var);
        }

        void d(b2<?> b2Var) {
            i3.j1 j1Var;
            synchronized (this.f4918a) {
                this.f4919b.remove(b2Var);
                if (this.f4919b.isEmpty()) {
                    j1Var = this.f4920c;
                    this.f4919b = new HashSet();
                } else {
                    j1Var = null;
                }
            }
            if (j1Var != null) {
                i1.this.L.f(j1Var);
            }
        }
    }

    static {
        i3.j1 j1Var = i3.j1.f3447u;
        f4793n0 = j1Var.q("Channel shutdownNow invoked");
        f4794o0 = j1Var.q("Channel shutdown invoked");
        f4795p0 = j1Var.q("Subchannel shutdown invoked");
        f4796q0 = l1.a();
        f4797r0 = new a();
        f4798s0 = new l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(j1 j1Var, io.grpc.internal.v vVar, k.a aVar, r1<? extends Executor> r1Var, z0.o<z0.m> oVar, List<i3.h> list, q2 q2Var) {
        a aVar2;
        i3.n1 n1Var = new i3.n1(new j());
        this.f4828s = n1Var;
        this.f4834y = new io.grpc.internal.y();
        this.H = new HashSet(16, 0.75f);
        this.J = new Object();
        this.K = new HashSet(1, 0.75f);
        this.M = new y(this, null);
        this.N = new AtomicBoolean(false);
        this.R = new CountDownLatch(1);
        this.Y = v.NO_RESOLUTION;
        this.Z = f4796q0;
        this.f4802b0 = false;
        this.f4806d0 = new b2.t();
        o oVar2 = new o(this, null);
        this.f4814h0 = oVar2;
        this.f4816i0 = new q(this, null);
        this.f4818j0 = new m(this, null);
        String str = (String) z0.k.o(j1Var.f4941f, "target");
        this.f4801b = str;
        i3.j0 b5 = i3.j0.b("Channel", str);
        this.f4799a = b5;
        this.f4826q = (q2) z0.k.o(q2Var, "timeProvider");
        r1<? extends Executor> r1Var2 = (r1) z0.k.o(j1Var.f4936a, "executorPool");
        this.f4822m = r1Var2;
        Executor executor = (Executor) z0.k.o(r1Var2.a(), "executor");
        this.f4821l = executor;
        this.f4813h = vVar;
        p pVar = new p((r1) z0.k.o(j1Var.f4937b, "offloadExecutorPool"));
        this.f4825p = pVar;
        io.grpc.internal.n nVar = new io.grpc.internal.n(vVar, j1Var.f4942g, pVar);
        this.f4815i = nVar;
        this.f4817j = new io.grpc.internal.n(vVar, null, pVar);
        w wVar = new w(nVar.R(), null);
        this.f4819k = wVar;
        this.f4827r = j1Var.f4957v;
        int i5 = j1Var.f4957v;
        long a5 = q2Var.a();
        io.grpc.internal.q qVar = new io.grpc.internal.q(b5, i5, a5, "Channel for '" + str + "'");
        this.U = qVar;
        io.grpc.internal.p pVar2 = new io.grpc.internal.p(qVar, q2Var);
        this.V = pVar2;
        i3.g1 g1Var = j1Var.f4960y;
        g1Var = g1Var == null ? t0.f5191q : g1Var;
        boolean z4 = j1Var.f4955t;
        this.f4812g0 = z4;
        io.grpc.internal.j jVar = new io.grpc.internal.j(j1Var.f4946k);
        this.f4811g = jVar;
        this.f4805d = j1Var.f4939d;
        g2 g2Var = new g2(z4, j1Var.f4951p, j1Var.f4952q, jVar);
        String str2 = j1Var.f4945j;
        this.f4803c = str2;
        a1.b a6 = a1.b.g().c(j1Var.e()).f(g1Var).i(n1Var).g(wVar).h(g2Var).b(pVar2).d(pVar).e(str2).a();
        this.f4809f = a6;
        a1.d dVar = j1Var.f4940e;
        this.f4807e = dVar;
        this.C = A0(str, str2, dVar, a6);
        this.f4823n = (r1) z0.k.o(r1Var, "balancerRpcExecutorPool");
        this.f4824o = new p(r1Var);
        c0 c0Var = new c0(executor, n1Var);
        this.L = c0Var;
        c0Var.b(oVar2);
        this.f4835z = aVar;
        Map<String, ?> map = j1Var.f4958w;
        if (map != null) {
            a1.c a7 = g2Var.a(map);
            z0.k.w(a7.d() == null, "Default config is invalid: %s", a7.d());
            l1 l1Var = (l1) a7.c();
            this.f4800a0 = l1Var;
            this.Z = l1Var;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f4800a0 = null;
        }
        boolean z5 = j1Var.f4959x;
        this.f4804c0 = z5;
        u uVar = new u(this, this.C.a(), aVar2);
        this.X = uVar;
        this.A = i3.j.a(uVar, list);
        this.f4832w = (z0.o) z0.k.o(oVar, "stopwatchSupplier");
        long j5 = j1Var.f4950o;
        if (j5 != -1) {
            z0.k.i(j5 >= j1.J, "invalid idleTimeoutMillis %s", j5);
            j5 = j1Var.f4950o;
        }
        this.f4833x = j5;
        this.f4820k0 = new a2(new r(this, null), n1Var, nVar.R(), oVar.get());
        this.f4829t = j1Var.f4947l;
        this.f4830u = (i3.v) z0.k.o(j1Var.f4948m, "decompressorRegistry");
        this.f4831v = (i3.o) z0.k.o(j1Var.f4949n, "compressorRegistry");
        this.B = j1Var.f4944i;
        this.f4810f0 = j1Var.f4953r;
        this.f4808e0 = j1Var.f4954s;
        c cVar = new c(q2Var);
        this.S = cVar;
        this.T = cVar.a();
        i3.d0 d0Var = (i3.d0) z0.k.n(j1Var.f4956u);
        this.W = d0Var;
        d0Var.d(this);
        if (z5) {
            return;
        }
        if (this.f4800a0 != null) {
            pVar2.a(f.a.INFO, "Service config look-up disabled, using default service config");
        }
        this.f4802b0 = true;
    }

    static i3.a1 A0(String str, String str2, a1.d dVar, a1.b bVar) {
        e2 e2Var = new e2(z0(str, dVar, bVar), new io.grpc.internal.m(new g0.a(), bVar.d(), bVar.f()), bVar.f());
        return str2 == null ? e2Var : new k(e2Var, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (this.O) {
            for (a1 a1Var : this.H) {
                a1Var.h(f4793n0);
            }
            for (s1 s1Var : this.K) {
                s1Var.o().h(f4793n0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        if (!this.Q && this.N.get() && this.H.isEmpty() && this.K.isEmpty()) {
            this.V.a(f.a.INFO, "Terminated");
            this.W.j(this);
            this.f4822m.b(this.f4821l);
            this.f4824o.b();
            this.f4825p.b();
            this.f4815i.close();
            this.Q = true;
            this.R.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.f4828s.e();
        if (this.D) {
            this.C.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        long j5 = this.f4833x;
        if (j5 == -1) {
            return;
        }
        this.f4820k0.k(j5, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(boolean z4) {
        this.f4828s.e();
        if (z4) {
            z0.k.u(this.D, "nameResolver is not started");
            z0.k.u(this.E != null, "lbHelper is null");
        }
        i3.a1 a1Var = this.C;
        if (a1Var != null) {
            a1Var.c();
            this.D = false;
            if (z4) {
                this.C = A0(this.f4801b, this.f4803c, this.f4807e, this.f4809f);
            } else {
                this.C = null;
            }
        }
        s sVar = this.E;
        if (sVar != null) {
            sVar.f4869a.d();
            this.E = null;
        }
        this.F = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(r0.i iVar) {
        this.F = iVar;
        this.L.r(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(boolean z4) {
        this.f4820k0.i(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        H0(true);
        this.L.r(null);
        this.V.a(f.a.INFO, "Entering IDLE state");
        this.f4834y.b(i3.p.IDLE);
        if (this.f4816i0.a(this.J, this.L)) {
            x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Executor y0(i3.c cVar) {
        Executor e5 = cVar.e();
        return e5 == null ? this.f4821l : e5;
    }

    private static i3.a1 z0(String str, a1.d dVar, a1.b bVar) {
        URI uri;
        i3.a1 b5;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e5) {
            sb.append(e5.getMessage());
            uri = null;
        }
        if (uri == null || (b5 = dVar.b(uri, bVar)) == null) {
            String str2 = "";
            if (!f4792m0.matcher(str).matches()) {
                try {
                    i3.a1 b6 = dVar.b(new URI(dVar.a(), "", "/" + str, null), bVar);
                    if (b6 != null) {
                        return b6;
                    }
                } catch (URISyntaxException e6) {
                    throw new IllegalArgumentException(e6);
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (sb.length() > 0) {
                str2 = " (" + ((Object) sb) + ")";
            }
            objArr[1] = str2;
            throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
        }
        return b5;
    }

    void D0(Throwable th) {
        if (this.G) {
            return;
        }
        this.G = true;
        v0(true);
        H0(false);
        J0(new e(th));
        this.X.p(null);
        this.V.a(f.a.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f4834y.b(i3.p.TRANSIENT_FAILURE);
    }

    @Override // i3.u0
    /* renamed from: G0 */
    public i1 m() {
        this.V.a(f.a.DEBUG, "shutdown() called");
        if (this.N.compareAndSet(false, true)) {
            this.f4828s.execute(new h());
            this.X.n();
            this.f4828s.execute(new b());
            return this;
        }
        return this;
    }

    @Override // i3.u0
    /* renamed from: I0 */
    public i1 n() {
        this.V.a(f.a.DEBUG, "shutdownNow() called");
        m();
        this.X.o();
        this.f4828s.execute(new i());
        return this;
    }

    @Override // i3.d
    public String a() {
        return this.A.a();
    }

    @Override // i3.d
    public <ReqT, RespT> i3.g<ReqT, RespT> d(i3.z0<ReqT, RespT> z0Var, i3.c cVar) {
        return this.A.d(z0Var, cVar);
    }

    @Override // i3.p0
    public i3.j0 e() {
        return this.f4799a;
    }

    @Override // i3.u0
    public boolean i(long j5, TimeUnit timeUnit) {
        return this.R.await(j5, timeUnit);
    }

    @Override // i3.u0
    public void j() {
        this.f4828s.execute(new f());
    }

    @Override // i3.u0
    public i3.p k(boolean z4) {
        i3.p a5 = this.f4834y.a();
        if (z4 && a5 == i3.p.IDLE) {
            this.f4828s.execute(new g());
        }
        return a5;
    }

    @Override // i3.u0
    public void l(i3.p pVar, Runnable runnable) {
        this.f4828s.execute(new d(runnable, pVar));
    }

    public String toString() {
        return z0.f.b(this).c("logId", this.f4799a.d()).d("target", this.f4801b).toString();
    }

    void x0() {
        this.f4828s.e();
        if (this.N.get() || this.G) {
            return;
        }
        if (this.f4816i0.d()) {
            v0(false);
        } else {
            F0();
        }
        if (this.E != null) {
            return;
        }
        this.V.a(f.a.INFO, "Exiting idle mode");
        s sVar = new s(this, null);
        sVar.f4869a = this.f4811g.e(sVar);
        this.E = sVar;
        this.C.d(new t(sVar, this.C));
        this.D = true;
    }
}
