package t3;

import java.util.Collection;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e<T> implements Collection<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f7617a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7618b;

    public e(T[] tArr, boolean z4) {
        e4.k.e(tArr, "values");
        this.f7617a = tArr;
        this.f7618b = z4;
    }

    @Override // java.util.Collection
    public boolean add(T t5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return k.g(this.f7617a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        e4.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int g() {
        return this.f7617a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f7617a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return e4.b.a(this.f7617a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return o.a(this.f7617a, this.f7618b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        e4.k.e(tArr, "array");
        return (T[]) e4.f.b(this, tArr);
    }
}
