package com.google.android.gms.internal.p000authapiphone;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zza  reason: invalid package */
/* loaded from: classes.dex */
public class zza extends Binder implements IInterface {
    private static zzc zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        boolean z4;
        if (i5 > 16777215) {
            z4 = super.onTransact(i5, parcel, parcel2, i6);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z4 = false;
        }
        if (z4) {
            return true;
        }
        return zza(i5, parcel, parcel2, i6);
    }

    protected boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        return false;
    }
}
