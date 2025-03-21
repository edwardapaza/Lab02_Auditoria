package j1;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
/* loaded from: classes.dex */
final class n implements Continuation<com.google.firebase.auth.i, Task<com.google.firebase.auth.i>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ o f5445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar) {
        this.f5445a = oVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<com.google.firebase.auth.i> then(Task<com.google.firebase.auth.i> task) {
        com.google.firebase.auth.d2 d2Var;
        com.google.firebase.auth.d2 d2Var2;
        com.google.firebase.auth.d2 d2Var3;
        d2Var = this.f5445a.f5449d;
        if (d2Var == null) {
            return task;
        }
        if (task.isSuccessful()) {
            com.google.firebase.auth.i result = task.getResult();
            d2Var3 = this.f5445a.f5449d;
            return Tasks.forResult(new e2((i) result.m(), (c2) result.s(), d2Var3));
        }
        Exception exception = task.getException();
        if (exception instanceof com.google.firebase.auth.x) {
            d2Var2 = this.f5445a.f5449d;
            ((com.google.firebase.auth.x) exception).d(d2Var2);
        }
        return Tasks.forException(exception);
    }
}
