package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(FirebaseAuth firebaseAuth) {
        this.f1563a = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<FirebaseAuth.a> list;
        list = this.f1563a.f1384d;
        for (FirebaseAuth.a aVar : list) {
            aVar.a(this.f1563a);
        }
    }
}
