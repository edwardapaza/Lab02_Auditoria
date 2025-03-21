package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        Bundle bundle = null;
        l0.c[] cVarArr = null;
        e eVar = null;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                bundle = m0.b.a(parcel, l5);
            } else if (i6 == 2) {
                cVarArr = (l0.c[]) m0.b.f(parcel, l5, l0.c.CREATOR);
            } else if (i6 == 3) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 != 4) {
                m0.b.r(parcel, l5);
            } else {
                eVar = (e) m0.b.c(parcel, l5, e.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new b1(bundle, cVarArr, i5, eVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new b1[i5];
    }
}
