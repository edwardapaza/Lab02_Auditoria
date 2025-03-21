package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.s;
import com.google.firebase.firestore.z;
import i2.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import s1.a1;
import s1.o;
import s1.p;
import s1.x1;
import s1.z0;
/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    final s1.a1 f1786a;

    /* renamed from: b  reason: collision with root package name */
    final FirebaseFirestore f1787b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ArrayList<com.google.firebase.firestore.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.firestore.a f1788a;

        a(com.google.firebase.firestore.a aVar) {
            this.f1788a = aVar;
            add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1790a;

        static {
            int[] iArr = new int[p.b.values().length];
            f1790a = iArr;
            try {
                iArr[p.b.NOT_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1790a[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1790a[p.b.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1790a[p.b.NOT_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        ASCENDING,
        DESCENDING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(s1.a1 a1Var, FirebaseFirestore firebaseFirestore) {
        this.f1786a = (s1.a1) z1.y.b(a1Var);
        this.f1787b = (FirebaseFirestore) z1.y.b(firebaseFirestore);
    }

    private void C(Object obj, p.b bVar) {
        if (!(obj instanceof List) || ((List) obj).size() == 0) {
            throw new IllegalArgumentException("Invalid Query. A non-empty array is required for '" + bVar.toString() + "' filters.");
        }
    }

    private void D() {
        if (this.f1786a.l().equals(a1.a.LIMIT_TO_LAST) && this.f1786a.h().isEmpty()) {
            throw new IllegalStateException("limitToLast() queries require specifying at least one orderBy() clause");
        }
    }

    private void E(s1.a1 a1Var, s1.p pVar) {
        p.b g5 = pVar.g();
        p.b k5 = k(a1Var.i(), h(g5));
        if (k5 != null) {
            if (k5 == g5) {
                throw new IllegalArgumentException("Invalid Query. You cannot use more than one '" + g5.toString() + "' filter.");
            }
            throw new IllegalArgumentException("Invalid Query. You cannot use '" + g5.toString() + "' filters with '" + k5.toString() + "' filters.");
        }
    }

    private void F(s1.q qVar) {
        s1.a1 a1Var = this.f1786a;
        for (s1.p pVar : qVar.c()) {
            E(a1Var, pVar);
            a1Var = a1Var.e(pVar);
        }
    }

    private g0 e(Executor executor, o.b bVar, Activity activity, final o<y0> oVar) {
        D();
        s1.h hVar = new s1.h(executor, new o() { // from class: com.google.firebase.firestore.u0
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj, z zVar) {
                w0.this.p(oVar, (x1) obj, zVar);
            }
        });
        return s1.d.c(activity, new s1.v0(this.f1787b.s(), this.f1787b.s().d0(this.f1786a, bVar, hVar), hVar));
    }

    private s1.i g(String str, Object[] objArr, boolean z4) {
        i2.d0 h5;
        List<s1.z0> h6 = this.f1786a.h();
        if (objArr.length > h6.size()) {
            throw new IllegalArgumentException("Too many arguments provided to " + str + "(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < objArr.length; i5++) {
            Object obj = objArr[i5];
            if (!h6.get(i5).c().equals(v1.r.f8134b)) {
                h5 = this.f1787b.w().h(obj);
            } else if (!(obj instanceof String)) {
                throw new IllegalArgumentException("Invalid query. Expected a string for document ID in " + str + "(), but got " + obj + ".");
            } else {
                String str2 = (String) obj;
                if (!this.f1786a.q() && str2.contains("/")) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection and ordering by FieldPath.documentId(), the value passed to " + str + "() must be a plain document ID, but '" + str2 + "' contains a slash.");
                }
                v1.u c5 = this.f1786a.n().c(v1.u.u(str2));
                if (!v1.l.s(c5)) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection group and ordering by FieldPath.documentId(), the value passed to " + str + "() must result in a valid document path, but '" + c5 + "' is not because it contains an odd number of segments.");
                }
                h5 = v1.z.F(this.f1787b.t(), v1.l.k(c5));
            }
            arrayList.add(h5);
        }
        return new s1.i(arrayList, z4);
    }

    private List<p.b> h(p.b bVar) {
        int i5 = b.f1790a[bVar.ordinal()];
        return i5 != 1 ? (i5 == 2 || i5 == 3) ? Arrays.asList(p.b.NOT_IN) : i5 != 4 ? new ArrayList() : Arrays.asList(p.b.ARRAY_CONTAINS_ANY, p.b.IN, p.b.NOT_IN, p.b.NOT_EQUAL) : Arrays.asList(p.b.NOT_EQUAL, p.b.NOT_IN);
    }

    private p.b k(List<s1.q> list, List<p.b> list2) {
        for (s1.q qVar : list) {
            for (s1.p pVar : qVar.c()) {
                if (list2.contains(pVar.g())) {
                    return pVar.g();
                }
            }
        }
        return null;
    }

    private Task<y0> n(final d1 d1Var) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        o.b bVar = new o.b();
        bVar.f7413a = true;
        bVar.f7414b = true;
        bVar.f7415c = true;
        taskCompletionSource2.setResult(e(z1.p.f8961b, bVar, null, new o() { // from class: com.google.firebase.firestore.v0
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj, z zVar) {
                w0.r(TaskCompletionSource.this, taskCompletionSource2, d1Var, (y0) obj, zVar);
            }
        }));
        return taskCompletionSource.getTask();
    }

    private static o.b o(p0 p0Var, f0 f0Var) {
        o.b bVar = new o.b();
        p0 p0Var2 = p0.INCLUDE;
        bVar.f7413a = p0Var == p0Var2;
        bVar.f7414b = p0Var == p0Var2;
        bVar.f7415c = false;
        bVar.f7416d = f0Var;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(o oVar, x1 x1Var, z zVar) {
        if (zVar != null) {
            oVar.a(null, zVar);
            return;
        }
        z1.b.d(x1Var != null, "Got event without value or error set", new Object[0]);
        oVar.a(new y0(this, x1Var, this.f1787b), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ y0 q(Task task) {
        return new y0(new w0(this.f1786a, this.f1787b), (x1) task.getResult(), this.f1787b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, d1 d1Var, y0 y0Var, z zVar) {
        if (zVar != null) {
            taskCompletionSource.setException(zVar);
            return;
        }
        try {
            ((g0) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (y0Var.m().b() && d1Var == d1.SERVER) {
                taskCompletionSource.setException(new z("Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to SERVER to retrieve the cached documents.)", z.a.UNAVAILABLE));
            } else {
                taskCompletionSource.setResult(y0Var);
            }
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            throw z1.b.b(e5, "Failed to register a listener for a query result", new Object[0]);
        } catch (ExecutionException e6) {
            throw z1.b.b(e6, "Failed to register a listener for a query result", new Object[0]);
        }
    }

    private w0 v(v1.r rVar, c cVar) {
        z1.y.c(cVar, "Provided direction must not be null.");
        if (this.f1786a.o() == null) {
            if (this.f1786a.g() == null) {
                return new w0(this.f1786a.A(s1.z0.d(cVar == c.ASCENDING ? z0.a.ASCENDING : z0.a.DESCENDING, rVar)), this.f1787b);
            }
            throw new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
        }
        throw new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
    }

    private s1.q w(s.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (s sVar : aVar.m()) {
            s1.q z4 = z(sVar);
            if (!z4.b().isEmpty()) {
                arrayList.add(z4);
            }
        }
        return arrayList.size() == 1 ? (s1.q) arrayList.get(0) : new s1.k(arrayList, aVar.n());
    }

    private i2.d0 x(Object obj) {
        v1.f t5;
        v1.l k5;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
            }
            if (!this.f1786a.q() && str.contains("/")) {
                throw new IllegalArgumentException("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '" + str + "' contains a '/' character.");
            }
            v1.u c5 = this.f1786a.n().c(v1.u.u(str));
            if (!v1.l.s(c5)) {
                throw new IllegalArgumentException("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '" + c5 + "' is not because it has an odd number of segments (" + c5.p() + ").");
            }
            t5 = m().t();
            k5 = v1.l.k(c5);
        } else if (!(obj instanceof m)) {
            throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: " + z1.h0.B(obj));
        } else {
            t5 = m().t();
            k5 = ((m) obj).k();
        }
        return v1.z.F(t5, k5);
    }

    private s1.p y(s.b bVar) {
        i2.d0 i5;
        q m5 = bVar.m();
        p.b n5 = bVar.n();
        Object o5 = bVar.o();
        z1.y.c(m5, "Provided field path must not be null.");
        z1.y.c(n5, "Provided op must not be null.");
        if (!m5.c().w()) {
            p.b bVar2 = p.b.IN;
            if (n5 == bVar2 || n5 == p.b.NOT_IN || n5 == p.b.ARRAY_CONTAINS_ANY) {
                C(o5, n5);
            }
            i5 = this.f1787b.w().i(o5, n5 == bVar2 || n5 == p.b.NOT_IN);
        } else if (n5 == p.b.ARRAY_CONTAINS || n5 == p.b.ARRAY_CONTAINS_ANY) {
            throw new IllegalArgumentException("Invalid query. You can't perform '" + n5.toString() + "' queries on FieldPath.documentId().");
        } else if (n5 == p.b.IN || n5 == p.b.NOT_IN) {
            C(o5, n5);
            b.C0063b n02 = i2.b.n0();
            for (Object obj : (List) o5) {
                n02.F(x(obj));
            }
            i5 = i2.d0.B0().F(n02).build();
        } else {
            i5 = x(o5);
        }
        return s1.p.e(m5.c(), n5, i5);
    }

    private s1.q z(s sVar) {
        boolean z4 = sVar instanceof s.b;
        z1.b.d(z4 || (sVar instanceof s.a), "Parsing is only supported for Filter.UnaryFilter and Filter.CompositeFilter.", new Object[0]);
        return z4 ? y((s.b) sVar) : w((s.a) sVar);
    }

    public w0 A(Object... objArr) {
        return new w0(this.f1786a.B(g("startAfter", objArr, false)), this.f1787b);
    }

    public w0 B(Object... objArr) {
        return new w0(this.f1786a.B(g("startAt", objArr, true)), this.f1787b);
    }

    public w0 G(s sVar) {
        s1.q z4 = z(sVar);
        if (z4.b().isEmpty()) {
            return this;
        }
        F(z4);
        return new w0(this.f1786a.e(z4), this.f1787b);
    }

    public w0 H(q qVar, Object obj) {
        return G(s.b(qVar, obj));
    }

    public w0 I(q qVar, List<? extends Object> list) {
        return G(s.c(qVar, list));
    }

    public w0 J(q qVar, Object obj) {
        return G(s.d(qVar, obj));
    }

    public w0 K(q qVar, Object obj) {
        return G(s.e(qVar, obj));
    }

    public w0 L(q qVar, Object obj) {
        return G(s.f(qVar, obj));
    }

    public w0 M(q qVar, List<? extends Object> list) {
        return G(s.g(qVar, list));
    }

    public w0 N(q qVar, Object obj) {
        return G(s.h(qVar, obj));
    }

    public w0 O(q qVar, Object obj) {
        return G(s.i(qVar, obj));
    }

    public w0 P(q qVar, Object obj) {
        return G(s.j(qVar, obj));
    }

    public w0 Q(q qVar, List<? extends Object> list) {
        return G(s.k(qVar, list));
    }

    public g0 d(b1 b1Var, o<y0> oVar) {
        z1.y.c(b1Var, "Provided options value must not be null.");
        z1.y.c(oVar, "Provided EventListener must not be null.");
        return e(b1Var.b(), o(b1Var.c(), b1Var.d()), b1Var.a(), oVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w0) {
            w0 w0Var = (w0) obj;
            return this.f1786a.equals(w0Var.f1786a) && this.f1787b.equals(w0Var.f1787b);
        }
        return false;
    }

    public com.google.firebase.firestore.c f(com.google.firebase.firestore.a aVar, com.google.firebase.firestore.a... aVarArr) {
        a aVar2 = new a(aVar);
        aVar2.addAll(Arrays.asList(aVarArr));
        return new com.google.firebase.firestore.c(this, aVar2);
    }

    public int hashCode() {
        return (this.f1786a.hashCode() * 31) + this.f1787b.hashCode();
    }

    public w0 i(Object... objArr) {
        return new w0(this.f1786a.d(g("endAt", objArr, true)), this.f1787b);
    }

    public w0 j(Object... objArr) {
        return new w0(this.f1786a.d(g("endBefore", objArr, false)), this.f1787b);
    }

    public Task<y0> l(d1 d1Var) {
        D();
        return d1Var == d1.CACHE ? this.f1787b.s().C(this.f1786a).continueWith(z1.p.f8961b, new Continuation() { // from class: com.google.firebase.firestore.t0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                y0 q5;
                q5 = w0.this.q(task);
                return q5;
            }
        }) : n(d1Var);
    }

    public FirebaseFirestore m() {
        return this.f1787b;
    }

    public w0 s(long j5) {
        if (j5 > 0) {
            return new w0(this.f1786a.s(j5), this.f1787b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limit (" + j5 + ") is invalid. Limit must be positive.");
    }

    public w0 t(long j5) {
        if (j5 > 0) {
            return new w0(this.f1786a.t(j5), this.f1787b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limitToLast (" + j5 + ") is invalid. Limit must be positive.");
    }

    public w0 u(q qVar, c cVar) {
        z1.y.c(qVar, "Provided field path must not be null.");
        return v(qVar.c(), cVar);
    }
}
