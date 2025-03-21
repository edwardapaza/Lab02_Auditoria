package l0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        int i5 = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i6 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i7 = m0.b.i(l5);
            if (i7 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i7 == 2) {
                i6 = m0.b.n(parcel, l5);
            } else if (i7 == 3) {
                pendingIntent = (PendingIntent) m0.b.c(parcel, l5, PendingIntent.CREATOR);
            } else if (i7 != 4) {
                m0.b.r(parcel, l5);
            } else {
                str = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new a(i5, i6, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new a[i5];
    }
}
