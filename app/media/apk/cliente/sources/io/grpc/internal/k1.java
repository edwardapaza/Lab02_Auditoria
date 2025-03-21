package io.grpc.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k1 extends o0 {

    /* renamed from: c  reason: collision with root package name */
    private static final ReferenceQueue<k1> f4966c = new ReferenceQueue<>();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentMap<a, a> f4967d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f4968e = Logger.getLogger(k1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final a f4969b;

    /* loaded from: classes.dex */
    static final class a extends WeakReference<k1> {

        /* renamed from: f  reason: collision with root package name */
        private static final boolean f4970f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* renamed from: g  reason: collision with root package name */
        private static final RuntimeException f4971g = e();

        /* renamed from: a  reason: collision with root package name */
        private final ReferenceQueue<k1> f4972a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentMap<a, a> f4973b;

        /* renamed from: c  reason: collision with root package name */
        private final String f4974c;

        /* renamed from: d  reason: collision with root package name */
        private final Reference<RuntimeException> f4975d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicBoolean f4976e;

        a(k1 k1Var, i3.u0 u0Var, ReferenceQueue<k1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
            super(k1Var, referenceQueue);
            this.f4976e = new AtomicBoolean();
            this.f4975d = new SoftReference(f4970f ? new RuntimeException("ManagedChannel allocation site") : f4971g);
            this.f4974c = u0Var.toString();
            this.f4972a = referenceQueue;
            this.f4973b = concurrentMap;
            concurrentMap.put(this, this);
            b(referenceQueue);
        }

        static int b(ReferenceQueue<k1> referenceQueue) {
            int i5 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i5;
                }
                RuntimeException runtimeException = aVar.f4975d.get();
                aVar.c();
                if (!aVar.f4976e.get()) {
                    i5++;
                    Level level = Level.SEVERE;
                    if (k1.f4968e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        logRecord.setLoggerName(k1.f4968e.getName());
                        logRecord.setParameters(new Object[]{aVar.f4974c});
                        logRecord.setThrown(runtimeException);
                        k1.f4968e.log(logRecord);
                    }
                }
            }
        }

        private void c() {
            super.clear();
            this.f4973b.remove(this);
            this.f4975d.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.f4976e.getAndSet(true)) {
                return;
            }
            clear();
        }

        private static RuntimeException e() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            c();
            b(this.f4972a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(i3.u0 u0Var) {
        this(u0Var, f4966c, f4967d);
    }

    k1(i3.u0 u0Var, ReferenceQueue<k1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
        super(u0Var);
        this.f4969b = new a(this, u0Var, referenceQueue, concurrentMap);
    }

    @Override // io.grpc.internal.o0, i3.u0
    public i3.u0 m() {
        this.f4969b.d();
        return super.m();
    }

    @Override // io.grpc.internal.o0, i3.u0
    public i3.u0 n() {
        this.f4969b.d();
        return super.n();
    }
}
