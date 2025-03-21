package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import i2.a0;
import i2.d0;
import m0.b;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagr  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagr implements Parcelable.Creator<zzags> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzags createFromParcel(Parcel parcel) {
        int s5 = b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 2:
                    str = b.d(parcel, l5);
                    break;
                case 3:
                    str2 = b.d(parcel, l5);
                    break;
                case 4:
                    str3 = b.d(parcel, l5);
                    break;
                case 5:
                    str4 = b.d(parcel, l5);
                    break;
                case 6:
                    str5 = b.d(parcel, l5);
                    break;
                case 7:
                    str6 = b.d(parcel, l5);
                    break;
                case 8:
                    str7 = b.d(parcel, l5);
                    break;
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    str8 = b.d(parcel, l5);
                    break;
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    z4 = b.j(parcel, l5);
                    break;
                case 11:
                    z5 = b.j(parcel, l5);
                    break;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    str9 = b.d(parcel, l5);
                    break;
                case 13:
                    str10 = b.d(parcel, l5);
                    break;
                case 14:
                    str11 = b.d(parcel, l5);
                    break;
                case 15:
                    str12 = b.d(parcel, l5);
                    break;
                case 16:
                    z6 = b.j(parcel, l5);
                    break;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    str13 = b.d(parcel, l5);
                    break;
                default:
                    b.r(parcel, l5);
                    break;
            }
        }
        b.h(parcel, s5);
        return new zzags(str, str2, str3, str4, str5, str6, str7, str8, z4, z5, str9, str10, str11, str12, z6, str13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzags[] newArray(int i5) {
        return new zzags[i5];
    }
}
