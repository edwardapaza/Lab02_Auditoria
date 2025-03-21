package io.grpc.internal;

import i3.a1;
/* loaded from: classes.dex */
abstract class p0 extends i3.a1 {

    /* renamed from: a  reason: collision with root package name */
    private final i3.a1 f5086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(i3.a1 a1Var) {
        z0.k.o(a1Var, "delegate can not be null");
        this.f5086a = a1Var;
    }

    @Override // i3.a1
    public String a() {
        return this.f5086a.a();
    }

    @Override // i3.a1
    public void b() {
        this.f5086a.b();
    }

    @Override // i3.a1
    public void c() {
        this.f5086a.c();
    }

    @Override // i3.a1
    public void d(a1.e eVar) {
        this.f5086a.d(eVar);
    }

    @Override // i3.a1
    @Deprecated
    public void e(a1.f fVar) {
        this.f5086a.e(fVar);
    }

    public String toString() {
        return z0.f.b(this).d("delegate", this.f5086a).toString();
    }
}
