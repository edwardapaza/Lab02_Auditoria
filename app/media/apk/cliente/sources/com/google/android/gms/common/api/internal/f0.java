package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f0 implements c.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g0 f951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(g0 g0Var) {
        this.f951a = g0Var;
    }

    @Override // com.google.android.gms.common.internal.c.e
    public final void a() {
        Handler handler;
        handler = this.f951a.f967m.f949p;
        handler.post(new e0(this));
    }
}
