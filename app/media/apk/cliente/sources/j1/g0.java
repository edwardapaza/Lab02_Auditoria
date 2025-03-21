package j1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f5397a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<com.google.firebase.auth.i> f5398b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseAuth f5399c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.auth.a0 f5400d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ a0 f5401e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(a0 a0Var, Activity activity, TaskCompletionSource<com.google.firebase.auth.i> taskCompletionSource, FirebaseAuth firebaseAuth, com.google.firebase.auth.a0 a0Var2) {
        this.f5401e = a0Var;
        this.f5397a = new WeakReference<>(activity);
        this.f5398b = taskCompletionSource;
        this.f5399c = firebaseAuth;
        this.f5400d = a0Var2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f5397a.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f5398b.setException(zzach.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            a0.d(context);
        } else if (!intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            if (h1.d(intent)) {
                this.f5398b.setException(zzach.zza(h1.a(intent)));
                a0.d(context);
            } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                this.f5398b.setException(zzach.zza(r.a("WEB_CONTEXT_CANCELED")));
                a0.d(context);
            }
        } else {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                this.f5399c.B(a0.a(intent)).addOnSuccessListener(new c0(r0, r1, context)).addOnFailureListener(new z(this.f5401e, this.f5398b, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                this.f5400d.A(a0.a(intent)).addOnSuccessListener(new f0(r0, r1, context)).addOnFailureListener(new b0(this.f5401e, this.f5398b, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                this.f5400d.B(a0.a(intent)).addOnSuccessListener(new h0(r0, r1, context)).addOnFailureListener(new e0(this.f5401e, this.f5398b, context));
            } else {
                TaskCompletionSource<com.google.firebase.auth.i> taskCompletionSource = this.f5398b;
                taskCompletionSource.setException(zzach.zza(r.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
            }
        }
    }
}
