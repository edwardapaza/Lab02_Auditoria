package com.google.android.gms.common.util;

import kotlin.UByte;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class Hex {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToStringLowercase(byte[] bytes) {
        int length = bytes.length;
        char[] cArr = new char[length + length];
        int i = 0;
        for (byte b : bytes) {
            int i2 = b & UByte.MAX_VALUE;
            int i3 = i + 1;
            char[] cArr2 = zzb;
            cArr[i] = cArr2[i2 >>> 4];
            cArr[i3] = cArr2[i2 & 15];
            i = i3 + 1;
        }
        return new String(cArr);
    }

    public static String bytesToStringUppercase(byte[] bytes) {
        return bytesToStringUppercase(bytes, false);
    }

    public static byte[] stringToBytes(String hex) throws IllegalArgumentException {
        int length = hex.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArr[i / 2] = (byte) Integer.parseInt(hex.substring(i, i2), 16);
            i = i2;
        }
        return bArr;
    }

    public static String bytesToStringUppercase(byte[] bytes, boolean zeroTerminated) {
        int length = bytes.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i = 0; i < length && (!zeroTerminated || i != length - 1 || (bytes[i] & UByte.MAX_VALUE) != 0); i++) {
            char[] cArr = zza;
            sb.append(cArr[(bytes[i] & 240) >>> 4]);
            sb.append(cArr[bytes[i] & 15]);
        }
        return sb.toString();
    }
}
