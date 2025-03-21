package com.google.android.gms.internal.p001firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.o0;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzc  reason: invalid package */
/* loaded from: classes.dex */
final class zzzc implements zzadm<zzaha> {
    private final /* synthetic */ zzadm zza;
    private final /* synthetic */ zzzd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzc(zzzd zzzdVar, zzadm zzadmVar) {
        this.zza = zzadmVar;
        this.zzb = zzzdVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzaha zzahaVar) {
        zzaha zzahaVar2 = zzahaVar;
        if (TextUtils.isEmpty(zzahaVar2.zze())) {
            this.zzb.zzb.zza(new zzafm(zzahaVar2.zzd(), zzahaVar2.zzb(), Long.valueOf(zzahaVar2.zza()), "Bearer"), null, "phone", Boolean.valueOf(zzahaVar2.zzf()), null, this.zzb.zza, this.zza);
            return;
        }
        this.zzb.zza.zza(new Status(17025), o0.z(zzahaVar2.zzc(), zzahaVar2.zze()));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(str);
    }
}
