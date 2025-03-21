package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzkl {
    private static final zzkk zza;
    private static final zzkk zzb;

    static {
        zzkk zzkkVar;
        try {
            zzkkVar = (zzkk) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzkkVar = null;
        }
        zza = zzkkVar;
        zzb = new zzkk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkk zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkk zzb() {
        return zzb;
    }
}
