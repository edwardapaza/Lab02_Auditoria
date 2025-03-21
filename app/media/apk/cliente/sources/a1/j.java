package a1;

import a1.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public abstract class j<E> extends i<E> implements List<E>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final a0<Object> f16b = new b(t.f39e, 0);

    /* loaded from: classes.dex */
    public static final class a<E> extends i.a<E> {
        public a() {
            this(4);
        }

        a(int i5) {
            super(i5);
        }

        public a<E> d(E e5) {
            super.b(e5);
            return this;
        }

        public j<E> e() {
            this.f15c = true;
            return j.o(this.f13a, this.f14b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b<E> extends a1.a<E> {

        /* renamed from: c  reason: collision with root package name */
        private final j<E> f17c;

        b(j<E> jVar, int i5) {
            super(jVar.size(), i5);
            this.f17c = jVar;
        }

        @Override // a1.a
        protected E b(int i5) {
            return this.f17c.get(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends j<E> {

        /* renamed from: c  reason: collision with root package name */
        final transient int f18c;

        /* renamed from: d  reason: collision with root package name */
        final transient int f19d;

        c(int i5, int i6) {
            this.f18c = i5;
            this.f19d = i6;
        }

        @Override // java.util.List
        public E get(int i5) {
            z0.k.l(i5, this.f19d);
            return j.this.get(i5 + this.f18c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a1.i
        public Object[] h() {
            return j.this.h();
        }

        @Override // a1.i
        int i() {
            return j.this.k() + this.f18c + this.f19d;
        }

        @Override // a1.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a1.i
        public int k() {
            return j.this.k() + this.f18c;
        }

        @Override // a1.j, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // a1.j, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i5) {
            return super.listIterator(i5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f19d;
        }

        @Override // a1.j, java.util.List
        /* renamed from: t */
        public j<E> subList(int i5, int i6) {
            z0.k.s(i5, i6, this.f19d);
            j jVar = j.this;
            int i7 = this.f18c;
            return jVar.subList(i5 + i7, i6 + i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> j<E> n(Object[] objArr) {
        return o(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> j<E> o(Object[] objArr, int i5) {
        return i5 == 0 ? s() : new t(objArr, i5);
    }

    public static <E> a<E> p() {
        return new a<>();
    }

    public static <E> j<E> s() {
        return (j<E>) t.f39e;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i5, E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i5, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // a1.i, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return n.a(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a1.i
    public int g(Object[] objArr, int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i5 + i6] = get(i6);
        }
        return i5 + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = ~(~((i5 * 31) + get(i6).hashCode()));
        }
        return i5;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return n.b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return n.d(this, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: m */
    public z<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* renamed from: q */
    public a0<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: r */
    public a0<E> listIterator(int i5) {
        z0.k.q(i5, size());
        return isEmpty() ? (a0<E>) f16b : new b(this, i5);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i5, E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: t */
    public j<E> subList(int i5, int i6) {
        z0.k.s(i5, i6, size());
        int i7 = i6 - i5;
        return i7 == size() ? this : i7 == 0 ? s() : u(i5, i6);
    }

    j<E> u(int i5, int i6) {
        return new c(i5, i6 - i5);
    }
}
