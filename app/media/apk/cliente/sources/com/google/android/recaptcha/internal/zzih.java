package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzih {
    private static final zzif zza = new zzig();
    private static final zzif zzb;

    static {
        zzif zzifVar;
        try {
            zzifVar = (zzif) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzifVar = null;
        }
        zzb = zzifVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzif zza() {
        zzif zzifVar = zzb;
        if (zzifVar != null) {
            return zzifVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzif zzb() {
        return zza;
    }
}
