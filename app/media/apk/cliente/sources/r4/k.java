package r4;

import java.util.concurrent.CancellationException;
import m4.f1;
import m4.q2;
import m4.u1;
import m4.z2;
import s3.m;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    private static final h0 f7201a = new h0("UNDEFINED");

    /* renamed from: b */
    public static final h0 f7202b = new h0("REUSABLE_CLAIMED");

    public static final <T> void b(v3.d<? super T> dVar, Object obj, d4.l<? super Throwable, s3.t> lVar) {
        boolean z4;
        if (!(dVar instanceof j)) {
            dVar.resumeWith(obj);
            return;
        }
        j jVar = (j) dVar;
        Object b5 = m4.d0.b(obj, lVar);
        if (jVar.f7196d.g0(jVar.getContext())) {
            jVar.f7198f = b5;
            jVar.f6287c = 1;
            jVar.f7196d.f0(jVar.getContext(), jVar);
            return;
        }
        f1 a5 = q2.f6272a.a();
        if (a5.o0()) {
            jVar.f7198f = b5;
            jVar.f6287c = 1;
            a5.k0(jVar);
            return;
        }
        a5.m0(true);
        try {
            u1 u1Var = (u1) jVar.getContext().d(u1.f6282h);
            if (u1Var == null || u1Var.c()) {
                z4 = false;
            } else {
                CancellationException P = u1Var.P();
                jVar.a(b5, P);
                m.a aVar = s3.m.f7565b;
                jVar.resumeWith(s3.m.b(s3.n.a(P)));
                z4 = true;
            }
            if (!z4) {
                v3.d<T> dVar2 = jVar.f7197e;
                Object obj2 = jVar.f7199k;
                v3.g context = dVar2.getContext();
                Object c5 = l0.c(context, obj2);
                z2<?> g5 = c5 != l0.f7204a ? m4.f0.g(dVar2, context, c5) : null;
                jVar.f7197e.resumeWith(obj);
                s3.t tVar = s3.t.f7573a;
                if (g5 == null || g5.X0()) {
                    l0.a(context, c5);
                }
            }
            do {
            } while (a5.q0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(v3.d dVar, Object obj, d4.l lVar, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
