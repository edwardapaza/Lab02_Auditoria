package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.o0;
import j1.i;
import j1.q1;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabc  reason: invalid package */
/* loaded from: classes.dex */
final class zzabc extends zzacw<Void, q1> {
    private final zzye zzy;

    public zzabc(o0 o0Var, String str) {
        super(2);
        q.l(o0Var, "credential cannot be null");
        o0Var.y(false);
        this.zzy = new zzye(o0Var, str);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "reauthenticateWithPhoneCredential";
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
