package com.google.android.recaptcha.internal;

import java.io.IOException;
/* loaded from: classes.dex */
public abstract class zzfy {
    private static final zzfy zza = new zzfv("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzfy zzb = new zzfv("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzfy zzc = new zzfx("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzfy zzd = new zzfx("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzfy zze = new zzfu("base16()", "0123456789ABCDEF");

    public static zzfy zzg() {
        return zza;
    }

    public static zzfy zzh() {
        return zzb;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence);

    abstract void zzb(Appendable appendable, byte[] bArr, int i5, int i6);

    abstract int zzc(int i5);

    abstract int zzd(int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence zze(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i5, int i6) {
        zzff.zzd(0, i6, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i6));
        try {
            zzb(sb, bArr, 0, i6);
            return sb.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence zze2 = zze(charSequence);
            int zzc2 = zzc(zze2.length());
            byte[] bArr = new byte[zzc2];
            int zza2 = zza(bArr, zze2);
            if (zza2 == zzc2) {
                return bArr;
            }
            byte[] bArr2 = new byte[zza2];
            System.arraycopy(bArr, 0, bArr2, 0, zza2);
            return bArr2;
        } catch (zzfw e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
