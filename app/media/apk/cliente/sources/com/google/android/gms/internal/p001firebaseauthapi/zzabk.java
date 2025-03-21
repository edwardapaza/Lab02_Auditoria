package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.h;
import com.google.firebase.auth.i;
import j1.e2;
import j1.p1;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabk  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabk extends zzacw<i, q1> {
    private final zzags zzy;

    public zzabk(h hVar, String str) {
        super(2);
        q.l(hVar, "credential cannot be null");
        this.zzy = p1.a(hVar, str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "signInWithCredential";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        j1.i zza = zzaag.zza(this.zzc, this.zzk);
        ((q1) this.zze).a(this.zzj, zza);
        zzb(new e2(zza));
    }
}
