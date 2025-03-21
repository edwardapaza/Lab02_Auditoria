package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class a2 implements Parcelable.Creator<e1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e1 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        boolean z4 = false;
        String str = null;
        String str2 = null;
        boolean z5 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 2) {
                str = m0.b.d(parcel, l5);
            } else if (i5 == 3) {
                str2 = m0.b.d(parcel, l5);
            } else if (i5 == 4) {
                z4 = m0.b.j(parcel, l5);
            } else if (i5 != 5) {
                m0.b.r(parcel, l5);
            } else {
                z5 = m0.b.j(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new e1(str, str2, z4, z5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e1[] newArray(int i5) {
        return new e1[i5];
    }
}
