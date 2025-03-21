package com.google.android.gms.internal.p001firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzmb {
    public static BigInteger zza(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] zza(BigInteger bigInteger) {
        if (bigInteger.signum() != -1) {
            return bigInteger.toByteArray();
        }
        throw new IllegalArgumentException("n must not be negative");
    }

    public static byte[] zza(BigInteger bigInteger, int i5) {
        if (bigInteger.signum() != -1) {
            byte[] byteArray = bigInteger.toByteArray();
            if (byteArray.length == i5) {
                return byteArray;
            }
            int i6 = i5 + 1;
            if (byteArray.length <= i6) {
                if (byteArray.length == i6) {
                    if (byteArray[0] == 0) {
                        return Arrays.copyOfRange(byteArray, 1, byteArray.length);
                    }
                    throw new GeneralSecurityException("integer too large");
                }
                byte[] bArr = new byte[i5];
                System.arraycopy(byteArray, 0, bArr, i5 - byteArray.length, byteArray.length);
                return bArr;
            }
            throw new GeneralSecurityException("integer too large");
        }
        throw new IllegalArgumentException("integer must be nonnegative");
    }
}
