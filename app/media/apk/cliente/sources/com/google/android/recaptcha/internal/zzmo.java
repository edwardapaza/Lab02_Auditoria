package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzmo extends zzit implements zzkf {
    private static final zziz zzb = new zzmm();
    private static final zzmo zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zziy zzk = zzit.zzv();

    static {
        zzmo zzmoVar = new zzmo();
        zzd = zzmoVar;
        zzit.zzD(zzmo.class, zzmoVar);
    }

    private zzmo() {
    }

    public static /* synthetic */ void zzH(zzmo zzmoVar, String str) {
        str.getClass();
        zzmoVar.zzf = str;
    }

    public static /* synthetic */ void zzJ(zzmo zzmoVar, String str) {
        str.getClass();
        zzmoVar.zzh = str;
    }

    public static zzmn zzf() {
        return (zzmn) zzd.zzp();
    }

    public static /* synthetic */ void zzj(zzmo zzmoVar, String str) {
        str.getClass();
        zzmoVar.zzi = str;
    }

    public static /* synthetic */ void zzk(zzmo zzmoVar, String str) {
        str.getClass();
        zzmoVar.zzj = str;
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
                        return zzd;
                    }
                    return new zzmn(null);
                }
                return new zzmo();
            }
            return zzit.zzA(zzd, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007,", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }
}
