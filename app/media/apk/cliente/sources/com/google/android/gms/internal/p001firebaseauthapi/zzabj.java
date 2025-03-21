package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.e;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabj extends zzacw<Void, q1> {
    private final zzya zzy;
    private final String zzz;

    public zzabj(String str, e eVar, String str2, String str3, String str4) {
        super(4);
        q.f(str, "email cannot be null or empty");
        this.zzy = new zzya(str, eVar, str2, str3);
        this.zzz = str4;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return this.zzz;
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
