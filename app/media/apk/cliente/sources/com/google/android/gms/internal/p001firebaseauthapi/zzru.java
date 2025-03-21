package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzru  reason: invalid package */
/* loaded from: classes.dex */
public final class zzru {
    private final zzbw zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    private zzru(zzbw zzbwVar, int i5, String str, String str2) {
        this.zza = zzbwVar;
        this.zzb = i5;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzru) {
            zzru zzruVar = (zzru) obj;
            return this.zza == zzruVar.zza && this.zzb == zzruVar.zzb && this.zzc.equals(zzruVar.zzc) && this.zzd.equals(zzruVar.zzd);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final int zza() {
        return this.zzb;
    }
}
