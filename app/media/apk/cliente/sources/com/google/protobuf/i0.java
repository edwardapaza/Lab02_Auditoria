package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class i0 extends j0 {

    /* renamed from: f  reason: collision with root package name */
    private final w0 f1973f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, i0> f1974a;

        private b(Map.Entry<K, i0> entry) {
            this.f1974a = entry;
        }

        public i0 a() {
            return this.f1974a.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f1974a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            i0 value = this.f1974a.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof w0) {
                return this.f1974a.getValue().d((w0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f1975a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f1975a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f1975a.next();
            return next.getValue() instanceof i0 ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1975a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1975a.remove();
        }
    }

    @Override // com.google.protobuf.j0
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public w0 f() {
        return c(this.f1973f);
    }

    @Override // com.google.protobuf.j0
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
