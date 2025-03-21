package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqq  reason: invalid package */
/* loaded from: classes.dex */
public final class zzqq {
    private static final String zza = "type.googleapis.com/google.crypto.tink.HmacKey";
    @Deprecated
    private static final zzvv zzb;
    @Deprecated
    private static final zzvv zzc;
    @Deprecated
    private static final zzvv zzd;

    static {
        zzvv zzb2 = zzvv.zzb();
        zzb = zzb2;
        zzc = zzb2;
        zzd = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e5) {
            throw new ExceptionInInitializerError(e5);
        }
    }

    public static void zza() {
        zzqr.zzc();
        zzqa.zzc();
        zzqe.zza(true);
        if (zzic.zzb()) {
            return;
        }
        zzpm.zza(true);
    }
}
