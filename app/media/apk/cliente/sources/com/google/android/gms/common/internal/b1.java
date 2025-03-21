package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b1 extends m0.a {
    public static final Parcelable.Creator<b1> CREATOR = new c1();

    /* renamed from: a  reason: collision with root package name */
    Bundle f1079a;

    /* renamed from: b  reason: collision with root package name */
    l0.c[] f1080b;

    /* renamed from: c  reason: collision with root package name */
    int f1081c;

    /* renamed from: d  reason: collision with root package name */
    e f1082d;

    public b1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(Bundle bundle, l0.c[] cVarArr, int i5, e eVar) {
        this.f1079a = bundle;
        this.f1080b = cVarArr;
        this.f1081c = i5;
        this.f1082d = eVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.e(parcel, 1, this.f1079a, false);
        m0.c.n(parcel, 2, this.f1080b, i5, false);
        m0.c.g(parcel, 3, this.f1081c);
        m0.c.k(parcel, 4, this.f1082d, i5, false);
        m0.c.b(parcel, a5);
    }
}
