package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import m0.b;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafl implements Parcelable.Creator<zzafm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafm createFromParcel(Parcel parcel) {
        int s5 = b.s(parcel);
        String str = null;
        String str2 = null;
        Long l5 = null;
        String str3 = null;
        Long l6 = null;
        while (parcel.dataPosition() < s5) {
            int l7 = b.l(parcel);
            int i5 = b.i(l7);
            if (i5 == 2) {
                str = b.d(parcel, l7);
            } else if (i5 == 3) {
                str2 = b.d(parcel, l7);
            } else if (i5 == 4) {
                l5 = b.p(parcel, l7);
            } else if (i5 == 5) {
                str3 = b.d(parcel, l7);
            } else if (i5 != 6) {
                b.r(parcel, l7);
            } else {
                l6 = b.p(parcel, l7);
            }
        }
        b.h(parcel, s5);
        return new zzafm(str, str2, l5, str3, l6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafm[] newArray(int i5) {
        return new zzafm[i5];
    }
}
