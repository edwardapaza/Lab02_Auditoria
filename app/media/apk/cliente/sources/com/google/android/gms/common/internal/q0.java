package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;
/* loaded from: classes.dex */
public abstract class q0 extends zzb implements l {
    public q0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zzc.zzb(parcel);
            k(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
        } else if (i5 == 2) {
            zzc.zzb(parcel);
            h(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
        } else if (i5 != 3) {
            return false;
        } else {
            zzc.zzb(parcel);
            i(parcel.readInt(), parcel.readStrongBinder(), (b1) zzc.zza(parcel, b1.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
