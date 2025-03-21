package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahm  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzahm implements Serializable, Iterable<Byte> {
    public static final zzahm zza = new zzahw(zzajc.zzb);
    private static final zzaht zzb = new zzahz();
    private static final Comparator<zzahm> zzc = new zzaho();
    private int zzd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(byte b5) {
        return b5 & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, int i6, int i7) {
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

    public static zzahm zza(String str) {
        return new zzahw(str.getBytes(zzajc.zza));
    }

    public static zzahm zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzahm zza(byte[] bArr, int i5, int i6) {
        zza(i5, i5 + i6, bArr.length);
        return new zzahw(zzb.zza(bArr, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzahm zzb(byte[] bArr) {
        return new zzahw(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzahv zzc(int i5) {
        return new zzahv(i5);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i5 = this.zzd;
        if (i5 == 0) {
            int zzb2 = zzb();
            i5 = zzb(zzb2, 0, zzb2);
            if (i5 == 0) {
                i5 = 1;
            }
            this.zzd = i5;
        }
        return i5;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzahp(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzalx.zza(this);
        } else {
            str = zzalx.zza(zza(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i5);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zza() {
        return this.zzd;
    }

    public abstract zzahm zza(int i5, int i6);

    protected abstract String zza(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(zzahn zzahnVar);

    protected abstract void zza(byte[] bArr, int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i5);

    public abstract int zzb();

    protected abstract int zzb(int i5, int i6, int i7);

    public abstract zzaib zzc();

    public final String zzd() {
        return zzb() == 0 ? "" : zza(zzajc.zza);
    }

    public final boolean zze() {
        return zzb() == 0;
    }

    public abstract boolean zzf();

    public final byte[] zzg() {
        int zzb2 = zzb();
        if (zzb2 == 0) {
            return zzajc.zzb;
        }
        byte[] bArr = new byte[zzb2];
        zza(bArr, 0, 0, zzb2);
        return bArr;
    }
}
