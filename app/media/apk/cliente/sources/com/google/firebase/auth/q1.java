package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class q1 implements Parcelable.Creator<f0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i5 != 2) {
                m0.b.r(parcel, l5);
            } else {
                str2 = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new f0(str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0[] newArray(int i5) {
        return new f0[i5];
    }
}
