package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public final class l0 implements Parcelable.Creator<k0> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ k0 createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            int i7 = m0.b.i(l5);
            if (i7 == 1) {
                i5 = m0.b.n(parcel, l5);
            } else if (i7 == 2) {
                account = (Account) m0.b.c(parcel, l5, Account.CREATOR);
            } else if (i7 == 3) {
                i6 = m0.b.n(parcel, l5);
            } else if (i7 != 4) {
                m0.b.r(parcel, l5);
            } else {
                googleSignInAccount = (GoogleSignInAccount) m0.b.c(parcel, l5, GoogleSignInAccount.CREATOR);
            }
        }
        m0.b.h(parcel, s5);
        return new k0(i5, account, i6, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k0[] newArray(int i5) {
        return new k0[i5];
    }
}
