package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzu  reason: invalid package */
/* loaded from: classes.dex */
public final class zzzu implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzu(zzyl zzylVar, zzacf zzacfVar) {
        this.zza = zzacfVar;
        this.zzb = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzadk zzadkVar;
        zzael zzaelVar = new zzael(zzafmVar.zzc());
        zzadkVar = this.zzb.zza;
        zzadkVar.zza(zzaelVar, new zzzx(this, this));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }
}
