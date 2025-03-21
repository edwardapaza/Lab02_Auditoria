package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzis  reason: invalid package */
/* loaded from: classes.dex */
public final class zzis {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    private static final zzvv zzb = zzvv.zzb();
    @Deprecated
    private static final zzvv zzc = zzvv.zzb();

    static {
        try {
            zza();
        } catch (GeneralSecurityException e5) {
            throw new ExceptionInInitializerError(e5);
        }
    }

    public static void zza() {
        zzix.zzc();
        if (zzic.zzb()) {
            return;
        }
        zzin.zza(true);
    }
}
