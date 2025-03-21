package io.grpc.internal;

import io.grpc.internal.u;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class x0 {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f5305g = Logger.getLogger(x0.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final long f5306a;

    /* renamed from: b  reason: collision with root package name */
    private final z0.m f5307b;

    /* renamed from: c  reason: collision with root package name */
    private Map<u.a, Executor> f5308c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f5309d;

    /* renamed from: e  reason: collision with root package name */
    private Throwable f5310e;

    /* renamed from: f  reason: collision with root package name */
    private long f5311f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u.a f5312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f5313b;

        a(u.a aVar, long j5) {
            this.f5312a = aVar;
            this.f5313b = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5312a.b(this.f5313b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u.a f5314a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f5315b;

        b(u.a aVar, Throwable th) {
            this.f5314a = aVar;
            this.f5315b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5314a.a(this.f5315b);
        }
    }

    public x0(long j5, z0.m mVar) {
        this.f5306a = j5;
        this.f5307b = mVar;
    }

    private static Runnable b(u.a aVar, long j5) {
        return new a(aVar, j5);
    }

    private static Runnable c(u.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    private static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f5305g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(u.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(u.a aVar, Executor executor) {
        synchronized (this) {
            if (!this.f5309d) {
                this.f5308c.put(aVar, executor);
                return;
            }
            Throwable th = this.f5310e;
            e(executor, th != null ? c(aVar, th) : b(aVar, this.f5311f));
        }
    }

    public boolean d() {
        synchronized (this) {
            if (this.f5309d) {
                return false;
            }
            this.f5309d = true;
            long d5 = this.f5307b.d(TimeUnit.NANOSECONDS);
            this.f5311f = d5;
            Map<u.a, Executor> map = this.f5308c;
            this.f5308c = null;
            for (Map.Entry<u.a, Executor> entry : map.entrySet()) {
                e(entry.getValue(), b(entry.getKey(), d5));
            }
            return true;
        }
    }

    public void f(Throwable th) {
        synchronized (this) {
            if (this.f5309d) {
                return;
            }
            this.f5309d = true;
            this.f5310e = th;
            Map<u.a, Executor> map = this.f5308c;
            this.f5308c = null;
            for (Map.Entry<u.a, Executor> entry : map.entrySet()) {
                g(entry.getKey(), entry.getValue(), th);
            }
        }
    }

    public long h() {
        return this.f5306a;
    }
}
