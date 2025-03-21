package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaq  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaaq extends zzacw<zzafi, Void> {
    private final zzxw zzy;

    public zzaaq() {
        super(11);
        this.zzy = new zzxw();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "getRecaptchaParam";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource<zzafi> taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        zzb(this.zzu);
    }
}
