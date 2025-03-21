package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzagq;
/* loaded from: classes.dex */
public final class y1 implements Parcelable.Creator<z0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        zzagq zzagqVar = null;
        long j5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i5 == 2) {
                str2 = m0.b.d(parcel, l5);
            } else if (i5 == 3) {
                j5 = m0.b.o(parcel, l5);
            } else if (i5 != 4) {
                m0.b.r(parcel, l5);
            } else {
                zzagqVar = (zzagq) m0.b.c(parcel, l5, zzagq.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new z0(str, str2, j5, zzagqVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z0[] newArray(int i5) {
        return new z0[i5];
    }
}
