package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class f<K, V> {

    /* renamed from: d  reason: collision with root package name */
    static Object[] f216d;

    /* renamed from: e  reason: collision with root package name */
    static int f217e;

    /* renamed from: f  reason: collision with root package name */
    static Object[] f218f;

    /* renamed from: k  reason: collision with root package name */
    static int f219k;

    /* renamed from: a  reason: collision with root package name */
    int[] f220a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f221b;

    /* renamed from: c  reason: collision with root package name */
    int f222c;

    public f() {
        this.f220a = c.f198a;
        this.f221b = c.f200c;
        this.f222c = 0;
    }

    public f(int i5) {
        if (i5 == 0) {
            this.f220a = c.f198a;
            this.f221b = c.f200c;
        } else {
            a(i5);
        }
        this.f222c = 0;
    }

    private void a(int i5) {
        if (i5 == 8) {
            synchronized (f.class) {
                Object[] objArr = f218f;
                if (objArr != null) {
                    this.f221b = objArr;
                    f218f = (Object[]) objArr[0];
                    this.f220a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f219k--;
                    return;
                }
            }
        } else if (i5 == 4) {
            synchronized (f.class) {
                Object[] objArr2 = f216d;
                if (objArr2 != null) {
                    this.f221b = objArr2;
                    f216d = (Object[]) objArr2[0];
                    this.f220a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f217e--;
                    return;
                }
            }
        }
        this.f220a = new int[i5];
        this.f221b = new Object[i5 << 1];
    }

    private static int b(int[] iArr, int i5, int i6) {
        try {
            return c.a(iArr, i5, i6);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (f.class) {
                if (f219k < 10) {
                    objArr[0] = f218f;
                    objArr[1] = iArr;
                    for (int i6 = (i5 << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f218f = objArr;
                    f219k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (f.class) {
                if (f217e < 10) {
                    objArr[0] = f216d;
                    objArr[1] = iArr;
                    for (int i7 = (i5 << 1) - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f216d = objArr;
                    f217e++;
                }
            }
        }
    }

    public void c(int i5) {
        int i6 = this.f222c;
        int[] iArr = this.f220a;
        if (iArr.length < i5) {
            Object[] objArr = this.f221b;
            a(i5);
            if (this.f222c > 0) {
                System.arraycopy(iArr, 0, this.f220a, 0, i6);
                System.arraycopy(objArr, 0, this.f221b, 0, i6 << 1);
            }
            d(iArr, objArr, i6);
        }
        if (this.f222c != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i5 = this.f222c;
        if (i5 > 0) {
            int[] iArr = this.f220a;
            Object[] objArr = this.f221b;
            this.f220a = c.f198a;
            this.f221b = c.f200c;
            this.f222c = 0;
            d(iArr, objArr, i5);
        }
        if (this.f222c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i5) {
        int i6 = this.f222c;
        if (i6 == 0) {
            return -1;
        }
        int b5 = b(this.f220a, i6, i5);
        if (b5 >= 0 && !obj.equals(this.f221b[b5 << 1])) {
            int i7 = b5 + 1;
            while (i7 < i6 && this.f220a[i7] == i5) {
                if (obj.equals(this.f221b[i7 << 1])) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = b5 - 1; i8 >= 0 && this.f220a[i8] == i5; i8--) {
                if (obj.equals(this.f221b[i8 << 1])) {
                    return i8;
                }
            }
            return ~i7;
        }
        return b5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (size() != fVar.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f222c; i5++) {
                try {
                    K i6 = i(i5);
                    V l5 = l(i5);
                    Object obj2 = fVar.get(i6);
                    if (l5 == null) {
                        if (obj2 != null || !fVar.containsKey(i6)) {
                            return false;
                        }
                    } else if (!l5.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i7 = 0; i7 < this.f222c; i7++) {
                try {
                    K i8 = i(i7);
                    V l6 = l(i7);
                    Object obj3 = map.get(i8);
                    if (l6 == null) {
                        if (obj3 != null || !map.containsKey(i8)) {
                            return false;
                        }
                    } else if (!l6.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i5 = this.f222c;
        if (i5 == 0) {
            return -1;
        }
        int b5 = b(this.f220a, i5, 0);
        if (b5 >= 0 && this.f221b[b5 << 1] != null) {
            int i6 = b5 + 1;
            while (i6 < i5 && this.f220a[i6] == 0) {
                if (this.f221b[i6 << 1] == null) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = b5 - 1; i7 >= 0 && this.f220a[i7] == 0; i7--) {
                if (this.f221b[i7 << 1] == null) {
                    return i7;
                }
            }
            return ~i6;
        }
        return b5;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v5) {
        int f5 = f(obj);
        return f5 >= 0 ? (V) this.f221b[(f5 << 1) + 1] : v5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object obj) {
        int i5 = this.f222c * 2;
        Object[] objArr = this.f221b;
        if (obj == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (obj.equals(objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f220a;
        Object[] objArr = this.f221b;
        int i5 = this.f222c;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            i8 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return i8;
    }

    public K i(int i5) {
        return (K) this.f221b[i5 << 1];
    }

    public boolean isEmpty() {
        return this.f222c <= 0;
    }

    public V j(int i5) {
        Object[] objArr = this.f221b;
        int i6 = i5 << 1;
        V v5 = (V) objArr[i6 + 1];
        int i7 = this.f222c;
        int i8 = 0;
        if (i7 <= 1) {
            d(this.f220a, objArr, i7);
            this.f220a = c.f198a;
            this.f221b = c.f200c;
        } else {
            int i9 = i7 - 1;
            int[] iArr = this.f220a;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                if (i5 < i9) {
                    int i10 = i5 + 1;
                    int i11 = i9 - i5;
                    System.arraycopy(iArr, i10, iArr, i5, i11);
                    Object[] objArr2 = this.f221b;
                    System.arraycopy(objArr2, i10 << 1, objArr2, i6, i11 << 1);
                }
                Object[] objArr3 = this.f221b;
                int i12 = i9 << 1;
                objArr3[i12] = null;
                objArr3[i12 + 1] = null;
            } else {
                a(i7 > 8 ? i7 + (i7 >> 1) : 8);
                if (i7 != this.f222c) {
                    throw new ConcurrentModificationException();
                }
                if (i5 > 0) {
                    System.arraycopy(iArr, 0, this.f220a, 0, i5);
                    System.arraycopy(objArr, 0, this.f221b, 0, i6);
                }
                if (i5 < i9) {
                    int i13 = i5 + 1;
                    int i14 = i9 - i5;
                    System.arraycopy(iArr, i13, this.f220a, i5, i14);
                    System.arraycopy(objArr, i13 << 1, this.f221b, i6, i14 << 1);
                }
            }
            i8 = i9;
        }
        if (i7 == this.f222c) {
            this.f222c = i8;
            return v5;
        }
        throw new ConcurrentModificationException();
    }

    public V k(int i5, V v5) {
        int i6 = (i5 << 1) + 1;
        Object[] objArr = this.f221b;
        V v6 = (V) objArr[i6];
        objArr[i6] = v5;
        return v6;
    }

    public V l(int i5) {
        return (V) this.f221b[(i5 << 1) + 1];
    }

    public V put(K k5, V v5) {
        int i5;
        int e5;
        int i6 = this.f222c;
        if (k5 == null) {
            e5 = g();
            i5 = 0;
        } else {
            int hashCode = k5.hashCode();
            i5 = hashCode;
            e5 = e(k5, hashCode);
        }
        if (e5 >= 0) {
            int i7 = (e5 << 1) + 1;
            Object[] objArr = this.f221b;
            V v6 = (V) objArr[i7];
            objArr[i7] = v5;
            return v6;
        }
        int i8 = ~e5;
        int[] iArr = this.f220a;
        if (i6 >= iArr.length) {
            int i9 = 4;
            if (i6 >= 8) {
                i9 = (i6 >> 1) + i6;
            } else if (i6 >= 4) {
                i9 = 8;
            }
            Object[] objArr2 = this.f221b;
            a(i9);
            if (i6 != this.f222c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f220a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f221b, 0, objArr2.length);
            }
            d(iArr, objArr2, i6);
        }
        if (i8 < i6) {
            int[] iArr3 = this.f220a;
            int i10 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i10, i6 - i8);
            Object[] objArr3 = this.f221b;
            System.arraycopy(objArr3, i8 << 1, objArr3, i10 << 1, (this.f222c - i8) << 1);
        }
        int i11 = this.f222c;
        if (i6 == i11) {
            int[] iArr4 = this.f220a;
            if (i8 < iArr4.length) {
                iArr4[i8] = i5;
                Object[] objArr4 = this.f221b;
                int i12 = i8 << 1;
                objArr4[i12] = k5;
                objArr4[i12 + 1] = v5;
                this.f222c = i11 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k5, V v5) {
        V v6 = get(k5);
        return v6 == null ? put(k5, v5) : v6;
    }

    public V remove(Object obj) {
        int f5 = f(obj);
        if (f5 >= 0) {
            return j(f5);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f5 = f(obj);
        if (f5 >= 0) {
            V l5 = l(f5);
            if (obj2 == l5 || (obj2 != null && obj2.equals(l5))) {
                j(f5);
                return true;
            }
            return false;
        }
        return false;
    }

    public V replace(K k5, V v5) {
        int f5 = f(k5);
        if (f5 >= 0) {
            return k(f5, v5);
        }
        return null;
    }

    public boolean replace(K k5, V v5, V v6) {
        int f5 = f(k5);
        if (f5 >= 0) {
            V l5 = l(f5);
            if (l5 == v5 || (v5 != null && v5.equals(l5))) {
                k(f5, v6);
                return true;
            }
            return false;
        }
        return false;
    }

    public int size() {
        return this.f222c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f222c * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f222c; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            K i6 = i(i5);
            if (i6 != this) {
                sb.append(i6);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l5 = l(i5);
            if (l5 != this) {
                sb.append(l5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
