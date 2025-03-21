package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class g2 implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j createFromParcel(Parcel parcel) {
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
            } else if (i5 == 3) {
                str3 = m0.b.d(parcel, l5);
            } else if (i5 == 4) {
                str4 = m0.b.d(parcel, l5);
            } else if (i5 != 5) {
                m0.b.r(parcel, l5);
            } else {
                z4 = m0.b.j(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new j(str, str2, str3, str4, z4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i5) {
        return new j[i5];
    }
}
