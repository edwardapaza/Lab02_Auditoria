package com.google.android.gms.common.api.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f926a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g0 f927b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(g0 g0Var, int i5) {
        this.f927b = g0Var;
        this.f926a = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f927b.k(this.f926a);
    }
}
