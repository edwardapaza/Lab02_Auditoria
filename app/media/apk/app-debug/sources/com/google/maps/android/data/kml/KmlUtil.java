package com.google.maps.android.data.kml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class KmlUtil {
    public static String substituteProperties(String template, KmlPlacemark placemark) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("\\$\\[(.+?)]");
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String property = matcher.group(1);
            String value = placemark.getProperty(property);
            if (value != null) {
                matcher.appendReplacement(sb, value);
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
