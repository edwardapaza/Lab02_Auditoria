package r4;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import r4.o0;
/* loaded from: classes.dex */
public class n0<T extends o0 & Comparable<? super T>> {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f7212b = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    private T[] f7213a;

    private final T[] f() {
        T[] tArr = this.f7213a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new o0[4];
            this.f7213a = tArr2;
            return tArr2;
        } else if (c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            e4.k.d(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((o0[]) copyOf);
            this.f7213a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void j(int i5) {
        f7212b.set(this, i5);
    }

    private final void k(int i5) {
        while (true) {
            int i6 = (i5 * 2) + 1;
            if (i6 >= c()) {
                return;
            }
            T[] tArr = this.f7213a;
            e4.k.b(tArr);
            int i7 = i6 + 1;
            if (i7 < c()) {
                T t5 = tArr[i7];
                e4.k.b(t5);
                T t6 = tArr[i6];
                e4.k.b(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    i6 = i7;
                }
            }
            T t7 = tArr[i5];
            e4.k.b(t7);
            T t8 = tArr[i6];
            e4.k.b(t8);
            if (((Comparable) t7).compareTo(t8) <= 0) {
                return;
            }
            m(i5, i6);
            i5 = i6;
        }
    }

    private final void l(int i5) {
        while (i5 > 0) {
            T[] tArr = this.f7213a;
            e4.k.b(tArr);
            int i6 = (i5 - 1) / 2;
            T t5 = tArr[i6];
            e4.k.b(t5);
            T t6 = tArr[i5];
            e4.k.b(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            m(i5, i6);
            i5 = i6;
        }
    }

    private final void m(int i5, int i6) {
        T[] tArr = this.f7213a;
        e4.k.b(tArr);
        T t5 = tArr[i6];
        e4.k.b(t5);
        T t6 = tArr[i5];
        e4.k.b(t6);
        tArr[i5] = t5;
        tArr[i6] = t6;
        t5.setIndex(i5);
        t6.setIndex(i6);
    }

    public final void a(T t5) {
        t5.c(this);
        T[] f5 = f();
        int c5 = c();
        j(c5 + 1);
        f5[c5] = t5;
        t5.setIndex(c5);
        l(c5);
    }

    public final T b() {
        T[] tArr = this.f7213a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f7212b.get(this);
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b5;
        synchronized (this) {
            b5 = b();
        }
        return b5;
    }

    public final boolean g(T t5) {
        boolean z4;
        synchronized (this) {
            if (t5.d() == null) {
                z4 = false;
            } else {
                h(t5.getIndex());
                z4 = true;
            }
        }
        return z4;
    }

    public final T h(int i5) {
        T[] tArr = this.f7213a;
        e4.k.b(tArr);
        j(c() - 1);
        if (i5 < c()) {
            m(i5, c());
            int i6 = (i5 - 1) / 2;
            if (i5 > 0) {
                T t5 = tArr[i5];
                e4.k.b(t5);
                T t6 = tArr[i6];
                e4.k.b(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    m(i5, i6);
                    l(i6);
                }
            }
            k(i5);
        }
        T t7 = tArr[c()];
        e4.k.b(t7);
        t7.c(null);
        t7.setIndex(-1);
        tArr[c()] = null;
        return t7;
    }

    public final T i() {
        T h5;
        synchronized (this) {
            h5 = c() > 0 ? h(0) : null;
        }
        return h5;
    }
}
