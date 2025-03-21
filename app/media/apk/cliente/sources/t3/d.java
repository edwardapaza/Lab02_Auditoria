package t3;

import java.util.AbstractList;
/* loaded from: classes.dex */
public abstract class d<E> extends AbstractList<E> {
    public abstract int g();

    public abstract E h(int i5);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i5) {
        return h(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return g();
    }
}
