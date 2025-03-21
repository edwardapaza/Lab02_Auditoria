package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzib extends zzit implements zzkf {
    private static final zzib zzb;
    private long zzd;
    private int zze;

    static {
        zzib zzibVar = new zzib();
        zzb = zzibVar;
        zzit.zzD(zzib.class, zzibVar);
    }

    private zzib() {
    }

    public static zzia zzi() {
        return (zzia) zzb.zzp();
    }

    public final int zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzd;
    }

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
                    return new zzia(null);
                }
                return new zzib();
            }
            return new zzkp(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
