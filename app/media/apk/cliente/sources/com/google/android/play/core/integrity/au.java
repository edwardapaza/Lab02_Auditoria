package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
final class au extends at {

    /* renamed from: c  reason: collision with root package name */
    private final c0 f1286c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
        this.f1286c = new c0("OnRequestIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.at, com.google.android.play.integrity.internal.w
    public final void c(Bundle bundle) {
        super.c(bundle);
        this.f1286c.c("onRequestExpressIntegrityToken", new Object[0]);
        int i5 = bundle.getInt("error");
        if (i5 != 0) {
            this.f1284a.trySetException(new StandardIntegrityException(i5, null));
            return;
        }
        Object parcelable = Build.VERSION.SDK_INT >= 33 ? bundle.getParcelable("dialog.intent", PendingIntent.class) : bundle.getParcelable("dialog.intent");
        TaskCompletionSource taskCompletionSource = this.f1284a;
        b bVar = new b();
        bVar.c(bundle.getString("token"));
        bVar.b(this.f1286c);
        bVar.a((PendingIntent) parcelable);
        taskCompletionSource.trySetResult(bVar.d());
    }
}
