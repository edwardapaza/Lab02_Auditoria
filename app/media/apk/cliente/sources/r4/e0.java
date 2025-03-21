package r4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import m4.i2;
import r4.e0;
/* loaded from: classes.dex */
public abstract class e0<S extends e0<S>> extends e<S> implements i2 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7186d = AtomicIntegerFieldUpdater.newUpdater(e0.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    public final long f7187c;
    private volatile int cleanedAndPointers;

    public e0(long j5, S s5, int i5) {
        super(s5);
        this.f7187c = j5;
        this.cleanedAndPointers = i5 << 16;
    }

    @Override // r4.e
    public boolean h() {
        return f7186d.get(this) == n() && !i();
    }

    public final boolean m() {
        return f7186d.addAndGet(this, -65536) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i5, Throwable th, v3.g gVar);

    public final void p() {
        if (f7186d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7186d;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            if (!(i5 != n() || i())) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 65536 + i5));
        return true;
    }
}
