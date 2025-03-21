package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.e1;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaby  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaby extends zzacw<Void, q1> {
    private final e1 zzy;

    public zzaby(e1 e1Var) {
        super(2);
        this.zzy = (e1) q.l(e1Var, "request cannot be null");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "updateProfile";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzd.zze(), this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        ((q1) this.zze).a(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }
}
