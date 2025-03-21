package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlo  reason: invalid package */
/* loaded from: classes.dex */
public final class zzlo extends zznb<zzuw> {
    public zzlo() {
        super(zzuw.class, new zzln(zzbs.class));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final /* synthetic */ zzuw zza(zzahm zzahmVar) {
        return zzuw.zza(zzahmVar, zzaip.zza());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final zzic.zza zza() {
        return zzic.zza.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final /* synthetic */ void zzb(zzuw zzuwVar) {
        zzuw zzuwVar2 = zzuwVar;
        zzxq.zza(zzuwVar2.zza(), 0);
        if (!zzuwVar2.zzg()) {
            throw new GeneralSecurityException("Missing HPKE key params.");
        }
        zzlq.zza(zzuwVar2.zzb());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final zzux.zzb zzc() {
        return zzux.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zznb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }
}
