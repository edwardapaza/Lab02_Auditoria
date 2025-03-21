package r4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7227a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7228b = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_prev");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7229c = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* loaded from: classes.dex */
    public static abstract class a extends r4.b<s> {

        /* renamed from: b  reason: collision with root package name */
        public final s f7230b;

        /* renamed from: c  reason: collision with root package name */
        public s f7231c;

        public a(s sVar) {
            this.f7230b = sVar;
        }

        @Override // r4.b
        /* renamed from: e */
        public void b(s sVar, Object obj) {
            boolean z4 = obj == null;
            s sVar2 = z4 ? this.f7230b : this.f7231c;
            if (sVar2 != null && androidx.concurrent.futures.b.a(s.f7227a, sVar, this, sVar2) && z4) {
                s sVar3 = this.f7230b;
                s sVar4 = this.f7231c;
                e4.k.b(sVar4);
                sVar3.l(sVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (androidx.concurrent.futures.b.a(r4, r3, r2, ((r4.b0) r5).f7180a) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final r4.s j(r4.a0 r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r4.s.f7228b
            java.lang.Object r0 = r0.get(r8)
            r4.s r0 = (r4.s) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = r4.s.f7227a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = r4.s.f7228b
            boolean r0 = androidx.concurrent.futures.b.a(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.p()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof r4.a0
            if (r6 == 0) goto L34
            r4.a0 r5 = (r4.a0) r5
            r5.a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof r4.b0
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            r4.b0 r5 = (r4.b0) r5
            r4.s r5 = r5.f7180a
            boolean r2 = androidx.concurrent.futures.b.a(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = r4.s.f7228b
            java.lang.Object r2 = r4.get(r2)
            r4.s r2 = (r4.s) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            e4.k.c(r5, r3)
            r3 = r5
            r4.s r3 = (r4.s) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.s.j(r4.a0):r4.s");
    }

    private final s k(s sVar) {
        while (sVar.p()) {
            sVar = (s) f7228b.get(sVar);
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(s sVar) {
        s sVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7228b;
        do {
            sVar2 = (s) atomicReferenceFieldUpdater.get(sVar);
            if (m() != sVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f7228b, sVar, sVar2, this));
        if (p()) {
            sVar.j(null);
        }
    }

    private final b0 s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7229c;
        b0 b0Var = (b0) atomicReferenceFieldUpdater.get(this);
        if (b0Var == null) {
            b0 b0Var2 = new b0(this);
            atomicReferenceFieldUpdater.lazySet(this, b0Var2);
            return b0Var2;
        }
        return b0Var;
    }

    public final boolean i(s sVar) {
        f7228b.lazySet(sVar, this);
        f7227a.lazySet(sVar, this);
        while (m() == this) {
            if (androidx.concurrent.futures.b.a(f7227a, this, this, sVar)) {
                sVar.l(this);
                return true;
            }
        }
        return false;
    }

    public final Object m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7227a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof a0)) {
                return obj;
            }
            ((a0) obj).a(this);
        }
    }

    public final s n() {
        return r.b(m());
    }

    public final s o() {
        s j5 = j(null);
        return j5 == null ? k((s) f7228b.get(this)) : j5;
    }

    public boolean p() {
        return m() instanceof b0;
    }

    public boolean q() {
        return r() == null;
    }

    public final s r() {
        Object m5;
        s sVar;
        do {
            m5 = m();
            if (m5 instanceof b0) {
                return ((b0) m5).f7180a;
            }
            if (m5 == this) {
                return (s) m5;
            }
            e4.k.c(m5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            sVar = (s) m5;
        } while (!androidx.concurrent.futures.b.a(f7227a, this, m5, sVar.s()));
        sVar.j(null);
        return null;
    }

    public final int t(s sVar, s sVar2, a aVar) {
        f7228b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7227a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        aVar.f7231c = sVar2;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, sVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new e4.o(this) { // from class: r4.s.b
            @Override // i4.f
            public Object get() {
                return m4.n0.a(this.f2919b);
            }
        } + '@' + m4.n0.b(this);
    }
}
