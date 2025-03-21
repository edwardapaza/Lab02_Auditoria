package d3;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.e1;
import com.google.firebase.auth.n0;
import d3.a1;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import java.util.Map;
/* loaded from: classes.dex */
public class q0 implements a1.e {

    /* renamed from: a  reason: collision with root package name */
    private Activity f2524a;

    public static com.google.firebase.auth.a0 I(a1.b bVar) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(f1.f.p(bVar.b()));
        if (bVar.d() != null) {
            firebaseAuth.z(bVar.d());
        }
        return firebaseAuth.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(a1.b bVar, a1.f0 f0Var, Boolean bool) {
        com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
            return;
        }
        try {
            f0Var.a(g3.l((com.google.firebase.auth.c0) Tasks.await(I.u(bool.booleanValue()))));
        } catch (Exception e5) {
            f0Var.b(v.e(e5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(a1.f0 f0Var, com.google.firebase.auth.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.i((com.google.firebase.auth.i) task.getResult()));
            return;
        }
        Exception exception = task.getException();
        f0Var.b(exception.getMessage().contains("User was not linked to an account with the given provider.") ? v.c() : v.e(exception));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(a1.f0 f0Var, com.google.firebase.auth.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(final com.google.firebase.auth.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.C().addOnCompleteListener(new OnCompleteListener() { // from class: d3.d0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.T(a1.f0.this, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(a1.f0 f0Var, com.google.firebase.auth.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(final com.google.firebase.auth.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.C().addOnCompleteListener(new OnCompleteListener() { // from class: d3.e0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.V(a1.f0.this, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(a1.f0 f0Var, com.google.firebase.auth.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(final com.google.firebase.auth.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.C().addOnCompleteListener(new OnCompleteListener() { // from class: d3.f0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.X(a1.f0.this, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(a1.f0 f0Var, com.google.firebase.auth.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(g3.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(final com.google.firebase.auth.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.C().addOnCompleteListener(new OnCompleteListener() { // from class: d3.g0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.Z(a1.f0.this, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    @Override // d3.a1.e
    public void a(a1.b bVar, String str, final a1.f0<a1.b0> f0Var) {
        final com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
        } else {
            I.I(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.p0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.U(com.google.firebase.auth.a0.this, f0Var, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void b(a1.b bVar, Map<String, Object> map, final a1.f0<a1.b0> f0Var) {
        final com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
            return;
        }
        com.google.firebase.auth.o0 o0Var = (com.google.firebase.auth.o0) g3.b(map);
        if (o0Var == null) {
            f0Var.b(v.b());
        } else {
            I.K(o0Var).addOnCompleteListener(new OnCompleteListener() { // from class: d3.z
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.Y(com.google.firebase.auth.a0.this, f0Var, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void c(a1.b bVar, Map<String, Object> map, final a1.f0<a1.a0> f0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        com.google.firebase.auth.h b5 = g3.b(map);
        if (I == null) {
            f0Var.b(v.d());
        } else if (b5 == null) {
            f0Var.b(v.b());
        } else {
            I.A(b5).addOnCompleteListener(new OnCompleteListener() { // from class: d3.x
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.L(a1.f0.this, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void d(a1.b bVar, Map<String, Object> map, final a1.f0<a1.a0> f0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        com.google.firebase.auth.h b5 = g3.b(map);
        if (I == null) {
            f0Var.b(v.d());
        } else if (b5 == null) {
            f0Var.b(v.b());
        } else {
            I.B(b5).addOnCompleteListener(new OnCompleteListener() { // from class: d3.j0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.N(a1.f0.this, task);
                }
            });
        }
    }

    public void d0(Activity activity) {
        this.f2524a = activity;
    }

    @Override // d3.a1.e
    public void e(a1.b bVar, a1.y yVar, final a1.f0<a1.a0> f0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        n0.a d5 = com.google.firebase.auth.n0.d(yVar.c());
        if (yVar.d() != null) {
            d5.c(yVar.d());
        }
        if (yVar.b() != null) {
            d5.a(yVar.b());
        }
        I.F(this.f2524a, d5.b()).addOnCompleteListener(new OnCompleteListener() { // from class: d3.m0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                q0.M(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.e
    public void f(a1.b bVar, a1.y yVar, final a1.f0<a1.a0> f0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        n0.a d5 = com.google.firebase.auth.n0.d(yVar.c());
        if (yVar.d() != null) {
            d5.c(yVar.d());
        }
        if (yVar.b() != null) {
            d5.a(yVar.b());
        }
        I.G(this.f2524a, d5.b()).addOnCompleteListener(new OnCompleteListener() { // from class: d3.k0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                q0.O(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.e
    public void g(a1.b bVar, String str, a1.q qVar, final a1.g0 g0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            g0Var.b(v.d());
        } else if (qVar == null) {
            I.M(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.b0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.b0(a1.g0.this, task);
                }
            });
        } else {
            I.N(str, g3.a(qVar)).addOnCompleteListener(new OnCompleteListener() { // from class: d3.c0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.c0(a1.g0.this, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void h(a1.b bVar, String str, final a1.f0<a1.a0> f0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
        } else {
            I.H(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.a0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.S(a1.f0.this, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void i(a1.b bVar, final a1.f0<a1.b0> f0Var) {
        final com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
        } else {
            I.C().addOnCompleteListener(new OnCompleteListener() { // from class: d3.w
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.P(a1.f0.this, I, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void j(a1.b bVar, a1.q qVar, final a1.g0 g0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            g0Var.b(v.d());
        } else if (qVar == null) {
            I.D().addOnCompleteListener(new OnCompleteListener() { // from class: d3.h0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.Q(a1.g0.this, task);
                }
            });
        } else {
            I.E(g3.a(qVar)).addOnCompleteListener(new OnCompleteListener() { // from class: d3.i0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.R(a1.g0.this, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void k(a1.b bVar, final a1.g0 g0Var) {
        com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            g0Var.b(v.d());
        } else {
            I.t().addOnCompleteListener(new OnCompleteListener() { // from class: d3.y
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.J(a1.g0.this, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void l(a1.b bVar, String str, final a1.f0<a1.b0> f0Var) {
        final com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
        } else {
            I.J(str).addOnCompleteListener(new OnCompleteListener() { // from class: d3.n0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.W(com.google.firebase.auth.a0.this, f0Var, task);
                }
            });
        }
    }

    @Override // d3.a1.e
    public void m(a1.b bVar, a1.d0 d0Var, final a1.f0<a1.b0> f0Var) {
        final com.google.firebase.auth.a0 I = I(bVar);
        if (I == null) {
            f0Var.b(v.d());
            return;
        }
        e1.a aVar = new e1.a();
        if (d0Var.c().booleanValue()) {
            aVar.b(d0Var.b());
        }
        if (d0Var.e().booleanValue()) {
            aVar.c(d0Var.d() != null ? Uri.parse(d0Var.d()) : null);
        }
        I.L(aVar.a()).addOnCompleteListener(new OnCompleteListener() { // from class: d3.l0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                q0.a0(com.google.firebase.auth.a0.this, f0Var, task);
            }
        });
    }

    @Override // d3.a1.e
    public void n(final a1.b bVar, final Boolean bool, final a1.f0<a1.u> f0Var) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: d3.o0
            @Override // java.lang.Runnable
            public final void run() {
                q0.K(a1.b.this, f0Var, bool);
            }
        });
    }
}
