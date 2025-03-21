package io.grpc.internal;

import io.grpc.internal.t;
/* loaded from: classes.dex */
public final class h0 extends q1 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f4781b;

    /* renamed from: c  reason: collision with root package name */
    private final i3.j1 f4782c;

    /* renamed from: d  reason: collision with root package name */
    private final t.a f4783d;

    /* renamed from: e  reason: collision with root package name */
    private final i3.k[] f4784e;

    public h0(i3.j1 j1Var, t.a aVar, i3.k[] kVarArr) {
        z0.k.e(!j1Var.o(), "error must not be OK");
        this.f4782c = j1Var;
        this.f4783d = aVar;
        this.f4784e = kVarArr;
    }

    public h0(i3.j1 j1Var, i3.k[] kVarArr) {
        this(j1Var, t.a.PROCESSED, kVarArr);
    }

    @Override // io.grpc.internal.q1, io.grpc.internal.s
    public void f(t tVar) {
        z0.k.u(!this.f4781b, "already started");
        this.f4781b = true;
        for (i3.k kVar : this.f4784e) {
            kVar.i(this.f4782c);
        }
        tVar.d(this.f4782c, this.f4783d, new i3.y0());
    }

    @Override // io.grpc.internal.q1, io.grpc.internal.s
    public void l(z0 z0Var) {
        z0Var.b("error", this.f4782c).b("progress", this.f4783d);
    }
}
