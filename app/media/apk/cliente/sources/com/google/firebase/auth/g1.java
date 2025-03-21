package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g1 implements j1.x, j1.q1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(FirebaseAuth firebaseAuth) {
        this.f1457a = firebaseAuth;
    }

    @Override // j1.q1
    public final void a(zzafm zzafmVar, a0 a0Var) {
        this.f1457a.i0(a0Var, zzafmVar, true, true);
    }

    @Override // j1.x
    public final void zza(Status status) {
        int u5 = status.u();
        if (u5 == 17011 || u5 == 17021 || u5 == 17005) {
            this.f1457a.F();
        }
    }
}
