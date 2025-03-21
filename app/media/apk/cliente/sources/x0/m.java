package x0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m0;
/* loaded from: classes.dex */
public final class m implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ l createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        l0.a aVar = null;
        m0 m0Var = null;
        int i5 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 == 2) {
                aVar = (l0.a) m0.b.c(parcel, l5, l0.a.CREATOR);
            } else if (i6 != 3) {
                m0.b.r(parcel, l5);
            } else {
                m0Var = (m0) m0.b.c(parcel, l5, m0.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new l(i5, aVar, m0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i5) {
        return new l[i5];
    }
}
