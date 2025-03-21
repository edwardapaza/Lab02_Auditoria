package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzvh;
import java.security.GeneralSecurityException;
import java.util.Iterator;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcc  reason: invalid package */
/* loaded from: classes.dex */
public final class zzcc {
    private final zzvh.zzb zza;

    private zzcc(zzvh.zzb zzbVar) {
        this.zza = zzbVar;
    }

    private final synchronized int zza(zzvd zzvdVar, boolean z4) {
        zzvh.zza zza;
        zza = zza(zzvdVar);
        this.zza.zza(zza);
        return zza.zza();
    }

    public static zzcc zza(zzby zzbyVar) {
        return new zzcc(zzbyVar.zzb().zzm());
    }

    private final synchronized zzvh.zza zza(zzux zzuxVar, zzvt zzvtVar) {
        int zzc;
        zzc = zzc();
        if (zzvtVar == zzvt.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzvh.zza) ((zzaja) zzvh.zza.zzd().zza(zzuxVar).zza(zzc).zza(zzvb.ENABLED).zza(zzvtVar).zzf());
    }

    private final synchronized zzvh.zza zza(zzvd zzvdVar) {
        return zza(zzcu.zza(zzvdVar), zzvdVar.zzd());
    }

    public static zzcc zzb() {
        return new zzcc(zzvh.zzc());
    }

    private final synchronized boolean zzb(int i5) {
        boolean z4;
        Iterator<zzvh.zza> it = this.zza.zzb().iterator();
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            } else if (it.next().zza() == i5) {
                z4 = true;
                break;
            }
        }
        return z4;
    }

    private final synchronized int zzc() {
        int zza;
        do {
            zza = zzpg.zza();
        } while (zzb(zza));
        return zza;
    }

    public final synchronized zzby zza() {
        return zzby.zza((zzvh) ((zzaja) this.zza.zzf()));
    }

    public final synchronized zzcc zza(int i5) {
        for (int i6 = 0; i6 < this.zza.zza(); i6++) {
            zzvh.zza zzb = this.zza.zzb(i6);
            if (zzb.zza() == i5) {
                if (!zzb.zzc().equals(zzvb.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i5);
                } else {
                    this.zza.zza(i5);
                }
            }
        }
        throw new GeneralSecurityException("key not found: " + i5);
        return this;
    }

    public final synchronized zzcc zza(zzbv zzbvVar) {
        zza(zzbvVar.zza(), false);
        return this;
    }
}
