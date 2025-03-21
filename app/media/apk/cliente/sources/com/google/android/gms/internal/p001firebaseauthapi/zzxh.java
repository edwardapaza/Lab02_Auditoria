package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh  reason: invalid package */
/* loaded from: classes.dex */
public final class zzxh {
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b5 : bArr) {
            int i5 = b5 & 255;
            sb.append("0123456789abcdef".charAt(i5 / 16));
            sb.append("0123456789abcdef".charAt(i5 % 16));
        }
        return sb.toString();
    }

    public static byte[] zza(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                int digit = Character.digit(str.charAt(i6), 16);
                int digit2 = Character.digit(str.charAt(i6 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
                bArr[i5] = (byte) ((digit << 4) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }
}
