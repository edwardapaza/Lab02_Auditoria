package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaef  reason: invalid package */
/* loaded from: classes.dex */
final class zzaef extends zzafy {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzaex zzd;
    private final String zze;

    private zzaef(String str, String str2, String str3, zzaex zzaexVar, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaexVar;
        this.zze = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzafy) {
            zzafy zzafyVar = (zzafy) obj;
            if (this.zza.equals(zzafyVar.zzd()) && ((str = this.zzb) != null ? str.equals(zzafyVar.zze()) : zzafyVar.zze() == null) && this.zzc.equals(zzafyVar.zzf()) && this.zzd.equals(zzafyVar.zzb()) && this.zze.equals(zzafyVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        String str = this.zzb;
        return ((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzc;
        String valueOf = String.valueOf(this.zzd);
        String str4 = this.zze;
        return "RevokeTokenRequest{providerId=" + str + ", tenantId=" + str2 + ", token=" + str3 + ", tokenType=" + valueOf + ", idToken=" + str4 + "}";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzafy
    public final zzaex zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzafy
    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzafy
    public final String zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzafy
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzafy
    public final String zzf() {
        return this.zzc;
    }
}
