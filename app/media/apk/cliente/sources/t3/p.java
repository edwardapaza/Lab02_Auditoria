package t3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {
    public static <T> ArrayList<T> d(T... tArr) {
        e4.k.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new e(tArr, true));
    }

    public static final <T> Collection<T> e(T[] tArr) {
        e4.k.e(tArr, "<this>");
        return new e(tArr, false);
    }

    public static <T> List<T> f() {
        return z.f7647a;
    }

    public static <T> int g(List<? extends T> list) {
        e4.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> h(T... tArr) {
        List<T> f5;
        List<T> b5;
        e4.k.e(tArr, "elements");
        if (tArr.length > 0) {
            b5 = j.b(tArr);
            return b5;
        }
        f5 = f();
        return f5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> i(List<? extends T> list) {
        List<T> f5;
        List<T> b5;
        e4.k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            f5 = f();
            return f5;
        } else if (size != 1) {
            return list;
        } else {
            b5 = o.b(list.get(0));
            return b5;
        }
    }

    public static void j() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
