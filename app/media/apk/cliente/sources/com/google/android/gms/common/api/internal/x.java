package com.google.android.gms.common.api.internal;

import android.app.Activity;
/* loaded from: classes.dex */
public final class x extends n1 {

    /* renamed from: e  reason: collision with root package name */
    private final androidx.collection.b<b<?>> f1061e;

    /* renamed from: f  reason: collision with root package name */
    private final f f1062f;

    x(i iVar, f fVar, l0.f fVar2) {
        super(iVar, fVar2);
        this.f1061e = new androidx.collection.b<>();
        this.f1062f = fVar;
        this.mLifecycleFragment.b("ConnectionlessLifecycleHelper", this);
    }

    public static void j(Activity activity, f fVar, b<?> bVar) {
        i fragment = LifecycleCallback.getFragment(activity);
        x xVar = (x) fragment.c("ConnectionlessLifecycleHelper", x.class);
        if (xVar == null) {
            xVar = new x(fragment, fVar, l0.f.m());
        }
        com.google.android.gms.common.internal.q.l(bVar, "ApiKey cannot be null");
        xVar.f1061e.add(bVar);
        fVar.c(xVar);
    }

    private final void k() {
        if (this.f1061e.isEmpty()) {
            return;
        }
        this.f1062f.c(this);
    }

    @Override // com.google.android.gms.common.api.internal.n1
    protected final void b(l0.a aVar, int i5) {
        this.f1062f.I(aVar, i5);
    }

    @Override // com.google.android.gms.common.api.internal.n1
    protected final void c() {
        this.f1062f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final androidx.collection.b<b<?>> i() {
        return this.f1061e;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onResume() {
        super.onResume();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.n1, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.n1, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        this.f1062f.d(this);
    }
}
