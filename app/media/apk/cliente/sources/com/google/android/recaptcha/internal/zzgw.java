package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes.dex */
public abstract class zzgw implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzgw zzb = new zzgt(zzjc.zzd);
    private static final zzgv zzd;
    private int zzc = 0;

    static {
        int i5 = zzgi.zza;
        zzd = new zzgv(null);
        zza = new zzgo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) < 0) {
            if (i5 < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
            } else if (i6 < i5) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
            } else {
                throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
            }
        }
        return i8;
    }

    public static zzgw zzm(byte[] bArr, int i5, int i6) {
        zzk(i5, i5 + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return new zzgt(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i5 = this.zzc;
        if (i5 == 0) {
            int zzd2 = zzd();
            i5 = zzf(zzd2, 0, zzd2);
            if (i5 == 0) {
                i5 = 1;
            }
            this.zzc = i5;
        }
        return i5;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgn(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzlg.zza(this) : zzlg.zza(zzg(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i5);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i5, int i6, int i7);

    protected abstract int zzf(int i5, int i6, int i7);

    public abstract zzgw zzg(int i5, int i6);

    protected abstract String zzh(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzi(zzgm zzgmVar);

    public abstract boolean zzj();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzl() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        return zzd() == 0 ? "" : zzh(charset);
    }

    public final byte[] zzo() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzjc.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }
}
