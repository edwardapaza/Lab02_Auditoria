package j1;

import com.google.android.gms.tasks.OnFailureListener;
/* loaded from: classes.dex */
final class v implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ w f5488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar) {
        this.f5488a = wVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        o0.a aVar;
        if (exc instanceof f1.m) {
            aVar = t.f5474h;
            aVar.g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f5488a.f5493b.d();
        }
    }
}
