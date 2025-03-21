package r4;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: classes.dex */
public final class u<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f7233e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7234f = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_next");

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f7235g = AtomicLongFieldUpdater.newUpdater(u.class, "_state");

    /* renamed from: h  reason: collision with root package name */
    public static final h0 f7236h = new h0("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a  reason: collision with root package name */
    private final int f7237a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7238b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7239c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReferenceArray f7240d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final int a(long j5) {
            return (j5 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j5, int i5) {
            return d(j5, 1073741823L) | (i5 << 0);
        }

        public final long c(long j5, int i5) {
            return d(j5, 1152921503533105152L) | (i5 << 30);
        }

        public final long d(long j5, long j6) {
            return j5 & (~j6);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f7241a;

        public b(int i5) {
            this.f7241a = i5;
        }
    }

    public u(int i5, boolean z4) {
        this.f7237a = i5;
        this.f7238b = z4;
        int i6 = i5 - 1;
        this.f7239c = i6;
        this.f7240d = new AtomicReferenceArray(i5);
        if (!(i6 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i5 & i6) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final u<E> b(long j5) {
        u<E> uVar = new u<>(this.f7237a * 2, this.f7238b);
        int i5 = (int) ((1073741823 & j5) >> 0);
        int i6 = (int) ((1152921503533105152L & j5) >> 30);
        while (true) {
            int i7 = this.f7239c;
            if ((i5 & i7) == (i6 & i7)) {
                f7235g.set(uVar, f7233e.d(j5, 1152921504606846976L));
                return uVar;
            }
            Object obj = this.f7240d.get(i7 & i5);
            if (obj == null) {
                obj = new b(i5);
            }
            uVar.f7240d.set(uVar.f7239c & i5, obj);
            i5++;
        }
    }

    private final u<E> c(long j5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7234f;
        while (true) {
            u<E> uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar != null) {
                return uVar;
            }
            androidx.concurrent.futures.b.a(f7234f, this, null, b(j5));
        }
    }

    private final u<E> e(int i5, E e5) {
        Object obj = this.f7240d.get(this.f7239c & i5);
        if ((obj instanceof b) && ((b) obj).f7241a == i5) {
            this.f7240d.set(i5 & this.f7239c, e5);
            return this;
        }
        return null;
    }

    private final long h() {
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7235g;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                return j5;
            }
            j6 = j5 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, j6));
        return j6;
    }

    private final u<E> k(int i5, int i6) {
        long j5;
        int i7;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7235g;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            i7 = (int) ((1073741823 & j5) >> 0);
            if ((1152921504606846976L & j5) != 0) {
                return i();
            }
        } while (!f7235g.compareAndSet(this, j5, f7233e.b(j5, i6)));
        this.f7240d.set(this.f7239c & i7, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = r4.u.f7235g
        L2:
            long r3 = r0.get(r13)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L16
            r4.u$a r14 = r4.u.f7233e
            int r14 = r14.a(r3)
            return r14
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r9 = 0
            long r1 = r1 >> r9
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r10 = (int) r5
            int r11 = r13.f7239c
            int r1 = r10 + 2
            r1 = r1 & r11
            r5 = r2 & r11
            r6 = 1
            if (r1 != r5) goto L32
            return r6
        L32:
            boolean r1 = r13.f7238b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L51
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r13.f7240d
            r12 = r10 & r11
            java.lang.Object r1 = r1.get(r12)
            if (r1 == 0) goto L51
            int r1 = r13.f7237a
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L50
            int r10 = r10 - r2
            r2 = r10 & r5
            int r1 = r1 >> 1
            if (r2 <= r1) goto L2
        L50:
            return r6
        L51:
            int r1 = r10 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = r4.u.f7235g
            r4.u$a r5 = r4.u.f7233e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r13
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f7240d
            r1 = r10 & r11
            r0.set(r1, r14)
            r0 = r13
        L6c:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = r4.u.f7235g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L83
            r4.u r0 = r0.i()
            r4.u r0 = r0.e(r10, r14)
            if (r0 != 0) goto L6c
        L83:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.u.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7235g;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, j5 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j5 = f7235g.get(this);
        return 1073741823 & (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j5) >> 0)));
    }

    public final boolean g() {
        long j5 = f7235g.get(this);
        return ((int) ((1073741823 & j5) >> 0)) == ((int) ((j5 & 1152921503533105152L) >> 30));
    }

    public final u<E> i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7235g;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j5) != 0) {
                return f7236h;
            }
            int i5 = (int) ((1073741823 & j5) >> 0);
            int i6 = (int) ((1152921503533105152L & j5) >> 30);
            int i7 = this.f7239c;
            if ((i6 & i7) == (i5 & i7)) {
                return null;
            }
            Object obj = this.f7240d.get(i7 & i5);
            if (obj == null) {
                if (this.f7238b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i8 = (i5 + 1) & 1073741823;
                if (f7235g.compareAndSet(this, j5, f7233e.b(j5, i8))) {
                    this.f7240d.set(this.f7239c & i5, null);
                    return obj;
                } else if (this.f7238b) {
                    u<E> uVar = this;
                    do {
                        uVar = uVar.k(i5, i8);
                    } while (uVar != null);
                    return obj;
                }
            }
        }
    }
}
