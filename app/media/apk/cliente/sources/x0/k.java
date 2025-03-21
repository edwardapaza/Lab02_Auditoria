package x0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.k0;
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ j createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        int i5 = 0;
        k0 k0Var = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 != 2) {
                m0.b.r(parcel, l5);
            } else {
                k0Var = (k0) m0.b.c(parcel, l5, k0.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new j(i5, k0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i5) {
        return new j[i5];
    }
}
