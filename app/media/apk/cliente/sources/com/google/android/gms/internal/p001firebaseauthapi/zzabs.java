package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabs extends zzacw<Void, q1> {
    private final String zzaa;
    private final String zzy;
    private final String zzz;

    public zzabs(String str, String str2, String str3) {
        super(2);
        this.zzy = q.e(str);
        this.zzz = q.e(str2);
        this.zzaa = str3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "unenrollMfa";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzz, this.zzaa, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
        ((q1) this.zze).a(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }
}
