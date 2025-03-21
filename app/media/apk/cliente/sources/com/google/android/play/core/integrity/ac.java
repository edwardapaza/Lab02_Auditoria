package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.a0;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
final class ac extends a0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1254a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f1255b = new c0("OnRequestIntegrityTokenCallback");

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f1256c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ad adVar, TaskCompletionSource taskCompletionSource) {
        this.f1254a = adVar;
        this.f1256c = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.b0
    public final void b(Bundle bundle) {
        this.f1254a.f1257a.v(this.f1256c);
        this.f1255b.c("onRequestIntegrityToken", new Object[0]);
        int i5 = bundle.getInt("error");
        if (i5 != 0) {
            this.f1256c.trySetException(new IntegrityServiceException(i5, null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f1256c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        Object parcelable = Build.VERSION.SDK_INT >= 33 ? bundle.getParcelable("dialog.intent", PendingIntent.class) : bundle.getParcelable("dialog.intent");
        TaskCompletionSource taskCompletionSource = this.f1256c;
        a aVar = new a();
        aVar.c(string);
        aVar.b(this.f1255b);
        aVar.a((PendingIntent) parcelable);
        taskCompletionSource.trySetResult(aVar.d());
    }
}
