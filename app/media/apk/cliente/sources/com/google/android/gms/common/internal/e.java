package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class e extends m0.a {
    public static final Parcelable.Creator<e> CREATOR = new d1();

    /* renamed from: a  reason: collision with root package name */
    private final s f1104a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1105b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1106c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f1107d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1108e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1109f;

    public e(s sVar, boolean z4, boolean z5, int[] iArr, int i5, int[] iArr2) {
        this.f1104a = sVar;
        this.f1105b = z4;
        this.f1106c = z5;
        this.f1107d = iArr;
        this.f1108e = i5;
        this.f1109f = iArr2;
    }

    public int t() {
        return this.f1108e;
    }

    public int[] u() {
        return this.f1107d;
    }

    public int[] v() {
        return this.f1109f;
    }

    public boolean w() {
        return this.f1105b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.k(parcel, 1, this.f1104a, i5, false);
        m0.c.c(parcel, 2, w());
        m0.c.c(parcel, 3, x());
        m0.c.h(parcel, 4, u(), false);
        m0.c.g(parcel, 5, t());
        m0.c.h(parcel, 6, v(), false);
        m0.c.b(parcel, a5);
    }

    public boolean x() {
        return this.f1106c;
    }

    public final s y() {
        return this.f1104a;
    }
}
