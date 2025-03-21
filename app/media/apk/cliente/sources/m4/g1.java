package m4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.s0;
/* loaded from: classes.dex */
public abstract class g1 extends h1 implements s0 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6235f = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_queue");

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6236k = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_delayed");

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f6237l = AtomicIntegerFieldUpdater.newUpdater(g1.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* loaded from: classes.dex */
    private static final class a extends b {

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f6238c;

        public a(long j5, Runnable runnable) {
            super(j5);
            this.f6238c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6238c.run();
        }

        @Override // m4.g1.b
        public String toString() {
            return super.toString() + this.f6238c;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b implements Runnable, Comparable<b>, b1, r4.o0 {
        private volatile Object _heap;

        /* renamed from: a  reason: collision with root package name */
        public long f6239a;

        /* renamed from: b  reason: collision with root package name */
        private int f6240b = -1;

        public b(long j5) {
            this.f6239a = j5;
        }

        @Override // m4.b1
        public final void a() {
            r4.h0 h0Var;
            r4.h0 h0Var2;
            synchronized (this) {
                Object obj = this._heap;
                h0Var = j1.f6245a;
                if (obj == h0Var) {
                    return;
                }
                c cVar = obj instanceof c ? (c) obj : null;
                if (cVar != null) {
                    cVar.g(this);
                }
                h0Var2 = j1.f6245a;
                this._heap = h0Var2;
                s3.t tVar = s3.t.f7573a;
            }
        }

        @Override // r4.o0
        public void c(r4.n0<?> n0Var) {
            r4.h0 h0Var;
            Object obj = this._heap;
            h0Var = j1.f6245a;
            if (!(obj != h0Var)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = n0Var;
        }

        @Override // r4.o0
        public r4.n0<?> d() {
            Object obj = this._heap;
            if (obj instanceof r4.n0) {
                return (r4.n0) obj;
            }
            return null;
        }

        @Override // r4.o0
        public int getIndex() {
            return this.f6240b;
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(b bVar) {
            int i5 = ((this.f6239a - bVar.f6239a) > 0L ? 1 : ((this.f6239a - bVar.f6239a) == 0L ? 0 : -1));
            if (i5 > 0) {
                return 1;
            }
            return i5 < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0040 A[Catch: all -> 0x0048, TryCatch #1 {, blocks: (B:3:0x0001, B:8:0x000c, B:12:0x001a, B:29:0x0045, B:9:0x000d, B:17:0x0021, B:25:0x0037, B:27:0x0040, B:28:0x0042, B:18:0x0024, B:22:0x002e), top: B:37:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int k(long r8, m4.g1.c r10, m4.g1 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch: java.lang.Throwable -> L4b
                r4.h0 r1 = m4.j1.b()     // Catch: java.lang.Throwable -> L4b
                if (r0 != r1) goto Lc
                r8 = 2
            La:
                monitor-exit(r7)
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4b
                r4.o0 r0 = r10.b()     // Catch: java.lang.Throwable -> L48
                m4.g1$b r0 = (m4.g1.b) r0     // Catch: java.lang.Throwable -> L48
                boolean r11 = m4.g1.u0(r11)     // Catch: java.lang.Throwable -> L48
                if (r11 == 0) goto L1d
                r8 = 1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r7)
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f6241c = r8     // Catch: java.lang.Throwable -> L48
                goto L37
            L24:
                long r3 = r0.f6239a     // Catch: java.lang.Throwable -> L48
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f6241c     // Catch: java.lang.Throwable -> L48
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.f6239a     // Catch: java.lang.Throwable -> L48
                long r3 = r10.f6241c     // Catch: java.lang.Throwable -> L48
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L42
                r7.f6239a = r3     // Catch: java.lang.Throwable -> L48
            L42:
                r10.a(r7)     // Catch: java.lang.Throwable -> L48
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                r8 = 0
                goto La
            L48:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                throw r8     // Catch: java.lang.Throwable -> L4b
            L4b:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: m4.g1.b.k(long, m4.g1$c, m4.g1):int");
        }

        public final boolean m(long j5) {
            return j5 - this.f6239a >= 0;
        }

        @Override // r4.o0
        public void setIndex(int i5) {
            this.f6240b = i5;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f6239a + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends r4.n0<b> {

        /* renamed from: c  reason: collision with root package name */
        public long f6241c;

        public c(long j5) {
            this.f6241c = j5;
        }
    }

    private final void C0() {
        b i5;
        m4.c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f6236k.get(this);
            if (cVar == null || (i5 = cVar.i()) == null) {
                return;
            }
            s0(nanoTime, i5);
        }
    }

    private final int F0(long j5, b bVar) {
        if (z0()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6236k;
        c cVar = (c) atomicReferenceFieldUpdater.get(this);
        if (cVar == null) {
            androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, new c(j5));
            Object obj = atomicReferenceFieldUpdater.get(this);
            e4.k.b(obj);
            cVar = (c) obj;
        }
        return bVar.k(j5, cVar, this);
    }

    private final void H0(boolean z4) {
        f6237l.set(this, z4 ? 1 : 0);
    }

    private final boolean I0(b bVar) {
        c cVar = (c) f6236k.get(this);
        return (cVar != null ? cVar.e() : null) == bVar;
    }

    private final void v0() {
        r4.h0 h0Var;
        r4.h0 h0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6235f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6235f;
                h0Var = j1.f6246b;
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater2, this, null, h0Var)) {
                    return;
                }
            } else if (obj instanceof r4.u) {
                ((r4.u) obj).d();
                return;
            } else {
                h0Var2 = j1.f6246b;
                if (obj == h0Var2) {
                    return;
                }
                r4.u uVar = new r4.u(8, true);
                e4.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                uVar.a((Runnable) obj);
                if (androidx.concurrent.futures.b.a(f6235f, this, obj, uVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable w0() {
        r4.h0 h0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6235f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof r4.u) {
                e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                r4.u uVar = (r4.u) obj;
                Object j5 = uVar.j();
                if (j5 != r4.u.f7236h) {
                    return (Runnable) j5;
                }
                androidx.concurrent.futures.b.a(f6235f, this, obj, uVar.i());
            } else {
                h0Var = j1.f6246b;
                if (obj == h0Var) {
                    return null;
                }
                if (androidx.concurrent.futures.b.a(f6235f, this, obj, null)) {
                    e4.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean y0(Runnable runnable) {
        r4.h0 h0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6235f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (z0()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f6235f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof r4.u) {
                e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                r4.u uVar = (r4.u) obj;
                int a5 = uVar.a(runnable);
                if (a5 == 0) {
                    return true;
                }
                if (a5 == 1) {
                    androidx.concurrent.futures.b.a(f6235f, this, obj, uVar.i());
                } else if (a5 == 2) {
                    return false;
                }
            } else {
                h0Var = j1.f6246b;
                if (obj == h0Var) {
                    return false;
                }
                r4.u uVar2 = new r4.u(8, true);
                e4.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                uVar2.a((Runnable) obj);
                uVar2.a(runnable);
                if (androidx.concurrent.futures.b.a(f6235f, this, obj, uVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z0() {
        return f6237l.get(this) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean A0() {
        r4.h0 h0Var;
        if (p0()) {
            c cVar = (c) f6236k.get(this);
            if (cVar == null || cVar.d()) {
                Object obj = f6235f.get(this);
                if (obj != null) {
                    if (obj instanceof r4.u) {
                        return ((r4.u) obj).g();
                    }
                    h0Var = j1.f6246b;
                    if (obj != h0Var) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long B0() {
        /*
            r9 = this;
            boolean r0 = r9.q0()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m4.g1.f6236k
            java.lang.Object r0 = r0.get(r9)
            m4.g1$c r0 = (m4.g1.c) r0
            if (r0 == 0) goto L49
            boolean r3 = r0.d()
            if (r3 != 0) goto L49
            m4.c.a()
            long r3 = java.lang.System.nanoTime()
        L20:
            monitor-enter(r0)
            r4.o0 r5 = r0.b()     // Catch: java.lang.Throwable -> L46
            r6 = 0
            if (r5 != 0) goto L2a
        L28:
            monitor-exit(r0)
            goto L41
        L2a:
            m4.g1$b r5 = (m4.g1.b) r5     // Catch: java.lang.Throwable -> L46
            boolean r7 = r5.m(r3)     // Catch: java.lang.Throwable -> L46
            r8 = 0
            if (r7 == 0) goto L38
            boolean r5 = r9.y0(r5)     // Catch: java.lang.Throwable -> L46
            goto L39
        L38:
            r5 = 0
        L39:
            if (r5 == 0) goto L28
            r4.o0 r5 = r0.h(r8)     // Catch: java.lang.Throwable -> L46
            r6 = r5
            goto L28
        L41:
            m4.g1$b r6 = (m4.g1.b) r6
            if (r6 != 0) goto L20
            goto L49
        L46:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L49:
            java.lang.Runnable r0 = r9.w0()
            if (r0 == 0) goto L53
            r0.run()
            return r1
        L53:
            long r0 = r9.l0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.g1.B0():long");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D0() {
        f6235f.set(this, null);
        f6236k.set(this, null);
    }

    public final void E0(long j5, b bVar) {
        int F0 = F0(j5, bVar);
        if (F0 == 0) {
            if (I0(bVar)) {
                t0();
            }
        } else if (F0 == 1) {
            s0(j5, bVar);
        } else if (F0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b1 G0(long j5, Runnable runnable) {
        long c5 = j1.c(j5);
        if (c5 < 4611686018427387903L) {
            m4.c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(c5 + nanoTime, runnable);
            E0(nanoTime, aVar);
            return aVar;
        }
        return h2.f6244a;
    }

    @Override // m4.g0
    public final void f0(v3.g gVar, Runnable runnable) {
        x0(runnable);
    }

    @Override // m4.s0
    public b1 l(long j5, Runnable runnable, v3.g gVar) {
        return s0.a.a(this, j5, runnable, gVar);
    }

    @Override // m4.f1
    protected long l0() {
        b e5;
        long b5;
        r4.h0 h0Var;
        if (super.l0() == 0) {
            return 0L;
        }
        Object obj = f6235f.get(this);
        if (obj != null) {
            if (!(obj instanceof r4.u)) {
                h0Var = j1.f6246b;
                return obj == h0Var ? Long.MAX_VALUE : 0L;
            } else if (!((r4.u) obj).g()) {
                return 0L;
            }
        }
        c cVar = (c) f6236k.get(this);
        if (cVar == null || (e5 = cVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j5 = e5.f6239a;
        m4.c.a();
        b5 = h4.l.b(j5 - System.nanoTime(), 0L);
        return b5;
    }

    @Override // m4.f1
    public void shutdown() {
        q2.f6272a.b();
        H0(true);
        v0();
        do {
        } while (B0() <= 0);
        C0();
    }

    public void x0(Runnable runnable) {
        if (y0(runnable)) {
            t0();
        } else {
            o0.f6264m.x0(runnable);
        }
    }
}
