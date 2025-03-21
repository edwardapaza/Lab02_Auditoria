package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j1 f1008a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n1 f1009b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1(n1 n1Var, j1 j1Var) {
        this.f1009b = n1Var;
        this.f1008a = j1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1009b.f1012a) {
            l0.a b5 = this.f1008a.b();
            if (b5.w()) {
                n1 n1Var = this.f1009b;
                n1Var.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(n1Var.getActivity(), (PendingIntent) com.google.android.gms.common.internal.q.k(b5.v()), this.f1008a.a(), false), 1);
                return;
            }
            n1 n1Var2 = this.f1009b;
            if (n1Var2.f1015d.a(n1Var2.getActivity(), b5.t(), null) != null) {
                n1 n1Var3 = this.f1009b;
                n1Var3.f1015d.v(n1Var3.getActivity(), this.f1009b.mLifecycleFragment, b5.t(), 2, this.f1009b);
            } else if (b5.t() != 18) {
                this.f1009b.a(b5, this.f1008a.a());
            } else {
                n1 n1Var4 = this.f1009b;
                Dialog q5 = n1Var4.f1015d.q(n1Var4.getActivity(), this.f1009b);
                n1 n1Var5 = this.f1009b;
                n1Var5.f1015d.r(n1Var5.getActivity().getApplicationContext(), new k1(this, q5));
            }
        }
    }
}
