package m4;
/* loaded from: classes.dex */
public final class x2 {
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r4 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final m4.v2 a(long r2, m4.s0 r4, m4.u1 r5) {
        /*
            boolean r0 = r4 instanceof m4.u0
            if (r0 == 0) goto L7
            m4.u0 r4 = (m4.u0) r4
            goto L8
        L7:
            r4 = 0
        L8:
            if (r4 == 0) goto L18
            l4.b$a r0 = l4.b.f6033b
            l4.e r0 = l4.e.MILLISECONDS
            long r0 = l4.d.h(r2, r0)
            java.lang.String r4 = r4.L(r0)
            if (r4 != 0) goto L2e
        L18:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Timed out waiting for "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L2e:
            m4.v2 r2 = new m4.v2
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.x2.a(long, m4.s0, m4.u1):m4.v2");
    }

    private static final <U, T extends U> Object b(w2<U, ? super T> w2Var, d4.p<? super j0, ? super v3.d<? super T>, ? extends Object> pVar) {
        y1.f(w2Var, t0.a(w2Var.f7183d.getContext()).l(w2Var.f6288e, w2Var, w2Var.getContext()));
        return s4.b.c(w2Var, w2Var, pVar);
    }

    public static final <T> Object c(long j5, d4.p<? super j0, ? super v3.d<? super T>, ? extends Object> pVar, v3.d<? super T> dVar) {
        Object c5;
        if (j5 > 0) {
            Object b5 = b(new w2(j5, dVar), pVar);
            c5 = w3.d.c();
            if (b5 == c5) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return b5;
        }
        throw new v2("Timed out immediately");
    }
}
