package r4;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class n<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i5, e4.g gVar) {
        if ((i5 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e5) {
        if (obj == null) {
            return a(e5);
        }
        if (obj instanceof ArrayList) {
            e4.k.c(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e5);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e5);
        return a(arrayList);
    }
}
