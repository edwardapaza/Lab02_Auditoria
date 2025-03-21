package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.j;
/* loaded from: classes.dex */
public final class m0 extends m0.a {
    public static final Parcelable.Creator<m0> CREATOR = new n0();

    /* renamed from: a  reason: collision with root package name */
    final int f1165a;

    /* renamed from: b  reason: collision with root package name */
    final IBinder f1166b;

    /* renamed from: c  reason: collision with root package name */
    private final l0.a f1167c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1168d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1169e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(int i5, IBinder iBinder, l0.a aVar, boolean z4, boolean z5) {
        this.f1165a = i5;
        this.f1166b = iBinder;
        this.f1167c = aVar;
        this.f1168d = z4;
        this.f1169e = z5;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            return this.f1167c.equals(m0Var.f1167c) && p.a(u(), m0Var.u());
        }
        return false;
    }

    public final l0.a t() {
        return this.f1167c;
    }

    public final j u() {
        IBinder iBinder = this.f1166b;
        if (iBinder == null) {
            return null;
        }
        return j.a.a(iBinder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f1165a);
        m0.c.f(parcel, 2, this.f1166b, false);
        m0.c.k(parcel, 3, this.f1167c, i5, false);
        m0.c.c(parcel, 4, this.f1168d);
        m0.c.c(parcel, 5, this.f1169e);
        m0.c.b(parcel, a5);
    }
}
