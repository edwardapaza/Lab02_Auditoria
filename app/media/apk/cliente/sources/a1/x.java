package a1;
/* loaded from: classes.dex */
final class x<E> extends l<E> {

    /* renamed from: c  reason: collision with root package name */
    final transient E f63c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(E e5) {
        this.f63c = (E) z0.k.n(e5);
    }

    @Override // a1.i, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f63c.equals(obj);
    }

    @Override // a1.i
    int g(Object[] objArr, int i5) {
        objArr[i5] = this.f63c;
        return i5 + 1;
    }

    @Override // a1.l, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f63c.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public boolean l() {
        return false;
    }

    @Override // a1.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: m */
    public z<E> iterator() {
        return m.b(this.f63c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f63c.toString() + ']';
    }
}
