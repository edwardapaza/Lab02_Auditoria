package io.grpc.internal;

import i3.j1;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    final int f4605a;

    /* renamed from: b  reason: collision with root package name */
    final long f4606b;

    /* renamed from: c  reason: collision with root package name */
    final long f4607c;

    /* renamed from: d  reason: collision with root package name */
    final double f4608d;

    /* renamed from: e  reason: collision with root package name */
    final Long f4609e;

    /* renamed from: f  reason: collision with root package name */
    final Set<j1.b> f4610f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c2(int i5, long j5, long j6, double d5, Long l5, Set<j1.b> set) {
        this.f4605a = i5;
        this.f4606b = j5;
        this.f4607c = j6;
        this.f4608d = d5;
        this.f4609e = l5;
        this.f4610f = a1.l.q(set);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c2) {
            c2 c2Var = (c2) obj;
            return this.f4605a == c2Var.f4605a && this.f4606b == c2Var.f4606b && this.f4607c == c2Var.f4607c && Double.compare(this.f4608d, c2Var.f4608d) == 0 && z0.g.a(this.f4609e, c2Var.f4609e) && z0.g.a(this.f4610f, c2Var.f4610f);
        }
        return false;
    }

    public int hashCode() {
        return z0.g.b(Integer.valueOf(this.f4605a), Long.valueOf(this.f4606b), Long.valueOf(this.f4607c), Double.valueOf(this.f4608d), this.f4609e, this.f4610f);
    }

    public String toString() {
        return z0.f.b(this).b("maxAttempts", this.f4605a).c("initialBackoffNanos", this.f4606b).c("maxBackoffNanos", this.f4607c).a("backoffMultiplier", this.f4608d).d("perAttemptRecvTimeoutNanos", this.f4609e).d("retryableStatusCodes", this.f4610f).toString();
    }
}
