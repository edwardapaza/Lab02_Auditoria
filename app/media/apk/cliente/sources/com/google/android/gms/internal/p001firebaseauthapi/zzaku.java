package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaku  reason: invalid package */
/* loaded from: classes.dex */
final class zzaku {
    private static final zzaks zza = zzc();
    private static final zzaks zzb = new zzakv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaks zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaks zzb() {
        return zzb;
    }

    private static zzaks zzc() {
        try {
            return (zzaks) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
