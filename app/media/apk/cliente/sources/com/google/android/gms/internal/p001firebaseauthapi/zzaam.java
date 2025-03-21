package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.w0;
import j1.q1;
import j1.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaam extends zzacw<w0, q1> {
    private final String zzy;
    private final String zzz;

    public zzaam(String str, String str2) {
        super(3);
        q.f(str, "email cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zze(this.zzy, this.zzz, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        zzb(new u(this.zzl.zza() == null ? zzaq.zzh() : (List) q.k(this.zzl.zza())));
    }
}
