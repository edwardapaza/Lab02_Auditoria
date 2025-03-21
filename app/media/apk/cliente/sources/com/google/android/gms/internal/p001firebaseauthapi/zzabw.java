package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabw extends zzacw<Void, q1> {
    private final String zzy;

    public zzabw(String str) {
        super(2);
        this.zzy = q.f(str, "password cannot be null or empty");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "updatePassword";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zzc(this.zzd.zze(), this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        ((q1) this.zze).a(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }
}
