package io.grpc.internal;

import i3.j1;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    final int f5278a;

    /* renamed from: b  reason: collision with root package name */
    final long f5279b;

    /* renamed from: c  reason: collision with root package name */
    final Set<j1.b> f5280c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(int i5, long j5, Set<j1.b> set) {
        this.f5278a = i5;
        this.f5279b = j5;
        this.f5280c = a1.l.q(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f5278a == v0Var.f5278a && this.f5279b == v0Var.f5279b && z0.g.a(this.f5280c, v0Var.f5280c);
    }

    public int hashCode() {
        return z0.g.b(Integer.valueOf(this.f5278a), Long.valueOf(this.f5279b), this.f5280c);
    }

    public String toString() {
        return z0.f.b(this).b("maxAttempts", this.f5278a).c("hedgingDelayNanos", this.f5279b).d("nonFatalStatusCodes", this.f5280c).toString();
    }
}
