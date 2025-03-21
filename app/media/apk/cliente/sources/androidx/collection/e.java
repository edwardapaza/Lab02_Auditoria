package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    e<K, V>.b f201a;

    /* renamed from: b  reason: collision with root package name */
    e<K, V>.c f202b;

    /* renamed from: c  reason: collision with root package name */
    e<K, V>.C0009e f203c;

    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f204a;

        /* renamed from: b  reason: collision with root package name */
        int f205b;

        /* renamed from: c  reason: collision with root package name */
        int f206c;

        /* renamed from: d  reason: collision with root package name */
        boolean f207d = false;

        a(int i5) {
            this.f204a = i5;
            this.f205b = e.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f206c < this.f205b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t5 = (T) e.this.b(this.f206c, this.f204a);
                this.f206c++;
                this.f207d = true;
                return t5;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f207d) {
                throw new IllegalStateException();
            }
            int i5 = this.f206c - 1;
            this.f206c = i5;
            this.f205b--;
            this.f207d = false;
            e.this.h(i5);
        }
    }

    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d5 = e.this.d();
            for (Map.Entry<K, V> entry : collection) {
                e.this.g(entry.getKey(), entry.getValue());
            }
            return d5 != e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int e5 = e.this.e(entry.getKey());
                if (e5 < 0) {
                    return false;
                }
                return androidx.collection.c.b(e.this.b(e5, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: g */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i5 = 0;
            for (int d5 = e.this.d() - 1; d5 >= 0; d5--) {
                Object b5 = e.this.b(d5, 0);
                Object b6 = e.this.b(d5, 1);
                i5 += (b5 == null ? 0 : b5.hashCode()) ^ (b6 == null ? 0 : b6.hashCode());
            }
            return i5;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return e.j(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i5 = 0;
            for (int d5 = e.this.d() - 1; d5 >= 0; d5--) {
                Object b5 = e.this.b(d5, 0);
                i5 += b5 == null ? 0 : b5.hashCode();
            }
            return i5;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e5 = e.this.e(obj);
            if (e5 >= 0) {
                e.this.h(e5);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return e.o(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return e.p(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return e.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 0);
        }
    }

    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f211a;

        /* renamed from: c  reason: collision with root package name */
        boolean f213c = false;

        /* renamed from: b  reason: collision with root package name */
        int f212b = -1;

        d() {
            this.f211a = e.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f212b++;
                this.f213c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f213c) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return androidx.collection.c.b(entry.getKey(), e.this.b(this.f212b, 0)) && androidx.collection.c.b(entry.getValue(), e.this.b(this.f212b, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f213c) {
                return (K) e.this.b(this.f212b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f213c) {
                return (V) e.this.b(this.f212b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f212b < this.f211a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f213c) {
                Object b5 = e.this.b(this.f212b, 0);
                Object b6 = e.this.b(this.f212b, 1);
                return (b5 == null ? 0 : b5.hashCode()) ^ (b6 != null ? b6.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f213c) {
                throw new IllegalStateException();
            }
            e.this.h(this.f212b);
            this.f212b--;
            this.f211a--;
            this.f213c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            if (this.f213c) {
                return (V) e.this.i(this.f212b, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: androidx.collection.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    final class C0009e implements Collection<V> {
        C0009e() {
        }

        @Override // java.util.Collection
        public boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return e.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f5 = e.this.f(obj);
            if (f5 >= 0) {
                e.this.h(f5);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d5 = e.this.d();
            int i5 = 0;
            boolean z4 = false;
            while (i5 < d5) {
                if (collection.contains(e.this.b(i5, 1))) {
                    e.this.h(i5);
                    i5--;
                    d5--;
                    z4 = true;
                }
                i5++;
            }
            return z4;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d5 = e.this.d();
            int i5 = 0;
            boolean z4 = false;
            while (i5 < d5) {
                if (!collection.contains(e.this.b(i5, 1))) {
                    e.this.h(i5);
                    i5--;
                    d5--;
                    z4 = true;
                }
                i5++;
            }
            return z4;
        }

        @Override // java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return e.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i5, int i6);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k5, V v5);

    protected abstract void h(int i5);

    protected abstract V i(int i5, V v5);

    public Set<Map.Entry<K, V>> l() {
        if (this.f201a == null) {
            this.f201a = new b();
        }
        return this.f201a;
    }

    public Set<K> m() {
        if (this.f202b == null) {
            this.f202b = new c();
        }
        return this.f202b;
    }

    public Collection<V> n() {
        if (this.f203c == null) {
            this.f203c = new C0009e();
        }
        return this.f203c;
    }

    public Object[] q(int i5) {
        int d5 = d();
        Object[] objArr = new Object[d5];
        for (int i6 = 0; i6 < d5; i6++) {
            objArr[i6] = b(i6, i5);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i5) {
        int d5 = d();
        if (tArr.length < d5) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d5));
        }
        for (int i6 = 0; i6 < d5; i6++) {
            tArr[i6] = b(i6, i5);
        }
        if (tArr.length > d5) {
            tArr[d5] = null;
        }
        return tArr;
    }
}
