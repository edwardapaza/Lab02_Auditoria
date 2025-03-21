package j1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: c  reason: collision with root package name */
    private static a0 f5340c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f5341a = false;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f5342b;

    private a0() {
    }

    private static com.google.firebase.auth.h a(Intent intent) {
        com.google.android.gms.common.internal.q.k(intent);
        return com.google.firebase.auth.d2.A(((zzags) m0.e.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzags.CREATOR)).zzc(true));
    }

    public static a0 b() {
        if (f5340c == null) {
            f5340c = new a0();
        }
        return f5340c;
    }

    private final void c(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f5342b = broadcastReceiver;
        t.a.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        a0 a0Var = f5340c;
        a0Var.f5341a = false;
        if (a0Var.f5342b != null) {
            t.a.b(context).e(f5340c.f5342b);
        }
        f5340c.f5342b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(a0 a0Var, Intent intent, TaskCompletionSource taskCompletionSource, Context context) {
        taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
        d(context);
    }

    public final boolean h(Activity activity, TaskCompletionSource<String> taskCompletionSource) {
        if (this.f5341a) {
            return false;
        }
        c(activity, new i0(this, activity, taskCompletionSource));
        this.f5341a = true;
        return true;
    }

    public final boolean i(Activity activity, TaskCompletionSource<com.google.firebase.auth.i> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return j(activity, taskCompletionSource, firebaseAuth, null);
    }

    public final boolean j(Activity activity, TaskCompletionSource<com.google.firebase.auth.i> taskCompletionSource, FirebaseAuth firebaseAuth, com.google.firebase.auth.a0 a0Var) {
        if (this.f5341a) {
            return false;
        }
        c(activity, new g0(this, activity, taskCompletionSource, firebaseAuth, a0Var));
        this.f5341a = true;
        return true;
    }
}
