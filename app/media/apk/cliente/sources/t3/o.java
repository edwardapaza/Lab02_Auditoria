package t3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o {
    public static final <T> Object[] a(T[] tArr, boolean z4) {
        e4.k.e(tArr, "<this>");
        if (z4 && e4.k.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        e4.k.d(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t5) {
        List<T> singletonList = Collections.singletonList(t5);
        e4.k.d(singletonList, "singletonList(element)");
        return singletonList;
    }

    public static <T> List<T> c(Iterable<? extends T> iterable) {
        e4.k.e(iterable, "<this>");
        List<T> J = x.J(iterable);
        Collections.shuffle(J);
        return J;
    }
}
