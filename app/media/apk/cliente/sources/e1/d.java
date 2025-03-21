package e1;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f2654a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f2655b = null;

    /* renamed from: c  reason: collision with root package name */
    private Integer f2656c = null;

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2657d = null;

    /* renamed from: e  reason: collision with root package name */
    private ThreadFactory f2658e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ThreadFactory f2659a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2660b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f2661c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Boolean f2662d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Integer f2663e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f2664f;

        a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f2659a = threadFactory;
            this.f2660b = str;
            this.f2661c = atomicLong;
            this.f2662d = bool;
            this.f2663e = num;
            this.f2664f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f2659a.newThread(runnable);
            Objects.requireNonNull(newThread);
            String str = this.f2660b;
            if (str != null) {
                AtomicLong atomicLong = this.f2661c;
                Objects.requireNonNull(atomicLong);
                newThread.setName(d.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f2662d;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f2663e;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2664f;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    private static ThreadFactory c(d dVar) {
        String str = dVar.f2654a;
        Boolean bool = dVar.f2655b;
        Integer num = dVar.f2656c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = dVar.f2657d;
        ThreadFactory threadFactory = dVar.f2658e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public d e(boolean z4) {
        this.f2655b = Boolean.valueOf(z4);
        return this;
    }

    public d f(String str) {
        d(str, 0);
        this.f2654a = str;
        return this;
    }
}
