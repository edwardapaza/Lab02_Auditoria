package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
/* loaded from: classes.dex */
abstract class o0 extends w0 {

    /* renamed from: d  reason: collision with root package name */
    public final int f1185d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f1186e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ c f1187f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(c cVar, int i5, Bundle bundle) {
        super(cVar, Boolean.TRUE);
        this.f1187f = cVar;
        this.f1185d = i5;
        this.f1186e = bundle;
    }

    @Override // com.google.android.gms.common.internal.w0
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f1185d != 0) {
            this.f1187f.zzp(1, null);
            Bundle bundle = this.f1186e;
            f(new l0.a(this.f1185d, bundle != null ? (PendingIntent) bundle.getParcelable(c.KEY_PENDING_INTENT) : null));
        } else if (g()) {
        } else {
            this.f1187f.zzp(1, null);
            f(new l0.a(8, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.w0
    public final void b() {
    }

    protected abstract void f(l0.a aVar);

    protected abstract boolean g();
}
