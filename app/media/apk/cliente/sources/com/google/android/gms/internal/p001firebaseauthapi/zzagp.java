package com.google.android.gms.internal.p001firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import m0.b;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzagp implements Parcelable.Creator<zzagq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzagq createFromParcel(Parcel parcel) {
        int s5 = b.s(parcel);
        while (parcel.dataPosition() < s5) {
            int l5 = b.l(parcel);
            b.i(l5);
            b.r(parcel, l5);
        }
        b.h(parcel, s5);
        return new zzagq();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzagq[] newArray(int i5) {
        return new zzagq[i5];
    }
}
