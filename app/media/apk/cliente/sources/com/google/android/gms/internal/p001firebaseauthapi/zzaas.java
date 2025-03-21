package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.i;
import com.google.firebase.auth.j;
import j1.e2;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaas  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaas extends zzacw<i, q1> {
    private final j zzy;
    private final String zzz;

    public zzaas(j jVar, String str) {
        super(2);
        this.zzy = (j) q.l(jVar, "credential cannot be null");
        q.f(jVar.zzc(), "email cannot be null");
        q.f(jVar.zzd(), "password cannot be null");
        this.zzz = str;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "linkEmailAuthCredential";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy.zzc(), q.e(this.zzy.zzd()), this.zzd.zze(), this.zzd.y(), this.zzz, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        j1.i zza = zzaag.zza(this.zzc, this.zzk);
        ((q1) this.zze).a(this.zzj, zza);
        zzb(new e2(zza));
    }
}
