package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
final class zzfv extends zzfx {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzfv(java.lang.String r2, java.lang.String r3, java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.recaptcha.internal.zzft r0 = new com.google.android.recaptcha.internal.zzft
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = com.google.android.recaptcha.internal.zzft.zze(r0)
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            com.google.android.recaptcha.internal.zzff.zza(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfv.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    @Override // com.google.android.recaptcha.internal.zzfx, com.google.android.recaptcha.internal.zzfy
    final int zza(byte[] bArr, CharSequence charSequence) {
        CharSequence zze = zze(charSequence);
        if (!this.zzb.zzc(zze.length())) {
            int length = zze.length();
            throw new zzfw("Invalid input length " + length);
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < zze.length()) {
            int i7 = i5 + 1;
            int i8 = i6 + 1;
            int zzb = (this.zzb.zzb(zze.charAt(i5)) << 18) | (this.zzb.zzb(zze.charAt(i7)) << 12);
            bArr[i6] = (byte) (zzb >>> 16);
            int i9 = i7 + 1;
            if (i9 < zze.length()) {
                int i10 = i9 + 1;
                int zzb2 = zzb | (this.zzb.zzb(zze.charAt(i9)) << 6);
                i6 = i8 + 1;
                bArr[i8] = (byte) ((zzb2 >>> 8) & 255);
                if (i10 < zze.length()) {
                    bArr[i6] = (byte) ((zzb2 | this.zzb.zzb(zze.charAt(i10))) & 255);
                    i6++;
                    i5 = i10 + 1;
                } else {
                    i5 = i10;
                }
            } else {
                i5 = i9;
                i6 = i8;
            }
        }
        return i6;
    }

    @Override // com.google.android.recaptcha.internal.zzfx, com.google.android.recaptcha.internal.zzfy
    final void zzb(Appendable appendable, byte[] bArr, int i5, int i6) {
        int i7 = 0;
        zzff.zzd(0, i6, bArr.length);
        for (int i8 = i6; i8 >= 3; i8 -= 3) {
            int i9 = i7 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i7] & 255) << 16) | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
            appendable.append(this.zzb.zza(i11 >>> 18));
            appendable.append(this.zzb.zza((i11 >>> 12) & 63));
            appendable.append(this.zzb.zza((i11 >>> 6) & 63));
            appendable.append(this.zzb.zza(i11 & 63));
            i7 = i10 + 1;
        }
        if (i7 < i6) {
            zzf(appendable, bArr, i7, i6 - i7);
        }
    }
}
