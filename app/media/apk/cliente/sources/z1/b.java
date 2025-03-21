package z1;
/* loaded from: classes.dex */
public class b {
    public static AssertionError a(String str, Object... objArr) {
        throw new AssertionError(c(str, objArr));
    }

    public static AssertionError b(Throwable th, String str, Object... objArr) {
        throw a.b(c(str, objArr), th);
    }

    private static String c(String str, Object... objArr) {
        return "INTERNAL ASSERTION FAILED: " + String.format(str, objArr);
    }

    public static void d(boolean z4, String str, Object... objArr) {
        if (!z4) {
            throw a(str, objArr);
        }
    }

    public static <T> T e(T t5, String str, Object... objArr) {
        if (t5 != null) {
            return t5;
        }
        throw a(str, objArr);
    }
}
