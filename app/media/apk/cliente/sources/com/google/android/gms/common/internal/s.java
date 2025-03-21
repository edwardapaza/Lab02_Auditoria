package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class s extends m0.a {
    public static final Parcelable.Creator<s> CREATOR = new u0();

    /* renamed from: a  reason: collision with root package name */
    private final int f1194a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1195b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1196c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1197d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1198e;

    public s(int i5, boolean z4, boolean z5, int i6, int i7) {
        this.f1194a = i5;
        this.f1195b = z4;
        this.f1196c = z5;
        this.f1197d = i6;
        this.f1198e = i7;
    }

    public int t() {
        return this.f1197d;
    }

    public int u() {
        return this.f1198e;
    }

    public boolean v() {
        return this.f1195b;
    }

    public boolean w() {
        return this.f1196c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, x());
        m0.c.c(parcel, 2, v());
        m0.c.c(parcel, 3, w());
        m0.c.g(parcel, 4, t());
        m0.c.g(parcel, 5, u());
        m0.c.b(parcel, a5);
    }

    public int x() {
        return this.f1194a;
    }
}
