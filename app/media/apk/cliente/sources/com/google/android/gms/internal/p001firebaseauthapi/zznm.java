package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznm  reason: invalid package */
/* loaded from: classes.dex */
public final class zznm {
    private static final zznm zza = new zznm();
    private final Map<Class<? extends zzci>, zznp<? extends zzci>> zzb = new HashMap();

    public static zznm zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzci> void zza(zznp<ParametersT> zznpVar, Class<ParametersT> cls) {
        zznp<? extends zzci> zznpVar2 = this.zzb.get(cls);
        if (zznpVar2 != null && !zznpVar2.equals(zznpVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
        this.zzb.put(cls, zznpVar);
    }
}
