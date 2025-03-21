package com.baseflow.geocoding.utils;

import java.util.Locale;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
public class LocaleConverter {
    private static final String LOCALE_DELIMITER = "_";

    public static Locale fromLanguageTag(String languageTag) {
        if (languageTag == null || languageTag.isEmpty()) {
            return null;
        }
        String language = null;
        StringTokenizer tokenizer = new StringTokenizer(languageTag, LOCALE_DELIMITER, false);
        if (tokenizer.hasMoreTokens()) {
            language = tokenizer.nextToken();
        }
        String country = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
        String variant = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
        if (language != null && country != null && variant != null) {
            return new Locale(language, country, variant);
        }
        if (language != null && country != null) {
            return new Locale(language, country);
        }
        if (language == null) {
            return null;
        }
        return new Locale(language);
    }
}
