package com.google.android.gms.common.api.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final b<?> f971a;

    /* renamed from: b  reason: collision with root package name */
    private final l0.c f972b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i0(b bVar, l0.c cVar, h0 h0Var) {
        this.f971a = bVar;
        this.f972b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof i0)) {
            i0 i0Var = (i0) obj;
            if (com.google.android.gms.common.internal.p.a(this.f971a, i0Var.f971a) && com.google.android.gms.common.internal.p.a(this.f972b, i0Var.f972b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.f971a, this.f972b);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.p.c(this).a("key", this.f971a).a("feature", this.f972b).toString();
    }
}
