package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.h;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzadg<ResultT, CallbackT> implements zzacx<ResultT> {
    private final zzacw<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzadg(zzacw<ResultT, CallbackT> zzacwVar, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzacwVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzacx
    public final void zza(ResultT resultt, Status status) {
        q.l(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(resultt);
            return;
        }
        zzacw<ResultT, CallbackT> zzacwVar = this.zza;
        if (zzacwVar.zzs != null) {
            TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzacwVar.zzc);
            zzacw<ResultT, CallbackT> zzacwVar2 = this.zza;
            taskCompletionSource.setException(zzach.zza(firebaseAuth, zzacwVar2.zzs, ("reauthenticateWithCredential".equals(zzacwVar2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zzd : null));
            return;
        }
        h hVar = zzacwVar.zzp;
        if (hVar != null) {
            this.zzb.setException(zzach.zza(status, hVar, zzacwVar.zzq, zzacwVar.zzr));
        } else {
            this.zzb.setException(zzach.zza(status));
        }
    }
}
