package t3;

import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g0 extends f0 {
    public static int a(int i5) {
        return i5 < 0 ? i5 : i5 < 3 ? i5 + 1 : i5 < 1073741824 ? (int) ((i5 / 0.75f) + 1.0f) : a.e.API_PRIORITY_OTHER;
    }

    public static final <K, V> Map<K, V> b(s3.l<? extends K, ? extends V> lVar) {
        e4.k.e(lVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(lVar.c(), lVar.d());
        e4.k.d(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        e4.k.e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        e4.k.d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
