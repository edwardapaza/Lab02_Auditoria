package q4;

import e4.u;
import r4.l0;
/* loaded from: classes.dex */
public final class e {
    public static final /* synthetic */ p4.d a(p4.d dVar, v3.g gVar) {
        return d(dVar, gVar);
    }

    public static final <T, V> Object b(v3.g gVar, V v5, Object obj, d4.p<? super V, ? super v3.d<? super T>, ? extends Object> pVar, v3.d<? super T> dVar) {
        Object c5;
        Object c6 = l0.c(gVar, obj);
        try {
            Object invoke = ((d4.p) u.a(pVar, 2)).invoke(v5, new p(dVar, gVar));
            l0.a(gVar, c6);
            c5 = w3.d.c();
            if (invoke == c5) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return invoke;
        } catch (Throwable th) {
            l0.a(gVar, c6);
            throw th;
        }
    }

    public static /* synthetic */ Object c(v3.g gVar, Object obj, Object obj2, d4.p pVar, v3.d dVar, int i5, Object obj3) {
        if ((i5 & 4) != 0) {
            obj2 = l0.b(gVar);
        }
        return b(gVar, obj, obj2, pVar, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> p4.d<T> d(p4.d<? super T> dVar, v3.g gVar) {
        return dVar instanceof o ? dVar : new q(dVar, gVar);
    }
}
