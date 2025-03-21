package t4;

import com.google.android.gms.common.api.a;
import e4.r;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import m4.n0;
import r4.c0;
import r4.h0;
import s3.t;
/* loaded from: classes.dex */
public final class a implements Executor, Closeable {

    /* renamed from: l  reason: collision with root package name */
    public static final C0118a f7648l = new C0118a(null);

    /* renamed from: m  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f7649m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: n  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f7650n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: o  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7651o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: p  reason: collision with root package name */
    public static final h0 f7652p = new h0("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final int f7653a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7654b;

    /* renamed from: c  reason: collision with root package name */
    public final long f7655c;
    private volatile long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final String f7656d;

    /* renamed from: e  reason: collision with root package name */
    public final t4.d f7657e;

    /* renamed from: f  reason: collision with root package name */
    public final t4.d f7658f;

    /* renamed from: k  reason: collision with root package name */
    public final c0<c> f7659k;
    private volatile long parkedWorkersStack;

    /* renamed from: t4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0118a {
        private C0118a() {
        }

        public /* synthetic */ C0118a(e4.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7660a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f7660a = iArr;
        }
    }

    /* loaded from: classes.dex */
    public final class c extends Thread {

        /* renamed from: m  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f7661m = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final n f7662a;

        /* renamed from: b  reason: collision with root package name */
        private final r<h> f7663b;

        /* renamed from: c  reason: collision with root package name */
        public d f7664c;

        /* renamed from: d  reason: collision with root package name */
        private long f7665d;

        /* renamed from: e  reason: collision with root package name */
        private long f7666e;

        /* renamed from: f  reason: collision with root package name */
        private int f7667f;
        private volatile int indexInArray;

        /* renamed from: k  reason: collision with root package name */
        public boolean f7668k;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.f7662a = new n();
            this.f7663b = new r<>();
            this.f7664c = d.DORMANT;
            this.nextParkedWorker = a.f7652p;
            this.f7667f = f4.c.f3050a.b();
        }

        public c(a aVar, int i5) {
            this();
            q(i5);
        }

        private final void b(int i5) {
            if (i5 == 0) {
                return;
            }
            a.f7650n.addAndGet(a.this, -2097152L);
            if (this.f7664c != d.TERMINATED) {
                this.f7664c = d.DORMANT;
            }
        }

        private final void c(int i5) {
            if (i5 != 0 && u(d.BLOCKING)) {
                a.this.D();
            }
        }

        private final void d(h hVar) {
            int b5 = hVar.f7686b.b();
            k(b5);
            c(b5);
            a.this.w(hVar);
            b(b5);
        }

        private final h e(boolean z4) {
            h o5;
            h o6;
            if (z4) {
                boolean z5 = m(a.this.f7653a * 2) == 0;
                if (z5 && (o6 = o()) != null) {
                    return o6;
                }
                h g5 = this.f7662a.g();
                if (g5 != null) {
                    return g5;
                }
                if (!z5 && (o5 = o()) != null) {
                    return o5;
                }
            } else {
                h o7 = o();
                if (o7 != null) {
                    return o7;
                }
            }
            return v(3);
        }

        private final h f() {
            h h5 = this.f7662a.h();
            if (h5 == null) {
                h d5 = a.this.f7658f.d();
                return d5 == null ? v(1) : d5;
            }
            return h5;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f7661m;
        }

        private final void k(int i5) {
            this.f7665d = 0L;
            if (this.f7664c == d.PARKING) {
                this.f7664c = d.BLOCKING;
            }
        }

        private final boolean l() {
            return this.nextParkedWorker != a.f7652p;
        }

        private final void n() {
            if (this.f7665d == 0) {
                this.f7665d = System.nanoTime() + a.this.f7655c;
            }
            LockSupport.parkNanos(a.this.f7655c);
            if (System.nanoTime() - this.f7665d >= 0) {
                this.f7665d = 0L;
                w();
            }
        }

        private final h o() {
            t4.d dVar;
            if (m(2) == 0) {
                h d5 = a.this.f7657e.d();
                if (d5 != null) {
                    return d5;
                }
                dVar = a.this.f7658f;
            } else {
                h d6 = a.this.f7658f.d();
                if (d6 != null) {
                    return d6;
                }
                dVar = a.this.f7657e;
            }
            return dVar.d();
        }

