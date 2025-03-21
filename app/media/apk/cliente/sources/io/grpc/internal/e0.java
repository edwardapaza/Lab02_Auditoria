package io.grpc.internal;

import i3.a1;
import io.grpc.internal.k2;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class e0 extends i3.a1 {
    private static final g A;
    private static String B;

    /* renamed from: s  reason: collision with root package name */
    private static final Logger f4668s = Logger.getLogger(e0.class.getName());

    /* renamed from: t  reason: collision with root package name */
    private static final Set<String> f4669t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* renamed from: u  reason: collision with root package name */
    private static final String f4670u;

    /* renamed from: v  reason: collision with root package name */
    private static final String f4671v;

    /* renamed from: w  reason: collision with root package name */
    private static final String f4672w;

    /* renamed from: x  reason: collision with root package name */
    static boolean f4673x;

    /* renamed from: y  reason: collision with root package name */
    static boolean f4674y;

    /* renamed from: z  reason: collision with root package name */
    protected static boolean f4675z;

    /* renamed from: a  reason: collision with root package name */
    final i3.g1 f4676a;

    /* renamed from: b  reason: collision with root package name */
    private final Random f4677b = new Random();

    /* renamed from: c  reason: collision with root package name */
    protected volatile b f4678c = d.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<f> f4679d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final String f4680e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4681f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4682g;

    /* renamed from: h  reason: collision with root package name */
    private final k2.d<Executor> f4683h;

    /* renamed from: i  reason: collision with root package name */
    private final long f4684i;

    /* renamed from: j  reason: collision with root package name */
    private final i3.n1 f4685j;

    /* renamed from: k  reason: collision with root package name */
    private final z0.m f4686k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f4687l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4688m;

    /* renamed from: n  reason: collision with root package name */
    private Executor f4689n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f4690o;

    /* renamed from: p  reason: collision with root package name */
    private final a1.h f4691p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4692q;

    /* renamed from: r  reason: collision with root package name */
    private a1.e f4693r;

    /* loaded from: classes.dex */
    public interface b {
        List<InetAddress> a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private i3.j1 f4694a;

        /* renamed from: b  reason: collision with root package name */
        private List<i3.x> f4695b;

        /* renamed from: c  reason: collision with root package name */
        private a1.c f4696c;

        /* renamed from: d  reason: collision with root package name */
        public i3.a f4697d;

        private c() {
        }
    }

    /* loaded from: classes.dex */
    private enum d implements b {
        INSTANCE;

        @Override // io.grpc.internal.e0.b
        public List<InetAddress> a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final a1.e f4700a;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f4702a;

            a(boolean z4) {
                this.f4702a = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4702a) {
                    e0 e0Var = e0.this;
                    e0Var.f4687l = true;
                    if (e0Var.f4684i > 0) {
                        e0.this.f4686k.f().g();
                    }
                }
                e0.this.f4692q = false;
            }
        }

        e(a1.e eVar) {
            this.f4700a = (a1.e) z0.k.o(eVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            i3.n1 n1Var;
            a aVar;
            Logger logger = e0.f4668s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                Logger logger2 = e0.f4668s;
                logger2.finer("Attempting DNS resolution of " + e0.this.f4681f);
            }
            c cVar = null;
            boolean z4 = true;
            try {
                try {
                    i3.x n5 = e0.this.n();
                    a1.g.a d5 = a1.g.d();
                    if (n5 != null) {
                        if (e0.f4668s.isLoggable(level)) {
                            Logger logger3 = e0.f4668s;
                            logger3.finer("Using proxy address " + n5);
                        }
                        d5.b(Collections.singletonList(n5));
                    } else {
                        cVar = e0.this.o(false);
                        if (cVar.f4694a != null) {
                            this.f4700a.a(cVar.f4694a);
                            return;
                        }
                        if (cVar.f4695b != null) {
                            d5.b(cVar.f4695b);
                        }
                        if (cVar.f4696c != null) {
                            d5.d(cVar.f4696c);
                        }
                        i3.a aVar2 = cVar.f4697d;
                        if (aVar2 != null) {
                            d5.c(aVar2);
                        }
                    }
                    this.f4700a.c(d5.a());
                    z4 = (cVar == null || cVar.f4694a != null) ? false : false;
                    n1Var = e0.this.f4685j;
                    aVar = new a(z4);
                } catch (IOException e5) {
                    a1.e eVar = this.f4700a;
                    i3.j1 j1Var = i3.j1.f3447u;
                    eVar.a(j1Var.q("Unable to resolve host " + e0.this.f4681f).p(e5));
                    z4 = (0 == 0 || null.f4694a != null) ? false : false;
                    n1Var = e0.this.f4685j;
                    aVar = new a(z4);
                }
                n1Var.execute(aVar);
            } finally {
                e0.this.f4685j.execute(new a((0 == 0 || null.f4694a != null) ? false : false));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        List<String> a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        f a();

        Throwable b();
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        f4670u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        f4671v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f4672w = property3;
        f4673x = Boolean.parseBoolean(property);
        f4674y = Boolean.parseBoolean(property2);
        f4675z = Boolean.parseBoolean(property3);
        A = v(e0.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e0(String str, String str2, a1.b bVar, k2.d<Executor> dVar, z0.m mVar, boolean z4) {
        z0.k.o(bVar, "args");
        this.f4683h = dVar;
        URI create = URI.create("//" + ((String) z0.k.o(str2, "name")));
        z0.k.j(create.getHost() != null, "Invalid DNS name: %s", str2);
        this.f4680e = (String) z0.k.p(create.getAuthority(), "nameUri (%s) doesn't have an authority", create);
        this.f4681f = create.getHost();
        this.f4682g = create.getPort() == -1 ? bVar.a() : create.getPort();
        this.f4676a = (i3.g1) z0.k.o(bVar.c(), "proxyDetector");
        this.f4684i = s(z4);
        this.f4686k = (z0.m) z0.k.o(mVar, "stopwatch");
        this.f4685j = (i3.n1) z0.k.o(bVar.f(), "syncContext");
        Executor b5 = bVar.b();
        this.f4689n = b5;
        this.f4690o = b5 == null;
        this.f4691p = (a1.h) z0.k.o(bVar.e(), "serviceConfigParser");
    }

    private List<i3.x> A() {
        Exception e5 = null;
        try {
            try {
                List<InetAddress> a5 = this.f4678c.a(this.f4681f);
                ArrayList arrayList = new ArrayList(a5.size());
                for (InetAddress inetAddress : a5) {
                    arrayList.add(new i3.x(new InetSocketAddress(inetAddress, this.f4682g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e6) {
                e5 = e6;
                z0.p.f(e5);
                throw new RuntimeException(e5);
            }
        } catch (Throwable th) {
            if (e5 != null) {
                f4668s.log(Level.FINE, "Address resolution failure", (Throwable) e5);
            }
            throw th;
        }
    }

    private a1.c B() {
        List<String> emptyList = Collections.emptyList();
        f u5 = u();
        if (u5 != null) {
            try {
                emptyList = u5.a("_grpc_config." + this.f4681f);
            } catch (Exception e5) {
                f4668s.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e5);
            }
        }
        if (emptyList.isEmpty()) {
            f4668s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f4681f});
            return null;
        }
        a1.c x4 = x(emptyList, this.f4677b, r());
        if (x4 != null) {
            return x4.d() != null ? a1.c.b(x4.d()) : this.f4691p.a((Map) x4.c());
        }
        return null;
    }

    protected static boolean C(boolean z4, boolean z5, String str) {
        if (z4) {
            if ("localhost".equalsIgnoreCase(str)) {
                return z5;
            }
            if (str.contains(":")) {
                return false;
            }
            boolean z6 = true;
            for (int i5 = 0; i5 < str.length(); i5++) {
                char charAt = str.charAt(i5);
                if (charAt != '.') {
                    z6 &= charAt >= '0' && charAt <= '9';
                }
            }
            return true ^ z6;
        }
        return false;
    }

    private boolean m() {
        if (this.f4687l) {
            long j5 = this.f4684i;
            if (j5 != 0 && (j5 <= 0 || this.f4686k.d(TimeUnit.NANOSECONDS) <= this.f4684i)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i3.x n() {
        i3.f1 a5 = this.f4676a.a(InetSocketAddress.createUnresolved(this.f4681f, this.f4682g));
        if (a5 != null) {
            return new i3.x(a5);
        }
        return null;
    }

    private static final List<String> p(Map<String, ?> map) {
        return d1.g(map, "clientLanguage");
    }

    private static final List<String> q(Map<String, ?> map) {
        return d1.g(map, "clientHostname");
    }

    private static String r() {
        if (B == null) {
            try {
                B = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e5) {
                throw new RuntimeException(e5);
            }
        }
        return B;
    }

    private static long s(boolean z4) {
        if (z4) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j5 = 30;
        if (property != null) {
            try {
                j5 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f4668s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j5 > 0 ? TimeUnit.SECONDS.toNanos(j5) : j5;
    }

    private static final Double t(Map<String, ?> map) {
        return d1.h(map, "percentage");
    }

    static g v(ClassLoader classLoader) {
        Logger logger;
        Level level;
        String str;
        g gVar;
        try {
            try {
                try {
                    gVar = (g) Class.forName("io.grpc.internal.b1", true, classLoader).asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e5) {
                    e = e5;
                    logger = f4668s;
                    level = Level.FINE;
                    str = "Can't construct JndiResourceResolverFactory, skipping.";
                }
            } catch (Exception e6) {
                e = e6;
                logger = f4668s;
                level = Level.FINE;
                str = "Can't find JndiResourceResolverFactory ctor, skipping.";
            }
        } catch (ClassCastException e7) {
            e = e7;
            logger = f4668s;
            level = Level.FINE;
            str = "Unable to cast JndiResourceResolverFactory, skipping.";
        } catch (ClassNotFoundException e8) {
            e = e8;
            logger = f4668s;
            level = Level.FINE;
            str = "Unable to find JndiResourceResolverFactory, skipping.";
        }
        if (gVar.b() != null) {
            logger = f4668s;
            level = Level.FINE;
            e = gVar.b();
            str = "JndiResourceResolverFactory not available, skipping.";
            logger.log(level, str, e);
            return null;
        }
        return gVar;
    }

    static Map<String, ?> w(Map<String, ?> map, Random random, String str) {
        boolean z4;
        boolean z5;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            z0.r.a(f4669t.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> p5 = p(map);
        if (p5 != null && !p5.isEmpty()) {
            Iterator<String> it = p5.iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("java".equalsIgnoreCase(it.next())) {
                        z5 = true;
                        break;
                    }
                } else {
                    z5 = false;
                    break;
                }
            }
            if (!z5) {
                return null;
            }
        }
        Double t5 = t(map);
        if (t5 != null) {
            int intValue = t5.intValue();
            z0.r.a(intValue >= 0 && intValue <= 100, "Bad percentage: %s", t5);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> q5 = q(map);
        if (q5 != null && !q5.isEmpty()) {
            Iterator<String> it2 = q5.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(str)) {
                        z4 = true;
                        break;
                    }
                } else {
                    z4 = false;
                    break;
                }
            }
            if (!z4) {
                return null;
            }
        }
        Map<String, ?> j5 = d1.j(map, "serviceConfig");
        if (j5 != null) {
            return j5;
        }
        throw new z0.s(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    static a1.c x(List<String> list, Random random, String str) {
        i3.j1 j1Var;
        String str2;
        try {
            Map<String, ?> map = null;
            for (Map<String, ?> map2 : y(list)) {
                try {
                    map = w(map2, random, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e5) {
                    e = e5;
                    j1Var = i3.j1.f3434h;
                    str2 = "failed to pick service config choice";
                    return a1.c.b(j1Var.q(str2).p(e));
                }
            }
            if (map == null) {
                return null;
            }
            return a1.c.a(map);
        } catch (IOException | RuntimeException e6) {
            e = e6;
            j1Var = i3.j1.f3434h;
            str2 = "failed to parse TXT records";
        }
    }

    static List<Map<String, ?>> y(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith("grpc_config=")) {
                Object a5 = c1.a(str.substring(12));
                if (!(a5 instanceof List)) {
                    throw new ClassCastException("wrong type " + a5);
                }
                arrayList.addAll(d1.a((List) a5));
            } else {
                f4668s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    private void z() {
        if (this.f4692q || this.f4688m || !m()) {
            return;
        }
        this.f4692q = true;
        this.f4689n.execute(new e(this.f4693r));
    }

    @Override // i3.a1
    public String a() {
        return this.f4680e;
    }

    @Override // i3.a1
    public void b() {
        z0.k.u(this.f4693r != null, "not started");
        z();
    }

    @Override // i3.a1
    public void c() {
        if (this.f4688m) {
            return;
        }
        this.f4688m = true;
        Executor executor = this.f4689n;
        if (executor == null || !this.f4690o) {
            return;
        }
        this.f4689n = (Executor) k2.f(this.f4683h, executor);
    }

    @Override // i3.a1
    public void d(a1.e eVar) {
        z0.k.u(this.f4693r == null, "already started");
        if (this.f4690o) {
            this.f4689n = (Executor) k2.d(this.f4683h);
        }
        this.f4693r = (a1.e) z0.k.o(eVar, "listener");
        z();
    }

    protected c o(boolean z4) {
        c cVar = new c();
        try {
            cVar.f4695b = A();
        } catch (Exception e5) {
            if (!z4) {
                i3.j1 j1Var = i3.j1.f3447u;
                cVar.f4694a = j1Var.q("Unable to resolve host " + this.f4681f).p(e5);
                return cVar;
            }
        }
        if (f4675z) {
            cVar.f4696c = B();
        }
        return cVar;
    }

    protected f u() {
        g gVar;
        if (C(f4673x, f4674y, this.f4681f)) {
            f fVar = this.f4679d.get();
            return (fVar != null || (gVar = A) == null) ? fVar : gVar.a();
        }
        return null;
    }
}
