package io.grpc.internal;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
abstract class o0 extends i3.u0 {

    /* renamed from: a  reason: collision with root package name */
    private final i3.u0 f5065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(i3.u0 u0Var) {
        this.f5065a = u0Var;
    }

    @Override // i3.d
    public String a() {
        return this.f5065a.a();
    }

    @Override // i3.d
    public <RequestT, ResponseT> i3.g<RequestT, ResponseT> d(i3.z0<RequestT, ResponseT> z0Var, i3.c cVar) {
        return this.f5065a.d(z0Var, cVar);
    }

    @Override // i3.u0
    public boolean i(long j5, TimeUnit timeUnit) {
        return this.f5065a.i(j5, timeUnit);
    }

    @Override // i3.u0
    public void j() {
        this.f5065a.j();
    }

    @Override // i3.u0
    public i3.p k(boolean z4) {
        return this.f5065a.k(z4);
    }

    @Override // i3.u0
    public void l(i3.p pVar, Runnable runnable) {
        this.f5065a.l(pVar, runnable);
    }

    @Override // i3.u0
    public i3.u0 m() {
        return this.f5065a.m();
    }

    @Override // i3.u0
    public i3.u0 n() {
        return this.f5065a.n();
    }

    public String toString() {
        return z0.f.b(this).d("delegate", this.f5065a).toString();
    }
}
