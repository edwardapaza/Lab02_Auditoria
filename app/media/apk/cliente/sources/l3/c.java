package l3;

import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public final class c {
    public static String a(String str, String str2) {
        try {
            String a5 = w4.f.m((str + ":" + str2).getBytes("ISO-8859-1")).a();
            return "Basic " + a5;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
