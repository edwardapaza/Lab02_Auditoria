package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
final class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f0 f928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(f0 f0Var) {
        this.f928a = f0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f fVar;
        a.f fVar2;
        g0 g0Var = this.f928a.f951a;
        fVar = g0Var.f956b;
        fVar2 = g0Var.f956b;
        fVar.disconnect(fVar2.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
