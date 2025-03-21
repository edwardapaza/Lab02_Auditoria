package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzakp {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzakk zzakkVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzakkVar, sb, 0);
        return sb.toString();
    }

    private static void zza(int i5, StringBuilder sb) {
        while (i5 > 0) {
            char[] cArr = zza;
            int length = i5 > cArr.length ? cArr.length : i5;
            sb.append(cArr, 0, length);
            i5 -= length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x018f, code lost:
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0191, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a2, code lost:
        if (((java.lang.Integer) r7).intValue() == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b4, code lost:
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ca, code lost:
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.p001firebaseauthapi.zzakk r20, java.lang.StringBuilder r21, int r22) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzakp.zza(com.google.android.gms.internal.firebase-auth-api.zzakk, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zza(sb, i5, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zza(sb, i5, str, entry);
            }
        } else {
            sb.append('\n');
            zza(i5, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i6 = 1; i6 < str.length(); i6++) {
                    char charAt = str.charAt(i6);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzalx.zza(zzahm.zza((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzahm) {
                sb.append(": \"");
                sb.append(zzalx.zza((zzahm) obj));
                sb.append('\"');
            } else if (obj instanceof zzaja) {
                sb.append(" {");
                zza((zzaja) obj, sb, i5 + 2);
                sb.append("\n");
                zza(i5, sb);
                sb.append("}");
            } else if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj);
            } else {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i7 = i5 + 2;
                zza(sb, i7, "key", entry2.getKey());
                zza(sb, i7, "value", entry2.getValue());
                sb.append("\n");
                zza(i5, sb);
                sb.append("}");
            }
        }
    }
}
