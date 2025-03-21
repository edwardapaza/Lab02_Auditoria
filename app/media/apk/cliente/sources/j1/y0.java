package j1;

import com.google.android.gms.internal.p001firebaseauthapi.zzafj;
import com.google.android.gms.internal.p001firebaseauthapi.zzah;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Task<RecaptchaTasksClient>> f5501a;

    /* renamed from: b  reason: collision with root package name */
    private zzafj f5502b;

    /* renamed from: c  reason: collision with root package name */
    f1.f f5503c;

    /* renamed from: d  reason: collision with root package name */
    private FirebaseAuth f5504d;

    /* renamed from: e  reason: collision with root package name */
    t0 f5505e;

    public y0(f1.f fVar, FirebaseAuth firebaseAuth) {
        this(fVar, firebaseAuth, new w0());
    }

    private y0(f1.f fVar, FirebaseAuth firebaseAuth, t0 t0Var) {
        this.f5501a = new HashMap();
        this.f5503c = fVar;
        this.f5504d = firebaseAuth;
        this.f5505e = t0Var;
    }

    private final Task<RecaptchaTasksClient> e(String str) {
        return this.f5501a.get(str);
    }

    private static String f(String str) {
        return zzah.zzc(str) ? "*" : str;
    }

    public final Task<RecaptchaTasksClient> a(String str, Boolean bool) {
        Task<RecaptchaTasksClient> e5;
        String f5 = f(str);
        return (bool.booleanValue() || (e5 = e(f5)) == null) ? this.f5504d.Y("RECAPTCHA_ENTERPRISE").continueWithTask(new x0(this, f5)) : e5;
    }

    public final Task<String> b(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String f5 = f(str);
        Task<RecaptchaTasksClient> e5 = e(f5);
        if (bool.booleanValue() || e5 == null) {
            e5 = a(f5, bool);
        }
        return e5.continueWithTask(new a1(this, recaptchaAction));
    }

    public final boolean d(String str) {
        zzafj zzafjVar = this.f5502b;
        return zzafjVar != null && zzafjVar.zzb(str);
    }
}
