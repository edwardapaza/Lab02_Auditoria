package m4;
/* loaded from: classes.dex */
public final class i0 {
    public static final void a(v3.g gVar, Throwable th) {
        try {
            h0 h0Var = (h0) gVar.d(h0.f6242g);
            if (h0Var != null) {
                h0Var.U(gVar, th);
            } else {
                r4.h.a(gVar, th);
            }
        } catch (Throwable th2) {
            r4.h.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        s3.b.a(runtimeException, th);
        return runtimeException;
    }
}
