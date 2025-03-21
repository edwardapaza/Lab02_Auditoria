package a1;

import a1.k;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
final class u<K, V> extends k<K, V> {

    /* renamed from: l  reason: collision with root package name */
    static final k<Object, Object> f42l = new u(null, new Object[0], 0);

    /* renamed from: e  reason: collision with root package name */
    private final transient Object f43e;

    /* renamed from: f  reason: collision with root package name */
    final transient Object[] f44f;

    /* renamed from: k  reason: collision with root package name */
    private final transient int f45k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends l<Map.Entry<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private final transient k<K, V> f46c;

        /* renamed from: d  reason: collision with root package name */
        private final transient Object[] f47d;

        /* renamed from: e  reason: collision with root package name */
        private final transient int f48e;

        /* renamed from: f  reason: collision with root package name */
        private final transient int f49f;

        /* renamed from: a1.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0004a extends j<Map.Entry<K, V>> {
            C0004a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f49f;
            }

            @Override // java.util.List
            /* renamed from: v */
            public Map.Entry<K, V> get(int i5) {
                z0.k.l(i5, a.this.f49f);
                int i6 = i5 * 2;
                Object obj = a.this.f47d[a.this.f48e + i6];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f47d[i6 + (a.this.f48e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        a(k<K, V> kVar, Object[] objArr, int i5, int i6) {
            this.f46c = kVar;
            this.f47d = objArr;
            this.f48e = i5;
            this.f49f = i6;
        }

        @Override // a1.i, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                return value != null && value.equals(this.f46c.get(key));
            }
            return false;
        }

        @Override // a1.i
        int g(Object[] objArr, int i5) {
            return n().g(objArr, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a1.i
        public boolean l() {
            return true;
        }

        @Override // a1.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: m */
        public z<Map.Entry<K, V>> iterator() {
            return n().iterator();
        }

        @Override // a1.l
        j<Map.Entry<K, V>> r() {
            return new C0004a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f49f;
        }
    }

    /* loaded from: classes.dex */
    static final class b<K> extends l<K> {

        /* renamed from: c  reason: collision with root package name */
        private final transient k<K, ?> f51c;

        /* renamed from: d  reason: collision with root package name */
        private final transient j<K> f52d;

        b(k<K, ?> kVar, j<K> jVar) {
            this.f51c = kVar;
            this.f52d = jVar;
        }

        @Override // a1.i, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f51c.get(obj) != null;
        }

        @Override // a1.i
        int g(Object[] objArr, int i5) {
            return n().g(objArr, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a1.i
        public boolean l() {
            return true;
        }

        @Override // a1.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: m */
        public z<K> iterator() {
            return n().iterator();
        }

        @Override // a1.l
        public j<K> n() {
            return this.f52d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f51c.size();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends j<Object> {

        /* renamed from: c  reason: collision with root package name */
        private final transient Object[] f53c;

        /* renamed from: d  reason: collision with root package name */
        private final transient int f54d;

        /* renamed from: e  reason: collision with root package name */
        private final transient int f55e;

        c(Object[] objArr, int i5, int i6) {
            this.f53c = objArr;
            this.f54d = i5;
            this.f55e = i6;
        }

        @Override // java.util.List
        public Object get(int i5) {
            z0.k.l(i5, this.f55e);
            Object obj = this.f53c[(i5 * 2) + this.f54d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f55e;
        }
    }

    private u(Object obj, Object[] objArr, int i5) {
        this.f43e = obj;
        this.f44f = objArr;
        this.f45k = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> u<K, V> k(int i5, Object[] objArr, k.a<K, V> aVar) {
        if (i5 == 0) {
            return (u) f42l;
        }
        if (i5 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            a1.c.a(obj, obj2);
            return new u<>(null, objArr, 1);
        }
        z0.k.q(i5, objArr.length >> 1);
        Object l5 = l(objArr, i5, l.o(i5), 0);
        if (l5 instanceof Object[]) {
            Object[] objArr2 = (Object[]) l5;
            k.a.C0002a c0002a = (k.a.C0002a) objArr2[2];
            if (aVar == null) {
                throw c0002a.a();
            }
            aVar.f29e = c0002a;
            Object obj3 = objArr2[0];
            int intValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, intValue * 2);
            l5 = obj3;
            i5 = intValue;
        }
        return new u<>(l5, objArr, i5);
    }

    private static Object l(Object[] objArr, int i5, int i6, int i7) {
        k.a.C0002a c0002a = null;
        if (i5 == 1) {
            Object obj = objArr[i7];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i7 ^ 1];
            Objects.requireNonNull(obj2);
            a1.c.a(obj, obj2);
            return null;
        }
        int i8 = i6 - 1;
        int i9 = -1;
        if (i6 <= 128) {
            byte[] bArr = new byte[i6];
            Arrays.fill(bArr, (byte) -1);
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                int i12 = (i11 * 2) + i7;
                int i13 = (i10 * 2) + i7;
                Object obj3 = objArr[i12];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i12 ^ 1];
                Objects.requireNonNull(obj4);
                a1.c.a(obj3, obj4);
                int a5 = h.a(obj3.hashCode());
                while (true) {
                    int i14 = a5 & i8;
                    int i15 = bArr[i14] & 255;
                    if (i15 == 255) {
                        bArr[i14] = (byte) i13;
                        if (i10 < i11) {
                            objArr[i13] = obj3;
                            objArr[i13 ^ 1] = obj4;
                        }
                        i10++;
                    } else if (obj3.equals(objArr[i15])) {
                        int i16 = i15 ^ 1;
                        Object obj5 = objArr[i16];
                        Objects.requireNonNull(obj5);
                        c0002a = new k.a.C0002a(obj3, obj4, obj5);
                        objArr[i16] = obj4;
                        break;
                    } else {
                        a5 = i14 + 1;
                    }
                }
            }
            return i10 == i5 ? bArr : new Object[]{bArr, Integer.valueOf(i10), c0002a};
        } else if (i6 <= 32768) {
            short[] sArr = new short[i6];
            Arrays.fill(sArr, (short) -1);
            int i17 = 0;
            for (int i18 = 0; i18 < i5; i18++) {
                int i19 = (i18 * 2) + i7;
                int i20 = (i17 * 2) + i7;
                Object obj6 = objArr[i19];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i19 ^ 1];
                Objects.requireNonNull(obj7);
                a1.c.a(obj6, obj7);
                int a6 = h.a(obj6.hashCode());
                while (true) {
                    int i21 = a6 & i8;
                    int i22 = sArr[i21] & 65535;
                    if (i22 == 65535) {
                        sArr[i21] = (short) i20;
                        if (i17 < i18) {
                            objArr[i20] = obj6;
                            objArr[i20 ^ 1] = obj7;
                        }
                        i17++;
                    } else if (obj6.equals(objArr[i22])) {
                        int i23 = i22 ^ 1;
                        Object obj8 = objArr[i23];
                        Objects.requireNonNull(obj8);
                        c0002a = new k.a.C0002a(obj6, obj7, obj8);
                        objArr[i23] = obj7;
                        break;
                    } else {
                        a6 = i21 + 1;
                    }
                }
            }
            return i17 == i5 ? sArr : new Object[]{sArr, Integer.valueOf(i17), c0002a};
        } else {
            int[] iArr = new int[i6];
            Arrays.fill(iArr, -1);
            int i24 = 0;
            int i25 = 0;
            while (i24 < i5) {
                int i26 = (i24 * 2) + i7;
                int i27 = (i25 * 2) + i7;
                Object obj9 = objArr[i26];
                Objects.requireNonNull(obj9);
                Object obj10 = objArr[i26 ^ 1];
                Objects.requireNonNull(obj10);
                a1.c.a(obj9, obj10);
                int a7 = h.a(obj9.hashCode());
                while (true) {
                    int i28 = a7 & i8;
                    int i29 = iArr[i28];
                    if (i29 == i9) {
                        iArr[i28] = i27;
                        if (i25 < i24) {
                            objArr[i27] = obj9;
                            objArr[i27 ^ 1] = obj10;
                        }
                        i25++;
                    } else if (obj9.equals(objArr[i29])) {
                        int i30 = i29 ^ 1;
                        Object obj11 = objArr[i30];
                        Objects.requireNonNull(obj11);
                        c0002a = new k.a.C0002a(obj9, obj10, obj11);
                        objArr[i30] = obj10;
                        break;
                    } else {
                        a7 = i28 + 1;
                        i9 = -1;
                    }
                }
                i24++;
                i9 = -1;
            }
            return i25 == i5 ? iArr : new Object[]{iArr, Integer.valueOf(i25), c0002a};
        }
    }

    static Object m(Object obj, Object[] objArr, int i5, int i6, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i5 == 1) {
            Object obj3 = objArr[i6];
            Objects.requireNonNull(obj3);
            if (obj3.equals(obj2)) {
                Object obj4 = objArr[i6 ^ 1];
                Objects.requireNonNull(obj4);
                return obj4;
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int a5 = h.a(obj2.hashCode());
                while (true) {
                    int i7 = a5 & length;
                    int i8 = bArr[i7] & 255;
                    if (i8 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[i8])) {
                        return objArr[i8 ^ 1];
                    }
                    a5 = i7 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int a6 = h.a(obj2.hashCode());
                while (true) {
                    int i9 = a6 & length2;
                    int i10 = sArr[i9] & 65535;
                    if (i10 == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[i10])) {
                        return objArr[i10 ^ 1];
                    }
                    a6 = i9 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int a7 = h.a(obj2.hashCode());
                while (true) {
                    int i11 = a7 & length3;
                    int i12 = iArr[i11];
                    if (i12 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i12])) {
                        return objArr[i12 ^ 1];
                    }
                    a7 = i11 + 1;
                }
            }
        }
    }

    @Override // a1.k
    l<Map.Entry<K, V>> c() {
        return new a(this, this.f44f, 0, this.f45k);
    }

    @Override // a1.k
    l<K> d() {
        return new b(this, new c(this.f44f, 0, this.f45k));
    }

    @Override // a1.k
    i<V> e() {
        return new c(this.f44f, 1, this.f45k);
    }

    @Override // a1.k
    boolean g() {
        return false;
    }

    @Override // a1.k, java.util.Map
    public V get(Object obj) {
        V v5 = (V) m(this.f43e, this.f44f, this.f45k, 0, obj);
        if (v5 == null) {
            return null;
        }
        return v5;
    }

    @Override // java.util.Map
    public int size() {
        return this.f45k;
    }
}
