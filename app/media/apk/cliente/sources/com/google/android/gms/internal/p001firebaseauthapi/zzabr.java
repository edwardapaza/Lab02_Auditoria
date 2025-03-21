package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import j1.p;
import j1.q1;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzabr extends zzacw<Void, q1> {
    private final String zzaa;
    private final long zzab;
    private final boolean zzac;
    private final boolean zzad;
    private final String zzae;
    private final String zzaf;
    private final boolean zzag;
    private final String zzy;
    private final String zzz;

    public zzabr(p pVar, String str, String str2, long j5, boolean z4, boolean z5, String str3, String str4, boolean z6) {
        super(8);
        q.k(pVar);
        q.e(str);
        this.zzy = q.e(pVar.w());
        this.zzz = str;
        this.zzaa = str2;
        this.zzab = j5;
        this.zzac = z4;
        this.zzad = z5;
        this.zzae = str3;
        this.zzaf = str4;
        this.zzag = z6;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadh
    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzaceVar) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzaceVar.zza(this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzae, this.zzaf, this.zzag, this.zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacw
    public final void zzb() {
    }
}
