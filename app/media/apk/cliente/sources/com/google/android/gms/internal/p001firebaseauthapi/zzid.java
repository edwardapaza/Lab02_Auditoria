package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzid  reason: invalid package */
/* loaded from: classes.dex */
final class zzid extends ThreadLocal<Cipher> {
    private static Cipher zza() {
        boolean zzb;
        try {
            Cipher zza = zzwr.zza.zza("AES/GCM-SIV/NoPadding");
            zzb = zzia.zzb(zza);
            if (zzb) {
                return zza;
            }
            return null;
        } catch (GeneralSecurityException e5) {
            throw new IllegalStateException(e5);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return zza();
    }
}
