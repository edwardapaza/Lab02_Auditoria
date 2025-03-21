package com.google.android.gms.common.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
public final class a1 extends o0 {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ c f1077g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(c cVar, int i5, Bundle bundle) {
        super(cVar, i5, null);
        this.f1077g = cVar;
    }

    @Override // com.google.android.gms.common.internal.o0
    protected final void f(l0.a aVar) {
        if (this.f1077g.enableLocalFallback() && c.zzo(this.f1077g)) {
            c.zzk(this.f1077g, 16);
            return;
        }
        this.f1077g.zzc.a(aVar);
        this.f1077g.onConnectionFailed(aVar);
    }

    @Override // com.google.android.gms.common.internal.o0
    protected final boolean g() {
        this.f1077g.zzc.a(l0.a.f5864e);
        return true;
    }
}
