package j1;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f5507a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Context f5508b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a0 a0Var, TaskCompletionSource taskCompletionSource, Context context) {
        this.f5507a = taskCompletionSource;
        this.f5508b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f5507a.setException(exc);
        a0.d(this.f5508b);
    }
}
