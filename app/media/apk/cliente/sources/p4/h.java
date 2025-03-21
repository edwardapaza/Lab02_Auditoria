package p4;

import m4.u1;
import q4.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class h {
    private static final void a(v3.g gVar) {
        if (gVar.d(u1.f6282h) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + gVar).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> c<T> b(c<? extends T> cVar, v3.g gVar) {
        a(gVar);
        return e4.k.a(gVar, v3.h.f8175a) ? cVar : cVar instanceof q4.i ? i.a.a((q4.i) cVar, gVar, 0, null, 6, null) : new q4.g(cVar, gVar, 0, null, 12, null);
    }
}
