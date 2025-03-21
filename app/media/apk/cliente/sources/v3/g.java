package v3;

import d4.p;
import e4.k;
import e4.l;
import v3.e;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: v3.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0120a extends l implements p<g, b, g> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0120a f8174a = new C0120a();

            C0120a() {
                super(2);
            }

            @Override // d4.p
            /* renamed from: a */
            public final g invoke(g gVar, b bVar) {
                v3.c cVar;
                k.e(gVar, "acc");
                k.e(bVar, "element");
                g c02 = gVar.c0(bVar.getKey());
                h hVar = h.f8175a;
                if (c02 == hVar) {
                    return bVar;
                }
                e.b bVar2 = e.f8172j;
                e eVar = (e) c02.d(bVar2);
                if (eVar == null) {
                    cVar = new v3.c(c02, bVar);
                } else {
                    g c03 = c02.c0(bVar2);
                    if (c03 == hVar) {
                        return new v3.c(bVar, eVar);
                    }
                    cVar = new v3.c(new v3.c(c03, bVar), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g gVar2) {
            k.e(gVar2, "context");
            return gVar2 == h.f8175a ? gVar : (g) gVar2.e0(gVar, C0120a.f8174a);
        }
    }

    /* loaded from: classes.dex */
    public interface b extends g {

        /* loaded from: classes.dex */
        public static final class a {
            public static <R> R a(b bVar, R r5, p<? super R, ? super b, ? extends R> pVar) {
                k.e(pVar, "operation");
                return pVar.invoke(r5, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                k.e(cVar, "key");
                if (k.a(bVar.getKey(), cVar)) {
                    k.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return bVar;
                }
                return null;
            }

            public static g c(b bVar, c<?> cVar) {
                k.e(cVar, "key");
                return k.a(bVar.getKey(), cVar) ? h.f8175a : bVar;
            }

            public static g d(b bVar, g gVar) {
                k.e(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        @Override // v3.g
        <E extends b> E d(c<E> cVar);

        c<?> getKey();
    }

    /* loaded from: classes.dex */
    public interface c<E extends b> {
    }

    g J(g gVar);

    g c0(c<?> cVar);

    <E extends b> E d(c<E> cVar);

    <R> R e0(R r5, p<? super R, ? super b, ? extends R> pVar);
}
