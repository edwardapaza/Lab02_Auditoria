package x0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<h> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ h createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i5 = m0.b.i(l5);
            if (i5 == 1) {
                arrayList = m0.b.e(parcel, l5);
            } else if (i5 != 2) {
                m0.b.r(parcel, l5);
            } else {
                str = m0.b.d(parcel, l5);
            }
        }
        m0.b.h(parcel, s5);
        return new h(arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i5) {
        return new h[i5];
    }
}
