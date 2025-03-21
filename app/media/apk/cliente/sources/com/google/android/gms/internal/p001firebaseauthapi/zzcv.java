package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzcv {
    public static zzci zza(byte[] bArr) {
        try {
            zzvd zza = zzvd.zza(bArr, zzaip.zza());
            zznv zza2 = zznv.zza();
            zzos zza3 = zzos.zza(zza);
            return !zza2.zzb(zza3) ? new zzne(zza3) : zza2.zza((zznv) zza3);
        } catch (IOException e5) {
            throw new GeneralSecurityException("Failed to parse proto", e5);
        }
    }

    public static byte[] zza(zzci zzciVar) {
        return (zzciVar instanceof zzne ? ((zzne) zzciVar).zzb() : (zzos) zznv.zza().zza((zznv) zzciVar, (Class<zzow>) zzos.class)).zza().zzj();
    }
}
