package j1;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d2 implements Parcelable.Creator<e2> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e2 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        i iVar = null;
        c2 c2Var = null;
        com.google.firebase.auth.d2 d2Var = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                iVar = (i) m0.b.c(parcel, l5, i.CREATOR);
            } else if (i5 == 2) {
                c2Var = (c2) m0.b.c(parcel, l5, c2.CREATOR);
            } else if (i5 != 3) {
                m0.b.r(parcel, l5);
            } else {
                d2Var = (com.google.firebase.auth.d2) m0.b.c(parcel, l5, com.google.firebase.auth.d2.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new e2(iVar, c2Var, d2Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e2[] newArray(int i5) {
        return new e2[i5];
    }
}
