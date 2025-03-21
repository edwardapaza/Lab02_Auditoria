package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzqm;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzrg {
    private static final zzxr zza;
    private static final zzmf<zzvt, zzqm.zzc> zzb;
    private static final zzmf<zzuc, zzqm.zzb> zzc;
    private static final zzoa<zzqm, zzos> zzd;
    private static final zznw<zzos> zze;
    private static final zzmx<zzqb, zzot> zzf;
    private static final zzmt<zzot> zzg;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        zzb = zzmf.zza().zza(zzvt.RAW, zzqm.zzc.zzd).zza(zzvt.TINK, zzqm.zzc.zza).zza(zzvt.LEGACY, zzqm.zzc.zzc).zza(zzvt.CRUNCHY, zzqm.zzc.zzb).zza();
        zzc = zzmf.zza().zza(zzuc.SHA1, zzqm.zzb.zza).zza(zzuc.SHA224, zzqm.zzb.zzb).zza(zzuc.SHA256, zzqm.zzb.zzc).zza(zzuc.SHA384, zzqm.zzb.zzd).zza(zzuc.SHA512, zzqm.zzb.zze).zza();
        zzd = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrf
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.HmacKey").zza(((zzuf) ((zzaja) zzuf.zzc().zza(zzrg.zzb(r1)).zza(r1.zzc()).zzf())).zzi()).zza(zzrg.zzb.zza((zzmf<zzvt, zzqm.zzc>) ((zzqm) zzciVar).zzf())).zzf()));
                return zzb3;
            }
        }, zzqm.class, zzos.class);
        zze = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzri
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzqm zzb3;
                zzb3 = zzrg.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzf = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrh
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzue) ((zzaja) zzue.zzb().zza(zzrg.zzb((zzqm) r1.zzc())).zza(zzahm.zza(r1.zze().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzrg.zzb.zza((zzmf<zzvt, zzqm.zzc>) ((zzqm) r1.zzc()).zzf()), ((zzqb) zzbuVar).zza());
                return zza2;
            }
        }, zzqb.class, zzot.class);
        zzg = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrk
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzqb zzb3;
                zzb3 = zzrg.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    public static void zza() {
        zznv zza2 = zznv.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqb zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzue zza2 = zzue.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzqb.zzb().zza(zzqm.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza(zzc.zza((zzmf<zzuc, zzqm.zzb>) zza2.zze().zzb())).zza(zzb.zza((zzmf<zzvt, zzqm.zzc>) zzotVar.zzc())).zza()).zza(zzxt.zza(zza2.zzf().zzg(), zzct.zza(zzctVar))).zza(zzotVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqm zzb(zzos zzosVar) {
        if (!zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            String zzf2 = zzosVar.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzf2);
        }
        try {
            zzuf zza2 = zzuf.zza(zzosVar.zza().zze(), zzaip.zza());
            if (zza2.zzb() == 0) {
                return zzqm.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza(zzc.zza((zzmf<zzuc, zzqm.zzb>) zza2.zzf().zzb())).zza(zzb.zza((zzmf<zzvt, zzqm.zzc>) zzosVar.zza().zzd())).zza();
            }
            int zzb2 = zza2.zzb();
            throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzb2);
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e5);
        }
    }

    private static zzui zzb(zzqm zzqmVar) {
        return (zzui) ((zzaja) zzui.zzc().zza(zzqmVar.zzb()).zza(zzc.zza((zzmf<zzuc, zzqm.zzb>) zzqmVar.zze())).zzf());
    }
}
