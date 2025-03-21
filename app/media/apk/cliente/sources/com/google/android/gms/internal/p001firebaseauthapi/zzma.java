package com.google.android.gms.internal.p001firebaseauthapi;

import android.annotation.NonNull;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
/* loaded from: classes.dex */
public final class zzma implements zzcd {
    private static final Object zza = new Object();
    private static final String zzb = "zzma";
    private final String zzc;
    private KeyStore zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        KeyStore zza;
        private String zzb = null;

        public zza() {
            this.zza = null;
            if (!zzma.zza()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zza = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e5) {
                throw new IllegalStateException(e5);
            }
        }
    }

    public zzma() {
        this(new zza());
    }

    private zzma(zza zzaVar) {
        this.zzc = null;
        this.zzd = zzaVar.zza;
    }

    static /* synthetic */ boolean zza() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.security.keystore.KeyGenParameterSpec$Builder] */
    public static boolean zzc(String str) {
        zzma zzmaVar = new zzma();
        synchronized (zza) {
            if (zzmaVar.zzd(str)) {
                return false;
            }
            final String zza2 = zzxq.zza("android-keystore://", str);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new Object(zza2, 3) { // from class: android.security.keystore.KeyGenParameterSpec$Builder
                static {
                    throw new NoClassDefFoundError();
                }

                @NonNull
                public native /* synthetic */ KeyGenParameterSpec build();

                @NonNull
                public native /* synthetic */ KeyGenParameterSpec$Builder setBlockModes(String... strArr);

                @NonNull
                public native /* synthetic */ KeyGenParameterSpec$Builder setEncryptionPaddings(String... strArr);

                @NonNull
                public native /* synthetic */ KeyGenParameterSpec$Builder setKeySize(int i5);
            }.setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            keyGenerator.generateKey();
            return true;
        }
    }

    private final synchronized boolean zzd(String str) {
        String str2;
        try {
        } catch (NullPointerException unused) {
            Log.w(zzb, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                try {
                    Thread.sleep((int) (Math.random() * 40.0d));
                } catch (InterruptedException unused2) {
                }
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zzd = keyStore;
                keyStore.load(null);
                return this.zzd.containsAlias(str2);
            } catch (IOException e5) {
                throw new GeneralSecurityException(e5);
            }
        }
        return this.zzd.containsAlias(zzxq.zza("android-keystore://", str));
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcd
    public final synchronized zzbh zza(String str) {
        zzly zzlyVar;
        zzlyVar = new zzly(zzxq.zza("android-keystore://", str), this.zzd);
        byte[] zza2 = zzov.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zza2, zzlyVar.zza(zzlyVar.zzb(zza2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzlyVar;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcd
    public final synchronized boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }
}
