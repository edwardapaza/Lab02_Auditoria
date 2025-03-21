package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
/* loaded from: classes.dex */
public final class x0 extends q0 {

    /* renamed from: a  reason: collision with root package name */
    private c f1214a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1215b;

    public x0(c cVar, int i5) {
        this.f1214a = cVar;
        this.f1215b = i5;
    }

    @Override // com.google.android.gms.common.internal.l
    public final void h(int i5, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.l
    public final void i(int i5, IBinder iBinder, b1 b1Var) {
        c cVar = this.f1214a;
        q.l(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        q.k(b1Var);
        c.zzj(cVar, b1Var);
        k(i5, iBinder, b1Var.f1079a);
    }

    @Override // com.google.android.gms.common.internal.l
    public final void k(int i5, IBinder iBinder, Bundle bundle) {
        q.l(this.f1214a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f1214a.onPostInitHandler(i5, iBinder, bundle, this.f1215b);
        this.f1214a = null;
    }
}
