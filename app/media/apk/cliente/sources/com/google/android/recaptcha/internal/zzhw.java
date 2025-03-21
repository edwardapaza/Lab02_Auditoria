package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzhw extends zzit implements zzkf {
    private static final zzhw zzb;
    private int zzd;
    private boolean zzf;
    private byte zzg = 2;
    private String zze = "";

    static {
        zzhw zzhwVar = new zzhw();
        zzb = zzhwVar;
        zzit.zzD(zzhw.class, zzhwVar);
    }

    private zzhw() {
    }

    @Override // com.google.android.recaptcha.internal.zzit
    public final Object zzh(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            this.zzg = obj == null ? (byte) 0 : (byte) 1;
                            return null;
                        }
                        return zzb;
                    }
                    return new zzhv(null);
                }
                return new zzhw();
            }
            return new zzkp(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return Byte.valueOf(this.zzg);
    }
}
