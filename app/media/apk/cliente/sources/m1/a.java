package m1;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m1.c;
/* loaded from: classes.dex */
public class a<K, V> extends c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K[] f6050a;

    /* renamed from: b  reason: collision with root package name */
    private final V[] f6051b;

    /* renamed from: c  reason: collision with root package name */
    private final Comparator<K> f6052c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0089a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        int f6053a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6054b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f6055c;

        C0089a(int i5, boolean z4) {
            this.f6054b = i5;
            this.f6055c = z4;
            this.f6053a = i5;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            Object obj = a.this.f6050a[this.f6053a];
            Object[] objArr = a.this.f6051b;
            int i5 = this.f6053a;
            Object obj2 = objArr[i5];
            this.f6053a = this.f6055c ? i5 - 1 : i5 + 1;
            return new AbstractMap.SimpleImmutableEntry(obj, obj2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6055c) {
                if (this.f6053a >= 0) {
                    return true;
                }
            } else if (this.f6053a < a.this.f6050a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public a(Comparator<K> comparator) {
        this.f6050a = (K[]) new Object[0];
        this.f6051b = (V[]) new Object[0];
        this.f6052c = comparator;
    }

    private a(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f6050a = kArr;
        this.f6051b = vArr;
        this.f6052c = comparator;
    }

    private static <T> T[] r(T[] tArr, int i5, T t5) {
        int length = tArr.length + 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i5);
        tArr2[i5] = t5;
        System.arraycopy(tArr, i5, tArr2, i5 + 1, (length - i5) - 1);
        return tArr2;
    }

    public static <A, B, C> a<A, C> s(List<A> list, Map<B, C> map, c.a.InterfaceC0090a<A, B> interfaceC0090a, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i5 = 0;
        for (A a5 : list) {
            objArr[i5] = a5;
            objArr2[i5] = map.get(interfaceC0090a.a(a5));
            i5++;
        }
        return new a<>(comparator, objArr, objArr2);
    }

    private int t(K k5) {
        int i5 = 0;
        for (K k6 : this.f6050a) {
            if (this.f6052c.compare(k5, k6) == 0) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private int u(K k5) {
        int i5 = 0;
        while (true) {
            K[] kArr = this.f6050a;
            if (i5 >= kArr.length || this.f6052c.compare(kArr[i5], k5) >= 0) {
                break;
            }
            i5++;
        }
        return i5;
    }

    private Iterator<Map.Entry<K, V>> v(int i5, boolean z4) {
        return new C0089a(i5, z4);
    }

    private static <T> T[] w(T[] tArr, int i5) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i5);
        System.arraycopy(tArr, i5 + 1, tArr2, i5, length - i5);
        return tArr2;
    }

    private static <T> T[] x(T[] tArr, int i5, T t5) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i5] = t5;
        return tArr2;
    }

    @Override // m1.c
    public boolean g(K k5) {
        return t(k5) != -1;
    }

    @Override // m1.c
    public V h(K k5) {
        int t5 = t(k5);
        if (t5 != -1) {
            return this.f6051b[t5];
        }
        return null;
    }

    @Override // m1.c
    public Comparator<K> i() {
        return this.f6052c;
    }

    @Override // m1.c
    public int indexOf(K k5) {
        return t(k5);
    }

    @Override // m1.c
    public boolean isEmpty() {
        return this.f6050a.length == 0;
    }

    @Override // m1.c, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return v(0, false);
    }

    @Override // m1.c
    public K k() {
        K[] kArr = this.f6050a;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // m1.c
    public K l() {
        K[] kArr = this.f6050a;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // m1.c
    public c<K, V> m(K k5, V v5) {
        int t5 = t(k5);
        if (t5 != -1) {
            K[] kArr = this.f6050a;
            if (kArr[t5] == k5 && this.f6051b[t5] == v5) {
                return this;
            }
            return new a(this.f6052c, x(kArr, t5, k5), x(this.f6051b, t5, v5));
        } else if (this.f6050a.length <= 25) {
            int u5 = u(k5);
            return new a(this.f6052c, r(this.f6050a, u5, k5), r(this.f6051b, u5, v5));
        } else {
            HashMap hashMap = new HashMap(this.f6050a.length + 1);
            int i5 = 0;
            while (true) {
                K[] kArr2 = this.f6050a;
                if (i5 >= kArr2.length) {
                    hashMap.put(k5, v5);
                    return k.q(hashMap, this.f6052c);
                }
                hashMap.put(kArr2[i5], this.f6051b[i5]);
                i5++;
            }
        }
    }

    @Override // m1.c
    public Iterator<Map.Entry<K, V>> n(K k5) {
        return v(u(k5), false);
    }

    @Override // m1.c
    public c<K, V> o(K k5) {
        int t5 = t(k5);
        if (t5 == -1) {
            return this;
        }
        return new a(this.f6052c, w(this.f6050a, t5), w(this.f6051b, t5));
    }

    @Override // m1.c
    public int size() {
        return this.f6050a.length;
    }
}
