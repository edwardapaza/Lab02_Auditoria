package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.c0;
/* loaded from: classes.dex */
final class ah extends IntegrityTokenResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f1263a;

    /* renamed from: b  reason: collision with root package name */
    private final u f1264b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(String str, c0 c0Var, PendingIntent pendingIntent) {
        this.f1263a = str;
        this.f1264b = new u(c0Var, pendingIntent);
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final String token() {
        return this.f1263a;
    }
}
