package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.a0;
import com.google.firebase.auth.i;
import com.google.firebase.auth.i0;
import j1.e2;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaao  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaao extends zzacw<i, q1> {
    private final String zzaa;
    private final i0 zzy;
    private final String zzz;

    public zzaao(i0 i0Var, String str, String str2) {
        super(2);
        this.zzy = (i0) q.k(i0Var);
        this.zzz = q.e(str);
        this.zzaa = str2;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "finalizeMfaSignIn";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzz, this.zzy, this.zzaa, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        j1.i zza = zzaag.zza(this.zzc, this.zzk);
        a0 a0Var = this.zzd;
        if (a0Var != null && !a0Var.a().equalsIgnoreCase(zza.a())) {
            zza(new Status(17024));
            return;
        }
        ((q1) this.zze).a(this.zzj, zza);
        zzb(new e2(zza));
    }
}
