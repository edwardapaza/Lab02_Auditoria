package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.z;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import s1.o;
import s1.s1;
import s1.x1;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final v1.l f1744a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseFirestore f1745b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(v1.l lVar, FirebaseFirestore firebaseFirestore) {
        this.f1744a = (v1.l) z1.y.b(lVar);
        this.f1745b = firebaseFirestore;
    }

    private g0 e(Executor executor, o.b bVar, Activity activity, final o<n> oVar) {
        s1.h hVar = new s1.h(executor, new o() { // from class: com.google.firebase.firestore.k
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj, z zVar) {
                m.this.o(oVar, (x1) obj, zVar);
            }
        });
        return s1.d.c(activity, new s1.v0(this.f1745b.s(), this.f1745b.s().d0(f(), bVar, hVar), hVar));
    }

    private s1.a1 f() {
        return s1.a1.b(this.f1744a.q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m h(v1.u uVar, FirebaseFirestore firebaseFirestore) {
        if (uVar.p() % 2 == 0) {
            return new m(v1.l.k(uVar), firebaseFirestore);
        }
        throw new IllegalArgumentException("Invalid document reference. Document references must have an even number of segments, but " + uVar.d() + " has " + uVar.p());
    }

    private Task<n> m(final d1 d1Var) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        o.b bVar = new o.b();
        bVar.f7413a = true;
        bVar.f7414b = true;
        bVar.f7415c = true;
        taskCompletionSource2.setResult(e(z1.p.f8961b, bVar, null, new o() { // from class: com.google.firebase.firestore.l
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj, z zVar) {
                m.q(TaskCompletionSource.this, taskCompletionSource2, d1Var, (n) obj, zVar);
            }
        }));
        return taskCompletionSource.getTask();
    }

    private static o.b n(p0 p0Var, f0 f0Var) {
        o.b bVar = new o.b();
        p0 p0Var2 = p0.INCLUDE;
        bVar.f7413a = p0Var == p0Var2;
        bVar.f7414b = p0Var == p0Var2;
        bVar.f7415c = false;
        bVar.f7416d = f0Var;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(o oVar, x1 x1Var, z zVar) {
        if (zVar != null) {
            oVar.a(null, zVar);
            return;
        }
        z1.b.d(x1Var != null, "Got event without value or error set", new Object[0]);
        z1.b.d(x1Var.e().size() <= 1, "Too many documents returned on a document query", new Object[0]);
        v1.i k5 = x1Var.e().k(this.f1744a);
        oVar.a(k5 != null ? n.b(this.f1745b, k5, x1Var.k(), x1Var.f().contains(k5.getKey())) : n.c(this.f1745b, this.f1744a, x1Var.k()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n p(Task task) {
        v1.i iVar = (v1.i) task.getResult();
        return new n(this.f1745b, this.f1744a, iVar, true, iVar != null && iVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, d1 d1Var, n nVar, z zVar) {
        z zVar2;
        if (zVar != null) {
            taskCompletionSource.setException(zVar);
            return;
        }
        try {
            ((g0) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (!nVar.a() && nVar.f().b()) {
                zVar2 = new z("Failed to get document because the client is offline.", z.a.UNAVAILABLE);
            } else if (!nVar.a() || !nVar.f().b() || d1Var != d1.SERVER) {
                taskCompletionSource.setResult(nVar);
                return;
            } else {
                zVar2 = new z("Failed to get document from server. (However, this document does exist in the local cache. Run again without setting source to SERVER to retrieve the cached document.)", z.a.UNAVAILABLE);
            }
            taskCompletionSource.setException(zVar2);
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            throw z1.b.b(e5, "Failed to register a listener for a single document", new Object[0]);
        } catch (ExecutionException e6) {
            throw z1.b.b(e6, "Failed to register a listener for a single document", new Object[0]);
        }
    }

    private Task<Void> u(s1 s1Var) {
        return this.f1745b.s().m0(Collections.singletonList(s1Var.a(this.f1744a, w1.m.a(true)))).continueWith(z1.p.f8961b, z1.h0.C());
    }

    public g0 d(b1 b1Var, o<n> oVar) {
        z1.y.c(b1Var, "Provided options value must not be null.");
        z1.y.c(oVar, "Provided EventListener must not be null.");
        return e(b1Var.b(), n(b1Var.c(), b1Var.d()), b1Var.a(), oVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.f1744a.equals(mVar.f1744a) && this.f1745b.equals(mVar.f1745b);
        }
        return false;
    }

    public Task<Void> g() {
        return this.f1745b.s().m0(Collections.singletonList(new w1.c(this.f1744a, w1.m.f8253c))).continueWith(z1.p.f8961b, z1.h0.C());
    }

    public int hashCode() {
        return (this.f1744a.hashCode() * 31) + this.f1745b.hashCode();
    }

    public Task<n> i(d1 d1Var) {
        return d1Var == d1.CACHE ? this.f1745b.s().B(this.f1744a).continueWith(z1.p.f8961b, new Continuation() { // from class: com.google.firebase.firestore.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                n p5;
                p5 = m.this.p(task);
                return p5;
            }
        }) : m(d1Var);
    }

    public FirebaseFirestore j() {
        return this.f1745b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1.l k() {
        return this.f1744a;
    }

    public String l() {
        return this.f1744a.q().d();
    }

    public Task<Void> r(Object obj) {
        return s(obj, a1.f1656c);
    }

    public Task<Void> s(Object obj, a1 a1Var) {
        z1.y.c(obj, "Provided data must not be null.");
        z1.y.c(a1Var, "Provided options must not be null.");
        return this.f1745b.s().m0(Collections.singletonList((a1Var.b() ? this.f1745b.w().g(obj, a1Var.a()) : this.f1745b.w().l(obj)).a(this.f1744a, w1.m.f8253c))).continueWith(z1.p.f8961b, z1.h0.C());
    }

    public Task<Void> t(q qVar, Object obj, Object... objArr) {
        return u(this.f1745b.w().n(z1.h0.f(1, qVar, obj, objArr)));
    }
}
