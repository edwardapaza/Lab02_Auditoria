package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzox extends zzit implements zzkf {
    private static final zzox zzb;
    private int zzd;

    static {
        zzox zzoxVar = new zzox();
        zzb = zzoxVar;
        zzit.zzD(zzox.class, zzoxVar);
    }

    private zzox() {
    }

    public static zzox zzg(byte[] bArr) {
        return (zzox) zzit.zzu(zzb, bArr);
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
                        return zzb;
                    }
                    return new zzow(null);
                }
                return new zzox();
            }
            return zzit.zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzd"});
        }
        return (byte) 1;
    }

    public final zzpb zzi() {
        zzpb zzb2 = zzpb.zzb(this.zzd);
        return zzb2 == null ? zzpb.UNRECOGNIZED : zzb2;
    }
}
