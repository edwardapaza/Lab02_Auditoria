package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u2 implements j1.y {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a0 f1560a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1561b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u2(FirebaseAuth firebaseAuth, a0 a0Var) {
        this.f1560a = a0Var;
        this.f1561b = firebaseAuth;
    }

    @Override // j1.y
    public final void zza() {
        a0 a0Var;
        a0 a0Var2;
        a0Var = this.f1561b.f1386f;
        if (a0Var != null) {
            a0Var2 = this.f1561b.f1386f;
            if (a0Var2.a().equalsIgnoreCase(this.f1560a.a())) {
                this.f1561b.I0();
            }
        }
    }

    @Override // j1.x
    public final void zza(Status status) {
        if (status.u() == 17011 || status.u() == 17021 || status.u() == 17005) {
            this.f1561b.F();
        }
    }
}
