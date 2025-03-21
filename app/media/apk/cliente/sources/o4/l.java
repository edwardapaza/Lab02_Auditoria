package o4;

import java.util.concurrent.CancellationException;
import m4.k1;
/* loaded from: classes.dex */
final /* synthetic */ class l {
    public static final void a(t<?> tVar, Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = k1.a("Channel was consumed, consumer had failed", th);
            }
        }
        tVar.g(r0);
    }
}
