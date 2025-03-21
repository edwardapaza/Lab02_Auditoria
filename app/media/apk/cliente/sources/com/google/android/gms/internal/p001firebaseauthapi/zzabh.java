package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabh  reason: invalid package */
/* loaded from: classes.dex */
final class zzabh extends zzacw<Void, Void> {
    private final zzafy zzy;

    public zzabh(String str, String str2, String str3, String str4) {
        super(15);
        this.zzy = zzafy.zzg().zzd(str).zza(str2).zzc(str4).zzb(str3).zza(zzaex.ACCESS_TOKEN).zza();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "revokeAccessToken";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource<Void> taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        zzb(null);
    }
}
