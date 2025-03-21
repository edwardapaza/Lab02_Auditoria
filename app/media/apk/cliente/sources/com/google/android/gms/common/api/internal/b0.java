package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.c;
/* loaded from: classes.dex */
final class b0 implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(f fVar) {
        this.f918a = fVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z4) {
        Handler handler;
        Handler handler2;
        f fVar = this.f918a;
        handler = fVar.f949p;
        handler2 = fVar.f949p;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z4)));
    }
}
