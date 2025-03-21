package m4;

import v3.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a3 implements g.b, g.c<a3> {

    /* renamed from: a  reason: collision with root package name */
    public static final a3 f6180a = new a3();

    private a3() {
    }

    @Override // v3.g
    public v3.g J(v3.g gVar) {
        return g.b.a.d(this, gVar);
    }

    @Override // v3.g
    public v3.g c0(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // v3.g.b, v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // v3.g
    public <R> R e0(R r5, d4.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r5, pVar);
    }

    @Override // v3.g.b
    public g.c<?> getKey() {
        return this;
    }
}
