package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzov  reason: invalid package */
/* loaded from: classes.dex */
public final class zzov {
    private static final ThreadLocal<SecureRandom> zza = new zzou();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SecureRandom zza() {
        SecureRandom zzc = zzc();
        zzc.nextLong();
        return zzc;
    }

    public static byte[] zza(int i5) {
        byte[] bArr = new byte[i5];
        zza.get().nextBytes(bArr);
        return bArr;
    }

    private static Provider zzb() {
        try {
            return (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e5) {
            throw new GeneralSecurityException("Failed to get Conscrypt provider", e5);
        }
    }

    private static SecureRandom zzc() {
        try {
            try {
                try {
                    try {
                        return SecureRandom.getInstance("SHA1PRNG", "GmsCore_OpenSSL");
                    } catch (GeneralSecurityException unused) {
                        return new SecureRandom();
                    }
                } catch (GeneralSecurityException unused2) {
                    return SecureRandom.getInstance("SHA1PRNG", "Conscrypt");
                }
            } catch (GeneralSecurityException unused3) {
                return SecureRandom.getInstance("SHA1PRNG", "AndroidOpenSSL");
            }
        } catch (GeneralSecurityException unused4) {
            return SecureRandom.getInstance("SHA1PRNG", zzb());
        }
    }
}
