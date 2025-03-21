package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzh  reason: invalid package */
/* loaded from: classes.dex */
public final class zzzh implements zzadm<zzafm> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzh(zzyl zzylVar, zzacf zzacfVar) {
        this.zza = zzacfVar;
        this.zzb = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzafm zzafmVar2 = zzafmVar;
        zzagb zzagbVar = new zzagb();
        zzagbVar.zzd(zzafmVar2.zzc()).zzc(null).zzf(null);
        zzyl.zza(this.zzb, this.zza, zzafmVar2, zzagbVar, this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }
}
