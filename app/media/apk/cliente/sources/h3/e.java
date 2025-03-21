package h3;
/* loaded from: classes.dex */
public final class e implements AutoCloseable {
    private e(String str) {
        c(str);
    }

    public static void c(String str) {
        w.a.c(g(str));
    }

    public static void d(String str, int i5) {
        w.a.a(g(str), i5);
    }

    private static String g(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void h() {
        w.a.f();
    }

    public static void i(String str, int i5) {
        w.a.d(g(str), i5);
    }

    public static e j(String str) {
        return new e(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        h();
    }
}
