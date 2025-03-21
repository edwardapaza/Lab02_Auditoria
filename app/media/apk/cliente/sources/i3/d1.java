package i3;
/* loaded from: classes.dex */
abstract class d1<ReqT, RespT> extends g<ReqT, RespT> {
    @Override // i3.g
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    @Override // i3.g
    public void b() {
        f().b();
    }

    @Override // i3.g
    public void c(int i5) {
        f().c(i5);
    }

    protected abstract g<?, ?> f();

    public String toString() {
        return z0.f.b(this).d("delegate", f()).toString();
    }
}
