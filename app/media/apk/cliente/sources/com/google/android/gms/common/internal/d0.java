package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 extends f0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f1101a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f1102b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f1103c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(Intent intent, Activity activity, int i5) {
        this.f1101a = intent;
        this.f1102b = activity;
        this.f1103c = i5;
    }

    @Override // com.google.android.gms.common.internal.f0
    public final void a() {
        Intent intent = this.f1101a;
        if (intent != null) {
            this.f1102b.startActivityForResult(intent, this.f1103c);
        }
    }
}
