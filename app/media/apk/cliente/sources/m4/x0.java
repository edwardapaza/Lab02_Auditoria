package m4;

import s3.m;
/* loaded from: classes.dex */
public final class x0 {
    public static final <T> void a(w0<? super T> w0Var, int i5) {
        v3.d<? super T> b5 = w0Var.b();
        boolean z4 = i5 == 4;
        if (z4 || !(b5 instanceof r4.j) || b(i5) != b(w0Var.f6287c)) {
            d(w0Var, b5, z4);
            return;
        }
        g0 g0Var = ((r4.j) b5).f7196d;
        v3.g context = b5.getContext();
        if (g0Var.g0(context)) {
            g0Var.f0(context, w0Var);
        } else {
            e(w0Var);
        }
    }

    public static final boolean b(int i5) {
        return i5 == 1 || i5 == 2;
    }

    public static final boolean c(int i5) {
        return i5 == 2;
    }

    public static final <T> void d(w0<? super T> w0Var, v3.d<? super T> dVar, boolean z4) {
        Object d5;
        Object i5 = w0Var.i();
        Throwable c5 = w0Var.c(i5);
        if (c5 != null) {
            m.a aVar = s3.m.f7565b;
            d5 = s3.n.a(c5);
        } else {
            m.a aVar2 = s3.m.f7565b;
            d5 = w0Var.d(i5);
        }
        Object b5 = s3.m.b(d5);
        if (!z4) {
            dVar.resumeWith(b5);
            return;
        }
        e4.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        r4.j jVar = (r4.j) dVar;
        v3.d<T> dVar2 = jVar.f7197e;
        Object obj = jVar.f7199k;
        v3.g context = dVar2.getContext();
        Object c6 = r4.l0.c(context, obj);
        z2<?> g5 = c6 != r4.l0.f7204a ? f0.g(dVar2, context, c6) : null;
        try {
            jVar.f7197e.resumeWith(b5);
            s3.t tVar = s3.t.f7573a;
        } finally {
            if (g5 == null || g5.X0()) {
                r4.l0.a(context, c6);
            }
        }
    }

    private static final void e(w0<?> w0Var) {
        f1 a5 = q2.f6272a.a();
        if (a5.o0()) {
            a5.k0(w0Var);
            return;
        }
        a5.m0(true);
        try {
            d(w0Var, w0Var.b(), true);
            do {
            } while (a5.q0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
