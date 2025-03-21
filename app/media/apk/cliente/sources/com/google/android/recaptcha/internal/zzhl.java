package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzhl extends zzip {
    private static final zzhl zzd;
    private int zze;
    private boolean zzf;
    private zzht zzg;
    private boolean zzh;
    private byte zzj = 2;
    private zzjb zzi = zzko.zze();

    static {
        zzhl zzhlVar = new zzhl();
        zzd = zzhlVar;
        zzit.zzD(zzhl.class, zzhlVar);
    }

    private zzhl() {
    }

    public static zzhl zzg() {
        return zzd;
    }

    @Override // com.google.android.recaptcha.internal.zzit
    public final Object zzh(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            this.zzj = obj == null ? (byte) 0 : (byte) 1;
                            return null;
                        }
                        return zzd;
                    }
                    return new zzhk(null);
                }
                return new zzhl();
            }
            return new zzkp(zzd, "\u0001\u0004\u0000\u0001\u0001ϧ\u0004\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzhx.class});
        }
        return Byte.valueOf(this.zzj);
    }
}
