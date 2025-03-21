package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {

    /* renamed from: l  reason: collision with root package name */
    e<K, V> f185l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.collection.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0008a extends e<K, V> {
        C0008a() {
        }

        @Override // androidx.collection.e
        protected void a() {
            a.this.clear();
        }

        @Override // androidx.collection.e
        protected Object b(int i5, int i6) {
            return a.this.f221b[(i5 << 1) + i6];
        }

        @Override // androidx.collection.e
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // androidx.collection.e
        protected int d() {
            return a.this.f222c;
        }

        @Override // androidx.collection.e
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // androidx.collection.e
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // androidx.collection.e
        protected void g(K k5, V v5) {
            a.this.put(k5, v5);
        }

        @Override // androidx.collection.e
        protected void h(int i5) {
            a.this.j(i5);
        }

        @Override // androidx.collection.e
        protected V i(int i5, V v5) {
            return a.this.k(i5, v5);
        }
    }

    public a() {
    }

    public a(int i5) {
        super(i5);
    }

    private e<K, V> m() {
        if (this.f185l == null) {
            this.f185l = new C0008a();
        }
        return this.f185l;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    public boolean n(Collection<?> collection) {
        return e.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f222c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
