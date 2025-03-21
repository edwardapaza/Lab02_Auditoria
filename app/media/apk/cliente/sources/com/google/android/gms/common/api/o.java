package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        l0.a aVar = null;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 == 2) {
                str = m0.b.d(parcel, l5);
            } else if (i6 == 3) {
                pendingIntent = (PendingIntent) m0.b.c(parcel, l5, PendingIntent.CREATOR);
            } else if (i6 != 4) {
                m0.b.r(parcel, l5);
            } else {
                aVar = (l0.a) m0.b.c(parcel, l5, l0.a.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new Status(i5, str, pendingIntent, aVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new Status[i5];
    }
}
