package io.grpc.internal;

import io.grpc.internal.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i0 implements u {

    /* renamed from: a  reason: collision with root package name */
    final i3.j1 f4789a;

    /* renamed from: b  reason: collision with root package name */
    private final t.a f4790b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(i3.j1 j1Var, t.a aVar) {
        z0.k.e(!j1Var.o(), "error must not be OK");
        this.f4789a = j1Var;
        this.f4790b = aVar;
    }

    @Override // io.grpc.internal.u
    public s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
        return new h0(this.f4789a, this.f4790b, kVarArr);
    }

    @Override // i3.p0
    public i3.j0 e() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
