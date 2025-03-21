package e3;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.a0;
import com.google.firebase.firestore.a1;
import com.google.firebase.firestore.d1;
import com.google.firebase.firestore.g1;
import com.google.firebase.firestore.k1;
import com.google.firebase.firestore.n;
import com.google.firebase.firestore.w0;
import com.google.firebase.firestore.y0;
import e3.y;
import f3.o;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import s2.a;
import z2.c;
/* loaded from: classes.dex */
public class w implements FlutterFirebasePlugin, s2.a, t2.a, y.g {

    /* renamed from: h  reason: collision with root package name */
    protected static final HashMap<FirebaseFirestore, b> f2800h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static final Map<Integer, n.a> f2801i = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private z2.b f2803b;

    /* renamed from: a  reason: collision with root package name */
    final z2.q f2802a = new z2.q(c.f2680d);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<Activity> f2804c = new AtomicReference<>(null);

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, g1> f2805d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, z2.c> f2806e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, c.d> f2807f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, f3.f> f2808g = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2809a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2810b;

        static {
            int[] iArr = new int[y.v.values().length];
            f2810b = iArr;
            try {
                iArr[y.v.DELETE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2810b[y.v.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2810b[y.v.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[y.d.values().length];
            f2809a = iArr2;
            try {
                iArr2[y.d.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2809a[y.d.SUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2809a[y.d.AVERAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void V(t2.c cVar) {
        this.f2804c.set(cVar.d());
    }

    private static void W(FirebaseFirestore firebaseFirestore) {
        HashMap<FirebaseFirestore, b> hashMap = f2800h;
        synchronized (hashMap) {
            if (hashMap.get(firebaseFirestore) != null) {
                hashMap.remove(firebaseFirestore);
            }
        }
    }

    private void X() {
        this.f2804c.set(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static b Y(FirebaseFirestore firebaseFirestore) {
        b bVar;
        HashMap<FirebaseFirestore, b> hashMap = f2800h;
        synchronized (hashMap) {
            bVar = hashMap.get(firebaseFirestore);
        }
        return bVar;
    }

    public static FirebaseFirestore Z(y.i iVar) {
        synchronized (f2800h) {
            if (a0(iVar.b(), iVar.c()) != null) {
                return a0(iVar.b(), iVar.c());
            }
            FirebaseFirestore u5 = FirebaseFirestore.u(f1.f.p(iVar.b()), iVar.c());
            u5.J(b0(iVar));
            z0(u5, iVar.c());
            return u5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static FirebaseFirestore a0(String str, String str2) {
        for (Map.Entry<FirebaseFirestore, b> entry : f2800h.entrySet()) {
            if (entry.getValue().b().r().q().equals(str) && entry.getValue().a().equals(str2)) {
                return entry.getKey();
            }
        }
        return null;
    }

    static com.google.firebase.firestore.a0 b0(y.i iVar) {
        com.google.firebase.firestore.k0 a5;
        a0.b bVar = new a0.b();
        if (iVar.d().c() != null) {
            bVar.g(iVar.d().c());
        }
        if (iVar.d().e() != null) {
            bVar.i(iVar.d().e().booleanValue());
        }
        if (iVar.d().d() != null) {
            if (iVar.d().d().booleanValue()) {
                Long b5 = iVar.d().b();
                long j5 = 104857600;
                if (b5 != null && b5.longValue() != -1) {
                    j5 = b5.longValue();
                }
                a5 = com.google.firebase.firestore.r0.b().b(j5).a();
            } else {
                a5 = com.google.firebase.firestore.l0.b().a();
            }
            bVar.h(a5);
        }
        return bVar.f();
    }

    private void c0(z2.b bVar) {
        this.f2803b = bVar;
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_firestore", this);
        v0.x(this.f2803b, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(com.google.firebase.firestore.c cVar, y.c cVar2, List list, y.w wVar) {
        y.b a5;
        try {
            com.google.firebase.firestore.d dVar = (com.google.firebase.firestore.d) Tasks.await(cVar.b(g3.b.b(cVar2)));
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                y.a aVar = (y.a) it.next();
                int i5 = a.f2809a[aVar.c().ordinal()];
                if (i5 == 1) {
                    y.b.a aVar2 = new y.b.a();
                    aVar2.c(y.d.COUNT);
                    aVar2.d(Double.valueOf(dVar.e()));
                    a5 = aVar2.a();
                } else if (i5 == 2) {
                    y.b.a aVar3 = new y.b.a();
                    aVar3.c(y.d.SUM);
                    Object d5 = dVar.d(com.google.firebase.firestore.a.f(aVar.b()));
                    Objects.requireNonNull(d5);
                    aVar3.d(Double.valueOf(((Number) d5).doubleValue()));
                    aVar3.b(aVar.b());
                    a5 = aVar3.a();
                } else if (i5 == 3) {
                    y.b.a aVar4 = new y.b.a();
                    aVar4.c(y.d.AVERAGE);
                    aVar4.d(dVar.c(com.google.firebase.firestore.a.a(aVar.b())));
                    aVar4.b(aVar.b());
                    a5 = aVar4.a();
                }
                arrayList.add(a5);
            }
            wVar.a(arrayList);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(y.i iVar, y.w wVar) {
        try {
            Tasks.await(Z(iVar).k());
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(TaskCompletionSource taskCompletionSource) {
        try {
            for (Map.Entry<FirebaseFirestore, b> entry : f2800h.entrySet()) {
                FirebaseFirestore key = entry.getKey();
                Tasks.await(key.M());
                W(key);
            }
            y0();
            taskCompletionSource.setResult(null);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(y.i iVar, y.w wVar) {
        try {
            Tasks.await(Z(iVar).n());
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(y.i iVar, y.f fVar, y.w wVar) {
        try {
            wVar.a((Void) Tasks.await(Z(iVar).o(fVar.d()).g()));
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(y.f fVar, y.i iVar, y.w wVar) {
        try {
            wVar.a(g3.b.k((com.google.firebase.firestore.n) Tasks.await(Z(iVar).o(fVar.d()).i(g3.b.f(fVar.f()))), g3.b.e(fVar.e())));
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(y.i iVar, y.f fVar, y.w wVar) {
        Task<Void> r5;
        a1 d5;
        try {
            com.google.firebase.firestore.m o5 = Z(iVar).o(fVar.d());
            Map<Object, Object> b5 = fVar.b();
            Objects.requireNonNull(b5);
            if (fVar.c().b() != null && fVar.c().b().booleanValue()) {
                d5 = a1.c();
            } else if (fVar.c().c() == null) {
                r5 = o5.r(b5);
                wVar.a((Void) Tasks.await(r5));
            } else {
                List<List<String>> c5 = fVar.c().c();
                Objects.requireNonNull(c5);
                d5 = a1.d(g3.b.c(c5));
            }
            r5 = o5.s(b5, d5);
            wVar.a((Void) Tasks.await(r5));
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(y.i iVar, y.f fVar, y.w wVar) {
        com.google.firebase.firestore.q qVar;
        Object obj;
        try {
            com.google.firebase.firestore.m o5 = Z(iVar).o(fVar.d());
            Map<Object, Object> b5 = fVar.b();
            Objects.requireNonNull(b5);
            Map<Object, Object> map = b5;
            HashMap hashMap = new HashMap();
            for (Object obj2 : map.keySet()) {
                if (obj2 instanceof String) {
                    qVar = com.google.firebase.firestore.q.d((String) obj2);
                    obj = map.get(obj2);
                } else if (!(obj2 instanceof com.google.firebase.firestore.q)) {
                    throw new IllegalArgumentException("Invalid key type in update data. Supported types are String and FieldPath.");
                } else {
                    qVar = (com.google.firebase.firestore.q) obj2;
                    obj = map.get(obj2);
                }
                hashMap.put(qVar, obj);
            }
            com.google.firebase.firestore.q qVar2 = (com.google.firebase.firestore.q) hashMap.keySet().iterator().next();
            Object obj3 = hashMap.get(qVar2);
            ArrayList arrayList = new ArrayList();
            for (com.google.firebase.firestore.q qVar3 : hashMap.keySet()) {
                if (!qVar3.equals(qVar2)) {
                    arrayList.add(qVar3);
                    arrayList.add(hashMap.get(qVar3));
                }
            }
            wVar.a((Void) Tasks.await(o5.t(qVar2, obj3, arrayList.toArray())));
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(y.i iVar, y.w wVar) {
        try {
            Tasks.await(Z(iVar).p());
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(y.i iVar, String str, y.w wVar, y.p pVar) {
        try {
            w0 w0Var = (w0) Tasks.await(Z(iVar).v(str));
            if (w0Var == null) {
                wVar.b(new NullPointerException("Named query has not been found. Please check it has been loaded properly via loadBundle()."));
            } else {
                wVar.a(g3.b.m((y0) Tasks.await(w0Var.l(g3.b.f(pVar.c()))), g3.b.e(pVar.b())));
            }
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(y.p pVar, y.i iVar, String str, Boolean bool, y.q qVar, y.w wVar) {
        try {
            d1 f5 = g3.b.f(pVar.c());
            w0 g5 = g3.b.g(Z(iVar), str, bool.booleanValue(), qVar);
            if (g5 == null) {
                wVar.b(new y.j("invalid_query", "An error occurred while parsing query arguments, see native logs for more information. Please report this issue.", null));
            } else {
                wVar.a(g3.b.m((y0) Tasks.await(g5.l(f5)), g3.b.e(pVar.b())));
            }
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(y.i iVar, String str, y.w wVar) {
        try {
            Tasks.await(Z(iVar).K(str));
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q0(Boolean bool, y.w wVar) {
        try {
            FirebaseFirestore.L(bool.booleanValue());
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(y.i iVar, y.w wVar) {
        try {
            FirebaseFirestore Z = Z(iVar);
            Tasks.await(Z.M());
            W(Z);
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String str, g1 g1Var) {
        this.f2805d.put(str, g1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(y.i iVar, String str, String str2, y.w wVar) {
        try {
            com.google.firebase.firestore.m o5 = Z(iVar).o(str);
            g1 g1Var = this.f2805d.get(str2);
            if (g1Var != null) {
                wVar.a(g3.b.k(g1Var.c(o5), n.a.NONE));
                return;
            }
            wVar.b(new Exception("Transaction.getDocument(): No transaction handler exists for ID: " + str2));
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u0(y.i iVar, y.w wVar) {
        try {
            Tasks.await(Z(iVar).O());
            wVar.a(null);
        } catch (Exception e5) {
            g3.a.b(wVar, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v0(y.i iVar, List list, y.w wVar) {
        a1 d5;
        try {
            FirebaseFirestore Z = Z(iVar);
            k1 j5 = Z.j();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                y.t tVar = (y.t) it.next();
                y.v e5 = tVar.e();
                Objects.requireNonNull(e5);
                String d6 = tVar.d();
                Objects.requireNonNull(d6);
                Map<String, Object> b5 = tVar.b();
                com.google.firebase.firestore.m o5 = Z.o(d6);
                int i5 = a.f2810b[e5.ordinal()];
                if (i5 == 1) {
                    j5 = j5.b(o5);
                } else if (i5 == 2) {
                    Objects.requireNonNull(b5);
                    j5 = j5.e(o5, b5);
                } else if (i5 == 3) {
                    y.m c5 = tVar.c();
                    Objects.requireNonNull(c5);
                    if (c5.b() != null && c5.b().booleanValue()) {
                        Objects.requireNonNull(b5);
                        d5 = a1.c();
                    } else if (c5.c() != null) {
                        List<List<String>> c6 = c5.c();
                        Objects.requireNonNull(c6);
                        List<com.google.firebase.firestore.q> c7 = g3.b.c(c6);
                        Objects.requireNonNull(b5);
                        d5 = a1.d(c7);
                    } else {
                        Objects.requireNonNull(b5);
                        j5 = j5.c(o5, b5);
                    }
                    j5 = j5.d(o5, b5, d5);
                }
            }
            Tasks.await(j5.a());
            wVar.a(null);
        } catch (Exception e6) {
            g3.a.b(wVar, e6);
        }
    }

    private String w0(String str, String str2, c.d dVar) {
        z2.c cVar = new z2.c(this.f2803b, str + "/" + str2, this.f2802a);
        cVar.d(dVar);
        this.f2806e.put(str2, cVar);
        this.f2807f.put(str2, dVar);
        return str2;
    }

    private String x0(String str, c.d dVar) {
        return w0(str, UUID.randomUUID().toString().toLowerCase(Locale.US), dVar);
    }

    private void y0() {
        synchronized (this.f2806e) {
            for (String str : this.f2806e.keySet()) {
                z2.c cVar = this.f2806e.get(str);
                Objects.requireNonNull(cVar);
                cVar.d(null);
            }
            this.f2806e.clear();
        }
        synchronized (this.f2807f) {
            for (String str2 : this.f2807f.keySet()) {
                c.d dVar = this.f2807f.get(str2);
                Objects.requireNonNull(dVar);
                dVar.b(null);
            }
            this.f2807f.clear();
        }
        this.f2808g.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void z0(FirebaseFirestore firebaseFirestore, String str) {
        HashMap<FirebaseFirestore, b> hashMap = f2800h;
        synchronized (hashMap) {
            if (hashMap.get(firebaseFirestore) == null) {
                hashMap.put(firebaseFirestore, new b(firebaseFirestore, str));
            }
        }
    }

    @Override // t2.a
    public void A() {
        X();
    }

    @Override // e3.y.g
    public void B(y.i iVar, y.f fVar, Boolean bool, y.k kVar, y.w<String> wVar) {
        wVar.a(x0("plugins.flutter.io/firebase_firestore/document", new f3.b(Z(iVar), Z(iVar).o(fVar.d()), bool, g3.b.e(fVar.e()), g3.b.d(kVar))));
    }

    @Override // e3.y.g
    public void a(y.i iVar, y.w<String> wVar) {
        wVar.a(x0("plugins.flutter.io/firebase_firestore/snapshotsInSync", new f3.j(Z(iVar))));
    }

    @Override // s2.a
    public void b(a.b bVar) {
        c0(bVar.b());
    }

    @Override // e3.y.g
    public void c(final y.i iVar, final y.f fVar, final y.w<y.n> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.t
            @Override // java.lang.Runnable
            public final void run() {
                w.i0(y.f.this, iVar, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void d(final y.i iVar, final List<y.t> list, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.s
            @Override // java.lang.Runnable
            public final void run() {
                w.v0(y.i.this, list, wVar);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.d
            @Override // java.lang.Runnable
            public final void run() {
                w.this.f0(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // e3.y.g
    public void e(y.i iVar, String str, Boolean bool, y.q qVar, y.p pVar, Boolean bool2, y.k kVar, y.w<String> wVar) {
        w0 g5 = g3.b.g(Z(iVar), str, bool.booleanValue(), qVar);
        if (g5 == null) {
            wVar.b(new y.j("invalid_query", "An error occurred while parsing query arguments, see native logs for more information. Please report this issue.", null));
        } else {
            wVar.a(x0("plugins.flutter.io/firebase_firestore/query", new f3.h(g5, bool2, g3.b.e(pVar.b()), g3.b.d(kVar))));
        }
    }

    @Override // e3.y.g
    public void f(final y.i iVar, final y.f fVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.f
            @Override // java.lang.Runnable
            public final void run() {
                w.k0(y.i.this, fVar, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void g(y.i iVar, String str, y.q qVar, final y.c cVar, final List<y.a> list, Boolean bool, final y.w<List<y.b>> wVar) {
        com.google.firebase.firestore.a b5;
        w0 g5 = g3.b.g(Z(iVar), str, bool.booleanValue(), qVar);
        ArrayList arrayList = new ArrayList();
        for (y.a aVar : list) {
            int i5 = a.f2809a[aVar.c().ordinal()];
            if (i5 == 1) {
                b5 = com.google.firebase.firestore.a.b();
            } else if (i5 == 2) {
                b5 = com.google.firebase.firestore.a.f(aVar.b());
            } else if (i5 == 3) {
                b5 = com.google.firebase.firestore.a.a(aVar.b());
            }
            arrayList.add(b5);
        }
        final com.google.firebase.firestore.c f5 = g5.f((com.google.firebase.firestore.a) arrayList.get(0), (com.google.firebase.firestore.a[]) arrayList.subList(1, arrayList.size()).toArray(new com.google.firebase.firestore.a[0]));
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.u
            @Override // java.lang.Runnable
            public final void run() {
                w.d0(com.google.firebase.firestore.c.this, cVar, list, wVar);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(f1.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.n
            @Override // java.lang.Runnable
            public final void run() {
                w.m0(TaskCompletionSource.this);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // e3.y.g
    public void h(final y.i iVar, final String str, final y.p pVar, final y.w<y.r> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.p
            @Override // java.lang.Runnable
            public final void run() {
                w.n0(y.i.this, str, wVar, pVar);
            }
        });
    }

    @Override // e3.y.g
    public void i(final y.i iVar, final String str, final String str2, final y.w<y.n> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.o
            @Override // java.lang.Runnable
            public final void run() {
                w.this.t0(iVar, str2, str, wVar);
            }
        });
    }

    @Override // t2.a
    public void j() {
        X();
    }

    @Override // e3.y.g
    public void k(final y.i iVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.g
            @Override // java.lang.Runnable
            public final void run() {
                w.u0(y.i.this, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void l(final y.i iVar, final String str, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.l
            @Override // java.lang.Runnable
            public final void run() {
                w.p0(y.i.this, str, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void m(final y.i iVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.e
            @Override // java.lang.Runnable
            public final void run() {
                w.e0(y.i.this, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void n(final y.i iVar, final String str, final Boolean bool, final y.q qVar, final y.p pVar, final y.w<y.r> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.q
            @Override // java.lang.Runnable
            public final void run() {
                w.o0(y.p.this, iVar, str, bool, qVar, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void o(final Boolean bool, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.k
            @Override // java.lang.Runnable
            public final void run() {
                w.q0(bool, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void p(y.i iVar, byte[] bArr, y.w<String> wVar) {
        wVar.a(x0("plugins.flutter.io/firebase_firestore/loadBundle", new f3.e(Z(iVar), bArr)));
    }

    @Override // e3.y.g
    public void q(String str, y.u uVar, List<y.t> list, y.w<Void> wVar) {
        f3.f fVar = this.f2808g.get(str);
        Objects.requireNonNull(fVar);
        fVar.c(uVar, list);
        wVar.a(null);
    }

    @Override // t2.a
    public void r(t2.c cVar) {
        V(cVar);
    }

    @Override // e3.y.g
    public void s(final y.i iVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.j
            @Override // java.lang.Runnable
            public final void run() {
                w.l0(y.i.this, wVar);
            }
        });
    }

    @Override // s2.a
    public void t(a.b bVar) {
        y0();
        this.f2803b = null;
    }

    @Override // e3.y.g
    public void u(final y.i iVar, final y.f fVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.m
            @Override // java.lang.Runnable
            public final void run() {
                w.h0(y.i.this, fVar, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void v(final y.i iVar, final y.f fVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.h
            @Override // java.lang.Runnable
            public final void run() {
                w.j0(y.i.this, fVar, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void w(y.i iVar, Long l5, Long l6, y.w<String> wVar) {
        FirebaseFirestore Z = Z(iVar);
        final String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        f3.o oVar = new f3.o(new o.b() { // from class: e3.v
            @Override // f3.o.b
            public final void a(g1 g1Var) {
                w.this.s0(lowerCase, g1Var);
            }
        }, Z, lowerCase, l5, l6);
        w0("plugins.flutter.io/firebase_firestore/transaction", lowerCase, oVar);
        this.f2808g.put(lowerCase, oVar);
        wVar.a(lowerCase);
    }

    @Override // e3.y.g
    public void x(final y.i iVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.i
            @Override // java.lang.Runnable
            public final void run() {
                w.r0(y.i.this, wVar);
            }
        });
    }

    @Override // e3.y.g
    public void y(final y.i iVar, final y.w<Void> wVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: e3.r
            @Override // java.lang.Runnable
            public final void run() {
                w.g0(y.i.this, wVar);
            }
        });
    }

    @Override // t2.a
    public void z(t2.c cVar) {
        V(cVar);
    }
}
