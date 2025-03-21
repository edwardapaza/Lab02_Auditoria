package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzpp;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpr  reason: invalid package */
/* loaded from: classes.dex */
final class zzpr {
    private static final zzxr zza;
    private static final zzoa<zzpp, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzpi, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpu
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.AesCmacKey").zza(((zzrz) ((zzaja) zzrz.zzb().zza(zzpr.zzb(r1)).zza(r1.zzc()).zzf())).zzi()).zza(zzpr.zza(((zzpp) zzciVar).zze())).zzf()));
                return zzb3;
            }
        }, zzpp.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpt
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzpp zzb3;
                zzb3 = zzpr.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpw
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzry) ((zzaja) zzry.zzb().zza(zzpr.zzb((zzpp) r1.zzc())).zza(zzahm.zza(r1.zze().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzpr.zza(((zzpp) r1.zzc()).zze()), ((zzpi) zzbuVar).zza());
                return zza2;
            }
        }, zzpi.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpv
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzpi zzb3;
                zzb3 = zzpr.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzpp.zzb zza(zzvt zzvtVar) {
        int i5 = zzpy.zza[zzvtVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        return zzpp.zzb.zzd;
                    }
                    int zza2 = zzvtVar.zza();
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                }
                return zzpp.zzb.zzc;
            }
            return zzpp.zzb.zzb;
        }
        return zzpp.zzb.zza;
    }

    private static zzvt zza(zzpp.zzb zzbVar) {
        if (zzpp.zzb.zza.equals(zzbVar)) {
            return zzvt.TINK;
        }
        if (zzpp.zzb.zzb.equals(zzbVar)) {
            return zzvt.CRUNCHY;
        }
        if (zzpp.zzb.zzd.equals(zzbVar)) {
            return zzvt.RAW;
        }
        if (zzpp.zzb.zzc.equals(zzbVar)) {
            return zzvt.LEGACY;
        }
        String valueOf = String.valueOf(zzbVar);
        throw new GeneralSecurityException("Unable to serialize variant: " + valueOf);
    }

    public static void zza() {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzpi zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzry zza2 = zzry.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzpi.zzb().zza(zzpp.zzd().zza(zza2.zze().zzb()).zzb(zza2.zzd().zza()).zza(zza(zzotVar.zzc())).zza()).zza(zzxt.zza(zza2.zze().zzg(), zzct.zza(zzctVar))).zza(zzotVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzpp zzb(zzos zzosVar) {
        if (zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzrz zza2 = zzrz.zza(zzosVar.zza().zze(), zzaip.zza());
                return zzpp.zzd().zza(zza2.zza()).zzb(zza2.zzd().zza()).zza(zza(zzosVar.zza().zzd())).zza();
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e5);
            }
        }
        String zzf = zzosVar.zza().zzf();
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzf);
    }

    private static zzsc zzb(zzpp zzppVar) {
        return (zzsc) ((zzaja) zzsc.zzb().zza(zzppVar.zzb()).zzf());
    }
}
