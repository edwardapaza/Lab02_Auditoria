package t3;

import java.util.Collection;
/* loaded from: classes.dex */
public abstract class a<E> implements Collection<E> {

    /* renamed from: t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0116a extends e4.l implements d4.l<E, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a<E> f7604a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0116a(a<? extends E> aVar) {
            super(1);
            this.f7604a = aVar;
        }

        @Override // d4.l
        /* renamed from: a */
        public final CharSequence invoke(E e5) {
            return e5 == this.f7604a ? "(this Collection)" : String.valueOf(e5);
        }
    }

    @Override // java.util.Collection
    public boolean add(E e5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e5) {
        if (isEmpty()) {
            return false;
        }
        for (E e6 : this) {
            if (e4.k.a(e6, e5)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        e4.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    public abstract int g();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
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
    public Object[] toArray() {
        return e4.f.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        e4.k.e(tArr, "array");
        return (T[]) e4.f.b(this, tArr);
    }

    public String toString() {
        String w5;
        w5 = x.w(this, ", ", "[", "]", 0, null, new C0116a(this), 24, null);
        return w5;
    }
}
