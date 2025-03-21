package d3;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import d3.a1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public class w0 implements a1.m, a1.h {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, Map<String, com.google.firebase.auth.h0>> f2564a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    static final Map<String, com.google.firebase.auth.l0> f2565b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    static final Map<String, com.google.firebase.auth.k0> f2566c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    static final Map<String, com.google.firebase.auth.i0> f2567d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(a1.f0 f0Var, Task task) {
        if (!task.isSuccessful()) {
            f0Var.b(v.e(task.getException()));
            return;
        }
        String uuid = UUID.randomUUID().toString();
        f2565b.put(uuid, (com.google.firebase.auth.l0) task.getResult());
        f0Var.a(new a1.w.a().b(uuid).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    @Override // d3.a1.m
    public void a(a1.b bVar, a1.f0<List<a1.v>> f0Var) {
        try {
            f0Var.a(g3.e(l(bVar).b()));
        } catch (d2.a e5) {
            f0Var.b(e5);
        }
    }

    @Override // d3.a1.h
    public void b(String str, a1.x xVar, String str2, final a1.f0<a1.a0> f0Var) {
        com.google.firebase.auth.k0 k0Var = f2566c.get(str);
        if (k0Var == null) {
            f0Var.b(v.e(new Exception("Resolver not found")));
        } else {
            k0Var.w(xVar != null ? com.google.firebase.auth.s0.a(com.google.firebase.auth.q0.a(xVar.c(), xVar.b())) : f2567d.get(str2)).addOnCompleteListener(new OnCompleteListener() { // from class: d3.v0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.p(a1.f0.this, task);
                }
            });
        }
    }

    @Override // d3.a1.m
    public void c(a1.b bVar, String str, String str2, final a1.g0 g0Var) {
        try {
            l(bVar).a(f2567d.get(str), str2).addOnCompleteListener(new OnCompleteListener() { // from class: d3.t0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.n(a1.g0.this, task);
                }
            });
        } catch (d2.a e5) {
            g0Var.b(e5);
        }
    }

    @Override // d3.a1.m
    public void d(a1.b bVar, final a1.f0<a1.w> f0Var) {
        try {
            l(bVar).c().addOnCompleteListener(new OnCompleteListener() { // from class: d3.u0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.o(a1.f0.this, task);
                }
            });
        } catch (d2.a e5) {
            f0Var.b(e5);
        }
    }

    @Override // d3.a1.m
    public void e(a1.b bVar, a1.x xVar, String str, final a1.g0 g0Var) {
        try {
            l(bVar).a(com.google.firebase.auth.s0.a(com.google.firebase.auth.q0.a(xVar.c(), xVar.b())), str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.r0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.m(a1.g0.this, task);
                }
            });
        } catch (d2.a e5) {
            g0Var.b(e5);
        }
    }

    @Override // d3.a1.m
    public void f(a1.b bVar, String str, final a1.g0 g0Var) {
        try {
            l(bVar).d(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.s0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.q(a1.g0.this, task);
                }
            });
        } catch (d2.a e5) {
            g0Var.b(v.e(e5));
        }
    }

    com.google.firebase.auth.h0 l(a1.b bVar) {
        com.google.firebase.auth.a0 I = q0.I(bVar);
        if (I != null) {
            Map<String, Map<String, com.google.firebase.auth.h0>> map = f2564a;
            if (map.get(bVar.b()) == null) {
                map.put(bVar.b(), new HashMap());
            }
            Map<String, com.google.firebase.auth.h0> map2 = map.get(bVar.b());
            if (map2.get(I.a()) == null) {
                map2.put(I.a(), I.w());
            }
            return map2.get(I.a());
        }
        throw new d2.a("No user is signed in");
    }
}
