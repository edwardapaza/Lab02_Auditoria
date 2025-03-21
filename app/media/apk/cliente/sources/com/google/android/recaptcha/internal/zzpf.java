package com.google.android.recaptcha.internal;

import java.util.List;
/* loaded from: classes.dex */
public final class zzpf extends zzit implements zzkf {
    private static final zzpf zzb;
    private zzjb zzd = zzit.zzx();

    static {
        zzpf zzpfVar = new zzpf();
        zzb = zzpfVar;
        zzit.zzD(zzpf.class, zzpfVar);
    }

    private zzpf() {
    }

    public static zzpf zzg(byte[] bArr) {
        return (zzpf) zzit.zzu(zzb, bArr);
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
                    return new zzpe(null);
                }
                return new zzpf();
            }
            return zzit.zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzpr.class});
        }
        return (byte) 1;
    }

    public final List zzi() {
        return this.zzd;
    }
}
