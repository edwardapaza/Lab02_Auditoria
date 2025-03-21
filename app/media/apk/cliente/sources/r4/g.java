package r4;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Collection<m4.h0> f7189a;

    static {
        j4.b c5;
        List h5;
        c5 = j4.h.c(ServiceLoader.load(m4.h0.class, m4.h0.class.getClassLoader()).iterator());
        h5 = j4.j.h(c5);
        f7189a = h5;
    }

    public static final Collection<m4.h0> a() {
        return f7189a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
