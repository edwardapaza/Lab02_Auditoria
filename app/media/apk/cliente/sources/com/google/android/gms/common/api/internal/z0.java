package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import java.util.Set;
/* loaded from: classes.dex */
public final class z0 extends x0.d implements f.a, f.b {

    /* renamed from: h  reason: collision with root package name */
    private static final a.AbstractC0036a<? extends w0.f, w0.a> f1068h = w0.e.f8223c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1069a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1070b;

    /* renamed from: c  reason: collision with root package name */
    private final a.AbstractC0036a<? extends w0.f, w0.a> f1071c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Scope> f1072d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.common.internal.d f1073e;

    /* renamed from: f  reason: collision with root package name */
    private w0.f f1074f;

    /* renamed from: g  reason: collision with root package name */
    private y0 f1075g;

    public z0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar) {
        a.AbstractC0036a<? extends w0.f, w0.a> abstractC0036a = f1068h;
        this.f1069a = context;
        this.f1070b = handler;
        this.f1073e = (com.google.android.gms.common.internal.d) com.google.android.gms.common.internal.q.l(dVar, "ClientSettings must not be null");
        this.f1072d = dVar.e();
        this.f1071c = abstractC0036a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void m(z0 z0Var, x0.l lVar) {
        l0.a t5 = lVar.t();
        if (t5.x()) {
            com.google.android.gms.common.internal.m0 m0Var = (com.google.android.gms.common.internal.m0) com.google.android.gms.common.internal.q.k(lVar.u());
            t5 = m0Var.t();
            if (t5.x()) {
                z0Var.f1075g.c(m0Var.u(), z0Var.f1072d);
                z0Var.f1074f.disconnect();
            }
            String valueOf = String.valueOf(t5);
            Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
        }
        z0Var.f1075g.b(t5);
        z0Var.f1074f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.e
    public final void a(int i5) {
        this.f1074f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.m
    public final void b(l0.a aVar) {
        this.f1075g.b(aVar);
    }

    @Override // com.google.android.gms.common.api.internal.e
    public final void f(Bundle bundle) {
        this.f1074f.b(this);
    }

    @Override // x0.f
    public final void j(x0.l lVar) {
        this.f1070b.post(new x0(this, lVar));
    }

    public final void n(y0 y0Var) {
        w0.f fVar = this.f1074f;
        if (fVar != null) {
            fVar.disconnect();
        }
        this.f1073e.i(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0036a<? extends w0.f, w0.a> abstractC0036a = this.f1071c;
        Context context = this.f1069a;
        Looper looper = this.f1070b.getLooper();
        com.google.android.gms.common.internal.d dVar = this.f1073e;
        this.f1074f = abstractC0036a.buildClient(context, looper, dVar, (com.google.android.gms.common.internal.d) dVar.f(), (f.a) this, (f.b) this);
        this.f1075g = y0Var;
        Set<Scope> set = this.f1072d;
        if (set == null || set.isEmpty()) {
            this.f1070b.post(new w0(this));
        } else {
            this.f1074f.a();
        }
    }

    public final void o() {
        w0.f fVar = this.f1074f;
        if (fVar != null) {
            fVar.disconnect();
        }
    }
}
