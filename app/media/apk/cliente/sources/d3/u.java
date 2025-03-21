package d3;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.n0;
import d3.a1;
import d3.f3;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import s2.a;
import z2.c;
/* loaded from: classes.dex */
public class u implements FlutterFirebasePlugin, s2.a, t2.a, a1.c {

    /* renamed from: i  reason: collision with root package name */
    static final HashMap<Integer, com.google.firebase.auth.h> f2544i = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private z2.b f2545a;

    /* renamed from: b  reason: collision with root package name */
    private z2.j f2546b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f2547c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<z2.c, c.d> f2548d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final q0 f2549e = new q0();

    /* renamed from: f  reason: collision with root package name */
    private final w0 f2550f = new w0();

    /* renamed from: g  reason: collision with root package name */
    private final y0 f2551g = new y0();

    /* renamed from: h  reason: collision with root package name */
    private final z0 f2552h = new z0();

    private Activity U() {
        return this.f2547c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FirebaseAuth V(a1.b bVar) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(f1.f.p(bVar.b()));
        if (bVar.d() != null) {
            firebaseAuth.z(bVar.d());
        }
        String str = io.flutter.plugins.firebase.core.i.f4123c.get(bVar.b());
        if (str != null) {
            firebaseAuth.x(str);
        }
        if (bVar.c() != null) {
            firebaseAuth.x(bVar.c());
        }
        return firebaseAuth;
    }

