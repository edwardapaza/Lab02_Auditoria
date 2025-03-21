package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic  reason: invalid package */
/* loaded from: classes.dex */
public final class zzic {
    private static final Logger zza = Logger.getLogger(zzic.class.getName());
    private static final AtomicBoolean zzb = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic$zza */
    /* loaded from: classes.dex */
    public static abstract class zza {
        public static final zza zza;
        public static final zza zzb;
        private static final /* synthetic */ zza[] zzc;

        static {
            zzie zzieVar = new zzie("ALGORITHM_NOT_FIPS");
            zza = zzieVar;
            zzif zzifVar = new zzif("ALGORITHM_REQUIRES_BORINGCRYPTO");
            zzb = zzifVar;
            zzc = new zza[]{zzieVar, zzifVar};
        }

        private zza(String str, int i5) {
        }

        public static zza[] values() {
            return (zza[]) zzc.clone();
        }

        public abstract boolean zza();
    }

    private zzic() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zza.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean zzb() {
        return zzb.get();
    }
}
