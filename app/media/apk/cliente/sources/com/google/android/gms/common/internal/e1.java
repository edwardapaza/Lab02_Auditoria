package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class e1 implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, Parcel parcel, int i5) {
        int a5 = m0.c.a(parcel);
        m0.c.g(parcel, 1, fVar.f1114a);
        m0.c.g(parcel, 2, fVar.f1115b);
        m0.c.g(parcel, 3, fVar.f1116c);
        m0.c.l(parcel, 4, fVar.f1117d, false);
        m0.c.f(parcel, 5, fVar.f1118e, false);
        m0.c.n(parcel, 6, fVar.f1119f, i5, false);
        m0.c.e(parcel, 7, fVar.f1120k, false);
        m0.c.k(parcel, 8, fVar.f1121l, i5, false);
        m0.c.n(parcel, 10, fVar.f1122m, i5, false);
        m0.c.n(parcel, 11, fVar.f1123n, i5, false);
        m0.c.c(parcel, 12, fVar.f1124o);
        m0.c.g(parcel, 13, fVar.f1125p);
        m0.c.c(parcel, 14, fVar.f1126q);
        m0.c.l(parcel, 15, fVar.zza(), false);
        m0.c.b(parcel, a5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s5 = m0.b.s(parcel);
        Scope[] scopeArr = f.f1112s;
        Bundle bundle = new Bundle();
        l0.c[] cVarArr = f.f1113t;
        l0.c[] cVarArr2 = cVarArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z4 = false;
        int i8 = 0;
        boolean z5 = false;
        while (parcel.dataPosition() < s5) {
            int l5 = m0.b.l(parcel);
            switch (m0.b.i(l5)) {
                case 1:
                    i5 = m0.b.n(parcel, l5);
                    break;
                case 2:
                    i6 = m0.b.n(parcel, l5);
                    break;
                case 3:
                    i7 = m0.b.n(parcel, l5);
                    break;
                case 4:
                    str = m0.b.d(parcel, l5);
                    break;
                case 5:
                    iBinder = m0.b.m(parcel, l5);
                    break;
                case 6:
                    scopeArr = (Scope[]) m0.b.f(parcel, l5, Scope.CREATOR);
                    break;
                case 7:
                    bundle = m0.b.a(parcel, l5);
                    break;
                case 8:
                    account = (Account) m0.b.c(parcel, l5, Account.CREATOR);
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                default:
                    m0.b.r(parcel, l5);
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    cVarArr = (l0.c[]) m0.b.f(parcel, l5, l0.c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (l0.c[]) m0.b.f(parcel, l5, l0.c.CREATOR);
                    break;
                case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    z4 = m0.b.j(parcel, l5);
                    break;
                case 13:
                    i8 = m0.b.n(parcel, l5);
                    break;
                case 14:
                    z5 = m0.b.j(parcel, l5);
                    break;
                case 15:
                    str2 = m0.b.d(parcel, l5);
                    break;
            }
        }
        m0.b.h(parcel, s5);
        return new f(i5, i6, i7, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z4, i8, z5, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new f[i5];
    }
}
