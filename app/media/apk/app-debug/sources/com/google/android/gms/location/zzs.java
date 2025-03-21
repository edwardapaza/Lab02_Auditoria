package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public abstract class zzs extends com.google.android.gms.internal.location.zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.location.IDeviceOrientationListener");
    }

    public static zzt zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return queryLocalInterface instanceof zzt ? (zzt) queryLocalInterface : new zzr(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zzd((DeviceOrientation) com.google.android.gms.internal.location.zzc.zza(parcel, DeviceOrientation.CREATOR));
            return true;
        }
        return false;
    }
}
