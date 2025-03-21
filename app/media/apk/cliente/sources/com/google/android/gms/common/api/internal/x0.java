package com.google.android.gms.common.api.internal;
/* loaded from: classes.dex */
final class x0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x0.l f1063a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z0 f1064b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(z0 z0Var, x0.l lVar) {
        this.f1064b = z0Var;
        this.f1063a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z0.m(this.f1064b, this.f1063a);
    }
}
