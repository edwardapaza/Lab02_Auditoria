package r4;

import m4.p2;
import v3.g;
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f7204a = new h0("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final d4.p<Object, g.b, Object> f7205b = a.f7208a;

    /* renamed from: c  reason: collision with root package name */
    private static final d4.p<p2<?>, g.b, p2<?>> f7206c = b.f7209a;

    /* renamed from: d  reason: collision with root package name */
    private static final d4.p<p0, g.b, p0> f7207d = c.f7210a;

    /* loaded from: classes.dex */
    static final class a extends e4.l implements d4.p<Object, g.b, Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7208a = new a();

        a() {
            super(2);
        }

        @Override // d4.p
        /* renamed from: a */
        public final Object invoke(Object obj, g.b bVar) {
            if (bVar instanceof p2) {
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e4.l implements d4.p<p2<?>, g.b, p2<?>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f7209a = new b();

        b() {
            super(2);
        }

        @Override // d4.p
        /* renamed from: a */
        public final p2<?> invoke(p2<?> p2Var, g.b bVar) {
            if (p2Var != null) {
                return p2Var;
            }
            if (bVar instanceof p2) {
                return (p2) bVar;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends e4.l implements d4.p<p0, g.b, p0> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7210a = new c();

        c() {
            super(2);
        }

        @Override // d4.p
        /* renamed from: a */
        public final p0 invoke(p0 p0Var, g.b bVar) {
            if (bVar instanceof p2) {
                p2<?> p2Var = (p2) bVar;
                p0Var.a(p2Var, p2Var.N(p0Var.f7222a));
            }
            return p0Var;
        }
    }

    public static final void a(v3.g gVar, Object obj) {
        if (obj == f7204a) {
            return;
        }
        if (obj instanceof p0) {
            ((p0) obj).b(gVar);
            return;
        }
        Object e02 = gVar.e0(null, f7206c);
        e4.k.c(e02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((p2) e02).X(gVar, obj);
    }

    public static final Object b(v3.g gVar) {
        Object e02 = gVar.e0(0, f7205b);
        e4.k.b(e02);
        return e02;
    }

    public static final Object c(v3.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f7204a;
        }
        if (obj instanceof Integer) {
            return gVar.e0(new p0(gVar, ((Number) obj).intValue()), f7207d);
        }
        e4.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((p2) obj).N(gVar);
    }
}
