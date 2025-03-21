package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class g {
    private static final void a(int i5, int i6) {
        if (i6 <= i5) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i5 + ", got " + i6 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        String str;
        e4.k.e(aVar, "<this>");
        f b5 = b(aVar);
        if (b5 == null) {
            return null;
        }
        a(1, b5.v());
        int c5 = c(aVar);
        int i5 = c5 < 0 ? -1 : b5.l()[c5];
        String b6 = i.f5857a.b(aVar);
        if (b6 == null) {
            str = b5.c();
        } else {
            str = b6 + '/' + b5.c();
        }
        return new StackTraceElement(str, b5.m(), b5.f(), i5);
    }
}
