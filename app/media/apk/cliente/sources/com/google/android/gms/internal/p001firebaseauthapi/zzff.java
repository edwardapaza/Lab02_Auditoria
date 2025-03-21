package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzfa;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzff  reason: invalid package */
/* loaded from: classes.dex */
public final class zzff {
    private static final zzxr zza;
    private static final zzoa<zzfa, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzet, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfe
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey").zza(((zzta) ((zzaja) zzta.zzc().zza(r1.zzb()).zzf())).zzi()).zza(zzff.zza(((zzfa) zzciVar).zzd())).zzf()));
                return zzb3;
            }
        }, zzfa.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfh
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzfa zzb3;
                zzb3 = zzff.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfg
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzsx) ((zzaja) zzsx.zzb().zza(zzahm.zza(r1.zze().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzff.zza(r1.zzc().zzd()), ((zzet) zzbuVar).zza());
                return zza2;
            }
        }, zzet.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfj
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzet zzb3;
                zzb3 = zzff.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzfa.zzb zza(zzvt zzvtVar) {
        int i5 = zzfi.zza[zzvtVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return zzfa.zzb.zzb;
            }
            if (i5 == 4) {
                return zzfa.zzb.zzc;
            }
            int zza2 = zzvtVar.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
        }
        return zzfa.zzb.zza;
    }

    private static zzvt zza(zzfa.zzb zzbVar) {
        if (zzfa.zzb.zza.equals(zzbVar)) {
            return zzvt.TINK;
        }
        if (zzfa.zzb.zzb.equals(zzbVar)) {
            return zzvt.CRUNCHY;
        }
        if (zzfa.zzb.zzc.equals(zzbVar)) {
            return zzvt.RAW;
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
    public static zzet zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzsx zza2 = zzsx.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzet.zzb().zza(zzfa.zzc().zza(zza2.zzd().zzb()).zza(zza(zzotVar.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzctVar))).zza(zzotVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfa zzb(zzos zzosVar) {
        if (!zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            String zzf = zzosVar.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + zzf);
        }
        try {
            zzta zza2 = zzta.zza(zzosVar.zza().zze(), zzaip.zza());
            if (zza2.zzb() == 0) {
                return zzfa.zzc().zza(zza2.zza()).zza(zza(zzosVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e5);
        }
    }
}
