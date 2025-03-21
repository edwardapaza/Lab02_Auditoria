package q1;

import b2.a;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import z1.p;
import z1.v;
/* loaded from: classes.dex */
public final class e extends a<String> {

    /* renamed from: a  reason: collision with root package name */
    private v<String> f6938a;

    /* renamed from: b  reason: collision with root package name */
    private i1.b f6939b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6940c;

    /* renamed from: d  reason: collision with root package name */
    private final i1.a f6941d = new i1.a() { // from class: q1.b
    };

    public e(b2.a<i1.b> aVar) {
        aVar.a(new a.InterfaceC0028a() { // from class: q1.c
            @Override // b2.a.InterfaceC0028a
            public final void a(b2.b bVar) {
                e.this.h(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task g(Task task) {
        return task.isSuccessful() ? Tasks.forResult(((h1.a) task.getResult()).b()) : Tasks.forException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(b2.b bVar) {
        synchronized (this) {
            i1.b bVar2 = (i1.b) bVar.get();
            this.f6939b = bVar2;
            if (bVar2 != null) {
                bVar2.a(this.f6941d);
            }
        }
    }

    @Override // q1.a
    public synchronized Task<String> a() {
        i1.b bVar = this.f6939b;
        if (bVar == null) {
            return Tasks.forException(new f1.c("AppCheck is not available"));
        }
        Task<h1.a> c5 = bVar.c(this.f6940c);
        this.f6940c = false;
        return c5.continueWithTask(p.f8961b, new Continuation() { // from class: q1.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task g5;
                g5 = e.g(task);
                return g5;
            }
        });
    }

    @Override // q1.a
    public synchronized void b() {
        this.f6940c = true;
    }

    @Override // q1.a
    public synchronized void c() {
        this.f6938a = null;
        i1.b bVar = this.f6939b;
        if (bVar != null) {
            bVar.b(this.f6941d);
        }
    }

    @Override // q1.a
    public synchronized void d(v<String> vVar) {
        this.f6938a = vVar;
    }
}
