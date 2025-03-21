package m1;

import java.util.Comparator;
import m1.h;
/* loaded from: classes.dex */
public abstract class j<K, V> implements h<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f6067a;

    /* renamed from: b  reason: collision with root package name */
    private final V f6068b;

    /* renamed from: c  reason: collision with root package name */
    private h<K, V> f6069c;

    /* renamed from: d  reason: collision with root package name */
    private final h<K, V> f6070d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(K k5, V v5, h<K, V> hVar, h<K, V> hVar2) {
        this.f6067a = k5;
        this.f6068b = v5;
        this.f6069c = hVar == null ? g.i() : hVar;
        this.f6070d = hVar2 == null ? g.i() : hVar2;
    }

    private j<K, V> i() {
        h<K, V> hVar = this.f6069c;
        h<K, V> d5 = hVar.d(null, null, p(hVar), null, null);
        h<K, V> hVar2 = this.f6070d;
        return d(null, null, p(this), d5, hVar2.d(null, null, p(hVar2), null, null));
    }

    private j<K, V> l() {
        j<K, V> r5 = (!this.f6070d.c() || this.f6069c.c()) ? this : r();
        if (r5.f6069c.c() && ((j) r5.f6069c).f6069c.c()) {
            r5 = r5.s();
        }
        return (r5.f6069c.c() && r5.f6070d.c()) ? r5.i() : r5;
    }

    private j<K, V> n() {
        j<K, V> i5 = i();
        return i5.e().a().c() ? i5.k(null, null, null, ((j) i5.e()).s()).r().i() : i5;
    }

    private j<K, V> o() {
        j<K, V> i5 = i();
        return i5.a().a().c() ? i5.s().i() : i5;
    }

    private static h.a p(h hVar) {
        return hVar.c() ? h.a.BLACK : h.a.RED;
    }

    private h<K, V> q() {
        if (this.f6069c.isEmpty()) {
            return g.i();
        }
        j<K, V> n5 = (a().c() || a().a().c()) ? this : n();
        return n5.k(null, null, ((j) n5.f6069c).q(), null).l();
    }

    private j<K, V> r() {
        return (j) this.f6070d.d(null, null, m(), d(null, null, h.a.RED, null, ((j) this.f6070d).f6069c), null);
    }

    private j<K, V> s() {
        return (j) this.f6069c.d(null, null, m(), null, d(null, null, h.a.RED, ((j) this.f6069c).f6070d, null));
    }

    @Override // m1.h
    public h<K, V> a() {
        return this.f6069c;
    }

    @Override // m1.h
    public h<K, V> b(K k5, V v5, Comparator<K> comparator) {
        int compare = comparator.compare(k5, this.f6067a);
        return (compare < 0 ? k(null, null, this.f6069c.b(k5, v5, comparator), null) : compare == 0 ? k(k5, v5, null, null) : k(null, null, null, this.f6070d.b(k5, v5, comparator))).l();
    }

    @Override // m1.h
    public h<K, V> e() {
        return this.f6070d;
    }

    @Override // m1.h
    public h<K, V> f(K k5, Comparator<K> comparator) {
        j<K, V> k6;
        if (comparator.compare(k5, this.f6067a) < 0) {
            j<K, V> n5 = (this.f6069c.isEmpty() || this.f6069c.c() || ((j) this.f6069c).f6069c.c()) ? this : n();
            k6 = n5.k(null, null, n5.f6069c.f(k5, comparator), null);
        } else {
            j<K, V> s5 = this.f6069c.c() ? s() : this;
            if (!s5.f6070d.isEmpty() && !s5.f6070d.c() && !((j) s5.f6070d).f6069c.c()) {
                s5 = s5.o();
            }
            if (comparator.compare(k5, s5.f6067a) == 0) {
                if (s5.f6070d.isEmpty()) {
                    return g.i();
                }
                h<K, V> g5 = s5.f6070d.g();
                s5 = s5.k(g5.getKey(), g5.getValue(), null, ((j) s5.f6070d).q());
            }
            k6 = s5.k(null, null, null, s5.f6070d.f(k5, comparator));
        }
        return k6.l();
    }

    @Override // m1.h
    public h<K, V> g() {
        return this.f6069c.isEmpty() ? this : this.f6069c.g();
    }

    @Override // m1.h
    public K getKey() {
        return this.f6067a;
    }

    @Override // m1.h
    public V getValue() {
        return this.f6068b;
    }

    @Override // m1.h
    public h<K, V> h() {
        return this.f6070d.isEmpty() ? this : this.f6070d.h();
    }

    @Override // m1.h
    public boolean isEmpty() {
        return false;
    }

    @Override // m1.h
    /* renamed from: j */
    public j<K, V> d(K k5, V v5, h.a aVar, h<K, V> hVar, h<K, V> hVar2) {
        if (k5 == null) {
            k5 = this.f6067a;
        }
        if (v5 == null) {
            v5 = this.f6068b;
        }
        if (hVar == null) {
            hVar = this.f6069c;
        }
        if (hVar2 == null) {
            hVar2 = this.f6070d;
        }
        return aVar == h.a.RED ? new i(k5, v5, hVar, hVar2) : new f(k5, v5, hVar, hVar2);
    }

    protected abstract j<K, V> k(K k5, V v5, h<K, V> hVar, h<K, V> hVar2);

    protected abstract h.a m();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(h<K, V> hVar) {
        this.f6069c = hVar;
    }
}
