package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznk  reason: invalid package */
/* loaded from: classes.dex */
public final class zznk {
    private static final zznk zza = new zznk();
    private final Map<Class<? extends zzci>, zznn<? extends zzci>> zzb = new HashMap();

    public static zznk zza() {
        return zza;
    }

    private final synchronized <ParametersT extends zzci> zzbu zzb(ParametersT parameterst, Integer num) {
        zznn<? extends zzci> zznnVar;
        zznnVar = this.zzb.get(parameterst.getClass());
        if (zznnVar == null) {
            String valueOf = String.valueOf(parameterst);
            throw new GeneralSecurityException("Cannot create a new key for parameters " + valueOf + ": no key creator for this class was registered.");
        }
        return zznnVar.zza(parameterst, null);
    }

    public final zzbu zza(zzci zzciVar, Integer num) {
        return zzb(zzciVar, null);
    }

    public final synchronized <ParametersT extends zzci> void zza(zznn<ParametersT> zznnVar, Class<ParametersT> cls) {
        zznn<? extends zzci> zznnVar2 = this.zzb.get(cls);
        if (zznnVar2 != null && !zznnVar2.equals(zznnVar)) {
            String valueOf = String.valueOf(cls);
            throw new GeneralSecurityException("Different key creator for parameters class " + valueOf + " already inserted");
        }
        this.zzb.put(cls, zznnVar);
    }
}
