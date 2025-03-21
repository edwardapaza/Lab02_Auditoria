package i3;

import i3.a1;
import i3.i1;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f3374e = Logger.getLogger(c1.class.getName());

    /* renamed from: f  reason: collision with root package name */
    private static c1 f3375f;

    /* renamed from: a  reason: collision with root package name */
    private final a1.d f3376a = new b();

    /* renamed from: b  reason: collision with root package name */
    private String f3377b = "unknown";

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashSet<b1> f3378c = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private a1.k<String, b1> f3379d = a1.k.i();

    /* loaded from: classes.dex */
    private final class b extends a1.d {
        private b() {
        }

        @Override // i3.a1.d
        public String a() {
            String str;
            synchronized (c1.this) {
                str = c1.this.f3377b;
            }
            return str;
        }

        @Override // i3.a1.d
        public a1 b(URI uri, a1.b bVar) {
            b1 b1Var;
            String scheme = uri.getScheme();
            if (scheme == null || (b1Var = c1.this.f().get(scheme.toLowerCase(Locale.US))) == null) {
                return null;
            }
            return b1Var.b(uri, bVar);
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements i1.b<b1> {
        private c() {
        }

        @Override // i3.i1.b
        /* renamed from: c */
        public int b(b1 b1Var) {
            return b1Var.e();
        }

        @Override // i3.i1.b
        /* renamed from: d */
        public boolean a(b1 b1Var) {
            return b1Var.d();
        }
    }

    private synchronized void b(b1 b1Var) {
        z0.k.e(b1Var.d(), "isAvailable() returned false");
        this.f3378c.add(b1Var);
    }

    public static synchronized c1 d() {
        c1 c1Var;
        synchronized (c1.class) {
            if (f3375f == null) {
                List<b1> e5 = i1.e(b1.class, e(), b1.class.getClassLoader(), new c());
                if (e5.isEmpty()) {
                    f3374e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                f3375f = new c1();
                for (b1 b1Var : e5) {
                    Logger logger = f3374e;
                    logger.fine("Service loader found " + b1Var);
                    f3375f.b(b1Var);
                }
                f3375f.g();
            }
            c1Var = f3375f;
        }
        return c1Var;
    }

    static List<Class<?>> e() {
        ArrayList arrayList = new ArrayList();
        try {
            int i5 = io.grpc.internal.f0.f4753b;
            arrayList.add(io.grpc.internal.f0.class);
        } catch (ClassNotFoundException e5) {
            f3374e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e5);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void g() {
        HashMap hashMap = new HashMap();
        int i5 = Integer.MIN_VALUE;
        String str = "unknown";
        Iterator<b1> it = this.f3378c.iterator();
        while (it.hasNext()) {
            b1 next = it.next();
            String c5 = next.c();
            b1 b1Var = (b1) hashMap.get(c5);
            if (b1Var == null || b1Var.e() < next.e()) {
                hashMap.put(c5, next);
            }
            if (i5 < next.e()) {
                i5 = next.e();
                str = next.c();
            }
        }
        this.f3379d = a1.k.b(hashMap);
        this.f3377b = str;
    }

    public a1.d c() {
        return this.f3376a;
    }

    synchronized Map<String, b1> f() {
        return this.f3379d;
    }
}
