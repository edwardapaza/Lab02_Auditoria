package com.dexterous.flutterlocalnotifications.utils;
/* loaded from: classes2.dex */
public class LongUtils {
    public static Long parseLong(Object object) {
        if (object instanceof Integer) {
            return Long.valueOf(((Integer) object).longValue());
        }
        if (object instanceof Long) {
            return (Long) object;
        }
        return null;
    }
}
