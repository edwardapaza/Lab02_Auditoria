package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.firebase.auth.o0;
import com.google.firebase.auth.q0;
import f1.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzadr extends q0.b {
    private final /* synthetic */ q0.b zza;
    private final /* synthetic */ String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadr(q0.b bVar, String str) {
        this.zza = bVar;
        this.zzb = str;
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzads.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onCodeSent(String str, q0.a aVar) {
        this.zza.onCodeSent(str, aVar);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onVerificationCompleted(o0 o0Var) {
        zzads.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(o0Var);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onVerificationFailed(l lVar) {
        zzads.zza.remove(this.zzb);
        this.zza.onVerificationFailed(lVar);
    }
}
