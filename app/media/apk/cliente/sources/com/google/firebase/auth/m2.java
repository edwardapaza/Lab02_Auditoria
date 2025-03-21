package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p001firebaseauthapi.zzaag;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.q0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m2 implements OnCompleteListener<j1.o1> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p0 f1493a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f1494b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1495c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(FirebaseAuth firebaseAuth, p0 p0Var, String str) {
        this.f1493a = p0Var;
        this.f1494b = str;
        this.f1495c = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<j1.o1> task) {
        String a5;
        String str;
        q0.b d02;
        zzaag zzaagVar;
        String str2;
        zzaag zzaagVar2;
        String str3;
        if (task.isSuccessful()) {
            String c5 = task.getResult().c();
            a5 = task.getResult().a();
            str = c5;
        } else {
            String str4 = "Error while validating application identity: ";
            Exception exception = task.getException();
            if (exception != null) {
                str4 = "Error while validating application identity: " + exception.getMessage();
            }
            Log.e("FirebaseAuth", str4);
            if (exception != null && j1.d0.h(exception)) {
                FirebaseAuth.l0((f1.l) exception, this.f1493a, this.f1494b);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str = null;
            a5 = null;
        }
        long longValue = this.f1493a.h().longValue();
        d02 = this.f1495c.d0(this.f1493a.i(), this.f1493a.f());
        if (TextUtils.isEmpty(str)) {
            d02 = this.f1495c.c0(this.f1493a, d02);
        }
        q0.b bVar = d02;
        j1.p pVar = (j1.p) com.google.android.gms.common.internal.q.k(this.f1493a.d());
        if (pVar.x()) {
            zzaagVar2 = this.f1495c.f1385e;
            String str5 = (String) com.google.android.gms.common.internal.q.k(this.f1493a.i());
            str3 = this.f1495c.f1389i;
            zzaagVar2.zza(pVar, str5, str3, longValue, this.f1493a.e() != null, this.f1493a.l(), str, a5, this.f1495c.K0(), bVar, this.f1493a.j(), this.f1493a.a());
            return;
        }
        zzaagVar = this.f1495c.f1385e;
        t0 t0Var = (t0) com.google.android.gms.common.internal.q.k(this.f1493a.g());
        str2 = this.f1495c.f1389i;
        zzaagVar.zza(pVar, t0Var, str2, longValue, this.f1493a.e() != null, this.f1493a.l(), str, a5, this.f1495c.K0(), bVar, this.f1493a.j(), this.f1493a.a());
    }
}
