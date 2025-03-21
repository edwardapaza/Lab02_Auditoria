package j1;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaTasksClient;
/* loaded from: classes.dex */
public interface t0 {
    Task<RecaptchaTasksClient> a(Application application, String str);
}
