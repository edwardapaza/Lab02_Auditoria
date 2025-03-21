package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c1<T> extends p0 {

    /* renamed from: b  reason: collision with root package name */
    protected final TaskCompletionSource<T> f925b;

    public c1(int i5, TaskCompletionSource<T> taskCompletionSource) {
        super(i5);
        this.f925b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void a(Status status) {
        this.f925b.trySetException(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void b(Exception exc) {
        this.f925b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void c(g0<?> g0Var) {
        try {
            h(g0Var);
        } catch (DeadObjectException e5) {
            a(h1.e(e5));
            throw e5;
        } catch (RemoteException e6) {
            a(h1.e(e6));
        } catch (RuntimeException e7) {
            this.f925b.trySetException(e7);
        }
    }

    protected abstract void h(g0<?> g0Var);
}
