package y1;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.z;
import i3.g;
import i3.j1;
import i3.y0;
/* loaded from: classes.dex */
public class z {

    /* renamed from: g  reason: collision with root package name */
    private static final y0.g<String> f8563g;

    /* renamed from: h  reason: collision with root package name */
    private static final y0.g<String> f8564h;

    /* renamed from: i  reason: collision with root package name */
    private static final y0.g<String> f8565i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile String f8566j;

    /* renamed from: a  reason: collision with root package name */
    private final z1.g f8567a;

    /* renamed from: b  reason: collision with root package name */
    private final q1.a<q1.j> f8568b;

    /* renamed from: c  reason: collision with root package name */
    private final q1.a<String> f8569c;

    /* renamed from: d  reason: collision with root package name */
    private final i0 f8570d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8571e;

    /* renamed from: f  reason: collision with root package name */
    private final j0 f8572f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f8573a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i3.g[] f8574b;

        a(k0 k0Var, i3.g[] gVarArr) {
            this.f8573a = k0Var;
            this.f8574b = gVarArr;
        }

        @Override // i3.g.a
        public void a(j1 j1Var, i3.y0 y0Var) {
            try {
                this.f8573a.b(j1Var);
            } catch (Throwable th) {
                z.this.f8567a.u(th);
            }
        }

        @Override // i3.g.a
        public void b(i3.y0 y0Var) {
            try {
                this.f8573a.c(y0Var);
            } catch (Throwable th) {
                z.this.f8567a.u(th);
            }
        }

        @Override // i3.g.a
        public void c(Object obj) {
            try {
                this.f8573a.d(obj);
                this.f8574b[0].c(1);
            } catch (Throwable th) {
                z.this.f8567a.u(th);
            }
        }

        @Override // i3.g.a
        public void d() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
    /* loaded from: classes.dex */
    class b<ReqT, RespT> extends i3.z<ReqT, RespT> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.g[] f8576a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Task f8577b;

        b(i3.g[] gVarArr, Task task) {
            this.f8576a = gVarArr;
            this.f8577b = task;
        }

        @Override // i3.z, i3.d1, i3.g
        public void b() {
            if (this.f8576a[0] == null) {
                this.f8577b.addOnSuccessListener(z.this.f8567a.o(), new OnSuccessListener() { // from class: y1.a0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        ((i3.g) obj).b();
                    }
                });
            } else {
                super.b();
            }
        }

        @Override // i3.z, i3.d1
        protected i3.g<ReqT, RespT> f() {
            z1.b.d(this.f8576a[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
            return this.f8576a[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f8579a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i3.g f8580b;

        c(e eVar, i3.g gVar) {
            this.f8579a = eVar;
            this.f8580b = gVar;
        }

        @Override // i3.g.a
        public void a(j1 j1Var, i3.y0 y0Var) {
            this.f8579a.a(j1Var);
        }

        @Override // i3.g.a
        public void c(Object obj) {
            this.f8579a.b(obj);
            this.f8580b.c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TaskCompletionSource f8582a;

        d(TaskCompletionSource taskCompletionSource) {
            this.f8582a = taskCompletionSource;
        }

        @Override // i3.g.a
        public void a(j1 j1Var, i3.y0 y0Var) {
            if (!j1Var.o()) {
                this.f8582a.setException(z.this.f(j1Var));
            } else if (this.f8582a.getTask().isComplete()) {
            } else {
                this.f8582a.setException(new com.google.firebase.firestore.z("Received onClose with status OK, but no message.", z.a.INTERNAL));
            }
        }

        @Override // i3.g.a
        public void c(Object obj) {
            this.f8582a.setResult(obj);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<T> {
        public abstract void a(j1 j1Var);

        public abstract void b(T t5);
    }

    static {
        y0.d<String> dVar = i3.y0.f3588e;
        f8563g = y0.g.e("x-goog-api-client", dVar);
        f8564h = y0.g.e("google-cloud-resource-prefix", dVar);
        f8565i = y0.g.e("x-goog-request-params", dVar);
        f8566j = "gl-java/";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(z1.g gVar, Context context, q1.a<q1.j> aVar, q1.a<String> aVar2, s1.l lVar, j0 j0Var) {
        this.f8567a = gVar;
        this.f8572f = j0Var;
        this.f8568b = aVar;
        this.f8569c = aVar2;
        this.f8570d = new i0(gVar, context, lVar, new v(aVar, aVar2));
        v1.f a5 = lVar.a();
        this.f8571e = String.format("projects/%s/databases/%s", a5.h(), a5.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.firebase.firestore.z f(j1 j1Var) {
        return r.j(j1Var) ? new com.google.firebase.firestore.z("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", z.a.c(j1Var.m().d()), j1Var.l()) : z1.h0.t(j1Var);
    }

    private String g() {
        return String.format("%s fire/%s grpc/", f8566j, "24.11.0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(i3.g[] gVarArr, k0 k0Var, Task task) {
        i3.g gVar = (i3.g) task.getResult();
        gVarArr[0] = gVar;
        gVar.e(new a(k0Var, gVarArr), l());
        k0Var.a();
        gVarArr[0].c(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        i3.g gVar = (i3.g) task.getResult();
        gVar.e(new d(taskCompletionSource), l());
        gVar.c(2);
        gVar.d(obj);
        gVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(e eVar, Object obj, Task task) {
        i3.g gVar = (i3.g) task.getResult();
        gVar.e(new c(eVar, gVar), l());
        gVar.c(1);
        gVar.d(obj);
        gVar.b();
    }

    private i3.y0 l() {
        i3.y0 y0Var = new i3.y0();
        y0Var.p(f8563g, g());
        y0Var.p(f8564h, this.f8571e);
        y0Var.p(f8565i, this.f8571e);
        j0 j0Var = this.f8572f;
        if (j0Var != null) {
            j0Var.a(y0Var);
        }
        return y0Var;
    }

    public static void p(String str) {
        f8566j = str;
    }

    public void h() {
        this.f8568b.b();
        this.f8569c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> i3.g<ReqT, RespT> m(i3.z0<ReqT, RespT> z0Var, final k0<RespT> k0Var) {
        final i3.g[] gVarArr = {null};
        Task<i3.g<ReqT, RespT>> i5 = this.f8570d.i(z0Var);
        i5.addOnCompleteListener(this.f8567a.o(), new OnCompleteListener() { // from class: y1.w
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                z.this.i(gVarArr, k0Var, task);
            }
        });
        return new b(gVarArr, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> Task<RespT> n(i3.z0<ReqT, RespT> z0Var, final ReqT reqt) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f8570d.i(z0Var).addOnCompleteListener(this.f8567a.o(), new OnCompleteListener() { // from class: y1.y
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                z.this.j(taskCompletionSource, reqt, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> void o(i3.z0<ReqT, RespT> z0Var, final ReqT reqt, final e<RespT> eVar) {
        this.f8570d.i(z0Var).addOnCompleteListener(this.f8567a.o(), new OnCompleteListener() { // from class: y1.x
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                z.this.k(eVar, reqt, task);
            }
        });
    }

    public void q() {
        this.f8570d.u();
    }
}
