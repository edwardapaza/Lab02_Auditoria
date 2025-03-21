package com.google.android.gms.internal.p001firebaseauthapi;

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.ProviderException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzly  reason: invalid package */
/* loaded from: classes.dex */
public final class zzly implements zzbh {
    private static final String zza = "zzly";
    private final SecretKey zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzly(String str, KeyStore keyStore) {
        SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
        this.zzb = secretKey;
        if (secretKey != null) {
            return;
        }
        throw new InvalidKeyException("Keystore cannot load the key with ID: " + str);
    }

    private static void zza() {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) {
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, this.zzb, gCMParameterSpec);
        cipher.updateAAD(bArr2);
        return cipher.doFinal(bArr, 12, bArr.length - 12);
    }

    private final byte[] zzd(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[bArr.length + 12 + 16];
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, this.zzb);
            cipher.updateAAD(bArr2);
            cipher.doFinal(bArr, 0, bArr.length, bArr3, 12);
            System.arraycopy(cipher.getIV(), 0, bArr3, 0, 12);
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= 28) {
            try {
                return zzc(bArr, bArr2);
            } catch (ProviderException e5) {
                e = e5;
                Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
                zza();
                return zzc(bArr, bArr2);
            } catch (AEADBadTagException e6) {
                throw e6;
            } catch (GeneralSecurityException e7) {
                e = e7;
                Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
                zza();
                return zzc(bArr, bArr2);
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        try {
            return zzd(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e5) {
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e5);
            zza();
            return zzd(bArr, bArr2);
        }
    }
}
