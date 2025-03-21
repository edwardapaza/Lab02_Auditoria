package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzjv implements zzkc {
    private final zzkc[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjv(zzkc... zzkcVarArr) {
        this.zza = zzkcVarArr;
    }

    @Override // com.google.android.recaptcha.internal.zzkc
    public final zzkb zzb(Class cls) {
        for (int i5 = 0; i5 < 2; i5++) {
            zzkc zzkcVar = this.zza[i5];
            if (zzkcVar.zzc(cls)) {
                return zzkcVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.recaptcha.internal.zzkc
    public final boolean zzc(Class cls) {
        for (int i5 = 0; i5 < 2; i5++) {
            if (this.zza[i5].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
