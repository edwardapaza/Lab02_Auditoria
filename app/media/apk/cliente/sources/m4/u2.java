package m4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class u2 {
    public static final l1 b(final int i5, final String str) {
        if (i5 >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return n1.b(Executors.newScheduledThreadPool(i5, new ThreadFactory() { // from class: m4.t2
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread c5;
                    c5 = u2.c(i5, str, atomicInteger, runnable);
                    return c5;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i5 + " specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(int i5, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i5 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
