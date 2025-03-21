package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.i0;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaap  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaap extends zzacw<Void, q1> {
    private final String zzaa;
    private final String zzab;
    private final i0 zzy;
    private final String zzz;

    public zzaap(i0 i0Var, String str, String str2, String str3) {
        super(2);
        this.zzy = (i0) q.k(i0Var);
        this.zzz = q.e(str);
        this.zzaa = str2;
        this.zzab = str3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzz, this.zzaa, this.zzab, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        ((q1) this.zze).a(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }
}
