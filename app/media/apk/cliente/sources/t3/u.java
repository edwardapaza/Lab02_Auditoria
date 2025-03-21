package t3;

import java.util.Collection;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends t {
    public static <T> boolean l(Collection<? super T> collection, Iterable<? extends T> iterable) {
        e4.k.e(collection, "<this>");
        e4.k.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z4 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z4 = true;
            }
        }
        return z4;
    }

    private static final <T> boolean m(Iterable<? extends T> iterable, d4.l<? super T, Boolean> lVar, boolean z4) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (lVar.invoke((T) it.next()).booleanValue() == z4) {
                it.remove();
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> boolean n(Iterable<? extends T> iterable, d4.l<? super T, Boolean> lVar) {
        e4.k.e(iterable, "<this>");
        e4.k.e(lVar, "predicate");
        return m(iterable, lVar, false);
    }
}
