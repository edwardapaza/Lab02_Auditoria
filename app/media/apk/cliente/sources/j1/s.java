package j1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class s implements Parcelable.Creator<p> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        i iVar = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i5 == 2) {
                str2 = m0.b.d(parcel, l5);
            } else if (i5 == 3) {
                arrayList = m0.b.g(parcel, l5, com.google.firebase.auth.t0.CREATOR);
            } else if (i5 == 4) {
                arrayList2 = m0.b.g(parcel, l5, com.google.firebase.auth.z0.CREATOR);
            } else if (i5 != 5) {
                m0.b.r(parcel, l5);
            } else {
                iVar = (i) m0.b.c(parcel, l5, i.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new p(str, str2, arrayList, arrayList2, iVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p[] newArray(int i5) {
        return new p[i5];
    }
}
