package j1;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        long j5 = 0;
        long j6 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                j5 = m0.b.o(parcel, l5);
            } else if (i5 != 2) {
                m0.b.r(parcel, l5);
            } else {
                j6 = m0.b.o(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new k(j5, j6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k[] newArray(int i5) {
        return new k[i5];
    }
}
