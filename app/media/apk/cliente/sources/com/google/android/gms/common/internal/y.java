package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator<u> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ u createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        int i5 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 != 2) {
                m0.b.r(parcel, l5);
            } else {
                arrayList = m0.b.g(parcel, l5, o.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new u(i5, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u[] newArray(int i5) {
        return new u[i5];
    }
}
