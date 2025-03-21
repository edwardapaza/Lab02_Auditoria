package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqt  reason: invalid package */
/* loaded from: classes.dex */
final class zzqt implements zzcf {
    private final zzch<zzcf> zza;
    private final zzrp zzb;
    private final zzrp zzc;

    private zzqt(zzch<zzcf> zzchVar) {
        zzrp zzrpVar;
        this.zza = zzchVar;
        if (zzchVar.zzf()) {
            zzrq zzb = zzno.zza().zzb();
            zzrs zza = zzng.zza(zzchVar);
            this.zzb = zzb.zza(zza, "mac", "compute");
            zzrpVar = zzb.zza(zza, "mac", "verify");
        } else {
            zzrpVar = zzng.zza;
            this.zzb = zzrpVar;
        }
        this.zzc = zzrpVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcf
    public final void zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 5) {
            this.zzc.zza();
            throw new GeneralSecurityException("tag too short");
        }
        for (zzcm<zzcf> zzcmVar : this.zza.zza(Arrays.copyOf(bArr, 5))) {
            try {
                zzcmVar.zze().zza(bArr, bArr2);
                this.zzc.zza(zzcmVar.zza(), bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        for (zzcm<zzcf> zzcmVar2 : this.zza.zze()) {
            try {
                zzcmVar2.zze().zza(bArr, bArr2);
                this.zzc.zza(zzcmVar2.zza(), bArr2.length);
                return;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("invalid MAC");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcf
    public final byte[] zza(byte[] bArr) {
        try {
            byte[] zza = this.zza.zza().zze().zza(bArr);
            this.zzb.zza(this.zza.zza().zza(), bArr.length);
            return zza;
        } catch (GeneralSecurityException e5) {
            this.zzb.zza();
            throw e5;
        }
    }
}
