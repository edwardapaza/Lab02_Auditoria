package j1;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<e> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z4 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    str = m0.b.d(parcel, l5);
                    break;
                case 2:
                    str2 = m0.b.d(parcel, l5);
                    break;
                case 3:
                    str5 = m0.b.d(parcel, l5);
                    break;
                case 4:
                    str4 = m0.b.d(parcel, l5);
                    break;
                case 5:
                    str3 = m0.b.d(parcel, l5);
                    break;
                case 6:
                    str6 = m0.b.d(parcel, l5);
                    break;
                case 7:
                    z4 = m0.b.j(parcel, l5);
                    break;
                case 8:
                    str7 = m0.b.d(parcel, l5);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new e(str, str2, str3, str4, str5, str6, z4, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i5) {
        return new e[i5];
    }
}
