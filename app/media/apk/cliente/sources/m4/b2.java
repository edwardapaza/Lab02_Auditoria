package m4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.u1;
import r4.s;
import v3.g;
/* loaded from: classes.dex */
public class b2 implements u1, t, j2 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6181a = AtomicReferenceFieldUpdater.newUpdater(b2.class, Object.class, "_state");

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f6182b = AtomicReferenceFieldUpdater.newUpdater(b2.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a<T> extends m<T> {

        /* renamed from: m  reason: collision with root package name */
        private final b2 f6183m;

        public a(v3.d<? super T> dVar, b2 b2Var) {
            super(dVar, 1);
            this.f6183m = b2Var;
        }

        @Override // m4.m
        protected String H() {
            return "AwaitContinuation";
        }

        @Override // m4.m
        public Throwable w(u1 u1Var) {
            Throwable e5;
            Object m02 = this.f6183m.m0();
            return (!(m02 instanceof c) || (e5 = ((c) m02).e()) == null) ? m02 instanceof z ? ((z) m02).f6298a : u1Var.P() : e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends a2 {

        /* renamed from: e  reason: collision with root package name */
        private final b2 f6184e;

        /* renamed from: f  reason: collision with root package name */
        private final c f6185f;

        /* renamed from: k  reason: collision with root package name */
        private final s f6186k;

        /* renamed from: l  reason: collision with root package name */
        private final Object f6187l;

        public b(b2 b2Var, c cVar, s sVar, Object obj) {
            this.f6184e = b2Var;
            this.f6185f = cVar;
            this.f6186k = sVar;
            this.f6187l = obj;
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
            u(th);
            return s3.t.f7573a;
        }

        @Override // m4.b0
        public void u(Throwable th) {
            this.f6184e.Z(this.f6185f, this.f6186k, this.f6187l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements p1 {

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f6188b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f6189c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f6190d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        private final g2 f6191a;

        public c(g2 g2Var, boolean z4, Throwable th) {
            this.f6191a = g2Var;
            this._isCompleting = z4 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return f6190d.get(this);
        }

        private final void l(Object obj) {
            f6190d.set(this, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Throwable th) {
            Throwable e5 = e();
            if (e5 == null) {
                m(th);
            } else if (th == e5) {
            } else {
                Object d5 = d();
                if (d5 == null) {
                    l(th);
                } else if (d5 instanceof Throwable) {
                    if (th == d5) {
                        return;
                    }
                    ArrayList<Throwable> b5 = b();
                    b5.add(d5);
                    b5.add(th);
                    l(b5);
                } else if (d5 instanceof ArrayList) {
                    ((ArrayList) d5).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d5).toString());
                }
            }
        }

        @Override // m4.p1
        public boolean c() {
            return e() == null;
        }

        public final Throwable e() {
            return (Throwable) f6189c.get(this);
        }

        @Override // m4.p1
        public g2 f() {
            return this.f6191a;
        }

        public final boolean g() {
            return e() != null;
        }

        public final boolean h() {
            return f6188b.get(this) != 0;
        }

        public final boolean i() {
            r4.h0 h0Var;
            Object d5 = d();
            h0Var = c2.f6204e;
            return d5 == h0Var;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            r4.h0 h0Var;
            Object d5 = d();
            if (d5 == null) {
                arrayList = b();
            } else if (d5 instanceof Throwable) {
                ArrayList<Throwable> b5 = b();
                b5.add(d5);
                arrayList = b5;
            } else if (!(d5 instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + d5).toString());
            } else {
                arrayList = (ArrayList) d5;
            }
            Throwable e5 = e();
            if (e5 != null) {
                arrayList.add(0, e5);
            }
            if (th != null && !e4.k.a(th, e5)) {
                arrayList.add(th);
            }
            h0Var = c2.f6204e;
            l(h0Var);
            return arrayList;
        }

        public final void k(boolean z4) {
            f6188b.set(this, z4 ? 1 : 0);
        }

        public final void m(Throwable th) {
            f6189c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + f() + ']';
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends s.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b2 f6192d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f6193e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(r4.s sVar, b2 b2Var, Object obj) {
            super(sVar);
            this.f6192d = b2Var;
            this.f6193e = obj;
        }

        @Override // r4.b
        /* renamed from: f */
        public Object d(r4.s sVar) {
            if (this.f6192d.m0() == this.f6193e) {
                return null;
            }
            return r4.r.a();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {956, 958}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class e extends kotlin.coroutines.jvm.internal.k implements d4.p<j4.d<? super u1>, v3.d<? super s3.t>, Object> {

        /* renamed from: b  reason: collision with root package name */
        Object f6194b;

        /* renamed from: c  reason: collision with root package name */
        Object f6195c;

        /* renamed from: d  reason: collision with root package name */
        int f6196d;

        /* renamed from: e  reason: collision with root package name */
        private /* synthetic */ Object f6197e;

        e(v3.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(j4.d<? super u1> dVar, v3.d<? super s3.t> dVar2) {
            return ((e) create(dVar, dVar2)).invokeSuspend(s3.t.f7573a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v3.d<s3.t> create(Object obj, v3.d<?> dVar) {
            e eVar = new e(dVar);
            eVar.f6197e = obj;
            return eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:27:0x0083). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0080 -> B:27:0x0083). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = w3.b.c()
                int r1 = r7.f6196d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r7.f6195c
                r4.s r1 = (r4.s) r1
                java.lang.Object r3 = r7.f6194b
                r4.q r3 = (r4.q) r3
                java.lang.Object r4 = r7.f6197e
                j4.d r4 = (j4.d) r4
                s3.n.b(r8)
                r8 = r7
                goto L83
            L1f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L27:
                s3.n.b(r8)
                goto L88
            L2b:
                s3.n.b(r8)
                java.lang.Object r8 = r7.f6197e
                j4.d r8 = (j4.d) r8
                m4.b2 r1 = m4.b2.this
                java.lang.Object r1 = r1.m0()
                boolean r4 = r1 instanceof m4.s
                if (r4 == 0) goto L49
                m4.s r1 = (m4.s) r1
                m4.t r1 = r1.f6275e
                r7.f6196d = r3
                java.lang.Object r8 = r8.b(r1, r7)
                if (r8 != r0) goto L88
                return r0
            L49:
                boolean r3 = r1 instanceof m4.p1
                if (r3 == 0) goto L88
                m4.p1 r1 = (m4.p1) r1
                m4.g2 r1 = r1.f()
                if (r1 == 0) goto L88
                java.lang.Object r3 = r1.m()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                e4.k.c(r3, r4)
                r4.s r3 = (r4.s) r3
                r4 = r8
                r8 = r7
                r6 = r3
                r3 = r1
                r1 = r6
            L65:
                boolean r5 = e4.k.a(r1, r3)
                if (r5 != 0) goto L88
                boolean r5 = r1 instanceof m4.s
                if (r5 == 0) goto L83
                r5 = r1
                m4.s r5 = (m4.s) r5
                m4.t r5 = r5.f6275e
                r8.f6197e = r4
                r8.f6194b = r3
                r8.f6195c = r1
                r8.f6196d = r2
                java.lang.Object r5 = r4.b(r5, r8)
                if (r5 != r0) goto L83
                return r0
            L83:
                r4.s r1 = r1.n()
                goto L65
            L88:
                s3.t r8 = s3.t.f7573a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: m4.b2.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public b2(boolean z4) {
        this._state = z4 ? c2.f6206g : c2.f6205f;
    }

    private final void A0(g2 g2Var, Throwable th) {
        C0(th);
        Object m5 = g2Var.m();
        e4.k.c(m5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        c0 c0Var = null;
        for (r4.s sVar = (r4.s) m5; !e4.k.a(sVar, g2Var); sVar = sVar.n()) {
            if (sVar instanceof w1) {
                a2 a2Var = (a2) sVar;
                try {
                    a2Var.u(th);
                } catch (Throwable th2) {
                    if (c0Var != null) {
                        s3.b.a(c0Var, th2);
                    } else {
                        c0Var = new c0("Exception in completion handler " + a2Var + " for " + this, th2);
                        s3.t tVar = s3.t.f7573a;
                    }
                }
            }
        }
        if (c0Var != null) {
            o0(c0Var);
        }
        T(th);
    }

    private final boolean B(Object obj, g2 g2Var, a2 a2Var) {
        int t5;
        d dVar = new d(a2Var, this, obj);
        do {
            t5 = g2Var.o().t(a2Var, g2Var, dVar);
            if (t5 == 1) {
                return true;
            }
        } while (t5 != 2);
        return false;
    }

    private final void B0(g2 g2Var, Throwable th) {
        Object m5 = g2Var.m();
        e4.k.c(m5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        c0 c0Var = null;
        for (r4.s sVar = (r4.s) m5; !e4.k.a(sVar, g2Var); sVar = sVar.n()) {
            if (sVar instanceof a2) {
                a2 a2Var = (a2) sVar;
                try {
                    a2Var.u(th);
                } catch (Throwable th2) {
                    if (c0Var != null) {
                        s3.b.a(c0Var, th2);
                    } else {
                        c0Var = new c0("Exception in completion handler " + a2Var + " for " + this, th2);
                        s3.t tVar = s3.t.f7573a;
                    }
                }
            }
        }
        if (c0Var != null) {
            o0(c0Var);
        }
    }

    private final void C(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                s3.b.a(th, th2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [m4.o1] */
    private final void F0(e1 e1Var) {
        g2 g2Var = new g2();
        if (!e1Var.c()) {
            g2Var = new o1(g2Var);
        }
        androidx.concurrent.futures.b.a(f6181a, this, e1Var, g2Var);
    }

    private final Object G(v3.d<Object> dVar) {
        v3.d b5;
        Object c5;
        b5 = w3.c.b(dVar);
        a aVar = new a(b5, this);
        aVar.B();
        o.a(aVar, O(new k2(aVar)));
        Object y4 = aVar.y();
        c5 = w3.d.c();
        if (y4 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return y4;
    }

    private final void G0(a2 a2Var) {
        a2Var.i(new g2());
        androidx.concurrent.futures.b.a(f6181a, this, a2Var, a2Var.n());
    }

    private final int J0(Object obj) {
        e1 e1Var;
        if (!(obj instanceof e1)) {
            if (obj instanceof o1) {
                if (androidx.concurrent.futures.b.a(f6181a, this, obj, ((o1) obj).f())) {
                    E0();
                    return 1;
                }
                return -1;
            }
            return 0;
        } else if (((e1) obj).c()) {
            return 0;
        } else {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6181a;
            e1Var = c2.f6206g;
            if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj, e1Var)) {
                E0();
                return 1;
            }
            return -1;
        }
    }

    private final String K0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof p1 ? ((p1) obj).c() ? "Active" : "New" : obj instanceof z ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.g() ? "Cancelling" : cVar.h() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException M0(b2 b2Var, Throwable th, String str, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                str = null;
            }
            return b2Var.L0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean O0(p1 p1Var, Object obj) {
        if (androidx.concurrent.futures.b.a(f6181a, this, p1Var, c2.g(obj))) {
            C0(null);
            D0(obj);
            Y(p1Var, obj);
            return true;
        }
        return false;
    }

    private final boolean P0(p1 p1Var, Throwable th) {
        g2 k02 = k0(p1Var);
        if (k02 == null) {
            return false;
        }
        if (androidx.concurrent.futures.b.a(f6181a, this, p1Var, new c(k02, false, th))) {
            A0(k02, th);
            return true;
        }
        return false;
    }

    private final Object Q0(Object obj, Object obj2) {
        r4.h0 h0Var;
        r4.h0 h0Var2;
        if (!(obj instanceof p1)) {
            h0Var2 = c2.f6200a;
            return h0Var2;
        } else if ((!(obj instanceof e1) && !(obj instanceof a2)) || (obj instanceof s) || (obj2 instanceof z)) {
            return R0((p1) obj, obj2);
        } else {
            if (O0((p1) obj, obj2)) {
                return obj2;
            }
            h0Var = c2.f6202c;
            return h0Var;
        }
    }

    private final Object R(Object obj) {
        r4.h0 h0Var;
        Object Q0;
        r4.h0 h0Var2;
        do {
            Object m02 = m0();
            if (!(m02 instanceof p1) || ((m02 instanceof c) && ((c) m02).h())) {
                h0Var = c2.f6200a;
                return h0Var;
            }
            Q0 = Q0(m02, new z(a0(obj), false, 2, null));
            h0Var2 = c2.f6202c;
        } while (Q0 == h0Var2);
        return Q0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object R0(p1 p1Var, Object obj) {
        r4.h0 h0Var;
        r4.h0 h0Var2;
        r4.h0 h0Var3;
        g2 k02 = k0(p1Var);
        if (k02 == null) {
            h0Var3 = c2.f6202c;
            return h0Var3;
        }
        c cVar = p1Var instanceof c ? (c) p1Var : null;
        if (cVar == null) {
            cVar = new c(k02, false, null);
        }
        e4.r rVar = new e4.r();
        synchronized (cVar) {
            if (cVar.h()) {
                h0Var2 = c2.f6200a;
                return h0Var2;
            }
            cVar.k(true);
            if (cVar != p1Var && !androidx.concurrent.futures.b.a(f6181a, this, p1Var, cVar)) {
                h0Var = c2.f6202c;
                return h0Var;
            }
            boolean g5 = cVar.g();
            z zVar = obj instanceof z ? (z) obj : null;
            if (zVar != null) {
                cVar.a(zVar.f6298a);
            }
            ?? e5 = Boolean.valueOf(g5 ? false : true).booleanValue() ? cVar.e() : 0;
            rVar.f2939a = e5;
            s3.t tVar = s3.t.f7573a;
            if (e5 != 0) {
                A0(k02, e5);
            }
            s d02 = d0(p1Var);
            return (d02 == null || !S0(cVar, d02, obj)) ? b0(cVar, obj) : c2.f6201b;
        }
    }

    private final boolean S0(c cVar, s sVar, Object obj) {
        while (u1.a.d(sVar.f6275e, false, false, new b(this, cVar, sVar, obj), 1, null) == h2.f6244a) {
            sVar = z0(sVar);
            if (sVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean T(Throwable th) {
        if (r0()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        r l02 = l0();
        return (l02 == null || l02 == h2.f6244a) ? z4 : l02.e(th) || z4;
    }

    private final void Y(p1 p1Var, Object obj) {
        r l02 = l0();
        if (l02 != null) {
            l02.a();
            I0(h2.f6244a);
        }
        z zVar = obj instanceof z ? (z) obj : null;
        Throwable th = zVar != null ? zVar.f6298a : null;
        if (!(p1Var instanceof a2)) {
            g2 f5 = p1Var.f();
            if (f5 != null) {
                B0(f5, th);
                return;
            }
            return;
        }
        try {
            ((a2) p1Var).u(th);
        } catch (Throwable th2) {
            o0(new c0("Exception in completion handler " + p1Var + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(c cVar, s sVar, Object obj) {
        s z02 = z0(sVar);
        if (z02 == null || !S0(cVar, z02, obj)) {
            E(b0(cVar, obj));
        }
    }

    private final Throwable a0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new v1(V(), null, this) : th;
        }
        e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((j2) obj).M();
    }

    private final Object b0(c cVar, Object obj) {
        boolean g5;
        Throwable h02;
        z zVar = obj instanceof z ? (z) obj : null;
        Throwable th = zVar != null ? zVar.f6298a : null;
        synchronized (cVar) {
            g5 = cVar.g();
            List<Throwable> j5 = cVar.j(th);
            h02 = h0(cVar, j5);
            if (h02 != null) {
                C(h02, j5);
            }
        }
        boolean z4 = false;
        if (h02 != null && h02 != th) {
            obj = new z(h02, false, 2, null);
        }
        if (h02 != null) {
            if ((T(h02) || n0(h02)) ? true : true) {
                e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((z) obj).b();
            }
        }
        if (!g5) {
            C0(h02);
        }
        D0(obj);
        androidx.concurrent.futures.b.a(f6181a, this, cVar, c2.g(obj));
        Y(cVar, obj);
        return obj;
    }

    private final s d0(p1 p1Var) {
        s sVar = p1Var instanceof s ? (s) p1Var : null;
        if (sVar == null) {
            g2 f5 = p1Var.f();
            if (f5 != null) {
                return z0(f5);
            }
            return null;
        }
        return sVar;
    }

    private final Throwable g0(Object obj) {
        z zVar = obj instanceof z ? (z) obj : null;
        if (zVar != null) {
            return zVar.f6298a;
        }
        return null;
    }

    private final Throwable h0(c cVar, List<? extends Throwable> list) {
        Object obj;
        boolean z4;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (cVar.g()) {
                return new v1(V(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof v2) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 == th2 || !(th3 instanceof v2)) {
                    z4 = false;
                    continue;
                } else {
                    z4 = true;
                    continue;
                }
                if (z4) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final g2 k0(p1 p1Var) {
        g2 f5 = p1Var.f();
        if (f5 == null) {
            if (p1Var instanceof e1) {
                return new g2();
            }
            if (p1Var instanceof a2) {
                G0((a2) p1Var);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + p1Var).toString());
        }
        return f5;
    }

    private final boolean s0() {
        Object m02;
        do {
            m02 = m0();
            if (!(m02 instanceof p1)) {
                return false;
            }
        } while (J0(m02) < 0);
        return true;
    }

    private final Object t0(v3.d<? super s3.t> dVar) {
        v3.d b5;
        Object c5;
        Object c6;
        b5 = w3.c.b(dVar);
        m mVar = new m(b5, 1);
        mVar.B();
        o.a(mVar, O(new l2(mVar)));
        Object y4 = mVar.y();
        c5 = w3.d.c();
        if (y4 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        c6 = w3.d.c();
        return y4 == c6 ? y4 : s3.t.f7573a;
    }

    private final Object u0(Object obj) {
        r4.h0 h0Var;
        r4.h0 h0Var2;
        r4.h0 h0Var3;
        r4.h0 h0Var4;
        r4.h0 h0Var5;
        r4.h0 h0Var6;
        Throwable th = null;
        while (true) {
            Object m02 = m0();
            if (m02 instanceof c) {
                synchronized (m02) {
                    if (((c) m02).i()) {
                        h0Var2 = c2.f6203d;
                        return h0Var2;
                    }
                    boolean g5 = ((c) m02).g();
                    if (obj != null || !g5) {
                        if (th == null) {
                            th = a0(obj);
                        }
                        ((c) m02).a(th);
                    }
                    Throwable e5 = g5 ^ true ? ((c) m02).e() : null;
                    if (e5 != null) {
                        A0(((c) m02).f(), e5);
                    }
                    h0Var = c2.f6200a;
                    return h0Var;
                }
            } else if (!(m02 instanceof p1)) {
                h0Var3 = c2.f6203d;
                return h0Var3;
            } else {
                if (th == null) {
                    th = a0(obj);
                }
                p1 p1Var = (p1) m02;
                if (!p1Var.c()) {
                    Object Q0 = Q0(m02, new z(th, false, 2, null));
                    h0Var5 = c2.f6200a;
                    if (Q0 == h0Var5) {
                        throw new IllegalStateException(("Cannot happen in " + m02).toString());
                    }
                    h0Var6 = c2.f6202c;
                    if (Q0 != h0Var6) {
                        return Q0;
                    }
                } else if (P0(p1Var, th)) {
                    h0Var4 = c2.f6200a;
                    return h0Var4;
                }
            }
        }
    }

    private final a2 x0(d4.l<? super Throwable, s3.t> lVar, boolean z4) {
        a2 a2Var;
        if (z4) {
            a2Var = lVar instanceof w1 ? (w1) lVar : null;
            if (a2Var == null) {
                a2Var = new s1(lVar);
            }
        } else {
            a2Var = lVar instanceof a2 ? (a2) lVar : null;
            if (a2Var == null) {
                a2Var = new t1(lVar);
            }
        }
        a2Var.w(this);
        return a2Var;
    }

    private final s z0(r4.s sVar) {
        while (sVar.p()) {
            sVar = sVar.o();
        }
        while (true) {
            sVar = sVar.n();
            if (!sVar.p()) {
                if (sVar instanceof s) {
                    return (s) sVar;
                }
                if (sVar instanceof g2) {
                    return null;
                }
            }
        }
    }

    protected void C0(Throwable th) {
    }

    protected void D0(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(Object obj) {
    }

    protected void E0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object F(v3.d<Object> dVar) {
        Object m02;
        do {
            m02 = m0();
            if (!(m02 instanceof p1)) {
                if (m02 instanceof z) {
                    throw ((z) m02).f6298a;
                }
                return c2.h(m02);
            }
        } while (J0(m02) < 0);
        return G(dVar);
    }

    public final boolean H(Throwable th) {
        return L(th);
    }

    public final void H0(a2 a2Var) {
        Object m02;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e1 e1Var;
        do {
            m02 = m0();
            if (!(m02 instanceof a2)) {
                if (!(m02 instanceof p1) || ((p1) m02).f() == null) {
                    return;
                }
                a2Var.q();
                return;
            } else if (m02 != a2Var) {
                return;
            } else {
                atomicReferenceFieldUpdater = f6181a;
                e1Var = c2.f6206g;
            }
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, m02, e1Var));
    }

    @Override // m4.u1
    public final r I(t tVar) {
        b1 d5 = u1.a.d(this, true, false, new s(tVar), 2, null);
        e4.k.c(d5, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (r) d5;
    }

    public final void I0(r rVar) {
        f6182b.set(this, rVar);
    }

    @Override // v3.g
    public v3.g J(v3.g gVar) {
        return u1.a.f(this, gVar);
    }

    public final boolean L(Object obj) {
        Object obj2;
        r4.h0 h0Var;
        r4.h0 h0Var2;
        r4.h0 h0Var3;
        obj2 = c2.f6200a;
        if (j0() && (obj2 = R(obj)) == c2.f6201b) {
            return true;
        }
        h0Var = c2.f6200a;
        if (obj2 == h0Var) {
            obj2 = u0(obj);
        }
        h0Var2 = c2.f6200a;
        if (obj2 == h0Var2 || obj2 == c2.f6201b) {
            return true;
        }
        h0Var3 = c2.f6203d;
        if (obj2 == h0Var3) {
            return false;
        }
        E(obj2);
        return true;
    }

    protected final CancellationException L0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = V();
            }
            cancellationException = new v1(str, th, this);
        }
        return cancellationException;
    }

    @Override // m4.j2
    public CancellationException M() {
        Throwable th;
        Object m02 = m0();
        if (m02 instanceof c) {
            th = ((c) m02).e();
        } else if (m02 instanceof z) {
            th = ((z) m02).f6298a;
        } else if (m02 instanceof p1) {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + m02).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException == null) {
            return new v1("Parent job is " + K0(m02), th, this);
        }
        return cancellationException;
    }

    public final String N0() {
        return y0() + '{' + K0(m0()) + '}';
    }

    @Override // m4.u1
    public final b1 O(d4.l<? super Throwable, s3.t> lVar) {
        return v(false, true, lVar);
    }

    @Override // m4.u1
    public final CancellationException P() {
        Object m02 = m0();
        if (!(m02 instanceof c)) {
            if (m02 instanceof p1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            } else if (m02 instanceof z) {
                return M0(this, ((z) m02).f6298a, null, 1, null);
            } else {
                return new v1(n0.a(this) + " has completed normally", null, this);
            }
        }
        Throwable e5 = ((c) m02).e();
        if (e5 != null) {
            CancellationException L0 = L0(e5, n0.a(this) + " is cancelling");
            if (L0 != null) {
                return L0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public void Q(Throwable th) {
        L(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String V() {
        return "Job was cancelled";
    }

    public boolean W(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return L(th) && i0();
    }

    @Override // m4.u1
    public boolean c() {
        Object m02 = m0();
        return (m02 instanceof p1) && ((p1) m02).c();
    }

    @Override // v3.g
    public v3.g c0(g.c<?> cVar) {
        return u1.a.e(this, cVar);
    }

    @Override // v3.g.b, v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        return (E) u1.a.c(this, cVar);
    }

    @Override // v3.g
    public <R> R e0(R r5, d4.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) u1.a.b(this, r5, pVar);
    }

    public final Object f0() {
        Object m02 = m0();
        if (!(m02 instanceof p1)) {
            if (m02 instanceof z) {
                throw ((z) m02).f6298a;
            }
            return c2.h(m02);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // m4.u1
    public void g(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new v1(V(), null, this);
        }
        Q(cancellationException);
    }

    @Override // v3.g.b
    public final g.c<?> getKey() {
        return u1.f6282h;
    }

    @Override // m4.u1
    public u1 getParent() {
        r l02 = l0();
        if (l02 != null) {
            return l02.getParent();
        }
        return null;
    }

    public boolean i0() {
        return true;
    }

    @Override // m4.t
    public final void j(j2 j2Var) {
        L(j2Var);
    }

    public boolean j0() {
        return false;
    }

    public final boolean k() {
        return !(m0() instanceof p1);
    }

    public final r l0() {
        return (r) f6182b.get(this);
    }

    public final Object m0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6181a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof r4.a0)) {
                return obj;
            }
            ((r4.a0) obj).a(this);
        }
    }

    protected boolean n0(Throwable th) {
        return false;
    }

    public void o0(Throwable th) {
        throw th;
    }

    @Override // m4.u1
    public final Object p(v3.d<? super s3.t> dVar) {
        Object c5;
        if (!s0()) {
            y1.h(dVar.getContext());
            return s3.t.f7573a;
        }
        Object t02 = t0(dVar);
        c5 = w3.d.c();
        return t02 == c5 ? t02 : s3.t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(u1 u1Var) {
        if (u1Var == null) {
            I0(h2.f6244a);
            return;
        }
        u1Var.start();
        r I = u1Var.I(this);
        I0(I);
        if (k()) {
            I.a();
            I0(h2.f6244a);
        }
    }

    public final boolean q0() {
        Object m02 = m0();
        return (m02 instanceof z) || ((m02 instanceof c) && ((c) m02).g());
    }

    protected boolean r0() {
        return false;
    }

    @Override // m4.u1
    public final boolean start() {
        int J0;
        do {
            J0 = J0(m0());
            if (J0 == 0) {
                return false;
            }
        } while (J0 != 1);
        return true;
    }

    public String toString() {
        return N0() + '@' + n0.b(this);
    }

    @Override // m4.u1
    public final j4.b<u1> u() {
        j4.b<u1> b5;
        b5 = j4.f.b(new e(null));
        return b5;
    }

    @Override // m4.u1
    public final b1 v(boolean z4, boolean z5, d4.l<? super Throwable, s3.t> lVar) {
        a2 x02 = x0(lVar, z4);
        while (true) {
            Object m02 = m0();
            if (m02 instanceof e1) {
                e1 e1Var = (e1) m02;
                if (!e1Var.c()) {
                    F0(e1Var);
                } else if (androidx.concurrent.futures.b.a(f6181a, this, m02, x02)) {
                    return x02;
                }
            } else {
                if (!(m02 instanceof p1)) {
                    if (z5) {
                        z zVar = m02 instanceof z ? (z) m02 : null;
                        lVar.invoke(zVar != null ? zVar.f6298a : null);
                    }
                    return h2.f6244a;
                }
                g2 f5 = ((p1) m02).f();
                if (f5 == null) {
                    e4.k.c(m02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    G0((a2) m02);
                } else {
                    b1 b1Var = h2.f6244a;
                    if (z4 && (m02 instanceof c)) {
                        synchronized (m02) {
                            r3 = ((c) m02).e();
                            if (r3 == null || ((lVar instanceof s) && !((c) m02).h())) {
                                if (B(m02, f5, x02)) {
                                    if (r3 == null) {
                                        return x02;
                                    }
                                    b1Var = x02;
                                }
                            }
                            s3.t tVar = s3.t.f7573a;
                        }
                    }
                    if (r3 != null) {
                        if (z5) {
                            lVar.invoke(r3);
                        }
                        return b1Var;
                    } else if (B(m02, f5, x02)) {
                        return x02;
                    }
                }
            }
        }
    }

    public final boolean v0(Object obj) {
        Object Q0;
        r4.h0 h0Var;
        r4.h0 h0Var2;
        do {
            Q0 = Q0(m0(), obj);
            h0Var = c2.f6200a;
            if (Q0 == h0Var) {
                return false;
            }
            if (Q0 == c2.f6201b) {
                return true;
            }
            h0Var2 = c2.f6202c;
        } while (Q0 == h0Var2);
        E(Q0);
        return true;
    }

    public final Throwable w() {
        Object m02 = m0();
        if (!(m02 instanceof p1)) {
            return g0(m02);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Object w0(Object obj) {
        Object Q0;
        r4.h0 h0Var;
        r4.h0 h0Var2;
        do {
            Q0 = Q0(m0(), obj);
            h0Var = c2.f6200a;
            if (Q0 == h0Var) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, g0(obj));
            }
            h0Var2 = c2.f6202c;
        } while (Q0 == h0Var2);
        return Q0;
    }

    public String y0() {
        return n0.a(this);
    }
}
