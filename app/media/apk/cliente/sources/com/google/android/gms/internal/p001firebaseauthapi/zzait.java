package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzait  reason: invalid package */
/* loaded from: classes.dex */
final class zzait {
    private static final zzair<?> zza = new zzaiq();
    private static final zzair<?> zzb = zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzair<?> zza() {
        zzair<?> zzairVar = zzb;
        if (zzairVar != null) {
            return zzairVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzair<?> zzb() {
        return zza;
    }

    private static zzair<?> zzc() {
        try {
            return (zzair) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
