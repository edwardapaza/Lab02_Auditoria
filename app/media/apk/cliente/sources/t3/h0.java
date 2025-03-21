package t3;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h0 extends g0 {
    public static <K, V> Map<K, V> d() {
        a0 a0Var = a0.f7605a;
        e4.k.c(a0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return a0Var;
    }

    public static <K, V> Map<K, V> e(s3.l<? extends K, ? extends V>... lVarArr) {
        e4.k.e(lVarArr, "pairs");
        return lVarArr.length > 0 ? m(lVarArr, new LinkedHashMap(e0.a(lVarArr.length))) : e0.d();
    }

    public static <K, V> Map<K, V> f(s3.l<? extends K, ? extends V>... lVarArr) {
        e4.k.e(lVarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e0.a(lVarArr.length));
        i(linkedHashMap, lVarArr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> g(Map<K, ? extends V> map) {
        e4.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : g0.c(map) : e0.d();
    }

    public static final <K, V> void h(Map<? super K, ? super V> map, Iterable<? extends s3.l<? extends K, ? extends V>> iterable) {
        e4.k.e(map, "<this>");
        e4.k.e(iterable, "pairs");
        for (s3.l<? extends K, ? extends V> lVar : iterable) {
            map.put((K) lVar.a(), (V) lVar.b());
        }
    }

    public static final <K, V> void i(Map<? super K, ? super V> map, s3.l<? extends K, ? extends V>[] lVarArr) {
        e4.k.e(map, "<this>");
        e4.k.e(lVarArr, "pairs");
        for (s3.l<? extends K, ? extends V> lVar : lVarArr) {
            map.put((K) lVar.a(), (V) lVar.b());
        }
    }

    public static <K, V> Map<K, V> j(Iterable<? extends s3.l<? extends K, ? extends V>> iterable) {
        e4.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return k(iterable, new LinkedHashMap(e0.a(collection.size())));
                }
                return g0.b(iterable instanceof List ? (s3.l<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            return e0.d();
        }
        return g(k(iterable, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M k(Iterable<? extends s3.l<? extends K, ? extends V>> iterable, M m5) {
        e4.k.e(iterable, "<this>");
        e4.k.e(m5, "destination");
        h(m5, iterable);
        return m5;
    }

    public static <K, V> Map<K, V> l(Map<? extends K, ? extends V> map) {
        e4.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? n(map) : g0.c(map) : e0.d();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M m(s3.l<? extends K, ? extends V>[] lVarArr, M m5) {
        e4.k.e(lVarArr, "<this>");
        e4.k.e(m5, "destination");
        i(m5, lVarArr);
        return m5;
    }

    public static final <K, V> Map<K, V> n(Map<? extends K, ? extends V> map) {
        e4.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
