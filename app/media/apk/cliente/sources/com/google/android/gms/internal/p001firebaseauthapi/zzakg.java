package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakg  reason: invalid package */
/* loaded from: classes.dex */
final class zzakg implements zzakh {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final int zza(int i5, Object obj, Object obj2) {
        zzake zzakeVar = (zzake) obj;
        zzakc zzakcVar = (zzakc) obj2;
        if (zzakeVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzakeVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw new NoSuchMethodError();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final zzakf<?, ?> zza(Object obj) {
        zzakc zzakcVar = (zzakc) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final Object zza(Object obj, Object obj2) {
        zzake zzakeVar = (zzake) obj;
        zzake zzakeVar2 = (zzake) obj2;
        if (!zzakeVar2.isEmpty()) {
            if (!zzakeVar.zzd()) {
                zzakeVar = zzakeVar.zzb();
            }
            zzakeVar.zza(zzakeVar2);
        }
        return zzakeVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final Object zzb(Object obj) {
        return zzake.zza().zzb();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final Object zzc(Object obj) {
        ((zzake) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final Map<?, ?> zzd(Object obj) {
        return (zzake) obj;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final Map<?, ?> zze(Object obj) {
        return (zzake) obj;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakh
    public final boolean zzf(Object obj) {
        return !((zzake) obj).zzd();
    }
}
