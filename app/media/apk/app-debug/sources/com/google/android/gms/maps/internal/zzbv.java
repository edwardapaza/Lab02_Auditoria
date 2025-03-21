package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public abstract class zzbv extends com.google.android.gms.internal.maps.zzb implements zzbw {
    public zzbv() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                com.google.android.gms.internal.maps.zzc.zzc(parcel);
                zzb((Bitmap) com.google.android.gms.internal.maps.zzc.zza(parcel, Bitmap.CREATOR));
                break;
            case 2:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.internal.maps.zzc.zzc(parcel);
                zzc(asInterface);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
