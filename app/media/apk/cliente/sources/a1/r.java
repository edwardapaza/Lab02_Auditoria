package a1;

import java.util.Comparator;
/* loaded from: classes.dex */
public abstract class r<T> implements Comparator<T> {
    public static <T> r<T> a(Comparator<T> comparator) {
        return comparator instanceof r ? (r) comparator : new e(comparator);
    }

    public <F> r<F> b(z0.d<F, ? extends T> dVar) {
        return new b(dVar, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t5, T t6);
}
