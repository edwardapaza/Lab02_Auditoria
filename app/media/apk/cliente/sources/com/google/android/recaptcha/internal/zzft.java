package com.google.android.recaptcha.internal;

import java.math.RoundingMode;
import java.util.Arrays;
/* loaded from: classes.dex */
final class zzft {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzft(java.lang.String r10, char[] r11) {
        /*
            r9 = this;
            r0 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r0]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
            r4 = 0
        La:
            int r5 = r11.length
            if (r4 >= r5) goto L2b
            char r5 = r11[r4]
            r6 = 1
            if (r5 >= r0) goto L14
            r7 = 1
            goto L15
        L14:
            r7 = 0
        L15:
            java.lang.String r8 = "Non-ASCII character: %s"
            com.google.android.recaptcha.internal.zzff.zzc(r7, r8, r5)
            r7 = r1[r5]
            if (r7 != r2) goto L1f
            goto L20
        L1f:
            r6 = 0
        L20:
            java.lang.String r7 = "Duplicate character: %s"
            com.google.android.recaptcha.internal.zzff.zzc(r6, r7, r5)
            byte r6 = (byte) r4
            r1[r5] = r6
            int r4 = r4 + 1
            goto La
        L2b:
            r9.<init>(r10, r11, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzft.<init>(java.lang.String, char[]):void");
    }

    private zzft(String str, char[] cArr, byte[] bArr, boolean z4) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzb = zzga.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = zzb;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzb);
            int i5 = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i5;
            this.zzd = zzb >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i5];
            for (int i6 = 0; i6 < this.zzd; i6++) {
                zArr[zzga.zza(i6 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = false;
        } catch (ArithmeticException e5) {
            int length2 = cArr.length;
            throw new IllegalArgumentException("Illegal alphabet length " + length2, e5);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzft) {
            zzft zzftVar = (zzft) obj;
            boolean z4 = zzftVar.zzi;
            if (Arrays.equals(this.zzf, zzftVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + 1237;
    }

    public final String toString() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char zza(int i5) {
        return this.zzf[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(char c5) {
        if (c5 <= 127) {
            byte b5 = this.zzg[c5];
            if (b5 == -1) {
                if (c5 <= ' ' || c5 == 127) {
                    throw new zzfw("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c5))));
                }
                throw new zzfw("Unrecognized character: " + c5);
            }
            return b5;
        }
        throw new zzfw("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(int i5) {
        return this.zzh[i5 % this.zzc];
    }

    public final boolean zzd(char c5) {
        return this.zzg[61] != -1;
    }
}
