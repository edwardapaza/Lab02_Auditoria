package a1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class f<K, V> extends g implements Map<K, V> {
    protected abstract Map<K, V> b();

    @Override // java.util.Map
    public void clear() {
        b().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return b().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return b().containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return b().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return b().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return b().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().keySet();
    }

    @Override // java.util.Map
    public V put(K k5, V v5) {
        return b().put(k5, v5);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b().putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return b().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return b().size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().values();
    }
}
