package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznt  reason: invalid package */
/* loaded from: classes.dex */
public final class zznt {
    private static final zznt zza = new zznt();
    private final Map<String, zzci> zzb = new HashMap();

    zznt() {
    }

    public static zznt zza() {
        return zza;
    }

    private final synchronized void zza(String str, zzci zzciVar) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, zzciVar);
        } else if (this.zzb.get(str).equals(zzciVar)) {
        } else {
            String valueOf = String.valueOf(this.zzb.get(str));
            String valueOf2 = String.valueOf(zzciVar);
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + valueOf2);
        }
    }

    public final synchronized void zza(Map<String, zzci> map) {
        for (Map.Entry<String, zzci> entry : map.entrySet()) {
            zza(entry.getKey(), entry.getValue());
        }
    }
}
