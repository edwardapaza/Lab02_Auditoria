package com.google.firebase.auth;

import com.google.firebase.auth.q0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l2 extends q0.b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ q0.b f1490a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1491b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l2(FirebaseAuth firebaseAuth, q0.b bVar) {
        this.f1490a = bVar;
        this.f1491b = firebaseAuth;
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onCodeAutoRetrievalTimeOut(String str) {
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onCodeSent(String str, q0.a aVar) {
        j1.f fVar;
        q0.b bVar = this.f1490a;
        fVar = this.f1491b.f1387g;
        bVar.onVerificationCompleted(q0.a(str, (String) com.google.android.gms.common.internal.q.k(fVar.e())));
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onVerificationCompleted(o0 o0Var) {
        this.f1490a.onVerificationCompleted(o0Var);
    }

    @Override // com.google.firebase.auth.q0.b
    public final void onVerificationFailed(f1.l lVar) {
        this.f1490a.onVerificationFailed(lVar);
    }
}
