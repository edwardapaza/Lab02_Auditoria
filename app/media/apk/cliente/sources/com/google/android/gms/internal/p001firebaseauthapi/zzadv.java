package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;
import o0.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzadv implements OnFailureListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadv(zzadt zzadtVar) {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        a aVar;
        aVar = zzadt.zza;
        String message = exc.getMessage();
        aVar.c("SmsRetrieverClient failed to start: " + message, new Object[0]);
    }
}
