package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwb implements zzbh {
    private static final zzic.zza zza = zzic.zza.zza;
    private static final ThreadLocal<Cipher> zzb = new zzwe();
    private static final ThreadLocal<Cipher> zzc = new zzwd();
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private final SecretKeySpec zzg;
    private final int zzh;

    private zzwb(byte[] bArr, int i5, byte[] bArr2) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i5 != 12 && i5 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzh = i5;
        zzxq.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzg = secretKeySpec;
        Cipher cipher = zzb.get();
        cipher.init(1, secretKeySpec);
        byte[] zza2 = zza(cipher.doFinal(new byte[16]));
        this.zzd = zza2;
        this.zze = zza(zza2);
        this.zzf = bArr2;
    }

    public static zzbh zza(zzdv zzdvVar) {
        if (zza.zza()) {
            if (zzdvVar.zzc().zzd() == 16) {
                return new zzwb(zzdvVar.zze().zza(zzbr.zza()), zzdvVar.zzc().zzb(), zzdvVar.zzd().zzb());
            }
            int zzd = zzdvVar.zzc().zzd();
            throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + zzd);
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    private final byte[] zza(Cipher cipher, int i5, byte[] bArr, int i6, int i7) {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i5;
        if (i7 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzd));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i8 = 0;
        while (i7 - i8 > 16) {
            for (int i9 = 0; i9 < 16; i9++) {
                doFinal[i9] = (byte) (doFinal[i9] ^ bArr[(i6 + i8) + i9]);
            }
            doFinal = cipher.doFinal(doFinal);
            i8 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i8 + i6, i6 + i7);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzd);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zze, 16);
            for (int i10 = 0; i10 < copyOfRange.length; i10++) {
                copyOf[i10] = (byte) (copyOf[i10] ^ copyOfRange[i10]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private static byte[] zza(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i5 = 0;
        while (i5 < 15) {
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((bArr[i5] << 1) ^ ((bArr[i6] & 255) >>> 7));
            i5 = i6;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) {
        int length = (bArr.length - this.zzh) - 16;
        if (length >= 0) {
            Cipher cipher = zzb.get();
            cipher.init(1, this.zzg);
            byte[] zza2 = zza(cipher, 0, bArr, 0, this.zzh);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] zza3 = zza(cipher, 1, bArr3, 0, bArr3.length);
            byte[] zza4 = zza(cipher, 2, bArr, this.zzh, length);
            int length2 = bArr.length - 16;
            byte b5 = 0;
            for (int i5 = 0; i5 < 16; i5++) {
                b5 = (byte) (b5 | (((bArr[length2 + i5] ^ zza3[i5]) ^ zza2[i5]) ^ zza4[i5]));
            }
            if (b5 == 0) {
                Cipher cipher2 = zzc.get();
                cipher2.init(1, this.zzg, new IvParameterSpec(zza2));
                return cipher2.doFinal(bArr, this.zzh, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr3[i5] = (byte) (bArr[i5] ^ bArr2[i5]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.zzf;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzf.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i5 = this.zzh;
        if (length <= (a.e.API_PRIORITY_OTHER - i5) - 16) {
            byte[] bArr3 = new byte[bArr.length + i5 + 16];
            byte[] zza2 = zzov.zza(i5);
            System.arraycopy(zza2, 0, bArr3, 0, this.zzh);
            Cipher cipher = zzb.get();
            cipher.init(1, this.zzg);
            byte[] zza3 = zza(cipher, 0, zza2, 0, zza2.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza4 = zza(cipher, 1, bArr4, 0, bArr4.length);
            Cipher cipher2 = zzc.get();
            cipher2.init(1, this.zzg, new IvParameterSpec(zza3));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzh);
            byte[] zza5 = zza(cipher, 2, bArr3, this.zzh, bArr.length);
            int length2 = bArr.length + this.zzh;
            for (int i6 = 0; i6 < 16; i6++) {
                bArr3[length2 + i6] = (byte) ((zza4[i6] ^ zza3[i6]) ^ zza5[i6]);
            }
            byte[] bArr5 = this.zzf;
            return bArr5.length == 0 ? bArr3 : zzwi.zza(bArr5, bArr3);
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
