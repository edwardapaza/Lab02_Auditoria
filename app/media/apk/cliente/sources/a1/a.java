package a1;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
abstract class a<E> extends a0<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7a;

    /* renamed from: b  reason: collision with root package name */
    private int f8b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i5, int i6) {
        z0.k.q(i6, i5);
        this.f7a = i5;
        this.f8b = i6;
    }

    protected abstract E b(int i5);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f8b < this.f7a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f8b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i5 = this.f8b;
            this.f8b = i5 + 1;
            return b(i5);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f8b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i5 = this.f8b - 1;
            this.f8b = i5;
            return b(i5);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f8b - 1;
    }
}
