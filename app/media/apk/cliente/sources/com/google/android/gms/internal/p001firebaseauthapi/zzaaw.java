package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.h;
import j1.i;
import j1.p1;
import j1.q1;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaw  reason: invalid package */
/* loaded from: classes.dex */
final class zzaaw extends zzacw<Void, q1> {
    private final zzags zzy;

    public zzaaw(h hVar, String str) {
        super(2);
        q.l(hVar, "credential cannot be null");
        this.zzy = p1.a(hVar, str).zza(false);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "reauthenticateWithCredential";
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
