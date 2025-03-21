package j1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<o> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        ArrayList arrayList = null;
        p pVar = null;
        String str = null;
        com.google.firebase.auth.d2 d2Var = null;
        i iVar = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    arrayList = m0.b.g(parcel, l5, com.google.firebase.auth.t0.CREATOR);
                    break;
                case 2:
                    pVar = (p) m0.b.c(parcel, l5, p.CREATOR);
                    break;
                case 3:
                    str = m0.b.d(parcel, l5);
                    break;
                case 4:
                    d2Var = (com.google.firebase.auth.d2) m0.b.c(parcel, l5, com.google.firebase.auth.d2.CREATOR);
                    break;
                case 5:
                    iVar = (i) m0.b.c(parcel, l5, i.CREATOR);
                    break;
                case 6:
                    arrayList2 = m0.b.g(parcel, l5, com.google.firebase.auth.z0.CREATOR);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new o(arrayList, pVar, str, d2Var, iVar, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o[] newArray(int i5) {
        return new o[i5];
    }
}
