package com.google.android.recaptcha.internal;

import java.io.InputStream;
import java.util.List;
/* loaded from: classes.dex */
public final class zzoe extends zzit implements zzkf {
    private static final zzoe zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzja zzk = zzit.zzw();
    private zzgw zzl = zzgw.zzb;
    private String zzm = "";

    static {
        zzoe zzoeVar = new zzoe();
        zzb = zzoeVar;
        zzit.zzD(zzoe.class, zzoeVar);
    }

    private zzoe() {
    }

    public static zzoe zzi(InputStream inputStream) {
        return (zzoe) zzit.zzt(zzb, inputStream);
    }

    public final String zzH() {
        return this.zzg;
    }

    public final String zzI() {
        return this.zzi;
    }

    public final String zzJ() {
        return this.zzj;
    }

    public final List zzK() {
        return this.zzk;
    }

    public final zzgw zzf() {
        return this.zzl;
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
                    return new zzod(null);
                }
                return new zzoe();
            }
            return zzit.zzA(zzb, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007%\bည\u0006\tለ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        return (byte) 1;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final String zzk() {
        return this.zzh;
    }
}
