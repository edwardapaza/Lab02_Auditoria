package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class h2 implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            if (m0.b.i(l5) != 1) {
                m0.b.r(parcel, l5);
            } else {
                str = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new l(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i5) {
        return new l[i5];
    }
}
