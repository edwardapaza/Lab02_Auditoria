package io.grpc.internal;

import io.grpc.internal.u;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e1 {

    /* renamed from: l  reason: collision with root package name */
    private static final long f4704l = TimeUnit.SECONDS.toNanos(10);

    /* renamed from: m  reason: collision with root package name */
    private static final long f4705m = TimeUnit.MILLISECONDS.toNanos(10);

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f4706a;

    /* renamed from: b  reason: collision with root package name */
    private final z0.m f4707b;

    /* renamed from: c  reason: collision with root package name */
    private final d f4708c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4709d;

    /* renamed from: e  reason: collision with root package name */
    private e f4710e;

    /* renamed from: f  reason: collision with root package name */
    private ScheduledFuture<?> f4711f;

    /* renamed from: g  reason: collision with root package name */
    private ScheduledFuture<?> f4712g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f4713h;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f4714i;

    /* renamed from: j  reason: collision with root package name */
    private final long f4715j;

    /* renamed from: k  reason: collision with root package name */
    private final long f4716k;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            synchronized (e1.this) {
                e eVar = e1.this.f4710e;
                e eVar2 = e.DISCONNECTED;
                if (eVar != eVar2) {
                    e1.this.f4710e = eVar2;
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
            if (z4) {
                e1.this.f4708c.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            synchronized (e1.this) {
                e1.this.f4712g = null;
                e eVar = e1.this.f4710e;
                e eVar2 = e.PING_SCHEDULED;
                if (eVar == eVar2) {
                    z4 = true;
                    e1.this.f4710e = e.PING_SENT;
                    e1 e1Var = e1.this;
                    e1Var.f4711f = e1Var.f4706a.schedule(e1.this.f4713h, e1.this.f4716k, TimeUnit.NANOSECONDS);
                } else {
                    if (e1.this.f4710e == e.PING_DELAYED) {
                        e1 e1Var2 = e1.this;
                        ScheduledExecutorService scheduledExecutorService = e1Var2.f4706a;
                        Runnable runnable = e1.this.f4714i;
                        long j5 = e1.this.f4715j;
                        z0.m mVar = e1.this.f4707b;
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        e1Var2.f4712g = scheduledExecutorService.schedule(runnable, j5 - mVar.d(timeUnit), timeUnit);
                        e1.this.f4710e = eVar2;
                    }
                    z4 = false;
                }
            }
            if (z4) {
                e1.this.f4708c.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        private final x f4719a;

        /* loaded from: classes.dex */
        class a implements u.a {
            a() {
            }

            @Override // io.grpc.internal.u.a
            public void a(Throwable th) {
                c.this.f4719a.h(i3.j1.f3447u.q("Keepalive failed. The connection is likely gone"));
            }

            @Override // io.grpc.internal.u.a
            public void b(long j5) {
            }
        }

        public c(x xVar) {
            this.f4719a = xVar;
        }

        @Override // io.grpc.internal.e1.d
        public void a() {
            this.f4719a.h(i3.j1.f3447u.q("Keepalive failed. The connection is likely gone"));
        }

        @Override // io.grpc.internal.e1.d
        public void b() {
            this.f4719a.g(new a(), e1.c.a());
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public e1(d dVar, ScheduledExecutorService scheduledExecutorService, long j5, long j6, boolean z4) {
        this(dVar, scheduledExecutorService, z0.m.c(), j5, j6, z4);
    }

    e1(d dVar, ScheduledExecutorService scheduledExecutorService, z0.m mVar, long j5, long j6, boolean z4) {
        this.f4710e = e.IDLE;
        this.f4713h = new f1(new a());
        this.f4714i = new f1(new b());
        this.f4708c = (d) z0.k.o(dVar, "keepAlivePinger");
        this.f4706a = (ScheduledExecutorService) z0.k.o(scheduledExecutorService, "scheduler");
        this.f4707b = (z0.m) z0.k.o(mVar, "stopwatch");
        this.f4715j = j5;
        this.f4716k = j6;
        this.f4709d = z4;
        mVar.f().g();
    }

    public static long l(long j5) {
        return Math.max(j5, f4704l);
    }

    public synchronized void m() {
        this.f4707b.f().g();
        e eVar = this.f4710e;
        e eVar2 = e.PING_SCHEDULED;
        if (eVar == eVar2) {
            this.f4710e = e.PING_DELAYED;
        } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
            ScheduledFuture<?> scheduledFuture = this.f4711f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (this.f4710e == e.IDLE_AND_PING_SENT) {
                this.f4710e = e.IDLE;
                return;
            }
            this.f4710e = eVar2;
            z0.k.u(this.f4712g == null, "There should be no outstanding pingFuture");
            this.f4712g = this.f4706a.schedule(this.f4714i, this.f4715j, TimeUnit.NANOSECONDS);
        }
    }

    public synchronized void n() {
        e eVar = this.f4710e;
        if (eVar == e.IDLE) {
            this.f4710e = e.PING_SCHEDULED;
            if (this.f4712g == null) {
                ScheduledExecutorService scheduledExecutorService = this.f4706a;
                Runnable runnable = this.f4714i;
                long j5 = this.f4715j;
                z0.m mVar = this.f4707b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.f4712g = scheduledExecutorService.schedule(runnable, j5 - mVar.d(timeUnit), timeUnit);
            }
        } else if (eVar == e.IDLE_AND_PING_SENT) {
            this.f4710e = e.PING_SENT;
        }
    }

    public synchronized void o() {
        if (this.f4709d) {
            return;
        }
        e eVar = this.f4710e;
        if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
            this.f4710e = e.IDLE;
        }
        if (this.f4710e == e.PING_SENT) {
            this.f4710e = e.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void p() {
        if (this.f4709d) {
            n();
        }
    }

    public synchronized void q() {
        e eVar = this.f4710e;
        e eVar2 = e.DISCONNECTED;
        if (eVar != eVar2) {
            this.f4710e = eVar2;
            ScheduledFuture<?> scheduledFuture = this.f4711f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledFuture<?> scheduledFuture2 = this.f4712g;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                this.f4712g = null;
            }
        }
    }
}
