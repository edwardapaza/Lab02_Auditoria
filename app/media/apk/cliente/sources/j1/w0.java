package j1;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaTasksClient;
/* loaded from: classes.dex */
final class w0 implements t0 {
    @Override // j1.t0
    public final Task<RecaptchaTasksClient> a(Application application, String str) {
        return Recaptcha.getTasksClient(application, str);
    }
}
