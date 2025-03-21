package j1;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 implements Continuation<RecaptchaTasksClient, Task<String>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ RecaptchaAction f5343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(y0 y0Var, RecaptchaAction recaptchaAction) {
        this.f5343a = recaptchaAction;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<String> then(Task<RecaptchaTasksClient> task) {
        if (task.isSuccessful()) {
            return task.getResult().executeTask(this.f5343a);
        }
        Exception exc = (Exception) com.google.android.gms.common.internal.q.k(task.getException());
        if (exc instanceof v0) {
            if (Log.isLoggable("RecaptchaHandler", 4)) {
                String message = exc.getMessage();
                Log.i("RecaptchaHandler", "Ignoring error related to fetching recaptcha config - " + message);
            }
            return Tasks.forResult("");
        }
        return Tasks.forException(exc);
    }
}
