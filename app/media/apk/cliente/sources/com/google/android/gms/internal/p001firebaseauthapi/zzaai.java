package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.d;
import j1.q1;
import j1.z1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaai  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaai extends zzacw<d, q1> {
    private final String zzy;
    private final String zzz;

    public zzaai(String str, String str2) {
        super(4);
        q.f(str, "code cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "checkActionCode";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zzd(this.zzy, this.zzz, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        zzb(new z1(this.zzm));
    }
}
