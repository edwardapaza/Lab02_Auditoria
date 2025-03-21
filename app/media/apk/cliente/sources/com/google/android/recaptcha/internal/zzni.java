package com.google.android.recaptcha.internal;

import java.util.List;
/* loaded from: classes.dex */
public final class zzni extends zzit implements zzkf {
    private static final zzni zzb;
    private zzjb zzd = zzit.zzx();
    private zzjb zze = zzit.zzx();

    static {
        zzni zzniVar = new zzni();
        zzb = zzniVar;
        zzit.zzD(zzni.class, zzniVar);
    }

    private zzni() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzI(zzni zzniVar, zznf zznfVar) {
        zznfVar.getClass();
        zzjb zzjbVar = zzniVar.zzd;
        if (!zzjbVar.zzc()) {
            zzniVar.zzd = zzit.zzy(zzjbVar);
        }
        zzniVar.zzd.add(zznfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzJ(zzni zzniVar, zznu zznuVar) {
        zznuVar.getClass();
        zzjb zzjbVar = zzniVar.zze;
        if (!zzjbVar.zzc()) {
            zzniVar.zze = zzit.zzy(zzjbVar);
        }
        zzniVar.zze.add(zznuVar);
    }

    public static zznh zzi() {
        return (zznh) zzb.zzp();
    }

    public static zzni zzk(byte[] bArr) {
        return (zzni) zzit.zzu(zzb, bArr);
    }

    public final List zzH() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzd.size();
    }

    public final int zzg() {
        return this.zze.size();
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
                    return new zznh(null);
                }
                return new zzni();
            }
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zznf.class, "zze", zznu.class});
        }
        return (byte) 1;
    }
}
