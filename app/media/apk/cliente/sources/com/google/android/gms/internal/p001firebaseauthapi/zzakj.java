package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakj  reason: invalid package */
/* loaded from: classes.dex */
final class zzakj {
    private static final zzakh zza = zzc();
    private static final zzakh zzb = new zzakg();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakh zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzakh zzb() {
        return zzb;
    }

    private static zzakh zzc() {
        try {
            return (zzakh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
