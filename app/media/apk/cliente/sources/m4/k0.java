package m4;
/* loaded from: classes.dex */
public final class k0 {
    public static final j0 a(v3.g gVar) {
        x b5;
        if (gVar.d(u1.f6282h) == null) {
            b5 = z1.b(null, 1, null);
            gVar = gVar.J(b5);
        }
        return new r4.f(gVar);
    }

    public static final j0 b() {
        return new r4.f(o2.b(null, 1, null).J(z0.c()));
    }

    public static final <R> Object c(d4.p<? super j0, ? super v3.d<? super R>, ? extends Object> pVar, v3.d<? super R> dVar) {
        Object c5;
        r4.d0 d0Var = new r4.d0(dVar.getContext(), dVar);
        Object b5 = s4.b.b(d0Var, d0Var, pVar);
        c5 = w3.d.c();
        if (b5 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return b5;
    }

    public static final boolean d(j0 j0Var) {
        u1 u1Var = (u1) j0Var.b().d(u1.f6282h);
        if (u1Var != null) {
            return u1Var.c();
        }
        return true;
    }
}
