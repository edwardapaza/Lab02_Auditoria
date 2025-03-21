package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.j;
import j1.i;
import j1.q1;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaay  reason: invalid package */
/* loaded from: classes.dex */
final class zzaay extends zzacw<Void, q1> {
    private final zzyf zzy;

    public zzaay(j jVar, String str) {
        super(2);
        q.l(jVar, "Credential cannot be null");
        this.zzy = new zzyf(jVar, str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        i zza = zzaag.zza(this.zzc, this.zzk);
        if (!this.zzd.a().equalsIgnoreCase(zza.a())) {
            zza(new Status(17024));
            return;
        }
        ((q1) this.zze).a(this.zzj, zza);
        zzb(null);
    }
}
