package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public abstract class zzai extends zzb implements zzaj {
    public static zzaj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        return queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzah(iBinder);
    }
}
