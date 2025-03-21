package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f1043a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1044b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u1 f1045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(u1 u1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f1045c = u1Var;
        this.f1043a = lifecycleCallback;
        this.f1044b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        u1 u1Var = this.f1045c;
        i5 = u1Var.f1053j0;
        if (i5 > 0) {
            LifecycleCallback lifecycleCallback = this.f1043a;
            bundle = u1Var.f1054k0;
            if (bundle != null) {
                String str = this.f1044b;
                bundle3 = u1Var.f1054k0;
                bundle2 = bundle3.getBundle(str);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i6 = this.f1045c.f1053j0;
        if (i6 >= 2) {
            this.f1043a.onStart();
        }
        i7 = this.f1045c.f1053j0;
        if (i7 >= 3) {
            this.f1043a.onResume();
        }
        i8 = this.f1045c.f1053j0;
        if (i8 >= 4) {
            this.f1043a.onStop();
        }
        i9 = this.f1045c.f1053j0;
        if (i9 >= 5) {
            this.f1043a.onDestroy();
        }
    }
}
