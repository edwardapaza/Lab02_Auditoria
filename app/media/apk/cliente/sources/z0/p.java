package z0;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f8889a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f8890b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f8891c;

    static {
        Object b5 = b();
        f8889a = b5;
        f8890b = b5 == null ? null : a();
        f8891c = b5 != null ? d(b5) : null;
    }

    private static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e5) {
            throw e5;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e5) {
            throw e5;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Object obj) {
        try {
            Method c5 = c("getStackTraceDepth", Throwable.class);
            if (c5 == null) {
                return null;
            }
            c5.invoke(obj, new Throwable());
            return c5;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(Throwable th) {
        k.n(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
