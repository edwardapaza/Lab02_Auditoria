package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;
/* loaded from: classes.dex */
public interface g extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends zab implements g {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static g asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return queryLocalInterface instanceof g ? (g) queryLocalInterface : new o0(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        protected final boolean zaa(int i5, Parcel parcel, Parcel parcel2, int i6) {
            if (i5 == 1) {
                onResult((Status) zac.zaa(parcel, Status.CREATOR));
                return true;
            }
            return false;
        }
    }

    void onResult(Status status);
}
