package y1;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import i3.b;
import i3.j1;
import i3.y0;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends i3.b {

    /* renamed from: c  reason: collision with root package name */
    private static final y0.g<String> f8521c;

    /* renamed from: d  reason: collision with root package name */
    private static final y0.g<String> f8522d;

    /* renamed from: a  reason: collision with root package name */
    private final q1.a<q1.j> f8523a;

    /* renamed from: b  reason: collision with root package name */
    private final q1.a<String> f8524b;

    static {
        y0.d<String> dVar = i3.y0.f3588e;
        f8521c = y0.g.e("Authorization", dVar);
        f8522d = y0.g.e("x-firebase-appcheck", dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q1.a<q1.j> aVar, q1.a<String> aVar2) {
        this.f8523a = aVar;
        this.f8524b = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Task task, b.a aVar, Task task2, Task task3) {
        Exception exception;
        i3.y0 y0Var = new i3.y0();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            z1.w.a("FirestoreCallCredentials", "Successfully fetched auth token.", new Object[0]);
            if (str != null) {
                y0.g<String> gVar = f8521c;
                y0Var.p(gVar, "Bearer " + str);
            }
        } else {
            exception = task.getException();
            if (exception instanceof f1.c) {
                z1.w.a("FirestoreCallCredentials", "Firebase Auth API not available, not using authentication.", new Object[0]);
            } else if (!(exception instanceof d2.a)) {
                z1.w.e("FirestoreCallCredentials", "Failed to get auth token: %s.", exception);
                aVar.b(j1.f3440n.p(exception));
                return;
            } else {
                z1.w.a("FirestoreCallCredentials", "No user signed in, not using authentication.", new Object[0]);
            }
        }
        if (task2.isSuccessful()) {
            String str2 = (String) task2.getResult();
            if (str2 != null && !str2.isEmpty()) {
                z1.w.a("FirestoreCallCredentials", "Successfully fetched AppCheck token.", new Object[0]);
                y0Var.p(f8522d, str2);
            }
        } else {
            exception = task2.getException();
            if (!(exception instanceof f1.c)) {
                z1.w.e("FirestoreCallCredentials", "Failed to get AppCheck token: %s.", exception);
                aVar.b(j1.f3440n.p(exception));
                return;
            }
            z1.w.a("FirestoreCallCredentials", "Firebase AppCheck API not available.", new Object[0]);
        }
        aVar.a(y0Var);
    }

    @Override // i3.b
    public void a(b.AbstractC0068b abstractC0068b, Executor executor, final b.a aVar) {
        final Task<String> a5 = this.f8523a.a();
        final Task<String> a6 = this.f8524b.a();
        Tasks.whenAll(a5, a6).addOnCompleteListener(z1.p.f8961b, new OnCompleteListener() { // from class: y1.u
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                v.c(Task.this, aVar, a6, task);
            }
        });
    }
}
