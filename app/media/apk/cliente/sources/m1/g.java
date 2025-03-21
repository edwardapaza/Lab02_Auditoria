package m1;

import java.util.Comparator;
import m1.h;
/* loaded from: classes.dex */
public class g<K, V> implements h<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final g f6063a = new g();

    private g() {
    }

    public static <K, V> g<K, V> i() {
        return f6063a;
    }

    @Override // m1.h
    public h<K, V> a() {
        return this;
    }

    @Override // m1.h
    public h<K, V> b(K k5, V v5, Comparator<K> comparator) {
        return new i(k5, v5);
    }

    @Override // m1.h
    public boolean c() {
        return false;
    }

    @Override // m1.h
    public h<K, V> d(K k5, V v5, h.a aVar, h<K, V> hVar, h<K, V> hVar2) {
        return this;
    }

    @Override // m1.h
    public h<K, V> e() {
        return this;
    }

    @Override // m1.h
    public h<K, V> f(K k5, Comparator<K> comparator) {
        return this;
    }

    @Override // m1.h
    public h<K, V> g() {
        return this;
    }

    @Override // m1.h
    public K getKey() {
        return null;
    }

    @Override // m1.h
    public V getValue() {
        return null;
    }

    @Override // m1.h
    public h<K, V> h() {
        return this;
    }

    @Override // m1.h
    public boolean isEmpty() {
        return true;
    }

    @Override // m1.h
    public int size() {
        return 0;
    }
}
