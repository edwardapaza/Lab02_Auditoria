package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
/* loaded from: classes.dex */
public final class zzlq {
    private static final byte[] zzn;
    private static final byte[] zzo;
    private static final byte[] zzp;
    public static final byte[] zza = zza(1, 0);
    private static final byte[] zzm = zza(1, 2);
    public static final byte[] zzb = zza(2, 32);
    public static final byte[] zzc = zza(2, 16);
    public static final byte[] zzd = zza(2, 17);
    public static final byte[] zze = zza(2, 18);
    public static final byte[] zzf = zza(2, 1);
    public static final byte[] zzg = zza(2, 2);
    public static final byte[] zzh = zza(2, 3);
    public static final byte[] zzi = zza(2, 1);
    public static final byte[] zzj = zza(2, 2);
    public static final byte[] zzk = zza(2, 3);
    public static final byte[] zzl = new byte[0];

    static {
        Charset charset = zzpg.zza;
        zzn = "KEM".getBytes(charset);
        zzo = "HPKE".getBytes(charset);
        zzp = "HPKE-v1".getBytes(charset);
    }

    public static int zza(zzum zzumVar) {
        int i5 = zzlp.zza[zzumVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        return 32;
                    }
                    throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
                }
                return 66;
            }
            return 48;
        }
        return 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzus zzusVar) {
        if (zzusVar.zzc() == zzum.KEM_UNKNOWN || zzusVar.zzc() == zzum.UNRECOGNIZED) {
            String name = zzusVar.zzc().name();
            throw new GeneralSecurityException("Invalid KEM param: " + name);
        } else if (zzusVar.zzb() == zzuk.KDF_UNKNOWN || zzusVar.zzb() == zzuk.UNRECOGNIZED) {
            String name2 = zzusVar.zzb().name();
            throw new GeneralSecurityException("Invalid KDF param: " + name2);
        } else if (zzusVar.zza() == zzuj.AEAD_UNKNOWN || zzusVar.zza() == zzuj.UNRECOGNIZED) {
            String name3 = zzusVar.zza().name();
            throw new GeneralSecurityException("Invalid AEAD param: " + name3);
        }
    }

    private static byte[] zza(int i5, int i6) {
        byte[] bArr = new byte[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            bArr[i7] = (byte) (i6 >> (((i5 - i7) - 1) * 8));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(String str, byte[] bArr, byte[] bArr2) {
        return zzwi.zza(zzp, bArr2, str.getBytes(zzpg.zza), bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i5) {
        return zzwi.zza(zza(2, i5), zzp, bArr2, str.getBytes(zzpg.zza), bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(byte[] bArr) {
        return zzwi.zza(zzn, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return zzwi.zza(zzo, bArr, bArr2, bArr3);
    }

    public static int zzb(zzum zzumVar) {
        int i5 = zzlp.zza[zzumVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        return 32;
                    }
                    throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
                }
                return 133;
            }
            return 97;
        }
        return 65;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzwq zzc(zzum zzumVar) {
        int i5 = zzlp.zza[zzumVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return zzwq.NIST_P521;
                }
                throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
            }
            return zzwq.NIST_P384;
        }
        return zzwq.NIST_P256;
    }
}
