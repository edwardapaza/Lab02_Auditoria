package com.google.protobuf;

import com.google.protobuf.v;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f2110a;

    /* renamed from: b  reason: collision with root package name */
    private List<r1<K, V>.e> f2111b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f2112c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2113d;

    /* renamed from: e  reason: collision with root package name */
    private volatile r1<K, V>.g f2114e;

    /* renamed from: f  reason: collision with root package name */
    private Map<K, V> f2115f;

    /* renamed from: k  reason: collision with root package name */
    private volatile r1<K, V>.c f2116k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* loaded from: classes.dex */
    public class a<FieldDescriptorType> extends r1<FieldDescriptorType, Object> {
        a(int i5) {
            super(i5, null);
        }

        @Override // com.google.protobuf.r1
        public void p() {
            if (!o()) {
                for (int i5 = 0; i5 < k(); i5++) {
                    Map.Entry<FieldDescriptorType, Object> j5 = j(i5);
                    if (((v.b) j5.getKey()).f()) {
                        j5.setValue(Collections.unmodifiableList((List) j5.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : m()) {
                    if (((v.b) entry.getKey()).f()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.p();
        }
    }

    /* loaded from: classes.dex */
    private class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f2117a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f2118b;

        private b() {
            this.f2117a = r1.this.f2111b.size();
        }

        /* synthetic */ b(r1 r1Var, a aVar) {
            this();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f2118b == null) {
                this.f2118b = r1.this.f2115f.entrySet().iterator();
            }
            return this.f2118b;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry;
            if (b().hasNext()) {
                entry = b().next();
            } else {
                List list = r1.this.f2111b;
                int i5 = this.f2117a - 1;
                this.f2117a = i5;
                entry = (Map.Entry<K, V>) list.get(i5);
            }
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i5 = this.f2117a;
            return (i5 > 0 && i5 <= r1.this.f2111b.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends r1<K, V>.g {
        private c() {
            super(r1.this, null);
        }

        /* synthetic */ c(r1 r1Var, a aVar) {
            this();
        }

        @Override // com.google.protobuf.r1.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(r1.this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private static final Iterator<Object> f2121a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f2122b = new b();

        /* loaded from: classes.dex */
        class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* loaded from: classes.dex */
        class b implements Iterable<Object> {
            b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.f2121a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f2122b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Map.Entry<K, V>, Comparable<r1<K, V>.e> {

        /* renamed from: a  reason: collision with root package name */
        private final K f2123a;

        /* renamed from: b  reason: collision with root package name */
        private V f2124b;

        e(K k5, V v5) {
            this.f2123a = k5;
            this.f2124b = v5;
        }

        e(r1 r1Var, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean c(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(r1<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d */
        public K getKey() {
            return this.f2123a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return c(this.f2123a, entry.getKey()) && c(this.f2124b, entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2124b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k5 = this.f2123a;
            int hashCode = k5 == null ? 0 : k5.hashCode();
            V v5 = this.f2124b;
            return hashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            r1.this.g();
            V v6 = this.f2124b;
            this.f2124b = v5;
            return v6;
        }

        public String toString() {
            return this.f2123a + "=" + this.f2124b;
        }
    }

    /* loaded from: classes.dex */
    private class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f2126a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2127b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f2128c;

        private f() {
            this.f2126a = -1;
        }

        /* synthetic */ f(r1 r1Var, a aVar) {
            this();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f2128c == null) {
                this.f2128c = r1.this.f2112c.entrySet().iterator();
            }
            return this.f2128c;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f2127b = true;
            int i5 = this.f2126a + 1;
            this.f2126a = i5;
            return i5 < r1.this.f2111b.size() ? (Map.Entry<K, V>) r1.this.f2111b.get(this.f2126a) : b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2126a + 1 >= r1.this.f2111b.size()) {
                return !r1.this.f2112c.isEmpty() && b().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2127b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f2127b = false;
            r1.this.g();
            if (this.f2126a >= r1.this.f2111b.size()) {
                b().remove();
                return;
            }
            r1 r1Var = r1.this;
            int i5 = this.f2126a;
            this.f2126a = i5 - 1;
            r1Var.s(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends AbstractSet<Map.Entry<K, V>> {
        private g() {
        }

        /* synthetic */ g(r1 r1Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            r1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = r1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: g */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            r1.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(r1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                r1.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r1.this.size();
        }
    }

    private r1(int i5) {
        this.f2110a = i5;
        this.f2111b = Collections.emptyList();
        this.f2112c = Collections.emptyMap();
        this.f2115f = Collections.emptyMap();
    }

    /* synthetic */ r1(int i5, a aVar) {
        this(i5);
    }

    private int f(K k5) {
        int size = this.f2111b.size() - 1;
        if (size >= 0) {
            int compareTo = k5.compareTo(this.f2111b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) / 2;
            int compareTo2 = k5.compareTo(this.f2111b.get(i6).getKey());
            if (compareTo2 < 0) {
                size = i6 - 1;
            } else if (compareTo2 <= 0) {
                return i6;
            } else {
                i5 = i6 + 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f2113d) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        g();
        if (!this.f2111b.isEmpty() || (this.f2111b instanceof ArrayList)) {
            return;
        }
        this.f2111b = new ArrayList(this.f2110a);
    }

    private SortedMap<K, V> n() {
        g();
        if (this.f2112c.isEmpty() && !(this.f2112c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2112c = treeMap;
            this.f2115f = treeMap.descendingMap();
        }
        return (SortedMap) this.f2112c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends v.b<FieldDescriptorType>> r1<FieldDescriptorType, Object> q(int i5) {
        return new a(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V s(int i5) {
        g();
        V value = this.f2111b.remove(i5).getValue();
        if (!this.f2112c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = n().entrySet().iterator();
            this.f2111b.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f2111b.isEmpty()) {
            this.f2111b.clear();
        }
        if (this.f2112c.isEmpty()) {
            return;
        }
        this.f2112c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f2112c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f2114e == null) {
            this.f2114e = new g(this, null);
        }
        return this.f2114e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            int size = size();
            if (size != r1Var.size()) {
                return false;
            }
            int k5 = k();
            if (k5 != r1Var.k()) {
                return entrySet().equals(r1Var.entrySet());
            }
            for (int i5 = 0; i5 < k5; i5++) {
                if (!j(i5).equals(r1Var.j(i5))) {
                    return false;
                }
            }
            if (k5 != size) {
                return this.f2112c.equals(r1Var.f2112c);
            }
            return true;
        }
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f5 = f(comparable);
        return f5 >= 0 ? this.f2111b.get(f5).getValue() : this.f2112c.get(comparable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> h() {
        if (this.f2116k == null) {
            this.f2116k = new c(this, null);
        }
        return this.f2116k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int k5 = k();
        int i5 = 0;
        for (int i6 = 0; i6 < k5; i6++) {
            i5 += this.f2111b.get(i6).hashCode();
        }
        return l() > 0 ? i5 + this.f2112c.hashCode() : i5;
    }

    public Map.Entry<K, V> j(int i5) {
        return this.f2111b.get(i5);
    }

    public int k() {
        return this.f2111b.size();
    }

    public int l() {
        return this.f2112c.size();
    }

    public Iterable<Map.Entry<K, V>> m() {
        return this.f2112c.isEmpty() ? d.b() : this.f2112c.entrySet();
    }

    public boolean o() {
        return this.f2113d;
    }

    public void p() {
        if (this.f2113d) {
            return;
        }
        this.f2112c = this.f2112c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f2112c);
        this.f2115f = this.f2115f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f2115f);
        this.f2113d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: r */
    public V put(K k5, V v5) {
        g();
        int f5 = f(k5);
        if (f5 >= 0) {
            return this.f2111b.get(f5).setValue(v5);
        }
        i();
        int i5 = -(f5 + 1);
        if (i5 >= this.f2110a) {
            return n().put(k5, v5);
        }
        int size = this.f2111b.size();
        int i6 = this.f2110a;
        if (size == i6) {
            r1<K, V>.e remove = this.f2111b.remove(i6 - 1);
            n().put((K) remove.getKey(), remove.getValue());
        }
        this.f2111b.add(i5, new e(k5, v5));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f5 = f(comparable);
        if (f5 >= 0) {
            return (V) s(f5);
        }
        if (this.f2112c.isEmpty()) {
            return null;
        }
        return this.f2112c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2111b.size() + this.f2112c.size();
    }
}
