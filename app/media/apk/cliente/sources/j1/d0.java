package j1;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.android.gms.internal.p001firebaseauthapi.zzadq;
import com.google.android.gms.internal.p001firebaseauthapi.zzaec;
import com.google.android.gms.internal.p001firebaseauthapi.zzafi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5364b = "d0";

    /* renamed from: c  reason: collision with root package name */
    private static final d0 f5365c = new d0();

    /* renamed from: a  reason: collision with root package name */
    private String f5366a;

    private d0() {
    }

    public static d0 b() {
        return f5365c;
    }

    private final void e(FirebaseAuth firebaseAuth, g1 g1Var, Activity activity, TaskCompletionSource<o1> taskCompletionSource) {
        Task<String> task;
        if (activity == null) {
            taskCompletionSource.setException(new com.google.firebase.auth.t());
            return;
        }
        o0.d(firebaseAuth.l().m(), firebaseAuth);
        com.google.android.gms.common.internal.q.k(activity);
        TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
        if (a0.b().h(activity, taskCompletionSource2)) {
            new zzadq(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        } else {
            task = Tasks.forException(zzach.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        task.addOnSuccessListener(new l1(this, taskCompletionSource)).addOnFailureListener(new m1(this, taskCompletionSource));
    }

    private final void f(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z4, boolean z5, final g1 g1Var, final TaskCompletionSource<o1> taskCompletionSource) {
        if (!z4 || z5) {
            e(firebaseAuth, g1Var, activity, taskCompletionSource);
            return;
        }
        (!TextUtils.isEmpty(this.f5366a) ? Tasks.forResult(new zzafi(this.f5366a)) : firebaseAuth.K()).continueWithTask(firebaseAuth.E0(), new j1(this, str, IntegrityManagerFactory.create(firebaseAuth.l().m()))).addOnCompleteListener(new OnCompleteListener() { // from class: j1.i1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                d0.this.d(taskCompletionSource, firebaseAuth, g1Var, activity, task);
            }
        });
    }

    public static boolean h(Exception exc) {
        if (exc instanceof com.google.firebase.auth.t) {
            return true;
        }
        return (exc instanceof com.google.firebase.auth.q) && ((com.google.firebase.auth.q) exc).a().endsWith("UNAUTHORIZED_DOMAIN");
    }

    public final Task<o1> a(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z4, boolean z5, boolean z6, final RecaptchaAction recaptchaAction) {
        n1 r1Var;
        f fVar = (f) firebaseAuth.o();
        final g1 f5 = g1.f();
        if (!zzaec.zza(firebaseAuth.l()) && !fVar.h()) {
            String str2 = f5364b;
            boolean f6 = fVar.f();
            Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z5 + ", ForceRecaptchav2Flow from firebaseSettings = " + f6);
            boolean z7 = z5 || fVar.f();
            final TaskCompletionSource<o1> taskCompletionSource = new TaskCompletionSource<>();
            Task<String> e5 = f5.e();
            if (e5 != null) {
                if (e5.isSuccessful()) {
                    r1Var = new r1().d(e5.getResult());
                } else {
                    String message = e5.getException().getMessage();
                    Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + message);
                    Log.e(str2, "Continuing with application verification as normal");
                }
            }
            if (z7) {
                f(firebaseAuth, str, activity, z4, true, f5, taskCompletionSource);
            } else {
                firebaseAuth.r().addOnCompleteListener(new OnCompleteListener() { // from class: j1.c
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        d0.this.c(taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z4, r8, f5, task);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }
        r1Var = new r1();
        return Tasks.forResult(r1Var.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z4, boolean z5, g1 g1Var, Task task) {
        if (!task.isSuccessful()) {
            String str2 = f5364b;
            String message = task.getException().getMessage();
            Log.e(str2, "Failed to initialize reCAPTCHA config: " + message);
        }
        if (firebaseAuth.r0() == null || !firebaseAuth.r0().d("PHONE_PROVIDER")) {
            f(firebaseAuth, str, activity, z4, z5, g1Var, taskCompletionSource);
        } else {
            firebaseAuth.r0().b(firebaseAuth.q(), Boolean.FALSE, recaptchaAction).addOnSuccessListener(new k1(this, taskCompletionSource)).addOnFailureListener(new b1(this, taskCompletionSource));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, g1 g1Var, Activity activity, Task task) {
        if ((!task.isSuccessful() || task.getResult() == null || TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) ? false : true) {
            taskCompletionSource.setResult(new r1().a(((IntegrityTokenResponse) task.getResult()).token()).b());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        String str = f5364b;
        Log.e(str, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        e(firebaseAuth, g1Var, activity, taskCompletionSource);
    }
}
