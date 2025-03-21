package io.grpc.internal;

import io.grpc.internal.r;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
/* loaded from: classes.dex */
final class s1 extends i3.u0 implements i3.i0<Object> {

    /* renamed from: k  reason: collision with root package name */
    private static final Logger f5159k = Logger.getLogger(s1.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private a1 f5160a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.j0 f5161b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5162c;

    /* renamed from: d  reason: collision with root package name */
    private final c0 f5163d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f5164e;

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f5165f;

    /* renamed from: g  reason: collision with root package name */
    private final CountDownLatch f5166g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f5167h;

    /* renamed from: i  reason: collision with root package name */
    private final o f5168i;

    /* renamed from: j  reason: collision with root package name */
    private final r.e f5169j;

    @Override // i3.d
    public String a() {
        return this.f5162c;
    }

    @Override // i3.d
    public <RequestT, ResponseT> i3.g<RequestT, ResponseT> d(i3.z0<RequestT, ResponseT> z0Var, i3.c cVar) {
        return new r(z0Var, cVar.e() == null ? this.f5164e : cVar.e(), cVar, this.f5169j, this.f5165f, this.f5168i, null);
    }

    @Override // i3.p0
    public i3.j0 e() {
        return this.f5161b;
    }

    @Override // i3.u0
    public boolean i(long j5, TimeUnit timeUnit) {
        return this.f5166g.await(j5, timeUnit);
    }

    @Override // i3.u0
    public i3.p k(boolean z4) {
        a1 a1Var = this.f5160a;
        return a1Var == null ? i3.p.IDLE : a1Var.M();
    }

    @Override // i3.u0
    public i3.u0 m() {
        this.f5167h = true;
        this.f5163d.f(i3.j1.f3447u.q("OobChannel.shutdown() called"));
        return this;
    }

    @Override // i3.u0
    public i3.u0 n() {
        this.f5167h = true;
        this.f5163d.h(i3.j1.f3447u.q("OobChannel.shutdownNow() called"));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1 o() {
        return this.f5160a;
    }

    public String toString() {
        return z0.f.b(this).c("logId", this.f5161b.d()).d("authority", this.f5162c).toString();
    }
}
