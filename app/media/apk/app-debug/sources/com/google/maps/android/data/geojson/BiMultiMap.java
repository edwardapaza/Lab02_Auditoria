package com.google.maps.android.data.geojson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class BiMultiMap<K> extends HashMap<K, Object> {
    private final Map<Object, K> mValuesToKeys = new HashMap();

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ?> map) {
        for (Map.Entry<? extends K, ?> entry : map.entrySet()) {
            put((BiMultiMap<K>) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(K key, Object value) {
        if (value instanceof Collection) {
            return put((BiMultiMap<K>) key, (Collection) value);
        }
        this.mValuesToKeys.put(value, key);
        return super.put((BiMultiMap<K>) key, (K) value);
    }

    public Object put(K key, Collection values) {
        for (Object value : values) {
            this.mValuesToKeys.put(value, key);
        }
        return super.put((BiMultiMap<K>) key, (K) values);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object key) {
        Object value = super.remove(key);
        if (value instanceof Collection) {
            for (Object valueItem : (Collection) value) {
                this.mValuesToKeys.remove(valueItem);
            }
        } else {
            this.mValuesToKeys.remove(value);
        }
        return value;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.mValuesToKeys.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public BiMultiMap<K> clone() {
        BiMultiMap<K> cloned = new BiMultiMap<>();
        cloned.putAll((Map) super.clone());
        return cloned;
    }

    public K getKey(Object value) {
        return this.mValuesToKeys.get(value);
    }
}
