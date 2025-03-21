package m1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m1.c;
import m1.h;
/* loaded from: classes.dex */
public class k<K, V> extends c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private h<K, V> f6071a;

    /* renamed from: b  reason: collision with root package name */
    private Comparator<K> f6072b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b<A, B, C> {

        /* renamed from: a  reason: collision with root package name */
        private final List<A> f6073a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<B, C> f6074b;

        /* renamed from: c  reason: collision with root package name */
        private final c.a.InterfaceC0090a<A, B> f6075c;

        /* renamed from: d  reason: collision with root package name */
        private j<A, C> f6076d;

        /* renamed from: e  reason: collision with root package name */
        private j<A, C> f6077e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Iterable<C0092b> {

            /* renamed from: a  reason: collision with root package name */
            private long f6078a;

            /* renamed from: b  reason: collision with root package name */
            private final int f6079b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: m1.k$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0091a implements Iterator<C0092b> {

                /* renamed from: a  reason: collision with root package name */
                private int f6080a;

                C0091a() {
                    this.f6080a = a.this.f6079b - 1;
                }

                @Override // java.util.Iterator
                /* renamed from: b */
                public C0092b next() {
                    C0092b c0092b = new C0092b();
                    c0092b.f6082a = (a.this.f6078a & ((long) (1 << this.f6080a))) == 0;
                    c0092b.f6083b = (int) Math.pow(2.0d, this.f6080a);
                    this.f6080a--;
                    return c0092b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f6080a >= 0;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            }

            public a(int i5) {
                int i6 = i5 + 1;
                int floor = (int) Math.floor(Math.log(i6) / Math.log(2.0d));
                this.f6079b = floor;
                this.f6078a = (((long) Math.pow(2.0d, floor)) - 1) & i6;
            }

            @Override // java.lang.Iterable
            public Iterator<C0092b> iterator() {
                return new C0091a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: m1.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0092b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f6082a;

            /* renamed from: b  reason: collision with root package name */
            public int f6083b;

            C0092b() {
            }
        }

        private b(List<A> list, Map<B, C> map, c.a.InterfaceC0090a<A, B> interfaceC0090a) {
            this.f6073a = list;
            this.f6074b = map;
            this.f6075c = interfaceC0090a;
        }

        private h<A, C> a(int i5, int i6) {
            if (i6 == 0) {
                return g.i();
            }
            if (i6 == 1) {
                A a5 = this.f6073a.get(i5);
                return new f(a5, d(a5), null, null);
            }
            int i7 = i6 / 2;
            int i8 = i5 + i7;
            h<A, C> a6 = a(i5, i7);
            h<A, C> a7 = a(i8 + 1, i7);
            A a8 = this.f6073a.get(i8);
            return new f(a8, d(a8), a6, a7);
        }

        public static <A, B, C> k<A, C> b(List<A> list, Map<B, C> map, c.a.InterfaceC0090a<A, B> interfaceC0090a, Comparator<A> comparator) {
            b bVar = new b(list, map, interfaceC0090a);
            Collections.sort(list, comparator);
            Iterator<C0092b> it = new a(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                C0092b next = it.next();
                int i5 = next.f6083b;
                size -= i5;
                if (next.f6082a) {
                    bVar.c(h.a.BLACK, i5, size);
                } else {
                    bVar.c(h.a.BLACK, i5, size);
                    int i6 = next.f6083b;
                    size -= i6;
                    bVar.c(h.a.RED, i6, size);
                }
            }
            h hVar = bVar.f6076d;
            if (hVar == null) {
                hVar = g.i();
            }
            return new k<>(hVar, comparator);
        }

        private void c(h.a aVar, int i5, int i6) {
            h<A, C> a5 = a(i6 + 1, i5 - 1);
            A a6 = this.f6073a.get(i6);
            j<A, C> iVar = aVar == h.a.RED ? new i<>(a6, d(a6), null, a5) : new f<>(a6, d(a6), null, a5);
            if (this.f6076d == null) {
                this.f6076d = iVar;
            } else {
                this.f6077e.t(iVar);
            }
            this.f6077e = iVar;
        }

        private C d(A a5) {
            return this.f6074b.get(this.f6075c.a(a5));
        }
    }

    private k(h<K, V> hVar, Comparator<K> comparator) {
        this.f6071a = hVar;
        this.f6072b = comparator;
    }

    public static <A, B, C> k<A, C> p(List<A> list, Map<B, C> map, c.a.InterfaceC0090a<A, B> interfaceC0090a, Comparator<A> comparator) {
        return b.b(list, map, interfaceC0090a, comparator);
    }

    public static <A, B> k<A, B> q(Map<A, B> map, Comparator<A> comparator) {
        return b.b(new ArrayList(map.keySet()), map, c.a.d(), comparator);
    }

    private h<K, V> r(K k5) {
        h<K, V> hVar = this.f6071a;
        while (!hVar.isEmpty()) {
            int compare = this.f6072b.compare(k5, hVar.getKey());
            if (compare < 0) {
                hVar = hVar.a();
            } else if (compare == 0) {
                return hVar;
            } else {
                hVar = hVar.e();
            }
        }
        return null;
    }

    @Override // m1.c
    public boolean g(K k5) {
        return r(k5) != null;
    }

    @Override // m1.c
    public V h(K k5) {
        h<K, V> r5 = r(k5);
        if (r5 != null) {
            return r5.getValue();
        }
        return null;
    }

    @Override // m1.c
    public Comparator<K> i() {
        return this.f6072b;
    }

    @Override // m1.c
    public int indexOf(K k5) {
        h<K, V> hVar = this.f6071a;
        int i5 = 0;
        while (!hVar.isEmpty()) {
            int compare = this.f6072b.compare(k5, hVar.getKey());
            if (compare == 0) {
                return i5 + hVar.a().size();
            }
            if (compare < 0) {
                hVar = hVar.a();
            } else {
                i5 += hVar.a().size() + 1;
                hVar = hVar.e();
            }
        }
        return -1;
    }

    @Override // m1.c
    public boolean isEmpty() {
        return this.f6071a.isEmpty();
    }

    @Override // m1.c, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new d(this.f6071a, null, this.f6072b, false);
    }

    @Override // m1.c
    public K k() {
        return this.f6071a.h().getKey();
    }

    @Override // m1.c
    public K l() {
        return this.f6071a.g().getKey();
    }

    @Override // m1.c
    public c<K, V> m(K k5, V v5) {
        return new k(this.f6071a.b(k5, v5, this.f6072b).d(null, null, h.a.BLACK, null, null), this.f6072b);
    }

    @Override // m1.c
    public Iterator<Map.Entry<K, V>> n(K k5) {
        return new d(this.f6071a, k5, this.f6072b, false);
    }

    @Override // m1.c
    public c<K, V> o(K k5) {
        return !g(k5) ? this : new k(this.f6071a.f(k5, this.f6072b).d(null, null, h.a.BLACK, null, null), this.f6072b);
    }

    @Override // m1.c
    public int size() {
        return this.f6071a.size();
    }
}
