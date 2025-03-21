package r4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import m4.b1;
import m4.s0;
/* loaded from: classes.dex */
public final class o extends m4.g0 implements s0 {

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7214l = AtomicIntegerFieldUpdater.newUpdater(o.class, "runningWorkers");

    /* renamed from: c  reason: collision with root package name */
    private final m4.g0 f7215c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7216d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ s0 f7217e;

    /* renamed from: f  reason: collision with root package name */
    private final t<Runnable> f7218f;

    /* renamed from: k  reason: collision with root package name */
    private final Object f7219k;
    private volatile int runningWorkers;

    /* loaded from: classes.dex */
    private final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f7220a;

        public a(Runnable runnable) {
            this.f7220a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i5 = 0;
            while (true) {
                try {
                    this.f7220a.run();
                } catch (Throwable th) {
                    m4.i0.a(v3.h.f8175a, th);
                }
                Runnable k02 = o.this.k0();
                if (k02 == null) {
                    return;
                }
                this.f7220a = k02;
                i5++;
                if (i5 >= 16 && o.this.f7215c.g0(o.this)) {
                    o.this.f7215c.f0(o.this, this);
                    return;
                }
            }
        }
    }

    public o(m4.g0 g0Var, int i5) {
        this.f7215c = g0Var;
        this.f7216d = i5;
        s0 s0Var = g0Var instanceof s0 ? (s0) g0Var : null;
        this.f7217e = s0Var == null ? m4.p0.a() : s0Var;
        this.f7218f = new t<>(false);
        this.f7219k = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable k0() {
        while (true) {
            Runnable d5 = this.f7218f.d();
            if (d5 != null) {
                return d5;
            }
            synchronized (this.f7219k) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7214l;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f7218f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean l0() {
        boolean z4;
        synchronized (this.f7219k) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7214l;
            if (atomicIntegerFieldUpdater.get(this) >= this.f7216d) {
                z4 = false;
            } else {
                atomicIntegerFieldUpdater.incrementAndGet(this);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // m4.g0
    public void f0(v3.g gVar, Runnable runnable) {
        Runnable k02;
        this.f7218f.a(runnable);
        if (f7214l.get(this) >= this.f7216d || !l0() || (k02 = k0()) == null) {
            return;
        }
        this.f7215c.f0(this, new a(k02));
    }

    @Override // m4.s0
    public b1 l(long j5, Runnable runnable, v3.g gVar) {
        return this.f7217e.l(j5, runnable, gVar);
    }
}
