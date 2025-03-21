package m1;

import java.util.Comparator;
/* loaded from: classes.dex */
public interface h<K, V> {

    /* loaded from: classes.dex */
    public enum a {
        RED,
        BLACK
    }

    h<K, V> a();

    h<K, V> b(K k5, V v5, Comparator<K> comparator);

    boolean c();

    h<K, V> d(K k5, V v5, a aVar, h<K, V> hVar, h<K, V> hVar2);

    h<K, V> e();

    h<K, V> f(K k5, Comparator<K> comparator);

    h<K, V> g();

    K getKey();

    V getValue();

    h<K, V> h();

    boolean isEmpty();

    int size();
}
