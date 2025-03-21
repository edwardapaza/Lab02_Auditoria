package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class Base64Utils {
    public static byte[] decode(String encodedData) {
        if (encodedData == null) {
            return null;
        }
        return Base64.decode(encodedData, 0);
    }

    public static byte[] decodeUrlSafe(String encodedData) {
        if (encodedData == null) {
            return null;
        }
        return Base64.decode(encodedData, 10);
    }

    @ResultIgnorabilityUnspecified
    public static byte[] decodeUrlSafeNoPadding(String encodedData) {
        if (encodedData == null) {
            return null;
        }
        return Base64.decode(encodedData, 11);
    }

    public static String encode(byte[] data) {
        if (data == null) {
            return null;
        }
        return Base64.encodeToString(data, 0);
    }

    public static String encodeUrlSafe(byte[] data) {
        if (data == null) {
            return null;
        }
        return Base64.encodeToString(data, 10);
    }

    public static String encodeUrlSafeNoPadding(byte[] data) {
        if (data == null) {
            return null;
        }
        return Base64.encodeToString(data, 11);
    }
}
