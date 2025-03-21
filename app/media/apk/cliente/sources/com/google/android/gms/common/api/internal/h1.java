package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f970a;

    public h1(int i5) {
        this.f970a = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void b(Exception exc);

    public abstract void c(g0<?> g0Var);

    public abstract void d(w wVar, boolean z4);
}
