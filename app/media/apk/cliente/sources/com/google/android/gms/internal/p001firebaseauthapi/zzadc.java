package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.q0;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadc  reason: invalid package */
/* loaded from: classes.dex */
final class zzadc implements zzadd {
    private final /* synthetic */ String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadc(zzacy zzacyVar, String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadd
    public final void zza(q0.b bVar, Object... objArr) {
        bVar.onCodeAutoRetrievalTimeOut(this.zza);
    }
}
