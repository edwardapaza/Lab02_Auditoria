package m4;

import java.util.concurrent.CancellationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class z1 {
    public static final x a(u1 u1Var) {
        return new x1(u1Var);
    }

    public static /* synthetic */ x b(u1 u1Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            u1Var = null;
        }
        return y1.a(u1Var);
    }

    public static final void c(v3.g gVar, CancellationException cancellationException) {
        u1 u1Var = (u1) gVar.d(u1.f6282h);
        if (u1Var != null) {
            u1Var.g(cancellationException);
        }
    }

    public static final void d(v3.g gVar, CancellationException cancellationException) {
        j4.b<u1> u5;
        u1 u1Var = (u1) gVar.d(u1.f6282h);
        if (u1Var == null || (u5 = u1Var.u()) == null) {
            return;
        }
        for (u1 u1Var2 : u5) {
            u1Var2.g(cancellationException);
        }
    }

    public static /* synthetic */ void e(v3.g gVar, CancellationException cancellationException, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cancellationException = null;
        }
        y1.d(gVar, cancellationException);
    }

    public static final b1 f(u1 u1Var, b1 b1Var) {
        return u1Var.O(new d1(b1Var));
    }

    public static final void g(u1 u1Var) {
        if (!u1Var.c()) {
            throw u1Var.P();
        }
    }

    public static final void h(v3.g gVar) {
        u1 u1Var = (u1) gVar.d(u1.f6282h);
        if (u1Var != null) {
            y1.g(u1Var);
        }
    }

    public static final u1 i(v3.g gVar) {
        u1 u1Var = (u1) gVar.d(u1.f6282h);
        if (u1Var != null) {
            return u1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + gVar).toString());
    }
}
