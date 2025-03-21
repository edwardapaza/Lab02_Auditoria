package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwf  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwf implements zzbq {
    private static final zzic.zza zza = zzic.zza.zza;
    private static final Collection<Integer> zzb = Arrays.asList(64);
    private static final byte[] zzc = new byte[16];
    private static final byte[] zzd = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private final zzxj zze;
    private final byte[] zzf;
    private final byte[] zzg;

    private zzwf(byte[] bArr, zzxr zzxrVar) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (zzb.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.zze = new zzxj(copyOfRange);
            this.zzg = zzxrVar.zzb();
            return;
        }
        int length = bArr.length;
        throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
    }

    public static zzbq zza(zzij zzijVar) {
        return new zzwf(zzijVar.zze().zza(zzbr.zza()), zzijVar.zzd());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbq
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] zza2;
        int length = bArr.length;
        byte[] bArr3 = this.zzg;
        if (length >= bArr3.length + 16) {
            if (zzpg.zza(bArr3, bArr)) {
                Cipher zza3 = zzwr.zza.zza("AES/CTR/NoPadding");
                byte[] bArr4 = this.zzg;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr4.length + 16);
                byte[] bArr5 = (byte[]) copyOfRange.clone();
                bArr5[8] = (byte) (bArr5[8] & Byte.MAX_VALUE);
                bArr5[12] = (byte) (bArr5[12] & Byte.MAX_VALUE);
                zza3.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr5));
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzg.length + 16, bArr.length);
                byte[] doFinal = zza3.doFinal(copyOfRange2);
                if (copyOfRange2.length == 0 && doFinal == null && zzxn.zza()) {
                    doFinal = new byte[0];
                }
                byte[][] bArr6 = {bArr2, doFinal};
                byte[] zza4 = this.zze.zza(zzc, 16);
                for (int i5 = 0; i5 <= 0; i5++) {
                    byte[] bArr7 = bArr6[i5];
                    if (bArr7 == null) {
                        bArr7 = new byte[0];
                    }
                    zza4 = zzwi.zza(zzrb.zzb(zza4), this.zze.zza(bArr7, 16));
                }
                byte[] bArr8 = bArr6[1];
                if (bArr8.length < 16) {
                    zza2 = zzwi.zza(zzrb.zza(bArr8), zzrb.zzb(zza4));
                } else if (bArr8.length < zza4.length) {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                } else {
                    int length2 = bArr8.length - zza4.length;
                    zza2 = Arrays.copyOf(bArr8, bArr8.length);
                    for (int i6 = 0; i6 < zza4.length; i6++) {
                        int i7 = length2 + i6;
                        zza2[i7] = (byte) (zza2[i7] ^ zza4[i6]);
                    }
                }
                if (MessageDigest.isEqual(copyOfRange, this.zze.zza(zza2, 16))) {
                    return doFinal;
                }
                throw new AEADBadTagException("Integrity check failed.");
            }
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
