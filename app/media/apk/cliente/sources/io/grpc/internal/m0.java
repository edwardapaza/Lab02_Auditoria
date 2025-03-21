package io.grpc.internal;

import io.grpc.internal.m1;
import io.grpc.internal.u;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
abstract class m0 implements x {
    protected abstract x a();

    @Override // io.grpc.internal.m1
    public Runnable b(m1.a aVar) {
        return a().b(aVar);
    }

    @Override // io.grpc.internal.u
    public s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
        return a().c(z0Var, y0Var, cVar, kVarArr);
    }

    @Override // i3.p0
    public i3.j0 e() {
        return a().e();
    }

    @Override // io.grpc.internal.m1
    public void f(i3.j1 j1Var) {
        a().f(j1Var);
    }

    @Override // io.grpc.internal.u
    public void g(u.a aVar, Executor executor) {
        a().g(aVar, executor);
    }

    @Override // io.grpc.internal.m1
    public void h(i3.j1 j1Var) {
        a().h(j1Var);
    }

    public String toString() {
        return z0.f.b(this).d("delegate", a()).toString();
    }
}
