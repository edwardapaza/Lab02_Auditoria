package io.grpc.internal;

import io.grpc.internal.n1;
import io.grpc.internal.p2;
import java.io.Closeable;
/* loaded from: classes.dex */
final class m2 extends n0 {

    /* renamed from: a  reason: collision with root package name */
    private final n1.b f5010a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5011b;

    public m2(n1.b bVar) {
        this.f5010a = bVar;
    }

    @Override // io.grpc.internal.n0, io.grpc.internal.n1.b
    public void a(p2.a aVar) {
        if (!this.f5011b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            t0.e((Closeable) aVar);
        }
    }

    @Override // io.grpc.internal.n0, io.grpc.internal.n1.b
    public void b(Throwable th) {
        this.f5011b = true;
        super.b(th);
    }

    @Override // io.grpc.internal.n0
    protected n1.b c() {
        return this.f5010a;
    }

    @Override // io.grpc.internal.n0, io.grpc.internal.n1.b
    public void e(boolean z4) {
        this.f5011b = true;
        super.e(z4);
    }
}
