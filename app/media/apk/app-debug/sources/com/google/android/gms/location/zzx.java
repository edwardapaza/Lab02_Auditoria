package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final class zzx extends com.google.android.gms.internal.location.zza implements zzz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    @Override // com.google.android.gms.location.zzz
    public final void zzd(Location location) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.location.zzz
    public final void zze() throws RemoteException {
        throw null;
    }
}
