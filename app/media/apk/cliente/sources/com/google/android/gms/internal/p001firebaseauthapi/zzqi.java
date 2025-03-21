package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqi  reason: invalid package */
/* loaded from: classes.dex */
final class zzqi extends zzoi<zzcf, zzue> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqi(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoi
    public final /* synthetic */ zzcf zza(zzue zzueVar) {
        zzue zzueVar2 = zzueVar;
        zzuc zzb = zzueVar2.zze().zzb();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzueVar2.zzf().zzg(), "HMAC");
        int zza = zzueVar2.zze().zza();
        int i5 = zzqk.zza[zzb.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 == 5) {
                            return new zzxo(new zzxm("HMACSHA512", secretKeySpec), zza);
                        }
                        throw new GeneralSecurityException("unknown hash");
                    }
                    return new zzxo(new zzxm("HMACSHA384", secretKeySpec), zza);
                }
                return new zzxo(new zzxm("HMACSHA256", secretKeySpec), zza);
            }
            return new zzxo(new zzxm("HMACSHA224", secretKeySpec), zza);
        }
        return new zzxo(new zzxm("HMACSHA1", secretKeySpec), zza);
    }
}
