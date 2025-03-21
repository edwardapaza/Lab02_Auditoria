package t3;

import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {
    public static <T> int k(Iterable<? extends T> iterable, int i5) {
        e4.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i5;
    }
}
