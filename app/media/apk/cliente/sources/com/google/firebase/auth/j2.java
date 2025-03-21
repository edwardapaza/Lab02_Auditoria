package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j2 implements OnCompleteListener<j1.o1> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p0 f1479a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f1480b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1481c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j2(FirebaseAuth firebaseAuth, p0 p0Var, String str) {
        this.f1479a = p0Var;
        this.f1480b = str;
        this.f1481c = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<j1.o1> task) {
        String a5;
        String str = null;
        if (task.isSuccessful()) {
            str = task.getResult().c();
            a5 = task.getResult().a();
        } else {
            Exception exception = task.getException();
            Log.e("FirebaseAuth", "Error while validating application identity: " + (exception != null ? exception.getMessage() : ""));
            if (exception != null && j1.d0.h(exception)) {
                FirebaseAuth.l0((f1.l) exception, this.f1479a, this.f1480b);
                return;
            } else {
                Log.e("FirebaseAuth", "Proceeding without any application identifier.");
                a5 = null;
            }
        }
        this.f1481c.k0(this.f1479a, str, a5);
    }
}
