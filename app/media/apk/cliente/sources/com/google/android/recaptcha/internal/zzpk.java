package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzpk extends zzit implements zzkf {
    private static final zzpk zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzpk zzpkVar = new zzpk();
        zzb = zzpkVar;
        zzit.zzD(zzpk.class, zzpkVar);
    }

    private zzpk() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzH(zzpk zzpkVar, double d5) {
        zzpkVar.zzd = 10;
        zzpkVar.zze = Double.valueOf(d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzI(zzpk zzpkVar, String str) {
        str.getClass();
        zzpkVar.zzd = 11;
        zzpkVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzJ(zzpk zzpkVar, boolean z4) {
        zzpkVar.zzd = 1;
        zzpkVar.zze = Boolean.valueOf(z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzK(zzpk zzpkVar, zzgw zzgwVar) {
        zzpkVar.zzd = 2;
        zzpkVar.zze = zzgwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzL(zzpk zzpkVar, String str) {
        str.getClass();
        zzpkVar.zzd = 3;
        zzpkVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzM(zzpk zzpkVar, int i5) {
        zzpkVar.zzd = 4;
        zzpkVar.zze = Integer.valueOf(i5);
    }

    public static zzpj zzf() {
        return (zzpj) zzb.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzpk zzpkVar, int i5) {
        zzpkVar.zzd = 5;
        zzpkVar.zze = Integer.valueOf(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzpk zzpkVar, long j5) {
        zzpkVar.zzd = 7;
        zzpkVar.zze = Long.valueOf(j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzpk zzpkVar, float f5) {
        zzpkVar.zzd = 9;
        zzpkVar.zze = Float.valueOf(f5);
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
                    return new zzpj(null);
                }
                return new zzpk();
            }
            return zzit.zzA(zzb, "\u0000\u000b\u0001\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001:\u0000\u0002=\u0000\u0003Ȼ\u0000\u0004B\u0000\u0005B\u0000\u0006>\u0000\u0007C\u0000\b6\u0000\t4\u0000\n3\u0000\u000bȻ\u0000", new Object[]{"zze", "zzd"});
        }
        return (byte) 1;
    }
}
