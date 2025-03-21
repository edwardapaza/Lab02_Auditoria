package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhk  reason: invalid package */
/* loaded from: classes.dex */
final class zzhk {
    private static final int[] zza = zza(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    private static int zza(int i5, int i6) {
        return (i5 >>> (-i6)) | (i5 << i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(int[] iArr) {
        for (int i5 = 0; i5 < 10; i5++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    private static void zza(int[] iArr, int i5, int i6, int i7, int i8) {
        int i9 = iArr[i5] + iArr[i6];
        iArr[i5] = i9;
        int zza2 = zza(i9 ^ iArr[i8], 16);
        iArr[i8] = zza2;
        int i10 = iArr[i7] + zza2;
        iArr[i7] = i10;
        int zza3 = zza(iArr[i6] ^ i10, 12);
        iArr[i6] = zza3;
        int i11 = iArr[i5] + zza3;
        iArr[i5] = i11;
        int zza4 = zza(iArr[i8] ^ i11, 8);
        iArr[i8] = zza4;
        int i12 = iArr[i7] + zza4;
        iArr[i7] = i12;
        iArr[i6] = zza(iArr[i6] ^ i12, 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zza;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] zza(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
