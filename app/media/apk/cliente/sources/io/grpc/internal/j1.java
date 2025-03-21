package io.grpc.internal;

import i3.a1;
import io.grpc.internal.g0;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class j1 extends i3.v0<j1> {
    private static final Logger H = Logger.getLogger(j1.class.getName());
    static final long I = TimeUnit.MINUTES.toMillis(30);
    static final long J = TimeUnit.SECONDS.toMillis(1);
    private static final r1<? extends Executor> K = l2.c(t0.f5195u);
    private static final i3.v L = i3.v.c();
    private static final i3.o M = i3.o.a();
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private final c F;
    private final b G;

    /* renamed from: a  reason: collision with root package name */
    r1<? extends Executor> f4936a;

    /* renamed from: b  reason: collision with root package name */
    r1<? extends Executor> f4937b;

    /* renamed from: c  reason: collision with root package name */
    private final List<i3.h> f4938c;

    /* renamed from: d  reason: collision with root package name */
    final i3.c1 f4939d;

    /* renamed from: e  reason: collision with root package name */
    a1.d f4940e;

    /* renamed from: f  reason: collision with root package name */
    final String f4941f;

    /* renamed from: g  reason: collision with root package name */
    final i3.b f4942g;

    /* renamed from: h  reason: collision with root package name */
    private final SocketAddress f4943h;

    /* renamed from: i  reason: collision with root package name */
    String f4944i;

    /* renamed from: j  reason: collision with root package name */
    String f4945j;

    /* renamed from: k  reason: collision with root package name */
    String f4946k;

    /* renamed from: l  reason: collision with root package name */
    boolean f4947l;

    /* renamed from: m  reason: collision with root package name */
    i3.v f4948m;

    /* renamed from: n  reason: collision with root package name */
    i3.o f4949n;

    /* renamed from: o  reason: collision with root package name */
    long f4950o;

    /* renamed from: p  reason: collision with root package name */
    int f4951p;

    /* renamed from: q  reason: collision with root package name */
    int f4952q;

    /* renamed from: r  reason: collision with root package name */
    long f4953r;

    /* renamed from: s  reason: collision with root package name */
    long f4954s;

    /* renamed from: t  reason: collision with root package name */
    boolean f4955t;

    /* renamed from: u  reason: collision with root package name */
    i3.d0 f4956u;

    /* renamed from: v  reason: collision with root package name */
    int f4957v;

    /* renamed from: w  reason: collision with root package name */
    Map<String, ?> f4958w;

    /* renamed from: x  reason: collision with root package name */
    boolean f4959x;

    /* renamed from: y  reason: collision with root package name */
    i3.g1 f4960y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4961z;

    /* loaded from: classes.dex */
    public interface b {
        int a();
    }

    /* loaded from: classes.dex */
    public interface c {
        v a();
    }

    /* loaded from: classes.dex */
    private static final class d implements b {
        private d() {
        }

        @Override // io.grpc.internal.j1.b
        public int a() {
            return 443;
        }
    }

    public j1(String str, i3.e eVar, i3.b bVar, c cVar, b bVar2) {
        r1<? extends Executor> r1Var = K;
        this.f4936a = r1Var;
        this.f4937b = r1Var;
        this.f4938c = new ArrayList();
        i3.c1 d5 = i3.c1.d();
        this.f4939d = d5;
        this.f4940e = d5.c();
        this.f4946k = "pick_first";
        this.f4948m = L;
        this.f4949n = M;
        this.f4950o = I;
        this.f4951p = 5;
        this.f4952q = 5;
        this.f4953r = 16777216L;
        this.f4954s = 1048576L;
        this.f4955t = true;
        this.f4956u = i3.d0.g();
        this.f4959x = true;
        this.f4961z = true;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.f4941f = (String) z0.k.o(str, "target");
        this.f4942g = bVar;
        this.F = (c) z0.k.o(cVar, "clientTransportFactoryBuilder");
        this.f4943h = null;
        if (bVar2 != null) {
            this.G = bVar2;
        } else {
            this.G = new d();
        }
    }

    public j1(String str, c cVar, b bVar) {
        this(str, null, null, cVar, bVar);
    }

    @Override // i3.v0
    public i3.u0 a() {
        return new k1(new i1(this, this.F.a(), new g0.a(), l2.c(t0.f5195u), t0.f5197w, f(), q2.f5109a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.G.a();
    }

    List<i3.h> f() {
        boolean z4;
        i3.h hVar;
        ArrayList arrayList = new ArrayList(this.f4938c);
        List<i3.h> a5 = i3.h0.a();
        if (a5 != null) {
            arrayList.addAll(a5);
            z4 = true;
        } else {
            z4 = false;
        }
        i3.h hVar2 = null;
        if (!z4 && this.f4961z) {
            try {
                Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class<?> cls2 = Boolean.TYPE;
                hVar = (i3.h) cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2).invoke(null, Boolean.valueOf(this.A), Boolean.valueOf(this.B), Boolean.valueOf(this.C), Boolean.valueOf(this.D));
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e5) {
                H.log(Level.FINE, "Unable to apply census stats", e5);
                hVar = null;
            }
            if (hVar != null) {
                arrayList.add(0, hVar);
            }
        }
        if (!z4 && this.E) {
            try {
                hVar2 = (i3.h) Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e6) {
                H.log(Level.FINE, "Unable to apply census stats", e6);
            }
            if (hVar2 != null) {
                arrayList.add(0, hVar2);
            }
        }
        return arrayList;
    }
}
