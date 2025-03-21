package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzht extends zzip {
    private static final zzht zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private byte zzl = 2;

    static {
        zzht zzhtVar = new zzht();
        zzd = zzhtVar;
        zzit.zzD(zzht.class, zzhtVar);
    }

    private zzht() {
    }

    @Override // com.google.android.recaptcha.internal.zzit
    public final Object zzh(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            this.zzl = obj == null ? (byte) 0 : (byte) 1;
                            return null;
                        }
                        return zzd;
                    }
                    return new zzhm(null);
                }
                return new zzht();
            }
            return new zzkp(zzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"zze", "zzf", zzho.zza, "zzg", zzhn.zza, "zzh", zzhr.zza, "zzi", zzhs.zza, "zzj", zzhq.zza, "zzk", zzhp.zza});
        }
        return Byte.valueOf(this.zzl);
    }
}
