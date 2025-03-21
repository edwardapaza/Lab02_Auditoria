package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzb;
/* loaded from: classes.dex */
public interface j extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends zzb implements j {
        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof j ? (j) queryLocalInterface : new n1(iBinder);
        }
    }

    Account zzb();
}
