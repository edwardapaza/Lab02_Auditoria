package m4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* loaded from: classes.dex */
public final class v0<T> extends r4.d0<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f6284e = AtomicIntegerFieldUpdater.newUpdater(v0.class, "_decision");
    private volatile int _decision;

    public v0(v3.g gVar, v3.d<? super T> dVar) {
        super(gVar, dVar);
    }

    private final boolean Y0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6284e;
        do {
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f6284e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean Z0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6284e;
        do {
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f6284e.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // r4.d0, m4.b2
    public void E(Object obj) {
        T0(obj);
    }

    @Override // r4.d0, m4.a
    protected void T0(Object obj) {
        v3.d b5;
        if (Y0()) {
            return;
        }
        b5 = w3.c.b(this.f7183d);
        r4.k.c(b5, d0.a(obj, this.f7183d), null, 2, null);
    }

    public final Object X0() {
        Object c5;
        if (Z0()) {
            c5 = w3.d.c();
            return c5;
        }
        Object h5 = c2.h(m0());
        if (h5 instanceof z) {
            throw ((z) h5).f6298a;
        }
        return h5;
    }
}
