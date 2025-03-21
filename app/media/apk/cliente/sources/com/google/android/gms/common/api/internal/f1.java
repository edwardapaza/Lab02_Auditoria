package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
public final class f1<ResultT> extends p0 {

    /* renamed from: b  reason: collision with root package name */
    private final r<a.b, ResultT> f952b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource<ResultT> f953c;

    /* renamed from: d  reason: collision with root package name */
    private final q f954d;

    public f1(int i5, r<a.b, ResultT> rVar, TaskCompletionSource<ResultT> taskCompletionSource, q qVar) {
        super(i5);
        this.f953c = taskCompletionSource;
        this.f952b = rVar;
        this.f954d = qVar;
        if (i5 == 2 && rVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void a(Status status) {
        this.f953c.trySetException(this.f954d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void b(Exception exc) {
        this.f953c.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void c(g0<?> g0Var) {
        try {
            this.f952b.b(g0Var.v(), this.f953c);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e6) {
            a(h1.e(e6));
        } catch (RuntimeException e7) {
            this.f953c.trySetException(e7);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void d(w wVar, boolean z4) {
        wVar.d(this.f953c, z4);
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final boolean f(g0<?> g0Var) {
        return this.f952b.c();
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final l0.c[] g(g0<?> g0Var) {
        return this.f952b.e();
    }
}
