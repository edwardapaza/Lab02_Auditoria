package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzim implements zzkc {
    private static final zzim zza = new zzim();

    private zzim() {
    }

    public static zzim zza() {
        return zza;
    }

    @Override // com.google.android.recaptcha.internal.zzkc
    public final zzkb zzb(Class cls) {
        if (zzit.class.isAssignableFrom(cls)) {
            try {
                return (zzkb) zzit.zzr(cls.asSubclass(zzit.class)).zzh(3, null, null);
            } catch (Exception e5) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e5);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.recaptcha.internal.zzkc
    public final boolean zzc(Class cls) {
        return zzit.class.isAssignableFrom(cls);
    }
}
