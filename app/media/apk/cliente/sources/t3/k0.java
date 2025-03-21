package t3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k0<T> extends c<T> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f7624b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7625c;

    /* renamed from: d  reason: collision with root package name */
    private int f7626d;

    /* renamed from: e  reason: collision with root package name */
    private int f7627e;

    /* loaded from: classes.dex */
    public static final class a extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        private int f7628c;

        /* renamed from: d  reason: collision with root package name */
        private int f7629d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k0<T> f7630e;

        a(k0<T> k0Var) {
            this.f7630e = k0Var;
            this.f7628c = k0Var.size();
            this.f7629d = ((k0) k0Var).f7626d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // t3.b
        protected void b() {
            if (this.f7628c == 0) {
                c();
                return;
            }
            d(((k0) this.f7630e).f7624b[this.f7629d]);
            this.f7629d = (this.f7629d + 1) % ((k0) this.f7630e).f7625c;
            this.f7628c--;
        }
    }

    public k0(int i5) {
        this(new Object[i5], 0);
    }

    public k0(Object[] objArr, int i5) {
        e4.k.e(objArr, "buffer");
        this.f7624b = objArr;
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i5).toString());
        }
        if (i5 <= objArr.length) {
            this.f7625c = objArr.length;
            this.f7627e = i5;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i5 + " cannot be larger than the buffer size: " + objArr.length).toString());
    }

    @Override // t3.a
    public int g() {
        return this.f7627e;
    }

    @Override // t3.c, java.util.List
    public T get(int i5) {
        c.f7610a.a(i5, size());
        return (T) this.f7624b[(this.f7626d + i5) % this.f7625c];
    }

    @Override // t3.c, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void l(T t5) {
        if (n()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f7624b[(this.f7626d + size()) % this.f7625c] = t5;
        this.f7627e = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k0<T> m(int i5) {
        int c5;
        Object[] array;
        int i6 = this.f7625c;
        c5 = h4.l.c(i6 + (i6 >> 1) + 1, i5);
        if (this.f7626d == 0) {
            array = Arrays.copyOf(this.f7624b, c5);
            e4.k.d(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[c5]);
        }
        return new k0<>(array, size());
    }

    public final boolean n() {
        return size() == this.f7625c;
    }

    public final void o(int i5) {
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i5).toString());
        }
        if (!(i5 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i5 + ", size = " + size()).toString());
        } else if (i5 > 0) {
            int i6 = this.f7626d;
            int i7 = (i6 + i5) % this.f7625c;
            if (i6 > i7) {
                j.f(this.f7624b, null, i6, this.f7625c);
                j.f(this.f7624b, null, 0, i7);
            } else {
                j.f(this.f7624b, null, i6, i7);
            }
            this.f7626d = i7;
            this.f7627e = size() - i5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        e4.k.e(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            e4.k.d(tArr, "copyOf(this, newSize)");
        }
        int size = size();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = this.f7626d; i6 < size && i7 < this.f7625c; i7++) {
            tArr[i6] = this.f7624b[i7];
            i6++;
        }
        while (i6 < size) {
            tArr[i6] = this.f7624b[i5];
            i6++;
            i5++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }
}