    private void W(z2.b bVar) {
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_auth", this);
        this.f2546b = new z2.j(bVar, "plugins.flutter.io/firebase_auth");
        x1.x(bVar, this);
        m2.p(bVar, this.f2549e);
        b3.g(bVar, this.f2550f);
        o2.c(bVar, this.f2550f);
        s2.e(bVar, this.f2551g);
        v2.d(bVar, this.f2552h);
        this.f2545a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.f((com.google.firebase.auth.d) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(TaskCompletionSource taskCompletionSource) {
        try {
            p0();
            f2544i.clear();
            taskCompletionSource.setResult(null);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(((com.google.firebase.auth.w0) task.getResult()).a());
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(f1.f fVar, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap hashMap = new HashMap();
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(fVar);
            com.google.firebase.auth.a0 m5 = firebaseAuth.m();
            String p5 = firebaseAuth.p();
            a1.b0 j5 = m5 == null ? null : g3.j(m5);
            if (p5 != null) {
                hashMap.put("APP_LANGUAGE_CODE", p5);
            }
            if (j5 != null) {
                hashMap.put("APP_CURRENT_USER", g3.c(j5));
            }
            taskCompletionSource.setResult(hashMap);
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a((String) task.getResult());
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(com.google.firebase.auth.o0 o0Var) {
        f2544i.put(Integer.valueOf(o0Var.hashCode()), o0Var);
    }

    private void p0() {
        for (z2.c cVar : this.f2548d.keySet()) {
            c.d dVar = this.f2548d.get(cVar);
            if (dVar != null) {
                dVar.b(null);
            }
            cVar.d(null);
        }
        this.f2548d.clear();
    }

    @Override // t2.a
    public void A() {
        this.f2547c = null;
        this.f2549e.d0(null);
    }

    @Override // d3.a1.c
    public void B(a1.b bVar, a1.y yVar, final a1.f0<a1.a0> f0Var) {
        FirebaseAuth V = V(bVar);
        n0.a d5 = com.google.firebase.auth.n0.d(yVar.c());
        if (yVar.d() != null) {
            d5.c(yVar.d());
        }
        if (yVar.b() != null) {
            d5.a(yVar.b());
        }
        V.G(U(), d5.b()).addOnCompleteListener(new OnCompleteListener() { // from class: d3.p
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.m0(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void a(a1.b bVar, String str, String str2, final a1.f0<a1.a0> f0Var) {
        V(bVar).E(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: d3.f
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.l0(a1.f0.this, task);
            }
        });
    }

    @Override // s2.a
    public void b(a.b bVar) {
        W(bVar.b());
    }

    @Override // d3.a1.c
    public void c(a1.b bVar, String str, final a1.f0<a1.a0> f0Var) {
        V(bVar).C(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.k
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.j0(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void d(a1.b bVar, a1.f0<String> f0Var) {
        FirebaseAuth V;
        try {
            d3 d3Var = new d3(V(bVar));
            String str = "plugins.flutter.io/firebase_auth/id-token/" + V.l().q();
            z2.c cVar = new z2.c(this.f2545a, str);
            cVar.d(d3Var);
            this.f2548d.put(cVar, d3Var);
            f0Var.a(str);
        } catch (Exception e5) {
            f0Var.b(e5);
        }
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: d3.l
            @Override // java.lang.Runnable
            public final void run() {
                u.this.b0(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // d3.a1.c
    public void e(a1.b bVar, String str, final a1.g0 g0Var) {
        V(bVar).g(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.r
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.X(a1.g0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void f(a1.b bVar, String str, a1.g0 g0Var) {
        g0Var.a();
    }

    @Override // d3.a1.c
    public void g(a1.b bVar, String str, final a1.f0<a1.o> f0Var) {
        V(bVar).h(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.Y(a1.f0.this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final f1.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: d3.c
            @Override // java.lang.Runnable
            public final void run() {
                u.d0(f1.f.this, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // d3.a1.c
    public void h(a1.b bVar, Map<String, Object> map, final a1.f0<a1.a0> f0Var) {
        FirebaseAuth V = V(bVar);
        com.google.firebase.auth.h b5 = g3.b(map);
        if (b5 == null) {
            throw v.b();
        }
        V.B(b5).addOnCompleteListener(new OnCompleteListener() { // from class: d3.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.i0(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void i(a1.b bVar, a1.f0<String> f0Var) {
        FirebaseAuth V;
        try {
            b bVar2 = new b(V(bVar));
            String str = "plugins.flutter.io/firebase_auth/auth-state/" + V.l().q();
            z2.c cVar = new z2.c(this.f2545a, str);
            cVar.d(bVar2);
            this.f2548d.put(cVar, bVar2);
            f0Var.a(str);
        } catch (Exception e5) {
            f0Var.b(e5);
        }
    }

    @Override // t2.a
    public void j() {
        this.f2547c = null;
        this.f2549e.d0(null);
    }

    @Override // d3.a1.c
    public void k(a1.b bVar, String str, a1.q qVar, final a1.g0 g0Var) {
        Task<Void> v5;
        OnCompleteListener<Void> onCompleteListener;
        FirebaseAuth V = V(bVar);
        if (qVar == null) {
            v5 = V.u(str);
            onCompleteListener = new OnCompleteListener() { // from class: d3.s
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    u.e0(a1.g0.this, task);
                }
            };
        } else {
            v5 = V.v(str, g3.a(qVar));
            onCompleteListener = new OnCompleteListener() { // from class: d3.t
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    u.f0(a1.g0.this, task);
                }
            };
        }
        v5.addOnCompleteListener(onCompleteListener);
    }

    @Override // d3.a1.c
    public void l(a1.b bVar, final a1.f0<a1.a0> f0Var) {
        V(bVar).A().addOnCompleteListener(new OnCompleteListener() { // from class: d3.h
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.h0(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void m(a1.b bVar, a1.e0 e0Var, a1.f0<String> f0Var) {
        try {
            String str = "plugins.flutter.io/firebase_auth/phone/" + UUID.randomUUID().toString();
            z2.c cVar = new z2.c(this.f2545a, str);
            com.google.firebase.auth.t0 t0Var = null;
            com.google.firebase.auth.l0 l0Var = e0Var.e() != null ? w0.f2565b.get(e0Var.e()) : null;
            String d5 = e0Var.d();
            if (d5 != null) {
                for (String str2 : w0.f2566c.keySet()) {
                    Iterator<com.google.firebase.auth.j0> it = w0.f2566c.get(str2).u().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.google.firebase.auth.j0 next = it.next();
                            if (next.a().equals(d5) && (next instanceof com.google.firebase.auth.t0)) {
                                t0Var = (com.google.firebase.auth.t0) next;
                                break;
                            }
                        }
                    }
                }
            }
            f3 f3Var = new f3(U(), bVar, e0Var, l0Var, t0Var, new f3.b() { // from class: d3.m
                @Override // d3.f3.b
                public final void a(com.google.firebase.auth.o0 o0Var) {
                    u.o0(o0Var);
                }
            });
            cVar.d(f3Var);
            this.f2548d.put(cVar, f3Var);
            f0Var.a(str);
        } catch (Exception e5) {
            f0Var.b(e5);
        }
    }

    @Override // d3.a1.c
    public void n(a1.b bVar, String str, Long l5, a1.g0 g0Var) {
        try {
            V(bVar).I(str, l5.intValue());
            g0Var.a();
        } catch (Exception e5) {
            g0Var.b(e5);
        }
    }

    @Override // d3.a1.c
    public void o(a1.b bVar, a1.t tVar, a1.g0 g0Var) {
        try {
            FirebaseAuth V = V(bVar);
            V.o().b(tVar.b().booleanValue());
            if (tVar.c() != null) {
                V.o().a(tVar.c().booleanValue());
            }
            if (tVar.d() != null && tVar.e() != null) {
                V.o().c(tVar.d(), tVar.e());
            }
            g0Var.a();
        } catch (Exception e5) {
            g0Var.b(e5);
        }
    }

    @Override // d3.a1.c
    public void p(a1.b bVar, String str, String str2, final a1.g0 g0Var) {
        V(bVar).i(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: d3.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.Z(a1.g0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void q(a1.b bVar, String str, String str2, final a1.f0<a1.a0> f0Var) {
        V(bVar).D(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: d3.q
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.k0(a1.f0.this, task);
            }
        });
    }

    @Override // t2.a
    public void r(t2.c cVar) {
        Activity d5 = cVar.d();
        this.f2547c = d5;
        this.f2549e.d0(d5);
    }

    @Override // d3.a1.c
    public void s(a1.b bVar, a1.g0 g0Var) {
        Map<String, com.google.firebase.auth.h0> map;
        try {
            FirebaseAuth V = V(bVar);
            if (V.m() != null && (map = w0.f2564a.get(bVar.b())) != null) {
                map.remove(V.m().a());
            }
            V.F();
            g0Var.a();
        } catch (Exception e5) {
            g0Var.b(e5);
        }
    }

    @Override // s2.a
    public void t(a.b bVar) {
        this.f2546b.e(null);
        x1.x(this.f2545a, null);
        m2.p(this.f2545a, null);
        b3.g(this.f2545a, null);
        o2.c(this.f2545a, null);
        s2.e(this.f2545a, null);
        v2.d(this.f2545a, null);
        this.f2546b = null;
        this.f2545a = null;
        p0();
    }

    @Override // d3.a1.c
    public void u(a1.b bVar, String str, final a1.f0<String> f0Var) {
        V(bVar).J(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.n0(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void v(a1.b bVar, String str, final a1.f0<List<String>> f0Var) {
        V(bVar).k(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.j
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.c0(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void w(a1.b bVar, String str, a1.f0<String> f0Var) {
        try {
            FirebaseAuth V = V(bVar);
            if (str == null) {
                V.H();
            } else {
                V.y(str);
            }
            f0Var.a(V.p());
        } catch (Exception e5) {
            f0Var.b(e5);
        }
    }

    @Override // d3.a1.c
    public void x(a1.b bVar, String str, a1.q qVar, final a1.g0 g0Var) {
        V(bVar).w(str, g3.a(qVar)).addOnCompleteListener(new OnCompleteListener() { // from class: d3.o
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.g0(a1.g0.this, task);
            }
        });
    }

    @Override // d3.a1.c
    public void y(a1.b bVar, String str, String str2, final a1.f0<a1.a0> f0Var) {
        V(bVar).j(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: d3.n
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.a0(a1.f0.this, task);
            }
        });
    }

    @Override // t2.a
    public void z(t2.c cVar) {
        Activity d5 = cVar.d();
        this.f2547c = d5;
        this.f2549e.d0(d5);
    }
}
