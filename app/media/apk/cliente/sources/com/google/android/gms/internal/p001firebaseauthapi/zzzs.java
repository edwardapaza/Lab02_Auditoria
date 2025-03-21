package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzs  reason: invalid package */
/* loaded from: classes.dex */
public final class zzzs implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzs(zzyl zzylVar, zzacf zzacfVar) {
        this.zza = zzacfVar;
        this.zzb = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzadk zzadkVar;
        zzafm zzafmVar2 = zzafmVar;
        zzaez zzaezVar = new zzaez(zzafmVar2.zzc());
        zzadkVar = this.zzb.zza;
        zzadkVar.zza(zzaezVar, new zzzv(this, this, zzafmVar2));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }
}
