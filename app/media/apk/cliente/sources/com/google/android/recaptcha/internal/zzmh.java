package com.google.android.recaptcha.internal;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes.dex */
public final class zzmh {
    protected static final Charset zza = StandardCharsets.UTF_16;

    protected static int zza(int i5, int i6) {
        if (i5 % 2 == 0) {
            return ((~i5) & i6) | ((~i6) & i5);
        }
        return (i5 | i6) - (i5 & i6);
    }

    public static String zzb(String str, byte[] bArr, zzmi zzmiVar) {
        int i5 = 0;
        byte[] decode = Base64.decode(str, 0);
        char c5 = '\f';
        byte[] bArr2 = new byte[12];
        int length = decode.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(decode, 0, bArr2, 0, 12);
        System.arraycopy(decode, 12, bArr3, 0, length);
        int[] iArr = {511133343, 1277647508, 107287496, 338123662};
        if (bArr.length == 32) {
            int i6 = 16;
            int[] iArr2 = new int[16];
            for (int i7 = 0; i7 < 4; i7++) {
                iArr2[i7] = zza(iArr[i7], 2131181306);
            }
            for (int i8 = 4; i8 < 12; i8++) {
                iArr2[i8] = zze(bArr, (i8 - 4) * 4);
            }
            iArr2[12] = 1;
            for (int i9 = 13; i9 < 16; i9++) {
                iArr2[i9] = zze(bArr2, (i9 - 13) * 4);
            }
            int[] iArr3 = new int[16];
            System.arraycopy(iArr2, 0, iArr3, 0, 16);
            byte[] bArr4 = new byte[length];
            int i10 = length;
            int i11 = 1;
            int i12 = 0;
            while (i10 > 0) {
                System.arraycopy(iArr3, i5, iArr2, i5, i6);
                iArr2[c5] = i11;
                int i13 = 0;
                while (i13 < 10) {
                    int[] iArr4 = iArr3;
                    int i14 = i11;
                    zzc(0, 4, 8, 12, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(1, 5, 9, 13, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(2, 6, 10, 14, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(3, 7, 11, 15, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(0, 5, 10, 15, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(1, 6, 11, 12, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(2, 7, 8, 13, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    zzc(3, 4, 9, 14, iArr, bArr, bArr2, i14, iArr2, iArr4);
                    i13++;
                    i10 = i10;
                    bArr4 = bArr4;
                    iArr3 = iArr4;
                }
                int i15 = i10;
                byte[] bArr5 = bArr4;
                int[] iArr5 = iArr3;
                int[] iArr6 = iArr2;
                byte[] bArr6 = new byte[64];
                for (int i16 = 0; i16 < 16; i16++) {
                    int i17 = iArr6[i16];
                    int i18 = i16 * 4;
                    bArr6[i18] = (byte) (i17 & 255);
                    bArr6[i18 + 1] = (byte) ((i17 >> 8) & 255);
                    bArr6[i18 + 2] = (byte) ((i17 >> 16) & 255);
                    bArr6[i18 + 3] = (byte) ((i17 >> 24) & 255);
                }
                for (int i19 = 0; i19 < Math.min(64, i15); i19++) {
                    int i20 = i12 + i19;
                    bArr5[i20] = (byte) zza(bArr6[i19], bArr3[i20]);
                }
                i11++;
                i10 = i15 - 64;
                i12 += 64;
                bArr4 = bArr5;
                iArr3 = iArr5;
                iArr2 = iArr6;
                i6 = 16;
                i5 = 0;
                c5 = '\f';
            }
            return new String(bArr4, zza);
        }
        throw new IllegalArgumentException();
    }

    protected static final void zzc(int i5, int i6, int i7, int i8, int[] iArr, byte[] bArr, byte[] bArr2, int i9, int[] iArr2, int[] iArr3) {
        zzd(i5, i6, i8, 16, iArr, bArr, bArr2, i9, iArr2, iArr3);
        zzd(i7, i8, i6, 12, iArr, bArr, bArr2, i9, iArr2, iArr3);
        zzd(i5, i6, i8, 8, iArr, bArr, bArr2, i9, iArr2, iArr3);
        zzd(i7, i8, i6, 7, iArr, bArr, bArr2, i9, iArr2, iArr3);
    }

    protected static final void zzd(int i5, int i6, int i7, int i8, int[] iArr, byte[] bArr, byte[] bArr2, int i9, int[] iArr2, int[] iArr3) {
        int i10 = iArr2[i5] + iArr2[i6];
        iArr2[i5] = i10;
        int zza2 = zza(iArr2[i7], i10);
        iArr2[i7] = (zza2 << i8) | (zza2 >>> (32 - i8));
    }

    private static final int zze(byte[] bArr, int i5) {
        int i6 = (bArr[i5 + 1] & 255) << 8;
        return ((bArr[i5 + 3] & 255) << 24) | i6 | (bArr[i5] & 255) | ((bArr[i5 + 2] & 255) << 16);
    }
}
