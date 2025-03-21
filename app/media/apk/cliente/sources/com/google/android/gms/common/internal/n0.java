package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class n0 implements Parcelable.Creator<m0> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ m0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        IBinder iBinder = null;
        l0.a aVar = null;
        int i5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 == 2) {
                iBinder = m0.b.m(parcel, l5);
            } else if (i6 == 3) {
                aVar = (l0.a) m0.b.c(parcel, l5, l0.a.CREATOR);
            } else if (i6 == 4) {
                z4 = m0.b.j(parcel, l5);
            } else if (i6 != 5) {
                m0.b.r(parcel, l5);
            } else {
                z5 = m0.b.j(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new m0(i5, iBinder, aVar, z4, z5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m0[] newArray(int i5) {
        return new m0[i5];
    }
}
