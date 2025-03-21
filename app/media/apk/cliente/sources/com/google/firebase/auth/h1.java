package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h1 extends j1.q0<i> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f1458a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a0 f1459b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ j f1460c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1461d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(FirebaseAuth firebaseAuth, boolean z4, a0 a0Var, j jVar) {
        this.f1458a = z4;
        this.f1459b = a0Var;
        this.f1460c = jVar;
        this.f1461d = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    @Override // j1.q0
    public final Task<i> d(String str) {
        zzaag zzaagVar;
        f1.f fVar;
        zzaag zzaagVar2;
        f1.f fVar2;
        Log.i("FirebaseAuth", TextUtils.isEmpty(str) ? "Email link login/reauth with empty reCAPTCHA token" : "Got reCAPTCHA token for login/reauth with email link");
        if (this.f1458a) {
            zzaagVar2 = this.f1461d.f1385e;
            fVar2 = this.f1461d.f1381a;
            return zzaagVar2.zzb(fVar2, (a0) com.google.android.gms.common.internal.q.k(this.f1459b), this.f1460c, str, (j1.e1) new FirebaseAuth.c());
        }
        zzaagVar = this.f1461d.f1385e;
        fVar = this.f1461d.f1381a;
        return zzaagVar.zza(fVar, this.f1460c, str, (j1.q1) new FirebaseAuth.d());
    }
}
