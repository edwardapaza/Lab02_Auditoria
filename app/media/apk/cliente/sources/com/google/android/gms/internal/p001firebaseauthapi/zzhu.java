package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzhd;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhu  reason: invalid package */
/* loaded from: classes.dex */
public final class zzhu {
    private static final zzxr zza;
    private static final zzoa<zzhd, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzha, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhx
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key").zza(zzvz.zzc().zzi()).zza(zzhu.zza(((zzhd) zzciVar).zzb())).zzf()));
                return zzb3;
            }
        }, zzhd.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhw
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzhd zzb3;
                zzb3 = zzhu.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhz
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzvw) ((zzaja) zzvw.zzb().zza(zzahm.zza(r1.zzd().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzhu.zza(r1.zzb().zzb()), ((zzha) zzbuVar).zza());
                return zza2;
            }
        }, zzha.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhy
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzha zzb3;
                zzb3 = zzhu.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzhd.zza zza(zzvt zzvtVar) {
        int i5 = zzib.zza[zzvtVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return zzhd.zza.zzb;
            }
            if (i5 == 4) {
                return zzhd.zza.zzc;
            }
            int zza2 = zzvtVar.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
        }
        return zzhd.zza.zza;
    }

    private static zzvt zza(zzhd.zza zzaVar) {
        if (zzhd.zza.zza.equals(zzaVar)) {
            return zzvt.TINK;
        }
        if (zzhd.zza.zzb.equals(zzaVar)) {
            return zzvt.CRUNCHY;
        }
        if (zzhd.zza.zzc.equals(zzaVar)) {
            return zzvt.RAW;
        }
        String valueOf = String.valueOf(zzaVar);
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
    public static zzha zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzvw zza2 = zzvw.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzha.zza(zza(zzotVar.zzc()), zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzctVar)), zzotVar.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzhd zzb(zzos zzosVar) {
        if (!zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            String zzf = zzosVar.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzf);
        }
        try {
            if (zzvz.zza(zzosVar.zza().zze(), zzaip.zza()).zza() == 0) {
                return zzhd.zza(zza(zzosVar.zza().zzd()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e5);
        }
    }
}
