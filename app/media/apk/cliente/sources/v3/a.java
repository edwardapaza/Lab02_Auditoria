package v3;

import d4.p;
import e4.k;
import v3.g;
/* loaded from: classes.dex */
public abstract class a implements g.b {

    /* renamed from: a  reason: collision with root package name */
    private final g.c<?> f8166a;

    public a(g.c<?> cVar) {
        k.e(cVar, "key");
        this.f8166a = cVar;
    }

    @Override // v3.g
    public g J(g gVar) {
        return g.b.a.d(this, gVar);
    }

    @Override // v3.g
    public g c0(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // v3.g.b, v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // v3.g
    public <R> R e0(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r5, pVar);
    }

    @Override // v3.g.b
    public g.c<?> getKey() {
        return this.f8166a;
    }
}
