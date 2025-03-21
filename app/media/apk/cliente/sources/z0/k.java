package z0;
/* loaded from: classes.dex */
public final class k {
    private static String a(int i5, int i6, String str) {
        if (i5 < 0) {
            return n.b("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return n.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("negative size: " + i6);
    }

    private static String b(int i5, int i6, String str) {
        if (i5 < 0) {
            return n.b("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return n.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("negative size: " + i6);
    }

    private static String c(int i5, int i6, int i7) {
        return (i5 < 0 || i5 > i7) ? b(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? b(i6, i7, "end index") : n.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
    }

    public static void d(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z4, String str, char c5) {
        if (!z4) {
            throw new IllegalArgumentException(n.b(str, Character.valueOf(c5)));
        }
    }

    public static void g(boolean z4, String str, char c5, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(n.b(str, Character.valueOf(c5), obj));
        }
    }

    public static void h(boolean z4, String str, int i5) {
        if (!z4) {
            throw new IllegalArgumentException(n.b(str, Integer.valueOf(i5)));
        }
    }

    public static void i(boolean z4, String str, long j5) {
        if (!z4) {
            throw new IllegalArgumentException(n.b(str, Long.valueOf(j5)));
        }
    }

    public static void j(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(n.b(str, obj));
        }
    }

    public static void k(boolean z4, String str, Object obj, Object obj2) {
        if (!z4) {
            throw new IllegalArgumentException(n.b(str, obj, obj2));
        }
    }

    public static int l(int i5, int i6) {
        return m(i5, i6, "index");
    }

    public static int m(int i5, int i6, String str) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(a(i5, i6, str));
        }
        return i5;
    }

    public static <T> T n(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T o(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T p(T t5, String str, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(n.b(str, obj));
    }

    public static int q(int i5, int i6) {
        return r(i5, i6, "index");
    }

    public static int r(int i5, int i6, String str) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(b(i5, i6, str));
        }
        return i5;
    }

    public static void s(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException(c(i5, i6, i7));
        }
    }

    public static void t(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static void u(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void v(boolean z4, String str, int i5) {
        if (!z4) {
            throw new IllegalStateException(n.b(str, Integer.valueOf(i5)));
        }
    }

    public static void w(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalStateException(n.b(str, obj));
        }
    }
}
