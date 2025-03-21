package io.grpc.internal;

import i3.g;
import i3.j1;
import i3.l;
import i3.r;
import i3.y0;
import i3.z0;
import io.grpc.internal.l1;
import io.grpc.internal.p2;
import io.grpc.internal.t;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r<ReqT, RespT> extends i3.g<ReqT, RespT> {

    /* renamed from: t  reason: collision with root package name */
    private static final Logger f5110t = Logger.getLogger(r.class.getName());

    /* renamed from: u  reason: collision with root package name */
    private static final byte[] f5111u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* renamed from: v  reason: collision with root package name */
    private static final double f5112v = TimeUnit.SECONDS.toNanos(1) * 1.0d;

    /* renamed from: a  reason: collision with root package name */
    private final i3.z0<ReqT, RespT> f5113a;

    /* renamed from: b  reason: collision with root package name */
    private final r3.d f5114b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f5115c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5116d;

    /* renamed from: e  reason: collision with root package name */
    private final o f5117e;

    /* renamed from: f  reason: collision with root package name */
    private final i3.r f5118f;

    /* renamed from: g  reason: collision with root package name */
    private volatile ScheduledFuture<?> f5119g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5120h;

    /* renamed from: i  reason: collision with root package name */
    private i3.c f5121i;

    /* renamed from: j  reason: collision with root package name */
    private s f5122j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f5123k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5124l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5125m;

    /* renamed from: n  reason: collision with root package name */
    private final e f5126n;

    /* renamed from: p  reason: collision with root package name */
    private final ScheduledExecutorService f5128p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5129q;

    /* renamed from: o  reason: collision with root package name */
    private final r<ReqT, RespT>.f f5127o = new f();

    /* renamed from: r  reason: collision with root package name */
    private i3.v f5130r = i3.v.c();

    /* renamed from: s  reason: collision with root package name */
    private i3.o f5131s = i3.o.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends z {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.a f5132b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g.a aVar) {
            super(r.this.f5118f);
            this.f5132b = aVar;
        }

        @Override // io.grpc.internal.z
        public void a() {
            r rVar = r.this;
            rVar.r(this.f5132b, i3.s.a(rVar.f5118f), new i3.y0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends z {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.a f5134b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f5135c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(g.a aVar, String str) {
            super(r.this.f5118f);
            this.f5134b = aVar;
            this.f5135c = str;
        }

        @Override // io.grpc.internal.z
        public void a() {
            r.this.r(this.f5134b, i3.j1.f3446t.q(String.format("Unable to find compressor by name %s", this.f5135c)), new i3.y0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements t {

        /* renamed from: a  reason: collision with root package name */
        private final g.a<RespT> f5137a;

        /* renamed from: b  reason: collision with root package name */
        private i3.j1 f5138b;

        /* loaded from: classes.dex */
        final class a extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r3.b f5140b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ i3.y0 f5141c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(r3.b bVar, i3.y0 y0Var) {
                super(r.this.f5118f);
                this.f5140b = bVar;
                this.f5141c = y0Var;
            }

            private void b() {
                if (d.this.f5138b != null) {
                    return;
                }
                try {
                    d.this.f5137a.b(this.f5141c);
                } catch (Throwable th) {
                    d.this.i(i3.j1.f3433g.p(th).q("Failed to read headers"));
                }
            }

            @Override // io.grpc.internal.z
            public void a() {
                r3.e h5 = r3.c.h("ClientCall$Listener.headersRead");
                try {
                    r3.c.a(r.this.f5114b);
                    r3.c.e(this.f5140b);
                    b();
                    if (h5 != null) {
                        h5.close();
                    }
                } catch (Throwable th) {
                    if (h5 != null) {
                        try {
                            h5.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* loaded from: classes.dex */
        final class b extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r3.b f5143b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ p2.a f5144c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(r3.b bVar, p2.a aVar) {
                super(r.this.f5118f);
                this.f5143b = bVar;
                this.f5144c = aVar;
            }

            private void b() {
                if (d.this.f5138b != null) {
                    t0.d(this.f5144c);
                    return;
                }
                while (true) {
                    try {
                        InputStream next = this.f5144c.next();
                        if (next == null) {
                            return;
                        }
                        d.this.f5137a.c(r.this.f5113a.i(next));
                        next.close();
                    } catch (Throwable th) {
                        t0.d(this.f5144c);
                        d.this.i(i3.j1.f3433g.p(th).q("Failed to read message."));
                        return;
                    }
                }
            }

            @Override // io.grpc.internal.z
            public void a() {
                r3.e h5 = r3.c.h("ClientCall$Listener.messagesAvailable");
                try {
                    r3.c.a(r.this.f5114b);
                    r3.c.e(this.f5143b);
                    b();
                    if (h5 != null) {
                        h5.close();
                    }
                } catch (Throwable th) {
                    if (h5 != null) {
                        try {
                            h5.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class c extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r3.b f5146b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ i3.j1 f5147c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ i3.y0 f5148d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(r3.b bVar, i3.j1 j1Var, i3.y0 y0Var) {
                super(r.this.f5118f);
                this.f5146b = bVar;
                this.f5147c = j1Var;
                this.f5148d = y0Var;
            }

            private void b() {
                i3.j1 j1Var = this.f5147c;
                i3.y0 y0Var = this.f5148d;
                if (d.this.f5138b != null) {
                    j1Var = d.this.f5138b;
                    y0Var = new i3.y0();
                }
                r.this.f5123k = true;
                try {
                    d dVar = d.this;
                    r.this.r(dVar.f5137a, j1Var, y0Var);
                } finally {
                    r.this.y();
                    r.this.f5117e.a(j1Var.o());
                }
            }

            @Override // io.grpc.internal.z
            public void a() {
                r3.e h5 = r3.c.h("ClientCall$Listener.onClose");
                try {
                    r3.c.a(r.this.f5114b);
                    r3.c.e(this.f5146b);
                    b();
                    if (h5 != null) {
                        h5.close();
                    }
                } catch (Throwable th) {
                    if (h5 != null) {
                        try {
                            h5.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* renamed from: io.grpc.internal.r$d$d  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        final class C0079d extends z {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r3.b f5150b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0079d(r3.b bVar) {
                super(r.this.f5118f);
                this.f5150b = bVar;
            }

            private void b() {
                if (d.this.f5138b != null) {
                    return;
                }
                try {
                    d.this.f5137a.d();
                } catch (Throwable th) {
                    d.this.i(i3.j1.f3433g.p(th).q("Failed to call onReady."));
                }
            }

            @Override // io.grpc.internal.z
            public void a() {
                r3.e h5 = r3.c.h("ClientCall$Listener.onReady");
                try {
                    r3.c.a(r.this.f5114b);
                    r3.c.e(this.f5150b);
                    b();
                    if (h5 != null) {
                        h5.close();
                    }
                } catch (Throwable th) {
                    if (h5 != null) {
                        try {
                            h5.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        public d(g.a<RespT> aVar) {
            this.f5137a = (g.a) z0.k.o(aVar, "observer");
        }

        private void h(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            i3.t s5 = r.this.s();
            if (j1Var.m() == j1.b.CANCELLED && s5 != null && s5.m()) {
                z0 z0Var = new z0();
                r.this.f5122j.l(z0Var);
                i3.j1 j1Var2 = i3.j1.f3436j;
                j1Var = j1Var2.e("ClientCall was cancelled at or after deadline. " + z0Var);
                y0Var = new i3.y0();
            }
            r.this.f5115c.execute(new c(r3.c.f(), j1Var, y0Var));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(i3.j1 j1Var) {
            this.f5138b = j1Var;
            r.this.f5122j.a(j1Var);
        }

        @Override // io.grpc.internal.p2
        public void a(p2.a aVar) {
            r3.e h5 = r3.c.h("ClientStreamListener.messagesAvailable");
            try {
                r3.c.a(r.this.f5114b);
                r.this.f5115c.execute(new b(r3.c.f(), aVar));
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.p2
        public void b() {
            if (r.this.f5113a.e().a()) {
                return;
            }
            r3.e h5 = r3.c.h("ClientStreamListener.onReady");
            try {
                r3.c.a(r.this.f5114b);
                r.this.f5115c.execute(new C0079d(r3.c.f()));
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.t
        public void c(i3.y0 y0Var) {
            r3.e h5 = r3.c.h("ClientStreamListener.headersRead");
            try {
                r3.c.a(r.this.f5114b);
                r.this.f5115c.execute(new a(r3.c.f(), y0Var));
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.t
        public void d(i3.j1 j1Var, t.a aVar, i3.y0 y0Var) {
            r3.e h5 = r3.c.h("ClientStreamListener.closed");
            try {
                r3.c.a(r.this.f5114b);
                h(j1Var, aVar, y0Var);
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        s a(i3.z0<?, ?> z0Var, i3.c cVar, i3.y0 y0Var, i3.r rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class f implements r.a {
        private f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final long f5153a;

        g(long j5) {
            this.f5153a = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            z0 z0Var = new z0();
            r.this.f5122j.l(z0Var);
            long abs = Math.abs(this.f5153a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = abs / timeUnit.toNanos(1L);
            long abs2 = Math.abs(this.f5153a) % timeUnit.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("deadline exceeded after ");
            if (this.f5153a < 0) {
                sb.append('-');
            }
            sb.append(nanos);
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
            sb.append("s. ");
            sb.append(z0Var);
            r.this.f5122j.a(i3.j1.f3436j.e(sb.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i3.z0<ReqT, RespT> z0Var, Executor executor, i3.c cVar, e eVar, ScheduledExecutorService scheduledExecutorService, o oVar, i3.f0 f0Var) {
        this.f5113a = z0Var;
        r3.d c5 = r3.c.c(z0Var.c(), System.identityHashCode(this));
        this.f5114b = c5;
        boolean z4 = true;
        if (executor == e1.c.a()) {
            this.f5115c = new h2();
            this.f5116d = true;
        } else {
            this.f5115c = new i2(executor);
            this.f5116d = false;
        }
        this.f5117e = oVar;
        this.f5118f = i3.r.e();
        if (z0Var.e() != z0.d.UNARY && z0Var.e() != z0.d.SERVER_STREAMING) {
            z4 = false;
        }
        this.f5120h = z4;
        this.f5121i = cVar;
        this.f5126n = eVar;
        this.f5128p = scheduledExecutorService;
        r3.c.d("ClientCall.<init>", c5);
    }

    private ScheduledFuture<?> D(i3.t tVar) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long o5 = tVar.o(timeUnit);
        return this.f5128p.schedule(new f1(new g(o5)), o5, timeUnit);
    }

    private void E(g.a<RespT> aVar, i3.y0 y0Var) {
        i3.n nVar;
        z0.k.u(this.f5122j == null, "Already started");
        z0.k.u(!this.f5124l, "call was cancelled");
        z0.k.o(aVar, "observer");
        z0.k.o(y0Var, "headers");
        if (this.f5118f.h()) {
            this.f5122j = q1.f5108a;
            this.f5115c.execute(new b(aVar));
            return;
        }
        p();
        String b5 = this.f5121i.b();
        if (b5 != null) {
            nVar = this.f5131s.b(b5);
            if (nVar == null) {
                this.f5122j = q1.f5108a;
                this.f5115c.execute(new c(aVar, b5));
                return;
            }
        } else {
            nVar = l.b.f3486a;
        }
        x(y0Var, this.f5130r, nVar, this.f5129q);
        i3.t s5 = s();
        if (s5 != null && s5.m()) {
            this.f5122j = new h0(i3.j1.f3436j.q(String.format("ClientCall started after %s deadline was exceeded .9%f seconds ago", u(this.f5121i.d(), this.f5118f.g()) ? "CallOptions" : "Context", Double.valueOf(s5.o(TimeUnit.NANOSECONDS) / f5112v))), t0.f(this.f5121i, y0Var, 0, false));
        } else {
            v(s5, this.f5118f.g(), this.f5121i.d());
            this.f5122j = this.f5126n.a(this.f5113a, this.f5121i, y0Var, this.f5118f);
        }
        if (this.f5116d) {
            this.f5122j.m();
        }
        if (this.f5121i.a() != null) {
            this.f5122j.k(this.f5121i.a());
        }
        if (this.f5121i.f() != null) {
            this.f5122j.d(this.f5121i.f().intValue());
        }
        if (this.f5121i.g() != null) {
            this.f5122j.e(this.f5121i.g().intValue());
        }
        if (s5 != null) {
            this.f5122j.g(s5);
        }
        this.f5122j.b(nVar);
        boolean z4 = this.f5129q;
        if (z4) {
            this.f5122j.p(z4);
        }
        this.f5122j.h(this.f5130r);
        this.f5117e.b();
        this.f5122j.f(new d(aVar));
        this.f5118f.a(this.f5127o, e1.c.a());
        if (s5 != null && !s5.equals(this.f5118f.g()) && this.f5128p != null) {
            this.f5119g = D(s5);
        }
        if (this.f5123k) {
            y();
        }
    }

    private void p() {
        l1.b bVar = (l1.b) this.f5121i.h(l1.b.f4995g);
        if (bVar == null) {
            return;
        }
        Long l5 = bVar.f4996a;
        if (l5 != null) {
            i3.t a5 = i3.t.a(l5.longValue(), TimeUnit.NANOSECONDS);
            i3.t d5 = this.f5121i.d();
            if (d5 == null || a5.compareTo(d5) < 0) {
                this.f5121i = this.f5121i.m(a5);
            }
        }
        Boolean bool = bVar.f4997b;
        if (bool != null) {
            this.f5121i = bool.booleanValue() ? this.f5121i.s() : this.f5121i.t();
        }
        if (bVar.f4998c != null) {
            Integer f5 = this.f5121i.f();
            this.f5121i = f5 != null ? this.f5121i.o(Math.min(f5.intValue(), bVar.f4998c.intValue())) : this.f5121i.o(bVar.f4998c.intValue());
        }
        if (bVar.f4999d != null) {
            Integer g5 = this.f5121i.g();
            this.f5121i = g5 != null ? this.f5121i.p(Math.min(g5.intValue(), bVar.f4999d.intValue())) : this.f5121i.p(bVar.f4999d.intValue());
        }
    }

    private void q(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f5110t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f5124l) {
            return;
        }
        this.f5124l = true;
        try {
            if (this.f5122j != null) {
                i3.j1 j1Var = i3.j1.f3433g;
                if (str == null) {
                    str = "Call cancelled without message";
                }
                i3.j1 q5 = j1Var.q(str);
                if (th != null) {
                    q5 = q5.p(th);
                }
                this.f5122j.a(q5);
            }
        } finally {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(g.a<RespT> aVar, i3.j1 j1Var, i3.y0 y0Var) {
        aVar.a(j1Var, y0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i3.t s() {
        return w(this.f5121i.d(), this.f5118f.g());
    }

    private void t() {
        z0.k.u(this.f5122j != null, "Not started");
        z0.k.u(!this.f5124l, "call was cancelled");
        z0.k.u(!this.f5125m, "call already half-closed");
        this.f5125m = true;
        this.f5122j.n();
    }

    private static boolean u(i3.t tVar, i3.t tVar2) {
        if (tVar == null) {
            return false;
        }
        if (tVar2 == null) {
            return true;
        }
        return tVar.k(tVar2);
    }

    private static void v(i3.t tVar, i3.t tVar2, i3.t tVar3) {
        Logger logger = f5110t;
        if (logger.isLoggable(Level.FINE) && tVar != null && tVar.equals(tVar2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long max = Math.max(0L, tVar.o(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(max)));
            sb.append(tVar3 == null ? " Explicit call timeout was not set." : String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(tVar3.o(timeUnit))));
            logger.fine(sb.toString());
        }
    }

    private static i3.t w(i3.t tVar, i3.t tVar2) {
        return tVar == null ? tVar2 : tVar2 == null ? tVar : tVar.n(tVar2);
    }

    static void x(i3.y0 y0Var, i3.v vVar, i3.n nVar, boolean z4) {
        y0Var.e(t0.f5183i);
        y0.g<String> gVar = t0.f5179e;
        y0Var.e(gVar);
        if (nVar != l.b.f3486a) {
            y0Var.p(gVar, nVar.a());
        }
        y0.g<byte[]> gVar2 = t0.f5180f;
        y0Var.e(gVar2);
        byte[] a5 = i3.g0.a(vVar);
        if (a5.length != 0) {
            y0Var.p(gVar2, a5);
        }
        y0Var.e(t0.f5181g);
        y0.g<byte[]> gVar3 = t0.f5182h;
        y0Var.e(gVar3);
        if (z4) {
            y0Var.p(gVar3, f5111u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.f5118f.i(this.f5127o);
        ScheduledFuture<?> scheduledFuture = this.f5119g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private void z(ReqT reqt) {
        z0.k.u(this.f5122j != null, "Not started");
        z0.k.u(!this.f5124l, "call was cancelled");
        z0.k.u(!this.f5125m, "call was half-closed");
        try {
            s sVar = this.f5122j;
            if (sVar instanceof b2) {
                ((b2) sVar).n0(reqt);
            } else {
                sVar.j(this.f5113a.j(reqt));
            }
            if (this.f5120h) {
                return;
            }
            this.f5122j.flush();
        } catch (Error e5) {
            this.f5122j.a(i3.j1.f3433g.q("Client sendMessage() failed with Error"));
            throw e5;
        } catch (RuntimeException e6) {
            this.f5122j.a(i3.j1.f3433g.p(e6).q("Failed to stream message"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r<ReqT, RespT> A(i3.o oVar) {
        this.f5131s = oVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r<ReqT, RespT> B(i3.v vVar) {
        this.f5130r = vVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r<ReqT, RespT> C(boolean z4) {
        this.f5129q = z4;
        return this;
    }

    @Override // i3.g
    public void a(String str, Throwable th) {
        r3.e h5 = r3.c.h("ClientCall.cancel");
        try {
            r3.c.a(this.f5114b);
            q(str, th);
            if (h5 != null) {
                h5.close();
            }
        } catch (Throwable th2) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // i3.g
    public void b() {
        r3.e h5 = r3.c.h("ClientCall.halfClose");
        try {
            r3.c.a(this.f5114b);
            t();
            if (h5 != null) {
                h5.close();
            }
        } catch (Throwable th) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // i3.g
    public void c(int i5) {
        r3.e h5 = r3.c.h("ClientCall.request");
        try {
            r3.c.a(this.f5114b);
            boolean z4 = true;
            z0.k.u(this.f5122j != null, "Not started");
            if (i5 < 0) {
                z4 = false;
            }
            z0.k.e(z4, "Number requested must be non-negative");
            this.f5122j.c(i5);
            if (h5 != null) {
                h5.close();
            }
        } catch (Throwable th) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // i3.g
    public void d(ReqT reqt) {
        r3.e h5 = r3.c.h("ClientCall.sendMessage");
        try {
            r3.c.a(this.f5114b);
            z(reqt);
            if (h5 != null) {
                h5.close();
            }
        } catch (Throwable th) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // i3.g
    public void e(g.a<RespT> aVar, i3.y0 y0Var) {
        r3.e h5 = r3.c.h("ClientCall.start");
        try {
            r3.c.a(this.f5114b);
            E(aVar, y0Var);
            if (h5 != null) {
                h5.close();
            }
        } catch (Throwable th) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String toString() {
        return z0.f.b(this).d("method", this.f5113a).toString();
    }
}
