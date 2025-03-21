package j1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class p0 implements Parcelable.Creator<m0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                arrayList = m0.b.g(parcel, l5, com.google.firebase.auth.t0.CREATOR);
            } else if (i5 != 2) {
                m0.b.r(parcel, l5);
            } else {
                arrayList2 = m0.b.g(parcel, l5, com.google.firebase.auth.z0.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new m0(arrayList, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m0[] newArray(int i5) {
        return new m0[i5];
    }
}
