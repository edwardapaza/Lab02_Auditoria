package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzyr implements zzadm<zzafc> {
    private final /* synthetic */ zzadj zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzafm zzc;
    private final /* synthetic */ zzagb zzd;
    private final /* synthetic */ zzyl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyr(zzyl zzylVar, zzadj zzadjVar, zzacf zzacfVar, zzafm zzafmVar, zzagb zzagbVar) {
        this.zza = zzadjVar;
        this.zzb = zzacfVar;
        this.zzc = zzafmVar;
        this.zzd = zzagbVar;
        this.zze = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafc zzafcVar) {
        List<zzafb> zza = zzafcVar.zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzyl.zza(this.zze, this.zzb, this.zzc, zza.get(0), this.zzd, this.zza);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zza.zza(str);
    }
}
