package m1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m1.c;
/* loaded from: classes.dex */
public class e<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T, Void> f6060a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<T, Void>> f6061a;

        public a(Iterator<Map.Entry<T, Void>> it) {
            this.f6061a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6061a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f6061a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f6061a.remove();
        }
    }

    public e(List<T> list, Comparator<T> comparator) {
        this.f6060a = c.a.b(list, Collections.emptyMap(), c.a.d(), comparator);
    }

    private e(c<T, Void> cVar) {
        this.f6060a = cVar;
    }

    public boolean contains(T t5) {
        return this.f6060a.g(t5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f6060a.equals(((e) obj).f6060a);
        }
        return false;
    }

    public T g() {
        return this.f6060a.k();
    }

    public T h() {
        return this.f6060a.l();
    }

    public int hashCode() {
        return this.f6060a.hashCode();
    }

    public e<T> i(T t5) {
        return new e<>(this.f6060a.m(t5, null));
    }

    public int indexOf(T t5) {
        return this.f6060a.indexOf(t5);
    }

    public boolean isEmpty() {
        return this.f6060a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f6060a.iterator());
    }

    public Iterator<T> k(T t5) {
        return new a(this.f6060a.n(t5));
    }

    public e<T> l(T t5) {
        c<T, Void> o5 = this.f6060a.o(t5);
        return o5 == this.f6060a ? this : new e<>(o5);
    }

    public e<T> m(e<T> eVar) {
        e<T> eVar2;
        if (size() < eVar.size()) {
            eVar2 = eVar;
            eVar = this;
        } else {
            eVar2 = this;
        }
        Iterator<T> it = eVar.iterator();
        while (it.hasNext()) {
            eVar2 = eVar2.i(it.next());
        }
        return eVar2;
    }

    public int size() {
        return this.f6060a.size();
    }
}
