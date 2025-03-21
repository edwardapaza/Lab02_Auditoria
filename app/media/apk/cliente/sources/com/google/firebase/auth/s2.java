package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s2 extends j1.q0<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1549a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e f1550b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1551c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s2(FirebaseAuth firebaseAuth, String str, e eVar) {
        this.f1549a = str;
        this.f1550b = eVar;
        this.f1551c = firebaseAuth;
    }

    @Override // j1.q0
    public final Task<Void> d(String str) {
        String str2;
        StringBuilder sb;
        zzaag zzaagVar;
        f1.f fVar;
        String str3;
        if (TextUtils.isEmpty(str)) {
            String str4 = this.f1549a;
            sb = new StringBuilder("Email link sign in for ");
            sb.append(str4);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.f1549a;
            sb = new StringBuilder("Got reCAPTCHA token for email link sign in for ");
        }
        sb.append(str2);
        Log.i("FirebaseAuth", sb.toString());
        zzaagVar = this.f1551c.f1385e;
        fVar = this.f1551c.f1381a;
        String str5 = this.f1549a;
        e eVar = this.f1550b;
        str3 = this.f1551c.f1391k;
        return zzaagVar.zzb(fVar, str5, eVar, str3, str);
    }
}
