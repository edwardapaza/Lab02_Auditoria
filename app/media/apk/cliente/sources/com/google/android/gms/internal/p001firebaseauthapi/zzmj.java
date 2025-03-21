package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzmj {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr) {
        jArr[10] = 0;
        int i5 = 0;
        while (i5 < 10) {
            long j5 = jArr[i5];
            long j6 = j5 / 67108864;
            jArr[i5] = j5 - (j6 << 26);
            int i6 = i5 + 1;
            long j7 = jArr[i6] + j6;
            jArr[i6] = j7;
            long j8 = j7 / 33554432;
            jArr[i6] = j7 - (j8 << 25);
            i5 += 2;
            jArr[i5] = jArr[i5] + j8;
        }
        long j9 = jArr[0];
        long j10 = jArr[10];
        long j11 = j9 + (j10 << 4);
        jArr[0] = j11;
        long j12 = j11 + (j10 << 1);
        jArr[0] = j12;
        long j13 = j12 + j10;
        jArr[0] = j13;
        jArr[10] = 0;
        long j14 = j13 / 67108864;
        jArr[0] = j13 - (j14 << 26);
        jArr[1] = jArr[1] + j14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        zzb(jArr3, jArr2);
        zzb(jArr12, jArr3);
        zzb(jArr11, jArr12);
        zza(jArr4, jArr11, jArr2);
        zza(jArr5, jArr4, jArr3);
        zzb(jArr11, jArr5);
        zza(jArr6, jArr11, jArr4);
        zzb(jArr11, jArr6);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zza(jArr7, jArr11, jArr6);
        zzb(jArr11, jArr7);
        zzb(jArr12, jArr11);
        for (int i5 = 2; i5 < 10; i5 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr8, jArr12, jArr7);
        zzb(jArr11, jArr8);
        zzb(jArr12, jArr11);
        for (int i6 = 2; i6 < 20; i6 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr8);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        for (int i7 = 2; i7 < 10; i7 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr9, jArr11, jArr7);
        zzb(jArr11, jArr9);
        zzb(jArr12, jArr11);
        for (int i8 = 2; i8 < 50; i8 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr10, jArr12, jArr9);
        zzb(jArr12, jArr10);
        zzb(jArr11, jArr12);
        for (int i9 = 2; i9 < 100; i9 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr12, jArr11, jArr10);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        for (int i10 = 2; i10 < 50; i10 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr9);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zza(jArr, jArr12, jArr5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2, long j5) {
        for (int i5 = 0; i5 < 10; i5++) {
            jArr[i5] = jArr2[i5] * j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zze(jArr4, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] zza(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i5 = 0; i5 < 10; i5++) {
            int i6 = zza[i5];
            jArr[i5] = (((((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8)) | ((bArr[i6 + 2] & 255) << 16)) | ((bArr[i6 + 3] & 255) << 24)) >> zzb[i5]) & zzc[i5 & 1];
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr) {
        long j5 = jArr[8];
        long j6 = jArr[18];
        long j7 = j5 + (j6 << 4);
        jArr[8] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[8] = j8;
        jArr[8] = j8 + j6;
        long j9 = jArr[7];
        long j10 = jArr[17];
        long j11 = j9 + (j10 << 4);
        jArr[7] = j11;
        long j12 = j11 + (j10 << 1);
        jArr[7] = j12;
        jArr[7] = j12 + j10;
        long j13 = jArr[6];
        long j14 = jArr[16];
        long j15 = j13 + (j14 << 4);
        jArr[6] = j15;
        long j16 = j15 + (j14 << 1);
        jArr[6] = j16;
        jArr[6] = j16 + j14;
        long j17 = jArr[5];
        long j18 = jArr[15];
        long j19 = j17 + (j18 << 4);
        jArr[5] = j19;
        long j20 = j19 + (j18 << 1);
        jArr[5] = j20;
        jArr[5] = j20 + j18;
        long j21 = jArr[4];
        long j22 = jArr[14];
        long j23 = j21 + (j22 << 4);
        jArr[4] = j23;
        long j24 = j23 + (j22 << 1);
        jArr[4] = j24;
        jArr[4] = j24 + j22;
        long j25 = jArr[3];
        long j26 = jArr[13];
        long j27 = j25 + (j26 << 4);
        jArr[3] = j27;
        long j28 = j27 + (j26 << 1);
        jArr[3] = j28;
        jArr[3] = j28 + j26;
        long j29 = jArr[2];
        long j30 = jArr[12];
        long j31 = j29 + (j30 << 4);
        jArr[2] = j31;
        long j32 = j31 + (j30 << 1);
        jArr[2] = j32;
        jArr[2] = j32 + j30;
        long j33 = jArr[1];
        long j34 = jArr[11];
        long j35 = j33 + (j34 << 4);
        jArr[1] = j35;
        long j36 = j35 + (j34 << 1);
        jArr[1] = j36;
        jArr[1] = j36 + j34;
        long j37 = jArr[0];
        long j38 = jArr[10];
        long j39 = j37 + (j38 << 4);
        jArr[0] = j39;
        long j40 = j39 + (j38 << 1);
        jArr[0] = j40;
        jArr[0] = j40 + j38;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr, long[] jArr2) {
        long j5 = jArr2[0];
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = jArr2[2];
        long j9 = jArr2[3];
        long j10 = jArr2[4];
        long j11 = jArr2[5];
        long j12 = jArr2[6];
        long j13 = (j8 * j12) + (jArr2[8] * j6);
        long j14 = jArr2[7];
        long j15 = jArr2[8];
        long j16 = jArr2[9];
        zze(new long[]{j5 * j5, j6 * 2 * jArr2[1], ((j7 * j7) + (jArr2[2] * j6)) * 2, ((j7 * j8) + (jArr2[3] * j6)) * 2, (j8 * j8) + (j7 * 4 * j9) + (j6 * 2 * jArr2[4]), ((j8 * j9) + (j7 * j10) + (jArr2[5] * j6)) * 2, ((j9 * j9) + (j8 * j10) + (jArr2[6] * j6) + (j7 * 2 * j11)) * 2, ((j9 * j10) + (j8 * j11) + (j7 * j12) + (jArr2[7] * j6)) * 2, (j10 * j10) + ((j13 + (((j7 * j14) + (j9 * j11)) * 2)) * 2), ((j10 * j11) + (j9 * j12) + (j8 * j14) + (j7 * j15) + (j6 * jArr2[9])) * 2, ((j11 * j11) + (j10 * j12) + (j8 * j15) + (((j9 * j14) + (j7 * j16)) * 2)) * 2, ((j11 * j12) + (j10 * j14) + (j9 * j15) + (j8 * j16)) * 2, (j12 * j12) + (((j10 * j15) + (((j11 * j14) + (j9 * j16)) * 2)) * 2), ((j12 * j14) + (j11 * j15) + (j10 * j16)) * 2, ((j14 * j14) + (j12 * j15) + (j11 * 2 * j16)) * 2, ((j14 * j15) + (j12 * j16)) * 2, (j15 * j15) + (j14 * 4 * j16), j15 * 2 * j16, 2 * j16 * j16}, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j5 = jArr2[0];
        long j6 = jArr2[1];
        long j7 = jArr3[0];
        jArr[1] = (jArr3[1] * j5) + (j6 * j7);
        long j8 = jArr2[1];
        long j9 = jArr3[1];
        jArr[2] = (j8 * 2 * j9) + (jArr3[2] * j5) + (jArr2[2] * j7);
        long j10 = jArr3[2];
        long j11 = jArr2[2];
        jArr[3] = (j8 * j10) + (j11 * j9) + (jArr3[3] * j5) + (jArr2[3] * j7);
        long j12 = jArr3[3];
        long j13 = jArr2[3];
        jArr[4] = (j11 * j10) + (((j8 * j12) + (j13 * j9)) * 2) + (jArr3[4] * j5) + (jArr2[4] * j7);
        long j14 = jArr3[4];
        long j15 = jArr2[4];
        jArr[5] = (j11 * j12) + (j13 * j10) + (j8 * j14) + (j15 * j9) + (jArr3[5] * j5) + (jArr2[5] * j7);
        long j16 = jArr3[5];
        long j17 = jArr2[5];
        jArr[6] = (((j13 * j12) + (j8 * j16) + (j17 * j9)) * 2) + (j11 * j14) + (j15 * j10) + (jArr3[6] * j5) + (jArr2[6] * j7);
        long j18 = jArr3[6];
        long j19 = jArr2[6];
        jArr[7] = (j13 * j14) + (j15 * j12) + (j11 * j16) + (j17 * j10) + (j8 * j18) + (j19 * j9) + (jArr3[7] * j5) + (jArr2[7] * j7);
        long j20 = jArr3[7];
        long j21 = jArr2[7];
        jArr[8] = (j15 * j14) + (((j13 * j16) + (j17 * j12) + (j8 * j20) + (j21 * j9)) * 2) + (j11 * j18) + (j19 * j10) + (jArr3[8] * j5) + (jArr2[8] * j7);
        long j22 = jArr3[8];
        long j23 = jArr2[8];
        jArr[9] = (j15 * j16) + (j17 * j14) + (j13 * j18) + (j19 * j12) + (j11 * j20) + (j21 * j10) + (j8 * j22) + (j23 * j9) + (j5 * jArr3[9]) + (jArr2[9] * j7);
        long j24 = jArr3[9];
        long j25 = jArr2[9];
        jArr[10] = (((j17 * j16) + (j13 * j20) + (j21 * j12) + (j8 * j24) + (j9 * j25)) * 2) + (j15 * j18) + (j19 * j14) + (j11 * j22) + (j23 * j10);
        jArr[11] = (j17 * j18) + (j19 * j16) + (j15 * j20) + (j21 * j14) + (j13 * j22) + (j23 * j12) + (j11 * j24) + (j10 * j25);
        jArr[12] = (j19 * j18) + (((j17 * j20) + (j21 * j16) + (j13 * j24) + (j12 * j25)) * 2) + (j15 * j22) + (j23 * j14);
        jArr[13] = (j19 * j20) + (j21 * j18) + (j17 * j22) + (j23 * j16) + (j15 * j24) + (j14 * j25);
        jArr[14] = (((j21 * j20) + (j17 * j24) + (j16 * j25)) * 2) + (j19 * j22) + (j23 * j18);
        jArr[15] = (j21 * j22) + (j23 * j20) + (j19 * j24) + (j18 * j25);
        jArr[16] = (j23 * j22) + (((j21 * j24) + (j20 * j25)) * 2);
        jArr[17] = (j23 * j24) + (j22 * j25);
        jArr[18] = j25 * 2 * j24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(long[] jArr, long[] jArr2) {
        zzc(jArr, jArr2, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i5 = 0; i5 < 10; i5++) {
            jArr[i5] = jArr2[i5] - jArr3[i5];
        }
    }

    public static byte[] zzc(long[] jArr) {
        int i5;
        int i6;
        long j5;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i14 = 0;
        while (true) {
            if (i14 >= 2) {
                break;
            }
            int i15 = 0;
            while (i15 < 9) {
                long j6 = copyOf[i15];
                copyOf[i15] = j6 + (i13 << i12);
                i15++;
                copyOf[i15] = copyOf[i15] - (-((int) (((j6 >> 31) & j6) >> zzd[i15 & 1])));
            }
            long j7 = copyOf[9];
            copyOf[9] = j7 + (i11 << 25);
            copyOf[0] = copyOf[0] - ((-((int) (((j7 >> 31) & j7) >> 25))) * 19);
            i14++;
        }
        long j8 = copyOf[0];
        copyOf[0] = j8 + (i6 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j8 >> 31) & j8) >> 26)));
        int i16 = 0;
        for (i5 = 2; i16 < i5; i5 = 2) {
            int i17 = 0;
            while (i17 < 9) {
                long j9 = copyOf[i17];
                int i18 = (int) (j9 >> zzd[i17 & 1]);
                copyOf[i17] = j9 & zzc[i10];
                i17++;
                copyOf[i17] = copyOf[i17] + i18;
            }
            i16++;
        }
        copyOf[9] = copyOf[9] & 33554431;
        long j10 = copyOf[0] + (((int) (j5 >> 25)) * 19);
        copyOf[0] = j10;
        int i19 = ~((((int) j10) - 67108845) >> 31);
        for (int i20 = 1; i20 < 10; i20++) {
            int i21 = ~(((int) copyOf[i20]) ^ zzc[i20 & 1]);
            int i22 = i21 & (i21 << 16);
            int i23 = i22 & (i22 << 8);
            int i24 = i23 & (i23 << 4);
            int i25 = i24 & (i24 << 2);
            i19 &= (i25 & (i25 << 1)) >> 31;
        }
        copyOf[0] = copyOf[0] - (67108845 & i19);
        long j11 = 33554431 & i19;
        copyOf[1] = copyOf[1] - j11;
        for (int i26 = 2; i26 < 10; i26 += 2) {
            copyOf[i26] = copyOf[i26] - (67108863 & i19);
            int i27 = i26 + 1;
            copyOf[i27] = copyOf[i27] - j11;
        }
        for (int i28 = 0; i28 < 10; i28++) {
            copyOf[i28] = copyOf[i28] << zzb[i28];
        }
        byte[] bArr = new byte[32];
        for (int i29 = 0; i29 < 10; i29++) {
            int i30 = zza[i29];
            long j12 = copyOf[i29];
            bArr[i30] = (byte) (bArr[i30] | (j12 & 255));
            bArr[i30 + 1] = (byte) (bArr[i7] | ((j12 >> 8) & 255));
            bArr[i30 + 2] = (byte) (bArr[i8] | ((j12 >> 16) & 255));
            bArr[i30 + 3] = (byte) (bArr[i9] | ((j12 >> 24) & 255));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(long[] jArr, long[] jArr2) {
        zzd(jArr, jArr, jArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i5 = 0; i5 < 10; i5++) {
            jArr[i5] = jArr2[i5] + jArr3[i5];
        }
    }

    private static void zze(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        zzb(jArr);
        zza(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }
}
