package t3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public abstract class c<E> extends t3.a<E> implements List<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7610a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final void a(int i5, int i6) {
            if (i5 < 0 || i5 >= i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void b(int i5, int i6) {
            if (i5 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("index: " + i5 + ", size: " + i6);
            }
        }

        public final void c(int i5, int i6, int i7) {
            if (i5 < 0 || i6 > i7) {
                throw new IndexOutOfBoundsException("fromIndex: " + i5 + ", toIndex: " + i6 + ", size: " + i7);
            } else if (i5 <= i6) {
            } else {
                throw new IllegalArgumentException("fromIndex: " + i5 + " > toIndex: " + i6);
            }
        }

        public final boolean d(Collection<?> collection, Collection<?> collection2) {
            e4.k.e(collection, "c");
            e4.k.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!e4.k.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> collection) {
            e4.k.e(collection, "c");
            Iterator<?> it = collection.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i5 = (i5 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f7611a;

        public b() {
        }

        protected final int b() {
            return this.f7611a;
        }

        protected final void c(int i5) {
            this.f7611a = i5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7611a < c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                c<E> cVar = c.this;
                int i5 = this.f7611a;
                this.f7611a = i5 + 1;
                return cVar.get(i5);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: t3.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0117c extends c<E>.b implements ListIterator<E> {
        public C0117c(int i5) {
            super();
            c.f7610a.b(i5, c.this.size());
            c(i5);
        }

        @Override // java.util.ListIterator
        public void add(E e5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                c<E> cVar = c.this;
                c(b() - 1);
                return cVar.get(b());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    private static final class d<E> extends c<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private final c<E> f7614b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7615c;

        /* renamed from: d  reason: collision with root package name */
        private int f7616d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(c<? extends E> cVar, int i5, int i6) {
            e4.k.e(cVar, "list");
            this.f7614b = cVar;
            this.f7615c = i5;
            c.f7610a.c(i5, i6, cVar.size());
            this.f7616d = i6 - i5;
        }

        @Override // t3.a
        public int g() {
            return this.f7616d;
        }

        @Override // t3.c, java.util.List
        public E get(int i5) {
            c.f7610a.a(i5, this.f7616d);
            return this.f7614b.get(this.f7615c + i5);
        }
    }

    @Override // java.util.List
    public void add(int i5, E e5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f7610a.d(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i5);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f7610a.e(this);
    }

    @Override // java.util.List
    public int indexOf(E e5) {
        int i5 = 0;
        for (E e6 : this) {
            if (e4.k.a(e6, e5)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e5) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (e4.k.a(listIterator.previous(), e5)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new C0117c(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i5) {
        return new C0117c(i5);
    }

    @Override // java.util.List
    public E remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i5, E e5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i5, int i6) {
        return new d(this, i5, i6);
    }
}
