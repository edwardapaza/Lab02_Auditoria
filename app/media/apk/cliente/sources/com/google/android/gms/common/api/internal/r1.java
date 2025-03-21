package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f1033a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1034b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s1 f1035c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(s1 s1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f1035c = s1Var;
        this.f1033a = lifecycleCallback;
        this.f1034b = str;
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
        s1 s1Var = this.f1035c;
        i5 = s1Var.f1039b;
        if (i5 > 0) {
            LifecycleCallback lifecycleCallback = this.f1033a;
            bundle = s1Var.f1040c;
            if (bundle != null) {
                String str = this.f1034b;
                bundle3 = s1Var.f1040c;
                bundle2 = bundle3.getBundle(str);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i6 = this.f1035c.f1039b;
        if (i6 >= 2) {
            this.f1033a.onStart();
        }
        i7 = this.f1035c.f1039b;
        if (i7 >= 3) {
            this.f1033a.onResume();
        }
        i8 = this.f1035c.f1039b;
        if (i8 >= 4) {
            this.f1033a.onStop();
        }
        i9 = this.f1035c.f1039b;
        if (i9 >= 5) {
            this.f1033a.onDestroy();
        }
    }
}
