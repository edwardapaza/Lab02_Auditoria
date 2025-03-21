package p3;

import i3.d;
import p3.a;
import p3.b;
import p3.c;
/* loaded from: classes.dex */
public abstract class a<S extends a<S>> extends b<S> {
    /* JADX INFO: Access modifiers changed from: protected */
    public a(d dVar, i3.c cVar) {
        super(dVar, cVar);
    }

    public static <T extends b<T>> T e(b.a<T> aVar, d dVar) {
        return (T) f(aVar, dVar, i3.c.f3343k);
    }

    public static <T extends b<T>> T f(b.a<T> aVar, d dVar, i3.c cVar) {
        return aVar.a(dVar, cVar.q(c.f6886c, c.a.ASYNC));
    }
}
