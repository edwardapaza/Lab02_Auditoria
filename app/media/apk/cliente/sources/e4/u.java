package e4;

import d4.v;
import d4.w;
/* loaded from: classes.dex */
public class u {
    public static Object a(Object obj, int i5) {
        if (obj != null && !c(obj, i5)) {
            f(obj, "kotlin.jvm.functions.Function" + i5);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof d4.a) {
            return 0;
        }
        if (obj instanceof d4.l) {
            return 1;
        }
        if (obj instanceof d4.p) {
            return 2;
        }
        if (obj instanceof d4.q) {
            return 3;
        }
        if (obj instanceof d4.r) {
            return 4;
        }
        if (obj instanceof d4.s) {
            return 5;
        }
        if (obj instanceof d4.t) {
            return 6;
        }
        if (obj instanceof d4.u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof d4.b) {
            return 10;
        }
        if (obj instanceof d4.c) {
            return 11;
        }
        if (obj instanceof d4.d) {
            return 12;
        }
        if (obj instanceof d4.e) {
            return 13;
        }
        if (obj instanceof d4.f) {
            return 14;
        }
        if (obj instanceof d4.g) {
            return 15;
        }
        if (obj instanceof d4.h) {
            return 16;
        }
        if (obj instanceof d4.i) {
            return 17;
        }
        if (obj instanceof d4.j) {
            return 18;
        }
        if (obj instanceof d4.k) {
            return 19;
        }
        if (obj instanceof d4.m) {
            return 20;
        }
        if (obj instanceof d4.n) {
            return 21;
        }
        return obj instanceof d4.o ? 22 : -1;
    }

    public static boolean c(Object obj, int i5) {
        return (obj instanceof s3.c) && b(obj) == i5;
    }

    private static <T extends Throwable> T d(T t5) {
        return (T) k.j(t5, u.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw ((ClassCastException) d(classCastException));
    }

    public static void f(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        g(name + " cannot be cast to " + str);
    }

    public static void g(String str) {
        throw e(new ClassCastException(str));
    }
}
