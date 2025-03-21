package io.grpc.internal;

import io.grpc.internal.p2;
import io.grpc.internal.t;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class d0 implements s {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f4622a;

    /* renamed from: b  reason: collision with root package name */
    private t f4623b;

    /* renamed from: c  reason: collision with root package name */
    private s f4624c;

    /* renamed from: d  reason: collision with root package name */
    private i3.j1 f4625d;

    /* renamed from: f  reason: collision with root package name */
    private o f4627f;

    /* renamed from: g  reason: collision with root package name */
    private long f4628g;

    /* renamed from: h  reason: collision with root package name */
    private long f4629h;

    /* renamed from: e  reason: collision with root package name */
    private List<Runnable> f4626e = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private List<Runnable> f4630i = new ArrayList();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4631a;

        a(int i5) {
            this.f4631a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.c(this.f4631a);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.m();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.n f4634a;

        c(i3.n nVar) {
            this.f4634a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.b(this.f4634a);
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f4636a;

        d(boolean z4) {
            this.f4636a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.p(this.f4636a);
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.v f4638a;

        e(i3.v vVar) {
            this.f4638a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.h(this.f4638a);
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4640a;

        f(int i5) {
            this.f4640a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.d(this.f4640a);
        }
    }

    /* loaded from: classes.dex */
    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4642a;

        g(int i5) {
            this.f4642a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.e(this.f4642a);
        }
    }

    /* loaded from: classes.dex */
    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.t f4644a;

        h(i3.t tVar) {
            this.f4644a = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.g(this.f4644a);
        }
    }

    /* loaded from: classes.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.s();
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4647a;

        j(String str) {
            this.f4647a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.k(this.f4647a);
        }
    }

    /* loaded from: classes.dex */
    class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f4649a;

        k(InputStream inputStream) {
            this.f4649a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.j(this.f4649a);
        }
    }

    /* loaded from: classes.dex */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.flush();
        }
    }

    /* loaded from: classes.dex */
    class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.j1 f4652a;

        m(i3.j1 j1Var) {
            this.f4652a = j1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.a(this.f4652a);
        }
    }

    /* loaded from: classes.dex */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f4624c.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class o implements t {

        /* renamed from: a  reason: collision with root package name */
        private final t f4655a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f4656b;

        /* renamed from: c  reason: collision with root package name */
        private List<Runnable> f4657c = new ArrayList();

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ p2.a f4658a;

            a(p2.a aVar) {
                this.f4658a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f4655a.a(this.f4658a);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f4655a.b();
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.y0 f4661a;

            c(i3.y0 y0Var) {
                this.f4661a = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f4655a.c(this.f4661a);
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.j1 f4663a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ t.a f4664b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ i3.y0 f4665c;

            d(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
                this.f4663a = j1Var;
                this.f4664b = aVar;
                this.f4665c = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f4655a.d(this.f4663a, this.f4664b, this.f4665c);
            }
        }

        public o(t tVar) {
            this.f4655a = tVar;
        }

        private void f(Runnable runnable) {
            synchronized (this) {
                if (this.f4656b) {
                    runnable.run();
                } else {
                    this.f4657c.add(runnable);
                }
            }
        }

        @Override // io.grpc.internal.p2
        public void a(p2.a aVar) {
            if (this.f4656b) {
                this.f4655a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        @Override // io.grpc.internal.p2
        public void b() {
            if (this.f4656b) {
                this.f4655a.b();
            } else {
                f(new b());
            }
        }

        @Override // io.grpc.internal.t
        public void c(i3.y0 y0Var) {
            f(new c(y0Var));
        }

        @Override // io.grpc.internal.t
        public void d(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            f(new d(j1Var, aVar, y0Var));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g() {
            List<Runnable> list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.f4657c.isEmpty()) {
                        this.f4657c = null;
                        this.f4656b = true;
                        return;
                    }
                    list = this.f4657c;
                    this.f4657c = arrayList;
                }
                for (Runnable runnable : list) {
                    runnable.run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    private void r(Runnable runnable) {
        z0.k.u(this.f4623b != null, "May only be called after start");
        synchronized (this) {
            if (this.f4622a) {
                runnable.run();
            } else {
                this.f4626e.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (r0.hasNext() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f4626e     // Catch: java.lang.Throwable -> L3b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L1d
            r0 = 0
            r3.f4626e = r0     // Catch: java.lang.Throwable -> L3b
            r0 = 1
            r3.f4622a = r0     // Catch: java.lang.Throwable -> L3b
            io.grpc.internal.d0$o r0 = r3.f4627f     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L1c
            r0.g()
        L1c:
            return
        L1d:
            java.util.List<java.lang.Runnable> r1 = r3.f4626e     // Catch: java.lang.Throwable -> L3b
            r3.f4626e = r0     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            java.util.Iterator r0 = r1.iterator()
        L26:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L36
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L26
        L36:
            r1.clear()
            r0 = r1
            goto L5
        L3b:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.d0.s():void");
    }

    private void t(t tVar) {
        for (Runnable runnable : this.f4630i) {
            runnable.run();
        }
        this.f4630i = null;
        this.f4624c.f(tVar);
    }

    private void v(s sVar) {
        s sVar2 = this.f4624c;
        z0.k.w(sVar2 == null, "realStream already set to %s", sVar2);
        this.f4624c = sVar;
        this.f4629h = System.nanoTime();
    }

    @Override // io.grpc.internal.s
    public void a(i3.j1 j1Var) {
        boolean z4 = true;
        z0.k.u(this.f4623b != null, "May only be called after start");
        z0.k.o(j1Var, "reason");
        synchronized (this) {
            if (this.f4624c == null) {
                v(q1.f5108a);
                this.f4625d = j1Var;
                z4 = false;
            }
        }
        if (z4) {
            r(new m(j1Var));
            return;
        }
        s();
        u(j1Var);
        this.f4623b.d(j1Var, t.a.PROCESSED, new i3.y0());
    }

    @Override // io.grpc.internal.o2
    public void b(i3.n nVar) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        z0.k.o(nVar, "compressor");
        this.f4630i.add(new c(nVar));
    }

    @Override // io.grpc.internal.o2
    public void c(int i5) {
        z0.k.u(this.f4623b != null, "May only be called after start");
        if (this.f4622a) {
            this.f4624c.c(i5);
        } else {
            r(new a(i5));
        }
    }

    @Override // io.grpc.internal.s
    public void d(int i5) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        this.f4630i.add(new f(i5));
    }

    @Override // io.grpc.internal.s
    public void e(int i5) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        this.f4630i.add(new g(i5));
    }

    @Override // io.grpc.internal.s
    public void f(t tVar) {
        i3.j1 j1Var;
        boolean z4;
        z0.k.o(tVar, "listener");
        z0.k.u(this.f4623b == null, "already started");
        synchronized (this) {
            j1Var = this.f4625d;
            z4 = this.f4622a;
            if (!z4) {
                o oVar = new o(tVar);
                this.f4627f = oVar;
                tVar = oVar;
            }
            this.f4623b = tVar;
            this.f4628g = System.nanoTime();
        }
        if (j1Var != null) {
            tVar.d(j1Var, t.a.PROCESSED, new i3.y0());
        } else if (z4) {
            t(tVar);
        }
    }

    @Override // io.grpc.internal.o2
    public void flush() {
        z0.k.u(this.f4623b != null, "May only be called after start");
        if (this.f4622a) {
            this.f4624c.flush();
        } else {
            r(new l());
        }
    }

    @Override // io.grpc.internal.s
    public void g(i3.t tVar) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        this.f4630i.add(new h(tVar));
    }

    @Override // io.grpc.internal.s
    public void h(i3.v vVar) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        z0.k.o(vVar, "decompressorRegistry");
        this.f4630i.add(new e(vVar));
    }

    @Override // io.grpc.internal.o2
    public boolean i() {
        if (this.f4622a) {
            return this.f4624c.i();
        }
        return false;
    }

    @Override // io.grpc.internal.o2
    public void j(InputStream inputStream) {
        z0.k.u(this.f4623b != null, "May only be called after start");
        z0.k.o(inputStream, "message");
        if (this.f4622a) {
            this.f4624c.j(inputStream);
        } else {
            r(new k(inputStream));
        }
    }

    @Override // io.grpc.internal.s
    public void k(String str) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        z0.k.o(str, "authority");
        this.f4630i.add(new j(str));
    }

    @Override // io.grpc.internal.s
    public void l(z0 z0Var) {
        synchronized (this) {
            if (this.f4623b == null) {
                return;
            }
            if (this.f4624c != null) {
                z0Var.b("buffered_nanos", Long.valueOf(this.f4629h - this.f4628g));
                this.f4624c.l(z0Var);
            } else {
                z0Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f4628g));
                z0Var.a("waiting_for_connection");
            }
        }
    }

    @Override // io.grpc.internal.o2
    public void m() {
        z0.k.u(this.f4623b == null, "May only be called before start");
        this.f4630i.add(new b());
    }

    @Override // io.grpc.internal.s
    public void n() {
        z0.k.u(this.f4623b != null, "May only be called after start");
        r(new n());
    }

    @Override // io.grpc.internal.s
    public void p(boolean z4) {
        z0.k.u(this.f4623b == null, "May only be called before start");
        this.f4630i.add(new d(z4));
    }

    protected void u(i3.j1 j1Var) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Runnable w(s sVar) {
        synchronized (this) {
            if (this.f4624c != null) {
                return null;
            }
            v((s) z0.k.o(sVar, "stream"));
            t tVar = this.f4623b;
            if (tVar == null) {
                this.f4626e = null;
                this.f4622a = true;
            }
            if (tVar == null) {
                return null;
            }
            t(tVar);
            return new i();
        }
    }
}
