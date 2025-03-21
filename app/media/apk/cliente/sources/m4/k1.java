package m4;

import java.util.concurrent.CancellationException;
/* loaded from: classes.dex */
public final class k1 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
