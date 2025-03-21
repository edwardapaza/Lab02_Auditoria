package t3;

import com.google.android.gms.common.api.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class f<E> extends d<E> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f7619d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f7620e = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    private int f7621a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f7622b = f7620e;

    /* renamed from: c  reason: collision with root package name */
    private int f7623c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final int a(int i5, int i6) {
            int i7 = i5 + (i5 >> 1);
            if (i7 - i6 < 0) {
                i7 = i6;
            }
            if (i7 - 2147483639 > 0) {
                if (i6 > 2147483639) {
                    return a.e.API_PRIORITY_OTHER;
                }
                return 2147483639;
            }
            return i7;
        }
    }

    private final void i(int i5, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f7622b.length;
        while (i5 < length && it.hasNext()) {
            this.f7622b[i5] = it.next();
            i5++;
        }
        int i6 = this.f7621a;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f7622b[i7] = it.next();
        }
        this.f7623c = size() + collection.size();
    }

    private final void k(int i5) {
        Object[] objArr = new Object[i5];
        Object[] objArr2 = this.f7622b;
        j.d(objArr2, objArr, 0, this.f7621a, objArr2.length);
        Object[] objArr3 = this.f7622b;
        int length = objArr3.length;
        int i6 = this.f7621a;
        j.d(objArr3, objArr, length - i6, 0, i6);
        this.f7621a = 0;
        this.f7622b = objArr;
    }

    private final int l(int i5) {
        return i5 == 0 ? k.k(this.f7622b) : i5 - 1;
    }

    private final void m(int i5) {
        int a5;
        if (i5 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f7622b;
        if (i5 <= objArr.length) {
            return;
        }
        if (objArr != f7620e) {
            k(f7619d.a(objArr.length, i5));
            return;
        }
        a5 = h4.l.a(i5, 10);
        this.f7622b = new Object[a5];
    }

    private final int n(int i5) {
        if (i5 == k.k(this.f7622b)) {
            return 0;
        }
        return i5 + 1;
    }

    private final int o(int i5) {
        return i5 < 0 ? i5 + this.f7622b.length : i5;
    }

    private final int p(int i5) {
        Object[] objArr = this.f7622b;
        return i5 >= objArr.length ? i5 - objArr.length : i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e5) {
        c.f7610a.b(i5, size());
        if (i5 == size()) {
            addLast(e5);
        } else if (i5 == 0) {
            addFirst(e5);
        } else {
            m(size() + 1);
            int p5 = p(this.f7621a + i5);
            if (i5 < ((size() + 1) >> 1)) {
                int l5 = l(p5);
                int l6 = l(this.f7621a);
                int i6 = this.f7621a;
                if (l5 >= i6) {
                    Object[] objArr = this.f7622b;
                    objArr[l6] = objArr[i6];
                    j.d(objArr, objArr, i6, i6 + 1, l5 + 1);
                } else {
                    Object[] objArr2 = this.f7622b;
                    j.d(objArr2, objArr2, i6 - 1, i6, objArr2.length);
                    Object[] objArr3 = this.f7622b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    j.d(objArr3, objArr3, 0, 1, l5 + 1);
                }
                this.f7622b[l5] = e5;
                this.f7621a = l6;
            } else {
                int p6 = p(this.f7621a + size());
                Object[] objArr4 = this.f7622b;
                if (p5 < p6) {
                    j.d(objArr4, objArr4, p5 + 1, p5, p6);
                } else {
                    j.d(objArr4, objArr4, 1, 0, p6);
                    Object[] objArr5 = this.f7622b;
                    objArr5[0] = objArr5[objArr5.length - 1];
                    j.d(objArr5, objArr5, p5 + 1, p5, objArr5.length - 1);
                }
                this.f7622b[p5] = e5;
            }
            this.f7623c = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e5) {
        addLast(e5);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        e4.k.e(collection, "elements");
        c.f7610a.b(i5, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i5 == size()) {
            return addAll(collection);
        }
        m(size() + collection.size());
        int p5 = p(this.f7621a + size());
        int p6 = p(this.f7621a + i5);
        int size = collection.size();
        if (i5 < ((size() + 1) >> 1)) {
            int i6 = this.f7621a;
            int i7 = i6 - size;
            if (p6 < i6) {
                Object[] objArr = this.f7622b;
                j.d(objArr, objArr, i7, i6, objArr.length);
                Object[] objArr2 = this.f7622b;
                if (size >= p6) {
                    j.d(objArr2, objArr2, objArr2.length - size, 0, p6);
                } else {
                    j.d(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f7622b;
                    j.d(objArr3, objArr3, 0, size, p6);
                }
            } else if (i7 >= 0) {
                Object[] objArr4 = this.f7622b;
                j.d(objArr4, objArr4, i7, i6, p6);
            } else {
                Object[] objArr5 = this.f7622b;
                i7 += objArr5.length;
                int i8 = p6 - i6;
                int length = objArr5.length - i7;
                if (length >= i8) {
                    j.d(objArr5, objArr5, i7, i6, p6);
                } else {
                    j.d(objArr5, objArr5, i7, i6, i6 + length);
                    Object[] objArr6 = this.f7622b;
                    j.d(objArr6, objArr6, 0, this.f7621a + length, p6);
                }
            }
            this.f7621a = i7;
            i(o(p6 - size), collection);
        } else {
            int i9 = p6 + size;
            if (p6 < p5) {
                int i10 = size + p5;
                Object[] objArr7 = this.f7622b;
                if (i10 > objArr7.length) {
                    if (i9 >= objArr7.length) {
                        i9 -= objArr7.length;
                    } else {
                        int length2 = p5 - (i10 - objArr7.length);
                        j.d(objArr7, objArr7, 0, length2, p5);
                        Object[] objArr8 = this.f7622b;
                        j.d(objArr8, objArr8, i9, p6, length2);
                    }
                }
                j.d(objArr7, objArr7, i9, p6, p5);
            } else {
                Object[] objArr9 = this.f7622b;
                j.d(objArr9, objArr9, size, 0, p5);
                Object[] objArr10 = this.f7622b;
                if (i9 >= objArr10.length) {
                    j.d(objArr10, objArr10, i9 - objArr10.length, p6, objArr10.length);
                } else {
                    j.d(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f7622b;
                    j.d(objArr11, objArr11, i9, p6, objArr11.length - size);
                }
            }
            i(p6, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        e4.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        m(size() + collection.size());
        i(p(this.f7621a + size()), collection);
        return true;
    }

    public final void addFirst(E e5) {
        m(size() + 1);
        int l5 = l(this.f7621a);
        this.f7621a = l5;
        this.f7622b[l5] = e5;
        this.f7623c = size() + 1;
    }

    public final void addLast(E e5) {
        m(size() + 1);
        this.f7622b[p(this.f7621a + size())] = e5;
        this.f7623c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int p5 = p(this.f7621a + size());
        int i5 = this.f7621a;
        if (i5 < p5) {
            j.f(this.f7622b, null, i5, p5);
        } else if (!isEmpty()) {
            Object[] objArr = this.f7622b;
            j.f(objArr, null, this.f7621a, objArr.length);
            j.f(this.f7622b, null, 0, p5);
        }
        this.f7621a = 0;
        this.f7623c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // t3.d
    public int g() {
        return this.f7623c;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        c.f7610a.a(i5, size());
        return (E) this.f7622b[p(this.f7621a + i5)];
    }

    @Override // t3.d
    public E h(int i5) {
        int g5;
        int g6;
        c.f7610a.a(i5, size());
        g5 = p.g(this);
        if (i5 == g5) {
            return removeLast();
        }
        if (i5 == 0) {
            return removeFirst();
        }
        int p5 = p(this.f7621a + i5);
        E e5 = (E) this.f7622b[p5];
        if (i5 < (size() >> 1)) {
            int i6 = this.f7621a;
            if (p5 >= i6) {
                Object[] objArr = this.f7622b;
                j.d(objArr, objArr, i6 + 1, i6, p5);
            } else {
                Object[] objArr2 = this.f7622b;
                j.d(objArr2, objArr2, 1, 0, p5);
                Object[] objArr3 = this.f7622b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i7 = this.f7621a;
                j.d(objArr3, objArr3, i7 + 1, i7, objArr3.length - 1);
            }
            Object[] objArr4 = this.f7622b;
            int i8 = this.f7621a;
            objArr4[i8] = null;
            this.f7621a = n(i8);
        } else {
            int i9 = this.f7621a;
            g6 = p.g(this);
            int p6 = p(i9 + g6);
            Object[] objArr5 = this.f7622b;
            if (p5 <= p6) {
                j.d(objArr5, objArr5, p5, p5 + 1, p6 + 1);
            } else {
                j.d(objArr5, objArr5, p5, p5 + 1, objArr5.length);
                Object[] objArr6 = this.f7622b;
                objArr6[objArr6.length - 1] = objArr6[0];
                j.d(objArr6, objArr6, 0, 1, p6 + 1);
            }
            this.f7622b[p6] = null;
        }
        this.f7623c = size() - 1;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int p5 = p(this.f7621a + size());
        int i5 = this.f7621a;
        if (i5 < p5) {
            while (i5 < p5) {
                if (!e4.k.a(obj, this.f7622b[i5])) {
                    i5++;
                }
            }
            return -1;
        } else if (i5 < p5) {
            return -1;
        } else {
            int length = this.f7622b.length;
            while (true) {
                if (i5 >= length) {
                    for (int i6 = 0; i6 < p5; i6++) {
                        if (e4.k.a(obj, this.f7622b[i6])) {
                            i5 = i6 + this.f7622b.length;
                        }
                    }
                    return -1;
                } else if (e4.k.a(obj, this.f7622b[i5])) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        return i5 - this.f7621a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int k5;
        int p5 = p(this.f7621a + size());
        int i5 = this.f7621a;
        if (i5 < p5) {
            k5 = p5 - 1;
            if (i5 <= k5) {
                while (!e4.k.a(obj, this.f7622b[k5])) {
                    if (k5 != i5) {
                        k5--;
                    }
                }
                return k5 - this.f7621a;
            }
            return -1;
        }
        if (i5 > p5) {
            int i6 = p5 - 1;
            while (true) {
                if (-1 >= i6) {
                    k5 = k.k(this.f7622b);
                    int i7 = this.f7621a;
                    if (i7 <= k5) {
                        while (!e4.k.a(obj, this.f7622b[k5])) {
                            if (k5 != i7) {
                                k5--;
                            }
                        }
                    }
                } else if (e4.k.a(obj, this.f7622b[i6])) {
                    k5 = i6 + this.f7622b.length;
                    break;
                } else {
                    i6--;
                }
            }
        }
        return -1;
    }

    public final E q() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        int p5;
        e4.k.e(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty()) {
            if (!(this.f7622b.length == 0)) {
                int p6 = p(this.f7621a + size());
                int i5 = this.f7621a;
                if (i5 < p6) {
                    p5 = i5;
                    while (i5 < p6) {
                        Object obj = this.f7622b[i5];
                        if (!collection.contains(obj)) {
                            this.f7622b[p5] = obj;
                            p5++;
                        } else {
                            z4 = true;
                        }
                        i5++;
                    }
                    j.f(this.f7622b, null, p5, p6);
                } else {
                    int length = this.f7622b.length;
                    int i6 = i5;
                    boolean z5 = false;
                    while (i5 < length) {
                        Object[] objArr = this.f7622b;
                        Object obj2 = objArr[i5];
                        objArr[i5] = null;
                        if (!collection.contains(obj2)) {
                            this.f7622b[i6] = obj2;
                            i6++;
                        } else {
                            z5 = true;
                        }
                        i5++;
                    }
                    p5 = p(i6);
                    for (int i7 = 0; i7 < p6; i7++) {
                        Object[] objArr2 = this.f7622b;
                        Object obj3 = objArr2[i7];
                        objArr2[i7] = null;
                        if (!collection.contains(obj3)) {
                            this.f7622b[p5] = obj3;
                            p5 = n(p5);
                        } else {
                            z5 = true;
                        }
                    }
                    z4 = z5;
                }
                if (z4) {
                    this.f7623c = o(p5 - this.f7621a);
                }
            }
        }
        return z4;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f7622b;
        int i5 = this.f7621a;
        E e5 = (E) objArr[i5];
        objArr[i5] = null;
        this.f7621a = n(i5);
        this.f7623c = size() - 1;
        return e5;
    }

    public final E removeLast() {
        int g5;
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i5 = this.f7621a;
        g5 = p.g(this);
        int p5 = p(i5 + g5);
        Object[] objArr = this.f7622b;
        E e5 = (E) objArr[p5];
        objArr[p5] = null;
        this.f7623c = size() - 1;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        int p5;
        e4.k.e(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty()) {
            if (!(this.f7622b.length == 0)) {
                int p6 = p(this.f7621a + size());
                int i5 = this.f7621a;
                if (i5 < p6) {
                    p5 = i5;
                    while (i5 < p6) {
                        Object obj = this.f7622b[i5];
                        if (collection.contains(obj)) {
                            this.f7622b[p5] = obj;
                            p5++;
                        } else {
                            z4 = true;
                        }
                        i5++;
                    }
                    j.f(this.f7622b, null, p5, p6);
                } else {
                    int length = this.f7622b.length;
                    int i6 = i5;
                    boolean z5 = false;
                    while (i5 < length) {
                        Object[] objArr = this.f7622b;
                        Object obj2 = objArr[i5];
                        objArr[i5] = null;
                        if (collection.contains(obj2)) {
                            this.f7622b[i6] = obj2;
                            i6++;
                        } else {
                            z5 = true;
                        }
                        i5++;
                    }
                    p5 = p(i6);
                    for (int i7 = 0; i7 < p6; i7++) {
                        Object[] objArr2 = this.f7622b;
                        Object obj3 = objArr2[i7];
                        objArr2[i7] = null;
                        if (collection.contains(obj3)) {
                            this.f7622b[p5] = obj3;
                            p5 = n(p5);
                        } else {
                            z5 = true;
                        }
                    }
                    z4 = z5;
                }
                if (z4) {
                    this.f7623c = o(p5 - this.f7621a);
                }
            }
        }
        return z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e5) {
        c.f7610a.a(i5, size());
        int p5 = p(this.f7621a + i5);
        Object[] objArr = this.f7622b;
        E e6 = (E) objArr[p5];
        objArr[p5] = e5;
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        e4.k.e(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) h.a(tArr, size());
        }
        int p5 = p(this.f7621a + size());
        int i5 = this.f7621a;
        if (i5 < p5) {
            j.e(this.f7622b, tArr, 0, i5, p5, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f7622b;
            j.d(objArr, tArr, 0, this.f7621a, objArr.length);
            Object[] objArr2 = this.f7622b;
            j.d(objArr2, tArr, objArr2.length - this.f7621a, 0, p5);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }
}
