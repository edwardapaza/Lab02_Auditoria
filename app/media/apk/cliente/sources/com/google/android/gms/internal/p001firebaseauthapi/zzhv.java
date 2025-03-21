package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzhv {
    private static long zza(byte[] bArr, int i5) {
        return (((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16)) & 4294967295L;
    }

    private static long zza(byte[] bArr, int i5, int i6) {
        return (zza(bArr, i5) >> i6) & 67108863;
    }

    private static void zza(byte[] bArr, long j5, int i5) {
        int i6 = 0;
        while (i6 < 4) {
            bArr[i5 + i6] = (byte) (255 & j5);
            i6++;
            j5 >>= 8;
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long zza = zza(bArr, 0, 0) & 67108863;
            int i5 = 3;
            long zza2 = zza(bArr, 3, 2) & 67108611;
            long zza3 = zza(bArr, 6, 4) & 67092735;
            long zza4 = zza(bArr, 9, 6) & 66076671;
            long zza5 = zza(bArr, 12, 8) & 1048575;
            long j5 = zza2 * 5;
            long j6 = zza3 * 5;
            long j7 = zza4 * 5;
            long j8 = zza5 * 5;
            int i6 = 17;
            byte[] bArr3 = new byte[17];
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            long j13 = 0;
            int i7 = 0;
            while (i7 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i7);
                System.arraycopy(bArr2, i7, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i6, (byte) 0);
                }
                long zza6 = j13 + zza(bArr3, 0, 0);
                long zza7 = j9 + zza(bArr3, i5, 2);
                long zza8 = j10 + zza(bArr3, 6, 4);
                long zza9 = j11 + zza(bArr3, 9, 6);
                long zza10 = j12 + (zza(bArr3, 12, 8) | (bArr3[16] << 24));
                long j14 = (zza6 * zza) + (zza7 * j8) + (zza8 * j7) + (zza9 * j6) + (zza10 * j5);
                long j15 = (zza6 * zza2) + (zza7 * zza) + (zza8 * j8) + (zza9 * j7) + (zza10 * j6) + (j14 >> 26);
                long j16 = (zza6 * zza3) + (zza7 * zza2) + (zza8 * zza) + (zza9 * j8) + (zza10 * j7) + (j15 >> 26);
                long j17 = (zza6 * zza4) + (zza7 * zza3) + (zza8 * zza2) + (zza9 * zza) + (zza10 * j8) + (j16 >> 26);
                long j18 = (zza6 * zza5) + (zza7 * zza4) + (zza8 * zza3) + (zza9 * zza2) + (zza10 * zza) + (j17 >> 26);
                long j19 = (j14 & 67108863) + ((j18 >> 26) * 5);
                j9 = (j15 & 67108863) + (j19 >> 26);
                i7 += 16;
                j10 = j16 & 67108863;
                j11 = j17 & 67108863;
                j12 = j18 & 67108863;
                i6 = 17;
                i5 = 3;
                j13 = j19 & 67108863;
            }
            long j20 = j10 + (j9 >> 26);
            long j21 = j20 & 67108863;
            long j22 = j11 + (j20 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j12 + (j22 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j13 + ((j24 >> 26) * 5);
            long j27 = j26 & 67108863;
            long j28 = (j9 & 67108863) + (j26 >> 26);
            long j29 = j27 + 5;
            long j30 = j29 & 67108863;
            long j31 = (j29 >> 26) + j28;
            long j32 = j21 + (j31 >> 26);
            long j33 = j23 + (j32 >> 26);
            long j34 = (j25 + (j33 >> 26)) - 67108864;
            long j35 = j34 >> 63;
            long j36 = ~j35;
            long j37 = (j27 & j35) | (j30 & j36);
            long j38 = (j28 & j35) | (j31 & 67108863 & j36);
            long j39 = (j21 & j35) | (j32 & 67108863 & j36);
            long j40 = (j23 & j35) | (j33 & 67108863 & j36);
            long j41 = ((j34 & j36) | (j25 & j35)) << 8;
            long zza11 = (((j38 << 26) | j37) & 4294967295L) + zza(bArr, 16);
            long j42 = zza11 & 4294967295L;
            long zza12 = (((j38 >> 6) | (j39 << 20)) & 4294967295L) + zza(bArr, 20) + (zza11 >> 32);
            long zza13 = (((j39 >> 12) | (j40 << 14)) & 4294967295L) + zza(bArr, 24) + (zza12 >> 32);
            byte[] bArr4 = new byte[16];
            zza(bArr4, j42, 0);
            zza(bArr4, zza12 & 4294967295L, 4);
            zza(bArr4, zza13 & 4294967295L, 8);
            zza(bArr4, (((j41 | (j40 >> 18)) & 4294967295L) + zza(bArr, 28) + (zza13 >> 32)) & 4294967295L, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
