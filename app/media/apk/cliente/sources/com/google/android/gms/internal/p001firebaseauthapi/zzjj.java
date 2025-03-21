package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjj  reason: invalid package */
/* loaded from: classes.dex */
final class zzjj extends zznb<zztt> {
    public zzjj() {
        super(zztt.class, new zzji(zzbs.class));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final /* synthetic */ zztt zza(zzahm zzahmVar) {
        return zztt.zza(zzahmVar, zzaip.zza());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final zzic.zza zza() {
        return zzic.zza.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final /* synthetic */ void zzb(zztt zzttVar) {
        zztt zzttVar2 = zzttVar;
        zzxq.zza(zzttVar2.zza(), 0);
        zzku.zza(zzttVar2.zzb());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final zzux.zzb zzc() {
        return zzux.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }
}
