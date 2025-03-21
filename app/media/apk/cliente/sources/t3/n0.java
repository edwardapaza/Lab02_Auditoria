package t3;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n0 extends m0 {
    public static <T> Set<T> b() {
        return b0.f7609a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        e4.k.e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : m0.a(set.iterator().next()) : l0.b();
    }
}
