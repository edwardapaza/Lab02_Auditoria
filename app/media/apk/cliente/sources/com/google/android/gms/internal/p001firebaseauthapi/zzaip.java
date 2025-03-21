package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaip  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaip {
    static final zzaip zza = new zzaip(true);
    private static volatile boolean zzb = false;
    private static boolean zzc = true;
    private final Map<zzaio, zzaja.zzf<?, ?>> zzd;

    zzaip() {
        this.zzd = new HashMap();
    }

    private zzaip(boolean z4) {
        this.zzd = Collections.emptyMap();
    }

    public static zzaip zza() {
        return zza;
    }

    public final <ContainingType extends zzakk> zzaja.zzf<ContainingType, ?> zza(ContainingType containingtype, int i5) {
        return (zzaja.zzf<ContainingType, ?>) this.zzd.get(new zzaio(containingtype, i5));
    }
}
