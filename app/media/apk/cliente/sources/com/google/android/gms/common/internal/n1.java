package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;
/* loaded from: classes.dex */
public final class n1 extends zza implements j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.j
    public final Account zzb() {
        Parcel zzB = zzB(2, zza());
        Account account = (Account) zzc.zza(zzB, Account.CREATOR);
        zzB.recycle();
        return account;
    }
}
