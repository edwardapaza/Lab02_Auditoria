package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
import com.google.android.gms.tasks.Task;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a0 extends m0.a implements d1 {
    public Task<i> A(h hVar) {
        com.google.android.gms.common.internal.q.k(hVar);
        return FirebaseAuth.getInstance(P()).P(this, hVar);
    }

    public Task<i> B(h hVar) {
        com.google.android.gms.common.internal.q.k(hVar);
        return FirebaseAuth.getInstance(P()).w0(this, hVar);
    }

    public Task<Void> C() {
        return FirebaseAuth.getInstance(P()).o0(this);
    }

    public Task<Void> D() {
        return FirebaseAuth.getInstance(P()).V(this, false).continueWithTask(new m1(this));
    }

    public Task<Void> E(e eVar) {
        return FirebaseAuth.getInstance(P()).V(this, false).continueWithTask(new o1(this, eVar));
    }

    public Task<i> F(Activity activity, n nVar) {
        com.google.android.gms.common.internal.q.k(activity);
        com.google.android.gms.common.internal.q.k(nVar);
        return FirebaseAuth.getInstance(P()).L(activity, nVar, this);
    }

    public Task<i> G(Activity activity, n nVar) {
        com.google.android.gms.common.internal.q.k(activity);
        com.google.android.gms.common.internal.q.k(nVar);
        return FirebaseAuth.getInstance(P()).n0(activity, nVar, this);
    }

    public Task<i> H(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return FirebaseAuth.getInstance(P()).p0(this, str);
    }

    @Deprecated
    public Task<Void> I(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return FirebaseAuth.getInstance(P()).x0(this, str);
    }

    public Task<Void> J(String str) {
        com.google.android.gms.common.internal.q.e(str);
        return FirebaseAuth.getInstance(P()).z0(this, str);
    }

    public Task<Void> K(o0 o0Var) {
        return FirebaseAuth.getInstance(P()).R(this, o0Var);
    }

    public Task<Void> L(e1 e1Var) {
        com.google.android.gms.common.internal.q.k(e1Var);
        return FirebaseAuth.getInstance(P()).S(this, e1Var);
    }

    public Task<Void> M(String str) {
        return N(str, null);
    }

    public Task<Void> N(String str, e eVar) {
        return FirebaseAuth.getInstance(P()).V(this, false).continueWithTask(new n1(this, str, eVar));
    }

    public abstract a0 O(List<? extends d1> list);

    public abstract f1.f P();

    public abstract void Q(zzafm zzafmVar);

    public abstract a0 R();

    public abstract void S(List<j0> list);

    public abstract zzafm T();

    public abstract List<String> U();

    @Override // com.google.firebase.auth.d1
    public abstract String a();

    @Override // com.google.firebase.auth.d1
    public abstract Uri b();

    @Override // com.google.firebase.auth.d1
    public abstract String j();

    @Override // com.google.firebase.auth.d1
    public abstract String n();

    @Override // com.google.firebase.auth.d1
    public abstract String q();

    public Task<Void> t() {
        return FirebaseAuth.getInstance(P()).O(this);
    }

    public Task<c0> u(boolean z4) {
        return FirebaseAuth.getInstance(P()).V(this, z4);
    }

    public abstract b0 v();

    public abstract h0 w();

    public abstract List<? extends d1> x();

    public abstract String y();

    public abstract boolean z();

    public abstract String zzd();

    public abstract String zze();
}
