package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzre  reason: invalid package */
/* loaded from: classes.dex */
public final class zzre implements zzpx {
    private static final zzic.zza zza = zzic.zza.zza;
    private final zzpi zzb;

    public zzre(zzpi zzpiVar) {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        this.zzb = zzpiVar;
    }
}
