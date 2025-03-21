package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class w1<T, B> {
    abstract void a(B b5, int i5, int i6);

    abstract void b(B b5, int i5, long j5);

    abstract void c(B b5, int i5, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(B b5, int i5, i iVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(B b5, int i5, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T k(T t5, T t6);

    final void l(B b5, m1 m1Var) {
        while (m1Var.u() != Integer.MAX_VALUE && m(b5, m1Var)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(B b5, m1 m1Var) {
        int c5 = m1Var.c();
        int a5 = c2.a(c5);
        int b6 = c2.b(c5);
        if (b6 == 0) {
            e(b5, a5, m1Var.L());
            return true;
        } else if (b6 == 1) {
            b(b5, a5, m1Var.f());
            return true;
        } else if (b6 == 2) {
            d(b5, a5, m1Var.B());
            return true;
        } else if (b6 != 3) {
            if (b6 != 4) {
                if (b6 == 5) {
                    a(b5, a5, m1Var.q());
                    return true;
                }
                throw e0.e();
            }
            return false;
        } else {
            B n5 = n();
            int c6 = c2.c(a5, 4);
            l(n5, m1Var);
            if (c6 == m1Var.c()) {
                c(b5, a5, r(n5));
                return true;
            }
            throw e0.b();
        }
    }

    abstract B n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, B b5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(m1 m1Var);

    abstract T r(B b5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(T t5, d2 d2Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(T t5, d2 d2Var);
}
