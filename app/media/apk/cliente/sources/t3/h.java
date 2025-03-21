package t3;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
class h {
    public static final <T> T[] a(T[] tArr, int i5) {
        e4.k.e(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i5);
        e4.k.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }
}
