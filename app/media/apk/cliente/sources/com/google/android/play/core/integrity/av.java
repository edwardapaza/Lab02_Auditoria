package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
final class av extends at {

    /* renamed from: c  reason: collision with root package name */
    private final c0 f1287c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
        this.f1287c = new c0("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.at, com.google.android.play.integrity.internal.w
    public final void e(Bundle bundle) {
        super.e(bundle);
        this.f1287c.c("onWarmUpExpressIntegrityToken", new Object[0]);
        int i5 = bundle.getInt("error");
        if (i5 != 0) {
            this.f1284a.trySetException(new StandardIntegrityException(i5, null));
        } else {
            this.f1284a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
