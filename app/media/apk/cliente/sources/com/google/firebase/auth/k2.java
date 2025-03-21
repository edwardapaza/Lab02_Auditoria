package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth.b f1482a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1483b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k2(FirebaseAuth firebaseAuth, FirebaseAuth.b bVar) {
        this.f1482a = bVar;
        this.f1483b = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1482a.a(this.f1483b);
    }
}
