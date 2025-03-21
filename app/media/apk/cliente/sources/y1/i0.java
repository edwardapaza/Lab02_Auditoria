package y1;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import i2.r;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import z1.g;
/* loaded from: classes.dex */
public class i0 {

    /* renamed from: h  reason: collision with root package name */
    private static z1.z<i3.v0<?>> f8407h;

    /* renamed from: a  reason: collision with root package name */
    private Task<i3.u0> f8408a;

    /* renamed from: b  reason: collision with root package name */
    private final z1.g f8409b;

    /* renamed from: c  reason: collision with root package name */
    private i3.c f8410c;

    /* renamed from: d  reason: collision with root package name */
    private g.b f8411d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f8412e;

    /* renamed from: f  reason: collision with root package name */
    private final s1.l f8413f;

    /* renamed from: g  reason: collision with root package name */
    private final i3.b f8414g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(z1.g gVar, Context context, s1.l lVar, i3.b bVar) {
        this.f8409b = gVar;
        this.f8412e = context;
        this.f8413f = lVar;
        this.f8414g = bVar;
        k();
    }

    private void h() {
        if (this.f8411d != null) {
            z1.w.a("GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f8411d.c();
            this.f8411d = null;
        }
    }

    private i3.u0 j(Context context, s1.l lVar) {
        i3.v0<?> v0Var;
        try {
            v0.a.a(context);
        } catch (IllegalStateException | l0.h | l0.i e5) {
            z1.w.e("GrpcCallProvider", "Failed to update ssl context: %s", e5);
        }
        z1.z<i3.v0<?>> zVar = f8407h;
        if (zVar != null) {
            v0Var = zVar.get();
        } else {
            i3.v0<?> b5 = i3.v0.b(lVar.b());
            if (!lVar.d()) {
                b5.d();
            }
            v0Var = b5;
        }
        v0Var.c(30L, TimeUnit.SECONDS);
        return j3.a.k(v0Var).i(context).a();
    }

    private void k() {
        this.f8408a = Tasks.call(z1.p.f8962c, new Callable() { // from class: y1.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                i3.u0 n5;
                n5 = i0.this.n();
                return n5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task l(i3.z0 z0Var, Task task) {
        return Tasks.forResult(((i3.u0) task.getResult()).d(z0Var, this.f8410c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ i3.u0 n() {
        final i3.u0 j5 = j(this.f8412e, this.f8413f);
        this.f8409b.l(new Runnable() { // from class: y1.c0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.m(j5);
            }
        });
        this.f8410c = ((r.b) ((r.b) i2.r.f(j5).c(this.f8414g)).d(this.f8409b.o())).b();
        z1.w.a("GrpcCallProvider", "Channel successfully reset.", new Object[0]);
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(i3.u0 u0Var) {
        z1.w.a("GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        h();
        t(u0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final i3.u0 u0Var) {
        this.f8409b.l(new Runnable() { // from class: y1.h0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.p(u0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(i3.u0 u0Var) {
        u0Var.n();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void p(final i3.u0 u0Var) {
        i3.p k5 = u0Var.k(true);
        z1.w.a("GrpcCallProvider", "Current gRPC connectivity state: " + k5, new Object[0]);
        h();
        if (k5 == i3.p.CONNECTING) {
            z1.w.a("GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f8411d = this.f8409b.k(g.d.CONNECTIVITY_ATTEMPT_TIMER, 15000L, new Runnable() { // from class: y1.d0
                @Override // java.lang.Runnable
                public final void run() {
                    i0.this.o(u0Var);
                }
            });
        }
        u0Var.l(k5, new Runnable() { // from class: y1.e0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.q(u0Var);
            }
        });
    }

    private void t(final i3.u0 u0Var) {
        this.f8409b.l(new Runnable() { // from class: y1.g0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.r(u0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> Task<i3.g<ReqT, RespT>> i(final i3.z0<ReqT, RespT> z0Var) {
        return (Task<i3.g<ReqT, RespT>>) this.f8408a.continueWithTask(this.f8409b.o(), new Continuation() { // from class: y1.f0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task l5;
                l5 = i0.this.l(z0Var, task);
                return l5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        try {
            i3.u0 u0Var = (i3.u0) Tasks.await(this.f8408a);
            u0Var.m();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (u0Var.i(1L, timeUnit)) {
                    return;
                }
                z1.w.a(z.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                u0Var.n();
                if (u0Var.i(60L, timeUnit)) {
                    return;
                }
                z1.w.e(z.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
            } catch (InterruptedException unused) {
                u0Var.n();
                z1.w.e(z.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused2) {
            z1.w.e(z.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e5) {
            z1.w.e(z.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", e5);
        }
    }
}
