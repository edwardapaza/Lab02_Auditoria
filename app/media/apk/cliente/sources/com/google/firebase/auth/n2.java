package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n2 extends j1.q0<i> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a0 f1507a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j f1508b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1509c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2(FirebaseAuth firebaseAuth, a0 a0Var, j jVar) {
        this.f1507a = a0Var;
        this.f1508b = jVar;
        this.f1509c = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    @Override // j1.q0
    public final Task<i> d(String str) {
        zzaag zzaagVar;
        f1.f fVar;
        Log.i("FirebaseAuth", TextUtils.isEmpty(str) ? "Linking email account with empty reCAPTCHA token" : "Got reCAPTCHA token for linking email account");
        zzaagVar = this.f1509c.f1385e;
        fVar = this.f1509c.f1381a;
        return zzaagVar.zza(fVar, this.f1507a, (h) this.f1508b, str, (j1.e1) new FirebaseAuth.c());
    }
}
