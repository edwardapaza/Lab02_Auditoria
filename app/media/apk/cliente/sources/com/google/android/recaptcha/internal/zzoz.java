package com.google.android.recaptcha.internal;

import java.io.InputStream;
/* loaded from: classes.dex */
public final class zzoz extends zzit implements zzkf {
    private static final zzoz zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzoz zzozVar = new zzoz();
        zzb = zzozVar;
        zzit.zzD(zzoz.class, zzozVar);
    }

    private zzoz() {
    }

    public static zzoz zzg(InputStream inputStream) {
        return (zzoz) zzit.zzt(zzb, inputStream);
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
                    return new zzoy(null);
                }
                return new zzoz();
            }
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzpb zzi() {
        zzpb zzb2 = zzpb.zzb(this.zzf);
        return zzb2 == null ? zzpb.UNRECOGNIZED : zzb2;
    }
}
