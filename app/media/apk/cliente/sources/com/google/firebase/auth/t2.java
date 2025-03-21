package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth.a f1556a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1557b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(FirebaseAuth firebaseAuth, FirebaseAuth.a aVar) {
        this.f1556a = aVar;
        this.f1557b = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1556a.a(this.f1557b);
    }
}
