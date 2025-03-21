package r4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r4.e;
/* loaded from: classes.dex */
public abstract class e<N extends e<N>> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7184a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7185b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public e(N n5) {
        this._prev = n5;
    }

    private final N c() {
        N g5 = g();
        while (g5 != null && g5.h()) {
            g5 = (N) f7185b.get(g5);
        }
        return g5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [r4.e] */
    private final N d() {
        ?? e5;
        N e6 = e();
        e4.k.b(e6);
        while (e6.h() && (e5 = e6.e()) != 0) {
            e6 = e5;
        }
        return e6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return f7184a.get(this);
    }

    public final void b() {
        f7185b.lazySet(this, null);
    }

    public final N e() {
        Object f5 = f();
        if (f5 == d.a()) {
            return null;
        }
        return (N) f5;
    }

    public final N g() {
        return (N) f7185b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return androidx.concurrent.futures.b.a(f7184a, this, null, d.a());
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            N c5 = c();
            N d5 = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7185b;
            do {
                obj = atomicReferenceFieldUpdater.get(d5);
            } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, d5, obj, ((e) obj) == null ? null : c5));
            if (c5 != null) {
                f7184a.set(c5, d5);
            }
            if (!d5.h() || d5.i()) {
                if (c5 == null || !c5.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(N n5) {
        return androidx.concurrent.futures.b.a(f7184a, this, null, n5);
    }
}
