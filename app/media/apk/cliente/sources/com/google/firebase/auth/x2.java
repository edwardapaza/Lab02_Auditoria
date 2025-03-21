package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1570a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c2.b f1571b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x2(FirebaseAuth firebaseAuth, c2.b bVar) {
        this.f1570a = firebaseAuth;
        this.f1571b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<j1.a> list;
        List<FirebaseAuth.b> list2;
        list = this.f1570a.f1383c;
        for (j1.a aVar : list) {
            aVar.a(this.f1571b);
        }
        list2 = this.f1570a.f1382b;
        for (FirebaseAuth.b bVar : list2) {
            bVar.a(this.f1570a);
        }
    }
}
