package io.grpc.internal;

import java.io.InputStream;
/* loaded from: classes.dex */
abstract class k0 implements s {
    @Override // io.grpc.internal.s
    public void a(i3.j1 j1Var) {
        o().a(j1Var);
    }

    @Override // io.grpc.internal.o2
    public void b(i3.n nVar) {
        o().b(nVar);
    }

    @Override // io.grpc.internal.o2
    public void c(int i5) {
        o().c(i5);
    }

    @Override // io.grpc.internal.s
    public void d(int i5) {
        o().d(i5);
    }

    @Override // io.grpc.internal.s
    public void e(int i5) {
        o().e(i5);
    }

    @Override // io.grpc.internal.s
    public void f(t tVar) {
        o().f(tVar);
    }

    @Override // io.grpc.internal.o2
    public void flush() {
        o().flush();
    }

    @Override // io.grpc.internal.s
    public void g(i3.t tVar) {
        o().g(tVar);
    }

    @Override // io.grpc.internal.s
    public void h(i3.v vVar) {
        o().h(vVar);
    }

    @Override // io.grpc.internal.o2
    public boolean i() {
        return o().i();
    }

    @Override // io.grpc.internal.o2
    public void j(InputStream inputStream) {
        o().j(inputStream);
    }

    @Override // io.grpc.internal.s
    public void k(String str) {
        o().k(str);
    }

    @Override // io.grpc.internal.s
    public void l(z0 z0Var) {
        o().l(z0Var);
    }

    @Override // io.grpc.internal.o2
    public void m() {
        o().m();
    }

    @Override // io.grpc.internal.s
    public void n() {
        o().n();
    }

    protected abstract s o();

    @Override // io.grpc.internal.s
    public void p(boolean z4) {
        o().p(z4);
    }

    public String toString() {
        return z0.f.b(this).d("delegate", o()).toString();
    }
}
