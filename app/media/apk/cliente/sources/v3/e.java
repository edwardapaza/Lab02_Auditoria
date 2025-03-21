package v3;

import e4.k;
import v3.g;
/* loaded from: classes.dex */
public interface e extends g.b {

    /* renamed from: j  reason: collision with root package name */
    public static final b f8172j = b.f8173a;

    /* loaded from: classes.dex */
    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> cVar) {
            k.e(cVar, "key");
            if (!(cVar instanceof v3.b)) {
                if (e.f8172j == cVar) {
                    k.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                    return eVar;
                }
                return null;
            }
            v3.b bVar = (v3.b) cVar;
            if (bVar.a(eVar.getKey())) {
                E e5 = (E) bVar.b(eVar);
                if (e5 instanceof g.b) {
                    return e5;
                }
                return null;
            }
            return null;
        }

        public static g b(e eVar, g.c<?> cVar) {
            k.e(cVar, "key");
            if (!(cVar instanceof v3.b)) {
                return e.f8172j == cVar ? h.f8175a : eVar;
            }
            v3.b bVar = (v3.b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f8175a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements g.c<e> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f8173a = new b();

        private b() {
        }
    }

    void A(d<?> dVar);

    <T> d<T> S(d<? super T> dVar);
}
