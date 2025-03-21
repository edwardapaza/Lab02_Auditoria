package j1;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l1 implements OnSuccessListener<String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f5440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1(d0 d0Var, TaskCompletionSource taskCompletionSource) {
        this.f5440a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(String str) {
        this.f5440a.setResult(new r1().d(str).b());
    }
}
