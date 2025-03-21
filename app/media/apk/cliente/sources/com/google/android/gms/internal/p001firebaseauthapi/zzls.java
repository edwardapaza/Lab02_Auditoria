package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzls  reason: invalid package */
/* loaded from: classes.dex */
public final class zzls implements zzlg {
    private final zzwq zza;
    private final zzkx zzb;

    private zzls(zzkx zzkxVar, zzwq zzwqVar) {
        this.zzb = zzkxVar;
        this.zza = zzwqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzls zza(zzwq zzwqVar) {
        int i5 = zzlr.zza[zzwqVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return new zzls(new zzkx("HmacSha512"), zzwq.NIST_P521);
                }
                String valueOf = String.valueOf(zzwqVar);
                throw new GeneralSecurityException("invalid curve type: " + valueOf);
            }
            return new zzls(new zzkx("HmacSha384"), zzwq.NIST_P384);
        }
        return new zzls(new zzkx("HmacSha256"), zzwq.NIST_P256);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzlg
    public final byte[] zza() {
        int i5 = zzlr.zza[this.zza.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return zzlq.zze;
                }
                throw new GeneralSecurityException("Could not determine HPKE KEM ID");
            }
            return zzlq.zzd;
        }
        return zzlq.zzc;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzlg
    public final byte[] zza(byte[] bArr, zzli zzliVar) {
        byte[] zza = zzwn.zza(zzwn.zza(this.zza, zzliVar.zza().zzb()), zzwn.zza(this.zza, zzwp.UNCOMPRESSED, bArr));
        byte[] zza2 = zzwi.zza(bArr, zzliVar.zzb().zzb());
        byte[] zza3 = zzlq.zza(zza());
        zzkx zzkxVar = this.zzb;
        return zzkxVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzkxVar.zza());
    }
}
