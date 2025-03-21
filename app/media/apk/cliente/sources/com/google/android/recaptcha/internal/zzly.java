package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzly extends zzlx {
    @Override // com.google.android.recaptcha.internal.zzlx
    final int zza(int i5, byte[] bArr, int i6, int i7) {
        while (i6 < i7 && bArr[i6] >= 0) {
            i6++;
        }
        if (i6 >= i7) {
            return 0;
        }
        while (i6 < i7) {
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            if (b5 < 0) {
                if (b5 < -32) {
                    if (i8 >= i7) {
                        return b5;
                    }
                    if (b5 >= -62) {
                        i6 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                } else if (b5 >= -16) {
                    if (i8 >= i7 - 2) {
                        return zzma.zza(bArr, i8, i7);
                    }
                    int i9 = i8 + 1;
                    byte b6 = bArr[i8];
                    if (b6 <= -65 && (((b5 << 28) + (b6 + 112)) >> 30) == 0) {
                        int i10 = i9 + 1;
                        if (bArr[i9] <= -65) {
                            i8 = i10 + 1;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i8 >= i7 - 1) {
                    return zzma.zza(bArr, i8, i7);
                } else {
                    int i11 = i8 + 1;
                    byte b7 = bArr[i8];
                    if (b7 <= -65 && ((b5 != -32 || b7 >= -96) && (b5 != -19 || b7 < -96))) {
                        i6 = i11 + 1;
                        if (bArr[i11] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i6 = i8;
        }
        return 0;
    }
}
