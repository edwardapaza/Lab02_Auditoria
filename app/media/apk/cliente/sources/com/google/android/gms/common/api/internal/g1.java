package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
public final class g1 extends c1<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final j.a<?> f968c;

    public g1(j.a<?> aVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f968c = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final /* bridge */ /* synthetic */ void d(w wVar, boolean z4) {
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final boolean f(g0<?> g0Var) {
        if (g0Var.x().get(this.f968c) == null) {
            return false;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final l0.c[] g(g0<?> g0Var) {
        if (g0Var.x().get(this.f968c) == null) {
            return null;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.c1
    public final void h(g0<?> g0Var) {
        if (g0Var.x().remove(this.f968c) == null) {
            this.f925b.trySetResult(Boolean.FALSE);
        } else {
            g0Var.v();
            throw null;
        }
    }
}
