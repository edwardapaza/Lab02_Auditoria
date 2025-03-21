package com.google.firebase.auth;

import com.google.android.gms.internal.p001firebaseauthapi.zzagi;
import com.google.android.gms.internal.p001firebaseauthapi.zzago;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v2 implements Continuation<zzagi, Task<a1>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v2(FirebaseAuth firebaseAuth) {
        this.f1562a = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<a1> then(Task<zzagi> task) {
        if (task.isSuccessful()) {
            zzagi result = task.getResult();
            if (result instanceof zzago) {
                zzago zzagoVar = (zzago) result;
                return Tasks.forResult(new j1.f1(com.google.android.gms.common.internal.q.e(zzagoVar.zzf()), com.google.android.gms.common.internal.q.e(zzagoVar.zze()), zzagoVar.zzc(), zzagoVar.zzb(), zzagoVar.zzd(), com.google.android.gms.common.internal.q.e(zzagoVar.zza()), this.f1562a));
            }
            String name = result.getClass().getName();
            throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + name + ".");
        }
        return Tasks.forException((Exception) com.google.android.gms.common.internal.q.k(task.getException()));
    }
}
