package io.grpc.internal;

import io.grpc.internal.k;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class g0 implements k {

    /* renamed from: a  reason: collision with root package name */
    private Random f4766a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private long f4767b = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: c  reason: collision with root package name */
    private long f4768c = TimeUnit.MINUTES.toNanos(2);

    /* renamed from: d  reason: collision with root package name */
    private double f4769d = 1.6d;

    /* renamed from: e  reason: collision with root package name */
    private double f4770e = 0.2d;

    /* renamed from: f  reason: collision with root package name */
    private long f4771f = this.f4767b;

    /* loaded from: classes.dex */
    public static final class a implements k.a {
        @Override // io.grpc.internal.k.a
        public k get() {
            return new g0();
        }
    }

    private long b(double d5, double d6) {
        z0.k.d(d6 >= d5);
        return (long) ((this.f4766a.nextDouble() * (d6 - d5)) + d5);
    }

    @Override // io.grpc.internal.k
    public long a() {
        long j5 = this.f4771f;
        double d5 = j5;
        this.f4771f = Math.min((long) (this.f4769d * d5), this.f4768c);
        double d6 = this.f4770e;
        return j5 + b((-d6) * d5, d6 * d5);
    }
}
