package j1;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h0 implements OnSuccessListener<com.google.firebase.auth.i> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f5405a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Context f5406b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(a0 a0Var, TaskCompletionSource taskCompletionSource, Context context) {
        this.f5405a = taskCompletionSource;
        this.f5406b = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(com.google.firebase.auth.i iVar) {
        this.f5405a.setResult(iVar);
        a0.d(this.f5406b);
    }
}
