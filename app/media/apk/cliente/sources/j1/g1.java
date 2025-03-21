package j1;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: c  reason: collision with root package name */
    private static final g1 f5402c = new g1();

    /* renamed from: a  reason: collision with root package name */
    private final o0 f5403a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f5404b;

    private g1() {
        this(o0.j(), a0.b());
    }

    private g1(o0 o0Var, a0 a0Var) {
        this.f5403a = o0Var;
        this.f5404b = a0Var;
    }

    public static g1 f() {
        return f5402c;
    }

    public final void a(Context context) {
        this.f5403a.a(context);
    }

    public final void b(FirebaseAuth firebaseAuth) {
        this.f5403a.h(firebaseAuth);
    }

    public final boolean c(Activity activity, TaskCompletionSource<com.google.firebase.auth.i> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.f5404b.i(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean d(Activity activity, TaskCompletionSource<com.google.firebase.auth.i> taskCompletionSource, FirebaseAuth firebaseAuth, com.google.firebase.auth.a0 a0Var) {
        return this.f5404b.j(activity, taskCompletionSource, firebaseAuth, a0Var);
    }

    public final Task<String> e() {
        return this.f5403a.i();
    }
}
