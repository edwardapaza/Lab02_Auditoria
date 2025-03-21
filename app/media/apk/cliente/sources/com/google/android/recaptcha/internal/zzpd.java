package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzpd extends zzit implements zzkf {
    private static final zzpd zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzpd zzpdVar = new zzpd();
        zzb = zzpdVar;
        zzit.zzD(zzpd.class, zzpdVar);
    }

    private zzpd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzH(zzpd zzpdVar, zznf zznfVar) {
        zznfVar.getClass();
        zzpdVar.zze = zznfVar;
        zzpdVar.zzd = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzI(zzpd zzpdVar, zznu zznuVar) {
        zznuVar.getClass();
        zzpdVar.zze = zznuVar;
        zzpdVar.zzd = 2;
    }

    public static zzpc zzi() {
        return (zzpc) zzb.zzp();
    }

    public static zzpd zzk(byte[] bArr) {
        return (zzpd) zzit.zzu(zzb, bArr);
    }

    public final int zzJ() {
        int i5 = this.zzd;
        if (i5 != 0) {
            int i6 = 1;
            if (i5 != 1) {
                i6 = 2;
                if (i5 != 2) {
                    return 0;
                }
            }
            return i6;
        }
        return 3;
    }

    public final zznf zzf() {
        return this.zzd == 1 ? (zznf) this.zze : zznf.zzH();
    }

    public final zznu zzg() {
        return this.zzd == 2 ? (zznu) this.zze : zznu.zzg();
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
                    return new zzpc(null);
                }
                return new zzpd();
            }
            return zzit.zzA(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zze", "zzd", zznf.class, zznu.class});
        }
        return (byte) 1;
    }
}
