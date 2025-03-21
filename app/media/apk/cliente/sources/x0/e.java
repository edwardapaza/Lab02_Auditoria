package x0;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;
import i2.d0;
/* loaded from: classes.dex */
public abstract class e extends zab implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i5, Parcel parcel, Parcel parcel2, int i6) {
        switch (i5) {
            case 3:
                l0.a aVar = (l0.a) zac.zaa(parcel, l0.a.CREATOR);
                b bVar = (b) zac.zaa(parcel, b.CREATOR);
                break;
            case 4:
            case 6:
                Status status = (Status) zac.zaa(parcel, Status.CREATOR);
                break;
            case 5:
            default:
                return false;
            case 7:
                Status status2 = (Status) zac.zaa(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) zac.zaa(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                j((l) zac.zaa(parcel, l.CREATOR));
                break;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                h hVar = (h) zac.zaa(parcel, h.CREATOR);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
