package f;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f2943a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f2944b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakHashMap<f<K, V>, Boolean> f2945c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f2946d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // f.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2950d;
        }

        @Override // f.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f2949c;
        }
    }

    /* renamed from: f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0050b<K, V> extends e<K, V> {
        C0050b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // f.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2949c;
        }

        @Override // f.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f2950d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f2947a;

        /* renamed from: b  reason: collision with root package name */
        final V f2948b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f2949c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f2950d;

        c(K k5, V v5) {
            this.f2947a = k5;
            this.f2948b = v5;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f2947a.equals(cVar.f2947a) && this.f2948b.equals(cVar.f2948b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2947a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2948b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2947a.hashCode() ^ this.f2948b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2947a + "=" + this.f2948b;
        }
    }

    /* loaded from: classes.dex */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f2951a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2952b = true;

        d() {
        }

        @Override // f.b.f
        void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f2951a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2950d;
                this.f2951a = cVar3;
                this.f2952b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f2952b) {
                this.f2952b = false;
                cVar = b.this.f2943a;
            } else {
                c<K, V> cVar2 = this.f2951a;
                cVar = cVar2 != null ? cVar2.f2949c : null;
            }
            this.f2951a = cVar;
            return this.f2951a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2952b) {
                return b.this.f2943a != null;
            }
            c<K, V> cVar = this.f2951a;
            return (cVar == null || cVar.f2949c == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f2954a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f2955b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2954a = cVar2;
            this.f2955b = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.f2955b;
            c<K, V> cVar2 = this.f2954a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // f.b.f
        public void b(c<K, V> cVar) {
            if (this.f2954a == cVar && cVar == this.f2955b) {
                this.f2955b = null;
                this.f2954a = null;
            }
            c<K, V> cVar2 = this.f2954a;
            if (cVar2 == cVar) {
                this.f2954a = c(cVar2);
            }
            if (this.f2955b == cVar) {
                this.f2955b = f();
            }
        }

        abstract c<K, V> c(c<K, V> cVar);

        abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: e */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2955b;
            this.f2955b = f();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2955b != null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f<K, V> {
        abstract void b(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0050b c0050b = new C0050b(this.f2944b, this.f2943a);
        this.f2945c.put(c0050b, Boolean.FALSE);
        return c0050b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public Map.Entry<K, V> g() {
        return this.f2943a;
    }

    protected c<K, V> h(K k5) {
        c<K, V> cVar = this.f2943a;
        while (cVar != null && !cVar.f2947a.equals(k5)) {
            cVar = cVar.f2949c;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += it.next().hashCode();
        }
        return i5;
    }

    public b<K, V>.d i() {
        b<K, V>.d dVar = new d();
        this.f2945c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f2943a, this.f2944b);
        this.f2945c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Map.Entry<K, V> k() {
        return this.f2944b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<K, V> l(K k5, V v5) {
        c<K, V> cVar = new c<>(k5, v5);
        this.f2946d++;
        c<K, V> cVar2 = this.f2944b;
        if (cVar2 == null) {
            this.f2943a = cVar;
        } else {
            cVar2.f2949c = cVar;
            cVar.f2950d = cVar2;
        }
        this.f2944b = cVar;
        return cVar;
    }

    public V m(K k5, V v5) {
        c<K, V> h5 = h(k5);
        if (h5 != null) {
            return h5.f2948b;
        }
        l(k5, v5);
        return null;
    }

    public V n(K k5) {
        c<K, V> h5 = h(k5);
        if (h5 == null) {
            return null;
        }
        this.f2946d--;
        if (!this.f2945c.isEmpty()) {
            for (f<K, V> fVar : this.f2945c.keySet()) {
                fVar.b(h5);
            }
        }
        c<K, V> cVar = h5.f2950d;
        c<K, V> cVar2 = h5.f2949c;
        if (cVar != null) {
            cVar.f2949c = cVar2;
        } else {
            this.f2943a = cVar2;
        }
        c<K, V> cVar3 = h5.f2949c;
        if (cVar3 != null) {
            cVar3.f2950d = cVar;
        } else {
            this.f2944b = cVar;
        }
        h5.f2949c = null;
        h5.f2950d = null;
        return h5.f2948b;
    }

    public int size() {
        return this.f2946d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
