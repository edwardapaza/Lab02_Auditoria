package com.google.android.gms.common.internal;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e0 extends f0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f1110a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.internal.i f1111b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(Intent intent, com.google.android.gms.common.api.internal.i iVar, int i5) {
        this.f1110a = intent;
        this.f1111b = iVar;
    }

    @Override // com.google.android.gms.common.internal.f0
    public final void a() {
        Intent intent = this.f1110a;
        if (intent != null) {
            this.f1111b.startActivityForResult(intent, 2);
        }
    }
}
