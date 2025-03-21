package i3;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import z0.f;
/* loaded from: classes.dex */
public abstract class a1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f3314a;

        a(f fVar) {
            this.f3314a = fVar;
        }

        @Override // i3.a1.e, i3.a1.f
        public void a(j1 j1Var) {
            this.f3314a.a(j1Var);
        }

        @Override // i3.a1.e
        public void c(g gVar) {
            this.f3314a.b(gVar.a(), gVar.b());
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f3316a;

        /* renamed from: b  reason: collision with root package name */
        private final g1 f3317b;

        /* renamed from: c  reason: collision with root package name */
        private final n1 f3318c;

        /* renamed from: d  reason: collision with root package name */
        private final h f3319d;

        /* renamed from: e  reason: collision with root package name */
        private final ScheduledExecutorService f3320e;

        /* renamed from: f  reason: collision with root package name */
        private final i3.f f3321f;

        /* renamed from: g  reason: collision with root package name */
        private final Executor f3322g;

        /* renamed from: h  reason: collision with root package name */
        private final String f3323h;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private Integer f3324a;

            /* renamed from: b  reason: collision with root package name */
            private g1 f3325b;

            /* renamed from: c  reason: collision with root package name */
            private n1 f3326c;

            /* renamed from: d  reason: collision with root package name */
            private h f3327d;

            /* renamed from: e  reason: collision with root package name */
            private ScheduledExecutorService f3328e;

            /* renamed from: f  reason: collision with root package name */
            private i3.f f3329f;

            /* renamed from: g  reason: collision with root package name */
            private Executor f3330g;

            /* renamed from: h  reason: collision with root package name */
            private String f3331h;

            a() {
            }

            public b a() {
                return new b(this.f3324a, this.f3325b, this.f3326c, this.f3327d, this.f3328e, this.f3329f, this.f3330g, this.f3331h, null);
            }

            public a b(i3.f fVar) {
                this.f3329f = (i3.f) z0.k.n(fVar);
                return this;
            }

            public a c(int i5) {
                this.f3324a = Integer.valueOf(i5);
                return this;
            }

            public a d(Executor executor) {
                this.f3330g = executor;
                return this;
            }

            public a e(String str) {
                this.f3331h = str;
                return this;
            }

            public a f(g1 g1Var) {
                this.f3325b = (g1) z0.k.n(g1Var);
                return this;
            }

            public a g(ScheduledExecutorService scheduledExecutorService) {
                this.f3328e = (ScheduledExecutorService) z0.k.n(scheduledExecutorService);
                return this;
            }

            public a h(h hVar) {
                this.f3327d = (h) z0.k.n(hVar);
                return this;
            }

            public a i(n1 n1Var) {
                this.f3326c = (n1) z0.k.n(n1Var);
                return this;
            }
        }

        private b(Integer num, g1 g1Var, n1 n1Var, h hVar, ScheduledExecutorService scheduledExecutorService, i3.f fVar, Executor executor, String str) {
            this.f3316a = ((Integer) z0.k.o(num, "defaultPort not set")).intValue();
            this.f3317b = (g1) z0.k.o(g1Var, "proxyDetector not set");
            this.f3318c = (n1) z0.k.o(n1Var, "syncContext not set");
            this.f3319d = (h) z0.k.o(hVar, "serviceConfigParser not set");
            this.f3320e = scheduledExecutorService;
            this.f3321f = fVar;
            this.f3322g = executor;
            this.f3323h = str;
        }

        /* synthetic */ b(Integer num, g1 g1Var, n1 n1Var, h hVar, ScheduledExecutorService scheduledExecutorService, i3.f fVar, Executor executor, String str, a aVar) {
            this(num, g1Var, n1Var, hVar, scheduledExecutorService, fVar, executor, str);
        }

        public static a g() {
            return new a();
        }

        public int a() {
            return this.f3316a;
        }

        public Executor b() {
            return this.f3322g;
        }

        public g1 c() {
            return this.f3317b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f3320e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public h e() {
            return this.f3319d;
        }

        public n1 f() {
            return this.f3318c;
        }

        public String toString() {
            return z0.f.b(this).b("defaultPort", this.f3316a).d("proxyDetector", this.f3317b).d("syncContext", this.f3318c).d("serviceConfigParser", this.f3319d).d("scheduledExecutorService", this.f3320e).d("channelLogger", this.f3321f).d("executor", this.f3322g).d("overrideAuthority", this.f3323h).toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final j1 f3332a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f3333b;

        private c(j1 j1Var) {
            this.f3333b = null;
            this.f3332a = (j1) z0.k.o(j1Var, "status");
            z0.k.j(!j1Var.o(), "cannot use OK status: %s", j1Var);
        }

        private c(Object obj) {
            this.f3333b = z0.k.o(obj, "config");
            this.f3332a = null;
        }

        public static c a(Object obj) {
            return new c(obj);
        }

        public static c b(j1 j1Var) {
            return new c(j1Var);
        }

        public Object c() {
            return this.f3333b;
        }

        public j1 d() {
            return this.f3332a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return z0.g.a(this.f3332a, cVar.f3332a) && z0.g.a(this.f3333b, cVar.f3333b);
        }

        public int hashCode() {
            return z0.g.b(this.f3332a, this.f3333b);
        }

        public String toString() {
            f.b b5;
            Object obj;
            String str;
            if (this.f3333b != null) {
                b5 = z0.f.b(this);
                obj = this.f3333b;
                str = "config";
            } else {
                b5 = z0.f.b(this);
                obj = this.f3332a;
                str = "error";
            }
            return b5.d(str, obj).toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract String a();

        public abstract a1 b(URI uri, b bVar);
    }

    /* loaded from: classes.dex */
    public static abstract class e implements f {
        @Override // i3.a1.f
        public abstract void a(j1 j1Var);

        @Override // i3.a1.f
        @Deprecated
        public final void b(List<x> list, i3.a aVar) {
            c(g.d().b(list).c(aVar).a());
        }

        public abstract void c(g gVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(j1 j1Var);

        void b(List<x> list, i3.a aVar);
    }

    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final List<x> f3334a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.a f3335b;

        /* renamed from: c  reason: collision with root package name */
        private final c f3336c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private List<x> f3337a = Collections.emptyList();

            /* renamed from: b  reason: collision with root package name */
            private i3.a f3338b = i3.a.f3307c;

            /* renamed from: c  reason: collision with root package name */
            private c f3339c;

            a() {
            }

            public g a() {
                return new g(this.f3337a, this.f3338b, this.f3339c);
            }

            public a b(List<x> list) {
                this.f3337a = list;
                return this;
            }

            public a c(i3.a aVar) {
                this.f3338b = aVar;
                return this;
            }

            public a d(c cVar) {
                this.f3339c = cVar;
                return this;
            }
        }

        g(List<x> list, i3.a aVar, c cVar) {
            this.f3334a = Collections.unmodifiableList(new ArrayList(list));
            this.f3335b = (i3.a) z0.k.o(aVar, "attributes");
            this.f3336c = cVar;
        }

        public static a d() {
            return new a();
        }

        public List<x> a() {
            return this.f3334a;
        }

        public i3.a b() {
            return this.f3335b;
        }

        public c c() {
            return this.f3336c;
        }

        public a e() {
            return d().b(this.f3334a).c(this.f3335b).d(this.f3336c);
        }

        public boolean equals(Object obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return z0.g.a(this.f3334a, gVar.f3334a) && z0.g.a(this.f3335b, gVar.f3335b) && z0.g.a(this.f3336c, gVar.f3336c);
            }
            return false;
        }

        public int hashCode() {
            return z0.g.b(this.f3334a, this.f3335b, this.f3336c);
        }

        public String toString() {
            return z0.f.b(this).d("addresses", this.f3334a).d("attributes", this.f3335b).d("serviceConfig", this.f3336c).toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract c a(Map<String, ?> map);
    }

    public abstract String a();

    public void b() {
    }

    public abstract void c();

    public void d(e eVar) {
        e(eVar);
    }

    public void e(f fVar) {
        if (fVar instanceof e) {
            d((e) fVar);
        } else {
            d(new a(fVar));
        }
    }
}
