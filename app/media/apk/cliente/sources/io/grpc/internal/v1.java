package io.grpc.internal;

import i3.r0;
/* loaded from: classes.dex */
public final class v1 extends r0.f {

    /* renamed from: a  reason: collision with root package name */
    private final i3.c f5281a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.y0 f5282b;

    /* renamed from: c  reason: collision with root package name */
    private final i3.z0<?, ?> f5283c;

    public v1(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar) {
        this.f5283c = (i3.z0) z0.k.o(z0Var, "method");
        this.f5282b = (i3.y0) z0.k.o(y0Var, "headers");
        this.f5281a = (i3.c) z0.k.o(cVar, "callOptions");
    }

    @Override // i3.r0.f
    public i3.c a() {
        return this.f5281a;
    }

    @Override // i3.r0.f
    public i3.y0 b() {
        return this.f5282b;
    }

    @Override // i3.r0.f
    public i3.z0<?, ?> c() {
        return this.f5283c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v1.class != obj.getClass()) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return z0.g.a(this.f5281a, v1Var.f5281a) && z0.g.a(this.f5282b, v1Var.f5282b) && z0.g.a(this.f5283c, v1Var.f5283c);
    }

    public int hashCode() {
        return z0.g.b(this.f5281a, this.f5282b, this.f5283c);
    }

    public final String toString() {
        return "[method=" + this.f5283c + " headers=" + this.f5282b + " callOptions=" + this.f5281a + "]";
    }
}
