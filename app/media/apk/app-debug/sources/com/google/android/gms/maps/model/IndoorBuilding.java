package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class IndoorBuilding {
    private final com.google.android.gms.internal.maps.zzu zza;
    private final zzh zzb;

    public IndoorBuilding(com.google.android.gms.internal.maps.zzu zzuVar) {
        zzh zzhVar = zzh.zza;
        this.zza = (com.google.android.gms.internal.maps.zzu) Preconditions.checkNotNull(zzuVar, "delegate");
        this.zzb = (zzh) Preconditions.checkNotNull(zzhVar, "shim");
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof IndoorBuilding) {
            try {
                return this.zza.zzh(((IndoorBuilding) other).zza);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return false;
    }

    public int getActiveLevelIndex() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> zzg = this.zza.zzg();
            ArrayList arrayList = new ArrayList(zzg.size());
            for (IBinder iBinder : zzg) {
                arrayList.add(new IndoorLevel(com.google.android.gms.internal.maps.zzw.zzb(iBinder)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
