package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwa  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwa implements zzxk {
    private static final zzic.zza zza = zzic.zza.zzb;
    private static final ThreadLocal<Cipher> zzb = new zzwc();
    private final SecretKeySpec zzc;
    private final int zzd;
    private final int zze;

    public zzwa(byte[] bArr, int i5) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzxq.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        int blockSize = zzb.get().getBlockSize();
        this.zze = blockSize;
        if (i5 < 12 || i5 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzd = i5;
    }

    private final void zza(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, byte[] bArr3, boolean z4) {
        Cipher cipher = zzb.get();
        byte[] bArr4 = new byte[this.zze];
        System.arraycopy(bArr3, 0, bArr4, 0, this.zzd);
        cipher.init(z4 ? 1 : 2, this.zzc, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i5, i6, bArr2, i7) != i6) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzxk
    public final byte[] zza(byte[] bArr) {
        int length = bArr.length;
        int i5 = this.zzd;
        if (length >= i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, 0, bArr2, 0, i5);
            int length2 = bArr.length;
            int i6 = this.zzd;
            byte[] bArr3 = new byte[length2 - i6];
            zza(bArr, i6, bArr.length - i6, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzxk
    public final byte[] zzb(byte[] bArr) {
        int length = bArr.length;
        int i5 = this.zzd;
        if (length > a.e.API_PRIORITY_OTHER - i5) {
            int i6 = a.e.API_PRIORITY_OTHER - this.zzd;
            throw new GeneralSecurityException("plaintext length can not exceed " + i6);
        }
        byte[] bArr2 = new byte[bArr.length + i5];
        byte[] zza2 = zzov.zza(i5);
        System.arraycopy(zza2, 0, bArr2, 0, this.zzd);
        zza(bArr, 0, bArr.length, bArr2, this.zzd, zza2, true);
        return bArr2;
    }
}
