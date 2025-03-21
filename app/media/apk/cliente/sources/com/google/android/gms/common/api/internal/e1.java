package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
/* loaded from: classes.dex */
public final class e1<A extends d<? extends com.google.android.gms.common.api.j, a.b>> extends h1 {

    /* renamed from: b  reason: collision with root package name */
    protected final A f929b;

    public e1(int i5, A a5) {
        super(i5);
        this.f929b = (A) com.google.android.gms.common.internal.q.l(a5, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void a(Status status) {
        try {
            this.f929b.o(status);
        } catch (IllegalStateException e5) {
            Log.w("ApiCallRunner", "Exception reporting failure", e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void b(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        try {
            this.f929b.o(new Status(10, sb.toString()));
        } catch (IllegalStateException e5) {
            Log.w("ApiCallRunner", "Exception reporting failure", e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void c(g0<?> g0Var) {
        try {
            this.f929b.m(g0Var.v());
        } catch (RuntimeException e5) {
            b(e5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.h1
    public final void d(w wVar, boolean z4) {
        wVar.c(this.f929b, z4);
    }
}
