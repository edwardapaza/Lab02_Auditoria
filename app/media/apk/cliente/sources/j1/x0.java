package j1;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzac;
import com.google.android.gms.internal.p001firebaseauthapi.zzafj;
import com.google.android.gms.internal.p001firebaseauthapi.zzah;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x0 implements Continuation<zzafj, Task<RecaptchaTasksClient>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f5499a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ y0 f5500b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(y0 y0Var, String str) {
        this.f5499a = str;
        this.f5500b = y0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<RecaptchaTasksClient> then(Task<zzafj> task) {
        if (task.isSuccessful()) {
            zzafj result = task.getResult();
            String zza = result.zza();
            if (zzah.zzc(zza)) {
                String str = this.f5499a;
                return Tasks.forException(new v0("No Recaptcha Enterprise siteKey configured for tenant/project " + str));
            }
            List<String> zza2 = zzac.zza('/').zza((CharSequence) zza);
            String str2 = zza2.size() != 4 ? null : zza2.get(3);
            if (TextUtils.isEmpty(str2)) {
                return Tasks.forException(new Exception("Invalid siteKey format " + zza));
            }
            if (Log.isLoggable("RecaptchaHandler", 4)) {
                String str3 = this.f5499a;
                Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + str3);
            }
            this.f5500b.f5502b = result;
            y0 y0Var = this.f5500b;
            Task<RecaptchaTasksClient> a5 = y0Var.f5505e.a((Application) y0Var.f5503c.m(), str2);
            this.f5500b.f5501a.put(this.f5499a, a5);
            return a5;
        }
        return Tasks.forException(new v0((String) com.google.android.gms.common.internal.q.k(((Exception) com.google.android.gms.common.internal.q.k(task.getException())).getMessage())));
    }
}
