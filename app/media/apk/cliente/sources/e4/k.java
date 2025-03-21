package e4;

import java.util.Arrays;
/* loaded from: classes.dex */
public class k {
    private k() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            k();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            l(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) i(new NullPointerException(str + " must not be null")));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            m(str);
        }
    }

    public static int f(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 == i6 ? 0 : 1;
    }

    public static int g(long j5, long j6) {
        int i5 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
        if (i5 < 0) {
            return -1;
        }
        return i5 == 0 ? 0 : 1;
    }

    private static String h(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = k.class.getName();
        int i5 = 0;
        while (!stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        while (stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        StackTraceElement stackTraceElement = stackTrace[i5];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    private static <T extends Throwable> T i(T t5) {
        return (T) j(t5, k.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T j(T t5, String str) {
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.equals(stackTrace[i6].getClassName())) {
                i5 = i6;
            }
        }
        t5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i5 + 1, length));
        return t5;
    }

    public static void k() {
        throw ((NullPointerException) i(new NullPointerException()));
    }

    public static void l(String str) {
        throw ((NullPointerException) i(new NullPointerException(str)));
    }

    private static void m(String str) {
        throw ((NullPointerException) i(new NullPointerException(h(str))));
    }

    public static void n(String str) {
        throw ((s3.s) i(new s3.s(str)));
    }

    public static void o(String str) {
        n("lateinit property " + str + " has not been initialized");
    }
}
