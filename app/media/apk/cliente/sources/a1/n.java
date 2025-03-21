package a1;

import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<?> list, Object obj) {
        if (obj == z0.k.n(list)) {
            return true;
        }
        if (obj instanceof List) {
            List list2 = (List) obj;
            int size = list.size();
            if (size != list2.size()) {
                return false;
            }
            if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
                for (int i5 = 0; i5 < size; i5++) {
                    if (!z0.g.a(list.get(i5), list2.get(i5))) {
                        return false;
                    }
                }
                return true;
            }
            return m.a(list.iterator(), list2.iterator());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return c(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (z0.g.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int c(List<?> list, Object obj) {
        int size = list.size();
        int i5 = 0;
        if (obj == null) {
            while (i5 < size) {
                if (list.get(i5) == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        while (i5 < size) {
            if (obj.equals(list.get(i5))) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (z0.g.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }
}
