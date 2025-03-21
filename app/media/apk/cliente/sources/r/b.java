package r;

import e4.g;
import e4.k;
import r.a;
/* loaded from: classes.dex */
public final class b extends a {
    public b() {
        this(null, 1, null);
    }

    public b(a aVar) {
        k.e(aVar, "initialExtras");
        a().putAll(aVar.a());
    }

    public /* synthetic */ b(a aVar, int i5, g gVar) {
        this((i5 & 1) != 0 ? a.C0110a.f7127b : aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void b(a.b<T> bVar, T t5) {
        k.e(bVar, "key");
        a().put(bVar, t5);
    }
}
