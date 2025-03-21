package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.e1;
import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaa  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaaa implements zzadm<zzafm> {
    private final /* synthetic */ e1 zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzyl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaaa(zzyl zzylVar, e1 e1Var, zzacf zzacfVar) {
        this.zza = e1Var;
        this.zzb = zzacfVar;
        this.zzc = zzylVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzafm zzafmVar) {
        zzafm zzafmVar2 = zzafmVar;
        zzagb zzagbVar = new zzagb();
        zzagbVar.zzd(zzafmVar2.zzc());
        if (this.zza.u() || this.zza.q() != null) {
            zzagbVar.zzb(this.zza.q());
        }
        if (this.zza.v() || this.zza.t() != null) {
            zzagbVar.zzg(this.zza.zza());
        }
        zzyl.zza(this.zzc, this.zzb, zzafmVar2, zzagbVar, this);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zzb.zza(r.a(str));
    }
}