        private final void p() {
            loop0: while (true) {
                boolean z4 = false;
                while (!a.this.isTerminated() && this.f7664c != d.TERMINATED) {
                    h g5 = g(this.f7668k);
                    if (g5 != null) {
                        this.f7666e = 0L;
                        d(g5);
                    } else {
                        this.f7668k = false;
                        if (this.f7666e == 0) {
                            t();
                        } else if (z4) {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f7666e);
                            this.f7666e = 0L;
                        } else {
                            z4 = true;
                        }
                    }
                }
            }
            u(d.TERMINATED);
        }

        private final boolean s() {
            boolean z4;
            if (this.f7664c != d.CPU_ACQUIRED) {
                a aVar = a.this;
                AtomicLongFieldUpdater atomicLongFieldUpdater = a.f7650n;
                while (true) {
                    long j5 = atomicLongFieldUpdater.get(aVar);
                    if (((int) ((9223367638808264704L & j5) >> 42)) != 0) {
                        if (a.f7650n.compareAndSet(aVar, j5, j5 - 4398046511104L)) {
                            z4 = true;
                            break;
                        }
                    } else {
                        z4 = false;
                        break;
                    }
                }
                if (!z4) {
                    return false;
                }
                this.f7664c = d.CPU_ACQUIRED;
            }
            return true;
        }

        private final void t() {
            if (!l()) {
                a.this.u(this);
                return;
            }
            f7661m.set(this, -1);
            while (l() && f7661m.get(this) == -1 && !a.this.isTerminated() && this.f7664c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final h v(int i5) {
            int i6 = (int) (a.f7650n.get(a.this) & 2097151);
            if (i6 < 2) {
                return null;
            }
            int m5 = m(i6);
            a aVar = a.this;
            long j5 = Long.MAX_VALUE;
            for (int i7 = 0; i7 < i6; i7++) {
                m5++;
                if (m5 > i6) {
                    m5 = 1;
                }
                c b5 = aVar.f7659k.b(m5);
                if (b5 != null && b5 != this) {
                    long n5 = b5.f7662a.n(i5, this.f7663b);
                    if (n5 == -1) {
                        r<h> rVar = this.f7663b;
                        h hVar = rVar.f2939a;
                        rVar.f2939a = null;
                        return hVar;
                    } else if (n5 > 0) {
                        j5 = Math.min(j5, n5);
                    }
                }
            }
            if (j5 == Long.MAX_VALUE) {
                j5 = 0;
            }
            this.f7666e = j5;
            return null;
        }

        private final void w() {
            a aVar = a.this;
            synchronized (aVar.f7659k) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (a.f7650n.get(aVar) & 2097151)) <= aVar.f7653a) {
                    return;
                }
                if (f7661m.compareAndSet(this, -1, 1)) {
                    int i5 = this.indexInArray;
                    q(0);
                    aVar.v(this, i5, 0);
                    int andDecrement = (int) (a.f7650n.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != i5) {
                        c b5 = aVar.f7659k.b(andDecrement);
                        e4.k.b(b5);
                        c cVar = b5;
                        aVar.f7659k.c(i5, cVar);
                        cVar.q(i5);
                        aVar.v(cVar, andDecrement, i5);
                    }
                    aVar.f7659k.c(andDecrement, null);
                    t tVar = t.f7573a;
                    this.f7664c = d.TERMINATED;
                }
            }
        }

        public final h g(boolean z4) {
            return s() ? e(z4) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i5) {
            int i6 = this.f7667f;
            int i7 = i6 ^ (i6 << 13);
            int i8 = i7 ^ (i7 >> 17);
            int i9 = i8 ^ (i8 << 5);
            this.f7667f = i9;
            int i10 = i5 - 1;
            return (i10 & i5) == 0 ? i9 & i10 : (i9 & a.e.API_PRIORITY_OTHER) % i5;
        }

        public final void q(int i5) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f7656d);
            sb.append("-worker-");
            sb.append(i5 == 0 ? "TERMINATED" : String.valueOf(i5));
            setName(sb.toString());
            this.indexInArray = i5;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean u(d dVar) {
            d dVar2 = this.f7664c;
            boolean z4 = dVar2 == d.CPU_ACQUIRED;
            if (z4) {
                a.f7650n.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f7664c = dVar;
            }
            return z4;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i5, int i6, long j5, String str) {
        this.f7653a = i5;
        this.f7654b = i6;
        this.f7655c = j5;
        this.f7656d = str;
        if (!(i5 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i5 + " should be at least 1").toString());
        }
        if (!(i6 >= i5)) {
            throw new IllegalArgumentException(("Max pool size " + i6 + " should be greater than or equals to core pool size " + i5).toString());
        }
        if (!(i6 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i6 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j5 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
        this.f7657e = new t4.d();
        this.f7658f = new t4.d();
        this.f7659k = new c0<>((i5 + 1) * 2);
        this.controlState = i5 << 42;
        this._isTerminated = 0;
    }

    private final void A(long j5, boolean z4) {
        if (z4 || L() || J(j5)) {
            return;
        }
        L();
    }

    private final h I(c cVar, h hVar, boolean z4) {
        if (cVar == null || cVar.f7664c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f7686b.b() == 0 && cVar.f7664c == d.BLOCKING) {
            return hVar;
        }
        cVar.f7668k = true;
        return cVar.f7662a.a(hVar, z4);
    }

    private final boolean J(long j5) {
        int a5;
        a5 = h4.l.a(((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21)), 0);
        if (a5 < this.f7653a) {
            int g5 = g();
            if (g5 == 1 && this.f7653a > 1) {
                g();
            }
            if (g5 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean K(a aVar, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j5 = f7650n.get(aVar);
        }
        return aVar.J(j5);
    }

    private final boolean L() {
        c r5;
        do {
            r5 = r();
            if (r5 == null) {
                return false;
            }
        } while (!c.j().compareAndSet(r5, -1, 0));
        LockSupport.unpark(r5);
        return true;
    }

    private final boolean d(h hVar) {
        return (hVar.f7686b.b() == 1 ? this.f7658f : this.f7657e).a(hVar);
    }

    private final int g() {
        int a5;
        synchronized (this.f7659k) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f7650n;
            long j5 = atomicLongFieldUpdater.get(this);
            int i5 = (int) (j5 & 2097151);
            a5 = h4.l.a(i5 - ((int) ((j5 & 4398044413952L) >> 21)), 0);
            if (a5 >= this.f7653a) {
                return 0;
            }
            if (i5 >= this.f7654b) {
                return 0;
            }
            int i6 = ((int) (f7650n.get(this) & 2097151)) + 1;
            if (i6 > 0 && this.f7659k.b(i6) == null) {
                c cVar = new c(this, i6);
                this.f7659k.c(i6, cVar);
                if (i6 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    int i7 = a5 + 1;
                    cVar.start();
                    return i7;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final c j() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !e4.k.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void n(a aVar, Runnable runnable, i iVar, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            iVar = l.f7695g;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        aVar.l(runnable, iVar, z4);
    }

    private final int p(c cVar) {
        int h5;
        do {
            Object i5 = cVar.i();
            if (i5 == f7652p) {
                return -1;
            }
            if (i5 == null) {
                return 0;
            }
            cVar = (c) i5;
            h5 = cVar.h();
        } while (h5 == 0);
        return h5;
    }

    private final c r() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7649m;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            c b5 = this.f7659k.b((int) (2097151 & j5));
            if (b5 == null) {
                return null;
            }
            long j6 = (2097152 + j5) & (-2097152);
            int p5 = p(b5);
            if (p5 >= 0 && f7649m.compareAndSet(this, j5, p5 | j6)) {
                b5.r(f7652p);
                return b5;
            }
        }
    }

    public final void D() {
        if (L() || K(this, 0L, 1, null)) {
            return;
        }
        L();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        n(this, runnable, null, false, 6, null);
    }

    public final h i(Runnable runnable, i iVar) {
        long a5 = l.f7694f.a();
        if (runnable instanceof h) {
            h hVar = (h) runnable;
            hVar.f7685a = a5;
            hVar.f7686b = iVar;
            return hVar;
        }
        return new k(runnable, a5, iVar);
    }

    public final boolean isTerminated() {
        return f7651o.get(this) != 0;
    }

    public final void l(Runnable runnable, i iVar, boolean z4) {
        m4.c.a();
        h i5 = i(runnable, iVar);
        boolean z5 = false;
        boolean z6 = i5.f7686b.b() == 1;
        long addAndGet = z6 ? f7650n.addAndGet(this, 2097152L) : 0L;
        c j5 = j();
        h I = I(j5, i5, z4);
        if (I != null && !d(I)) {
            throw new RejectedExecutionException(this.f7656d + " was terminated");
        }
        if (z4 && j5 != null) {
            z5 = true;
        }
        if (z6) {
            A(addAndGet, z5);
        } else if (z5) {
        } else {
            D();
        }
    }

    public String toString() {
        StringBuilder sb;
        char c5;
        ArrayList arrayList = new ArrayList();
        int a5 = this.f7659k.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < a5; i10++) {
            c b5 = this.f7659k.b(i10);
            if (b5 != null) {
                int e5 = b5.f7662a.e();
                int i11 = b.f7660a[b5.f7664c.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        i6++;
                        sb = new StringBuilder();
                        sb.append(e5);
                        c5 = 'b';
                    } else if (i11 == 3) {
                        i5++;
                        sb = new StringBuilder();
                        sb.append(e5);
                        c5 = 'c';
                    } else if (i11 == 4) {
                        i8++;
                        if (e5 > 0) {
                            sb = new StringBuilder();
                            sb.append(e5);
                            c5 = 'd';
                        }
                    } else if (i11 == 5) {
                        i9++;
                    }
                    sb.append(c5);
                    arrayList.add(sb.toString());
                } else {
                    i7++;
                }
            }
        }
        long j5 = f7650n.get(this);
        return this.f7656d + '@' + n0.b(this) + "[Pool Size {core = " + this.f7653a + ", max = " + this.f7654b + "}, Worker States {CPU = " + i5 + ", blocking = " + i6 + ", parked = " + i7 + ", dormant = " + i8 + ", terminated = " + i9 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f7657e.c() + ", global blocking queue size = " + this.f7658f.c() + ", Control State {created workers= " + ((int) (2097151 & j5)) + ", blocking tasks = " + ((int) ((4398044413952L & j5) >> 21)) + ", CPUs acquired = " + (this.f7653a - ((int) ((9223367638808264704L & j5) >> 42))) + "}]";
    }

    public final boolean u(c cVar) {
        long j5;
        int h5;
        if (cVar.i() != f7652p) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7649m;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            h5 = cVar.h();
            cVar.r(this.f7659k.b((int) (2097151 & j5)));
        } while (!f7649m.compareAndSet(this, j5, ((2097152 + j5) & (-2097152)) | h5));
        return true;
    }

    public final void v(c cVar, int i5, int i6) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7649m;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            int i7 = (int) (2097151 & j5);
            long j6 = (2097152 + j5) & (-2097152);
            if (i7 == i5) {
                i7 = i6 == 0 ? p(cVar) : i6;
            }
            if (i7 >= 0 && f7649m.compareAndSet(this, j5, j6 | i7)) {
                return;
            }
        }
    }

    public final void w(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void z(long j5) {
        int i5;
        h d5;
        if (f7651o.compareAndSet(this, 0, 1)) {
            c j6 = j();
            synchronized (this.f7659k) {
                i5 = (int) (f7650n.get(this) & 2097151);
            }
            if (1 <= i5) {
                int i6 = 1;
                while (true) {
                    c b5 = this.f7659k.b(i6);
                    e4.k.b(b5);
                    c cVar = b5;
                    if (cVar != j6) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j5);
                        }
                        cVar.f7662a.f(this.f7658f);
                    }
                    if (i6 == i5) {
                        break;
                    }
                    i6++;
                }
            }
            this.f7658f.b();
            this.f7657e.b();
            while (true) {
                if (j6 != null) {
                    d5 = j6.g(true);
                    if (d5 != null) {
                        continue;
                        w(d5);
                    }
                }
                d5 = this.f7657e.d();
                if (d5 == null && (d5 = this.f7658f.d()) == null) {
                    break;
                }
                w(d5);
            }
            if (j6 != null) {
                j6.u(d.TERMINATED);
            }
            f7649m.set(this, 0L);
            f7650n.set(this, 0L);
        }
    }
}
