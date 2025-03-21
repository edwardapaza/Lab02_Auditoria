package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
public final class zzu {
    private static zzu zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private zzn zzd = new zzn(this, null);
    private int zze = 1;

    zzu(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static /* bridge */ /* synthetic */ Context zza(zzu zzuVar) {
        return zzuVar.zzb;
    }

    public static synchronized zzu zzb(Context context) {
        zzu zzuVar;
        synchronized (zzu.class) {
            if (zza == null) {
                com.google.android.gms.internal.cloudmessaging.zze.zza();
                zza = new zzu(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            zzuVar = zza;
        }
        return zzuVar;
    }

    public static /* bridge */ /* synthetic */ ScheduledExecutorService zze(zzu zzuVar) {
        return zzuVar.zzc;
    }

    private final synchronized int zzf() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }

    private final synchronized Task zzg(zzr zzrVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Queueing ".concat(zzrVar.toString()));
        }
        if (!this.zzd.zzg(zzrVar)) {
            zzn zznVar = new zzn(this, null);
            this.zzd = zznVar;
            zznVar.zzg(zzrVar);
        }
        return zzrVar.zzb.getTask();
    }

    public final Task zzc(int i, Bundle bundle) {
        return zzg(new zzq(zzf(), i, bundle));
    }

    public final Task zzd(int i, Bundle bundle) {
        return zzg(new zzt(zzf(), 1, bundle));
    }
}
