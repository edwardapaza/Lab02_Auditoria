package r4;
/* loaded from: classes.dex */
public final class h {
    public static final void a(v3.g gVar, Throwable th) {
        for (m4.h0 h0Var : g.a()) {
            try {
                h0Var.U(gVar, th);
            } catch (Throwable th2) {
                g.b(m4.i0.b(th, th2));
            }
        }
        try {
            s3.b.a(th, new i(gVar));
        } catch (Throwable unused) {
        }
        g.b(th);
    }
}
