package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.q0;
import com.google.firebase.auth.t0;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabt  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabt extends zzacw<Void, q0.b> {
    private final zzyh zzy;

    public zzabt(t0 t0Var, String str, String str2, long j5, boolean z4, boolean z5, String str3, String str4, boolean z6) {
        super(8);
        q.k(t0Var);
        q.e(str);
        this.zzy = new zzyh(t0Var, str, str2, j5, z4, z5, str3, str4, z6);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
    }
}
