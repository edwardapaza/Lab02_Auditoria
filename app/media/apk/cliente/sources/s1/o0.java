package s1;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.z;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import s1.j;
import s1.o;
import u1.g4;
import u1.k;
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f7430a;

    /* renamed from: b  reason: collision with root package name */
    private final q1.a<q1.j> f7431b;

    /* renamed from: c  reason: collision with root package name */
    private final q1.a<String> f7432c;

    /* renamed from: d  reason: collision with root package name */
    private final z1.g f7433d;

    /* renamed from: e  reason: collision with root package name */
    private final r1.g f7434e;

    /* renamed from: f  reason: collision with root package name */
    private final y1.j0 f7435f;

    /* renamed from: g  reason: collision with root package name */
    private u1.e1 f7436g;

    /* renamed from: h  reason: collision with root package name */
    private u1.i0 f7437h;

    /* renamed from: i  reason: collision with root package name */
    private y1.s0 f7438i;

    /* renamed from: j  reason: collision with root package name */
    private e1 f7439j;

    /* renamed from: k  reason: collision with root package name */
    private o f7440k;

    /* renamed from: l  reason: collision with root package name */
    private g4 f7441l;

    /* renamed from: m  reason: collision with root package name */
    private g4 f7442m;

    public o0(final Context context, l lVar, final com.google.firebase.firestore.a0 a0Var, q1.a<q1.j> aVar, q1.a<String> aVar2, final z1.g gVar, y1.j0 j0Var) {
        this.f7430a = lVar;
        this.f7431b = aVar;
        this.f7432c = aVar2;
        this.f7433d = gVar;
        this.f7435f = j0Var;
        this.f7434e = new r1.g(new y1.o0(lVar.a()));
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        gVar.l(new Runnable() { // from class: s1.r
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.Q(taskCompletionSource, context, a0Var);
            }
        });
        aVar.d(new z1.v() { // from class: s1.c0
            @Override // z1.v
            public final void a(Object obj) {
                o0.this.S(atomicBoolean, taskCompletionSource, gVar, (q1.j) obj);
            }
        });
        aVar2.d(new z1.v() { // from class: s1.g0
            @Override // z1.v
            public final void a(Object obj) {
                o0.T((String) obj);
            }
        });
    }

    private void E(Context context, q1.j jVar, com.google.firebase.firestore.a0 a0Var) {
        z1.w.a("FirestoreClient", "Initializing. user=%s", jVar.a());
        j.a aVar = new j.a(context, this.f7433d, this.f7430a, new y1.r(this.f7430a, this.f7433d, this.f7431b, this.f7432c, context, this.f7435f), jVar, 100, a0Var);
        j d1Var = a0Var.d() ? new d1() : new w0();
        d1Var.q(aVar);
        this.f7436g = d1Var.n();
        this.f7442m = d1Var.k();
        this.f7437h = d1Var.m();
        this.f7438i = d1Var.o();
        this.f7439j = d1Var.p();
        this.f7440k = d1Var.j();
        u1.k l5 = d1Var.l();
        g4 g4Var = this.f7442m;
        if (g4Var != null) {
            g4Var.start();
        }
        if (l5 != null) {
            k.a f5 = l5.f();
            this.f7441l = f5;
            f5.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(com.google.firebase.firestore.o oVar) {
        this.f7440k.e(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(List list) {
        this.f7437h.z(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f7438i.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.f7438i.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v1.i K(Task task) {
        v1.i iVar = (v1.i) task.getResult();
        if (iVar.b()) {
            return iVar;
        }
        if (iVar.h()) {
            return null;
        }
        throw new com.google.firebase.firestore.z("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", z.a.UNAVAILABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ v1.i L(v1.l lVar) {
        return this.f7437h.h0(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x1 M(a1 a1Var) {
        u1.i1 A = this.f7437h.A(a1Var, true);
        v1 v1Var = new v1(a1Var, A.b());
        return v1Var.b(v1Var.h(A.a())).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(String str, TaskCompletionSource taskCompletionSource) {
        r1.j H = this.f7437h.H(str);
        if (H == null) {
            taskCompletionSource.setResult(null);
            return;
        }
        f1 b5 = H.a().b();
        taskCompletionSource.setResult(new a1(b5.n(), b5.d(), b5.h(), b5.m(), b5.j(), H.a().a(), b5.p(), b5.f()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(b1 b1Var) {
        this.f7440k.d(b1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(r1.f fVar, com.google.firebase.firestore.i0 i0Var) {
        this.f7439j.p(fVar, i0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(TaskCompletionSource taskCompletionSource, Context context, com.google.firebase.firestore.a0 a0Var) {
        try {
            E(context, (q1.j) Tasks.await(taskCompletionSource.getTask()), a0Var);
        } catch (InterruptedException | ExecutionException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(q1.j jVar) {
        z1.b.d(this.f7439j != null, "SyncEngine not yet initialized", new Object[0]);
        z1.w.a("FirestoreClient", "Credential changed. Current user: %s", jVar.a());
        this.f7439j.l(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, z1.g gVar, final q1.j jVar) {
        if (!atomicBoolean.compareAndSet(false, true)) {
            gVar.l(new Runnable() { // from class: s1.i0
                @Override // java.lang.Runnable
                public final void run() {
                    o0.this.R(jVar);
                }
            });
            return;
        }
        z1.b.d(!taskCompletionSource.getTask().isComplete(), "Already fulfilled first user task", new Object[0]);
        taskCompletionSource.setResult(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(com.google.firebase.firestore.o oVar) {
        this.f7440k.h(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(a1 a1Var, List list, final TaskCompletionSource taskCompletionSource) {
        this.f7439j.x(a1Var, list).addOnSuccessListener(new OnSuccessListener() { // from class: s1.d0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                TaskCompletionSource.this.setResult((Map) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: s1.e0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                TaskCompletionSource.this.setException(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(b1 b1Var) {
        this.f7440k.g(b1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        this.f7438i.P();
        this.f7436g.l();
        g4 g4Var = this.f7442m;
        if (g4Var != null) {
            g4Var.a();
        }
        g4 g4Var2 = this.f7441l;
        if (g4Var2 != null) {
            g4Var2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task a0(com.google.firebase.firestore.h1 h1Var, z1.u uVar) {
        return this.f7439j.C(this.f7433d, h1Var, uVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(TaskCompletionSource taskCompletionSource) {
        this.f7439j.t(taskCompletionSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(List list, TaskCompletionSource taskCompletionSource) {
        this.f7439j.E(list, taskCompletionSource);
    }

    private void k0() {
        if (F()) {
            throw new IllegalStateException("The client has already been terminated");
        }
    }

    public Task<Void> A() {
        k0();
        return this.f7433d.i(new Runnable() { // from class: s1.n0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.J();
            }
        });
    }

    public Task<v1.i> B(final v1.l lVar) {
        k0();
        return this.f7433d.j(new Callable() { // from class: s1.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                v1.i L;
                L = o0.this.L(lVar);
                return L;
            }
        }).continueWith(new Continuation() { // from class: s1.w
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                v1.i K;
                K = o0.K(task);
                return K;
            }
        });
    }

    public Task<x1> C(final a1 a1Var) {
        k0();
        return this.f7433d.j(new Callable() { // from class: s1.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                x1 M;
                M = o0.this.M(a1Var);
                return M;
            }
        });
    }

    public Task<a1> D(final String str) {
        k0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7433d.l(new Runnable() { // from class: s1.x
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.N(str, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public boolean F() {
        return this.f7433d.p();
    }

    public b1 d0(a1 a1Var, o.b bVar, com.google.firebase.firestore.o<x1> oVar) {
        k0();
        final b1 b1Var = new b1(a1Var, bVar, oVar);
        this.f7433d.l(new Runnable() { // from class: s1.z
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.O(b1Var);
            }
        });
        return b1Var;
    }

    public void e0(InputStream inputStream, final com.google.firebase.firestore.i0 i0Var) {
        k0();
        final r1.f fVar = new r1.f(this.f7434e, inputStream);
        this.f7433d.l(new Runnable() { // from class: s1.l0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.P(fVar, i0Var);
            }
        });
    }

    public void f0(final com.google.firebase.firestore.o<Void> oVar) {
        if (F()) {
            return;
        }
        this.f7433d.l(new Runnable() { // from class: s1.b0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.U(oVar);
            }
        });
    }

    public Task<Map<String, i2.d0>> g0(final a1 a1Var, final List<com.google.firebase.firestore.a> list) {
        k0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7433d.l(new Runnable() { // from class: s1.u
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.X(a1Var, list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void h0(final b1 b1Var) {
        if (F()) {
            return;
        }
        this.f7433d.l(new Runnable() { // from class: s1.a0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.Y(b1Var);
            }
        });
    }

    public Task<Void> i0() {
        this.f7431b.c();
        this.f7432c.c();
        return this.f7433d.n(new Runnable() { // from class: s1.h0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.Z();
            }
        });
    }

    public <TResult> Task<TResult> j0(final com.google.firebase.firestore.h1 h1Var, final z1.u<j1, Task<TResult>> uVar) {
        k0();
        return z1.g.g(this.f7433d.o(), new Callable() { // from class: s1.f0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Task a02;
                a02 = o0.this.a0(h1Var, uVar);
                return a02;
            }
        });
    }

    public Task<Void> l0() {
        k0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7433d.l(new Runnable() { // from class: s1.j0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.b0(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<Void> m0(final List<w1.f> list) {
        k0();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f7433d.l(new Runnable() { // from class: s1.m0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.c0(list, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void x(final com.google.firebase.firestore.o<Void> oVar) {
        k0();
        this.f7433d.l(new Runnable() { // from class: s1.t
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.G(oVar);
            }
        });
    }

    public Task<Void> y(final List<v1.q> list) {
        k0();
        return this.f7433d.i(new Runnable() { // from class: s1.k0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.H(list);
            }
        });
    }

    public Task<Void> z() {
        k0();
        return this.f7433d.i(new Runnable() { // from class: s1.s
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.I();
            }
        });
    }
}
