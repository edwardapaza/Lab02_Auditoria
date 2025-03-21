package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzp  reason: invalid package */
/* loaded from: classes.dex */
final class zzzp implements zzadm<zzaep> {
    private final /* synthetic */ zzzm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzp(zzzm zzzmVar) {
        this.zza = zzzmVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzaep zzaepVar) {
        zzaep zzaepVar2 = zzaepVar;
        zzafm zzafmVar = new zzafm(zzaepVar2.zzb(), zzaepVar2.zza(), Long.valueOf(zzafo.zza(zzaepVar2.zza())), "Bearer");
        zzzm zzzmVar = this.zza;
        zzzmVar.zzb.zza(zzafmVar, null, null, Boolean.FALSE, null, zzzmVar.zza, this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza.zza(r.a(str));
    }
}
