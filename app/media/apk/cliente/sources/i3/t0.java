package i3;

import i3.i1;
import io.grpc.internal.u1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: d  reason: collision with root package name */
    private static t0 f3567d;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashSet<s0> f3569a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashMap<String, s0> f3570b = new LinkedHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f3566c = Logger.getLogger(t0.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private static final Iterable<Class<?>> f3568e = c();

    /* loaded from: classes.dex */
    private static final class a implements i1.b<s0> {
        a() {
        }

        @Override // i3.i1.b
        /* renamed from: c */
        public int b(s0 s0Var) {
            return s0Var.c();
        }

        @Override // i3.i1.b
        /* renamed from: d */
        public boolean a(s0 s0Var) {
            return s0Var.d();
        }
    }

    private synchronized void a(s0 s0Var) {
        z0.k.e(s0Var.d(), "isAvailable() returned false");
        this.f3569a.add(s0Var);
    }

    public static synchronized t0 b() {
        t0 t0Var;
        synchronized (t0.class) {
            if (f3567d == null) {
                List<s0> e5 = i1.e(s0.class, f3568e, s0.class.getClassLoader(), new a());
                f3567d = new t0();
                for (s0 s0Var : e5) {
                    Logger logger = f3566c;
                    logger.fine("Service loader found " + s0Var);
                    f3567d.a(s0Var);
                }
                f3567d.e();
            }
            t0Var = f3567d;
        }
        return t0Var;
    }

    static List<Class<?>> c() {
        ArrayList arrayList = new ArrayList();
        try {
            int i5 = u1.f5273c;
            arrayList.add(u1.class);
        } catch (ClassNotFoundException e5) {
            f3566c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e5);
        }
        try {
            int i6 = q3.j.f7082b;
            arrayList.add(q3.j.class);
        } catch (ClassNotFoundException e6) {
            f3566c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e6);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void e() {
        this.f3570b.clear();
        Iterator<s0> it = this.f3569a.iterator();
        while (it.hasNext()) {
            s0 next = it.next();
            String b5 = next.b();
            s0 s0Var = this.f3570b.get(b5);
            if (s0Var == null || s0Var.c() < next.c()) {
                this.f3570b.put(b5, next);
            }
        }
    }

    public synchronized s0 d(String str) {
        return this.f3570b.get(z0.k.o(str, "policy"));
    }
}
