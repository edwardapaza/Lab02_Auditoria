package com.google.protobuf;

import com.google.protobuf.d0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class q0<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private static final q0<?, ?> f2104b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2105a;

    static {
        q0<?, ?> q0Var = new q0<>();
        f2104b = q0Var;
        q0Var.l();
    }

    private q0() {
        this.f2105a = true;
    }

    private q0(Map<K, V> map) {
        super(map);
        this.f2105a = true;
    }

    static <K, V> int a(Map<K, V> map) {
        int i5 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i5 += b(entry.getValue()) ^ b(entry.getKey());
        }
        return i5;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return d0.d((byte[]) obj);
        }
        if (obj instanceof d0.c) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private static void c(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            d0.a(obj);
            d0.a(map.get(obj));
        }
    }

    public static <K, V> q0<K, V> d() {
        return (q0<K, V>) f2104b;
    }

    private void e() {
        if (!k()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean f(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <K, V> boolean j(java.util.Map<K, V> r4, java.util.Map<K, V> r5) {
        /*
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            int r1 = r4.size()
            int r2 = r5.size()
            r3 = 0
            if (r1 == r2) goto L10
            return r3
        L10:
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L18:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L42
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r2 = r5.containsKey(r2)
            if (r2 != 0) goto L2f
            return r3
        L2f:
            java.lang.Object r2 = r1.getValue()
            java.lang.Object r1 = r1.getKey()
            java.lang.Object r1 = r5.get(r1)
            boolean r1 = f(r2, r1)
            if (r1 != 0) goto L18
            return r3
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.q0.j(java.util.Map, java.util.Map):boolean");
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        e();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && j(this, (Map) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return a(this);
    }

    public boolean k() {
        return this.f2105a;
    }

    public void l() {
        this.f2105a = false;
    }

    public void m(q0<K, V> q0Var) {
        e();
        if (q0Var.isEmpty()) {
            return;
        }
        putAll(q0Var);
    }

    public q0<K, V> n() {
        return isEmpty() ? new q0<>() : new q0<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k5, V v5) {
        e();
        d0.a(k5);
        d0.a(v5);
        return (V) super.put(k5, v5);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        e();
        c(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e();
        return (V) super.remove(obj);
    }
}
