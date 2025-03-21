package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c2 implements Parcelable.Creator<e> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z4 = false;
        boolean z5 = false;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    str = m0.b.d(parcel, l5);
                    break;
                case 2:
                    str2 = m0.b.d(parcel, l5);
                    break;
                case 3:
                    str3 = m0.b.d(parcel, l5);
                    break;
                case 4:
                    str4 = m0.b.d(parcel, l5);
                    break;
                case 5:
                    z4 = m0.b.j(parcel, l5);
                    break;
                case 6:
                    str5 = m0.b.d(parcel, l5);
                    break;
                case 7:
                    z5 = m0.b.j(parcel, l5);
                    break;
                case 8:
                    str6 = m0.b.d(parcel, l5);
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    i5 = m0.b.n(parcel, l5);
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    str7 = m0.b.d(parcel, l5);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new e(str, str2, str3, str4, z4, str5, z5, str6, i5, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i5) {
        return new e[i5];
    }
}
