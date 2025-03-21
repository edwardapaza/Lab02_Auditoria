package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzach;
import com.google.firebase.auth.q0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o2 extends q0.b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p0 f1517a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ q0.b f1518b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1519c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o2(FirebaseAuth firebaseAuth, p0 p0Var, q0.b bVar) {
        this.f1517a = p0Var;
        this.f1518b = bVar;
        this.f1519c = firebaseAuth;
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onCodeAutoRetrievalTimeOut(String str) {
        this.f1518b.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onCodeSent(String str, q0.a aVar) {
        this.f1518b.onCodeSent(str, aVar);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onVerificationCompleted(o0 o0Var) {
        this.f1518b.onVerificationCompleted(o0Var);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onVerificationFailed(f1.l lVar) {
        if (zzach.zza(lVar)) {
            this.f1517a.b(true);
            String i5 = this.f1517a.i();
            Log.d("FirebaseAuth", "Re-triggering phone verification with Recaptcha flow forced for phone number " + i5);
            FirebaseAuth.j0(this.f1517a);
            return;
        }
        String i6 = this.f1517a.i();
        String message = lVar.getMessage();
        Log.d("FirebaseAuth", "Invoking original failure callbacks after phone verification failure for " + i6 + ", error - " + message);
        this.f1518b.onVerificationFailed(lVar);
    }
}
