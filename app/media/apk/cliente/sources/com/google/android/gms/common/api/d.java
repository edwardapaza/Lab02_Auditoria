package com.google.android.gms.common.api;

import i2.a0;
import i2.d0;
/* loaded from: classes.dex */
public class d {
    public static String a(int i5) {
        switch (i5) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case 11:
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            default:
                return "unknown status code: " + i5;
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return "API_NOT_CONNECTED";
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
