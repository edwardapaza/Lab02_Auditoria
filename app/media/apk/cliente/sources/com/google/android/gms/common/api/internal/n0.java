package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
public final class n0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f1010a;

    /* renamed from: b  reason: collision with root package name */
    private final m0 f1011b;

    public n0(m0 m0Var) {
        this.f1011b = m0Var;
    }

    public final void a(Context context) {
        this.f1010a = context;
    }

    public final synchronized void b() {
        Context context = this.f1010a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f1010a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f1011b.a();
            b();
        }
    }
}
