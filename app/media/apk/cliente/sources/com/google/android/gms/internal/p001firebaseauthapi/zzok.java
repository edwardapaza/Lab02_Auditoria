package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok  reason: invalid package */
/* loaded from: classes.dex */
public final class zzok {
    private final Map<zzom, zzoe<?, ?>> zza;
    private final Map<Class<?>, zzcq<?, ?>> zzb;

    private zzok() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzok(zzol zzolVar) {
        this.zza = new HashMap(zzol.zzb(zzolVar));
        this.zzb = new HashMap(zzol.zzc(zzolVar));
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzok zza(zzcq<InputPrimitiveT, WrapperPrimitiveT> zzcqVar) {
        if (zzcqVar != null) {
            Class<WrapperPrimitiveT> zzb = zzcqVar.zzb();
            if (this.zzb.containsKey(zzb)) {
                zzcq<?, ?> zzcqVar2 = this.zzb.get(zzb);
                if (!zzcqVar2.equals(zzcqVar) || !zzcqVar.equals(zzcqVar2)) {
                    String valueOf = String.valueOf(zzb);
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + valueOf);
                }
            } else {
                this.zzb.put(zzb, zzcqVar);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public final <KeyT extends zzbu, PrimitiveT> zzok zza(zzoe<KeyT, PrimitiveT> zzoeVar) {
        if (zzoeVar != null) {
            zzom zzomVar = new zzom(zzoeVar.zza(), zzoeVar.zzb());
            if (this.zza.containsKey(zzomVar)) {
                zzoe<?, ?> zzoeVar2 = this.zza.get(zzomVar);
                if (!zzoeVar2.equals(zzoeVar) || !zzoeVar.equals(zzoeVar2)) {
                    String valueOf = String.valueOf(zzomVar);
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + valueOf);
                }
            } else {
                this.zza.put(zzomVar, zzoeVar);
            }
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final zzol zza() {
        return new zzol(this);
    }
}
