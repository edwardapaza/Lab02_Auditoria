package io.grpc.internal;

import i3.k;
import i3.y0;
import io.grpc.internal.p2;
import io.grpc.internal.t;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b2<ReqT> implements io.grpc.internal.s {
    static final y0.g<String> A;
    static final y0.g<String> B;
    private static final i3.j1 C;
    private static Random D;

    /* renamed from: a  reason: collision with root package name */
    private final i3.z0<ReqT, ?> f4471a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f4472b;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f4474d;

    /* renamed from: e  reason: collision with root package name */
    private final i3.y0 f4475e;

    /* renamed from: f  reason: collision with root package name */
    private final c2 f4476f;

    /* renamed from: g  reason: collision with root package name */
    private final v0 f4477g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f4478h;

    /* renamed from: j  reason: collision with root package name */
    private final t f4480j;

    /* renamed from: k  reason: collision with root package name */
    private final long f4481k;

    /* renamed from: l  reason: collision with root package name */
    private final long f4482l;

    /* renamed from: m  reason: collision with root package name */
    private final d0 f4483m;

    /* renamed from: s  reason: collision with root package name */
    private y f4489s;

    /* renamed from: t  reason: collision with root package name */
    private long f4490t;

    /* renamed from: u  reason: collision with root package name */
    private io.grpc.internal.t f4491u;

    /* renamed from: v  reason: collision with root package name */
    private u f4492v;

    /* renamed from: w  reason: collision with root package name */
    private u f4493w;

    /* renamed from: x  reason: collision with root package name */
    private long f4494x;

    /* renamed from: y  reason: collision with root package name */
    private i3.j1 f4495y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4496z;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f4473c = new i3.n1(new a());

    /* renamed from: i  reason: collision with root package name */
    private final Object f4479i = new Object();

    /* renamed from: n  reason: collision with root package name */
    private final z0 f4484n = new z0();

    /* renamed from: o  reason: collision with root package name */
    private volatile a0 f4485o = new a0(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* renamed from: p  reason: collision with root package name */
    private final AtomicBoolean f4486p = new AtomicBoolean();

    /* renamed from: q  reason: collision with root package name */
    private final AtomicInteger f4487q = new AtomicInteger();

    /* renamed from: r  reason: collision with root package name */
    private final AtomicInteger f4488r = new AtomicInteger();

    /* loaded from: classes.dex */
    class a implements Thread.UncaughtExceptionHandler {
        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw i3.j1.k(th).q("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a0 {

        /* renamed from: a  reason: collision with root package name */
        final boolean f4498a;

        /* renamed from: b  reason: collision with root package name */
        final List<r> f4499b;

        /* renamed from: c  reason: collision with root package name */
        final Collection<c0> f4500c;

        /* renamed from: d  reason: collision with root package name */
        final Collection<c0> f4501d;

        /* renamed from: e  reason: collision with root package name */
        final int f4502e;

        /* renamed from: f  reason: collision with root package name */
        final c0 f4503f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f4504g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f4505h;

        a0(List<r> list, Collection<c0> collection, Collection<c0> collection2, c0 c0Var, boolean z4, boolean z5, boolean z6, int i5) {
            this.f4499b = list;
            this.f4500c = (Collection) z0.k.o(collection, "drainedSubstreams");
            this.f4503f = c0Var;
            this.f4501d = collection2;
            this.f4504g = z4;
            this.f4498a = z5;
            this.f4505h = z6;
            this.f4502e = i5;
            boolean z7 = false;
            z0.k.u(!z5 || list == null, "passThrough should imply buffer is null");
            z0.k.u((z5 && c0Var == null) ? false : true, "passThrough should imply winningSubstream != null");
            z0.k.u(!z5 || (collection.size() == 1 && collection.contains(c0Var)) || (collection.size() == 0 && c0Var.f4527b), "passThrough should imply winningSubstream is drained");
            z0.k.u((z4 && c0Var == null) ? true : true, "cancelled should imply committed");
        }

        a0 a(c0 c0Var) {
            Collection unmodifiableCollection;
            z0.k.u(!this.f4505h, "hedging frozen");
            z0.k.u(this.f4503f == null, "already committed");
            if (this.f4501d == null) {
                unmodifiableCollection = Collections.singleton(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f4501d);
                arrayList.add(c0Var);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new a0(this.f4499b, this.f4500c, unmodifiableCollection, this.f4503f, this.f4504g, this.f4498a, this.f4505h, this.f4502e + 1);
        }

        a0 b() {
            return new a0(this.f4499b, this.f4500c, this.f4501d, this.f4503f, true, this.f4498a, this.f4505h, this.f4502e);
        }

        a0 c(c0 c0Var) {
            List<r> list;
            Collection emptyList;
            boolean z4;
            z0.k.u(this.f4503f == null, "Already committed");
            List<r> list2 = this.f4499b;
            if (this.f4500c.contains(c0Var)) {
                list = null;
                emptyList = Collections.singleton(c0Var);
                z4 = true;
            } else {
                list = list2;
                emptyList = Collections.emptyList();
                z4 = false;
            }
            return new a0(list, emptyList, this.f4501d, c0Var, this.f4504g, z4, this.f4505h, this.f4502e);
        }

        a0 d() {
            return this.f4505h ? this : new a0(this.f4499b, this.f4500c, this.f4501d, this.f4503f, this.f4504g, this.f4498a, true, this.f4502e);
        }

        a0 e(c0 c0Var) {
            ArrayList arrayList = new ArrayList(this.f4501d);
            arrayList.remove(c0Var);
            return new a0(this.f4499b, this.f4500c, Collections.unmodifiableCollection(arrayList), this.f4503f, this.f4504g, this.f4498a, this.f4505h, this.f4502e);
        }

        a0 f(c0 c0Var, c0 c0Var2) {
            ArrayList arrayList = new ArrayList(this.f4501d);
            arrayList.remove(c0Var);
            arrayList.add(c0Var2);
            return new a0(this.f4499b, this.f4500c, Collections.unmodifiableCollection(arrayList), this.f4503f, this.f4504g, this.f4498a, this.f4505h, this.f4502e);
        }

        a0 g(c0 c0Var) {
            c0Var.f4527b = true;
            if (this.f4500c.contains(c0Var)) {
                ArrayList arrayList = new ArrayList(this.f4500c);
                arrayList.remove(c0Var);
                return new a0(this.f4499b, Collections.unmodifiableCollection(arrayList), this.f4501d, this.f4503f, this.f4504g, this.f4498a, this.f4505h, this.f4502e);
            }
            return this;
        }

        a0 h(c0 c0Var) {
            Collection unmodifiableCollection;
            z0.k.u(!this.f4498a, "Already passThrough");
            if (c0Var.f4527b) {
                unmodifiableCollection = this.f4500c;
            } else if (this.f4500c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f4500c);
                arrayList.add(c0Var);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            c0 c0Var2 = this.f4503f;
            boolean z4 = c0Var2 != null;
            List<r> list = this.f4499b;
            if (z4) {
                z0.k.u(c0Var2 == c0Var, "Another RPC attempt has already committed");
                list = null;
            }
            return new a0(list, collection, this.f4501d, this.f4503f, this.f4504g, z4, this.f4505h, this.f4502e);
        }
    }

    /* loaded from: classes.dex */
    class b implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f4506a;

        b(String str) {
            this.f4506a = str;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.k(this.f4506a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b0 implements io.grpc.internal.t {

        /* renamed from: a  reason: collision with root package name */
        final c0 f4508a;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.y0 f4510a;

            a(i3.y0 y0Var) {
                this.f4510a = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f4491u.c(this.f4510a);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c0 f4512a;

            /* loaded from: classes.dex */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    b2.this.f0(bVar.f4512a);
                }
            }

            b(c0 c0Var) {
                this.f4512a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f4472b.execute(new a());
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f4496z = true;
                b2.this.f4491u.d(b2.this.f4489s.f4575a, b2.this.f4489s.f4576b, b2.this.f4489s.f4577c);
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c0 f4516a;

            d(c0 c0Var) {
                this.f4516a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f0(this.f4516a);
            }
        }

        /* loaded from: classes.dex */
        class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ p2.a f4518a;

            e(p2.a aVar) {
                this.f4518a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f4491u.a(this.f4518a);
            }
        }

        /* loaded from: classes.dex */
        class f implements Runnable {
            f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b2.this.f4496z) {
                    return;
                }
                b2.this.f4491u.b();
            }
        }

        b0(c0 c0Var) {
            this.f4508a = c0Var;
        }

        private Integer e(i3.y0 y0Var) {
            String str = (String) y0Var.g(b2.B);
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }
            return null;
        }

        private v f(i3.j1 j1Var, i3.y0 y0Var) {
            Integer e5 = e(y0Var);
            boolean z4 = true;
            boolean z5 = !b2.this.f4477g.f5280c.contains(j1Var.m());
            boolean z6 = (b2.this.f4483m == null || (z5 && (e5 == null || e5.intValue() >= 0))) ? false : !b2.this.f4483m.b();
            if (!z5 && !z6 && !j1Var.o() && e5 != null && e5.intValue() > 0) {
                e5 = 0;
            }
            return new v((z5 || z6) ? false : false, e5);
        }

        private x g(i3.j1 j1Var, i3.y0 y0Var) {
            b2 b2Var;
            long j5;
            long j6 = 0;
            boolean z4 = false;
            if (b2.this.f4476f == null) {
                return new x(false, 0L);
            }
            boolean contains = b2.this.f4476f.f4610f.contains(j1Var.m());
            Integer e5 = e(y0Var);
            boolean z5 = (b2.this.f4483m == null || (!contains && (e5 == null || e5.intValue() >= 0))) ? false : !b2.this.f4483m.b();
            if (b2.this.f4476f.f4605a > this.f4508a.f4529d + 1 && !z5) {
                if (e5 == null) {
                    if (contains) {
                        j6 = (long) (b2.this.f4494x * b2.D.nextDouble());
                        b2Var = b2.this;
                        j5 = Math.min((long) (b2Var.f4494x * b2.this.f4476f.f4608d), b2.this.f4476f.f4607c);
                        b2Var.f4494x = j5;
                        z4 = true;
                    }
                } else if (e5.intValue() >= 0) {
                    j6 = TimeUnit.MILLISECONDS.toNanos(e5.intValue());
                    b2Var = b2.this;
                    j5 = b2Var.f4476f.f4606b;
                    b2Var.f4494x = j5;
                    z4 = true;
                }
            }
            return new x(z4, j6);
        }

        @Override // io.grpc.internal.p2
        public void a(p2.a aVar) {
            a0 a0Var = b2.this.f4485o;
            z0.k.u(a0Var.f4503f != null, "Headers should be received prior to messages.");
            if (a0Var.f4503f != this.f4508a) {
                t0.d(aVar);
            } else {
                b2.this.f4473c.execute(new e(aVar));
            }
        }

        @Override // io.grpc.internal.p2
        public void b() {
            if (b2.this.i()) {
                b2.this.f4473c.execute(new f());
            }
        }

        @Override // io.grpc.internal.t
        public void c(i3.y0 y0Var) {
            if (this.f4508a.f4529d > 0) {
                y0.g<String> gVar = b2.A;
                y0Var.e(gVar);
                y0Var.p(gVar, String.valueOf(this.f4508a.f4529d));
            }
            b2.this.c0(this.f4508a);
            if (b2.this.f4485o.f4503f == this.f4508a) {
                if (b2.this.f4483m != null) {
                    b2.this.f4483m.c();
                }
                b2.this.f4473c.execute(new a(y0Var));
            }
        }

        @Override // io.grpc.internal.t
        public void d(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            u uVar;
            synchronized (b2.this.f4479i) {
                b2 b2Var = b2.this;
                b2Var.f4485o = b2Var.f4485o.g(this.f4508a);
                b2.this.f4484n.a(j1Var.m());
            }
            if (b2.this.f4488r.decrementAndGet() == Integer.MIN_VALUE) {
                b2.this.f4473c.execute(new c());
                return;
            }
            c0 c0Var = this.f4508a;
            if (c0Var.f4528c) {
                b2.this.c0(c0Var);
                if (b2.this.f4485o.f4503f == this.f4508a) {
                    b2.this.m0(j1Var, aVar, y0Var);
                    return;
                }
                return;
            }
            t.a aVar2 = t.a.MISCARRIED;
            if (aVar == aVar2 && b2.this.f4487q.incrementAndGet() > 1000) {
                b2.this.c0(this.f4508a);
                if (b2.this.f4485o.f4503f == this.f4508a) {
                    b2.this.m0(i3.j1.f3446t.q("Too many transparent retries. Might be a bug in gRPC").p(j1Var.d()), aVar, y0Var);
                    return;
                }
                return;
            }
            if (b2.this.f4485o.f4503f == null) {
                if (aVar == aVar2 || (aVar == t.a.REFUSED && b2.this.f4486p.compareAndSet(false, true))) {
                    c0 d02 = b2.this.d0(this.f4508a.f4529d, true);
                    if (d02 == null) {
                        return;
                    }
                    if (b2.this.f4478h) {
                        synchronized (b2.this.f4479i) {
                            b2 b2Var2 = b2.this;
                            b2Var2.f4485o = b2Var2.f4485o.f(this.f4508a, d02);
                        }
                    }
                    b2.this.f4472b.execute(new d(d02));
                    return;
                } else if (aVar != t.a.DROPPED) {
                    b2.this.f4486p.set(true);
                    if (b2.this.f4478h) {
                        v f5 = f(j1Var, y0Var);
                        if (f5.f4567a) {
                            b2.this.l0(f5.f4568b);
                        }
                        synchronized (b2.this.f4479i) {
                            b2 b2Var3 = b2.this;
                            b2Var3.f4485o = b2Var3.f4485o.e(this.f4508a);
                            if (f5.f4567a) {
                                b2 b2Var4 = b2.this;
                                if (b2Var4.h0(b2Var4.f4485o) || !b2.this.f4485o.f4501d.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    } else {
                        x g5 = g(j1Var, y0Var);
                        if (g5.f4573a) {
                            c0 d03 = b2.this.d0(this.f4508a.f4529d + 1, false);
                            if (d03 == null) {
                                return;
                            }
                            synchronized (b2.this.f4479i) {
                                b2 b2Var5 = b2.this;
                                uVar = new u(b2Var5.f4479i);
                                b2Var5.f4492v = uVar;
                            }
                            uVar.c(b2.this.f4474d.schedule(new b(d03), g5.f4574b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (b2.this.f4478h) {
                    b2.this.g0();
                }
            }
            b2.this.c0(this.f4508a);
            if (b2.this.f4485o.f4503f == this.f4508a) {
                b2.this.m0(j1Var, aVar, y0Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Collection f4521a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f4522b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Future f4523c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Future f4524d;

        c(Collection collection, c0 c0Var, Future future, Future future2) {
            this.f4521a = collection;
            this.f4522b = c0Var;
            this.f4523c = future;
            this.f4524d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (c0 c0Var : this.f4521a) {
                if (c0Var != this.f4522b) {
                    c0Var.f4526a.a(b2.C);
                }
            }
            Future future = this.f4523c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f4524d;
            if (future2 != null) {
                future2.cancel(false);
            }
            b2.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c0 {

        /* renamed from: a  reason: collision with root package name */
        io.grpc.internal.s f4526a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4527b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4528c;

        /* renamed from: d  reason: collision with root package name */
        final int f4529d;

        c0(int i5) {
            this.f4529d = i5;
        }
    }

    /* loaded from: classes.dex */
    class d implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.n f4530a;

        d(i3.n nVar) {
            this.f4530a = nVar;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.b(this.f4530a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d0 {

        /* renamed from: a  reason: collision with root package name */
        final int f4532a;

        /* renamed from: b  reason: collision with root package name */
        final int f4533b;

        /* renamed from: c  reason: collision with root package name */
        final int f4534c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f4535d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d0(float f5, float f6) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f4535d = atomicInteger;
            this.f4534c = (int) (f6 * 1000.0f);
            int i5 = (int) (f5 * 1000.0f);
            this.f4532a = i5;
            this.f4533b = i5 / 2;
            atomicInteger.set(i5);
        }

        boolean a() {
            return this.f4535d.get() > this.f4533b;
        }

        boolean b() {
            int i5;
            int i6;
            do {
                i5 = this.f4535d.get();
                if (i5 == 0) {
                    return false;
                }
                i6 = i5 - 1000;
            } while (!this.f4535d.compareAndSet(i5, Math.max(i6, 0)));
            return i6 > this.f4533b;
        }

        void c() {
            int i5;
            int i6;
            do {
                i5 = this.f4535d.get();
                i6 = this.f4532a;
                if (i5 == i6) {
                    return;
                }
            } while (!this.f4535d.compareAndSet(i5, Math.min(this.f4534c + i5, i6)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d0) {
                d0 d0Var = (d0) obj;
                return this.f4532a == d0Var.f4532a && this.f4534c == d0Var.f4534c;
            }
            return false;
        }

        public int hashCode() {
            return z0.g.b(Integer.valueOf(this.f4532a), Integer.valueOf(this.f4534c));
        }
    }

    /* loaded from: classes.dex */
    class e implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.t f4536a;

        e(i3.t tVar) {
            this.f4536a = tVar;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.g(this.f4536a);
        }
    }

    /* loaded from: classes.dex */
    class f implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.v f4538a;

        f(i3.v vVar) {
            this.f4538a = vVar;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.h(this.f4538a);
        }
    }

    /* loaded from: classes.dex */
    class g implements r {
        g() {
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.flush();
        }
    }

    /* loaded from: classes.dex */
    class h implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f4541a;

        h(boolean z4) {
            this.f4541a = z4;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.p(this.f4541a);
        }
    }

    /* loaded from: classes.dex */
    class i implements r {
        i() {
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.n();
        }
    }

    /* loaded from: classes.dex */
    class j implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4544a;

        j(int i5) {
            this.f4544a = i5;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.d(this.f4544a);
        }
    }

    /* loaded from: classes.dex */
    class k implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4546a;

        k(int i5) {
            this.f4546a = i5;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.e(this.f4546a);
        }
    }

    /* loaded from: classes.dex */
    class l implements r {
        l() {
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.m();
        }
    }

    /* loaded from: classes.dex */
    class m implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4549a;

        m(int i5) {
            this.f4549a = i5;
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.c(this.f4549a);
        }
    }

    /* loaded from: classes.dex */
    class n implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f4551a;

        n(Object obj) {
            this.f4551a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.j(b2.this.f4471a.j(this.f4551a));
            c0Var.f4526a.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends k.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.k f4553a;

        o(i3.k kVar) {
            this.f4553a = kVar;
        }

        @Override // i3.k.a
        public i3.k a(k.b bVar, i3.y0 y0Var) {
            return this.f4553a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b2.this.f4496z) {
                return;
            }
            b2.this.f4491u.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.j1 f4556a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t.a f4557b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i3.y0 f4558c;

        q(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            this.f4556a = j1Var;
            this.f4557b = aVar;
            this.f4558c = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b2.this.f4496z = true;
            b2.this.f4491u.d(this.f4556a, this.f4557b, this.f4558c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface r {
        void a(c0 c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s extends i3.k {

        /* renamed from: b  reason: collision with root package name */
        private final c0 f4560b;

        /* renamed from: c  reason: collision with root package name */
        long f4561c;

        s(c0 c0Var) {
            this.f4560b = c0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:7:0x0013, B:9:0x001d, B:12:0x0024, B:14:0x0033, B:16:0x0035, B:18:0x0042, B:19:0x0044, B:23:0x006e, B:25:0x0074, B:26:0x007a, B:20:0x0047, B:22:0x006b, B:30:0x0081), top: B:35:0x0013 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        @Override // i3.m1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(long r8) {
            /*
                r7 = this;
                io.grpc.internal.b2 r0 = io.grpc.internal.b2.this
                io.grpc.internal.b2$a0 r0 = io.grpc.internal.b2.K(r0)
                io.grpc.internal.b2$c0 r0 = r0.f4503f
                if (r0 == 0) goto Lb
                return
            Lb:
                r0 = 0
                io.grpc.internal.b2 r1 = io.grpc.internal.b2.this
                java.lang.Object r1 = io.grpc.internal.b2.W(r1)
                monitor-enter(r1)
                io.grpc.internal.b2 r2 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2$a0 r2 = io.grpc.internal.b2.K(r2)     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2$c0 r2 = r2.f4503f     // Catch: java.lang.Throwable -> L83
                if (r2 != 0) goto L81
                io.grpc.internal.b2$c0 r2 = r7.f4560b     // Catch: java.lang.Throwable -> L83
                boolean r2 = r2.f4527b     // Catch: java.lang.Throwable -> L83
                if (r2 == 0) goto L24
                goto L81
            L24:
                long r2 = r7.f4561c     // Catch: java.lang.Throwable -> L83
                long r2 = r2 + r8
                r7.f4561c = r2     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2 r8 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                long r8 = io.grpc.internal.b2.P(r8)     // Catch: java.lang.Throwable -> L83
                int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r4 > 0) goto L35
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L83
                return
            L35:
                long r8 = r7.f4561c     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2 r2 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                long r2 = io.grpc.internal.b2.R(r2)     // Catch: java.lang.Throwable -> L83
                r4 = 1
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 <= 0) goto L47
                io.grpc.internal.b2$c0 r8 = r7.f4560b     // Catch: java.lang.Throwable -> L83
            L44:
                r8.f4528c = r4     // Catch: java.lang.Throwable -> L83
                goto L6e
            L47:
                io.grpc.internal.b2 r8 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2$t r8 = io.grpc.internal.b2.S(r8)     // Catch: java.lang.Throwable -> L83
                long r2 = r7.f4561c     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2 r9 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                long r5 = io.grpc.internal.b2.P(r9)     // Catch: java.lang.Throwable -> L83
                long r2 = r2 - r5
                long r8 = r8.a(r2)     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2 r2 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                long r5 = r7.f4561c     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2.Q(r2, r5)     // Catch: java.lang.Throwable -> L83
                io.grpc.internal.b2 r2 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                long r2 = io.grpc.internal.b2.T(r2)     // Catch: java.lang.Throwable -> L83
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 <= 0) goto L6e
                io.grpc.internal.b2$c0 r8 = r7.f4560b     // Catch: java.lang.Throwable -> L83
                goto L44
            L6e:
                io.grpc.internal.b2$c0 r8 = r7.f4560b     // Catch: java.lang.Throwable -> L83
                boolean r9 = r8.f4528c     // Catch: java.lang.Throwable -> L83
                if (r9 == 0) goto L7a
                io.grpc.internal.b2 r9 = io.grpc.internal.b2.this     // Catch: java.lang.Throwable -> L83
                java.lang.Runnable r0 = io.grpc.internal.b2.U(r9, r8)     // Catch: java.lang.Throwable -> L83
            L7a:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L83
                if (r0 == 0) goto L80
                r0.run()
            L80:
                return
            L81:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L83
                return
            L83:
                r8 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L83
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.b2.s.h(long):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class t {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicLong f4563a = new AtomicLong();

        long a(long j5) {
            return this.f4563a.addAndGet(j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class u {

        /* renamed from: a  reason: collision with root package name */
        final Object f4564a;

        /* renamed from: b  reason: collision with root package name */
        Future<?> f4565b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4566c;

        u(Object obj) {
            this.f4564a = obj;
        }

        boolean a() {
            return this.f4566c;
        }

        Future<?> b() {
            this.f4566c = true;
            return this.f4565b;
        }

        void c(Future<?> future) {
            synchronized (this.f4564a) {
                if (!this.f4566c) {
                    this.f4565b = future;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: a  reason: collision with root package name */
        final boolean f4567a;

        /* renamed from: b  reason: collision with root package name */
        final Integer f4568b;

        public v(boolean z4, Integer num) {
            this.f4567a = z4;
            this.f4568b = num;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final u f4569a;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c0 f4571a;

            a(c0 c0Var) {
                this.f4571a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                boolean z4;
                b2 b2Var;
                synchronized (b2.this.f4479i) {
                    uVar = null;
                    z4 = false;
                    if (w.this.f4569a.a()) {
                        z4 = true;
                    } else {
                        b2 b2Var2 = b2.this;
                        b2Var2.f4485o = b2Var2.f4485o.a(this.f4571a);
                        b2 b2Var3 = b2.this;
                        if (b2Var3.h0(b2Var3.f4485o) && (b2.this.f4483m == null || b2.this.f4483m.a())) {
                            b2Var = b2.this;
                            uVar = new u(b2Var.f4479i);
                        } else {
                            b2 b2Var4 = b2.this;
                            b2Var4.f4485o = b2Var4.f4485o.d();
                            b2Var = b2.this;
                        }
                        b2Var.f4493w = uVar;
                    }
                }
                if (z4) {
                    this.f4571a.f4526a.f(new b0(this.f4571a));
                    this.f4571a.f4526a.a(i3.j1.f3433g.q("Unneeded hedging"));
                    return;
                }
                if (uVar != null) {
                    uVar.c(b2.this.f4474d.schedule(new w(uVar), b2.this.f4477g.f5279b, TimeUnit.NANOSECONDS));
                }
                b2.this.f0(this.f4571a);
            }
        }

        w(u uVar) {
            this.f4569a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b2 b2Var = b2.this;
            c0 d02 = b2Var.d0(b2Var.f4485o.f4502e, false);
            if (d02 == null) {
                return;
            }
            b2.this.f4472b.execute(new a(d02));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class x {

        /* renamed from: a  reason: collision with root package name */
        final boolean f4573a;

        /* renamed from: b  reason: collision with root package name */
        final long f4574b;

        x(boolean z4, long j5) {
            this.f4573a = z4;
            this.f4574b = j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        private final i3.j1 f4575a;

        /* renamed from: b  reason: collision with root package name */
        private final t.a f4576b;

        /* renamed from: c  reason: collision with root package name */
        private final i3.y0 f4577c;

        y(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            this.f4575a = j1Var;
            this.f4576b = aVar;
            this.f4577c = y0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class z implements r {
        z() {
        }

        @Override // io.grpc.internal.b2.r
        public void a(c0 c0Var) {
            c0Var.f4526a.f(new b0(c0Var));
        }
    }

    static {
        y0.d<String> dVar = i3.y0.f3588e;
        A = y0.g.e("grpc-previous-rpc-attempts", dVar);
        B = y0.g.e("grpc-retry-pushback-ms", dVar);
        C = i3.j1.f3433g.q("Stream thrown away because RetriableStream committed");
        D = new Random();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b2(i3.z0<ReqT, ?> z0Var, i3.y0 y0Var, t tVar, long j5, long j6, Executor executor, ScheduledExecutorService scheduledExecutorService, c2 c2Var, v0 v0Var, d0 d0Var) {
        this.f4471a = z0Var;
        this.f4480j = tVar;
        this.f4481k = j5;
        this.f4482l = j6;
        this.f4472b = executor;
        this.f4474d = scheduledExecutorService;
        this.f4475e = y0Var;
        this.f4476f = c2Var;
        if (c2Var != null) {
            this.f4494x = c2Var.f4606b;
        }
        this.f4477g = v0Var;
        z0.k.e(c2Var == null || v0Var == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f4478h = v0Var != null;
        this.f4483m = d0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable b0(c0 c0Var) {
        Future<?> future;
        Future<?> future2;
        synchronized (this.f4479i) {
            if (this.f4485o.f4503f != null) {
                return null;
            }
            Collection<c0> collection = this.f4485o.f4500c;
            this.f4485o = this.f4485o.c(c0Var);
            this.f4480j.a(-this.f4490t);
            u uVar = this.f4492v;
            if (uVar != null) {
                Future<?> b5 = uVar.b();
                this.f4492v = null;
                future = b5;
            } else {
                future = null;
            }
            u uVar2 = this.f4493w;
            if (uVar2 != null) {
                Future<?> b6 = uVar2.b();
                this.f4493w = null;
                future2 = b6;
            } else {
                future2 = null;
            }
            return new c(collection, c0Var, future, future2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(c0 c0Var) {
        Runnable b02 = b0(c0Var);
        if (b02 != null) {
            b02.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c0 d0(int i5, boolean z4) {
        int i6;
        do {
            i6 = this.f4488r.get();
            if (i6 < 0) {
                return null;
            }
        } while (!this.f4488r.compareAndSet(i6, i6 + 1));
        c0 c0Var = new c0(i5);
        c0Var.f4526a = i0(o0(this.f4475e, i5), new o(new s(c0Var)), i5, z4);
        return c0Var;
    }

    private void e0(r rVar) {
        Collection<c0> collection;
        synchronized (this.f4479i) {
            if (!this.f4485o.f4498a) {
                this.f4485o.f4499b.add(rVar);
            }
            collection = this.f4485o.f4500c;
        }
        for (c0 c0Var : collection) {
            rVar.a(c0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
        r8.f4473c.execute(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r2 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
        r9.f4526a.f(new io.grpc.internal.b2.b0(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
        r0 = r9.f4526a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
        if (r8.f4485o.f4503f != r9) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        r9 = r8.f4495y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
        r9 = io.grpc.internal.b2.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        r0.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0084, code lost:
        r1 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008c, code lost:
        if (r1.hasNext() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
        r4 = (io.grpc.internal.b2.r) r1.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0099, code lost:
        if ((r4 instanceof io.grpc.internal.b2.z) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009b, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
        r4 = r8.f4485o;
        r5 = r4.f4503f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
        if (r5 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a2, code lost:
        if (r5 == r9) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
        if (r4.f4504g == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f0(io.grpc.internal.b2.c0 r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r3 = r0
            r2 = 0
        L4:
            java.lang.Object r4 = r8.f4479i
            monitor-enter(r4)
            io.grpc.internal.b2$a0 r5 = r8.f4485o     // Catch: java.lang.Throwable -> Lac
            io.grpc.internal.b2$c0 r6 = r5.f4503f     // Catch: java.lang.Throwable -> Lac
            if (r6 == 0) goto L11
            if (r6 == r9) goto L11
        Lf:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lac
            goto L32
        L11:
            boolean r6 = r5.f4504g     // Catch: java.lang.Throwable -> Lac
            if (r6 == 0) goto L16
            goto Lf
        L16:
            java.util.List<io.grpc.internal.b2$r> r6 = r5.f4499b     // Catch: java.lang.Throwable -> Lac
            int r6 = r6.size()     // Catch: java.lang.Throwable -> Lac
            if (r1 != r6) goto L57
            io.grpc.internal.b2$a0 r0 = r5.h(r9)     // Catch: java.lang.Throwable -> Lac
            r8.f4485o = r0     // Catch: java.lang.Throwable -> Lac
            boolean r0 = r8.i()     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto L2c
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lac
            return
        L2c:
            io.grpc.internal.b2$p r0 = new io.grpc.internal.b2$p     // Catch: java.lang.Throwable -> Lac
            r0.<init>()     // Catch: java.lang.Throwable -> Lac
            goto Lf
        L32:
            if (r0 == 0) goto L3a
            java.util.concurrent.Executor r9 = r8.f4473c
            r9.execute(r0)
            return
        L3a:
            if (r2 != 0) goto L46
            io.grpc.internal.s r0 = r9.f4526a
            io.grpc.internal.b2$b0 r1 = new io.grpc.internal.b2$b0
            r1.<init>(r9)
            r0.f(r1)
        L46:
            io.grpc.internal.s r0 = r9.f4526a
            io.grpc.internal.b2$a0 r1 = r8.f4485o
            io.grpc.internal.b2$c0 r1 = r1.f4503f
            if (r1 != r9) goto L51
            i3.j1 r9 = r8.f4495y
            goto L53
        L51:
            i3.j1 r9 = io.grpc.internal.b2.C
        L53:
            r0.a(r9)
            return
        L57:
            boolean r6 = r9.f4527b     // Catch: java.lang.Throwable -> Lac
            if (r6 == 0) goto L5d
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lac
            return
        L5d:
            int r6 = r1 + 128
            java.util.List<io.grpc.internal.b2$r> r7 = r5.f4499b     // Catch: java.lang.Throwable -> Lac
            int r7 = r7.size()     // Catch: java.lang.Throwable -> Lac
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> Lac
            if (r3 != 0) goto L77
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lac
            java.util.List<io.grpc.internal.b2$r> r5 = r5.f4499b     // Catch: java.lang.Throwable -> Lac
            java.util.List r1 = r5.subList(r1, r6)     // Catch: java.lang.Throwable -> Lac
            r3.<init>(r1)     // Catch: java.lang.Throwable -> Lac
            goto L83
        L77:
            r3.clear()     // Catch: java.lang.Throwable -> Lac
            java.util.List<io.grpc.internal.b2$r> r5 = r5.f4499b     // Catch: java.lang.Throwable -> Lac
            java.util.List r1 = r5.subList(r1, r6)     // Catch: java.lang.Throwable -> Lac
            r3.addAll(r1)     // Catch: java.lang.Throwable -> Lac
        L83:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lac
            java.util.Iterator r1 = r3.iterator()
        L88:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto La9
            java.lang.Object r4 = r1.next()
            io.grpc.internal.b2$r r4 = (io.grpc.internal.b2.r) r4
            r4.a(r9)
            boolean r4 = r4 instanceof io.grpc.internal.b2.z
            if (r4 == 0) goto L9c
            r2 = 1
        L9c:
            io.grpc.internal.b2$a0 r4 = r8.f4485o
            io.grpc.internal.b2$c0 r5 = r4.f4503f
            if (r5 == 0) goto La5
            if (r5 == r9) goto La5
            goto La9
        La5:
            boolean r4 = r4.f4504g
            if (r4 == 0) goto L88
        La9:
            r1 = r6
            goto L4
        Lac:
            r9 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lac
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.b2.f0(io.grpc.internal.b2$c0):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        Future<?> future;
        synchronized (this.f4479i) {
            u uVar = this.f4493w;
            future = null;
            if (uVar != null) {
                Future<?> b5 = uVar.b();
                this.f4493w = null;
                future = b5;
            }
            this.f4485o = this.f4485o.d();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h0(a0 a0Var) {
        return a0Var.f4503f == null && a0Var.f4502e < this.f4477g.f5278a && !a0Var.f4505h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            g0();
            return;
        }
        synchronized (this.f4479i) {
            u uVar = this.f4493w;
            if (uVar == null) {
                return;
            }
            Future<?> b5 = uVar.b();
            u uVar2 = new u(this.f4479i);
            this.f4493w = uVar2;
            if (b5 != null) {
                b5.cancel(false);
            }
            uVar2.c(this.f4474d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
        this.f4489s = new y(j1Var, aVar, y0Var);
        if (this.f4488r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f4473c.execute(new q(j1Var, aVar, y0Var));
        }
    }

    @Override // io.grpc.internal.s
    public final void a(i3.j1 j1Var) {
        c0 c0Var = new c0(0);
        c0Var.f4526a = new q1();
        Runnable b02 = b0(c0Var);
        if (b02 != null) {
            synchronized (this.f4479i) {
                this.f4485o = this.f4485o.h(c0Var);
            }
            b02.run();
            m0(j1Var, t.a.PROCESSED, new i3.y0());
            return;
        }
        c0 c0Var2 = null;
        synchronized (this.f4479i) {
            if (this.f4485o.f4500c.contains(this.f4485o.f4503f)) {
                c0Var2 = this.f4485o.f4503f;
            } else {
                this.f4495y = j1Var;
            }
            this.f4485o = this.f4485o.b();
        }
        if (c0Var2 != null) {
            c0Var2.f4526a.a(j1Var);
        }
    }

    @Override // io.grpc.internal.o2
    public final void b(i3.n nVar) {
        e0(new d(nVar));
    }

    @Override // io.grpc.internal.o2
    public final void c(int i5) {
        a0 a0Var = this.f4485o;
        if (a0Var.f4498a) {
            a0Var.f4503f.f4526a.c(i5);
        } else {
            e0(new m(i5));
        }
    }

    @Override // io.grpc.internal.s
    public final void d(int i5) {
        e0(new j(i5));
    }

    @Override // io.grpc.internal.s
    public final void e(int i5) {
        e0(new k(i5));
    }

    @Override // io.grpc.internal.s
    public final void f(io.grpc.internal.t tVar) {
        d0 d0Var;
        this.f4491u = tVar;
        i3.j1 k02 = k0();
        if (k02 != null) {
            a(k02);
            return;
        }
        synchronized (this.f4479i) {
            this.f4485o.f4499b.add(new z());
        }
        c0 d02 = d0(0, false);
        if (d02 == null) {
            return;
        }
        if (this.f4478h) {
            u uVar = null;
            synchronized (this.f4479i) {
                this.f4485o = this.f4485o.a(d02);
                if (h0(this.f4485o) && ((d0Var = this.f4483m) == null || d0Var.a())) {
                    uVar = new u(this.f4479i);
                    this.f4493w = uVar;
                }
            }
            if (uVar != null) {
                uVar.c(this.f4474d.schedule(new w(uVar), this.f4477g.f5279b, TimeUnit.NANOSECONDS));
            }
        }
        f0(d02);
    }

    @Override // io.grpc.internal.o2
    public final void flush() {
        a0 a0Var = this.f4485o;
        if (a0Var.f4498a) {
            a0Var.f4503f.f4526a.flush();
        } else {
            e0(new g());
        }
    }

    @Override // io.grpc.internal.s
    public final void g(i3.t tVar) {
        e0(new e(tVar));
    }

    @Override // io.grpc.internal.s
    public final void h(i3.v vVar) {
        e0(new f(vVar));
    }

    @Override // io.grpc.internal.o2
    public final boolean i() {
        for (c0 c0Var : this.f4485o.f4500c) {
            if (c0Var.f4526a.i()) {
                return true;
            }
        }
        return false;
    }

    abstract io.grpc.internal.s i0(i3.y0 y0Var, k.a aVar, int i5, boolean z4);

    @Override // io.grpc.internal.o2
    public final void j(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    abstract void j0();

    @Override // io.grpc.internal.s
    public final void k(String str) {
        e0(new b(str));
    }

    abstract i3.j1 k0();

    @Override // io.grpc.internal.s
    public void l(z0 z0Var) {
        a0 a0Var;
        z0 z0Var2;
        String str;
        synchronized (this.f4479i) {
            z0Var.b("closed", this.f4484n);
            a0Var = this.f4485o;
        }
        if (a0Var.f4503f != null) {
            z0Var2 = new z0();
            a0Var.f4503f.f4526a.l(z0Var2);
            str = "committed";
        } else {
            z0Var2 = new z0();
            for (c0 c0Var : a0Var.f4500c) {
                z0 z0Var3 = new z0();
                c0Var.f4526a.l(z0Var3);
                z0Var2.a(z0Var3);
            }
            str = "open";
        }
        z0Var.b(str, z0Var2);
    }

    @Override // io.grpc.internal.o2
    public void m() {
        e0(new l());
    }

    @Override // io.grpc.internal.s
    public final void n() {
        e0(new i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n0(ReqT reqt) {
        a0 a0Var = this.f4485o;
        if (a0Var.f4498a) {
            a0Var.f4503f.f4526a.j(this.f4471a.j(reqt));
        } else {
            e0(new n(reqt));
        }
    }

    final i3.y0 o0(i3.y0 y0Var, int i5) {
        i3.y0 y0Var2 = new i3.y0();
        y0Var2.m(y0Var);
        if (i5 > 0) {
            y0Var2.p(A, String.valueOf(i5));
        }
        return y0Var2;
    }

    @Override // io.grpc.internal.s
    public final void p(boolean z4) {
        e0(new h(z4));
    }
}
