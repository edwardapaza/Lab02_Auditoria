package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class n implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 != 2) {
                m0.b.r(parcel, l5);
            } else {
                str = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new Scope(i5, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new Scope[i5];
    }
}
