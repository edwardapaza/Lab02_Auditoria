package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class u1 implements Parcelable.Creator<o0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z4 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i5 == 2) {
                str2 = m0.b.d(parcel, l5);
            } else if (i5 == 4) {
                str3 = m0.b.d(parcel, l5);
            } else if (i5 == 5) {
                z4 = m0.b.j(parcel, l5);
            } else if (i5 != 6) {
                m0.b.r(parcel, l5);
            } else {
                str4 = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new o0(str, str2, str3, z4, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0[] newArray(int i5) {
        return new o0[i5];
    }
}
