package m4;

import v3.e;
import v3.g;
/* loaded from: classes.dex */
public abstract class g0 extends v3.a implements v3.e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f6233b = new a(null);

    /* loaded from: classes.dex */
    public static final class a extends v3.b<v3.e, g0> {

        /* renamed from: m4.g0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0094a extends e4.l implements d4.l<g.b, g0> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0094a f6234a = new C0094a();

            C0094a() {
                super(1);
            }

            @Override // d4.l
            /* renamed from: a */
            public final g0 invoke(g.b bVar) {
                if (bVar instanceof g0) {
                    return (g0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(v3.e.f8172j, C0094a.f6234a);
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public g0() {
        super(v3.e.f8172j);
    }

    @Override // v3.e
    public final void A(v3.d<?> dVar) {
        e4.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((r4.j) dVar).p();
    }

    @Override // v3.e
    public final <T> v3.d<T> S(v3.d<? super T> dVar) {
        return new r4.j(this, dVar);
    }

    @Override // v3.a, v3.g
    public v3.g c0(g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    @Override // v3.a, v3.g.b, v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    public abstract void f0(v3.g gVar, Runnable runnable);

    public boolean g0(v3.g gVar) {
        return true;
    }

    public g0 h0(int i5) {
        r4.p.a(i5);
        return new r4.o(this, i5);
    }

    public String toString() {
        return n0.a(this) + '@' + n0.b(this);
    }
}
