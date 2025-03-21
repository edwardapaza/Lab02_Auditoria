package j1;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f5492a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f5493b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, String str) {
        this.f5493b = tVar;
        this.f5492a = com.google.android.gms.common.internal.q.e(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        o0.a aVar;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(f1.f.p(this.f5492a));
        if (firebaseAuth.m() != null) {
            Task<com.google.firebase.auth.c0> d5 = firebaseAuth.d(true);
            aVar = t.f5474h;
            aVar.g("Token refreshing started", new Object[0]);
            d5.addOnFailureListener(new v(this));
        }
    }
}
