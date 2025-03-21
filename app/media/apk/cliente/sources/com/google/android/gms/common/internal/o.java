package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class o extends m0.a {
    public static final Parcelable.Creator<o> CREATOR = new j0();

    /* renamed from: a  reason: collision with root package name */
    private final int f1176a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1177b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1178c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1179d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1180e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1181f;

    /* renamed from: k  reason: collision with root package name */
    private final String f1182k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1183l;

    /* renamed from: m  reason: collision with root package name */
    private final int f1184m;

    public o(int i5, int i6, int i7, long j5, long j6, String str, String str2, int i8, int i9) {
        this.f1176a = i5;
        this.f1177b = i6;
        this.f1178c = i7;
        this.f1179d = j5;
        this.f1180e = j6;
        this.f1181f = str;
        this.f1182k = str2;
        this.f1183l = i8;
        this.f1184m = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f1176a);
        m0.c.g(parcel, 2, this.f1177b);
        m0.c.g(parcel, 3, this.f1178c);
        m0.c.i(parcel, 4, this.f1179d);
        m0.c.i(parcel, 5, this.f1180e);
        m0.c.l(parcel, 6, this.f1181f, false);
        m0.c.l(parcel, 7, this.f1182k, false);
        m0.c.g(parcel, 8, this.f1183l);
        m0.c.g(parcel, 9, this.f1184m);
        m0.c.b(parcel, a5);
    }
}
