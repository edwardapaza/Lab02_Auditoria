package m1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m1.c;
/* loaded from: classes.dex */
public abstract class c<K, V> implements Iterable<Map.Entry<K, V>> {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final InterfaceC0090a f6057a = new InterfaceC0090a() { // from class: m1.b
            @Override // m1.c.a.InterfaceC0090a
            public final Object a(Object obj) {
                Object e5;
                e5 = c.a.e(obj);
                return e5;
            }
        };

        /* renamed from: m1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0090a<C, D> {
            D a(C c5);
        }

        public static <A, B, C> c<A, C> b(List<A> list, Map<B, C> map, InterfaceC0090a<A, B> interfaceC0090a, Comparator<A> comparator) {
            return list.size() < 25 ? m1.a.s(list, map, interfaceC0090a, comparator) : k.p(list, map, interfaceC0090a, comparator);
        }

        public static <K, V> c<K, V> c(Comparator<K> comparator) {
            return new m1.a(comparator);
        }

        public static <A> InterfaceC0090a<A, A> d() {
            return f6057a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object e(Object obj) {
            return obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (i().equals(cVar.i()) && size() == cVar.size()) {
                Iterator<Map.Entry<K, V>> it = iterator();
                Iterator<Map.Entry<K, V>> it2 = cVar.iterator();
                while (it.hasNext()) {
                    if (!it.next().equals(it2.next())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public abstract boolean g(K k5);

    public abstract V h(K k5);

    public int hashCode() {
        int hashCode = i().hashCode();
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            hashCode = (hashCode * 31) + it.next().hashCode();
        }
        return hashCode;
    }

    public abstract Comparator<K> i();

    public abstract int indexOf(K k5);

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract K k();

    public abstract K l();

    public abstract c<K, V> m(K k5, V v5);

    public abstract Iterator<Map.Entry<K, V>> n(K k5);

    public abstract c<K, V> o(K k5);

    public abstract int size();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator<Map.Entry<K, V>> it = iterator();
        boolean z4 = true;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (z4) {
                z4 = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(next.getKey());
            sb.append("=>");
            sb.append(next.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }
}
