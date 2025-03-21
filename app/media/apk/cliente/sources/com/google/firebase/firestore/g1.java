package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import s1.s1;
/* loaded from: classes.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    private final s1.j1 f1695a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseFirestore f1696b;

    /* loaded from: classes.dex */
    public interface a<TResult> {
        TResult a(g1 g1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(s1.j1 j1Var, FirebaseFirestore firebaseFirestore) {
        this.f1695a = (s1.j1) z1.y.b(j1Var);
        this.f1696b = (FirebaseFirestore) z1.y.b(firebaseFirestore);
    }

    private Task<n> d(m mVar) {
        return this.f1695a.j(Collections.singletonList(mVar.k())).continueWith(z1.p.f8961b, new Continuation() { // from class: com.google.firebase.firestore.f1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                n e5;
                e5 = g1.this.e(task);
                return e5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n e(Task task) {
        if (task.isSuccessful()) {
            List list = (List) task.getResult();
            if (list.size() == 1) {
                v1.s sVar = (v1.s) list.get(0);
                if (sVar.b()) {
                    return n.b(this.f1696b, sVar, false, false);
                }
                if (sVar.h()) {
                    return n.c(this.f1696b, sVar.getKey(), false);
                }
                throw z1.b.a("BatchGetDocumentsRequest returned unexpected document type: " + v1.s.class.getCanonicalName(), new Object[0]);
            }
            throw z1.b.a("Mismatch in docs returned from document lookup.", new Object[0]);
        }
        throw task.getException();
    }

    private g1 i(m mVar, s1 s1Var) {
        this.f1696b.N(mVar);
        this.f1695a.o(mVar.k(), s1Var);
        return this;
    }

    public g1 b(m mVar) {
        this.f1696b.N(mVar);
        this.f1695a.e(mVar.k());
        return this;
    }

    public n c(m mVar) {
        this.f1696b.N(mVar);
        try {
            return (n) Tasks.await(d(mVar));
        } catch (InterruptedException e5) {
            throw new RuntimeException(e5);
        } catch (ExecutionException e6) {
            if (e6.getCause() instanceof z) {
                throw ((z) e6.getCause());
            }
            throw new RuntimeException(e6.getCause());
        }
    }

    public g1 f(m mVar, Object obj) {
        return g(mVar, obj, a1.f1656c);
    }

    public g1 g(m mVar, Object obj, a1 a1Var) {
        this.f1696b.N(mVar);
        z1.y.c(obj, "Provided data must not be null.");
        z1.y.c(a1Var, "Provided options must not be null.");
        this.f1695a.n(mVar.k(), a1Var.b() ? this.f1696b.w().g(obj, a1Var.a()) : this.f1696b.w().l(obj));
        return this;
    }

    public g1 h(m mVar, Map<String, Object> map) {
        return i(mVar, this.f1696b.w().o(map));
    }
}
