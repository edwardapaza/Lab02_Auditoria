package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzmx extends zzit implements zzkf {
    private static final zzmx zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzmx zzmxVar = new zzmx();
        zzb = zzmxVar;
        zzit.zzD(zzmx.class, zzmxVar);
    }

    private zzmx() {
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
                    return new zzmw(null);
                }
                return new zzmx();
            }
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
