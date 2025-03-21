package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import i2.a0;
import i2.d0;
import java.util.ArrayList;
import m0.b;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int s5 = b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j5 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = b.l(parcel);
            switch (b.i(l5)) {
                case 1:
                    i5 = b.n(parcel, l5);
                    break;
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
                    uri = (Uri) b.c(parcel, l5, Uri.CREATOR);
                    break;
                case 7:
                    str5 = b.d(parcel, l5);
                    break;
                case 8:
                    j5 = b.o(parcel, l5);
                    break;
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    str6 = b.d(parcel, l5);
                    break;
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    arrayList = b.g(parcel, l5, Scope.CREATOR);
                    break;
                case 11:
                    str7 = b.d(parcel, l5);
                    break;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    str8 = b.d(parcel, l5);
                    break;
                default:
                    b.r(parcel, l5);
                    break;
            }
        }
        b.h(parcel, s5);
        return new GoogleSignInAccount(i5, str, str2, str3, str4, uri, str5, j5, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i5) {
        return new GoogleSignInAccount[i5];
    }
}
