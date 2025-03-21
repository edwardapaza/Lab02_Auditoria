package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.i;
import j1.e2;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabm  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabm extends zzacw<i, q1> {
    private final String zzaa;
    private final String zzab;
    private final String zzy;
    private final String zzz;

    public zzabm(String str, String str2, String str3, String str4) {
        super(2);
        q.f(str, "email cannot be null or empty");
        q.f(str2, "password cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
        this.zzaa = str3;
        this.zzab = str4;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "signInWithEmailAndPassword";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zzb(this.zzy, this.zzz, this.zzaa, this.zzab, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        j1.i zza = zzaag.zza(this.zzc, this.zzk);
        ((q1) this.zze).a(this.zzj, zza);
        zzb(new e2(zza));
    }
}
