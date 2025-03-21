package l0;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        long j5 = -1;
        int i5 = 0;
        String str = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i6 = m0.b.i(l5);
            if (i6 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i6 == 2) {
                i5 = m0.b.n(parcel, l5);
            } else if (i6 != 3) {
                m0.b.r(parcel, l5);
            } else {
                j5 = m0.b.o(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new c(str, i5, j5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new c[i5];
    }
}
