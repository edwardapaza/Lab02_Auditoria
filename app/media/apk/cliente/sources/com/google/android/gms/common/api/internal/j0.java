package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import java.util.Map;
/* loaded from: classes.dex */
final class j0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l0.a f983a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k0 f984b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(k0 k0Var, l0.a aVar) {
        this.f984b = k0Var;
        this.f983a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        a.f fVar4;
        k0 k0Var = this.f984b;
        map = k0Var.f992f.f945l;
        bVar = k0Var.f988b;
        g0 g0Var = (g0) map.get(bVar);
        if (g0Var == null) {
            return;
        }
        if (!this.f983a.x()) {
            g0Var.H(this.f983a, null);
            return;
        }
        this.f984b.f991e = true;
        fVar = this.f984b.f987a;
        if (fVar.requiresSignIn()) {
            this.f984b.h();
            return;
        }
        try {
            k0 k0Var2 = this.f984b;
            fVar3 = k0Var2.f987a;
            fVar4 = k0Var2.f987a;
            fVar3.getRemoteService(null, fVar4.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e5) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e5);
            fVar2 = this.f984b.f987a;
            fVar2.disconnect("Failed to get service from broker.");
            g0Var.H(new l0.a(10), null);
        }
    }
}
