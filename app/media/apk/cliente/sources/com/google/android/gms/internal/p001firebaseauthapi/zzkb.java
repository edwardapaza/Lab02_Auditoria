package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzjx;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzkb {
    private static final zzxr zza;
    private static final zzxr zzb;
    private static final zzoa<zzjx, zzos> zzc;
    private static final zznw<zzos> zzd;
    private static final zzmx<zzkk, zzot> zze;
    private static final zzmt<zzot> zzf;
    private static final zzmx<zzkc, zzot> zzg;
    private static final zzmt<zzot> zzh;
    private static final zzmf<zzvt, zzjx.zzf> zzi;
    private static final zzmf<zzum, zzjx.zzd> zzj;
    private static final zzmf<zzuk, zzjx.zze> zzk;
    private static final zzmf<zzuj, zzjx.zza> zzl;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzb2;
        zzxr zzb3 = zzpg.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzb3;
        zzc = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzke
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb4;
                zzb4 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey").zza(((zzuo) ((zzaja) zzuo.zza().zza(zzkb.zzb(r1)).zzf())).zzi()).zza(zzkb.zzi.zza((zzmf<zzvt, zzjx.zzf>) ((zzjx) zzciVar).zzf())).zzf()));
                return zzb4;
            }
        }, zzjx.class, zzos.class);
        zzd = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkd
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzjx zzb4;
                zzb4 = zzkb.zzb((zzos) zzowVar);
                return zzb4;
            }
        }, zzb2, zzos.class);
        zze = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkg
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzkb.zza(r1).zzi(), zzux.zzb.ASYMMETRIC_PUBLIC, zzkb.zzi.zza((zzmf<zzvt, zzjx.zzf>) r1.zzb().zzf()), ((zzkk) zzbuVar).zza());
                return zza2;
            }
        }, zzkk.class, zzot.class);
        zzf = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkf
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzkk zzd2;
                zzd2 = zzkb.zzd((zzot) zzowVar, zzctVar);
                return zzd2;
            }
        }, zzb3, zzot.class);
        zzg = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzki
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", ((zzut) ((zzaja) zzut.zzb().zza(0).zza(zzkb.zza((zzkk) r1.zzc())).zza(zzahm.zza(r1.zzd().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.ASYMMETRIC_PRIVATE, zzkb.zzi.zza((zzmf<zzvt, zzjx.zzf>) r1.zzb().zzf()), ((zzkc) zzbuVar).zza());
                return zza2;
            }
        }, zzkc.class, zzot.class);
        zzh = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkh
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzkc zzc2;
                zzc2 = zzkb.zzc((zzot) zzowVar, zzctVar);
                return zzc2;
            }
        }, zzb2, zzot.class);
        zzmi zza2 = zzmf.zza().zza(zzvt.RAW, zzjx.zzf.zzc).zza(zzvt.TINK, zzjx.zzf.zza);
        zzvt zzvtVar = zzvt.LEGACY;
        zzjx.zzf zzfVar = zzjx.zzf.zzb;
        zzi = zza2.zza(zzvtVar, zzfVar).zza(zzvt.CRUNCHY, zzfVar).zza();
        zzj = zzmf.zza().zza(zzum.DHKEM_P256_HKDF_SHA256, zzjx.zzd.zza).zza(zzum.DHKEM_P384_HKDF_SHA384, zzjx.zzd.zzb).zza(zzum.DHKEM_P521_HKDF_SHA512, zzjx.zzd.zzc).zza(zzum.DHKEM_X25519_HKDF_SHA256, zzjx.zzd.zzd).zza();
        zzk = zzmf.zza().zza(zzuk.HKDF_SHA256, zzjx.zze.zza).zza(zzuk.HKDF_SHA384, zzjx.zze.zzb).zza(zzuk.HKDF_SHA512, zzjx.zze.zzc).zza();
        zzl = zzmf.zza().zza(zzuj.AES_128_GCM, zzjx.zza.zza).zza(zzuj.AES_256_GCM, zzjx.zza.zzb).zza(zzuj.CHACHA20_POLY1305, zzjx.zza.zzc).zza();
    }

    private static zzjx zza(zzvt zzvtVar, zzus zzusVar) {
        return zzjx.zzc().zza(zzi.zza((zzmf<zzvt, zzjx.zzf>) zzvtVar)).zza(zzj.zza((zzmf<zzum, zzjx.zzd>) zzusVar.zzc())).zza(zzk.zza((zzmf<zzuk, zzjx.zze>) zzusVar.zzb())).zza(zzl.zza((zzmf<zzuj, zzjx.zza>) zzusVar.zza())).zza();
    }

    private static zzuw zza(zzkk zzkkVar) {
        return (zzuw) ((zzaja) zzuw.zzc().zza(0).zza(zzb(zzkkVar.zzb())).zza(zzahm.zza(zzkkVar.zzc().zzb())).zzf());
    }

    private static zzxr zza(zzum zzumVar, byte[] bArr) {
        return zzxr.zza(zzmb.zza(zzmb.zza(bArr), zzlq.zzb(zzumVar)));
    }

    public static void zza() {
        zznv zza2 = zznv.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjx zzb(zzos zzosVar) {
        if (zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                return zza(zzosVar.zza().zzd(), zzuo.zza(zzosVar.zza().zze(), zzaip.zza()).zzc());
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e5);
            }
        }
        String zzf2 = zzosVar.zza().zzf();
        throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzf2);
    }

    private static zzus zzb(zzjx zzjxVar) {
        return (zzus) ((zzaja) zzus.zzd().zza(zzj.zza((zzmf<zzum, zzjx.zzd>) zzjxVar.zze())).zza(zzk.zza((zzmf<zzuk, zzjx.zze>) zzjxVar.zzd())).zza(zzl.zza((zzmf<zzuj, zzjx.zza>) zzjxVar.zzb())).zzf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkc zzc(zzot zzotVar, zzct zzctVar) {
        if (!zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            String zzf2 = zzotVar.zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzf2);
        }
        try {
            zzut zza2 = zzut.zza(zzotVar.zzd(), zzaip.zza());
            if (zza2.zza() == 0) {
                zzuw zzd2 = zza2.zzd();
                return zzkc.zza(zzkk.zza(zza(zzotVar.zzc(), zzd2.zzb()), zza(zzd2.zzb().zzc(), zzd2.zzf().zzg()), zzotVar.zze()), zzxt.zza(zzmb.zza(zzmb.zza(zza2.zze().zzg()), zzlq.zza(zzd2.zzb().zzc())), zzct.zza(zzctVar)));
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzajj unused) {
            throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkk zzd(zzot zzotVar, zzct zzctVar) {
        if (!zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            String zzf2 = zzotVar.zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzf2);
        }
        try {
            zzuw zza2 = zzuw.zza(zzotVar.zzd(), zzaip.zza());
            if (zza2.zza() == 0) {
                return zzkk.zza(zza(zzotVar.zzc(), zza2.zzb()), zza(zza2.zzb().zzc(), zza2.zzf().zzg()), zzotVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzajj unused) {
            throw new GeneralSecurityException("Parsing HpkePublicKey failed");
        }
    }
}
