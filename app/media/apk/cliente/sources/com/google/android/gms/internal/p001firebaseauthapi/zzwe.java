package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwe  reason: invalid package */
/* loaded from: classes.dex */
final class zzwe extends ThreadLocal<Cipher> {
    private static Cipher zza() {
        try {
            return zzwr.zza.zza("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e5) {
            throw new IllegalStateException(e5);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return zza();
    }
}
