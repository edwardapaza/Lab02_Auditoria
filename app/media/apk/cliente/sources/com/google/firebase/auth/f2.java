package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzags;
/* loaded from: classes.dex */
public final class f2 implements Parcelable.Creator<d2> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d2 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzags zzagsVar = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
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
                    zzagsVar = (zzags) m0.b.c(parcel, l5, zzags.CREATOR);
                    break;
                case 5:
                    str4 = m0.b.d(parcel, l5);
                    break;
                case 6:
                    str5 = m0.b.d(parcel, l5);
                    break;
                case 7:
                    str6 = m0.b.d(parcel, l5);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new d2(str, str2, str3, zzagsVar, str4, str5, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d2[] newArray(int i5) {
        return new d2[i5];
    }
}
