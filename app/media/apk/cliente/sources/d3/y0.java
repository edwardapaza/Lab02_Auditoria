package d3;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import d3.a1;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public class y0 implements a1.j {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, com.google.firebase.auth.a1> f2618a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(a1.f0 f0Var, Task task) {
        if (!task.isSuccessful()) {
            f0Var.b(v.e(task.getException()));
            return;
        }
        com.google.firebase.auth.a1 a1Var = (com.google.firebase.auth.a1) task.getResult();
        f2618a.put(a1Var.e(), a1Var);
        f0Var.a(new a1.z.a().b(Long.valueOf(a1Var.h())).c(Long.valueOf(a1Var.b())).f(a1Var.e()).e(a1Var.a()).d(Long.valueOf(a1Var.g())).a());
    }

    @Override // d3.a1.j
    public void a(String str, final a1.f0<a1.z> f0Var) {
        com.google.firebase.auth.y0.a(w0.f2565b.get(str)).addOnCompleteListener(new OnCompleteListener() { // from class: d3.x0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                y0.e(a1.f0.this, task);
            }
        });
    }

    @Override // d3.a1.j
    public void b(String str, String str2, a1.f0<String> f0Var) {
        com.google.firebase.auth.x0 c5 = com.google.firebase.auth.y0.c(str, str2);
        String uuid = UUID.randomUUID().toString();
        w0.f2567d.put(uuid, c5);
        f0Var.a(uuid);
    }

    @Override // d3.a1.j
    public void c(String str, String str2, a1.f0<String> f0Var) {
        com.google.firebase.auth.x0 b5 = com.google.firebase.auth.y0.b(f2618a.get(str), str2);
        String uuid = UUID.randomUUID().toString();
        w0.f2567d.put(uuid, b5);
        f0Var.a(uuid);
    }
}
