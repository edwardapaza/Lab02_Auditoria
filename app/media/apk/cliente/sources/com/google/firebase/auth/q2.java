package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q2 extends j1.q0<i> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1545a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f1546b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1547c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(FirebaseAuth firebaseAuth, String str, String str2) {
        this.f1545a = str;
        this.f1546b = str2;
        this.f1547c = firebaseAuth;
    }

    @Override // j1.q0
    public final Task<i> d(String str) {
        String str2;
        StringBuilder sb;
        zzaag zzaagVar;
        f1.f fVar;
        String str3;
        if (TextUtils.isEmpty(str)) {
            String str4 = this.f1545a;
            sb = new StringBuilder("Creating user with ");
            sb.append(str4);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.f1545a;
            sb = new StringBuilder("Got reCAPTCHA token for sign up with email ");
        }
        sb.append(str2);
        Log.i("FirebaseAuth", sb.toString());
        zzaagVar = this.f1547c.f1385e;
        fVar = this.f1547c.f1381a;
        String str5 = this.f1545a;
        String str6 = this.f1546b;
        str3 = this.f1547c.f1391k;
        return zzaagVar.zza(fVar, str5, str6, str3, str, new FirebaseAuth.d());
    }
}
