package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzer;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhf  reason: invalid package */
/* loaded from: classes.dex */
public final class zzhf {
    private static final zzxr zza;
    private static final zzoa<zzer, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzek, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb(zzcx.zzb);
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhh
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                return zzhf.zza((zzer) zzciVar);
            }
        }, zzer.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhg
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzer zzb3;
                zzb3 = zzhf.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhj
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                return zzhf.zza((zzek) zzbuVar, zzctVar);
            }
        }, zzek.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhi
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzek zzb3;
                zzb3 = zzhf.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzer.zzb zza(zzvt zzvtVar) {
        int i5 = zzhl.zza[zzvtVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return zzer.zzb.zzb;
            }
            if (i5 == 4) {
                return zzer.zzb.zzc;
            }
            int zza2 = zzvtVar.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
        }
        return zzer.zzb.zza;
    }

    public static /* synthetic */ zzos zza(zzer zzerVar) {
        zzb(zzerVar);
        return zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza(zzcx.zzb).zza(((zzsw) ((zzaja) zzsw.zzc().zza(zzerVar.zzc()).zzf())).zzi()).zza(zza(zzerVar.zzf())).zzf()));
    }

    public static /* synthetic */ zzot zza(zzek zzekVar, zzct zzctVar) {
        zzb(zzekVar.zzc());
        return zzot.zza(zzcx.zzb, ((zzst) ((zzaja) zzst.zzb().zza(zzahm.zza(zzekVar.zze().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zza(zzekVar.zzc().zzf()), zzekVar.zza());
    }

    private static zzvt zza(zzer.zzb zzbVar) {
        if (zzer.zzb.zza.equals(zzbVar)) {
            return zzvt.TINK;
        }
        if (zzer.zzb.zzb.equals(zzbVar)) {
            return zzvt.CRUNCHY;
        }
        if (zzer.zzb.zzc.equals(zzbVar)) {
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
    public static zzek zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals(zzcx.zzb)) {
            try {
                zzst zza2 = zzst.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzek.zzb().zza(zzer.zze().zzb(zza2.zzd().zzb()).zza(12).zzc(16).zza(zza(zzotVar.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzctVar))).zza(zzotVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzer zzb(zzos zzosVar) {
        if (!zzosVar.zza().zzf().equals(zzcx.zzb)) {
            String zzf = zzosVar.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzf);
        }
        try {
            zzsw zza2 = zzsw.zza(zzosVar.zza().zze(), zzaip.zza());
            if (zza2.zzb() == 0) {
                return zzer.zze().zzb(zza2.zza()).zza(12).zzc(16).zza(zza(zzosVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e5);
        }
    }

    private static void zzb(zzer zzerVar) {
        if (zzerVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", Integer.valueOf(zzerVar.zzd())));
        }
        if (zzerVar.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", Integer.valueOf(zzerVar.zzb())));
        }
    }
}
