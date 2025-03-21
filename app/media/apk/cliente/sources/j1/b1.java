package j1;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b1 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f5347a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(d0 d0Var, TaskCompletionSource taskCompletionSource) {
        this.f5347a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        String str;
        str = d0.f5364b;
        String message = exc.getMessage();
        Log.e(str, "Failed to get reCAPTCHA enterprise token: " + message + "\n\n Failing open with a fake token.");
        this.f5347a.setResult(new r1().c("NO_RECAPTCHA").b());
    }
}
