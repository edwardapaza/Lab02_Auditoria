package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzv  reason: invalid package */
/* loaded from: classes.dex */
final class zzzv implements zzadm<zzafc> {
    private final /* synthetic */ zzadm zza;
    private final /* synthetic */ zzafm zzb;
    private final /* synthetic */ zzzs zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzv(zzzs zzzsVar, zzadm zzadmVar, zzafm zzafmVar) {
        this.zza = zzadmVar;
        this.zzb = zzafmVar;
        this.zzc = zzzsVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafc zzafcVar) {
        List<zzafb> zza = zzafcVar.zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zza(this.zzb, zza.get(0));
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(str);
    }
}
