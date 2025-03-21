package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
/* loaded from: classes.dex */
final class zzkl implements zzbp {
    private final zzch<zzbp> zza;
    private final zzrp zzb;

    public zzkl(zzch<zzbp> zzchVar) {
        this.zza = zzchVar;
        this.zzb = zzchVar.zzf() ? zzno.zza().zzb().zza(zzng.zza(zzchVar), "hybrid_decrypt", "decrypt") : zzng.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbp
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (zzcm<zzbp> zzcmVar : this.zza.zza(copyOfRange)) {
                try {
                    byte[] zza = zzcmVar.zzf().zza(copyOfRange2, bArr2);
                    this.zzb.zza(zzcmVar.zza(), copyOfRange2.length);
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcm<zzbp> zzcmVar2 : this.zza.zze()) {
            try {
                byte[] zza2 = zzcmVar2.zzf().zza(bArr, bArr2);
                this.zzb.zza(zzcmVar2.zza(), bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
