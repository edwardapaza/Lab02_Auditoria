package com.google.android.recaptcha.internal;

import java.util.List;
/* loaded from: classes.dex */
public final class zznx extends zzit implements zzkf {
    private static final zznx zzb;
    private zzjb zzd = zzit.zzx();

    static {
        zznx zznxVar = new zznx();
        zzb = zznxVar;
        zzit.zzD(zznx.class, zznxVar);
    }

    private zznx() {
    }

    public static zznx zzg() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.recaptcha.internal.zzit
    public final Object zzh(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zznw(null);
                }
                return new zznx();
            }
            return zzit.zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zzd"});
        }
        return (byte) 1;
    }

    public final List zzi() {
        return this.zzd;
    }
}
