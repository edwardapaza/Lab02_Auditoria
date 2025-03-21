package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
/* loaded from: classes.dex */
public final class zzct {
    private static final zzct zza = new zzct();

    private zzct() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzct zza() {
        return zza;
    }

    public static zzct zza(zzct zzctVar) {
        if (zzctVar != null) {
            return zzctVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
