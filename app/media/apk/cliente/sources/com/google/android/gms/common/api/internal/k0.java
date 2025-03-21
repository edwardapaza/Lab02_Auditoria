package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k0 implements c.InterfaceC0039c, y0 {

    /* renamed from: a  reason: collision with root package name */
    private final a.f f987a;

    /* renamed from: b  reason: collision with root package name */
    private final b<?> f988b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.gms.common.internal.j f989c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set<Scope> f990d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f991e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ f f992f;

    public k0(f fVar, a.f fVar2, b<?> bVar) {
        this.f992f = fVar;
        this.f987a = fVar2;
        this.f988b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        com.google.android.gms.common.internal.j jVar;
        if (!this.f991e || (jVar = this.f989c) == null) {
            return;
        }
        this.f987a.getRemoteService(jVar, this.f990d);
    }

    @Override // com.google.android.gms.common.internal.c.InterfaceC0039c
    public final void a(l0.a aVar) {
        Handler handler;
        handler = this.f992f.f949p;
        handler.post(new j0(this, aVar));
    }

    @Override // com.google.android.gms.common.api.internal.y0
    public final void b(l0.a aVar) {
        Map map;
        map = this.f992f.f945l;
        g0 g0Var = (g0) map.get(this.f988b);
        if (g0Var != null) {
            g0Var.I(aVar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.y0
    public final void c(com.google.android.gms.common.internal.j jVar, Set<Scope> set) {
        if (jVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new l0.a(4));
            return;
        }
        this.f989c = jVar;
        this.f990d = set;
        h();
    }
}
