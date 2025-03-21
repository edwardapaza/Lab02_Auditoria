package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzql  reason: invalid package */
/* loaded from: classes.dex */
final class zzql extends zzna<zzuf, zzue> {
    private final /* synthetic */ zzqe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzql(zzqe zzqeVar, Class cls) {
        super(cls);
        this.zza = zzqeVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzna
    public final /* synthetic */ zzuf zza(zzahm zzahmVar) {
        return zzuf.zza(zzahmVar, zzaip.zza());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzna
    public final /* synthetic */ zzue zza(zzuf zzufVar) {
        zzuf zzufVar2 = zzufVar;
        return (zzue) ((zzaja) zzue.zzb().zza(zzqe.zzh()).zza(zzufVar2.zzf()).zza(zzahm.zza(zzov.zza(zzufVar2.zza()))).zzf());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzna
    public final /* synthetic */ void zzb(zzuf zzufVar) {
        zzuf zzufVar2 = zzufVar;
        if (zzufVar2.zza() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzqe.zzb(zzufVar2.zzf());
    }
}
