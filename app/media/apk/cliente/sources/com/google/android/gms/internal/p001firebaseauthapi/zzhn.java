package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzhn {
    private static final zzic.zza zza = zzic.zza.zzb;
    private static final ThreadLocal<Cipher> zzb = new zzhm();
    private final SecretKey zzc;
    private final boolean zzd;

    public zzhn(byte[] bArr, boolean z4) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzxq.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        this.zzd = z4;
    }

    private static AlgorithmParameterSpec zza(byte[] bArr) {
        int length = bArr.length;
        Integer zzb2 = zzpg.zzb();
        return (zzb2 == null || zzb2.intValue() > 19) ? new GCMParameterSpec(128, bArr, 0, length) : new IvParameterSpec(bArr, 0, length);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr.length == 12) {
            boolean z4 = this.zzd;
            if (bArr2.length >= (z4 ? 28 : 16)) {
                if (!z4 || ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
                    AlgorithmParameterSpec zza2 = zza(bArr);
                    ThreadLocal<Cipher> threadLocal = zzb;
                    threadLocal.get().init(2, this.zzc, zza2);
                    if (bArr3 != null && bArr3.length != 0) {
                        threadLocal.get().updateAAD(bArr3);
                    }
                    boolean z5 = this.zzd;
                    return threadLocal.get().doFinal(bArr2, z5 ? 12 : 0, z5 ? bArr2.length - 12 : bArr2.length);
                }
                throw new GeneralSecurityException("iv does not match prepended iv");
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new GeneralSecurityException("iv is wrong size");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr.length == 12) {
            if (bArr2.length <= 2147483619) {
                boolean z4 = this.zzd;
                int length = bArr2.length;
                if (z4) {
                    length += 12;
                }
                byte[] bArr4 = new byte[length + 16];
                if (z4) {
                    System.arraycopy(bArr, 0, bArr4, 0, 12);
                }
                AlgorithmParameterSpec zza2 = zza(bArr);
                ThreadLocal<Cipher> threadLocal = zzb;
                threadLocal.get().init(1, this.zzc, zza2);
                if (bArr3 != null && bArr3.length != 0) {
                    threadLocal.get().updateAAD(bArr3);
                }
                int doFinal = threadLocal.get().doFinal(bArr2, 0, bArr2.length, bArr4, this.zzd ? 12 : 0);
                if (doFinal == bArr2.length + 16) {
                    return bArr4;
                }
                throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - bArr2.length)));
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new GeneralSecurityException("iv is wrong size");
    }
}
