package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f187e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f188f = new Object[0];

    /* renamed from: k  reason: collision with root package name */
    private static Object[] f189k;

    /* renamed from: l  reason: collision with root package name */
    private static int f190l;

    /* renamed from: m  reason: collision with root package name */
    private static Object[] f191m;

    /* renamed from: n  reason: collision with root package name */
    private static int f192n;

    /* renamed from: a  reason: collision with root package name */
    private int[] f193a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f194b;

    /* renamed from: c  reason: collision with root package name */
    int f195c;

    /* renamed from: d  reason: collision with root package name */
    private e<E, E> f196d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends e<E, E> {
        a() {
        }

        @Override // androidx.collection.e
        protected void a() {
            b.this.clear();
        }

        @Override // androidx.collection.e
        protected Object b(int i5, int i6) {
            return b.this.f194b[i5];
        }

        @Override // androidx.collection.e
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.e
        protected int d() {
            return b.this.f195c;
        }

        @Override // androidx.collection.e
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.e
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.e
        protected void g(E e5, E e6) {
            b.this.add(e5);
        }

        @Override // androidx.collection.e
        protected void h(int i5) {
            b.this.n(i5);
        }

        @Override // androidx.collection.e
        protected E i(int i5, E e5) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i5) {
        if (i5 == 0) {
            this.f193a = f187e;
            this.f194b = f188f;
        } else {
            g(i5);
        }
        this.f195c = 0;
    }

    private void g(int i5) {
        if (i5 == 8) {
            synchronized (b.class) {
                Object[] objArr = f191m;
                if (objArr != null) {
                    this.f194b = objArr;
                    f191m = (Object[]) objArr[0];
                    this.f193a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f192n--;
                    return;
                }
            }
        } else if (i5 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f189k;
                if (objArr2 != null) {
                    this.f194b = objArr2;
                    f189k = (Object[]) objArr2[0];
                    this.f193a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f190l--;
                    return;
                }
            }
        }
        this.f193a = new int[i5];
        this.f194b = new Object[i5];
    }

    private static void i(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f192n < 10) {
                    objArr[0] = f191m;
                    objArr[1] = iArr;
                    for (int i6 = i5 - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f191m = objArr;
                    f192n++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f190l < 10) {
                    objArr[0] = f189k;
                    objArr[1] = iArr;
                    for (int i7 = i5 - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f189k = objArr;
                    f190l++;
                }
            }
        }
    }

    private e<E, E> k() {
        if (this.f196d == null) {
            this.f196d = new a();
        }
        return this.f196d;
    }

    private int l(Object obj, int i5) {
        int i6 = this.f195c;
        if (i6 == 0) {
            return -1;
        }
        int a5 = c.a(this.f193a, i6, i5);
        if (a5 >= 0 && !obj.equals(this.f194b[a5])) {
            int i7 = a5 + 1;
            while (i7 < i6 && this.f193a[i7] == i5) {
                if (obj.equals(this.f194b[i7])) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = a5 - 1; i8 >= 0 && this.f193a[i8] == i5; i8--) {
                if (obj.equals(this.f194b[i8])) {
                    return i8;
                }
            }
            return ~i7;
        }
        return a5;
    }

    private int m() {
        int i5 = this.f195c;
        if (i5 == 0) {
            return -1;
        }
        int a5 = c.a(this.f193a, i5, 0);
        if (a5 >= 0 && this.f194b[a5] != null) {
            int i6 = a5 + 1;
            while (i6 < i5 && this.f193a[i6] == 0) {
                if (this.f194b[i6] == null) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = a5 - 1; i7 >= 0 && this.f193a[i7] == 0; i7--) {
                if (this.f194b[i7] == null) {
                    return i7;
                }
            }
            return ~i6;
        }
        return a5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e5) {
        int i5;
        int l5;
        if (e5 == null) {
            l5 = m();
            i5 = 0;
        } else {
            int hashCode = e5.hashCode();
            i5 = hashCode;
            l5 = l(e5, hashCode);
        }
        if (l5 >= 0) {
            return false;
        }
        int i6 = ~l5;
        int i7 = this.f195c;
        int[] iArr = this.f193a;
        if (i7 >= iArr.length) {
            int i8 = 4;
            if (i7 >= 8) {
                i8 = (i7 >> 1) + i7;
            } else if (i7 >= 4) {
                i8 = 8;
            }
            Object[] objArr = this.f194b;
            g(i8);
            int[] iArr2 = this.f193a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f194b, 0, objArr.length);
            }
            i(iArr, objArr, this.f195c);
        }
        int i9 = this.f195c;
        if (i6 < i9) {
            int[] iArr3 = this.f193a;
            int i10 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i10, i9 - i6);
            Object[] objArr2 = this.f194b;
            System.arraycopy(objArr2, i6, objArr2, i10, this.f195c - i6);
        }
        this.f193a[i6] = i5;
        this.f194b[i6] = e5;
        this.f195c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        h(this.f195c + collection.size());
        boolean z4 = false;
        for (E e5 : collection) {
            z4 |= add(e5);
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i5 = this.f195c;
        if (i5 != 0) {
            i(this.f193a, this.f194b, i5);
            this.f193a = f187e;
            this.f194b = f188f;
            this.f195c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f195c; i5++) {
                try {
                    if (!set.contains(o(i5))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void h(int i5) {
        int[] iArr = this.f193a;
        if (iArr.length < i5) {
            Object[] objArr = this.f194b;
            g(i5);
            int i6 = this.f195c;
            if (i6 > 0) {
                System.arraycopy(iArr, 0, this.f193a, 0, i6);
                System.arraycopy(objArr, 0, this.f194b, 0, this.f195c);
            }
            i(iArr, objArr, this.f195c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f193a;
        int i5 = this.f195c;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += iArr[i7];
        }
        return i6;
    }

    public int indexOf(Object obj) {
        return obj == null ? m() : l(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f195c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return k().m().iterator();
    }

    public E n(int i5) {
        Object[] objArr = this.f194b;
        E e5 = (E) objArr[i5];
        int i6 = this.f195c;
        if (i6 <= 1) {
            i(this.f193a, objArr, i6);
            this.f193a = f187e;
            this.f194b = f188f;
            this.f195c = 0;
        } else {
            int[] iArr = this.f193a;
            if (iArr.length <= 8 || i6 >= iArr.length / 3) {
                int i7 = i6 - 1;
                this.f195c = i7;
                if (i5 < i7) {
                    int i8 = i5 + 1;
                    System.arraycopy(iArr, i8, iArr, i5, i7 - i5);
                    Object[] objArr2 = this.f194b;
                    System.arraycopy(objArr2, i8, objArr2, i5, this.f195c - i5);
                }
                this.f194b[this.f195c] = null;
            } else {
                g(i6 > 8 ? i6 + (i6 >> 1) : 8);
                this.f195c--;
                if (i5 > 0) {
                    System.arraycopy(iArr, 0, this.f193a, 0, i5);
                    System.arraycopy(objArr, 0, this.f194b, 0, i5);
                }
                int i9 = this.f195c;
                if (i5 < i9) {
                    int i10 = i5 + 1;
                    System.arraycopy(iArr, i10, this.f193a, i5, i9 - i5);
                    System.arraycopy(objArr, i10, this.f194b, i5, this.f195c - i5);
                }
            }
        }
        return e5;
    }

    public E o(int i5) {
        return (E) this.f194b[i5];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            n(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 |= remove(it.next());
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z4 = false;
        for (int i5 = this.f195c - 1; i5 >= 0; i5--) {
            if (!collection.contains(this.f194b[i5])) {
                n(i5);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f195c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i5 = this.f195c;
        Object[] objArr = new Object[i5];
        System.arraycopy(this.f194b, 0, objArr, 0, i5);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f195c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f195c));
        }
        System.arraycopy(this.f194b, 0, tArr, 0, this.f195c);
        int length = tArr.length;
        int i5 = this.f195c;
        if (length > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f195c * 14);
        sb.append('{');
        for (int i5 = 0; i5 < this.f195c; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            E o5 = o(i5);
            if (o5 != this) {
                sb.append(o5);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
