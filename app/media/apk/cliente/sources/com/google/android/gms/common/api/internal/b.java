package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
/* loaded from: classes.dex */
public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final int f914a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f915b;

    /* renamed from: c  reason: collision with root package name */
    private final O f916c;

    /* renamed from: d  reason: collision with root package name */
    private final String f917d;

    private b(com.google.android.gms.common.api.a<O> aVar, O o5, String str) {
        this.f915b = aVar;
        this.f916c = o5;
        this.f917d = str;
        this.f914a = com.google.android.gms.common.internal.p.b(aVar, o5, str);
    }

    public static <O extends a.d> b<O> a(com.google.android.gms.common.api.a<O> aVar, O o5, String str) {
        return new b<>(aVar, o5, str);
    }

    public final String b() {
        return this.f915b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return com.google.android.gms.common.internal.p.a(this.f915b, bVar.f915b) && com.google.android.gms.common.internal.p.a(this.f916c, bVar.f916c) && com.google.android.gms.common.internal.p.a(this.f917d, bVar.f917d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f914a;
    }
}
