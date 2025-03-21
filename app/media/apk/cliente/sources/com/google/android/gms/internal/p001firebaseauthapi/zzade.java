package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzade  reason: invalid package */
/* loaded from: classes.dex */
final class zzade implements Runnable {
    private final /* synthetic */ zzadd zza;
    private final /* synthetic */ zzacy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzade(zzacy zzacyVar, zzadd zzaddVar) {
        this.zza = zzaddVar;
        this.zzb = zzacyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
