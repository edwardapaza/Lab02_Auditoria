package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import m0.b;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafs  reason: invalid package */
/* loaded from: classes.dex */
public final class zzafs implements Parcelable.Creator<zzafp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafp createFromParcel(Parcel parcel) {
        int s5 = b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < s5) {
            int l5 = b.l(parcel);
            int i5 = b.i(l5);
            if (i5 == 1) {
                str = b.d(parcel, l5);
            } else if (i5 == 2) {
                str2 = b.d(parcel, l5);
            } else if (i5 != 3) {
                b.r(parcel, l5);
            } else {
                str3 = b.d(parcel, l5);
            }
        }
        b.h(parcel, s5);
        return new zzafp(str, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafp[] newArray(int i5) {
        return new zzafp[i5];
    }
}
