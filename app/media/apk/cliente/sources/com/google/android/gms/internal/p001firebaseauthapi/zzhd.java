package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhd  reason: invalid package */
/* loaded from: classes.dex */
public final class zzhd extends zzdc {
    private final zza zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhd$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        private zza(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzhd(zza zzaVar) {
        this.zza = zzaVar;
    }

    public static zzhd zza(zza zzaVar) {
        return new zzhd(zzaVar);
    }

    public static zzhd zzc() {
        return new zzhd(zza.zzc);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhd) && ((zzhd) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhd.class, this.zza);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return "XChaCha20Poly1305 Parameters (variant: " + valueOf + ")";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return this.zza != zza.zzc;
    }

    public final zza zzb() {
        return this.zza;
    }
}
