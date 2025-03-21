package r4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.f1;
import m4.q2;
import m4.w0;
/* loaded from: classes.dex */
public final class j<T> extends w0<T> implements kotlin.coroutines.jvm.internal.e, v3.d<T> {

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7195l = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: d  reason: collision with root package name */
    public final m4.g0 f7196d;

    /* renamed from: e  reason: collision with root package name */
    public final v3.d<T> f7197e;

    /* renamed from: f  reason: collision with root package name */
    public Object f7198f;

    /* renamed from: k  reason: collision with root package name */
    public final Object f7199k;

    /* JADX WARN: Multi-variable type inference failed */
    public j(m4.g0 g0Var, v3.d<? super T> dVar) {
        super(-1);
        this.f7196d = g0Var;
        this.f7197e = dVar;
        this.f7198f = k.a();
        this.f7199k = l0.b(getContext());
    }

    private final m4.m<?> m() {
        Object obj = f7195l.get(this);
        if (obj instanceof m4.m) {
            return (m4.m) obj;
        }
        return null;
    }

    @Override // m4.w0
    public void a(Object obj, Throwable th) {
        if (obj instanceof m4.a0) {
            ((m4.a0) obj).f6177b.invoke(th);
        }
    }

    @Override // m4.w0
    public v3.d<T> b() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v3.d<T> dVar = this.f7197e;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // v3.d
    public v3.g getContext() {
        return this.f7197e.getContext();
    }

    @Override // m4.w0
    public Object i() {
        Object obj = this.f7198f;
        this.f7198f = k.a();
        return obj;
    }

    public final void j() {
        do {
        } while (f7195l.get(this) == k.f7202b);
    }

    public final m4.m<T> l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7195l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f7195l.set(this, k.f7202b);
                return null;
            } else if (obj instanceof m4.m) {
                if (androidx.concurrent.futures.b.a(f7195l, this, obj, k.f7202b)) {
                    return (m4.m) obj;
                }
            } else if (obj != k.f7202b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean n() {
        return f7195l.get(this) != null;
    }

    public final boolean o(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7195l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            h0 h0Var = k.f7202b;
            if (e4.k.a(obj, h0Var)) {
                if (androidx.concurrent.futures.b.a(f7195l, this, h0Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (androidx.concurrent.futures.b.a(f7195l, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void p() {
        j();
        m4.m<?> m5 = m();
        if (m5 != null) {
            m5.r();
        }
    }

    public final Throwable r(m4.l<?> lVar) {
        h0 h0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7195l;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            h0Var = k.f7202b;
            if (obj != h0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.b.a(f7195l, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.b.a(f7195l, this, h0Var, lVar));
        return null;
    }

    @Override // v3.d
    public void resumeWith(Object obj) {
        v3.g context = this.f7197e.getContext();
        Object d5 = m4.d0.d(obj, null, 1, null);
        if (this.f7196d.g0(context)) {
            this.f7198f = d5;
            this.f6287c = 0;
            this.f7196d.f0(context, this);
            return;
        }
        f1 a5 = q2.f6272a.a();
        if (a5.o0()) {
            this.f7198f = d5;
            this.f6287c = 0;
            a5.k0(this);
            return;
        }
        a5.m0(true);
        try {
            v3.g context2 = getContext();
            Object c5 = l0.c(context2, this.f7199k);
            this.f7197e.resumeWith(obj);
            s3.t tVar = s3.t.f7573a;
            l0.a(context2, c5);
            do {
            } while (a5.q0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f7196d + ", " + m4.n0.c(this.f7197e) + ']';
    }
}
