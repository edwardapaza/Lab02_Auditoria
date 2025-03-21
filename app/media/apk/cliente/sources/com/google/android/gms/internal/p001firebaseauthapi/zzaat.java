package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaat extends zzacw<zzafj, Void> {
    private final zzxz zzy;

    public zzaat(String str, String str2) {
        super(10);
        q.e(str2);
        this.zzy = new zzxz(str, str2);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "getRecaptchaConfig";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        zzb(this.zzt);
    }
}
