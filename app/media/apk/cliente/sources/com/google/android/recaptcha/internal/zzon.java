package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzon extends zzit implements zzkf {
    private static final zzon zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzon zzonVar = new zzon();
        zzb = zzonVar;
        zzit.zzD(zzon.class, zzonVar);
    }

    private zzon() {
    }

    public final String zzg() {
        return this.zze;
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
                    return new zzom(null);
                }
                return new zzon();
            }
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final String zzi() {
        return this.zzf;
    }
}
