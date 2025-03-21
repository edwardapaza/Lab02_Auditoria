package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkv  reason: invalid package */
/* loaded from: classes.dex */
final class zzkv implements zzla {
    private final int zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(int i5) {
        if (i5 == 16 || i5 == 32) {
            this.zza = i5;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i5);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzla
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzla
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr.length == this.zza) {
            return new zzhn(bArr, false).zza(bArr2, bArr3, bArr4);
        }
        int length = bArr.length;
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzla
    public final int zzb() {
        return 12;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzla
    public final byte[] zzc() {
        int i5 = this.zza;
        if (i5 != 16) {
            if (i5 == 32) {
                return zzlq.zzj;
            }
            throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
        }
        return zzlq.zzi;
    }
}
