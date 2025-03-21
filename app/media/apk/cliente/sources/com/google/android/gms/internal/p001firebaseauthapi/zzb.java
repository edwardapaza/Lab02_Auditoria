package com.google.android.gms.internal.p001firebaseauthapi;

import java.net.URL;
import java.net.URLConnection;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzb  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzb {
    private static zzb zza = new zze();

    public static synchronized zzb zza() {
        zzb zzbVar;
        synchronized (zzb.class) {
            zzbVar = zza;
        }
        return zzbVar;
    }

    public abstract URLConnection zza(URL url, String str);
}
