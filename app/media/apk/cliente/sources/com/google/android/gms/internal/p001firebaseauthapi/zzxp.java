package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxp {
    public static byte[] zza(byte[] bArr) {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b5 = (byte) (copyOf[31] & Byte.MAX_VALUE);
            copyOf[31] = b5;
            copyOf[31] = (byte) (b5 | 64);
            zzme.zza(jArr, copyOf, bArr2);
            return zzmj.zzc(jArr);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
