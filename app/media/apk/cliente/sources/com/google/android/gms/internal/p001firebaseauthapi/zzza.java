package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzza  reason: invalid package */
/* loaded from: classes.dex */
public final class zzza implements zzadm<zzagg> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzadj zzb;
    private final /* synthetic */ zzyl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzza(zzyl zzylVar, zzacf zzacfVar, zzadj zzadjVar) {
        this.zza = zzacfVar;
        this.zzb = zzadjVar;
        this.zzc = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzagg zzaggVar) {
        zzagg zzaggVar2 = zzaggVar;
        this.zzc.zza(new zzafm(zzaggVar2.zzc(), zzaggVar2.zzb(), Long.valueOf(zzaggVar2.zza()), "Bearer"), null, "password", Boolean.FALSE, null, this.zza, this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zzb.zza(str);
    }
}
