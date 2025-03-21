package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i1 extends j1.q0<i> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1462a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f1463b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ a0 f1464c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f1465d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f1466e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1467f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(FirebaseAuth firebaseAuth, String str, boolean z4, a0 a0Var, String str2, String str3) {
        this.f1462a = str;
        this.f1463b = z4;
        this.f1464c = a0Var;
        this.f1465d = str2;
        this.f1466e = str3;
        this.f1467f = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.auth.FirebaseAuth$c, j1.e1] */
    @Override // j1.q0
    public final Task<i> d(String str) {
        String str2;
        StringBuilder sb;
        zzaag zzaagVar;
        f1.f fVar;
        zzaag zzaagVar2;
        f1.f fVar2;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.f1462a;
            sb = new StringBuilder("Logging in as ");
            sb.append(str3);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.f1462a;
            sb = new StringBuilder("Got reCAPTCHA token for login with email ");
        }
        sb.append(str2);
        Log.i("FirebaseAuth", sb.toString());
        if (this.f1463b) {
            zzaagVar2 = this.f1467f.f1385e;
            fVar2 = this.f1467f.f1381a;
            return zzaagVar2.zzb(fVar2, (a0) com.google.android.gms.common.internal.q.k(this.f1464c), this.f1462a, this.f1465d, this.f1466e, str, new FirebaseAuth.c());
        }
        zzaagVar = this.f1467f.f1385e;
        fVar = this.f1467f.f1381a;
        return zzaagVar.zzb(fVar, this.f1462a, this.f1465d, this.f1466e, str, new FirebaseAuth.d());
    }
}
