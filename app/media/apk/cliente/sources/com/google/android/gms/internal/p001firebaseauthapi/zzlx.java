package com.google.android.gms.internal.p001firebaseauthapi;

import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx  reason: invalid package */
/* loaded from: classes.dex */
public final class zzlx {
    private static final Object zza = new Object();
    private static final String zzb = "zzlx";
    private final zzce zzc;
    private final zzbh zzd;
    private zzcc zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Context zza = null;
        private String zzb = null;
        private String zzc = null;
        private String zzd = null;
        private zzbh zze = null;
        private boolean zzf = true;
        private zzbv zzg = null;
        private zzvd zzh = null;
        private zzcc zzi;

        private static zzcc zza(byte[] bArr) {
            return zzcc.zza(zzbm.zza(zzbk.zza(bArr)));
        }

        private final zzbh zzb() {
            if (!zzlx.zzd()) {
                Log.w(zzlx.zzb, "Android Keystore requires at least Android M");
                return null;
            }
            zzma zzmaVar = new zzma();
            try {
                boolean zzc = zzma.zzc(this.zzd);
                try {
                    return zzmaVar.zza(this.zzd);
                } catch (GeneralSecurityException | ProviderException e5) {
                    if (zzc) {
                        Log.w(zzlx.zzb, "cannot use Android Keystore, it'll be disabled", e5);
                        return null;
                    }
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzd), e5);
                }
            } catch (GeneralSecurityException | ProviderException e6) {
                Log.w(zzlx.zzb, "cannot use Android Keystore, it'll be disabled", e6);
                return null;
            }
        }

        private final zzcc zzb(byte[] bArr) {
            try {
                this.zze = new zzma().zza(this.zzd);
                try {
                    return zzcc.zza(zzby.zza(zzbk.zza(bArr), this.zze));
                } catch (IOException | GeneralSecurityException e5) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e5;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e6) {
                try {
                    zzcc zza = zza(bArr);
                    Log.w(zzlx.zzb, "cannot use Android Keystore, it'll be disabled", e6);
                    return zza;
                } catch (IOException unused2) {
                    throw e6;
                }
            }
        }

        private static byte[] zzb(Context context, String str, String str2) {
            if (str != null) {
                Context applicationContext = context.getApplicationContext();
                try {
                    String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
                    if (string == null) {
                        return null;
                    }
                    return zzxh.zza(string);
                } catch (ClassCastException | IllegalArgumentException unused) {
                    throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
                }
            }
            throw new IllegalArgumentException("keysetName cannot be null");
        }

        public final zza zza(Context context, String str, String str2) {
            if (context != null) {
                this.zza = context;
                this.zzb = str;
                this.zzc = str2;
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }

        public final zza zza(zzvd zzvdVar) {
            this.zzh = zzvdVar;
            return this;
        }

        public final zza zza(String str) {
            if (str.startsWith("android-keystore://")) {
                if (this.zzf) {
                    this.zzd = str;
                    return this;
                }
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }

        public final synchronized zzlx zza() {
            zzcc zza;
            zzlx zzlxVar;
            if (this.zzb == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            zzvd zzvdVar = this.zzh;
            if (zzvdVar != null && this.zzg == null) {
                this.zzg = zzbv.zza(zzcv.zza(zzvdVar.zzj()));
            }
            synchronized (zzlx.zza) {
                byte[] zzb = zzb(this.zza, this.zzb, this.zzc);
                if (zzb == null) {
                    if (this.zzd != null) {
                        this.zze = zzb();
                    }
                    if (this.zzg == null) {
                        throw new GeneralSecurityException("cannot read or generate keyset");
                    }
                    zzcc zza2 = zzcc.zzb().zza(this.zzg);
                    zza = zza2.zza(zza2.zza().zzc().zza(0).zza());
                    zzlx.zza(zza.zza(), new zzmc(this.zza, this.zzb, this.zzc), this.zze);
                } else {
                    if (this.zzd != null && zzlx.zzd()) {
                        zza = zzb(zzb);
                    }
                    zza = zza(zzb);
                }
                this.zzi = zza;
                zzlxVar = new zzlx(this);
            }
            return zzlxVar;
        }
    }

    private zzlx(zza zzaVar) {
        this.zzc = new zzmc(zzaVar.zza, zzaVar.zzb, zzaVar.zzc);
        this.zzd = zzaVar.zze;
        this.zze = zzaVar.zzi;
    }

    static /* synthetic */ void zza(zzby zzbyVar, zzce zzceVar, zzbh zzbhVar) {
        try {
            if (zzbhVar != null) {
                zzbyVar.zza(zzceVar, zzbhVar);
            } else {
                zzbm.zza(zzbyVar, zzceVar);
            }
        } catch (IOException e5) {
            throw new GeneralSecurityException(e5);
        }
    }

    static /* synthetic */ boolean zzd() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public final synchronized zzby zza() {
        return this.zze.zza();
    }
}
