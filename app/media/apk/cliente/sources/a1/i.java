package a1;

import com.google.android.gms.common.api.a;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
/* loaded from: classes.dex */
public abstract class i<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f12a = new Object[0];

    /* loaded from: classes.dex */
    static abstract class a<E> extends b<E> {

        /* renamed from: a  reason: collision with root package name */
        Object[] f13a;

        /* renamed from: b  reason: collision with root package name */
        int f14b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i5) {
            c.b(i5, "initialCapacity");
            this.f13a = new Object[i5];
            this.f14b = 0;
        }

        private void c(int i5) {
            Object[] objArr = this.f13a;
            if (objArr.length < i5) {
                this.f13a = Arrays.copyOf(objArr, b.a(objArr.length, i5));
            } else if (!this.f15c) {
                return;
            } else {
                this.f13a = (Object[]) objArr.clone();
            }
            this.f15c = false;
        }

        public a<E> b(E e5) {
            z0.k.n(e5);
            c(this.f14b + 1);
            Object[] objArr = this.f13a;
            int i5 = this.f14b;
            this.f14b = i5 + 1;
            objArr[i5] = e5;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<E> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int a(int i5, int i6) {
            if (i6 >= 0) {
                int i7 = i5 + (i5 >> 1) + 1;
                if (i7 < i6) {
                    i7 = Integer.highestOneBit(i6 - 1) << 1;
                }
                return i7 < 0 ? a.e.API_PRIORITY_OTHER : i7;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    int g(Object[] objArr, int i5) {
        z<E> m5 = m();
        while (m5.hasNext()) {
            objArr[i5] = m5.next();
            i5++;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] h() {
        return null;
    }

    int i() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean l();

    public abstract z<E> m();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f12a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        z0.k.n(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] h5 = h();
            if (h5 != null) {
                return (T[]) s.a(h5, k(), i(), tArr);
            }
            tArr = (T[]) q.b(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        g(tArr, 0);
        return tArr;
    }
}
