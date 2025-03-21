package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwg  reason: invalid package */
/* loaded from: classes.dex */
public final class zzwg implements zzbh {
    private static final zzic.zza zza = zzic.zza.zzb;
    private final zzhn zzb;
    private final byte[] zzc;

    private zzwg(byte[] bArr, zzxr zzxrVar) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = new zzhn(bArr, true);
        this.zzc = zzxrVar.zzb();
    }

    public static zzbh zza(zzek zzekVar) {
        if (zzekVar.zzc().zzb() != 12) {
            int zzb = zzekVar.zzc().zzb();
            throw new GeneralSecurityException("Expected IV Size 12, got " + zzb);
        } else if (zzekVar.zzc().zzd() == 16) {
            return new zzwg(zzekVar.zze().zza(zzbr.zza()), zzekVar.zzd());
        } else {
            int zzd = zzekVar.zzc().zzd();
            throw new GeneralSecurityException("Expected tag Size 16, got " + zzd);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.zzc;
        if (bArr3.length == 0) {
            return this.zzb.zza(Arrays.copyOf(bArr, 12), bArr, bArr2);
        } else if (zzpg.zza(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzc.length, bArr.length);
            return this.zzb.zza(Arrays.copyOf(copyOfRange, 12), copyOfRange, bArr2);
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbh
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        byte[] zza2 = zzov.zza(12);
        byte[] bArr3 = this.zzc;
        return bArr3.length == 0 ? this.zzb.zzb(zza2, bArr, bArr2) : zzwi.zza(bArr3, this.zzb.zzb(zza2, bArr, bArr2));
    }
}
