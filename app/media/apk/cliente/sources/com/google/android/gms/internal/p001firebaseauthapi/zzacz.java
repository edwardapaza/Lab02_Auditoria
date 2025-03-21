package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.o0;
import com.google.firebase.auth.q0;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacz  reason: invalid package */
/* loaded from: classes.dex */
final class zzacz implements zzadd {
    private final /* synthetic */ o0 zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacz(zzacy zzacyVar, o0 o0Var) {
        this.zza = o0Var;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadd
    public final void zza(q0.b bVar, Object... objArr) {
        bVar.onVerificationCompleted(this.zza);
    }
}
