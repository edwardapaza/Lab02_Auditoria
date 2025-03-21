package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzga  reason: invalid package */
/* loaded from: classes.dex */
public final class zzga {
    private static final zzbt<zzbh> zza = zznd.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzbh.class, zzux.zzb.SYMMETRIC, zzvp.zze());
    private static final zznn<zzgj> zzb = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfz
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            return zzga.zza((zzgj) zzciVar, null);
        }
    };
    private static final zzoe<zzgk, zzbh> zzc = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgc
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            zzbh zzb2;
            zzb2 = zzga.zzb((zzgk) zzbuVar);
            return zzb2;
        }
    }, zzgk.class, zzbh.class);

    public static /* synthetic */ zzgk zza(zzgj zzgjVar, Integer num) {
        if (num == null) {
            return zzgk.zza(zzgjVar);
        }
        throw new GeneralSecurityException("Id Requirement is not supported for LegacyKmsEnvelopeAeadKey");
    }

    public static void zza(boolean z4) {
        zzgo.zza();
        zznk.zza().zza(zzb, zzgj.class);
        zzns.zza().zza(zzc);
        zzcu.zza((zzbt) zza, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzbh zzb(zzgk zzgkVar) {
        try {
            zzvd zza2 = zzvd.zza(zzcv.zza(zzgkVar.zzb().zzb()), zzaip.zza());
            String zzc2 = zzgkVar.zzb().zzc();
            return new zzfx(zza2, zzcg.zza(zzc2).zza(zzc2));
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing of DEK key template failed: ", e5);
        }
    }
}
