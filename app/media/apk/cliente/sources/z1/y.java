package z1;

import java.util.Locale;
/* loaded from: classes.dex */
public class y {
    public static void a(boolean z4, String str, Object... objArr) {
        if (!z4) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T b(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T c(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T d(T t5, String str, Object... objArr) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.format(Locale.US, str, objArr));
    }

    public static void e(boolean z4, String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }
}
