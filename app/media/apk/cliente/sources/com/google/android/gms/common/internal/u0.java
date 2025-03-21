package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        int i5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i8 = m0.b.i(l5);
            if (i8 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i8 == 2) {
                z4 = m0.b.j(parcel, l5);
            } else if (i8 == 3) {
                z5 = m0.b.j(parcel, l5);
            } else if (i8 == 4) {
                i6 = m0.b.n(parcel, l5);
            } else if (i8 != 5) {
                m0.b.r(parcel, l5);
            } else {
                i7 = m0.b.n(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new s(i5, z4, z5, i6, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new s[i5];
    }
}
