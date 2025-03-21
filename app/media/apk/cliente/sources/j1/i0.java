package j1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f5421a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<String> f5422b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ a0 f5423c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(a0 a0Var, Activity activity, TaskCompletionSource<String> taskCompletionSource) {
        this.f5423c = a0Var;
        this.f5421a = new WeakReference<>(activity);
        this.f5422b = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f5421a.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f5422b.setException(zzach.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            a0.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                a0.e(this.f5423c, intent, this.f5422b, context);
                return;
            }
            TaskCompletionSource<String> taskCompletionSource = this.f5422b;
            taskCompletionSource.setException(zzach.zza(r.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        } else if (h1.d(intent)) {
            this.f5422b.setException(zzach.zza(h1.a(intent)));
            a0.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.f5422b.setException(zzach.zza(r.a("WEB_CONTEXT_CANCELED")));
            a0.d(context);
        }
    }
}
