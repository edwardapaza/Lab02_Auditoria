package com.baseflow.geocoding.utils;

import java.util.StringTokenizer;
/* loaded from: classes2.dex */
public class AddressLineParser {
    private static final String ADDRESS_LINE_DELIMITER = ",";

    public static String getStreet(String addressLine) {
        if (addressLine == null || addressLine.isEmpty()) {
            return null;
        }
        StringTokenizer tokenizer = new StringTokenizer(addressLine, ADDRESS_LINE_DELIMITER, false);
        if (!tokenizer.hasMoreTokens()) {
            return null;
        }
        return tokenizer.nextToken();
    }
}
