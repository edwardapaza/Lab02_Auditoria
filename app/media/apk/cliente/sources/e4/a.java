package e4;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
final class a<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f2915a;

    /* renamed from: b  reason: collision with root package name */
    private int f2916b;

    public a(T[] tArr) {
        k.e(tArr, "array");
        this.f2915a = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2916b < this.f2915a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f2915a;
            int i5 = this.f2916b;
            this.f2916b = i5 + 1;
            return tArr[i5];
        } catch (ArrayIndexOutOfBoundsException e5) {
            this.f2916b--;
            throw new NoSuchElementException(e5.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
