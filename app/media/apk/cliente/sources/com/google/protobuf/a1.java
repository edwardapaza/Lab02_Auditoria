package com.google.protobuf;

import com.google.protobuf.c2;
import com.google.protobuf.i0;
import com.google.protobuf.v;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
final class a1<T> implements o1<T> {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f1836a;

    /* renamed from: b  reason: collision with root package name */
    private final w1<?, ?> f1837b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1838c;

    /* renamed from: d  reason: collision with root package name */
    private final r<?> f1839d;

    private a1(w1<?, ?> w1Var, r<?> rVar, w0 w0Var) {
        this.f1837b = w1Var;
        this.f1838c = rVar.e(w0Var);
        this.f1839d = rVar;
        this.f1836a = w0Var;
    }

    private <UT, UB> int k(w1<UT, UB> w1Var, T t5) {
        return w1Var.i(w1Var.g(t5));
    }

    private <UT, UB, ET extends v.b<ET>> void l(w1<UT, UB> w1Var, r<ET> rVar, T t5, m1 m1Var, q qVar) {
        UB f5 = w1Var.f(t5);
        v<ET> d5 = rVar.d(t5);
        do {
            try {
                if (m1Var.u() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                w1Var.o(t5, f5);
            }
        } while (n(m1Var, qVar, rVar, d5, w1Var, f5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> a1<T> m(w1<?, ?> w1Var, r<?> rVar, w0 w0Var) {
        return new a1<>(w1Var, rVar, w0Var);
    }

    private <UT, UB, ET extends v.b<ET>> boolean n(m1 m1Var, q qVar, r<ET> rVar, v<ET> vVar, w1<UT, UB> w1Var, UB ub) {
        int c5 = m1Var.c();
        if (c5 != c2.f1871a) {
            if (c2.b(c5) == 2) {
                Object b5 = rVar.b(qVar, this.f1836a, c2.a(c5));
                if (b5 != null) {
                    rVar.h(m1Var, b5, qVar, vVar);
                    return true;
                }
                return w1Var.m(ub, m1Var);
            }
            return m1Var.F();
        }
        int i5 = 0;
        Object obj = null;
        i iVar = null;
        while (m1Var.u() != Integer.MAX_VALUE) {
            int c6 = m1Var.c();
            if (c6 == c2.f1873c) {
                i5 = m1Var.D();
                obj = rVar.b(qVar, this.f1836a, i5);
            } else if (c6 == c2.f1874d) {
                if (obj != null) {
                    rVar.h(m1Var, obj, qVar, vVar);
                } else {
                    iVar = m1Var.B();
                }
            } else if (!m1Var.F()) {
                break;
            }
        }
        if (m1Var.c() == c2.f1872b) {
            if (iVar != null) {
                if (obj != null) {
                    rVar.i(iVar, obj, qVar, vVar);
                } else {
                    w1Var.d(ub, i5, iVar);
                }
            }
            return true;
        }
        throw e0.b();
    }

    private <UT, UB> void o(w1<UT, UB> w1Var, T t5, d2 d2Var) {
        w1Var.s(w1Var.g(t5), d2Var);
    }

    @Override // com.google.protobuf.o1
    public void a(T t5, T t6) {
        q1.G(this.f1837b, t5, t6);
        if (this.f1838c) {
            q1.E(this.f1839d, t5, t6);
        }
    }

    @Override // com.google.protobuf.o1
    public void b(T t5, d2 d2Var) {
        Iterator<Map.Entry<?, Object>> t6 = this.f1839d.c(t5).t();
        while (t6.hasNext()) {
            Map.Entry<?, Object> next = t6.next();
            v.b bVar = (v.b) next.getKey();
            if (bVar.j() != c2.c.MESSAGE || bVar.f() || bVar.l()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            d2Var.h(bVar.b(), next instanceof i0.b ? ((i0.b) next).a().e() : next.getValue());
        }
        o(this.f1837b, t5, d2Var);
    }

    @Override // com.google.protobuf.o1
    public void c(T t5) {
        this.f1837b.j(t5);
        this.f1839d.f(t5);
    }

    @Override // com.google.protobuf.o1
    public final boolean d(T t5) {
        return this.f1839d.c(t5).p();
    }

    @Override // com.google.protobuf.o1
    public void e(T t5, m1 m1Var, q qVar) {
        l(this.f1837b, this.f1839d, t5, m1Var, qVar);
    }

    @Override // com.google.protobuf.o1
    public boolean f(T t5, T t6) {
        if (this.f1837b.g(t5).equals(this.f1837b.g(t6))) {
            if (this.f1838c) {
                return this.f1839d.c(t5).equals(this.f1839d.c(t6));
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb A[EDGE_INSN: B:57:0x00cb->B:34:0x00cb ?: BREAK  , SYNTHETIC] */
    @Override // com.google.protobuf.o1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(T r11, byte[] r12, int r13, int r14, com.google.protobuf.f.b r15) {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.z r0 = (com.google.protobuf.z) r0
            com.google.protobuf.x1 r1 = r0.unknownFields
            com.google.protobuf.x1 r2 = com.google.protobuf.x1.c()
            if (r1 != r2) goto L11
            com.google.protobuf.x1 r1 = com.google.protobuf.x1.k()
            r0.unknownFields = r1
        L11:
            com.google.protobuf.z$c r11 = (com.google.protobuf.z.c) r11
            com.google.protobuf.v r11 = r11.d0()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.protobuf.f.I(r12, r13, r15)
            int r13 = r15.f1926a
            int r3 = com.google.protobuf.c2.f1871a
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.protobuf.c2.b(r13)
            if (r3 != r5) goto L66
            com.google.protobuf.r<?> r2 = r10.f1839d
            com.google.protobuf.q r3 = r15.f1929d
            com.google.protobuf.w0 r5 = r10.f1836a
            int r6 = com.google.protobuf.c2.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.protobuf.z$e r8 = (com.google.protobuf.z.e) r8
            if (r8 == 0) goto L5b
            com.google.protobuf.j1 r13 = com.google.protobuf.j1.a()
            com.google.protobuf.w0 r2 = r8.b()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.o1 r13 = r13.c(r2)
            int r13 = com.google.protobuf.f.p(r13, r12, r4, r14, r15)
            com.google.protobuf.z$d r2 = r8.f2211b
            java.lang.Object r3 = r15.f1928c
            r11.y(r2, r3)
            goto L64
        L5b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.f.G(r2, r3, r4, r5, r6, r7)
        L64:
            r2 = r8
            goto L19
        L66:
            int r13 = com.google.protobuf.f.P(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.protobuf.f.I(r12, r4, r15)
            int r6 = r15.f1926a
            int r7 = com.google.protobuf.c2.a(r6)
            int r8 = com.google.protobuf.c2.b(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.protobuf.j1 r6 = com.google.protobuf.j1.a()
            com.google.protobuf.w0 r7 = r2.b()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.o1 r6 = r6.c(r7)
            int r4 = com.google.protobuf.f.p(r6, r12, r4, r14, r15)
            com.google.protobuf.z$d r6 = r2.f2211b
            java.lang.Object r7 = r15.f1928c
            r11.y(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.protobuf.f.b(r12, r4, r15)
            java.lang.Object r3 = r15.f1928c
            com.google.protobuf.i r3 = (com.google.protobuf.i) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.protobuf.f.I(r12, r4, r15)
            int r13 = r15.f1926a
            com.google.protobuf.r<?> r2 = r10.f1839d
            com.google.protobuf.q r6 = r15.f1929d
            com.google.protobuf.w0 r7 = r10.f1836a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.protobuf.z$e r2 = (com.google.protobuf.z.e) r2
            goto L6d
        Lc1:
            int r7 = com.google.protobuf.c2.f1872b
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.protobuf.f.P(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.protobuf.c2.c(r13, r5)
            r1.n(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.protobuf.e0 r11 = com.google.protobuf.e0.h()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.a1.g(java.lang.Object, byte[], int, int, com.google.protobuf.f$b):void");
    }

    @Override // com.google.protobuf.o1
    public int h(T t5) {
        int k5 = k(this.f1837b, t5) + 0;
        return this.f1838c ? k5 + this.f1839d.c(t5).j() : k5;
    }

    @Override // com.google.protobuf.o1
    public T i() {
        w0 w0Var = this.f1836a;
        return w0Var instanceof z ? (T) ((z) w0Var).T() : (T) w0Var.k().i();
    }

    @Override // com.google.protobuf.o1
    public int j(T t5) {
        int hashCode = this.f1837b.g(t5).hashCode();
        return this.f1838c ? (hashCode * 53) + this.f1839d.c(t5).hashCode() : hashCode;
    }
}
