package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzfo;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfq  reason: invalid package */
/* loaded from: classes.dex */
public final class zzfq {
    private static final zzxr zza;
    private static final zzoa<zzfo, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzfl, zzot> zzd;
    private static final zzmt<zzot> zze;

    static {
        zzxr zzb2 = zzpg.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfp
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zza(zzti.zzb().zzi()).zza(zzfq.zza(((zzfo) zzciVar).zzb())).zzf()));
                return zzb3;
            }
        }, zzfo.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfs
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zzfo zzb3;
                zzb3 = zzfq.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfr
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zztf) ((zzaja) zztf.zzb().zza(zzahm.zza(r1.zzd().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzfq.zza(r1.zzb().zzb()), ((zzfl) zzbuVar).zza());
                return zza2;
            }
        }, zzfl.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfu
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzfl zzb3;
                zzb3 = zzfq.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
    }

    private static zzfo.zza zza(zzvt zzvtVar) {
        int i5 = zzft.zza[zzvtVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return zzfo.zza.zzb;
            }
            if (i5 == 4) {
                return zzfo.zza.zzc;
            }
            int zza2 = zzvtVar.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
        }
        return zzfo.zza.zza;
    }

    private static zzvt zza(zzfo.zza zzaVar) {
        if (zzfo.zza.zza.equals(zzaVar)) {
            return zzvt.TINK;
        }
        if (zzfo.zza.zzb.equals(zzaVar)) {
            return zzvt.CRUNCHY;
        }
        if (zzfo.zza.zzc.equals(zzaVar)) {
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
    public static zzfl zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zztf zza2 = zztf.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzfl.zza(zza(zzotVar.zzc()), zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzctVar)), zzotVar.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfo zzb(zzos zzosVar) {
        if (zzosVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzti.zza(zzosVar.zza().zze(), zzaip.zza());
                return zzfo.zza(zza(zzosVar.zza().zzd()));
            } catch (zzajj e5) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e5);
            }
        }
        String zzf = zzosVar.zza().zzf();
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzf);
    }
}
