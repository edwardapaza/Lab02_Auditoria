package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzos  reason: invalid package */
/* loaded from: classes.dex */
public final class zzos implements zzow {
    private final zzxr zza;
    private final zzvd zzb;

    private zzos(zzvd zzvdVar, zzxr zzxrVar) {
        this.zzb = zzvdVar;
        this.zza = zzxrVar;
    }

    public static zzos zza(zzvd zzvdVar) {
        return new zzos(zzvdVar, zzpg.zza(zzvdVar.zzf()));
    }

    public static zzos zzb(zzvd zzvdVar) {
        return new zzos(zzvdVar, zzpg.zzb(zzvdVar.zzf()));
    }

    public final zzvd zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzow
    public final zzxr zzb() {
        return this.zza;
    }
}
