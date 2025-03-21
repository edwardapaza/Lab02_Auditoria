package io.grpc.internal;

import i3.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class b0<ReqT, RespT> extends i3.g<ReqT, RespT> {

    /* renamed from: j  reason: collision with root package name */
    private static final Logger f4427j = Logger.getLogger(b0.class.getName());

    /* renamed from: k  reason: collision with root package name */
    private static final i3.g<Object, Object> f4428k = new i();

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledFuture<?> f4429a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f4430b;

    /* renamed from: c  reason: collision with root package name */
    private final i3.r f4431c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f4432d;

    /* renamed from: e  reason: collision with root package name */
    private g.a<RespT> f4433e;

    /* renamed from: f  reason: collision with root package name */
    private i3.g<ReqT, RespT> f4434f;

    /* renamed from: g  reason: collision with root package name */
    private i3.j1 f4435g;

    /* renamed from: h  reason: collision with root package name */
    private List<Runnable> f4436h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private k<RespT> f4437i;

    /* loaded from: classes.dex */
    class a extends z {
        a(i3.r rVar) {
            super(rVar);
        }

        @Override // io.grpc.internal.z
        public void a() {
            b0.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StringBuilder f4439a;

        b(StringBuilder sb) {
            this.f4439a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.k(i3.j1.f3436j.q(this.f4439a.toString()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends z {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f4441b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(k kVar) {
            super(b0.this.f4431c);
            this.f4441b = kVar;
        }

        @Override // io.grpc.internal.z
        public void a() {
            this.f4441b.g();
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g.a f4443a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i3.y0 f4444b;

        d(g.a aVar, i3.y0 y0Var) {
            this.f4443a = aVar;
            this.f4444b = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f4434f.e(this.f4443a, this.f4444b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.j1 f4446a;

        e(i3.j1 j1Var) {
            this.f4446a = j1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f4434f.a(this.f4446a.n(), this.f4446a.l());
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f4448a;

        f(Object obj) {
            this.f4448a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b0.this.f4434f.d(this.f4448a);
        }
    }

    /* loaded from: classes.dex */
    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4450a;

        g(int i5) {
            this.f4450a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f4434f.c(this.f4450a);
        }
    }

    /* loaded from: classes.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f4434f.b();
        }
    }

    /* loaded from: classes.dex */
    class i extends i3.g<Object, Object> {
        i() {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class j extends z {

        /* renamed from: b  reason: collision with root package name */
        final g.a<RespT> f4453b;

        /* renamed from: c  reason: collision with root package name */
        final i3.j1 f4454c;

        j(g.a<RespT> aVar, i3.j1 j1Var) {
            super(b0.this.f4431c);
            this.f4453b = aVar;
            this.f4454c = j1Var;
        }

        @Override // io.grpc.internal.z
        public void a() {
            this.f4453b.a(this.f4454c, new i3.y0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class k<RespT> extends g.a<RespT> {

        /* renamed from: a  reason: collision with root package name */
        private final g.a<RespT> f4456a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f4457b;

        /* renamed from: c  reason: collision with root package name */
        private List<Runnable> f4458c = new ArrayList();

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.y0 f4459a;

            a(i3.y0 y0Var) {
                this.f4459a = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f4456a.b(this.f4459a);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f4461a;

            b(Object obj) {
                this.f4461a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f4456a.c(this.f4461a);
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.j1 f4463a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ i3.y0 f4464b;

            c(i3.j1 j1Var, i3.y0 y0Var) {
                this.f4463a = j1Var;
                this.f4464b = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f4456a.a(this.f4463a, this.f4464b);
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f4456a.d();
            }
        }

        public k(g.a<RespT> aVar) {
            this.f4456a = aVar;
        }

        private void f(Runnable runnable) {
            synchronized (this) {
                if (this.f4457b) {
                    runnable.run();
                } else {
                    this.f4458c.add(runnable);
                }
            }
        }

        @Override // i3.g.a
        public void a(i3.j1 j1Var, i3.y0 y0Var) {
            f(new c(j1Var, y0Var));
        }

        @Override // i3.g.a
        public void b(i3.y0 y0Var) {
            if (this.f4457b) {
                this.f4456a.b(y0Var);
            } else {
                f(new a(y0Var));
            }
        }

        @Override // i3.g.a
        public void c(RespT respt) {
            if (this.f4457b) {
                this.f4456a.c(respt);
            } else {
                f(new b(respt));
            }
        }

        @Override // i3.g.a
        public void d() {
            if (this.f4457b) {
                this.f4456a.d();
            } else {
                f(new d());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            List<Runnable> list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.f4458c.isEmpty()) {
                        this.f4458c = null;
                        this.f4457b = true;
                        return;
                    }
                    list = this.f4458c;
                    this.f4458c = arrayList;
                }
                for (Runnable runnable : list) {
                    runnable.run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0(Executor executor, ScheduledExecutorService scheduledExecutorService, i3.t tVar) {
        this.f4430b = (Executor) z0.k.o(executor, "callExecutor");
        z0.k.o(scheduledExecutorService, "scheduler");
        this.f4431c = i3.r.e();
        this.f4429a = o(scheduledExecutorService, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void k(i3.j1 j1Var, boolean z4) {
        boolean z5;
        g.a<RespT> aVar;
        synchronized (this) {
            if (this.f4434f == null) {
                q(f4428k);
                z5 = false;
                aVar = this.f4433e;
                this.f4435g = j1Var;
            } else if (z4) {
                return;
            } else {
                z5 = true;
                aVar = null;
            }
            if (z5) {
                l(new e(j1Var));
            } else {
                if (aVar != null) {
                    this.f4430b.execute(new j(aVar, j1Var));
                }
                m();
            }
            j();
        }
    }

    private void l(Runnable runnable) {
        synchronized (this) {
            if (this.f4432d) {
                runnable.run();
            } else {
                this.f4436h.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0.hasNext() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f4436h     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L24
            r0 = 0
            r3.f4436h = r0     // Catch: java.lang.Throwable -> L42
            r0 = 1
            r3.f4432d = r0     // Catch: java.lang.Throwable -> L42
            io.grpc.internal.b0$k<RespT> r0 = r3.f4437i     // Catch: java.lang.Throwable -> L42
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f4430b
            io.grpc.internal.b0$c r2 = new io.grpc.internal.b0$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            java.util.List<java.lang.Runnable> r1 = r3.f4436h     // Catch: java.lang.Throwable -> L42
            r3.f4436h = r0     // Catch: java.lang.Throwable -> L42
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L42
            java.util.Iterator r0 = r1.iterator()
        L2d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2d
        L3d:
            r1.clear()
            r0 = r1
            goto L5
        L42:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L42
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.b0.m():void");
    }

    private boolean n(i3.t tVar, i3.t tVar2) {
        if (tVar2 == null) {
            return true;
        }
        if (tVar == null) {
            return false;
        }
        return tVar.k(tVar2);
    }

    private ScheduledFuture<?> o(ScheduledExecutorService scheduledExecutorService, i3.t tVar) {
        String str;
        i3.t g5 = this.f4431c.g();
        if (tVar == null && g5 == null) {
            return null;
        }
        long o5 = tVar != null ? tVar.o(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (g5 != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (g5.o(timeUnit) < o5) {
                o5 = g5.o(timeUnit);
                Logger logger = f4427j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(o5)));
                    sb.append(tVar == null ? " Explicit call timeout was not set." : String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(tVar.o(timeUnit))));
                    logger.fine(sb.toString());
                }
            }
        }
        long abs = Math.abs(o5);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = abs / timeUnit2.toNanos(1L);
        long abs2 = Math.abs(o5) % timeUnit2.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        String str2 = n(g5, tVar) ? "Context" : "CallOptions";
        if (o5 < 0) {
            sb2.append("ClientCall started after ");
            sb2.append(str2);
            str = " deadline was exceeded. Deadline has been exceeded for ";
        } else {
            sb2.append("Deadline ");
            sb2.append(str2);
            str = " will be exceeded in ";
        }
        sb2.append(str);
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new b(sb2), o5, TimeUnit.NANOSECONDS);
    }

    private void q(i3.g<ReqT, RespT> gVar) {
        i3.g<ReqT, RespT> gVar2 = this.f4434f;
        z0.k.w(gVar2 == null, "realCall already set to %s", gVar2);
        ScheduledFuture<?> scheduledFuture = this.f4429a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f4434f = gVar;
    }

    @Override // i3.g
    public final void a(String str, Throwable th) {
        i3.j1 j1Var = i3.j1.f3433g;
        if (str == null) {
            str = "Call cancelled without message";
        }
        i3.j1 q5 = j1Var.q(str);
        if (th != null) {
            q5 = q5.p(th);
        }
        k(q5, false);
    }

    @Override // i3.g
    public final void b() {
        l(new h());
    }

    @Override // i3.g
    public final void c(int i5) {
        if (this.f4432d) {
            this.f4434f.c(i5);
        } else {
            l(new g(i5));
        }
    }

    @Override // i3.g
    public final void d(ReqT reqt) {
        if (this.f4432d) {
            this.f4434f.d(reqt);
        } else {
            l(new f(reqt));
        }
    }

    @Override // i3.g
    public final void e(g.a<RespT> aVar, i3.y0 y0Var) {
        i3.j1 j1Var;
        boolean z4;
        z0.k.u(this.f4433e == null, "already started");
        synchronized (this) {
            this.f4433e = (g.a) z0.k.o(aVar, "listener");
            j1Var = this.f4435g;
            z4 = this.f4432d;
            if (!z4) {
                k<RespT> kVar = new k<>(aVar);
                this.f4437i = kVar;
                aVar = kVar;
            }
        }
        if (j1Var != null) {
            this.f4430b.execute(new j(aVar, j1Var));
        } else if (z4) {
            this.f4434f.e(aVar, y0Var);
        } else {
            l(new d(aVar, y0Var));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
    }

    public final Runnable p(i3.g<ReqT, RespT> gVar) {
        synchronized (this) {
            if (this.f4434f != null) {
                return null;
            }
            q((i3.g) z0.k.o(gVar, "call"));
            return new a(this.f4431c);
        }
    }

    public String toString() {
        return z0.f.b(this).d("realCall", this.f4434f).toString();
    }
}
