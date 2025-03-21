package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzzi implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    final /* synthetic */ zzyl zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzi(zzyl zzylVar, String str, String str2, zzacf zzacfVar) {
        this.zzc = str;
        this.zzd = str2;
        this.zza = zzacfVar;
        this.zzb = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzadk zzadkVar;
        zzagz zzagzVar = new zzagz(zzafmVar.zzc(), this.zzc, this.zzd);
        zzadkVar = this.zzb.zza;
        zzadkVar.zza(zzagzVar, new zzzl(this));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }
}
