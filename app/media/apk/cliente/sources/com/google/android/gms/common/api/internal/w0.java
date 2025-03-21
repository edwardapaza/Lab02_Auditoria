package com.google.android.gms.common.api.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z0 f1060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(z0 z0Var) {
        this.f1060a = z0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y0 y0Var;
        y0Var = this.f1060a.f1075g;
        y0Var.b(new l0.a(4));
    }
}
