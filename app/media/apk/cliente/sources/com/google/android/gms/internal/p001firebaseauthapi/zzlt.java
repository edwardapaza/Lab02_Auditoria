package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlt  reason: invalid package */
/* loaded from: classes.dex */
final class zzlt implements zzlg {
    private final zzkx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlt(zzkx zzkxVar) {
        this.zza = zzkxVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzlg
    public final byte[] zza() {
        if (Arrays.equals(this.zza.zzb(), zzlq.zzf)) {
            return zzlq.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzlg
    public final byte[] zza(byte[] bArr, zzli zzliVar) {
        byte[] zza = zzxp.zza(zzliVar.zza().zzb(), bArr);
        byte[] zza2 = zzwi.zza(bArr, zzliVar.zzb().zzb());
        byte[] zza3 = zzlq.zza(zzlq.zzb);
        zzkx zzkxVar = this.zza;
        return zzkxVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzkxVar.zza());
    }
}
