package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzea;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzef  reason: invalid package */
/* loaded from: classes.dex */
public final class zzef {
    private static final zzxr zza;
    private static final zzoa<zzea, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzdv, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzee
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.AesEaxKey").zza(((zzsp) ((zzaja) zzsp.zzb().zza(zzef.zzb(r1)).zza(r1.zzc()).zzf())).zzi()).zza(zzef.zza(((zzea) zzciVar).zzf())).zzf()));
                return zzb3;
            }
        }, zzea.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeh
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzea zzb3;
                zzb3 = zzef.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeg
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzso) ((zzaja) zzso.zzb().zza(zzef.zzb(r1.zzc())).zza(zzahm.zza(r1.zze().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzef.zza(r1.zzc().zzf()), ((zzdv) zzbuVar).zza());
                return zza2;
            }
        }, zzdv.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzej
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzdv zzb3;
                zzb3 = zzef.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzea.zzb zza(zzvt zzvtVar) {
        int i5 = zzei.zza[zzvtVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return zzea.zzb.zzb;
            }
            if (i5 == 4) {
                return zzea.zzb.zzc;
            }
            int zza2 = zzvtVar.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
        }
        return zzea.zzb.zza;
    }

    private static zzvt zza(zzea.zzb zzbVar) {
        if (zzea.zzb.zza.equals(zzbVar)) {
            return zzvt.TINK;
        }
        if (zzea.zzb.zzb.equals(zzbVar)) {
            return zzvt.CRUNCHY;
        }
        if (zzea.zzb.zzc.equals(zzbVar)) {
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
    public static zzdv zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzso zza2 = zzso.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzdv.zzb().zza(zzea.zze().zzb(zza2.zze().zzb()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzotVar.zzc())).zza()).zza(zzxt.zza(zza2.zze().zzg(), zzct.zza(zzctVar))).zza(zzotVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzea zzb(zzos zzosVar) {
        if (zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzsp zza2 = zzsp.zza(zzosVar.zza().zze(), zzaip.zza());
                return zzea.zze().zzb(zza2.zza()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzosVar.zza().zzd())).zza();
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e5);
            }
        }
        String zzf = zzosVar.zza().zzf();
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzf);
    }

    private static zzss zzb(zzea zzeaVar) {
        if (zzeaVar.zzd() == 16) {
            return (zzss) ((zzaja) zzss.zzb().zza(zzeaVar.zzb()).zzf());
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(zzeaVar.zzd())));
    }
}
