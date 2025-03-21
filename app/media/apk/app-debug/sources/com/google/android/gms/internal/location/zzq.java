package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzc.zzd(parcel);
                zzd((zzl) zzc.zza(parcel, zzl.CREATOR));
                return true;
            case 2:
                zze();
                return true;
            default:
                return false;
        }
    }
}
