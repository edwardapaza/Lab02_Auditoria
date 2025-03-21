package j1;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;
/* loaded from: classes.dex */
public final class m extends com.google.firebase.auth.h0 {

    /* renamed from: a  reason: collision with root package name */
    private final i f5441a;

    public m(i iVar) {
        com.google.android.gms.common.internal.q.k(iVar);
        this.f5441a = iVar;
    }

    @Override // com.google.firebase.auth.h0
    public final Task<Void> a(com.google.firebase.auth.i0 i0Var, String str) {
        com.google.android.gms.common.internal.q.k(i0Var);
        i iVar = this.f5441a;
        return FirebaseAuth.getInstance(iVar.P()).Q(iVar, i0Var, str);
    }

    @Override // com.google.firebase.auth.h0
    public final List<com.google.firebase.auth.j0> b() {
        return this.f5441a.b0();
    }

    @Override // com.google.firebase.auth.h0
    public final Task<com.google.firebase.auth.l0> c() {
        return this.f5441a.u(false).continueWithTask(new l(this));
    }

    @Override // com.google.firebase.auth.h0
    public final Task<Void> d(String str) {
        com.google.android.gms.common.internal.q.e(str);
        i iVar = this.f5441a;
        return FirebaseAuth.getInstance(iVar.P()).U(iVar, str);
    }
}
