package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public final class k0 extends m0.a {
    public static final Parcelable.Creator<k0> CREATOR = new l0();

    /* renamed from: a  reason: collision with root package name */
    final int f1153a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f1154b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1155c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f1156d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(int i5, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.f1153a = i5;
        this.f1154b = account;
        this.f1155c = i6;
        this.f1156d = googleSignInAccount;
    }

    public k0(Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i5, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, this.f1153a);
        m0.c.k(parcel, 2, this.f1154b, i5, false);
        m0.c.g(parcel, 3, this.f1155c);
        m0.c.k(parcel, 4, this.f1156d, i5, false);
        m0.c.b(parcel, a5);
    }
}
