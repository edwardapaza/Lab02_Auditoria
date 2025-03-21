package j1;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b2 implements Parcelable.Creator<c2> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c2 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        boolean z4 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                str = m0.b.d(parcel, l5);
            } else if (i5 == 2) {
                str2 = m0.b.d(parcel, l5);
            } else if (i5 != 3) {
                m0.b.r(parcel, l5);
            } else {
                z4 = m0.b.j(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new c2(str, str2, z4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c2[] newArray(int i5) {
        return new c2[i5];
    }
}
