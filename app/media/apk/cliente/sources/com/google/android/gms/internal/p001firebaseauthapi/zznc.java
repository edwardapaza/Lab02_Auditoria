package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
/* loaded from: classes.dex */
public final class zznc extends zzbu {
    private final zzot zza;

    public zznc(zzot zzotVar, zzct zzctVar) {
        zza(zzotVar, zzctVar);
        this.zza = zzotVar;
    }

    private static void zza(zzot zzotVar, zzct zzctVar) {
        int i5 = zznf.zza[zzotVar.zza().ordinal()];
        if (i5 == 1 || i5 == 2) {
            zzct.zza(zzctVar);
        }
    }

    public final zzot zza(zzct zzctVar) {
        zza(this.zza, zzctVar);
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbu
    public final Integer zza() {
        return this.zza.zze();
    }
}
