package w;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f8207a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f8208b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f8209c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f8210d;

    public static void a(String str, int i5) {
        int i6 = Build.VERSION.SDK_INT;
        String j5 = j(str);
        if (i6 >= 29) {
            f.a(j5, i5);
        } else {
            b(j5, i5);
        }
    }

    private static void b(String str, int i5) {
        try {
            if (f8209c == null) {
                f8209c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f8209c.invoke(null, Long.valueOf(f8207a), str, Integer.valueOf(i5));
        } catch (Exception e5) {
            g("asyncTraceBegin", e5);
        }
    }

    public static void c(String str) {
        b.a(j(str));
    }

    public static void d(String str, int i5) {
        int i6 = Build.VERSION.SDK_INT;
        String j5 = j(str);
        if (i6 >= 29) {
            f.b(j5, i5);
        } else {
            e(j5, i5);
        }
    }

    private static void e(String str, int i5) {
        try {
            if (f8210d == null) {
                f8210d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f8210d.invoke(null, Long.valueOf(f8207a), str, Integer.valueOf(i5));
        } catch (Exception e5) {
            g("asyncTraceEnd", e5);
        }
    }

    public static void f() {
        b.b();
    }

    private static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29 ? f.c() : i();
    }

    private static boolean i() {
        try {
            if (f8208b == null) {
                f8207a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f8208b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f8208b.invoke(null, Long.valueOf(f8207a))).booleanValue();
        } catch (Exception e5) {
            g("isTagEnabled", e5);
            return false;
        }
    }

    private static String j(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
