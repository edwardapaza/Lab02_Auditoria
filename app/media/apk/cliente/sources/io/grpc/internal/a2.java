package io.grpc.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f4417a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f4418b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f4419c;

    /* renamed from: d  reason: collision with root package name */
    private final z0.m f4420d;

    /* renamed from: e  reason: collision with root package name */
    private long f4421e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4422f;

    /* renamed from: g  reason: collision with root package name */
    private ScheduledFuture<?> f4423g;

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a2.this.f4422f) {
                a2.this.f4423g = null;
                return;
            }
            long j5 = a2.this.j();
            if (a2.this.f4421e - j5 > 0) {
                a2 a2Var = a2.this;
                a2Var.f4423g = a2Var.f4417a.schedule(new c(), a2.this.f4421e - j5, TimeUnit.NANOSECONDS);
                return;
            }
            a2.this.f4422f = false;
            a2.this.f4423g = null;
            a2.this.f4419c.run();
        }
    }

    /* loaded from: classes.dex */
    private final class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a2.this.f4418b.execute(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a2(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, z0.m mVar) {
        this.f4419c = runnable;
        this.f4418b = executor;
        this.f4417a = scheduledExecutorService;
        this.f4420d = mVar;
        mVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long j() {
        return this.f4420d.d(TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(boolean z4) {
        ScheduledFuture<?> scheduledFuture;
        this.f4422f = false;
        if (!z4 || (scheduledFuture = this.f4423g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f4423g = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(long j5, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j5);
        long j6 = j() + nanos;
        this.f4422f = true;
        if (j6 - this.f4421e < 0 || this.f4423g == null) {
            ScheduledFuture<?> scheduledFuture = this.f4423g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f4423g = this.f4417a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f4421e = j6;
    }
}
