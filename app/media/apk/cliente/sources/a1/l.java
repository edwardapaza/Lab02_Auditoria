package a1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes.dex */
public abstract class l<E> extends i<E> implements Set<E> {

    /* renamed from: b  reason: collision with root package name */
    private transient j<E> f33b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i5) {
        int max = Math.max(i5, 2);
        if (max >= 751619276) {
            z0.k.e(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * 0.7d < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    private static <E> l<E> p(int i5, Object... objArr) {
        if (i5 != 0) {
            if (i5 == 1) {
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                return u(obj);
            }
            int o5 = o(i5);
            Object[] objArr2 = new Object[o5];
            int i6 = o5 - 1;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                Object a5 = q.a(objArr[i9], i9);
                int hashCode = a5.hashCode();
                int a6 = h.a(hashCode);
                while (true) {
                    int i10 = a6 & i6;
                    Object obj2 = objArr2[i10];
                    if (obj2 == null) {
                        objArr[i8] = a5;
                        objArr2[i10] = a5;
                        i7 += hashCode;
                        i8++;
                        break;
                    } else if (obj2.equals(a5)) {
                        break;
                    } else {
                        a6++;
                    }
                }
            }
            Arrays.fill(objArr, i8, i5, (Object) null);
            if (i8 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                return new x(obj3);
            } else if (o(i8) < o5 / 2) {
                return p(i8, objArr);
            } else {
                if (v(i8, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i8);
                }
                return new v(objArr, i7, objArr2, i6, i8);
            }
        }
        return t();
    }

    public static <E> l<E> q(Collection<? extends E> collection) {
        if ((collection instanceof l) && !(collection instanceof SortedSet)) {
            l<E> lVar = (l) collection;
            if (!lVar.l()) {
                return lVar;
            }
        }
        Object[] array = collection.toArray();
        return p(array.length, array);
    }

    public static <E> l<E> t() {
        return v.f57m;
    }

    public static <E> l<E> u(E e5) {
        return new x(e5);
    }

    private static boolean v(int i5, int i6) {
        return i5 < (i6 >> 1) + (i6 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof l) && s() && ((l) obj).s() && hashCode() != obj.hashCode()) {
            return false;
        }
        return w.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return w.b(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: m */
    public abstract z<E> iterator();

    public j<E> n() {
        j<E> jVar = this.f33b;
        if (jVar == null) {
            j<E> r5 = r();
            this.f33b = r5;
            return r5;
        }
        return jVar;
    }

    j<E> r() {
        return j.n(toArray());
    }

    boolean s() {
        return false;
    }
}
