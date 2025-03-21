package io.grpc.internal;

import io.grpc.internal.p2;
import io.grpc.internal.t;
/* loaded from: classes.dex */
abstract class l0 implements t {
    @Override // io.grpc.internal.p2
    public void a(p2.a aVar) {
        e().a(aVar);
    }

    @Override // io.grpc.internal.p2
    public void b() {
        e().b();
    }

    @Override // io.grpc.internal.t
    public void c(i3.y0 y0Var) {
        e().c(y0Var);
    }

    @Override // io.grpc.internal.t
    public void d(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
        e().d(j1Var, aVar, y0Var);
    }

    protected abstract t e();

    public String toString() {
        return z0.f.b(this).d("delegate", e()).toString();
    }
}
