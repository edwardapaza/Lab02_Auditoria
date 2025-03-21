package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzzb implements zzadm<zzafm> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzacf zze;
    private final /* synthetic */ zzyl zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzb(zzyl zzylVar, String str, String str2, String str3, String str4, zzacf zzacfVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzacfVar;
        this.zzf = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzyl.zza(this.zzf, this.zze, new zzagd(this.zza, this.zzb, null, this.zzc, this.zzd, zzafmVar.zzc()), this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zze.zza(r.a(str));
    }
}
