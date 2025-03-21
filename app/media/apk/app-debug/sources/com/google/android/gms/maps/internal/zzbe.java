package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public abstract class zzbe extends com.google.android.gms.internal.maps.zzb implements zzbf {
    public zzbe() {
        super("com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzb((PointOfInterest) com.google.android.gms.internal.maps.zzc.zza(parcel, PointOfInterest.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
