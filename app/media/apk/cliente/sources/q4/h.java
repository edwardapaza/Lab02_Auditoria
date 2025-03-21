package q4;

import v3.g;
/* loaded from: classes.dex */
public final class h implements v3.g {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f7101a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ v3.g f7102b;

    public h(Throwable th, v3.g gVar) {
        this.f7101a = th;
        this.f7102b = gVar;
    }

    @Override // v3.g
    public v3.g J(v3.g gVar) {
        return this.f7102b.J(gVar);
    }

    @Override // v3.g
    public v3.g c0(g.c<?> cVar) {
        return this.f7102b.c0(cVar);
    }

    @Override // v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        return (E) this.f7102b.d(cVar);
    }

    @Override // v3.g
    public <R> R e0(R r5, d4.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) this.f7102b.e0(r5, pVar);
    }
}
