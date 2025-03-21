package j1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseauthapi.zzafm;
import com.google.android.gms.internal.p001firebaseauthapi.zzafp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h implements Parcelable.Creator<i> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        zzafm zzafmVar = null;
        e eVar = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Boolean bool = null;
        k kVar = null;
        com.google.firebase.auth.d2 d2Var = null;
        m0 m0Var = null;
        ArrayList arrayList3 = null;
        boolean z4 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    zzafmVar = (zzafm) m0.b.c(parcel, l5, zzafm.CREATOR);
                    break;
                case 2:
                    eVar = (e) m0.b.c(parcel, l5, e.CREATOR);
                    break;
                case 3:
                    str = m0.b.d(parcel, l5);
                    break;
                case 4:
                    str2 = m0.b.d(parcel, l5);
                    break;
                case 5:
                    arrayList = m0.b.g(parcel, l5, e.CREATOR);
                    break;
                case 6:
                    arrayList2 = m0.b.e(parcel, l5);
                    break;
                case 7:
                    str3 = m0.b.d(parcel, l5);
                    break;
                case 8:
                    bool = m0.b.k(parcel, l5);
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    kVar = (k) m0.b.c(parcel, l5, k.CREATOR);
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    z4 = m0.b.j(parcel, l5);
                    break;
                case 11:
                    d2Var = (com.google.firebase.auth.d2) m0.b.c(parcel, l5, com.google.firebase.auth.d2.CREATOR);
                    break;
                case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    m0Var = (m0) m0.b.c(parcel, l5, m0.CREATOR);
                    break;
                case 13:
                    arrayList3 = m0.b.g(parcel, l5, zzafp.CREATOR);
                    break;
                default:
                    m0.b.r(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new i(zzafmVar, eVar, str, str2, arrayList, arrayList2, str3, bool, kVar, z4, d2Var, m0Var, arrayList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i[] newArray(int i5) {
        return new i[i5];
    }
}
