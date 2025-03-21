package com.google.android.gms.common.api.internal;

import android.app.Dialog;
/* loaded from: classes.dex */
final class k1 extends m0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f993a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l1 f994b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(l1 l1Var, Dialog dialog) {
        this.f994b = l1Var;
        this.f993a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.m0
    public final void a() {
        this.f994b.f1009b.d();
        if (this.f993a.isShowing()) {
            this.f993a.dismiss();
        }
    }
}
