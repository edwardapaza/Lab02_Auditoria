package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public abstract class zzv extends com.google.android.gms.internal.location.zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzw zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzw ? (zzw) queryLocalInterface : new zzu(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                com.google.android.gms.internal.location.zzc.zzd(parcel);
                zzd((LocationResult) com.google.android.gms.internal.location.zzc.zza(parcel, LocationResult.CREATOR));
                return true;
            case 2:
                com.google.android.gms.internal.location.zzc.zzd(parcel);
                zze((LocationAvailability) com.google.android.gms.internal.location.zzc.zza(parcel, LocationAvailability.CREATOR));
                return true;
            case 3:
                zzf();
                return true;
            default:
                return false;
        }
    }
}
