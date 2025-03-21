package q1;

import b2.a;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.c0;
import z1.p;
import z1.v;
import z1.w;
/* loaded from: classes.dex */
public final class i extends a<j> {

    /* renamed from: a  reason: collision with root package name */
    private final j1.a f6946a = new j1.a() { // from class: q1.f
        @Override // j1.a
        public final void a(c2.b bVar) {
            i.this.j(bVar);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private j1.b f6947b;

    /* renamed from: c  reason: collision with root package name */
    private v<j> f6948c;

    /* renamed from: d  reason: collision with root package name */
    private int f6949d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6950e;

    public i(b2.a<j1.b> aVar) {
        aVar.a(new a.InterfaceC0028a() { // from class: q1.g
            @Override // b2.a.InterfaceC0028a
            public final void a(b2.b bVar) {
                i.this.k(bVar);
            }
        });
    }

    private synchronized j h() {
        String a5;
        j1.b bVar = this.f6947b;
        a5 = bVar == null ? null : bVar.a();
        return a5 != null ? new j(a5) : j.f6951b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task i(int i5, Task task) {
        synchronized (this) {
            if (i5 != this.f6949d) {
                w.a("FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                return a();
            } else if (task.isSuccessful()) {
                return Tasks.forResult(((c0) task.getResult()).g());
            } else {
                return Tasks.forException(task.getException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(c2.b bVar) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(b2.b bVar) {
        synchronized (this) {
            this.f6947b = (j1.b) bVar.get();
            l();
            this.f6947b.c(this.f6946a);
        }
    }

    private synchronized void l() {
        this.f6949d++;
        v<j> vVar = this.f6948c;
        if (vVar != null) {
            vVar.a(h());
        }
    }

    @Override // q1.a
    public synchronized Task<String> a() {
        j1.b bVar = this.f6947b;
        if (bVar == null) {
            return Tasks.forException(new f1.c("auth is not available"));
        }
        Task<c0> d5 = bVar.d(this.f6950e);
        this.f6950e = false;
        final int i5 = this.f6949d;
        return d5.continueWithTask(p.f8961b, new Continuation() { // from class: q1.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task i6;
                i6 = i.this.i(i5, task);
                return i6;
            }
        });
    }

    @Override // q1.a
    public synchronized void b() {
        this.f6950e = true;
    }

    @Override // q1.a
    public synchronized void c() {
        this.f6948c = null;
        j1.b bVar = this.f6947b;
        if (bVar != null) {
            bVar.b(this.f6946a);
        }
    }

    @Override // q1.a
    public synchronized void d(v<j> vVar) {
        this.f6948c = vVar;
        vVar.a(h());
    }
}
