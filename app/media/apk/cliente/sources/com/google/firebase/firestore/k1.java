package com.google.firebase.firestore;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Map;
import s1.s1;
/* loaded from: classes.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f1736a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<w1.f> f1737b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f1738c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(FirebaseFirestore firebaseFirestore) {
        this.f1736a = (FirebaseFirestore) z1.y.b(firebaseFirestore);
    }

    private k1 f(m mVar, s1 s1Var) {
        this.f1736a.N(mVar);
        g();
        this.f1737b.add(s1Var.a(mVar.k(), w1.m.a(true)));
        return this;
    }

    private void g() {
        if (this.f1738c) {
            throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
        }
    }

    public Task<Void> a() {
        g();
        this.f1738c = true;
        return this.f1737b.size() > 0 ? this.f1736a.s().m0(this.f1737b) : Tasks.forResult(null);
    }

    public k1 b(m mVar) {
        this.f1736a.N(mVar);
        g();
        this.f1737b.add(new w1.c(mVar.k(), w1.m.f8253c));
        return this;
    }

    public k1 c(m mVar, Object obj) {
        return d(mVar, obj, a1.f1656c);
    }

    public k1 d(m mVar, Object obj, a1 a1Var) {
        this.f1736a.N(mVar);
        z1.y.c(obj, "Provided data must not be null.");
        z1.y.c(a1Var, "Provided options must not be null.");
        g();
        this.f1737b.add((a1Var.b() ? this.f1736a.w().g(obj, a1Var.a()) : this.f1736a.w().l(obj)).a(mVar.k(), w1.m.f8253c));
        return this;
    }

    public k1 e(m mVar, Map<String, Object> map) {
        return f(mVar, this.f1736a.w().o(map));
    }
}
