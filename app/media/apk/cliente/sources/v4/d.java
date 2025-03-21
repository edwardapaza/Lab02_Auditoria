package v4;

import d4.l;
import d4.p;
import e4.j;
import e4.k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.b3;
import s3.t;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f8190c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f8191d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f8192e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f8193f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f8194g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f8195a;

    /* renamed from: b  reason: collision with root package name */
    private final l<Throwable, t> f8196b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class a extends j implements p<Long, f, f> {

        /* renamed from: n  reason: collision with root package name */
        public static final a f8197n = new a();

        a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f i(long j5, f fVar) {
            f h5;
            h5 = e.h(j5, fVar);
            return h5;
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ f invoke(Long l5, f fVar) {
            return i(l5.longValue(), fVar);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e4.l implements l<Throwable, t> {
        b() {
            super(1);
        }

        public final void a(Throwable th) {
            d.this.h();
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7573a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class c extends j implements p<Long, f, f> {

        /* renamed from: n  reason: collision with root package name */
        public static final c f8199n = new c();

        c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f i(long j5, f fVar) {
            f h5;
            h5 = e.h(j5, fVar);
            return h5;
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ f invoke(Long l5, f fVar) {
            return i(l5.longValue(), fVar);
        }
    }

    public d(int i5, int i6) {
        this.f8195a = i5;
        boolean z4 = true;
        if (!(i5 > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i5).toString());
        }
        if (!((i6 < 0 || i6 > i5) ? false : false)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i5).toString());
        }
        f fVar = new f(0L, null, 2);
        this.head = fVar;
        this.tail = fVar;
        this._availablePermits = i5 - i6;
        this.f8196b = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0051, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
        r10 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean d(m4.b3 r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = v4.d.f8192e
            java.lang.Object r3 = r2.get(r0)
            v4.f r3 = (v4.f) r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = v4.d.f8193f
            long r4 = r4.getAndIncrement(r0)
            v4.d$a r6 = v4.d.a.f8197n
            int r7 = v4.e.f()
            long r7 = (long) r7
            long r7 = r4 / r7
        L1b:
            java.lang.Object r9 = r4.d.c(r3, r7, r6)
            boolean r10 = r4.f0.c(r9)
            if (r10 != 0) goto L5e
            r4.e0 r10 = r4.f0.b(r9)
        L29:
            java.lang.Object r13 = r2.get(r0)
            r4.e0 r13 = (r4.e0) r13
            long r14 = r13.f7187c
            long r11 = r10.f7187c
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 < 0) goto L39
        L37:
            r10 = 1
            goto L51
        L39:
            boolean r11 = r10.q()
            if (r11 != 0) goto L41
            r10 = 0
            goto L51
        L41:
            boolean r11 = androidx.concurrent.futures.b.a(r2, r0, r13, r10)
            if (r11 == 0) goto L54
            boolean r10 = r13.m()
            if (r10 == 0) goto L37
            r13.k()
            goto L37
        L51:
            if (r10 == 0) goto L1b
            goto L5e
        L54:
            boolean r11 = r10.m()
            if (r11 == 0) goto L29
            r10.k()
            goto L29
        L5e:
            r4.e0 r2 = r4.f0.b(r9)
            v4.f r2 = (v4.f) r2
            int r3 = v4.e.f()
            long r6 = (long) r3
            long r4 = r4 % r6
            int r3 = (int) r4
            r4 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.r()
            boolean r4 = o4.i.a(r5, r3, r4, r1)
            if (r4 == 0) goto L7b
            r1.f(r2, r3)
            r1 = 1
            return r1
        L7b:
            r4.h0 r4 = v4.e.e()
            r4.h0 r5 = v4.e.g()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.r()
            boolean r2 = o4.i.a(r2, r3, r4, r5)
            if (r2 == 0) goto Lc9
            boolean r2 = r1 instanceof m4.l
            if (r2 == 0) goto La1
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>"
            e4.k.c(r1, r2)
            m4.l r1 = (m4.l) r1
            s3.t r2 = s3.t.f7573a
            d4.l<java.lang.Throwable, s3.t> r3 = r0.f8196b
            r1.e(r2, r3)
        L9f:
            r1 = 1
            goto Lad
        La1:
            boolean r2 = r1 instanceof u4.b
            if (r2 == 0) goto Lae
            u4.b r1 = (u4.b) r1
            s3.t r2 = s3.t.f7573a
            r1.c(r2)
            goto L9f
        Lad:
            return r1
        Lae:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        Lc9:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.d.d(m4.b3):boolean");
    }

    private final void e() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        int i6;
        do {
            atomicIntegerFieldUpdater = f8194g;
            i5 = atomicIntegerFieldUpdater.get(this);
            i6 = this.f8195a;
            if (i5 <= i6) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, i6));
    }

    private final int f() {
        int andDecrement;
        do {
            andDecrement = f8194g.getAndDecrement(this);
        } while (andDecrement > this.f8195a);
        return andDecrement;
    }

    private final boolean j(Object obj) {
        if (!(obj instanceof m4.l)) {
            if (obj instanceof u4.b) {
                return ((u4.b) obj).a(this, t.f7573a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        m4.l lVar = (m4.l) obj;
        Object h5 = lVar.h(t.f7573a, null, this.f8196b);
        if (h5 != null) {
            lVar.s(h5);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x004f, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean k() {
        /*
            r16 = this;
            r0 = r16
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = v4.d.f8190c
            java.lang.Object r2 = r1.get(r0)
            v4.f r2 = (v4.f) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = v4.d.f8191d
            long r3 = r3.getAndIncrement(r0)
            int r5 = v4.e.f()
            long r5 = (long) r5
            long r5 = r3 / r5
            v4.d$c r7 = v4.d.c.f8199n
        L19:
            java.lang.Object r8 = r4.d.c(r2, r5, r7)
            boolean r9 = r4.f0.c(r8)
            if (r9 != 0) goto L5c
            r4.e0 r9 = r4.f0.b(r8)
        L27:
            java.lang.Object r12 = r1.get(r0)
            r4.e0 r12 = (r4.e0) r12
            long r13 = r12.f7187c
            long r10 = r9.f7187c
            int r15 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r15 < 0) goto L37
        L35:
            r9 = 1
            goto L4f
        L37:
            boolean r10 = r9.q()
            if (r10 != 0) goto L3f
            r9 = 0
            goto L4f
        L3f:
            boolean r10 = androidx.concurrent.futures.b.a(r1, r0, r12, r9)
            if (r10 == 0) goto L52
            boolean r9 = r12.m()
            if (r9 == 0) goto L35
            r12.k()
            goto L35
        L4f:
            if (r9 == 0) goto L19
            goto L5c
        L52:
            boolean r10 = r9.m()
            if (r10 == 0) goto L27
            r9.k()
            goto L27
        L5c:
            r4.e0 r1 = r4.f0.b(r8)
            v4.f r1 = (v4.f) r1
            r1.b()
            long r7 = r1.f7187c
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L6d
            r2 = 0
            return r2
        L6d:
            int r2 = v4.e.f()
            long r5 = (long) r2
            long r3 = r3 % r5
            int r2 = (int) r3
            r4.h0 r3 = v4.e.e()
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r1.r()
            java.lang.Object r3 = r4.getAndSet(r2, r3)
            if (r3 != 0) goto Lb0
            int r3 = v4.e.d()
            r10 = 0
        L87:
            if (r10 >= r3) goto L9d
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r1.r()
            java.lang.Object r4 = r4.get(r2)
            r4.h0 r5 = v4.e.g()
            if (r4 != r5) goto L99
            r4 = 1
            return r4
        L99:
            r4 = 1
            int r10 = r10 + 1
            goto L87
        L9d:
            r4 = 1
            r4.h0 r3 = v4.e.e()
            r4.h0 r5 = v4.e.b()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r1.r()
            boolean r1 = o4.i.a(r1, r2, r3, r5)
            r1 = r1 ^ r4
            return r1
        Lb0:
            r4.h0 r1 = v4.e.c()
            if (r3 != r1) goto Lb8
            r1 = 0
            return r1
        Lb8:
            boolean r1 = r0.j(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.d.k():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(m4.l<? super t> lVar) {
        while (f() <= 0) {
            k.c(lVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((b3) lVar)) {
                return;
            }
        }
        lVar.e(t.f7573a, this.f8196b);
    }

    public int g() {
        return Math.max(f8194g.get(this), 0);
    }

    public void h() {
        do {
            int andIncrement = f8194g.getAndIncrement(this);
            if (andIncrement >= this.f8195a) {
                e();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f8195a).toString());
            } else if (andIncrement >= 0) {
                return;
            }
        } while (!k());
    }

    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f8194g;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 > this.f8195a) {
                e();
            } else if (i5 <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 - 1)) {
                    return true;
                }
            }
        }
    }
}
