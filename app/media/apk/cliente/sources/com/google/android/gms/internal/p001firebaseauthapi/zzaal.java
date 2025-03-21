package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaal extends zzacw<Void, q1> {
    private final zzxx zzy;

    public zzaal(String str, String str2, String str3) {
        super(4);
        q.f(str, "code cannot be null or empty");
        q.f(str2, "new password cannot be null or empty");
        this.zzy = new zzxx(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "confirmPasswordReset";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        zzb(null);
    }
}
