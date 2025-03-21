package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p2 extends j1.q0<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1541a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e f1542b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1543c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p2(FirebaseAuth firebaseAuth, String str, e eVar) {
        this.f1541a = str;
        this.f1542b = eVar;
        this.f1543c = firebaseAuth;
    }

    @Override // j1.q0
    public final Task<Void> d(String str) {
        String str2;
        StringBuilder sb;
        zzaag zzaagVar;
        f1.f fVar;
        String str3;
        if (TextUtils.isEmpty(str)) {
            String str4 = this.f1541a;
            sb = new StringBuilder("Password reset request ");
            sb.append(str4);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.f1541a;
            sb = new StringBuilder("Got reCAPTCHA token for password reset of email ");
        }
        sb.append(str2);
        Log.i("FirebaseAuth", sb.toString());
        zzaagVar = this.f1543c.f1385e;
        fVar = this.f1543c.f1381a;
        String str5 = this.f1541a;
        e eVar = this.f1542b;
        str3 = this.f1543c.f1391k;
        return zzaagVar.zza(fVar, str5, eVar, str3, str);
    }
}
