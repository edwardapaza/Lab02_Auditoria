package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.q0;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadb  reason: invalid package */
/* loaded from: classes.dex */
final class zzadb implements zzadd {
    private final /* synthetic */ Status zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadb(zzacy zzacyVar, Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadd
    public final void zza(q0.b bVar, Object... objArr) {
        bVar.onVerificationFailed(zzach.zza(this.zza));
    }
}
