package q3;

import i3.k;
import i3.y0;
/* loaded from: classes.dex */
public abstract class a extends k {
    @Override // i3.m1
    public void a(int i5) {
        o().a(i5);
    }

    @Override // i3.m1
    public void b(int i5, long j5, long j6) {
        o().b(i5, j5, j6);
    }

    @Override // i3.m1
    public void c(long j5) {
        o().c(j5);
    }

    @Override // i3.m1
    public void d(long j5) {
        o().d(j5);
    }

    @Override // i3.m1
    public void e(int i5) {
        o().e(i5);
    }

    @Override // i3.m1
    public void f(int i5, long j5, long j6) {
        o().f(i5, j5, j6);
    }

    @Override // i3.m1
    public void g(long j5) {
        o().g(j5);
    }

    @Override // i3.m1
    public void h(long j5) {
        o().h(j5);
    }

    @Override // i3.k
    public void j() {
        o().j();
    }

    @Override // i3.k
    public void k() {
        o().k();
    }

    @Override // i3.k
    public void l(y0 y0Var) {
        o().l(y0Var);
    }

    @Override // i3.k
    public void m() {
        o().m();
    }

    @Override // i3.k
    public void n(i3.a aVar, y0 y0Var) {
        o().n(aVar, y0Var);
    }

    protected abstract k o();

    public String toString() {
        return z0.f.b(this).d("delegate", o()).toString();
    }
}
