package com.google.android.gms.common.util;

import com.google.maps.android.BuildConfig;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String str : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str2 = hashMap.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append(BuildConfig.TRAVIS);
                z = false;
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
                z = false;
            }
        }
        sb.append("}");
    }
}
