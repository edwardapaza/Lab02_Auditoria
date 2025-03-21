package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziw  reason: invalid package */
/* loaded from: classes.dex */
final class zziw implements zzbq {
    private final zzch<zzbq> zza;
    private final zzrp zzb;
    private final zzrp zzc;

    public zziw(zzch<zzbq> zzchVar) {
        zzrp zzrpVar;
        this.zza = zzchVar;
        if (zzchVar.zzf()) {
            zzrq zzb = zzno.zza().zzb();
            zzrs zza = zzng.zza(zzchVar);
            this.zzb = zzb.zza(zza, "daead", "encrypt");
            zzrpVar = zzb.zza(zza, "daead", "decrypt");
        } else {
            zzrpVar = zzng.zza;
            this.zzb = zzrpVar;
        }
        this.zzc = zzrpVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbq
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (zzcm<zzbq> zzcmVar : this.zza.zza(copyOf)) {
                try {
                    byte[] zza = zzcmVar.zzf().zza(copyOfRange, bArr2);
                    this.zzc.zza(zzcmVar.zza(), copyOfRange.length);
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcm<zzbq> zzcmVar2 : this.zza.zze()) {
            try {
                byte[] zza2 = zzcmVar2.zzf().zza(bArr, bArr2);
                this.zzc.zza(zzcmVar2.zza(), bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
