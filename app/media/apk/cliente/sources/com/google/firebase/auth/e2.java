package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.q0;
/* loaded from: classes.dex */
public final class e2 implements Parcelable.Creator<q0.a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q0.a createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            m0.b.i(l5);
            m0.b.r(parcel, l5);
        }
        m0.b.h(parcel, s5);
        return new q0.a();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q0.a[] newArray(int i5) {
        return new q0.a[i5];
    }
}
