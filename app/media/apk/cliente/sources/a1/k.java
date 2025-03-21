package a1;

import a1.i;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
/* loaded from: classes.dex */
public abstract class k<K, V> implements Map<K, V>, Serializable {

    /* renamed from: d  reason: collision with root package name */
    static final Map.Entry<?, ?>[] f21d = new Map.Entry[0];

    /* renamed from: a  reason: collision with root package name */
    private transient l<Map.Entry<K, V>> f22a;

    /* renamed from: b  reason: collision with root package name */
    private transient l<K> f23b;

    /* renamed from: c  reason: collision with root package name */
    private transient i<V> f24c;

    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Comparator<? super V> f25a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f26b;

        /* renamed from: c  reason: collision with root package name */
        int f27c = 0;

        /* renamed from: d  reason: collision with root package name */
        boolean f28d = false;

        /* renamed from: e  reason: collision with root package name */
        C0002a f29e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a1.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0002a {

            /* renamed from: a  reason: collision with root package name */
            private final Object f30a;

            /* renamed from: b  reason: collision with root package name */
            private final Object f31b;

            /* renamed from: c  reason: collision with root package name */
            private final Object f32c;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0002a(Object obj, Object obj2, Object obj3) {
                this.f30a = obj;
                this.f31b = obj2;
                this.f32c = obj3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f30a + "=" + this.f31b + " and " + this.f30a + "=" + this.f32c);
            }
        }

        a(int i5) {
            this.f26b = new Object[i5 * 2];
        }

        private k<K, V> b(boolean z4) {
            Object[] objArr;
            C0002a c0002a;
            C0002a c0002a2;
            if (!z4 || (c0002a2 = this.f29e) == null) {
                int i5 = this.f27c;
                if (this.f25a == null) {
                    objArr = this.f26b;
                } else {
                    if (this.f28d) {
                        this.f26b = Arrays.copyOf(this.f26b, i5 * 2);
                    }
                    objArr = this.f26b;
                    if (!z4) {
                        objArr = e(objArr, this.f27c);
                        if (objArr.length < this.f26b.length) {
                            i5 = objArr.length >>> 1;
                        }
                    }
                    i(objArr, i5, this.f25a);
                }
                this.f28d = true;
                u k5 = u.k(i5, objArr, this);
                if (!z4 || (c0002a = this.f29e) == null) {
                    return k5;
                }
                throw c0002a.a();
            }
            throw c0002a2.a();
        }

        private void d(int i5) {
            int i6 = i5 * 2;
            Object[] objArr = this.f26b;
            if (i6 > objArr.length) {
                this.f26b = Arrays.copyOf(objArr, i.b.a(objArr.length, i6));
                this.f28d = false;
            }
        }

        private Object[] e(Object[] objArr, int i5) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                Object obj = objArr[i6 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i6);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i5 - bitSet.cardinality()) * 2];
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5 * 2) {
                if (bitSet.get(i7 >>> 1)) {
                    i7 += 2;
                } else {
                    int i9 = i8 + 1;
                    int i10 = i7 + 1;
                    Object obj2 = objArr[i7];
                    Objects.requireNonNull(obj2);
                    objArr2[i8] = obj2;
                    i8 = i9 + 1;
                    i7 = i10 + 1;
                    Object obj3 = objArr[i10];
                    Objects.requireNonNull(obj3);
                    objArr2[i9] = obj3;
                }
            }
            return objArr2;
        }

        static <V> void i(Object[] objArr, int i5, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 2;
                Object obj = objArr[i7];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i7 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i6] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i5, r.a(comparator).b(p.c()));
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = i8 * 2;
                objArr[i9] = entryArr[i8].getKey();
                objArr[i9 + 1] = entryArr[i8].getValue();
            }
        }

        public k<K, V> a() {
            return c();
        }

        public k<K, V> c() {
            return b(true);
        }

        public a<K, V> f(K k5, V v5) {
            d(this.f27c + 1);
            c.a(k5, v5);
            Object[] objArr = this.f26b;
            int i5 = this.f27c;
            objArr[i5 * 2] = k5;
            objArr[(i5 * 2) + 1] = v5;
            this.f27c = i5 + 1;
            return this;
        }

        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f27c + ((Collection) iterable).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                g(entry);
            }
            return this;
        }
    }

    public static <K, V> k<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.h(iterable);
        return aVar.a();
    }

    public static <K, V> k<K, V> b(Map<? extends K, ? extends V> map) {
        if ((map instanceof k) && !(map instanceof SortedMap)) {
            k<K, V> kVar = (k) map;
            if (!kVar.g()) {
                return kVar;
            }
        }
        return a(map.entrySet());
    }

    public static <K, V> k<K, V> i() {
        return (k<K, V>) u.f42l;
    }

    abstract l<Map.Entry<K, V>> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract l<K> d();

    abstract i<V> e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return p.a(this, obj);
    }

    @Override // java.util.Map
    /* renamed from: f */
    public l<Map.Entry<K, V>> entrySet() {
        l<Map.Entry<K, V>> lVar = this.f22a;
        if (lVar == null) {
            l<Map.Entry<K, V>> c5 = c();
            this.f22a = c5;
            return c5;
        }
        return lVar;
    }

    abstract boolean g();

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v5) {
        V v6 = get(obj);
        return v6 != null ? v6 : v5;
    }

    @Override // java.util.Map
    /* renamed from: h */
    public l<K> keySet() {
        l<K> lVar = this.f23b;
        if (lVar == null) {
            l<K> d5 = d();
            this.f23b = d5;
            return d5;
        }
        return lVar;
    }

    @Override // java.util.Map
    public int hashCode() {
        return w.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* renamed from: j */
    public i<V> values() {
        i<V> iVar = this.f24c;
        if (iVar == null) {
            i<V> e5 = e();
            this.f24c = e5;
            return e5;
        }
        return iVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k5, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return p.b(this);
    }
}
