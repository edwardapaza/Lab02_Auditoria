package q3;

import i3.a;
import i3.f;
import i3.j1;
import i3.k;
import i3.n1;
import i3.p;
import i3.q;
import i3.r0;
import i3.x;
import i3.y0;
import io.grpc.internal.j2;
import io.grpc.internal.q2;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class f extends r0 {

    /* renamed from: l  reason: collision with root package name */
    private static final a.c<b> f6993l = a.c.a("addressTrackerKey");

    /* renamed from: c  reason: collision with root package name */
    final c f6994c;

    /* renamed from: d  reason: collision with root package name */
    private final n1 f6995d;

    /* renamed from: e  reason: collision with root package name */
    private final r0.d f6996e;

    /* renamed from: f  reason: collision with root package name */
    private final q3.e f6997f;

    /* renamed from: g  reason: collision with root package name */
    private q2 f6998g;

    /* renamed from: h  reason: collision with root package name */
    private final ScheduledExecutorService f6999h;

    /* renamed from: i  reason: collision with root package name */
    private n1.d f7000i;

    /* renamed from: j  reason: collision with root package name */
    private Long f7001j;

    /* renamed from: k  reason: collision with root package name */
    private final i3.f f7002k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private g f7003a;

        /* renamed from: d  reason: collision with root package name */
        private Long f7006d;

        /* renamed from: e  reason: collision with root package name */
        private int f7007e;

        /* renamed from: b  reason: collision with root package name */
        private volatile a f7004b = new a();

        /* renamed from: c  reason: collision with root package name */
        private a f7005c = new a();

        /* renamed from: f  reason: collision with root package name */
        private final Set<i> f7008f = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            AtomicLong f7009a;

            /* renamed from: b  reason: collision with root package name */
            AtomicLong f7010b;

            private a() {
                this.f7009a = new AtomicLong();
                this.f7010b = new AtomicLong();
            }

            void a() {
                this.f7009a.set(0L);
                this.f7010b.set(0L);
            }
        }

        b(g gVar) {
            this.f7003a = gVar;
        }

        boolean b(i iVar) {
            if (m() && !iVar.o()) {
                iVar.n();
            } else if (!m() && iVar.o()) {
                iVar.q();
            }
            iVar.p(this);
            return this.f7008f.add(iVar);
        }

        void c() {
            int i5 = this.f7007e;
            this.f7007e = i5 == 0 ? 0 : i5 - 1;
        }

        void d(long j5) {
            this.f7006d = Long.valueOf(j5);
            this.f7007e++;
            for (i iVar : this.f7008f) {
                iVar.n();
            }
        }

        double e() {
            return this.f7005c.f7010b.get() / f();
        }

        long f() {
            return this.f7005c.f7009a.get() + this.f7005c.f7010b.get();
        }

        void g(boolean z4) {
            g gVar = this.f7003a;
            if (gVar.f7023e == null && gVar.f7024f == null) {
                return;
            }
            (z4 ? this.f7004b.f7009a : this.f7004b.f7010b).getAndIncrement();
        }

        public boolean h(long j5) {
            return j5 > this.f7006d.longValue() + Math.min(this.f7003a.f7020b.longValue() * ((long) this.f7007e), Math.max(this.f7003a.f7020b.longValue(), this.f7003a.f7021c.longValue()));
        }

        boolean i(i iVar) {
            iVar.m();
            return this.f7008f.remove(iVar);
        }

        void j() {
            this.f7004b.a();
            this.f7005c.a();
        }

        void k() {
            this.f7007e = 0;
        }

        void l(g gVar) {
            this.f7003a = gVar;
        }

        boolean m() {
            return this.f7006d != null;
        }

        double n() {
            return this.f7005c.f7009a.get() / f();
        }

        void o() {
            this.f7005c.a();
            a aVar = this.f7004b;
            this.f7004b = this.f7005c;
            this.f7005c = aVar;
        }

        void p() {
            z0.k.u(this.f7006d != null, "not currently ejected");
            this.f7006d = null;
            for (i iVar : this.f7008f) {
                iVar.q();
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.f7008f + '}';
        }
    }

    /* loaded from: classes.dex */
    static class c extends a1.f<SocketAddress, b> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<SocketAddress, b> f7011a = new HashMap();

        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a1.g
        /* renamed from: b */
        public Map<SocketAddress, b> a() {
            return this.f7011a;
        }

        void c() {
            for (b bVar : this.f7011a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        double d() {
            if (this.f7011a.isEmpty()) {
                return 0.0d;
            }
            int i5 = 0;
            int i6 = 0;
            for (b bVar : this.f7011a.values()) {
                i6++;
                if (bVar.m()) {
                    i5++;
                }
            }
            return (i5 / i6) * 100.0d;
        }

        void e(Long l5) {
            for (b bVar : this.f7011a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l5.longValue())) {
                    bVar.p();
                }
            }
        }

        void f(g gVar, Collection<SocketAddress> collection) {
            for (SocketAddress socketAddress : collection) {
                if (!this.f7011a.containsKey(socketAddress)) {
                    this.f7011a.put(socketAddress, new b(gVar));
                }
            }
        }

        void g() {
            for (b bVar : this.f7011a.values()) {
                bVar.j();
            }
        }

        void h() {
            for (b bVar : this.f7011a.values()) {
                bVar.o();
            }
        }

        void i(g gVar) {
            for (b bVar : this.f7011a.values()) {
                bVar.l(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    class d extends q3.c {

        /* renamed from: a  reason: collision with root package name */
        private r0.d f7012a;

        d(r0.d dVar) {
            this.f7012a = dVar;
        }

        @Override // q3.c, i3.r0.d
        public r0.h a(r0.b bVar) {
            i iVar = new i(this.f7012a.a(bVar));
            List<x> a5 = bVar.a();
            if (f.m(a5) && f.this.f6994c.containsKey(a5.get(0).a().get(0))) {
                b bVar2 = f.this.f6994c.get(a5.get(0).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f7006d != null) {
                    iVar.n();
                }
            }
            return iVar;
        }

        @Override // i3.r0.d
        public void f(p pVar, r0.i iVar) {
            this.f7012a.f(pVar, new h(iVar));
        }

        @Override // q3.c
        protected r0.d g() {
            return this.f7012a;
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        g f7014a;

        /* renamed from: b  reason: collision with root package name */
        i3.f f7015b;

        e(g gVar, i3.f fVar) {
            this.f7014a = gVar;
            this.f7015b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.f7001j = Long.valueOf(fVar.f6998g.a());
            f.this.f6994c.h();
            for (j jVar : q3.g.a(this.f7014a, this.f7015b)) {
                f fVar2 = f.this;
                jVar.a(fVar2.f6994c, fVar2.f7001j.longValue());
            }
            f fVar3 = f.this;
            fVar3.f6994c.e(fVar3.f7001j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q3.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0108f implements j {

        /* renamed from: a  reason: collision with root package name */
        private final g f7017a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.f f7018b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0108f(g gVar, i3.f fVar) {
            this.f7017a = gVar;
            this.f7018b = fVar;
        }

        @Override // q3.f.j
        public void a(c cVar, long j5) {
            List<b> n5 = f.n(cVar, this.f7017a.f7024f.f7036d.intValue());
            if (n5.size() < this.f7017a.f7024f.f7035c.intValue() || n5.size() == 0) {
                return;
            }
            for (b bVar : n5) {
                if (cVar.d() >= this.f7017a.f7022d.intValue()) {
                    return;
                }
                if (bVar.f() >= this.f7017a.f7024f.f7036d.intValue() && bVar.e() > this.f7017a.f7024f.f7033a.intValue() / 100.0d) {
                    this.f7018b.b(f.a.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", bVar, Double.valueOf(bVar.e()));
                    if (new Random().nextInt(100) < this.f7017a.f7024f.f7034b.intValue()) {
                        bVar.d(j5);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final Long f7019a;

        /* renamed from: b  reason: collision with root package name */
        public final Long f7020b;

        /* renamed from: c  reason: collision with root package name */
        public final Long f7021c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f7022d;

        /* renamed from: e  reason: collision with root package name */
        public final c f7023e;

        /* renamed from: f  reason: collision with root package name */
        public final b f7024f;

        /* renamed from: g  reason: collision with root package name */
        public final j2.b f7025g;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            Long f7026a = 10000000000L;

            /* renamed from: b  reason: collision with root package name */
            Long f7027b = 30000000000L;

            /* renamed from: c  reason: collision with root package name */
            Long f7028c = 300000000000L;

            /* renamed from: d  reason: collision with root package name */
            Integer f7029d = 10;

            /* renamed from: e  reason: collision with root package name */
            c f7030e;

            /* renamed from: f  reason: collision with root package name */
            b f7031f;

            /* renamed from: g  reason: collision with root package name */
            j2.b f7032g;

            public g a() {
                z0.k.t(this.f7032g != null);
                return new g(this.f7026a, this.f7027b, this.f7028c, this.f7029d, this.f7030e, this.f7031f, this.f7032g);
            }

            public a b(Long l5) {
                z0.k.d(l5 != null);
                this.f7027b = l5;
                return this;
            }

            public a c(j2.b bVar) {
                z0.k.t(bVar != null);
                this.f7032g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f7031f = bVar;
                return this;
            }

            public a e(Long l5) {
                z0.k.d(l5 != null);
                this.f7026a = l5;
                return this;
            }

            public a f(Integer num) {
                z0.k.d(num != null);
                this.f7029d = num;
                return this;
            }

            public a g(Long l5) {
                z0.k.d(l5 != null);
                this.f7028c = l5;
                return this;
            }

            public a h(c cVar) {
                this.f7030e = cVar;
                return this;
            }
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final Integer f7033a;

            /* renamed from: b  reason: collision with root package name */
            public final Integer f7034b;

            /* renamed from: c  reason: collision with root package name */
            public final Integer f7035c;

            /* renamed from: d  reason: collision with root package name */
            public final Integer f7036d;

            /* loaded from: classes.dex */
            public static class a {

                /* renamed from: a  reason: collision with root package name */
                Integer f7037a = 85;

                /* renamed from: b  reason: collision with root package name */
                Integer f7038b = 100;

                /* renamed from: c  reason: collision with root package name */
                Integer f7039c = 5;

                /* renamed from: d  reason: collision with root package name */
                Integer f7040d = 50;

                public b a() {
                    return new b(this.f7037a, this.f7038b, this.f7039c, this.f7040d);
                }

                public a b(Integer num) {
                    boolean z4 = true;
                    z0.k.d(num != null);
                    z0.k.d((num.intValue() < 0 || num.intValue() > 100) ? false : false);
                    this.f7038b = num;
                    return this;
                }

                public a c(Integer num) {
                    z0.k.d(num != null);
                    z0.k.d(num.intValue() >= 0);
                    this.f7039c = num;
                    return this;
                }

                public a d(Integer num) {
                    z0.k.d(num != null);
                    z0.k.d(num.intValue() >= 0);
                    this.f7040d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z4 = true;
                    z0.k.d(num != null);
                    z0.k.d((num.intValue() < 0 || num.intValue() > 100) ? false : false);
                    this.f7037a = num;
                    return this;
                }
            }

            b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f7033a = num;
                this.f7034b = num2;
                this.f7035c = num3;
                this.f7036d = num4;
            }
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public final Integer f7041a;

            /* renamed from: b  reason: collision with root package name */
            public final Integer f7042b;

            /* renamed from: c  reason: collision with root package name */
            public final Integer f7043c;

            /* renamed from: d  reason: collision with root package name */
            public final Integer f7044d;

            /* loaded from: classes.dex */
            public static final class a {

                /* renamed from: a  reason: collision with root package name */
                Integer f7045a = 1900;

                /* renamed from: b  reason: collision with root package name */
                Integer f7046b = 100;

                /* renamed from: c  reason: collision with root package name */
                Integer f7047c = 5;

                /* renamed from: d  reason: collision with root package name */
                Integer f7048d = 100;

                public c a() {
                    return new c(this.f7045a, this.f7046b, this.f7047c, this.f7048d);
                }

                public a b(Integer num) {
                    boolean z4 = true;
                    z0.k.d(num != null);
                    z0.k.d((num.intValue() < 0 || num.intValue() > 100) ? false : false);
                    this.f7046b = num;
                    return this;
                }

                public a c(Integer num) {
                    z0.k.d(num != null);
                    z0.k.d(num.intValue() >= 0);
                    this.f7047c = num;
                    return this;
                }

                public a d(Integer num) {
                    z0.k.d(num != null);
                    z0.k.d(num.intValue() >= 0);
                    this.f7048d = num;
                    return this;
                }

                public a e(Integer num) {
                    z0.k.d(num != null);
                    this.f7045a = num;
                    return this;
                }
            }

            c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f7041a = num;
                this.f7042b = num2;
                this.f7043c = num3;
                this.f7044d = num4;
            }
        }

        private g(Long l5, Long l6, Long l7, Integer num, c cVar, b bVar, j2.b bVar2) {
            this.f7019a = l5;
            this.f7020b = l6;
            this.f7021c = l7;
            this.f7022d = num;
            this.f7023e = cVar;
            this.f7024f = bVar;
            this.f7025g = bVar2;
        }

        boolean a() {
            return (this.f7023e == null && this.f7024f == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    class h extends r0.i {

        /* renamed from: a  reason: collision with root package name */
        private final r0.i f7049a;

        /* loaded from: classes.dex */
        class a extends k.a {

            /* renamed from: a  reason: collision with root package name */
            private final b f7051a;

            /* renamed from: b  reason: collision with root package name */
            private final k.a f7052b;

            /* renamed from: q3.f$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0109a extends q3.a {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ i3.k f7054b;

                C0109a(i3.k kVar) {
                    this.f7054b = kVar;
                }

                @Override // i3.m1
                public void i(j1 j1Var) {
                    a.this.f7051a.g(j1Var.o());
                    o().i(j1Var);
                }

                @Override // q3.a
                protected i3.k o() {
                    return this.f7054b;
                }
            }

            /* loaded from: classes.dex */
            class b extends i3.k {
                b() {
                }

                @Override // i3.m1
                public void i(j1 j1Var) {
                    a.this.f7051a.g(j1Var.o());
                }
            }

            a(b bVar, k.a aVar) {
                this.f7051a = bVar;
                this.f7052b = aVar;
            }

            @Override // i3.k.a
            public i3.k a(k.b bVar, y0 y0Var) {
                k.a aVar = this.f7052b;
                return aVar != null ? new C0109a(aVar.a(bVar, y0Var)) : new b();
            }
        }

        h(r0.i iVar) {
            this.f7049a = iVar;
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            r0.e a5 = this.f7049a.a(fVar);
            r0.h c5 = a5.c();
            return c5 != null ? r0.e.i(c5, new a((b) c5.c().b(f.f6993l), a5.b())) : a5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends q3.d {

        /* renamed from: a  reason: collision with root package name */
        private final r0.h f7057a;

        /* renamed from: b  reason: collision with root package name */
        private b f7058b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7059c;

        /* renamed from: d  reason: collision with root package name */
        private q f7060d;

        /* renamed from: e  reason: collision with root package name */
        private r0.j f7061e;

        /* renamed from: f  reason: collision with root package name */
        private final i3.f f7062f;

        /* loaded from: classes.dex */
        class a implements r0.j {

            /* renamed from: a  reason: collision with root package name */
            private final r0.j f7064a;

            a(r0.j jVar) {
                this.f7064a = jVar;
            }

            @Override // i3.r0.j
            public void a(q qVar) {
                i.this.f7060d = qVar;
                if (i.this.f7059c) {
                    return;
                }
                this.f7064a.a(qVar);
            }
        }

        i(r0.h hVar) {
            this.f7057a = hVar;
            this.f7062f = hVar.d();
        }

        @Override // i3.r0.h
        public i3.a c() {
            return this.f7058b != null ? this.f7057a.c().d().d(f.f6993l, this.f7058b).a() : this.f7057a.c();
        }

        @Override // q3.d, i3.r0.h
        public void h(r0.j jVar) {
            this.f7061e = jVar;
            super.h(new a(jVar));
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
            if (r3.f7063g.f6994c.containsKey(r0) != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
            if (r3.f7063g.f6994c.containsKey(r0) != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
            r3.f7063g.f6994c.get(r0).b(r3);
         */
        @Override // i3.r0.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(java.util.List<i3.x> r4) {
            /*
                r3 = this;
                java.util.List r0 = r3.b()
                boolean r0 = q3.f.j(r0)
                r1 = 0
                if (r0 == 0) goto L3d
                boolean r0 = q3.f.j(r4)
                if (r0 == 0) goto L3d
                q3.f r0 = q3.f.this
                q3.f$c r0 = r0.f6994c
                q3.f$b r2 = r3.f7058b
                boolean r0 = r0.containsValue(r2)
                if (r0 == 0) goto L22
                q3.f$b r0 = r3.f7058b
                r0.i(r3)
            L22:
                java.lang.Object r0 = r4.get(r1)
                i3.x r0 = (i3.x) r0
                java.util.List r0 = r0.a()
                java.lang.Object r0 = r0.get(r1)
                java.net.SocketAddress r0 = (java.net.SocketAddress) r0
                q3.f r1 = q3.f.this
                q3.f$c r1 = r1.f6994c
                boolean r1 = r1.containsKey(r0)
                if (r1 == 0) goto Lb7
                goto Laa
            L3d:
                java.util.List r0 = r3.b()
                boolean r0 = q3.f.j(r0)
                if (r0 == 0) goto L80
                boolean r0 = q3.f.j(r4)
                if (r0 != 0) goto L80
                q3.f r0 = q3.f.this
                q3.f$c r0 = r0.f6994c
                i3.x r2 = r3.a()
                java.util.List r2 = r2.a()
                java.lang.Object r2 = r2.get(r1)
                boolean r0 = r0.containsKey(r2)
                if (r0 == 0) goto Lb7
                q3.f r0 = q3.f.this
                q3.f$c r0 = r0.f6994c
                i3.x r2 = r3.a()
                java.util.List r2 = r2.a()
                java.lang.Object r1 = r2.get(r1)
                java.lang.Object r0 = r0.get(r1)
                q3.f$b r0 = (q3.f.b) r0
                r0.i(r3)
                r0.j()
                goto Lb7
            L80:
                java.util.List r0 = r3.b()
                boolean r0 = q3.f.j(r0)
                if (r0 != 0) goto Lb7
                boolean r0 = q3.f.j(r4)
                if (r0 == 0) goto Lb7
                java.lang.Object r0 = r4.get(r1)
                i3.x r0 = (i3.x) r0
                java.util.List r0 = r0.a()
                java.lang.Object r0 = r0.get(r1)
                java.net.SocketAddress r0 = (java.net.SocketAddress) r0
                q3.f r1 = q3.f.this
                q3.f$c r1 = r1.f6994c
                boolean r1 = r1.containsKey(r0)
                if (r1 == 0) goto Lb7
            Laa:
                q3.f r1 = q3.f.this
                q3.f$c r1 = r1.f6994c
                java.lang.Object r0 = r1.get(r0)
                q3.f$b r0 = (q3.f.b) r0
                r0.b(r3)
            Lb7:
                i3.r0$h r0 = r3.f7057a
                r0.i(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q3.f.i.i(java.util.List):void");
        }

        @Override // q3.d
        protected r0.h j() {
            return this.f7057a;
        }

        void m() {
            this.f7058b = null;
        }

        void n() {
            this.f7059c = true;
            this.f7061e.a(q.b(j1.f3447u));
            this.f7062f.b(f.a.INFO, "Subchannel ejected: {0}", this);
        }

        boolean o() {
            return this.f7059c;
        }

        void p(b bVar) {
            this.f7058b = bVar;
        }

        void q() {
            this.f7059c = false;
            q qVar = this.f7060d;
            if (qVar != null) {
                this.f7061e.a(qVar);
                this.f7062f.b(f.a.INFO, "Subchannel unejected: {0}", this);
            }
        }

        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.f7057a.b() + '}';
        }
    }

    /* loaded from: classes.dex */
    interface j {
        void a(c cVar, long j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class k implements j {

        /* renamed from: a  reason: collision with root package name */
        private final g f7066a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.f f7067b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(g gVar, i3.f fVar) {
            z0.k.e(gVar.f7023e != null, "success rate ejection config is null");
            this.f7066a = gVar;
            this.f7067b = fVar;
        }

        static double b(Collection<Double> collection) {
            double d5 = 0.0d;
            for (Double d6 : collection) {
                d5 += d6.doubleValue();
            }
            return d5 / collection.size();
        }

        static double c(Collection<Double> collection, double d5) {
            double d6 = 0.0d;
            for (Double d7 : collection) {
                double doubleValue = d7.doubleValue() - d5;
                d6 += doubleValue * doubleValue;
            }
            return Math.sqrt(d6 / collection.size());
        }

        @Override // q3.f.j
        public void a(c cVar, long j5) {
            List<b> n5 = f.n(cVar, this.f7066a.f7023e.f7044d.intValue());
            if (n5.size() < this.f7066a.f7023e.f7043c.intValue() || n5.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : n5) {
                arrayList.add(Double.valueOf(bVar.n()));
            }
            double b5 = b(arrayList);
            double c5 = c(arrayList, b5);
            double intValue = b5 - ((this.f7066a.f7023e.f7041a.intValue() / 1000.0f) * c5);
            for (b bVar2 : n5) {
                if (cVar.d() >= this.f7066a.f7022d.intValue()) {
                    return;
                }
                if (bVar2.n() < intValue) {
                    this.f7067b.b(f.a.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", bVar2, Double.valueOf(bVar2.n()), Double.valueOf(b5), Double.valueOf(c5), Double.valueOf(intValue));
                    if (new Random().nextInt(100) < this.f7066a.f7023e.f7042b.intValue()) {
                        bVar2.d(j5);
                    }
                }
            }
        }
    }

    public f(r0.d dVar, q2 q2Var) {
        i3.f b5 = dVar.b();
        this.f7002k = b5;
        d dVar2 = new d((r0.d) z0.k.o(dVar, "helper"));
        this.f6996e = dVar2;
        this.f6997f = new q3.e(dVar2);
        this.f6994c = new c();
        this.f6995d = (n1) z0.k.o(dVar.d(), "syncContext");
        this.f6999h = (ScheduledExecutorService) z0.k.o(dVar.c(), "timeService");
        this.f6998g = q2Var;
        b5.a(f.a.DEBUG, "OutlierDetection lb created.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(List<x> list) {
        int i5 = 0;
        for (x xVar : list) {
            i5 += xVar.a().size();
            if (i5 > 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<b> n(c cVar, int i5) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= i5) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // i3.r0
    public boolean a(r0.g gVar) {
        this.f7002k.b(f.a.DEBUG, "Received resolution result: {0}", gVar);
        g gVar2 = (g) gVar.c();
        ArrayList arrayList = new ArrayList();
        for (x xVar : gVar.a()) {
            arrayList.addAll(xVar.a());
        }
        this.f6994c.keySet().retainAll(arrayList);
        this.f6994c.i(gVar2);
        this.f6994c.f(gVar2, arrayList);
        this.f6997f.r(gVar2.f7025g.b());
        if (gVar2.a()) {
            Long valueOf = this.f7001j == null ? gVar2.f7019a : Long.valueOf(Math.max(0L, gVar2.f7019a.longValue() - (this.f6998g.a() - this.f7001j.longValue())));
            n1.d dVar = this.f7000i;
            if (dVar != null) {
                dVar.a();
                this.f6994c.g();
            }
            this.f7000i = this.f6995d.d(new e(gVar2, this.f7002k), valueOf.longValue(), gVar2.f7019a.longValue(), TimeUnit.NANOSECONDS, this.f6999h);
        } else {
            n1.d dVar2 = this.f7000i;
            if (dVar2 != null) {
                dVar2.a();
                this.f7001j = null;
                this.f6994c.c();
            }
        }
        this.f6997f.d(gVar.e().d(gVar2.f7025g.a()).a());
        return true;
    }

    @Override // i3.r0
    public void c(j1 j1Var) {
        this.f6997f.c(j1Var);
    }

    @Override // i3.r0
    public void f() {
        this.f6997f.f();
    }
}
