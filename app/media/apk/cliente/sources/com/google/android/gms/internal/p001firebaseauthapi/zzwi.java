package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwi {
    public static final void zza(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i5) {
        if (i5 < 0 || byteBuffer2.remaining() < i5 || byteBuffer3.remaining() < i5 || byteBuffer.remaining() < i5) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] zza(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        if (i7 < 0 || bArr.length - i7 < i5 || bArr2.length - i7 < i6) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            bArr3[i8] = (byte) (bArr[i8 + i5] ^ bArr2[i8 + i6]);
        }
        return bArr3;
    }

    public static final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return zza(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static byte[] zza(byte[]... bArr) {
        int i5 = 0;
        for (byte[] bArr2 : bArr) {
            if (i5 > a.e.API_PRIORITY_OTHER - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i5 += bArr2.length;
        }
        byte[] bArr3 = new byte[i5];
        int i6 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i6, bArr4.length);
            i6 += bArr4.length;
        }
        return bArr3;
    }
}
