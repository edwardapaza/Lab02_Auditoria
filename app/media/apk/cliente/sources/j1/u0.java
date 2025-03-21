package j1;

import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
/* loaded from: classes.dex */
final class u0 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f5484a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ y0 f5485b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ RecaptchaAction f5486c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Continuation f5487d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(String str, y0 y0Var, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.f5484a = str;
        this.f5485b = y0Var;
        this.f5486c = recaptchaAction;
        this.f5487d = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (task.isSuccessful() || !zzach.zzb((Exception) com.google.android.gms.common.internal.q.k(task.getException()))) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            String str = this.f5484a;
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + str);
        }
        return this.f5485b.b(this.f5484a, Boolean.TRUE, this.f5486c).continueWithTask(this.f5487d);
    }
}
