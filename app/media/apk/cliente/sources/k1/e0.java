package k1;
/* loaded from: classes.dex */
public final class e0 {
    public static void a(boolean z4, String str) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T b(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T c(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static void d(boolean z4, String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }
}
