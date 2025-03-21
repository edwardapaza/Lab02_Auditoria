package j1;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
/* loaded from: classes.dex */
final class l implements Continuation<com.google.firebase.auth.c0, Task<com.google.firebase.auth.l0>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ m f5438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar) {
        this.f5438a = mVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<com.google.firebase.auth.l0> then(Task<com.google.firebase.auth.c0> task) {
        i iVar;
        if (task.isSuccessful()) {
            String g5 = task.getResult().g();
            iVar = this.f5438a.f5441a;
            return Tasks.forResult(p.u(g5, iVar));
        }
        return Tasks.forException(task.getException());
    }
}
