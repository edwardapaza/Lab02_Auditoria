package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaac implements zzadm<zzafm> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzyl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaac(zzyl zzylVar, String str, zzacf zzacfVar) {
        this.zza = str;
        this.zzb = zzacfVar;
        this.zzc = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzafm zzafmVar2 = zzafmVar;
        String zzc = zzafmVar2.zzc();
        zzagb zzagbVar = new zzagb();
        zzagbVar.zzd(zzc).zzf(this.zza);
        zzyl.zza(this.zzc, this.zzb, zzafmVar2, zzagbVar, this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zzb.zza(r.a(str));
    }
}
