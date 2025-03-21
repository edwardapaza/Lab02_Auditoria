package o4;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.b3;
import r4.e0;
import r4.f0;
import r4.g0;
import r4.h0;
import r4.q0;
import r4.z;
import s3.m;
/* loaded from: classes.dex */
public class b<E> implements d<E> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f6790d = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f6791e = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f6792f = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f6793k = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6794l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");

    /* renamed from: m  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6795m = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* renamed from: n  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6796n = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* renamed from: o  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6797o = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* renamed from: p  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6798p = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* renamed from: a  reason: collision with root package name */
    private final int f6799a;

    /* renamed from: b  reason: collision with root package name */
    public final d4.l<E, s3.t> f6800b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c  reason: collision with root package name */
    private final d4.q<u4.b<?>, Object, Object, d4.l<Throwable, s3.t>> f6801c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements f<E>, b3 {

        /* renamed from: a  reason: collision with root package name */
        private Object f6802a;

        /* renamed from: b  reason: collision with root package name */
        private m4.m<? super Boolean> f6803b;

        public a() {
            h0 h0Var;
            h0Var = o4.c.f6826p;
            this.f6802a = h0Var;
        }

        private final Object e(j<E> jVar, int i5, long j5, v3.d<? super Boolean> dVar) {
            v3.d b5;
            h0 h0Var;
            h0 h0Var2;
            Boolean a5;
            h0 h0Var3;
            h0 h0Var4;
            h0 h0Var5;
            Object c5;
            b<E> bVar = b.this;
            b5 = w3.c.b(dVar);
            m4.m b6 = m4.o.b(b5);
            try {
                this.f6803b = b6;
                Object u02 = bVar.u0(jVar, i5, j5, this);
                h0Var = o4.c.f6823m;
                if (u02 == h0Var) {
                    bVar.h0(this, jVar, i5);
                } else {
                    h0Var2 = o4.c.f6825o;
                    d4.l<Throwable, s3.t> lVar = null;
                    if (u02 == h0Var2) {
                        if (j5 < bVar.L()) {
                            jVar.b();
                        }
                        j jVar2 = (j) b.f6795m.get(bVar);
                        while (true) {
                            if (bVar.S()) {
                                h();
                                break;
                            }
                            long andIncrement = b.f6791e.getAndIncrement(bVar);
                            int i6 = o4.c.f6812b;
                            long j6 = andIncrement / i6;
                            int i7 = (int) (andIncrement % i6);
                            if (jVar2.f7187c != j6) {
                                j E = bVar.E(j6, jVar2);
                                if (E != null) {
                                    jVar2 = E;
                                }
                            }
                            Object u03 = bVar.u0(jVar2, i7, andIncrement, this);
                            h0Var3 = o4.c.f6823m;
                            if (u03 == h0Var3) {
                                bVar.h0(this, jVar2, i7);
                                break;
                            }
                            h0Var4 = o4.c.f6825o;
                            if (u03 != h0Var4) {
                                h0Var5 = o4.c.f6824n;
                                if (u03 == h0Var5) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                jVar2.b();
                                this.f6802a = u03;
                                this.f6803b = null;
                                a5 = kotlin.coroutines.jvm.internal.b.a(true);
                                d4.l<E, s3.t> lVar2 = bVar.f6800b;
                                if (lVar2 != null) {
                                    lVar = z.a(lVar2, u03, b6.getContext());
                                }
                            } else if (andIncrement < bVar.L()) {
                                jVar2.b();
                            }
                        }
                    } else {
                        jVar.b();
                        this.f6802a = u02;
                        this.f6803b = null;
                        a5 = kotlin.coroutines.jvm.internal.b.a(true);
                        d4.l<E, s3.t> lVar3 = bVar.f6800b;
                        if (lVar3 != null) {
                            lVar = z.a(lVar3, u02, b6.getContext());
                        }
                    }
                    b6.e(a5, lVar);
                }
                Object y4 = b6.y();
                c5 = w3.d.c();
                if (y4 == c5) {
                    kotlin.coroutines.jvm.internal.h.c(dVar);
                }
                return y4;
            } catch (Throwable th) {
                b6.J();
                throw th;
            }
        }

        private final boolean g() {
            this.f6802a = o4.c.z();
            Throwable H = b.this.H();
            if (H == null) {
                return false;
            }
            throw g0.a(H);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            Object a5;
            m4.m<? super Boolean> mVar = this.f6803b;
            e4.k.b(mVar);
            this.f6803b = null;
            this.f6802a = o4.c.z();
            Throwable H = b.this.H();
            if (H == null) {
                m.a aVar = s3.m.f7565b;
                a5 = Boolean.FALSE;
            } else {
                m.a aVar2 = s3.m.f7565b;
                a5 = s3.n.a(H);
            }
            mVar.resumeWith(s3.m.b(a5));
        }

        @Override // o4.f
        public Object a(v3.d<? super Boolean> dVar) {
            boolean g5;
            j<E> jVar;
            h0 h0Var;
            h0 h0Var2;
            h0 h0Var3;
            b<E> bVar = b.this;
            j<E> jVar2 = (j) b.f6795m.get(bVar);
            while (true) {
                if (bVar.S()) {
                    g5 = g();
                    break;
                }
                long andIncrement = b.f6791e.getAndIncrement(bVar);
                int i5 = o4.c.f6812b;
                long j5 = andIncrement / i5;
                int i6 = (int) (andIncrement % i5);
                if (jVar2.f7187c != j5) {
                    j<E> E = bVar.E(j5, jVar2);
                    if (E == null) {
                        continue;
                    } else {
                        jVar = E;
                    }
                } else {
                    jVar = jVar2;
                }
                Object u02 = bVar.u0(jVar, i6, andIncrement, null);
                h0Var = o4.c.f6823m;
                if (u02 == h0Var) {
                    throw new IllegalStateException("unreachable".toString());
                }
                h0Var2 = o4.c.f6825o;
                if (u02 == h0Var2) {
                    if (andIncrement < bVar.L()) {
                        jVar.b();
                    }
                    jVar2 = jVar;
                } else {
                    h0Var3 = o4.c.f6824n;
                    if (u02 == h0Var3) {
                        return e(jVar, i6, andIncrement, dVar);
                    }
                    jVar.b();
                    this.f6802a = u02;
                    g5 = true;
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(g5);
        }

        @Override // m4.b3
        public void f(e0<?> e0Var, int i5) {
            m4.m<? super Boolean> mVar = this.f6803b;
            if (mVar != null) {
                mVar.f(e0Var, i5);
            }
        }

        public final boolean i(E e5) {
            boolean B;
            m4.m<? super Boolean> mVar = this.f6803b;
            e4.k.b(mVar);
            this.f6803b = null;
            this.f6802a = e5;
            Boolean bool = Boolean.TRUE;
            d4.l<E, s3.t> lVar = b.this.f6800b;
            B = o4.c.B(mVar, bool, lVar != null ? z.a(lVar, e5, mVar.getContext()) : null);
            return B;
        }

        public final void j() {
            Object a5;
            m4.m<? super Boolean> mVar = this.f6803b;
            e4.k.b(mVar);
            this.f6803b = null;
            this.f6802a = o4.c.z();
            Throwable H = b.this.H();
            if (H == null) {
                m.a aVar = s3.m.f7565b;
                a5 = Boolean.FALSE;
            } else {
                m.a aVar2 = s3.m.f7565b;
                a5 = s3.n.a(H);
            }
            mVar.resumeWith(s3.m.b(a5));
        }

        @Override // o4.f
        public E next() {
            h0 h0Var;
            h0 h0Var2;
            E e5 = (E) this.f6802a;
            h0Var = o4.c.f6826p;
            if (e5 != h0Var) {
                h0Var2 = o4.c.f6826p;
                this.f6802a = h0Var2;
                if (e5 != o4.c.z()) {
                    return e5;
                }
                throw g0.a(b.this.I());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o4.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0105b implements b3 {

        /* renamed from: a  reason: collision with root package name */
        private final m4.l<Boolean> f6805a;

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ m4.m<Boolean> f6806b;

        public final m4.l<Boolean> a() {
            return this.f6805a;
        }

        @Override // m4.b3
        public void f(e0<?> e0Var, int i5) {
            this.f6806b.f(e0Var, i5);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends e4.l implements d4.q<u4.b<?>, Object, Object, d4.l<? super Throwable, ? extends s3.t>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b<E> f6807a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends e4.l implements d4.l<Throwable, s3.t> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f6808a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b<E> f6809b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ u4.b<?> f6810c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b<E> bVar, u4.b<?> bVar2) {
                super(1);
                this.f6808a = obj;
                this.f6809b = bVar;
                this.f6810c = bVar2;
            }

            public final void a(Throwable th) {
                if (this.f6808a != o4.c.z()) {
                    z.b(this.f6809b.f6800b, this.f6808a, this.f6810c.getContext());
                }
            }

            @Override // d4.l
            public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
                a(th);
                return s3.t.f7573a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b<E> bVar) {
            super(3);
            this.f6807a = bVar;
        }

        @Override // d4.q
        /* renamed from: a */
        public final d4.l<Throwable, s3.t> d(u4.b<?> bVar, Object obj, Object obj2) {
            return new a(obj2, this.f6807a, bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i5, d4.l<? super E, s3.t> lVar) {
        long A;
        h0 h0Var;
        this.f6799a = i5;
        this.f6800b = lVar;
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i5 + ", should be >=0").toString());
        }
        A = o4.c.A(i5);
        this.bufferEnd = A;
        this.completedExpandBuffersAndPauseFlag = G();
        j jVar = new j(0L, null, this, 3);
        this.sendSegment = jVar;
        this.receiveSegment = jVar;
        if (W()) {
            jVar = o4.c.f6811a;
            e4.k.c(jVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = jVar;
        this.f6801c = lVar != 0 ? new c(this) : null;
        h0Var = o4.c.f6829s;
        this._closeCause = h0Var;
    }

    private final void A() {
        m();
    }

    private final void C() {
        if (W()) {
            return;
        }
        j<E> jVar = (j) f6796n.get(this);
        while (true) {
            long andIncrement = f6792f.getAndIncrement(this);
            int i5 = o4.c.f6812b;
            long j5 = andIncrement / i5;
            int i6 = (L() > andIncrement ? 1 : (L() == andIncrement ? 0 : -1));
            long j6 = jVar.f7187c;
            if (i6 <= 0) {
                if (j6 < j5 && jVar.e() != 0) {
                    b0(j5, jVar);
                }
                O(this, 0L, 1, null);
                return;
            }
            if (j6 != j5) {
                j<E> D = D(j5, jVar, andIncrement);
                if (D == null) {
                    continue;
                } else {
                    jVar = D;
                }
            }
            boolean s02 = s0(jVar, (int) (andIncrement % i5), andIncrement);
            O(this, 0L, 1, null);
            if (s02) {
                return;
            }
        }
    }

    private final j<E> D(long j5, j<E> jVar, long j6) {
        Object c5;
        boolean z4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6796n;
        d4.p pVar = (d4.p) o4.c.y();
        do {
            c5 = r4.d.c(jVar, j5, pVar);
            if (f0.c(c5)) {
                break;
            }
            e0 b5 = f0.b(c5);
            while (true) {
                e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                if (e0Var.f7187c >= b5.f7187c) {
                    break;
                } else if (!b5.q()) {
                    z4 = false;
                    continue;
                    break;
                } else if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, e0Var, b5)) {
                    if (e0Var.m()) {
                        e0Var.k();
                    }
                } else if (b5.m()) {
                    b5.k();
                }
            }
            z4 = true;
            continue;
        } while (!z4);
        if (f0.c(c5)) {
            A();
            b0(j5, jVar);
        } else {
            j<E> jVar2 = (j) f0.b(c5);
            long j7 = jVar2.f7187c;
            if (j7 <= j5) {
                return jVar2;
            }
            int i5 = o4.c.f6812b;
            if (f6792f.compareAndSet(this, j6 + 1, i5 * j7)) {
                N((jVar2.f7187c * i5) - j6);
                return null;
            }
        }
        O(this, 0L, 1, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j<E> E(long j5, j<E> jVar) {
        Object c5;
        boolean z4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6795m;
        d4.p pVar = (d4.p) o4.c.y();
        do {
            c5 = r4.d.c(jVar, j5, pVar);
            if (f0.c(c5)) {
                break;
            }
            e0 b5 = f0.b(c5);
            while (true) {
                e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                z4 = true;
                if (e0Var.f7187c < b5.f7187c) {
                    if (!b5.q()) {
                        z4 = false;
                        continue;
                        break;
                    } else if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, e0Var, b5)) {
                        if (e0Var.m()) {
                            e0Var.k();
                            continue;
                        } else {
                            continue;
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        } while (!z4);
        if (f0.c(c5)) {
            A();
            if (jVar.f7187c * o4.c.f6812b >= L()) {
                return null;
            }
        } else {
            jVar = (j) f0.b(c5);
            if (!W() && j5 <= G() / o4.c.f6812b) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6796n;
                while (true) {
                    e0 e0Var2 = (e0) atomicReferenceFieldUpdater2.get(this);
                    if (e0Var2.f7187c >= jVar.f7187c || !jVar.q()) {
                        break;
                    } else if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater2, this, e0Var2, jVar)) {
                        if (e0Var2.m()) {
                            e0Var2.k();
                        }
                    } else if (jVar.m()) {
                        jVar.k();
                    }
                }
            }
            long j6 = jVar.f7187c;
            if (j6 <= j5) {
                return jVar;
            }
            int i5 = o4.c.f6812b;
            y0(j6 * i5);
            if (jVar.f7187c * i5 >= L()) {
                return null;
            }
        }
        jVar.b();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j<E> F(long j5, j<E> jVar) {
        Object c5;
        boolean z4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6794l;
        d4.p pVar = (d4.p) o4.c.y();
        do {
            c5 = r4.d.c(jVar, j5, pVar);
            if (f0.c(c5)) {
                break;
            }
            e0 b5 = f0.b(c5);
            while (true) {
                e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                z4 = true;
                if (e0Var.f7187c < b5.f7187c) {
                    if (!b5.q()) {
                        z4 = false;
                        continue;
                        break;
                    } else if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, e0Var, b5)) {
                        if (e0Var.m()) {
                            e0Var.k();
                            continue;
                        } else {
                            continue;
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        } while (!z4);
        if (f0.c(c5)) {
            A();
            if (jVar.f7187c * o4.c.f6812b >= J()) {
                return null;
            }
        } else {
            jVar = (j) f0.b(c5);
            long j6 = jVar.f7187c;
            if (j6 <= j5) {
                return jVar;
            }
            int i5 = o4.c.f6812b;
            z0(j6 * i5);
            if (jVar.f7187c * i5 >= J()) {
                return null;
            }
        }
        jVar.b();
        return null;
    }

    private final long G() {
        return f6792f.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable I() {
        Throwable H = H();
        return H == null ? new m("Channel was closed") : H;
    }

    private final void N(long j5) {
        boolean z4;
        if ((f6793k.addAndGet(this, j5) & 4611686018427387904L) != 0) {
            do {
                if ((f6793k.get(this) & 4611686018427387904L) != 0) {
                    z4 = true;
                    continue;
                } else {
                    z4 = false;
                    continue;
                }
            } while (z4);
        }
    }

    static /* synthetic */ void O(b bVar, long j5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i5 & 1) != 0) {
            j5 = 1;
        }
        bVar.N(j5);
    }

    private final void P() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6798p;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj, obj == null ? o4.c.f6827q : o4.c.f6828r));
        if (obj == null) {
            return;
        }
        d4.l lVar = (d4.l) e4.u.a(obj, 1);
        ((d4.l) obj).invoke(H());
    }

    private final boolean Q(j<E> jVar, int i5, long j5) {
        Object w5;
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        h0 h0Var4;
        h0 h0Var5;
        h0 h0Var6;
        h0 h0Var7;
        do {
            w5 = jVar.w(i5);
            if (w5 != null) {
                h0Var2 = o4.c.f6815e;
                if (w5 != h0Var2) {
                    if (w5 == o4.c.f6814d) {
                        return true;
                    }
                    h0Var3 = o4.c.f6820j;
                    if (w5 == h0Var3 || w5 == o4.c.z()) {
                        return false;
                    }
                    h0Var4 = o4.c.f6819i;
                    if (w5 == h0Var4) {
                        return false;
                    }
                    h0Var5 = o4.c.f6818h;
                    if (w5 == h0Var5) {
                        return false;
                    }
                    h0Var6 = o4.c.f6817g;
                    if (w5 == h0Var6) {
                        return true;
                    }
                    h0Var7 = o4.c.f6816f;
                    return w5 != h0Var7 && j5 == J();
                }
            }
            h0Var = o4.c.f6818h;
        } while (!jVar.r(i5, w5, h0Var));
        C();
        return false;
    }

    private final boolean R(long j5, boolean z4) {
        int i5 = (int) (j5 >> 60);
        if (i5 == 0 || i5 == 1) {
            return false;
        }
        if (i5 == 2) {
            z(j5 & 1152921504606846975L);
            if (z4 && M()) {
                return false;
            }
        } else if (i5 != 3) {
            throw new IllegalStateException(("unexpected close status: " + i5).toString());
        } else {
            y(j5 & 1152921504606846975L);
        }
        return true;
    }

    private final boolean T(long j5) {
        return R(j5, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(long j5) {
        return R(j5, false);
    }

    private final boolean W() {
        long G = G();
        return G == 0 || G == Long.MAX_VALUE;
    }

    private final long X(j<E> jVar) {
        h0 h0Var;
        do {
            int i5 = o4.c.f6812b;
            while (true) {
                i5--;
                if (-1 < i5) {
                    long j5 = (jVar.f7187c * o4.c.f6812b) + i5;
                    if (j5 >= J()) {
                        while (true) {
                            Object w5 = jVar.w(i5);
                            if (w5 != null) {
                                h0Var = o4.c.f6815e;
                                if (w5 != h0Var) {
                                    if (w5 == o4.c.f6814d) {
                                        return j5;
                                    }
                                }
                            }
                            if (jVar.r(i5, w5, o4.c.z())) {
                                jVar.p();
                                break;
                            }
                        }
                    } else {
                        return -1L;
                    }
                } else {
                    jVar = (j) jVar.g();
                }
            }
        } while (jVar != null);
        return -1L;
    }

    private final void Y() {
        long j5;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f6790d;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                return;
            }
            w5 = o4.c.w(1152921504606846975L & j5, 1);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, w5));
    }

    private final void Z() {
        long j5;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f6790d;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            w5 = o4.c.w(1152921504606846975L & j5, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, w5));
    }

    private final void a0() {
        long j5;
        long j6;
        int i5;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f6790d;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            int i6 = (int) (j5 >> 60);
            if (i6 == 0) {
                j6 = j5 & 1152921504606846975L;
                i5 = 2;
            } else if (i6 != 1) {
                return;
            } else {
                j6 = j5 & 1152921504606846975L;
                i5 = 3;
            }
            w5 = o4.c.w(j6, i5);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, w5));
    }

    private final void b0(long j5, j<E> jVar) {
        boolean z4;
        j<E> jVar2;
        j<E> jVar3;
        while (jVar.f7187c < j5 && (jVar3 = (j) jVar.e()) != null) {
            jVar = jVar3;
        }
        while (true) {
            if (!jVar.h() || (jVar2 = (j) jVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6796n;
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z4 = true;
                    if (e0Var.f7187c >= jVar.f7187c) {
                        break;
                    } else if (!jVar.q()) {
                        z4 = false;
                        break;
                    } else if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, e0Var, jVar)) {
                        if (e0Var.m()) {
                            e0Var.k();
                        }
                    } else if (jVar.m()) {
                        jVar.k();
                    }
                }
                if (z4) {
                    return;
                }
            } else {
                jVar = jVar2;
            }
        }
    }

    private final Object d0(E e5, v3.d<? super s3.t> dVar) {
        v3.d b5;
        Throwable K;
        Object c5;
        Object c6;
        b5 = w3.c.b(dVar);
        m4.m mVar = new m4.m(b5, 1);
        mVar.B();
        d4.l<E, s3.t> lVar = this.f6800b;
        if (lVar == null || (K = z.d(lVar, e5, null, 2, null)) == null) {
            K = K();
        } else {
            s3.b.a(K, K());
        }
        m.a aVar = s3.m.f7565b;
        mVar.resumeWith(s3.m.b(s3.n.a(K)));
        Object y4 = mVar.y();
        c5 = w3.d.c();
        if (y4 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        c6 = w3.d.c();
        return y4 == c6 ? y4 : s3.t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(E e5, m4.l<? super s3.t> lVar) {
        d4.l<E, s3.t> lVar2 = this.f6800b;
        if (lVar2 != null) {
            z.b(lVar2, e5, lVar.getContext());
        }
        Throwable K = K();
        m.a aVar = s3.m.f7565b;
        lVar.resumeWith(s3.m.b(s3.n.a(K)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(b3 b3Var, j<E> jVar, int i5) {
        g0();
        b3Var.f(jVar, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(b3 b3Var, j<E> jVar, int i5) {
        b3Var.f(jVar, i5 + o4.c.f6812b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ab, code lost:
        r13 = (o4.j) r13.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j0(o4.j<E> r13) {
        /*
            r12 = this;
            d4.l<E, s3.t> r0 = r12.f6800b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = r4.n.b(r1, r2, r1)
        L8:
            int r4 = o4.c.f6812b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lab
            long r6 = r13.f7187c
            int r8 = o4.c.f6812b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L17:
            java.lang.Object r8 = r13.w(r4)
            r4.h0 r9 = o4.c.f()
            if (r8 == r9) goto Lb3
            r4.h0 r9 = o4.c.f6814d
            if (r8 != r9) goto L48
            long r9 = r12.J()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lb3
            r4.h0 r9 = o4.c.z()
            boolean r8 = r13.r(r4, r8, r9)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L41
            java.lang.Object r5 = r13.v(r4)
            r4.q0 r1 = r4.z.c(r0, r5, r1)
        L41:
            r13.s(r4)
        L44:
            r13.p()
            goto La7
        L48:
            r4.h0 r9 = o4.c.k()
            if (r8 == r9) goto L9c
            if (r8 != 0) goto L51
            goto L9c
        L51:
            boolean r9 = r8 instanceof m4.b3
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof o4.v
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            r4.h0 r9 = o4.c.p()
            if (r8 == r9) goto Lb3
            r4.h0 r9 = o4.c.q()
            if (r8 != r9) goto L67
            goto Lb3
        L67:
            r4.h0 r9 = o4.c.p()
            if (r8 == r9) goto L17
            goto La7
        L6e:
            long r9 = r12.J()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lb3
            boolean r9 = r8 instanceof o4.v
            if (r9 == 0) goto L80
            r9 = r8
            o4.v r9 = (o4.v) r9
            m4.b3 r9 = r9.f6849a
            goto L83
        L80:
            r9 = r8
            m4.b3 r9 = (m4.b3) r9
        L83:
            r4.h0 r10 = o4.c.z()
            boolean r8 = r13.r(r4, r8, r10)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L97
            java.lang.Object r5 = r13.v(r4)
            r4.q0 r1 = r4.z.c(r0, r5, r1)
        L97:
            java.lang.Object r3 = r4.n.c(r3, r9)
            goto L41
        L9c:
            r4.h0 r9 = o4.c.z()
            boolean r8 = r13.r(r4, r8, r9)
            if (r8 == 0) goto L17
            goto L44
        La7:
            int r4 = r4 + (-1)
            goto Lb
        Lab:
            r4.e r13 = r13.g()
            o4.j r13 = (o4.j) r13
            if (r13 != 0) goto L8
        Lb3:
            if (r3 == 0) goto Ld9
            boolean r13 = r3 instanceof java.util.ArrayList
            if (r13 != 0) goto Lbf
            m4.b3 r3 = (m4.b3) r3
            r12.l0(r3)
            goto Ld9
        Lbf:
            java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            e4.k.c(r3, r13)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r13 = r3.size()
            int r13 = r13 - r2
        Lcb:
            if (r5 >= r13) goto Ld9
            java.lang.Object r0 = r3.get(r13)
            m4.b3 r0 = (m4.b3) r0
            r12.l0(r0)
            int r13 = r13 + (-1)
            goto Lcb
        Ld9:
            if (r1 != 0) goto Ldc
            return
        Ldc:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.b.j0(o4.j):void");
    }

    private final void k0(b3 b3Var) {
        m0(b3Var, true);
    }

    private final void l0(b3 b3Var) {
        m0(b3Var, false);
    }

    private final void m0(b3 b3Var, boolean z4) {
        v3.d dVar;
        Object b5;
        if (b3Var instanceof C0105b) {
            dVar = ((C0105b) b3Var).a();
            m.a aVar = s3.m.f7565b;
            b5 = Boolean.FALSE;
        } else if (b3Var instanceof m4.l) {
            dVar = (v3.d) b3Var;
            m.a aVar2 = s3.m.f7565b;
            b5 = s3.n.a(z4 ? I() : K());
        } else if (!(b3Var instanceof s)) {
            if (b3Var instanceof a) {
                ((a) b3Var).j();
                return;
            } else if (b3Var instanceof u4.b) {
                ((u4.b) b3Var).a(this, o4.c.z());
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + b3Var).toString());
            }
        } else {
            dVar = ((s) b3Var).f6848a;
            m.a aVar3 = s3.m.f7565b;
            b5 = h.b(h.f6835b.a(H()));
        }
        dVar.resumeWith(s3.m.b(b5));
    }

    static /* synthetic */ <E> Object n0(b<E> bVar, E e5, v3.d<? super s3.t> dVar) {
        Object c5;
        Object c6;
        Object c7;
        Object c8;
        j<E> jVar = (j) f6794l.get(bVar);
        while (true) {
            long andIncrement = f6790d.getAndIncrement(bVar);
            long j5 = 1152921504606846975L & andIncrement;
            boolean U = bVar.U(andIncrement);
            int i5 = o4.c.f6812b;
            long j6 = j5 / i5;
            int i6 = (int) (j5 % i5);
            if (jVar.f7187c != j6) {
                j<E> F = bVar.F(j6, jVar);
                if (F != null) {
                    jVar = F;
                } else if (U) {
                    Object d02 = bVar.d0(e5, dVar);
                    c8 = w3.d.c();
                    if (d02 == c8) {
                        return d02;
                    }
                }
            }
            int w02 = bVar.w0(jVar, i6, e5, j5, null, U);
            if (w02 == 0) {
                jVar.b();
                break;
            } else if (w02 == 1) {
                break;
            } else if (w02 != 2) {
                if (w02 == 3) {
                    Object o02 = bVar.o0(jVar, i6, e5, j5, dVar);
                    c6 = w3.d.c();
                    if (o02 == c6) {
                        return o02;
                    }
                } else if (w02 == 4) {
                    if (j5 < bVar.J()) {
                        jVar.b();
                    }
                    Object d03 = bVar.d0(e5, dVar);
                    c7 = w3.d.c();
                    if (d03 == c7) {
                        return d03;
                    }
                } else if (w02 == 5) {
                    jVar.b();
                }
            } else if (U) {
                jVar.p();
                Object d04 = bVar.d0(e5, dVar);
                c5 = w3.d.c();
                if (d04 == c5) {
                    return d04;
                }
            }
        }
        return s3.t.f7573a;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object o0(o4.j<E> r21, int r22, E r23, long r24, v3.d<? super s3.t> r26) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.b.o0(o4.j, int, java.lang.Object, long, v3.d):java.lang.Object");
    }

    private final boolean p0(long j5) {
        if (U(j5)) {
            return false;
        }
        return !t(j5 & 1152921504606846975L);
    }

    private final boolean q0(Object obj, E e5) {
        boolean B;
        boolean B2;
        if (obj instanceof u4.b) {
            return ((u4.b) obj).a(this, e5);
        }
        if (obj instanceof s) {
            e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            s sVar = (s) obj;
            m4.m<h<? extends E>> mVar = sVar.f6848a;
            h b5 = h.b(h.f6835b.c(e5));
            d4.l<E, s3.t> lVar = this.f6800b;
            B2 = o4.c.B(mVar, b5, lVar != null ? z.a(lVar, e5, sVar.f6848a.getContext()) : null);
            return B2;
        } else if (obj instanceof a) {
            e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(e5);
        } else if (!(obj instanceof m4.l)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        } else {
            e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            m4.l lVar2 = (m4.l) obj;
            d4.l<E, s3.t> lVar3 = this.f6800b;
            B = o4.c.B(lVar2, e5, lVar3 != null ? z.a(lVar3, e5, lVar2.getContext()) : null);
            return B;
        }
    }

    private final boolean r0(Object obj, j<E> jVar, int i5) {
        m4.l<Boolean> a5;
        Object obj2;
        if (obj instanceof m4.l) {
            e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            a5 = (m4.l) obj;
            obj2 = s3.t.f7573a;
        } else if (obj instanceof u4.b) {
            e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            u4.d h5 = ((u4.a) obj).h(this, s3.t.f7573a);
            if (h5 == u4.d.REREGISTER) {
                jVar.s(i5);
            }
            return h5 == u4.d.SUCCESSFUL;
        } else if (!(obj instanceof C0105b)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        } else {
            a5 = ((C0105b) obj).a();
            obj2 = Boolean.TRUE;
        }
        return o4.c.C(a5, obj2, null, 2, null);
    }

    private final boolean s0(j<E> jVar, int i5, long j5) {
        h0 h0Var;
        h0 h0Var2;
        Object w5 = jVar.w(i5);
        if ((w5 instanceof b3) && j5 >= f6791e.get(this)) {
            h0Var = o4.c.f6817g;
            if (jVar.r(i5, w5, h0Var)) {
                if (r0(w5, jVar, i5)) {
                    jVar.A(i5, o4.c.f6814d);
                    return true;
                }
                h0Var2 = o4.c.f6820j;
                jVar.A(i5, h0Var2);
                jVar.x(i5, false);
                return false;
            }
        }
        return t0(jVar, i5, j5);
    }

    private final boolean t(long j5) {
        return j5 < G() || j5 < J() + ((long) this.f6799a);
    }

    private final boolean t0(j<E> jVar, int i5, long j5) {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        h0 h0Var4;
        h0 h0Var5;
        h0 h0Var6;
        h0 h0Var7;
        h0 h0Var8;
        while (true) {
            Object w5 = jVar.w(i5);
            if (!(w5 instanceof b3)) {
                h0Var3 = o4.c.f6820j;
                if (w5 != h0Var3) {
                    if (w5 != null) {
                        if (w5 != o4.c.f6814d) {
                            h0Var5 = o4.c.f6818h;
                            if (w5 == h0Var5) {
                                break;
                            }
                            h0Var6 = o4.c.f6819i;
                            if (w5 == h0Var6) {
                                break;
                            }
                            h0Var7 = o4.c.f6821k;
                            if (w5 == h0Var7 || w5 == o4.c.z()) {
                                return true;
                            }
                            h0Var8 = o4.c.f6816f;
                            if (w5 != h0Var8) {
                                throw new IllegalStateException(("Unexpected cell state: " + w5).toString());
                            }
                        } else {
                            return true;
                        }
                    } else {
                        h0Var4 = o4.c.f6815e;
                        if (jVar.r(i5, w5, h0Var4)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            } else if (j5 >= f6791e.get(this)) {
                h0Var = o4.c.f6817g;
                if (jVar.r(i5, w5, h0Var)) {
                    if (r0(w5, jVar, i5)) {
                        jVar.A(i5, o4.c.f6814d);
                        return true;
                    }
                    h0Var2 = o4.c.f6820j;
                    jVar.A(i5, h0Var2);
                    jVar.x(i5, false);
                    return false;
                }
            } else if (jVar.r(i5, w5, new v((b3) w5))) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u0(j<E> jVar, int i5, long j5, Object obj) {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        Object w5 = jVar.w(i5);
        if (w5 == null) {
            if (j5 >= (f6790d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    h0Var3 = o4.c.f6824n;
                    return h0Var3;
                } else if (jVar.r(i5, w5, obj)) {
                    C();
                    h0Var2 = o4.c.f6823m;
                    return h0Var2;
                }
            }
        } else if (w5 == o4.c.f6814d) {
            h0Var = o4.c.f6819i;
            if (jVar.r(i5, w5, h0Var)) {
                C();
                return jVar.y(i5);
            }
        }
        return v0(jVar, i5, j5, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r0 = r4.n.c(r0, r4);
        r9.x(r3, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v(o4.j<E> r9, long r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            java.lang.Object r0 = r4.n.b(r0, r1, r0)
        L6:
            r2 = -1
            if (r9 == 0) goto L68
            int r3 = o4.c.f6812b
            int r3 = r3 - r1
        Lc:
            if (r2 >= r3) goto L61
            long r4 = r9.f7187c
            int r6 = o4.c.f6812b
            long r6 = (long) r6
            long r4 = r4 * r6
            long r6 = (long) r3
            long r4 = r4 + r6
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 < 0) goto L68
        L1b:
            java.lang.Object r4 = r9.w(r3)
            if (r4 == 0) goto L51
            r4.h0 r5 = o4.c.k()
            if (r4 != r5) goto L28
            goto L51
        L28:
            boolean r5 = r4 instanceof o4.v
            if (r5 == 0) goto L42
            r4.h0 r5 = o4.c.z()
            boolean r5 = r9.r(r3, r4, r5)
            if (r5 == 0) goto L1b
            o4.v r4 = (o4.v) r4
            m4.b3 r4 = r4.f6849a
        L3a:
            java.lang.Object r0 = r4.n.c(r0, r4)
            r9.x(r3, r1)
            goto L5e
        L42:
            boolean r5 = r4 instanceof m4.b3
            if (r5 == 0) goto L5e
            r4.h0 r5 = o4.c.z()
            boolean r5 = r9.r(r3, r4, r5)
            if (r5 == 0) goto L1b
            goto L3a
        L51:
            r4.h0 r5 = o4.c.z()
            boolean r4 = r9.r(r3, r4, r5)
            if (r4 == 0) goto L1b
            r9.p()
        L5e:
            int r3 = r3 + (-1)
            goto Lc
        L61:
            r4.e r9 = r9.g()
            o4.j r9 = (o4.j) r9
            goto L6
        L68:
            if (r0 == 0) goto L8e
            boolean r9 = r0 instanceof java.util.ArrayList
            if (r9 != 0) goto L74
            m4.b3 r0 = (m4.b3) r0
            r8.k0(r0)
            goto L8e
        L74:
            java.lang.String r9 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            e4.k.c(r0, r9)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r9 = r0.size()
            int r9 = r9 - r1
        L80:
            if (r2 >= r9) goto L8e
            java.lang.Object r10 = r0.get(r9)
            m4.b3 r10 = (m4.b3) r10
            r8.k0(r10)
            int r9 = r9 + (-1)
            goto L80
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.b.v(o4.j, long):void");
    }

    private final Object v0(j<E> jVar, int i5, long j5, Object obj) {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        h0 h0Var4;
        h0 h0Var5;
        h0 h0Var6;
        h0 h0Var7;
        h0 h0Var8;
        h0 h0Var9;
        h0 h0Var10;
        h0 h0Var11;
        h0 h0Var12;
        h0 h0Var13;
        h0 h0Var14;
        h0 h0Var15;
        h0 h0Var16;
        while (true) {
            Object w5 = jVar.w(i5);
            if (w5 != null) {
                h0Var5 = o4.c.f6815e;
                if (w5 != h0Var5) {
                    if (w5 == o4.c.f6814d) {
                        h0Var6 = o4.c.f6819i;
                        if (jVar.r(i5, w5, h0Var6)) {
                            C();
                            return jVar.y(i5);
                        }
                    } else {
                        h0Var7 = o4.c.f6820j;
                        if (w5 == h0Var7) {
                            h0Var8 = o4.c.f6825o;
                            return h0Var8;
                        }
                        h0Var9 = o4.c.f6818h;
                        if (w5 == h0Var9) {
                            h0Var10 = o4.c.f6825o;
                            return h0Var10;
                        } else if (w5 == o4.c.z()) {
                            C();
                            h0Var11 = o4.c.f6825o;
                            return h0Var11;
                        } else {
                            h0Var12 = o4.c.f6817g;
                            if (w5 != h0Var12) {
                                h0Var13 = o4.c.f6816f;
                                if (jVar.r(i5, w5, h0Var13)) {
                                    boolean z4 = w5 instanceof v;
                                    if (z4) {
                                        w5 = ((v) w5).f6849a;
                                    }
                                    if (r0(w5, jVar, i5)) {
                                        h0Var16 = o4.c.f6819i;
                                        jVar.A(i5, h0Var16);
                                        C();
                                        return jVar.y(i5);
                                    }
                                    h0Var14 = o4.c.f6820j;
                                    jVar.A(i5, h0Var14);
                                    jVar.x(i5, false);
                                    if (z4) {
                                        C();
                                    }
                                    h0Var15 = o4.c.f6825o;
                                    return h0Var15;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            if (j5 < (f6790d.get(this) & 1152921504606846975L)) {
                h0Var = o4.c.f6818h;
                if (jVar.r(i5, w5, h0Var)) {
                    C();
                    h0Var2 = o4.c.f6825o;
                    return h0Var2;
                }
            } else if (obj == null) {
                h0Var3 = o4.c.f6824n;
                return h0Var3;
            } else if (jVar.r(i5, w5, obj)) {
                C();
                h0Var4 = o4.c.f6823m;
                return h0Var4;
            }
        }
    }

    private final j<E> w() {
        j jVar = f6796n.get(this);
        j jVar2 = (j) f6794l.get(this);
        if (jVar2.f7187c > ((j) jVar).f7187c) {
            jVar = jVar2;
        }
        j jVar3 = (j) f6795m.get(this);
        if (jVar3.f7187c > ((j) jVar).f7187c) {
            jVar = jVar3;
        }
        return (j) r4.d.b((r4.e) jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w0(j<E> jVar, int i5, E e5, long j5, Object obj, boolean z4) {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        jVar.B(i5, e5);
        if (z4) {
            return x0(jVar, i5, e5, j5, obj, z4);
        }
        Object w5 = jVar.w(i5);
        if (w5 == null) {
            if (t(j5)) {
                if (jVar.r(i5, null, o4.c.f6814d)) {
                    return 1;
                }
            } else if (obj == null) {
                return 3;
            } else {
                if (jVar.r(i5, null, obj)) {
                    return 2;
                }
            }
        } else if (w5 instanceof b3) {
            jVar.s(i5);
            if (q0(w5, e5)) {
                h0Var3 = o4.c.f6819i;
                jVar.A(i5, h0Var3);
                f0();
                return 0;
            }
            h0Var = o4.c.f6821k;
            Object t5 = jVar.t(i5, h0Var);
            h0Var2 = o4.c.f6821k;
            if (t5 != h0Var2) {
                jVar.x(i5, true);
            }
            return 5;
        }
        return x0(jVar, i5, e5, j5, obj, z4);
    }

    private final int x0(j<E> jVar, int i5, E e5, long j5, Object obj, boolean z4) {
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        h0 h0Var4;
        h0 h0Var5;
        h0 h0Var6;
        h0 h0Var7;
        while (true) {
            Object w5 = jVar.w(i5);
            if (w5 != null) {
                h0Var2 = o4.c.f6815e;
                if (w5 != h0Var2) {
                    h0Var3 = o4.c.f6821k;
                    if (w5 == h0Var3) {
                        jVar.s(i5);
                        return 5;
                    }
                    h0Var4 = o4.c.f6818h;
                    if (w5 == h0Var4) {
                        jVar.s(i5);
                        return 5;
                    }
                    h0 z5 = o4.c.z();
                    jVar.s(i5);
                    if (w5 == z5) {
                        A();
                        return 4;
                    }
                    if (w5 instanceof v) {
                        w5 = ((v) w5).f6849a;
                    }
                    if (q0(w5, e5)) {
                        h0Var7 = o4.c.f6819i;
                        jVar.A(i5, h0Var7);
                        f0();
                        return 0;
                    }
                    h0Var5 = o4.c.f6821k;
                    Object t5 = jVar.t(i5, h0Var5);
                    h0Var6 = o4.c.f6821k;
                    if (t5 != h0Var6) {
                        jVar.x(i5, true);
                    }
                    return 5;
                } else if (jVar.r(i5, w5, o4.c.f6814d)) {
                    return 1;
                }
            } else if (!t(j5) || z4) {
                if (z4) {
                    h0Var = o4.c.f6820j;
                    if (jVar.r(i5, null, h0Var)) {
                        jVar.x(i5, false);
                        return 4;
                    }
                } else if (obj == null) {
                    return 3;
                } else {
                    if (jVar.r(i5, null, obj)) {
                        return 2;
                    }
                }
            } else if (jVar.r(i5, null, o4.c.f6814d)) {
                return 1;
            }
        }
    }

    private final void y(long j5) {
        j0(z(j5));
    }

    private final void y0(long j5) {
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f6791e;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if (j6 >= j5) {
                return;
            }
        } while (!f6791e.compareAndSet(this, j6, j5));
    }

    private final j<E> z(long j5) {
        j<E> w5 = w();
        if (V()) {
            long X = X(w5);
            if (X != -1) {
                B(X);
            }
        }
        v(w5, j5);
        return w5;
    }

    private final void z0(long j5) {
        long j6;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f6790d;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            long j7 = 1152921504606846975L & j6;
            if (j7 >= j5) {
                return;
            }
            w5 = o4.c.w(j7, (int) (j6 >> 60));
        } while (!f6790d.compareAndSet(this, j6, w5));
    }

    public final void A0(long j5) {
        int i5;
        long j6;
        long v5;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long v6;
        long j7;
        long v7;
        if (W()) {
            return;
        }
        do {
        } while (G() <= j5);
        i5 = o4.c.f6813c;
        for (int i6 = 0; i6 < i5; i6++) {
            long G = G();
            if (G == (f6793k.get(this) & 4611686018427387903L) && G == G()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f6793k;
        do {
            j6 = atomicLongFieldUpdater2.get(this);
            v5 = o4.c.v(j6 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j6, v5));
        while (true) {
            long G2 = G();
            atomicLongFieldUpdater = f6793k;
            long j8 = atomicLongFieldUpdater.get(this);
            long j9 = j8 & 4611686018427387903L;
            boolean z4 = (4611686018427387904L & j8) != 0;
            if (G2 == j9 && G2 == G()) {
                break;
            } else if (!z4) {
                v6 = o4.c.v(j9, true);
                atomicLongFieldUpdater.compareAndSet(this, j8, v6);
            }
        }
        do {
            j7 = atomicLongFieldUpdater.get(this);
            v7 = o4.c.v(j7 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j7, v7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(long j5) {
        h0 h0Var;
        q0 d5;
        j<E> jVar = (j) f6795m.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f6791e;
            long j6 = atomicLongFieldUpdater.get(this);
            if (j5 < Math.max(this.f6799a + j6, G())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j6, j6 + 1)) {
                int i5 = o4.c.f6812b;
                long j7 = j6 / i5;
                int i6 = (int) (j6 % i5);
                if (jVar.f7187c != j7) {
                    j<E> E = E(j7, jVar);
                    if (E == null) {
                        continue;
                    } else {
                        jVar = E;
                    }
                }
                Object u02 = u0(jVar, i6, j6, null);
                h0Var = o4.c.f6825o;
                if (u02 != h0Var) {
                    jVar.b();
                    d4.l<E, s3.t> lVar = this.f6800b;
                    if (lVar != null && (d5 = z.d(lVar, u02, null, 2, null)) != null) {
                        throw d5;
                    }
                } else if (j6 < L()) {
                    jVar.b();
                }
            }
        }
    }

    protected final Throwable H() {
        return (Throwable) f6797o.get(this);
    }

    public final long J() {
        return f6791e.get(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable K() {
        Throwable H = H();
        return H == null ? new n("Channel was closed") : H;
    }

    public final long L() {
        return f6790d.get(this) & 1152921504606846975L;
    }

    public final boolean M() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6795m;
            j<E> jVar = (j) atomicReferenceFieldUpdater.get(this);
            long J = J();
            if (L() <= J) {
                return false;
            }
            int i5 = o4.c.f6812b;
            long j5 = J / i5;
            if (jVar.f7187c == j5 || (jVar = E(j5, jVar)) != null) {
                jVar.b();
                if (Q(jVar, (int) (J % i5), J)) {
                    return true;
                }
                f6791e.compareAndSet(this, J, J + 1);
            } else if (((j) atomicReferenceFieldUpdater.get(this)).f7187c < j5) {
                return false;
            }
        }
    }

    public boolean S() {
        return T(f6790d.get(this));
    }

    protected boolean V() {
        return false;
    }

    @Override // o4.u
    public boolean a(Throwable th) {
        return x(th, false);
    }

    protected void c0() {
    }

    @Override // o4.u
    public void f(d4.l<? super Throwable, s3.t> lVar) {
        h0 h0Var;
        h0 h0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h0 h0Var3;
        h0 h0Var4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6798p;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater2, this, null, lVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            h0Var = o4.c.f6827q;
            if (obj != h0Var) {
                h0Var2 = o4.c.f6828r;
                if (obj == h0Var2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = f6798p;
            h0Var3 = o4.c.f6827q;
            h0Var4 = o4.c.f6828r;
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, h0Var3, h0Var4));
        lVar.invoke(H());
    }

    protected void f0() {
    }

    @Override // o4.t
    public final void g(CancellationException cancellationException) {
        u(cancellationException);
    }

    protected void g0() {
    }

    @Override // o4.t
    public f<E> iterator() {
        return new a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
        return o4.h.f6835b.c(s3.t.f7573a);
     */
    @Override // o4.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = o4.b.f6790d
            long r0 = r0.get(r14)
            boolean r0 = r14.p0(r0)
            if (r0 == 0) goto L13
            o4.h$b r15 = o4.h.f6835b
            java.lang.Object r15 = r15.b()
            return r15
        L13:
            r4.h0 r8 = o4.c.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = i()
            java.lang.Object r0 = r0.get(r14)
            o4.j r0 = (o4.j) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = j()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = k(r14, r1)
            int r1 = o4.c.f6812b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f7187c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L4e
            o4.j r1 = c(r14, r2, r0)
            if (r1 != 0) goto L4c
            if (r11 == 0) goto L21
            goto L8e
        L4c:
            r13 = r1
            goto L4f
        L4e:
            r13 = r0
        L4f:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = s(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb0
            r1 = 1
            if (r0 == r1) goto Lb3
            r1 = 2
            if (r0 == r1) goto L89
            r1 = 3
            if (r0 == r1) goto L7d
            r1 = 4
            if (r0 == r1) goto L71
            r1 = 5
            if (r0 == r1) goto L6c
            goto L6f
        L6c:
            r13.b()
        L6f:
            r0 = r13
            goto L21
        L71:
            long r0 = r14.J()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L8e
            r13.b()
            goto L8e
        L7d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L89:
            if (r11 == 0) goto L99
            r13.p()
        L8e:
            o4.h$b r15 = o4.h.f6835b
            java.lang.Throwable r0 = r14.K()
            java.lang.Object r15 = r15.a(r0)
            goto Lbb
        L99:
            boolean r15 = r8 instanceof m4.b3
            if (r15 == 0) goto La0
            m4.b3 r8 = (m4.b3) r8
            goto La1
        La0:
            r8 = 0
        La1:
            if (r8 == 0) goto La6
            q(r14, r8, r13, r12)
        La6:
            r13.p()
            o4.h$b r15 = o4.h.f6835b
            java.lang.Object r15 = r15.b()
            goto Lbb
        Lb0:
            r13.b()
        Lb3:
            o4.h$b r15 = o4.h.f6835b
            s3.t r0 = s3.t.f7573a
            java.lang.Object r15 = r15.c(r0)
        Lbb:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.b.l(java.lang.Object):java.lang.Object");
    }

    @Override // o4.u
    public boolean m() {
        return U(f6790d.get(this));
    }

    @Override // o4.u
    public Object o(E e5, v3.d<? super s3.t> dVar) {
        return n0(this, e5, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x01da, code lost:
        r3 = (o4.j) r3.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e1, code lost:
        if (r3 != null) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01da A[EDGE_INSN: B:114:0x01da->B:96:0x01da ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.b.toString():java.lang.String");
    }

    public boolean u(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return x(th, true);
    }

    protected boolean x(Throwable th, boolean z4) {
        h0 h0Var;
        if (z4) {
            Y();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6797o;
        h0Var = o4.c.f6829s;
        boolean a5 = androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, h0Var, th);
        if (z4) {
            Z();
        } else {
            a0();
        }
        A();
        c0();
        if (a5) {
            P();
        }
        return a5;
    }
}
