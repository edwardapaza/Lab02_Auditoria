package x0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ b createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        int i5 = 0;
        Intent intent = null;
        int i6 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i7 = m0.b.i(l5);
            if (i7 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i7 == 2) {
                i6 = m0.b.n(parcel, l5);
            } else if (i7 != 3) {
                m0.b.r(parcel, l5);
            } else {
                intent = (Intent) m0.b.c(parcel, l5, Intent.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new b(i5, i6, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i5) {
        return new b[i5];
    }
}
