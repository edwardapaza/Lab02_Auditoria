package com.google.android.gms.internal.p000authapiphone;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzd  reason: invalid package */
/* loaded from: classes.dex */
public class zzd {
    private static final ClassLoader zza = zzd.class.getClassLoader();

    private zzd() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static boolean zza(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
