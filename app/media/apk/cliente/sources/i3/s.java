package i3;

import i3.j1;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class s {
    public static j1 a(r rVar) {
        z0.k.o(rVar, "context must not be null");
        if (rVar.h()) {
            Throwable c5 = rVar.c();
            if (c5 == null) {
                return j1.f3433g.q("io.grpc.Context was cancelled without error");
            }
            if (c5 instanceof TimeoutException) {
                return j1.f3436j.q(c5.getMessage()).p(c5);
            }
            j1 k5 = j1.k(c5);
            return (j1.b.UNKNOWN.equals(k5.m()) && k5.l() == c5) ? j1.f3433g.q("Context cancelled").p(c5) : k5.p(c5);
        }
        return null;
    }
}
