package io.grpc.internal;

import io.grpc.internal.n1;
import io.grpc.internal.p2;
/* loaded from: classes.dex */
abstract class n0 implements n1.b {
    @Override // io.grpc.internal.n1.b
    public void a(p2.a aVar) {
        c().a(aVar);
    }

    @Override // io.grpc.internal.n1.b
    public void b(Throwable th) {
        c().b(th);
    }

    protected abstract n1.b c();

    @Override // io.grpc.internal.n1.b
    public void e(boolean z4) {
        c().e(z4);
    }

    @Override // io.grpc.internal.n1.b
    public void f(int i5) {
        c().f(i5);
    }
}
