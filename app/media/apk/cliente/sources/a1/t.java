package a1;

import java.util.Objects;
/* loaded from: classes.dex */
class t<E> extends j<E> {

    /* renamed from: e  reason: collision with root package name */
    static final j<Object> f39e = new t(new Object[0], 0);

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f40c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f41d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object[] objArr, int i5) {
        this.f40c = objArr;
        this.f41d = i5;
    }

    @Override // a1.j, a1.i
    int g(Object[] objArr, int i5) {
        System.arraycopy(this.f40c, 0, objArr, i5, this.f41d);
        return i5 + this.f41d;
    }

    @Override // java.util.List
    public E get(int i5) {
        z0.k.l(i5, this.f41d);
        E e5 = (E) this.f40c[i5];
        Objects.requireNonNull(e5);
        return e5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public Object[] h() {
        return this.f40c;
    }

    @Override // a1.i
    int i() {
        return this.f41d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public int k() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41d;
    }
}
