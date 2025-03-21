package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzgj;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgo  reason: invalid package */
/* loaded from: classes.dex */
public final class zzgo {
    private static final zzxr zza;
    private static final zzoa<zzgj, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzgk, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgn
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").zza(zzgo.zzb((zzgj) zzciVar).zzi()).zza(zzvt.RAW).zzf()));
                return zzb3;
            }
        }, zzgj.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgq
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzgj zzb3;
                zzb3 = zzgo.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgp
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzvp) ((zzaja) zzvp.zzb().zza(zzgo.zzb(((zzgk) zzbuVar).zzb())).zzf())).zzi(), zzux.zzb.REMOTE, zzvt.RAW, null);
                return zza2;
            }
        }, zzgk.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgs
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzgk zzb3;
                zzb3 = zzgo.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzgj zza(zzvq zzvqVar) {
        zzgj.zzb zzbVar;
        zzci zza2 = zzcv.zza(((zzvd) ((zzaja) zzvd.zza().zza(zzvqVar.zza().zzf()).zza(zzvqVar.zza().zze()).zza(zzvt.RAW).zzf())).zzj());
        if (zza2 instanceof zzer) {
            zzbVar = zzgj.zzb.zza;
        } else if (zza2 instanceof zzfo) {
            zzbVar = zzgj.zzb.zzc;
        } else if (zza2 instanceof zzhd) {
            zzbVar = zzgj.zzb.zzb;
        } else if (zza2 instanceof zzdm) {
            zzbVar = zzgj.zzb.zzd;
        } else if (zza2 instanceof zzea) {
            zzbVar = zzgj.zzb.zze;
        } else if (!(zza2 instanceof zzfa)) {
            String valueOf = String.valueOf(zza2);
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + valueOf);
        } else {
            zzbVar = zzgj.zzb.zzf;
        }
        return new zzgj.zza().zza(zzvqVar.zze()).zza((zzdc) zza2).zza(zzbVar).zza();
    }

    public static void zza() {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgj zzb(zzos zzosVar) {
        if (zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zza(zzvq.zza(zzosVar.zza().zze(), zzaip.zza()));
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e5);
            }
        }
        String zzf = zzosVar.zza().zzf();
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgk zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzvp zza2 = zzvp.zza(zzotVar.zzd(), zzaip.zza());
                if (zzotVar.zzc() != zzvt.RAW) {
                    String valueOf = String.valueOf(zza2);
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + valueOf);
                } else if (zza2.zza() == 0) {
                    return zzgk.zza(zza(zza2.zzd()));
                } else {
                    String valueOf2 = String.valueOf(zza2);
                    throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + valueOf2);
                }
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e5);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
    }

    private static zzvq zzb(zzgj zzgjVar) {
        try {
            return (zzvq) ((zzaja) zzvq.zzb().zza(zzgjVar.zzc()).zza(zzvd.zza(zzcv.zza(zzgjVar.zzb()), zzaip.zza())).zzf());
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e5);
        }
    }
}
