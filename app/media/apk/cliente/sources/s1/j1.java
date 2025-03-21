package s1;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class j1 {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f7361g = d();

    /* renamed from: a  reason: collision with root package name */
    private final y1.r f7362a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7365d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.firebase.firestore.z f7366e;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<v1.l, v1.w> f7363b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<w1.f> f7364c = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Set<v1.l> f7367f = new HashSet();

    public j1(y1.r rVar) {
        this.f7362a = rVar;
    }

    private static Executor d() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    private void f() {
        z1.b.d(!this.f7365d, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
    }

    public static Executor g() {
        return f7361g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task h(Task task) {
        return task.isSuccessful() ? Tasks.forResult(null) : Tasks.forException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task i(Task task) {
        if (task.isSuccessful()) {
            for (v1.s sVar : (List) task.getResult()) {
                m(sVar);
            }
        }
        return task;
    }

    private w1.m k(v1.l lVar) {
        v1.w wVar = this.f7363b.get(lVar);
        return (this.f7367f.contains(lVar) || wVar == null) ? w1.m.f8253c : wVar.equals(v1.w.f8154b) ? w1.m.a(false) : w1.m.f(wVar);
    }

    private w1.m l(v1.l lVar) {
        v1.w wVar = this.f7363b.get(lVar);
        if (this.f7367f.contains(lVar) || wVar == null) {
            return w1.m.a(true);
        }
        if (wVar.equals(v1.w.f8154b)) {
            throw new com.google.firebase.firestore.z("Can't update a document that doesn't exist.", z.a.INVALID_ARGUMENT);
        }
        return w1.m.f(wVar);
    }

    private void m(v1.s sVar) {
        v1.w wVar;
        if (sVar.b()) {
            wVar = sVar.j();
        } else if (!sVar.h()) {
            throw z1.b.a("Unexpected document type in transaction: " + sVar, new Object[0]);
        } else {
            wVar = v1.w.f8154b;
        }
        if (!this.f7363b.containsKey(sVar.getKey())) {
            this.f7363b.put(sVar.getKey(), wVar);
        } else if (!this.f7363b.get(sVar.getKey()).equals(sVar.j())) {
            throw new com.google.firebase.firestore.z("Document version changed between two reads.", z.a.ABORTED);
        }
    }

    private void p(List<w1.f> list) {
        f();
        this.f7364c.addAll(list);
    }

    public Task<Void> c() {
        f();
        com.google.firebase.firestore.z zVar = this.f7366e;
        if (zVar != null) {
            return Tasks.forException(zVar);
        }
        HashSet hashSet = new HashSet(this.f7363b.keySet());
        Iterator<w1.f> it = this.f7364c.iterator();
        while (it.hasNext()) {
            hashSet.remove(it.next().g());
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            v1.l lVar = (v1.l) it2.next();
            this.f7364c.add(new w1.q(lVar, k(lVar)));
        }
        this.f7365d = true;
        return this.f7362a.e(this.f7364c).continueWithTask(z1.p.f8961b, new Continuation() { // from class: s1.h1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task h5;
                h5 = j1.h(task);
                return h5;
            }
        });
    }

    public void e(v1.l lVar) {
        p(Collections.singletonList(new w1.c(lVar, k(lVar))));
        this.f7367f.add(lVar);
    }

    public Task<List<v1.s>> j(List<v1.l> list) {
        f();
        return this.f7364c.size() != 0 ? Tasks.forException(new com.google.firebase.firestore.z("Firestore transactions require all reads to be executed before all writes.", z.a.INVALID_ARGUMENT)) : this.f7362a.p(list).continueWithTask(z1.p.f8961b, new Continuation() { // from class: s1.i1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task i5;
                i5 = j1.this.i(task);
                return i5;
            }
        });
    }

    public void n(v1.l lVar, r1 r1Var) {
        p(Collections.singletonList(r1Var.a(lVar, k(lVar))));
        this.f7367f.add(lVar);
    }

    public void o(v1.l lVar, s1 s1Var) {
        try {
            p(Collections.singletonList(s1Var.a(lVar, l(lVar))));
        } catch (com.google.firebase.firestore.z e5) {
            this.f7366e = e5;
        }
        this.f7367f.add(lVar);
    }
}
