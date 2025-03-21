package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.j;
import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyp implements zzadm<zzafm> {
    private final /* synthetic */ j zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzacf zzc;
    private final /* synthetic */ zzyl zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyp(zzyl zzylVar, j jVar, String str, zzacf zzacfVar) {
        this.zza = jVar;
        this.zzb = str;
        this.zzc = zzacfVar;
        this.zzd = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        this.zzd.zza(new zzaeo(this.zza, zzafmVar.zzc(), this.zzb), this.zzc);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }
}
