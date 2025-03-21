package com.google.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.a0;
import com.google.firebase.firestore.g1;
import com.google.firebase.firestore.z;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u1.a3;
import v1.q;
import z1.w;
/* loaded from: classes.dex */
public class FirebaseFirestore {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1630a;

    /* renamed from: b  reason: collision with root package name */
    private final v1.f f1631b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1632c;

    /* renamed from: d  reason: collision with root package name */
    private final q1.a<q1.j> f1633d;

    /* renamed from: e  reason: collision with root package name */
    private final q1.a<String> f1634e;

    /* renamed from: f  reason: collision with root package name */
    private final z1.g f1635f;

    /* renamed from: g  reason: collision with root package name */
    private final f1.f f1636g;

    /* renamed from: h  reason: collision with root package name */
    private final i1 f1637h;

    /* renamed from: i  reason: collision with root package name */
    private final a f1638i;

    /* renamed from: j  reason: collision with root package name */
    private a0 f1639j = new a0.b().f();

    /* renamed from: k  reason: collision with root package name */
    private volatile s1.o0 f1640k;

    /* renamed from: l  reason: collision with root package name */
    private final y1.j0 f1641l;

    /* loaded from: classes.dex */
    public interface a {
        void remove(String str);
    }

    FirebaseFirestore(Context context, v1.f fVar, String str, q1.a<q1.j> aVar, q1.a<String> aVar2, z1.g gVar, f1.f fVar2, a aVar3, y1.j0 j0Var) {
        this.f1630a = (Context) z1.y.b(context);
        this.f1631b = (v1.f) z1.y.b((v1.f) z1.y.b(fVar));
        this.f1637h = new i1(fVar);
        this.f1632c = (String) z1.y.b(str);
        this.f1633d = (q1.a) z1.y.b(aVar);
        this.f1634e = (q1.a) z1.y.b(aVar2);
        this.f1635f = (z1.g) z1.y.b(gVar);
        this.f1636g = fVar2;
        this.f1638i = aVar3;
        this.f1641l = j0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ w0 A(Task task) {
        s1.a1 a1Var = (s1.a1) task.getResult();
        if (a1Var != null) {
            return new w0(a1Var, this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object B(g1.a aVar, s1.j1 j1Var) {
        return aVar.a(new g1(j1Var, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task C(Executor executor, final g1.a aVar, final s1.j1 j1Var) {
        return Tasks.call(executor, new Callable() { // from class: com.google.firebase.firestore.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object B;
                B = FirebaseFirestore.this.B(aVar, j1Var);
                return B;
            }
        });
    }

    private a0 F(a0 a0Var, o1.a aVar) {
        return a0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FirebaseFirestore G(Context context, f1.f fVar, b2.a<j1.b> aVar, b2.a<i1.b> aVar2, String str, a aVar3, y1.j0 j0Var) {
        String g5 = fVar.r().g();
        if (g5 != null) {
            v1.f c5 = v1.f.c(g5, str);
            z1.g gVar = new z1.g();
            return new FirebaseFirestore(context, c5, fVar.q(), new q1.i(aVar), new q1.e(aVar2), gVar, fVar, aVar3, j0Var);
        }
        throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
    }

    private <ResultT> Task<ResultT> I(h1 h1Var, final g1.a<ResultT> aVar, final Executor executor) {
        q();
        return this.f1640k.j0(h1Var, new z1.u() { // from class: com.google.firebase.firestore.x
            @Override // z1.u
            public final Object apply(Object obj) {
                Task C;
                C = FirebaseFirestore.this.C(executor, aVar, (s1.j1) obj);
                return C;
            }
        });
    }

    public static void L(boolean z4) {
        z1.w.d(z4 ? w.b.DEBUG : w.b.WARN);
    }

    private g0 h(Executor executor, Activity activity, final Runnable runnable) {
        q();
        final s1.h hVar = new s1.h(executor, new o() { // from class: com.google.firebase.firestore.t
            @Override // com.google.firebase.firestore.o
            public final void a(Object obj, z zVar) {
                FirebaseFirestore.x(runnable, (Void) obj, zVar);
            }
        });
        this.f1640k.x(hVar);
        return s1.d.c(activity, new g0() { // from class: com.google.firebase.firestore.u
            @Override // com.google.firebase.firestore.g0
            public final void remove() {
                FirebaseFirestore.this.y(hVar);
            }
        });
    }

    private void q() {
        if (this.f1640k != null) {
            return;
        }
        synchronized (this.f1631b) {
            if (this.f1640k != null) {
                return;
            }
            this.f1640k = new s1.o0(this.f1630a, new s1.l(this.f1631b, this.f1632c, this.f1639j.c(), this.f1639j.e()), this.f1639j, this.f1633d, this.f1634e, this.f1635f, this.f1641l);
        }
    }

    static void setClientLanguage(String str) {
        y1.z.p(str);
    }

    public static FirebaseFirestore u(f1.f fVar, String str) {
        z1.y.c(fVar, "Provided FirebaseApp must not be null.");
        z1.y.c(str, "Provided database name must not be null.");
        b0 b0Var = (b0) fVar.k(b0.class);
        z1.y.c(b0Var, "Firestore component is not present.");
        return b0Var.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Runnable runnable, Void r22, z zVar) {
        z1.b.d(zVar == null, "snapshots-in-sync listeners should never get errors.", new Object[0]);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(s1.h hVar) {
        hVar.d();
        this.f1640k.f0(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(TaskCompletionSource taskCompletionSource) {
        try {
            if (this.f1640k != null && !this.f1640k.F()) {
                throw new z("Persistence cannot be cleared while the firestore instance is running.", z.a.FAILED_PRECONDITION);
            }
            a3.s(this.f1630a, this.f1631b, this.f1632c);
            taskCompletionSource.setResult(null);
        } catch (z e5) {
            taskCompletionSource.setException(e5);
        }
    }

    public i0 D(InputStream inputStream) {
        q();
        i0 i0Var = new i0();
        this.f1640k.e0(inputStream, i0Var);
        return i0Var;
    }

    public i0 E(byte[] bArr) {
        return D(new ByteArrayInputStream(bArr));
    }

    public <TResult> Task<TResult> H(h1 h1Var, g1.a<TResult> aVar) {
        z1.y.c(aVar, "Provided transaction update function must not be null.");
        return I(h1Var, aVar, s1.j1.g());
    }

    public void J(a0 a0Var) {
        a0 F = F(a0Var, null);
        synchronized (this.f1631b) {
            z1.y.c(F, "Provided settings must not be null.");
            if (this.f1640k != null && !this.f1639j.equals(F)) {
                throw new IllegalStateException("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
            }
            this.f1639j = F;
        }
    }

    @Deprecated
    public Task<Void> K(String str) {
        q();
        z1.y.e(this.f1639j.d(), "Cannot enable indexes when persistence is disabled");
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("indexes")) {
                JSONArray jSONArray = jSONObject.getJSONArray("indexes");
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                    String string = jSONObject2.getString("collectionGroup");
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray = jSONObject2.optJSONArray("fields");
                    for (int i6 = 0; optJSONArray != null && i6 < optJSONArray.length(); i6++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i6);
                        v1.r u5 = v1.r.u(jSONObject3.getString("fieldPath"));
                        arrayList2.add("CONTAINS".equals(jSONObject3.optString("arrayConfig")) ? q.c.c(u5, q.c.a.CONTAINS) : "ASCENDING".equals(jSONObject3.optString("order")) ? q.c.c(u5, q.c.a.ASCENDING) : q.c.c(u5, q.c.a.DESCENDING));
                    }
                    arrayList.add(v1.q.b(-1, string, arrayList2, v1.q.f8126a));
                }
            }
            return this.f1640k.y(arrayList);
        } catch (JSONException e5) {
            throw new IllegalArgumentException("Failed to parse index configuration", e5);
        }
    }

    public Task<Void> M() {
        this.f1638i.remove(t().e());
        q();
        return this.f1640k.i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(m mVar) {
        z1.y.c(mVar, "Provided DocumentReference must not be null.");
        if (mVar.j() != this) {
            throw new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
        }
    }

    public Task<Void> O() {
        q();
        return this.f1640k.l0();
    }

    public g0 g(Runnable runnable) {
        return i(z1.p.f8960a, runnable);
    }

    public g0 i(Executor executor, Runnable runnable) {
        return h(executor, null, runnable);
    }

    public k1 j() {
        q();
        return new k1(this);
    }

    public Task<Void> k() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1635f.m(new Runnable() { // from class: com.google.firebase.firestore.v
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseFirestore.this.z(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public g l(String str) {
        z1.y.c(str, "Provided collection path must not be null.");
        q();
        return new g(v1.u.u(str), this);
    }

    public w0 m(String str) {
        z1.y.c(str, "Provided collection ID must not be null.");
        if (str.contains("/")) {
            throw new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", str));
        }
        q();
        return new w0(new s1.a1(v1.u.f8153b, str), this);
    }

    public Task<Void> n() {
        q();
        return this.f1640k.z();
    }

    public m o(String str) {
        z1.y.c(str, "Provided document path must not be null.");
        q();
        return m.h(v1.u.u(str), this);
    }

    public Task<Void> p() {
        q();
        return this.f1640k.A();
    }

    public f1.f r() {
        return this.f1636g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1.o0 s() {
        return this.f1640k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1.f t() {
        return this.f1631b;
    }

    public Task<w0> v(String str) {
        q();
        return this.f1640k.D(str).continueWith(new Continuation() { // from class: com.google.firebase.firestore.w
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                w0 A;
                A = FirebaseFirestore.this.A(task);
                return A;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1 w() {
        return this.f1637h;
    }
}
