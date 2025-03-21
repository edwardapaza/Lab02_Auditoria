package com.google.protobuf;

import com.google.protobuf.c2;
/* loaded from: classes.dex */
public class p0<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f2091a;

    /* renamed from: b  reason: collision with root package name */
    private final K f2092b;

    /* renamed from: c  reason: collision with root package name */
    private final V f2093c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final c2.b f2094a;

        /* renamed from: b  reason: collision with root package name */
        public final K f2095b;

        /* renamed from: c  reason: collision with root package name */
        public final c2.b f2096c;

        /* renamed from: d  reason: collision with root package name */
        public final V f2097d;

        public a(c2.b bVar, K k5, c2.b bVar2, V v5) {
            this.f2094a = bVar;
            this.f2095b = k5;
            this.f2096c = bVar2;
            this.f2097d = v5;
        }
    }

    private p0(c2.b bVar, K k5, c2.b bVar2, V v5) {
        this.f2091a = new a<>(bVar, k5, bVar2, v5);
        this.f2092b = k5;
        this.f2093c = v5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int b(a<K, V> aVar, K k5, V v5) {
        return v.d(aVar.f2094a, 1, k5) + v.d(aVar.f2096c, 2, v5);
    }

    public static <K, V> p0<K, V> d(c2.b bVar, K k5, c2.b bVar2, V v5) {
        return new p0<>(bVar, k5, bVar2, v5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void e(l lVar, a<K, V> aVar, K k5, V v5) {
        v.A(lVar, aVar.f2094a, 1, k5);
        v.A(lVar, aVar.f2096c, 2, v5);
    }

    public int a(int i5, K k5, V v5) {
        return l.V(i5) + l.D(b(this.f2091a, k5, v5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<K, V> c() {
        return this.f2091a;
    }
}
