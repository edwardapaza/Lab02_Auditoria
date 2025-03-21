package i3;

import i3.g;
/* loaded from: classes.dex */
public abstract class z<ReqT, RespT> extends d1<ReqT, RespT> {
    @Override // i3.d1, i3.g
    public /* bridge */ /* synthetic */ void a(String str, Throwable th) {
        super.a(str, th);
    }

    @Override // i3.d1, i3.g
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // i3.d1, i3.g
    public /* bridge */ /* synthetic */ void c(int i5) {
        super.c(i5);
    }

    @Override // i3.g
    public void d(ReqT reqt) {
        f().d(reqt);
    }

    @Override // i3.g
    public void e(g.a<RespT> aVar, y0 y0Var) {
        f().e(aVar, y0Var);
    }

    @Override // i3.d1
    protected abstract g<ReqT, RespT> f();

    @Override // i3.d1
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
