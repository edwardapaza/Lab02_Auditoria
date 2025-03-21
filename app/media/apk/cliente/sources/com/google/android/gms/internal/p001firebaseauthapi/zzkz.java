package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkz  reason: invalid package */
/* loaded from: classes.dex */
public final class zzkz {
    private static final byte[] zza = new byte[0];
    private final zzla zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private zzkz(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzla zzlaVar) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzlaVar;
    }

    public static zzkz zza(byte[] bArr, zzli zzliVar, zzlg zzlgVar, zzld zzldVar, zzla zzlaVar, byte[] bArr2) {
        byte[] zza2 = zzlgVar.zza(bArr, zzliVar);
        byte[] bArr3 = zzlq.zza;
        byte[] zza3 = zzlq.zza(zzlgVar.zza(), zzldVar.zzb(), zzlaVar.zzc());
        byte[] bArr4 = zzlq.zzl;
        byte[] bArr5 = zza;
        byte[] zza4 = zzwi.zza(bArr3, zzldVar.zza(bArr4, bArr5, "psk_id_hash", zza3), zzldVar.zza(bArr4, bArr2, "info_hash", zza3));
        byte[] zza5 = zzldVar.zza(zza2, bArr5, "secret", zza3);
        byte[] zza6 = zzldVar.zza(zza5, zza4, "key", zza3, zzlaVar.zza());
        byte[] zza7 = zzldVar.zza(zza5, zza4, "base_nonce", zza3, zzlaVar.zzb());
        zzlaVar.zzb();
        BigInteger bigInteger = BigInteger.ONE;
        return new zzkz(bArr, zza6, zza7, bigInteger.shiftLeft(96).subtract(bigInteger), zzlaVar);
    }

    private final synchronized byte[] zza() {
        byte[] zza2;
        zza2 = zzwi.zza(this.zze, zzmb.zza(this.zzg, this.zzb.zzb()));
        if (this.zzg.compareTo(this.zzc) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.zzg = this.zzg.add(BigInteger.ONE);
        return zza2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        return this.zzb.zza(this.zzd, zza(), bArr, bArr2);
    }
}
