package v3;

import d4.l;
import e4.k;
import v3.g;
import v3.g.b;
/* loaded from: classes.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* renamed from: a  reason: collision with root package name */
    private final l<g.b, E> f8167a;

    /* renamed from: b  reason: collision with root package name */
    private final g.c<?> f8168b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [d4.l<? super v3.g$b, ? extends E extends B>, java.lang.Object, d4.l<v3.g$b, E extends B>] */
    public b(g.c<B> cVar, l<? super g.b, ? extends E> lVar) {
        k.e(cVar, "baseKey");
        k.e(lVar, "safeCast");
        this.f8167a = lVar;
        this.f8168b = cVar instanceof b ? (g.c<B>) ((b) cVar).f8168b : cVar;
    }

    public final boolean a(g.c<?> cVar) {
        k.e(cVar, "key");
        return cVar == this || this.f8168b == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lv3/g$b;)TE; */
    public final g.b b(g.b bVar) {
        k.e(bVar, "element");
        return (g.b) this.f8167a.invoke(bVar);
    }
}
