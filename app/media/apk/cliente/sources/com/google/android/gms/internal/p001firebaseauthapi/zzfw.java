package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfw  reason: invalid package */
/* loaded from: classes.dex */
public final class zzfw {
    private static final zzoe<zzgb, zzbh> zza = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfv
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            zzbh zza2;
            zza2 = zzcg.zza(r1.zzb().zzb()).zza(((zzgb) zzbuVar).zzb().zzb());
            return zza2;
        }
    }, zzgb.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzbh.class, zzux.zzb.REMOTE, zzvl.zze());
    private static final zznn<zzge> zzc = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfy
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            return zzfw.zza((zzge) zzciVar, null);
        }
    };

    public static /* synthetic */ zzgb zza(zzge zzgeVar, Integer num) {
        if (num == null) {
            return zzgb.zza(zzgeVar);
        }
        throw new GeneralSecurityException("Id Requirement is not supported for LegacyKmsEnvelopeAeadKey");
    }

    public static void zza(boolean z4) {
        zzgd.zza();
        zzns.zza().zza(zza);
        zznk.zza().zza(zzc, zzge.class);
        zzcu.zza((zzbt) zzb, true);
    }
}
