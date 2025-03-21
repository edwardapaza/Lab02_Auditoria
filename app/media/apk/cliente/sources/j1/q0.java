package j1;

import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public abstract class q0<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Task a(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) com.google.android.gms.common.internal.q.k(task.getException());
        if (zzach.zzc(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                String valueOf = String.valueOf(recaptchaAction);
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + valueOf);
            }
            if (firebaseAuth.r0() == null) {
                firebaseAuth.m0(new y0(firebaseAuth.l(), firebaseAuth));
            }
            return c(firebaseAuth.r0(), recaptchaAction, str, continuation);
        }
        String valueOf2 = String.valueOf(recaptchaAction);
        String message = exc.getMessage();
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + valueOf2 + "with exception - " + message);
        return Tasks.forException(exc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> Task<T> c(y0 y0Var, RecaptchaAction recaptchaAction, String str, Continuation<String, Task<T>> continuation) {
        Task<String> b5 = y0Var.b(str, Boolean.FALSE, recaptchaAction);
        return b5.continueWithTask(continuation).continueWithTask(new u0(str, y0Var, recaptchaAction, continuation));
    }

    public final Task<T> b(final FirebaseAuth firebaseAuth, final String str, final RecaptchaAction recaptchaAction, String str2) {
        final Continuation continuation = new Continuation() { // from class: j1.r0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                String str3;
                q0 q0Var = q0.this;
                if (task.isSuccessful()) {
                    str3 = (String) task.getResult();
                } else {
                    String message = ((Exception) com.google.android.gms.common.internal.q.k(task.getException())).getMessage();
                    Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + message + "\n\n Failing open with a fake token.");
                    str3 = "NO_RECAPTCHA";
                }
                return q0Var.d(str3);
            }
        };
        y0 r02 = firebaseAuth.r0();
        return (r02 == null || !r02.d(str2)) ? (Task<T>) d(null).continueWithTask(new Continuation() { // from class: j1.s0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return q0.a(RecaptchaAction.this, firebaseAuth, str, continuation, task);
            }
        }) : c(r02, recaptchaAction, str, continuation);
    }

    public abstract Task<T> d(String str);
}
