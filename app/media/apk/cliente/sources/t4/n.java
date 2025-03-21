package t4;

import e4.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7698b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7699c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7700d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7701e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<h> f7702a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    private final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.f7686b.b() == 1) {
            f7701e.incrementAndGet(this);
        }
        int i5 = f7699c.get(this) & 127;
        while (this.f7702a.get(i5) != null) {
            Thread.yield();
        }
        this.f7702a.lazySet(i5, hVar);
        f7699c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar != null) {
            if (hVar.f7686b.b() == 1) {
                f7701e.decrementAndGet(this);
            }
        }
    }

    private final int d() {
        return f7699c.get(this) - f7700d.get(this);
    }

    private final h i() {
        h andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7700d;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 - f7699c.get(this) == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 + 1) && (andSet = this.f7702a.getAndSet(i6, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        h i5 = i();
        if (i5 == null) {
            return false;
        }
        dVar.a(i5);
        return true;
    }

    private final h k(boolean z4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f7698b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                if ((hVar.f7686b.b() == 1) == z4) {
                }
            }
            int i5 = f7700d.get(this);
            int i6 = f7699c.get(this);
            while (i5 != i6) {
                if (z4 && f7701e.get(this) == 0) {
                    return null;
                }
                i6--;
                h m5 = m(i6, z4);
                if (m5 != null) {
                    return m5;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, hVar, null));
        return hVar;
    }

    private final h l(int i5) {
        int i6 = f7700d.get(this);
        int i7 = f7699c.get(this);
        boolean z4 = i5 == 1;
        while (i6 != i7) {
            if (z4 && f7701e.get(this) == 0) {
                return null;
            }
            int i8 = i6 + 1;
            h m5 = m(i6, z4);
            if (m5 != null) {
                return m5;
            }
            i6 = i8;
        }
        return null;
    }

    private final h m(int i5, boolean z4) {
        int i6 = i5 & 127;
        h hVar = this.f7702a.get(i6);
        if (hVar != null) {
            if ((hVar.f7686b.b() == 1) == z4 && o4.i.a(this.f7702a, i6, hVar, null)) {
                if (z4) {
                    f7701e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, t4.h] */
    private final long o(int i5, r<h> rVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r12;
        do {
            atomicReferenceFieldUpdater = f7698b;
            r12 = (h) atomicReferenceFieldUpdater.get(this);
            if (r12 == 0) {
                return -2L;
            }
            if (((r12.f7686b.b() == 1 ? 1 : 2) & i5) == 0) {
                return -2L;
            }
            long a5 = l.f7694f.a() - r12.f7685a;
            long j5 = l.f7690b;
            if (a5 < j5) {
                return j5 - a5;
            }
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, r12, null));
        rVar.f2939a = r12;
        return -1L;
    }

    public final h a(h hVar, boolean z4) {
        if (z4) {
            return b(hVar);
        }
        h hVar2 = (h) f7698b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int e() {
        return f7698b.get(this) != null ? d() + 1 : d();
    }

    public final void f(d dVar) {
        h hVar = (h) f7698b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (j(dVar));
    }

    public final h g() {
        h hVar = (h) f7698b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final h h() {
        return k(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int i5, r<h> rVar) {
        T i6 = i5 == 3 ? i() : l(i5);
        if (i6 != 0) {
            rVar.f2939a = i6;
            return -1L;
        }
        return o(i5, rVar);
    }
}
