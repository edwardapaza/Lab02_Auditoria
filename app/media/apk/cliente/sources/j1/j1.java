package j1;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzafi;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.security.MessageDigest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j1 implements Continuation<zzafi, Task<IntegrityTokenResponse>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f5431a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ IntegrityManager f5432b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ d0 f5433c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j1(d0 d0Var, String str, IntegrityManager integrityManager) {
        this.f5431a = str;
        this.f5432b = integrityManager;
        this.f5433c = d0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<IntegrityTokenResponse> then(Task<zzafi> task) {
        String str;
        if (task.isSuccessful()) {
            this.f5433c.f5366a = task.getResult().zza();
            return this.f5432b.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(task.getResult().zza())).setNonce(new String(Base64.encode(MessageDigest.getInstance("SHA-256").digest(this.f5431a.getBytes("UTF-8")), 11))).build());
        }
        str = d0.f5364b;
        String message = task.getException().getMessage();
        Log.e(str, "Problem retrieving Play Integrity producer project:  " + message);
        return Tasks.forException(task.getException());
    }
}
