package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class w1 implements Parcelable.Creator<t0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i5 == 2) {
                str2 = m0.b.d(parcel, l5);
            } else if (i5 == 3) {
                j5 = m0.b.o(parcel, l5);
            } else if (i5 != 4) {
                m0.b.r(parcel, l5);
            } else {
                str3 = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new t0(str, str2, j5, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t0[] newArray(int i5) {
        return new t0[i5];
    }
}
