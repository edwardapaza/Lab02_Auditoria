package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzna extends zzit implements zzkf {
    private static final zzna zzb;
    private int zzd;
    private int zzf;
    private int zzh;
    private int zzj;
    private String zze = "";
    private String zzg = "";
    private String zzi = "";

    static {
        zzna zznaVar = new zzna();
        zzb = zznaVar;
        zzit.zzD(zzna.class, zznaVar);
    }

    private zzna() {
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
                    return new zzmz(null);
                }
                return new zzna();
            }
            return zzit.zzA(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005\u0004\u0006Ȉ\u0007\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
