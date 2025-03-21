package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zznz extends zzit implements zzkf {
    private static final zznz zzb;
    private int zzd;
    private zznx zze;
    private zznx zzf;

    static {
        zznz zznzVar = new zznz();
        zzb = zznzVar;
        zzit.zzD(zznz.class, zznzVar);
    }

    private zznz() {
    }

    public static zznz zzj(byte[] bArr) {
        return (zznz) zzit.zzu(zzb, bArr);
    }

    public final zznx zzf() {
        zznx zznxVar = this.zze;
        return zznxVar == null ? zznx.zzg() : zznxVar;
    }

    public final zznx zzg() {
        zznx zznxVar = this.zzf;
        return zznxVar == null ? zznx.zzg() : zznxVar;
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
                    return new zzny(null);
                }
                return new zznz();
            }
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
