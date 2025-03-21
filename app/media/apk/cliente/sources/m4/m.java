package m4;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.u1;
/* loaded from: classes.dex */
public class m<T> extends w0<T> implements l<T>, kotlin.coroutines.jvm.internal.e, b3 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f6257f = AtomicIntegerFieldUpdater.newUpdater(m.class, "_decisionAndIndex");

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6258k = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state");

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6259l = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: d  reason: collision with root package name */
    private final v3.d<T> f6260d;

    /* renamed from: e  reason: collision with root package name */
    private final v3.g f6261e;

    /* JADX WARN: Multi-variable type inference failed */
    public m(v3.d<? super T> dVar, int i5) {
        super(i5);
        this.f6260d = dVar;
        this.f6261e = dVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f6209a;
    }

    private final String A() {
        Object z4 = z();
        return z4 instanceof i2 ? "Active" : z4 instanceof p ? "Cancelled" : "Completed";
    }

    private final b1 C() {
        u1 u1Var = (u1) getContext().d(u1.f6282h);
        if (u1Var == null) {
            return null;
        }
        b1 d5 = u1.a.d(u1Var, true, false, new q(this), 2, null);
        androidx.concurrent.futures.b.a(f6259l, this, null, d5);
        return d5;
    }

    private final void D(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6258k;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d)) {
                if (obj2 instanceof j ? true : obj2 instanceof r4.e0) {
                    G(obj, obj2);
                } else {
                    boolean z4 = obj2 instanceof z;
                    if (z4) {
                        z zVar = (z) obj2;
                        if (!zVar.b()) {
                            G(obj, obj2);
                        }
                        if (obj2 instanceof p) {
                            if (!z4) {
                                zVar = null;
                            }
                            Throwable th = zVar != null ? zVar.f6298a : null;
                            if (obj instanceof j) {
                                l((j) obj, th);
                                return;
                            }
                            e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            n((r4.e0) obj, th);
                            return;
                        }
                        return;
                    } else if (obj2 instanceof y) {
                        y yVar = (y) obj2;
                        if (yVar.f6291b != null) {
                            G(obj, obj2);
                        }
                        if (obj instanceof r4.e0) {
                            return;
                        }
                        e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        j jVar = (j) obj;
                        if (yVar.c()) {
                            l(jVar, yVar.f6294e);
                            return;
                        } else {
                            if (androidx.concurrent.futures.b.a(f6258k, this, obj2, y.b(yVar, null, jVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else if (obj instanceof r4.e0) {
                        return;
                    } else {
                        e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (androidx.concurrent.futures.b.a(f6258k, this, obj2, new y(obj2, (j) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (androidx.concurrent.futures.b.a(f6258k, this, obj2, obj)) {
                return;
            }
        }
    }

    private final boolean E() {
        if (x0.c(this.f6287c)) {
            v3.d<T> dVar = this.f6260d;
            e4.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((r4.j) dVar).n()) {
                return true;
            }
        }
        return false;
    }

    private final j F(d4.l<? super Throwable, s3.t> lVar) {
        return lVar instanceof j ? (j) lVar : new r1(lVar);
    }

    private final void G(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void L(Object obj, int i5, d4.l<? super Throwable, s3.t> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6258k;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof i2)) {
                if (obj2 instanceof p) {
                    p pVar = (p) obj2;
                    if (pVar.c()) {
                        if (lVar != null) {
                            m(lVar, pVar.f6298a);
                            return;
                        }
                        return;
                    }
                }
                j(obj);
                throw new s3.d();
            }
        } while (!androidx.concurrent.futures.b.a(f6258k, this, obj2, N((i2) obj2, obj, i5, lVar, null)));
        u();
        v(i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void M(m mVar, Object obj, int i5, d4.l lVar, int i6, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i6 & 4) != 0) {
            lVar = null;
        }
        mVar.L(obj, i5, lVar);
    }

    private final Object N(i2 i2Var, Object obj, int i5, d4.l<? super Throwable, s3.t> lVar, Object obj2) {
        if (obj instanceof z) {
            return obj;
        }
        if (x0.b(i5) || obj2 != null) {
            if (lVar == null && !(i2Var instanceof j) && obj2 == null) {
                return obj;
            }
            return new y(obj, i2Var instanceof j ? (j) i2Var : null, lVar, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean O() {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6257f;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f6257f.compareAndSet(this, i5, 1073741824 + (536870911 & i5)));
        return true;
    }

    private final r4.h0 P(Object obj, Object obj2, d4.l<? super Throwable, s3.t> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6258k;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof i2)) {
                if ((obj3 instanceof y) && obj2 != null && ((y) obj3).f6293d == obj2) {
                    return n.f6263a;
                }
                return null;
            }
        } while (!androidx.concurrent.futures.b.a(f6258k, this, obj3, N((i2) obj3, obj, this.f6287c, lVar, obj2)));
        u();
        return n.f6263a;
    }

    private final boolean Q() {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6257f;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f6257f.compareAndSet(this, i5, 536870912 + (536870911 & i5)));
        return true;
    }

    private final Void j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void n(r4.e0<?> e0Var, Throwable th) {
        int i5 = f6257f.get(this) & 536870911;
        if (!(i5 != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            e0Var.o(i5, th, getContext());
        } catch (Throwable th2) {
            v3.g context = getContext();
            i0.a(context, new c0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean p(Throwable th) {
        if (E()) {
            v3.d<T> dVar = this.f6260d;
            e4.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            return ((r4.j) dVar).o(th);
        }
        return false;
    }

    private final void u() {
        if (E()) {
            return;
        }
        r();
    }

    private final void v(int i5) {
        if (O()) {
            return;
        }
        x0.a(this, i5);
    }

    private final b1 x() {
        return (b1) f6259l.get(this);
    }

    public void B() {
        b1 C = C();
        if (C != null && k()) {
            C.a();
            f6259l.set(this, h2.f6244a);
        }
    }

    protected String H() {
        return "CancellableContinuation";
    }

    public final void I(Throwable th) {
        if (p(th)) {
            return;
        }
        o(th);
        u();
    }

    public final void J() {
        Throwable r5;
        v3.d<T> dVar = this.f6260d;
        r4.j jVar = dVar instanceof r4.j ? (r4.j) dVar : null;
        if (jVar == null || (r5 = jVar.r(this)) == null) {
            return;
        }
        r();
        o(r5);
    }

    public final boolean K() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6258k;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof y) && ((y) obj).f6293d != null) {
            r();
            return false;
        }
        f6257f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f6209a);
        return true;
    }

    @Override // m4.w0
    public void a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6258k;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof i2) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof z) {
                return;
            }
            if (obj2 instanceof y) {
                y yVar = (y) obj2;
                if (!(!yVar.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (androidx.concurrent.futures.b.a(f6258k, this, obj2, y.b(yVar, null, null, null, null, th, 15, null))) {
                    yVar.d(this, th);
                    return;
                }
            } else if (androidx.concurrent.futures.b.a(f6258k, this, obj2, new y(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // m4.w0
    public final v3.d<T> b() {
        return this.f6260d;
    }

    @Override // m4.w0
    public Throwable c(Object obj) {
        Throwable c5 = super.c(obj);
        if (c5 != null) {
            return c5;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m4.w0
    public <T> T d(Object obj) {
        return obj instanceof y ? (T) ((y) obj).f6290a : obj;
    }

    @Override // m4.l
    public void e(T t5, d4.l<? super Throwable, s3.t> lVar) {
        L(t5, this.f6287c, lVar);
    }

    @Override // m4.b3
    public void f(r4.e0<?> e0Var, int i5) {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6257f;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            if (!((i6 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i5));
        D(e0Var);
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v3.d<T> dVar = this.f6260d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // v3.d
    public v3.g getContext() {
        return this.f6261e;
    }

    @Override // m4.l
    public Object h(T t5, Object obj, d4.l<? super Throwable, s3.t> lVar) {
        return P(t5, obj, lVar);
    }

    @Override // m4.w0
    public Object i() {
        return z();
    }

    @Override // m4.l
    public boolean k() {
        return !(z() instanceof i2);
    }

    public final void l(j jVar, Throwable th) {
        try {
            jVar.e(th);
        } catch (Throwable th2) {
            v3.g context = getContext();
            i0.a(context, new c0("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(d4.l<? super Throwable, s3.t> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            v3.g context = getContext();
            i0.a(context, new c0("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean o(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6258k;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            boolean z4 = false;
            if (!(obj instanceof i2)) {
                return false;
            }
        } while (!androidx.concurrent.futures.b.a(f6258k, this, obj, new p(this, th, ((obj instanceof j) || (obj instanceof r4.e0)) ? true : true)));
        i2 i2Var = (i2) obj;
        if (i2Var instanceof j) {
            l((j) obj, th);
        } else if (i2Var instanceof r4.e0) {
            n((r4.e0) obj, th);
        }
        u();
        v(this.f6287c);
        return true;
    }

    @Override // m4.l
    public Object q(Throwable th) {
        return P(new z(th, false, 2, null), null, null);
    }

    public final void r() {
        b1 x4 = x();
        if (x4 == null) {
            return;
        }
        x4.a();
        f6259l.set(this, h2.f6244a);
    }

    @Override // v3.d
    public void resumeWith(Object obj) {
        M(this, d0.c(obj, this), this.f6287c, null, 4, null);
    }

    @Override // m4.l
    public void s(Object obj) {
        v(this.f6287c);
    }

    @Override // m4.l
    public void t(d4.l<? super Throwable, s3.t> lVar) {
        D(F(lVar));
    }

    public String toString() {
        return H() + '(' + n0.c(this.f6260d) + "){" + A() + "}@" + n0.b(this);
    }

    public Throwable w(u1 u1Var) {
        return u1Var.P();
    }

    public final Object y() {
        u1 u1Var;
        Object c5;
        boolean E = E();
        if (Q()) {
            if (x() == null) {
                C();
            }
            if (E) {
                J();
            }
            c5 = w3.d.c();
            return c5;
        }
        if (E) {
            J();
        }
        Object z4 = z();
        if (z4 instanceof z) {
            throw ((z) z4).f6298a;
        }
        if (!x0.b(this.f6287c) || (u1Var = (u1) getContext().d(u1.f6282h)) == null || u1Var.c()) {
            return d(z4);
        }
        CancellationException P = u1Var.P();
        a(z4, P);
        throw P;
    }

    public final Object z() {
        return f6258k.get(this);
    }
}
