package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoz */
/* loaded from: classes.dex */
public final class zzoz {
    private final Map<zzpd, zzmx<?, ?>> zza;
    private final Map<zzpb, zzmt<?>> zzb;
    private final Map<zzpd, zzoa<?, ?>> zzc;
    private final Map<zzpb, zznw<?>> zzd;

    /* JADX INFO: Access modifiers changed from: private */
    public zzoz(zzoy zzoyVar) {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = zzoyVar.zza;
        this.zza = new HashMap(map);
        map2 = zzoyVar.zzb;
        this.zzb = new HashMap(map2);
        map3 = zzoyVar.zzc;
        this.zzc = new HashMap(map3);
        map4 = zzoyVar.zzd;
        this.zzd = new HashMap(map4);
    }

    public final <SerializationT extends zzow> zzbu zza(SerializationT serializationt, zzct zzctVar) {
        zzpb zzpbVar = new zzpb(serializationt.getClass(), serializationt.zzb());
        if (this.zzb.containsKey(zzpbVar)) {
            return this.zzb.get(zzpbVar).zza(serializationt, zzctVar);
        }
        String valueOf = String.valueOf(zzpbVar);
        throw new GeneralSecurityException("No Key Parser for requested key type " + valueOf + " available");
    }

    public final <SerializationT extends zzow> zzci zza(SerializationT serializationt) {
        zzpb zzpbVar = new zzpb(serializationt.getClass(), serializationt.zzb());
        if (this.zzd.containsKey(zzpbVar)) {
            return this.zzd.get(zzpbVar).zza(serializationt);
        }
        String valueOf = String.valueOf(zzpbVar);
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + valueOf + " available");
    }

    public final <KeyT extends zzbu, SerializationT extends zzow> SerializationT zza(KeyT keyt, Class<SerializationT> cls, zzct zzctVar) {
        zzpd zzpdVar = new zzpd(keyt.getClass(), cls);
        if (this.zza.containsKey(zzpdVar)) {
            return (SerializationT) this.zza.get(zzpdVar).zza(keyt, zzctVar);
        }
        String valueOf = String.valueOf(zzpdVar);
        throw new GeneralSecurityException("No Key serializer for " + valueOf + " available");
    }

    public final <ParametersT extends zzci, SerializationT extends zzow> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) {
        zzpd zzpdVar = new zzpd(parameterst.getClass(), cls);
        if (this.zzc.containsKey(zzpdVar)) {
            return (SerializationT) this.zzc.get(zzpdVar).zza(parameterst);
        }
        String valueOf = String.valueOf(zzpdVar);
        throw new GeneralSecurityException("No Key Format serializer for " + valueOf + " available");
    }

    public final <SerializationT extends zzow> boolean zzb(SerializationT serializationt) {
        return this.zzb.containsKey(new zzpb(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzow> boolean zzc(SerializationT serializationt) {
        return this.zzd.containsKey(new zzpb(serializationt.getClass(), serializationt.zzb()));
    }
}
