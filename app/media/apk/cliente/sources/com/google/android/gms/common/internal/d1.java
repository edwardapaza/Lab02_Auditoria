package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        s sVar = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z4 = false;
        boolean z5 = false;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    sVar = (s) m0.b.c(parcel, l5, s.CREATOR);
                    break;
                case 2:
                    z4 = m0.b.j(parcel, l5);
                    break;
                case 3:
                    z5 = m0.b.j(parcel, l5);
                    break;
                case 4:
                    iArr = m0.b.b(parcel, l5);
                    break;
                case 5:
                    i5 = m0.b.n(parcel, l5);
                    break;
                case 6:
                    iArr2 = m0.b.b(parcel, l5);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new e(sVar, z4, z5, iArr, i5, iArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new e[i5];
    }
}
