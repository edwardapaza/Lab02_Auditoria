package f;

import f.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<K, b.c<K, V>> f2942e = new HashMap<>();

    public boolean contains(K k5) {
        return this.f2942e.containsKey(k5);
    }

    @Override // f.b
    protected b.c<K, V> h(K k5) {
        return this.f2942e.get(k5);
    }

    @Override // f.b
    public V m(K k5, V v5) {
        b.c<K, V> h5 = h(k5);
        if (h5 != null) {
            return h5.f2948b;
        }
        this.f2942e.put(k5, l(k5, v5));
        return null;
    }

    @Override // f.b
    public V n(K k5) {
        V v5 = (V) super.n(k5);
        this.f2942e.remove(k5);
        return v5;
    }

    public Map.Entry<K, V> o(K k5) {
        if (contains(k5)) {
            return this.f2942e.get(k5).f2950d;
        }
        return null;
    }
}
