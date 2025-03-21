package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g0 extends d0 {

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f1361k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ d0 f1362l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ d f1363m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(d dVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, d0 d0Var) {
        super(taskCompletionSource);
        this.f1363m = dVar;
        this.f1361k = taskCompletionSource2;
        this.f1362l = d0Var;
    }

    @Override // com.google.android.play.integrity.internal.d0
    public final void b() {
        Object obj;
        AtomicInteger atomicInteger;
        c0 c0Var;
        obj = this.f1363m.f1348f;
        synchronized (obj) {
            d.o(this.f1363m, this.f1361k);
            atomicInteger = this.f1363m.f1354l;
            if (atomicInteger.getAndIncrement() > 0) {
                c0Var = this.f1363m.f1344b;
                c0Var.c("Already connected to the service.", new Object[0]);
            }
            d.q(this.f1363m, this.f1362l);
        }
    }
}
