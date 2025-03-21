package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j0 implements Parcelable.Creator<o> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ o createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        long j5 = 0;
        long j6 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    i5 = m0.b.n(parcel, l5);
                    break;
                case 2:
                    i6 = m0.b.n(parcel, l5);
                    break;
                case 3:
                    i7 = m0.b.n(parcel, l5);
                    break;
                case 4:
                    j5 = m0.b.o(parcel, l5);
                    break;
                case 5:
                    j6 = m0.b.o(parcel, l5);
                    break;
                case 6:
                    str = m0.b.d(parcel, l5);
                    break;
                case 7:
                    str2 = m0.b.d(parcel, l5);
                    break;
                case 8:
                    i8 = m0.b.n(parcel, l5);
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    i9 = m0.b.n(parcel, l5);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new o(i5, i6, i7, j5, j6, str, str2, i8, i9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o[] newArray(int i5) {
        return new o[i5];
    }
}
