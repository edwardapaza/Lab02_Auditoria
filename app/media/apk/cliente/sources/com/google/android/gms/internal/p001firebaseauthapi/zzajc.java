package com.google.android.gms.internal.p001firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajc  reason: invalid package */
/* loaded from: classes.dex */
public final class zzajc {
    public static final byte[] zzb;
    private static final ByteBuffer zze;
    private static final zzaib zzf;
    private static final Charset zzc = Charset.forName("US-ASCII");
    static final Charset zza = Charset.forName("UTF-8");
    private static final Charset zzd = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zze = ByteBuffer.wrap(bArr);
        zzf = zzaib.zza(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    public static int zza(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static int zza(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t5) {
        t5.getClass();
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zzakk zzakkVar) {
        if (zzakkVar instanceof zzahe) {
            zzahe zzaheVar = (zzahe) zzakkVar;
            return false;
        }
        return false;
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static boolean zzc(byte[] bArr) {
        return zzaml.zza(bArr);
    }
}
