package t3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class z implements List, Serializable, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public static final z f7647a = new z();

    private z() {
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return g((Void) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        e4.k.e(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    public boolean g(Void r22) {
        e4.k.e(r22, "element");
        return false;
    }

    @Override // java.util.List
    /* renamed from: h */
    public Void get(int i5) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i5 + '.');
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    public int i() {
        return 0;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return k((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return y.f7646a;
    }

    public int k(Void r22) {
        e4.k.e(r22, "element");
        return -1;
    }

    public int l(Void r22) {
        e4.k.e(r22, "element");
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return l((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return y.f7646a;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i5) {
        if (i5 == 0) {
            return y.f7646a;
        }
        throw new IndexOutOfBoundsException("Index: " + i5);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return i();
    }

    @Override // java.util.List
    public List subList(int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return e4.f.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        e4.k.e(tArr, "array");
        return (T[]) e4.f.b(this, tArr);
    }

    public String toString() {
        return "[]";
    }
}
