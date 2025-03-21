package io.grpc.internal;

import i3.b;
/* loaded from: classes.dex */
final class p1 extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private final u f5087a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.z0<?, ?> f5088b;

    /* renamed from: c  reason: collision with root package name */
    private final i3.y0 f5089c;

    /* renamed from: d  reason: collision with root package name */
    private final i3.c f5090d;

    /* renamed from: f  reason: collision with root package name */
    private final a f5092f;

    /* renamed from: g  reason: collision with root package name */
    private final i3.k[] f5093g;

    /* renamed from: i  reason: collision with root package name */
    private s f5095i;

    /* renamed from: j  reason: collision with root package name */
    boolean f5096j;

    /* renamed from: k  reason: collision with root package name */
    d0 f5097k;

    /* renamed from: h  reason: collision with root package name */
    private final Object f5094h = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final i3.r f5091e = i3.r.e();

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1(u uVar, i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, a aVar, i3.k[] kVarArr) {
        this.f5087a = uVar;
        this.f5088b = z0Var;
        this.f5089c = y0Var;
        this.f5090d = cVar;
        this.f5092f = aVar;
        this.f5093g = kVarArr;
    }

    private void c(s sVar) {
        boolean z4;
        z0.k.u(!this.f5096j, "already finalized");
        this.f5096j = true;
        synchronized (this.f5094h) {
            if (this.f5095i == null) {
                this.f5095i = sVar;
                z4 = true;
            } else {
                z4 = false;
            }
        }
        if (!z4) {
            z0.k.u(this.f5097k != null, "delayedStream is null");
            Runnable w5 = this.f5097k.w(sVar);
            if (w5 != null) {
                w5.run();
            }
        }
        this.f5092f.a();
    }

    @Override // i3.b.a
    public void a(i3.y0 y0Var) {
        z0.k.u(!this.f5096j, "apply() or fail() already called");
        z0.k.o(y0Var, "headers");
        this.f5089c.m(y0Var);
        i3.r b5 = this.f5091e.b();
        try {
            s c5 = this.f5087a.c(this.f5088b, this.f5089c, this.f5090d, this.f5093g);
            this.f5091e.f(b5);
            c(c5);
        } catch (Throwable th) {
            this.f5091e.f(b5);
            throw th;
        }
    }

    @Override // i3.b.a
    public void b(i3.j1 j1Var) {
        z0.k.e(!j1Var.o(), "Cannot fail with OK status");
        z0.k.u(!this.f5096j, "apply() or fail() already called");
        c(new h0(t0.n(j1Var), this.f5093g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s d() {
        synchronized (this.f5094h) {
            s sVar = this.f5095i;
            if (sVar == null) {
                d0 d0Var = new d0();
                this.f5097k = d0Var;
                this.f5095i = d0Var;
                return d0Var;
            }
            return sVar;
        }
    }
}
