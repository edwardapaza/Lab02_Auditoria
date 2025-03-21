package com.google.android.gms.internal.p001firebaseauthapi;

import j1.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzzn implements zzadm<zzagi> {
    private final /* synthetic */ zzagf zza;
    private final /* synthetic */ zzacf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzn(zzyl zzylVar, zzagf zzagfVar, zzacf zzacfVar) {
        this.zza = zzagfVar;
        this.zzb = zzacfVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadm
    public final /* synthetic */ void zza(zzagi zzagiVar) {
        zzagi zzagiVar2 = zzagiVar;
        zzagf zzagfVar = this.zza;
        if (zzagfVar instanceof zzagj) {
            this.zzb.zzb(zzagiVar2.zza());
        } else if (zzagfVar instanceof zzagl) {
            this.zzb.zza(zzagiVar2);
        } else {
            String name = this.zza.getClass().getName();
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + name + ".");
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzadj
    public final void zza(String str) {
        this.zzb.zza(r.a(str));
    }
}
