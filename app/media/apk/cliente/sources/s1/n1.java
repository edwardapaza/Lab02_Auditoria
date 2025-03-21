package s1;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.z;
import z1.g;
/* loaded from: classes.dex */
public class n1<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private z1.g f7401a;

    /* renamed from: b  reason: collision with root package name */
    private y1.s0 f7402b;

    /* renamed from: c  reason: collision with root package name */
    private z1.u<j1, Task<TResult>> f7403c;

    /* renamed from: d  reason: collision with root package name */
    private int f7404d;

    /* renamed from: e  reason: collision with root package name */
    private z1.r f7405e;

    /* renamed from: f  reason: collision with root package name */
    private TaskCompletionSource<TResult> f7406f = new TaskCompletionSource<>();

    public n1(z1.g gVar, y1.s0 s0Var, com.google.firebase.firestore.h1 h1Var, z1.u<j1, Task<TResult>> uVar) {
        this.f7401a = gVar;
        this.f7402b = s0Var;
        this.f7403c = uVar;
        this.f7404d = h1Var.a();
        this.f7405e = new z1.r(gVar, g.d.RETRY_TRANSACTION);
    }

    private void d(Task task) {
        if (this.f7404d <= 0 || !e(task.getException())) {
            this.f7406f.setException(task.getException());
        } else {
            j();
        }
    }

    private static boolean e(Exception exc) {
        if (exc instanceof com.google.firebase.firestore.z) {
            com.google.firebase.firestore.z zVar = (com.google.firebase.firestore.z) exc;
            z.a a5 = zVar.a();
            return a5 == z.a.ABORTED || a5 == z.a.ALREADY_EXISTS || a5 == z.a.FAILED_PRECONDITION || !y1.r.k(zVar.a());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f(Task task, Task task2) {
        if (task2.isSuccessful()) {
            this.f7406f.setResult(task.getResult());
        } else {
            d(task2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(j1 j1Var, final Task task) {
        if (task.isSuccessful()) {
            j1Var.c().addOnCompleteListener(this.f7401a.o(), new OnCompleteListener() { // from class: s1.k1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    n1.this.f(task, task2);
                }
            });
        } else {
            d(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        final j1 q5 = this.f7402b.q();
        this.f7403c.apply(q5).addOnCompleteListener(this.f7401a.o(), new OnCompleteListener() { // from class: s1.m1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                n1.this.g(q5, task);
            }
        });
    }

    private void j() {
        this.f7404d--;
        this.f7405e.b(new Runnable() { // from class: s1.l1
            @Override // java.lang.Runnable
            public final void run() {
                n1.this.h();
            }
        });
    }

    public Task<TResult> i() {
        j();
        return this.f7406f.getTask();
    }
}
