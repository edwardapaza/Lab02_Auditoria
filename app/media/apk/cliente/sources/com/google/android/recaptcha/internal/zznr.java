package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zznr extends zzit implements zzkf {
    private static final zznr zzb;
    private int zzd;
    private zzmu zzf;
    private zzmo zzg;
    private zzmx zzh;
    private String zze = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zznr zznrVar = new zznr();
        zzb = zznrVar;
        zzit.zzD(zznr.class, zznrVar);
    }

    private zznr() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzH(zznr zznrVar, zzmo zzmoVar) {
        zzmoVar.getClass();
        zznrVar.zzg = zzmoVar;
        zznrVar.zzd |= 2;
    }

    public static zznq zzf() {
        return (zznq) zzb.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zznr zznrVar, String str) {
        str.getClass();
        zznrVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zznr zznrVar, String str) {
        str.getClass();
        zznrVar.zzi = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zznr zznrVar, String str) {
        str.getClass();
        zznrVar.zzj = str;
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
                    return new zznq(null);
                }
                return new zznr();
            }
            return zzit.zzA(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
