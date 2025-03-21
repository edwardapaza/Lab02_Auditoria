package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzfu extends zzfx {
    final char[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzfu(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            com.google.android.recaptcha.internal.zzft r4 = new com.google.android.recaptcha.internal.zzft
            java.lang.String r5 = "0123456789ABCDEF"
            char[] r5 = r5.toCharArray()
            java.lang.String r0 = "base16()"
            r4.<init>(r0, r5)
            r5 = 0
            r3.<init>(r4, r5)
            r5 = 512(0x200, float:7.175E-43)
            char[] r5 = new char[r5]
            r3.zza = r5
            char[] r5 = com.google.android.recaptcha.internal.zzft.zze(r4)
            int r5 = r5.length
            r0 = 0
            r1 = 16
            if (r5 != r1) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            com.google.android.recaptcha.internal.zzff.zza(r5)
        L27:
            r5 = 256(0x100, float:3.59E-43)
            if (r0 >= r5) goto L44
            char[] r5 = r3.zza
            int r1 = r0 >>> 4
            char r1 = r4.zza(r1)
            r5[r0] = r1
            char[] r5 = r3.zza
            r1 = r0 | 256(0x100, float:3.59E-43)
            r2 = r0 & 15
            char r2 = r4.zza(r2)
            r5[r1] = r2
            int r0 = r0 + 1
            goto L27
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfu.<init>(java.lang.String, java.lang.String):void");
    }

    @Override // com.google.android.recaptcha.internal.zzfx, com.google.android.recaptcha.internal.zzfy
    final int zza(byte[] bArr, CharSequence charSequence) {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            throw new zzfw("Invalid input length " + length);
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            bArr[i6] = (byte) ((this.zzb.zzb(charSequence.charAt(i5)) << 4) | this.zzb.zzb(charSequence.charAt(i5 + 1)));
            i5 += 2;
            i6++;
        }
        return i6;
    }

    @Override // com.google.android.recaptcha.internal.zzfx, com.google.android.recaptcha.internal.zzfy
    final void zzb(Appendable appendable, byte[] bArr, int i5, int i6) {
        zzff.zzd(0, i6, bArr.length);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = bArr[i7] & 255;
            appendable.append(this.zza[i8]);
            appendable.append(this.zza[i8 | 256]);
        }
    }
}
