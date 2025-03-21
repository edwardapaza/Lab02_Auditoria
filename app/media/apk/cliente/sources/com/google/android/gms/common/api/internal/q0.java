package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q0<T> implements OnCompleteListener<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f1016a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1017b;

    /* renamed from: c  reason: collision with root package name */
    private final b<?> f1018c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1019d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1020e;

    q0(f fVar, int i5, b<?> bVar, long j5, long j6, String str, String str2) {
        this.f1016a = fVar;
        this.f1017b = i5;
        this.f1018c = bVar;
        this.f1019d = j5;
        this.f1020e = j6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> q0<T> a(f fVar, int i5, b<?> bVar) {
        boolean z4;
        if (fVar.f()) {
            com.google.android.gms.common.internal.s a5 = com.google.android.gms.common.internal.r.b().a();
            if (a5 == null) {
                z4 = true;
            } else if (!a5.v()) {
                return null;
            } else {
                z4 = a5.w();
                g0 w5 = fVar.w(bVar);
                if (w5 != null) {
                    if (!(w5.v() instanceof com.google.android.gms.common.internal.c)) {
                        return null;
                    }
                    com.google.android.gms.common.internal.c cVar = (com.google.android.gms.common.internal.c) w5.v();
                    if (cVar.hasConnectionInfo() && !cVar.isConnecting()) {
                        com.google.android.gms.common.internal.e b5 = b(w5, cVar, i5);
                        if (b5 == null) {
                            return null;
                        }
                        w5.G();
                        z4 = b5.x();
                    }
                }
            }
            return new q0<>(fVar, i5, bVar, z4 ? System.currentTimeMillis() : 0L, z4 ? SystemClock.elapsedRealtime() : 0L, null, null);
        }
        return null;
    }

    private static com.google.android.gms.common.internal.e b(g0<?> g0Var, com.google.android.gms.common.internal.c<?> cVar, int i5) {
        int[] u5;
        int[] v5;
        com.google.android.gms.common.internal.e telemetryConfiguration = cVar.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.w() || ((u5 = telemetryConfiguration.u()) != null ? !q0.b.a(u5, i5) : !((v5 = telemetryConfiguration.v()) == null || !q0.b.a(v5, i5))) || g0Var.s() >= telemetryConfiguration.t()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<T> task) {
        g0 w5;
        int i5;
        int i6;
        int i7;
        int i8;
        int t5;
        long j5;
        long j6;
        int i9;
        if (this.f1016a.f()) {
            com.google.android.gms.common.internal.s a5 = com.google.android.gms.common.internal.r.b().a();
            if ((a5 == null || a5.v()) && (w5 = this.f1016a.w(this.f1018c)) != null && (w5.v() instanceof com.google.android.gms.common.internal.c)) {
                com.google.android.gms.common.internal.c cVar = (com.google.android.gms.common.internal.c) w5.v();
                boolean z4 = true;
                boolean z5 = this.f1019d > 0;
                int gCoreServiceId = cVar.getGCoreServiceId();
                if (a5 != null) {
                    z5 &= a5.w();
                    int t6 = a5.t();
                    int u5 = a5.u();
                    i5 = a5.x();
                    if (cVar.hasConnectionInfo() && !cVar.isConnecting()) {
                        com.google.android.gms.common.internal.e b5 = b(w5, cVar, this.f1017b);
                        if (b5 == null) {
                            return;
                        }
                        z4 = (!b5.x() || this.f1019d <= 0) ? false : false;
                        u5 = b5.t();
                        z5 = z4;
                    }
                    i6 = t6;
                    i7 = u5;
                } else {
                    i5 = 0;
                    i6 = 5000;
                    i7 = 100;
                }
                f fVar = this.f1016a;
                if (task.isSuccessful()) {
                    i8 = 0;
                    t5 = 0;
                } else {
                    if (task.isCanceled()) {
                        i8 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof com.google.android.gms.common.api.b) {
                            Status status = ((com.google.android.gms.common.api.b) exception).getStatus();
                            int u6 = status.u();
                            l0.a t7 = status.t();
                            t5 = t7 == null ? -1 : t7.t();
                            i8 = u6;
                        } else {
                            i8 = 101;
                        }
                    }
                    t5 = -1;
                }
                if (z5) {
                    long j7 = this.f1019d;
                    j6 = System.currentTimeMillis();
                    j5 = j7;
                    i9 = (int) (SystemClock.elapsedRealtime() - this.f1020e);
                } else {
                    j5 = 0;
                    j6 = 0;
                    i9 = -1;
                }
                fVar.H(new com.google.android.gms.common.internal.o(this.f1017b, i8, t5, j5, j6, null, null, gCoreServiceId, i9), i5, i6, i7);
            }
        }
    }
}
