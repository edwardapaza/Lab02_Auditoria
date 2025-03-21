package v3;

import d4.p;
import e4.k;
import java.io.Serializable;
import v3.g;
/* loaded from: classes.dex */
public final class h implements g, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final h f8175a = new h();

    private h() {
    }

    @Override // v3.g
    public g J(g gVar) {
        k.e(gVar, "context");
        return gVar;
    }

    @Override // v3.g
    public g c0(g.c<?> cVar) {
        k.e(cVar, "key");
        return this;
    }

    @Override // v3.g
    public <E extends g.b> E d(g.c<E> cVar) {
        k.e(cVar, "key");
        return null;
    }

    @Override // v3.g
    public <R> R e0(R r5, p<? super R, ? super g.b, ? extends R> pVar) {
        k.e(pVar, "operation");
        return r5;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
