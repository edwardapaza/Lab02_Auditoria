package j1;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e0 implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f5379a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Context f5380b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(a0 a0Var, TaskCompletionSource taskCompletionSource, Context context) {
        this.f5379a = taskCompletionSource;
        this.f5380b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f5379a.setException(exc);
        a0.d(this.f5380b);
    }
}
