package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgd  reason: invalid package */
/* loaded from: classes.dex */
public final class zzgd {
    private static final zzxr zza;
    private static final zzoa<zzge, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzgb, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgg
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.KmsAeadKey").zza(((zzvm) ((zzaja) zzvm.zza().zza(((zzge) zzciVar).zzb()).zzf())).zzi()).zza(zzvt.RAW).zzf()));
                return zzb3;
            }
        }, zzge.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgf
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzge zzb3;
                zzb3 = zzgd.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgi
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzvl) ((zzaja) zzvl.zzb().zza((zzvm) ((zzaja) zzvm.zza().zza(((zzgb) zzbuVar).zzb().zzb()).zzf())).zzf())).zzi(), zzux.zzb.REMOTE, zzvt.RAW, null);
                return zza2;
            }
        }, zzgb.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgh
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzgb zzb3;
                zzb3 = zzgd.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    public static void zza() {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgb zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            if (zzotVar.zzc() != zzvt.RAW) {
                String valueOf = String.valueOf(zzotVar.zzc());
                throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got " + valueOf);
            }
            try {
                zzvl zza2 = zzvl.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzgb.zza(zzge.zza(zza2.zzd().zzd()));
                }
                String valueOf2 = String.valueOf(zza2);
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + valueOf2);
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e5);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzge zzb(zzos zzosVar) {
        if (!zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            String zzf = zzosVar.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + zzf);
        }
        try {
            zzvm zza2 = zzvm.zza(zzosVar.zza().zze(), zzaip.zza());
            if (zzosVar.zza().zzd() == zzvt.RAW) {
                return zzge.zza(zza2.zzd());
            }
            String valueOf = String.valueOf(zzosVar.zza().zzd());
            String valueOf2 = String.valueOf(zza2);
            throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + valueOf + " with format " + valueOf2);
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e5);
        }
    }
}
