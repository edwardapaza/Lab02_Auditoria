package m4;

import v3.e;
/* loaded from: classes.dex */
public final /* synthetic */ class i {
    public static final <T> q0<T> a(j0 j0Var, v3.g gVar, l0 l0Var, d4.p<? super j0, ? super v3.d<? super T>, ? extends Object> pVar) {
        v3.g d5 = f0.d(j0Var, gVar);
        r0 d2Var = l0Var.d() ? new d2(d5, pVar) : new r0(d5, true);
        ((a) d2Var).W0(l0Var, d2Var, pVar);
        return d2Var;
    }

    public static /* synthetic */ q0 b(j0 j0Var, v3.g gVar, l0 l0Var, d4.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gVar = v3.h.f8175a;
        }
        if ((i5 & 2) != 0) {
            l0Var = l0.DEFAULT;
        }
        return h.a(j0Var, gVar, l0Var, pVar);
    }

    public static final u1 c(j0 j0Var, v3.g gVar, l0 l0Var, d4.p<? super j0, ? super v3.d<? super s3.t>, ? extends Object> pVar) {
        v3.g d5 = f0.d(j0Var, gVar);
        a e2Var = l0Var.d() ? new e2(d5, pVar) : new m2(d5, true);
        e2Var.W0(l0Var, e2Var, pVar);
        return e2Var;
    }

    public static /* synthetic */ u1 d(j0 j0Var, v3.g gVar, l0 l0Var, d4.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gVar = v3.h.f8175a;
        }
        if ((i5 & 2) != 0) {
            l0Var = l0.DEFAULT;
        }
        return h.c(j0Var, gVar, l0Var, pVar);
    }

    public static final <T> Object e(v3.g gVar, d4.p<? super j0, ? super v3.d<? super T>, ? extends Object> pVar, v3.d<? super T> dVar) {
        Object X0;
        Object c5;
        v3.g context = dVar.getContext();
        v3.g e5 = f0.e(context, gVar);
        y1.h(e5);
        if (e5 == context) {
            r4.d0 d0Var = new r4.d0(e5, dVar);
            X0 = s4.b.b(d0Var, d0Var, pVar);
        } else {
            e.b bVar = v3.e.f8172j;
            if (e4.k.a(e5.d(bVar), context.d(bVar))) {
                z2 z2Var = new z2(e5, dVar);
                v3.g context2 = z2Var.getContext();
                Object c6 = r4.l0.c(context2, null);
                try {
                    Object b5 = s4.b.b(z2Var, z2Var, pVar);
                    r4.l0.a(context2, c6);
                    X0 = b5;
                } catch (Throwable th) {
                    r4.l0.a(context2, c6);
                    throw th;
                }
            } else {
                v0 v0Var = new v0(e5, dVar);
                s4.a.d(pVar, v0Var, v0Var, null, 4, null);
                X0 = v0Var.X0();
            }
        }
        c5 = w3.d.c();
        if (X0 == c5) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return X0;
    }
}
