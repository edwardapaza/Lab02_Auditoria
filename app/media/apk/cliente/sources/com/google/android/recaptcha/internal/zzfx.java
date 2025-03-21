package com.google.android.recaptcha.internal;

import java.math.RoundingMode;
/* loaded from: classes.dex */
class zzfx extends zzfy {
    final zzft zzb;
    final Character zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfx(zzft zzftVar, Character ch) {
        this.zzb = zzftVar;
        if (ch != null) {
            ch.charValue();
            if (zzftVar.zzd('=')) {
                throw new IllegalArgumentException(zzfi.zza("Padding character %s was already in alphabet", ch));
            }
        }
        this.zzc = ch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfx(String str, String str2, Character ch) {
        this(new zzft(str, str2.toCharArray()), ch);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfx) {
            zzfx zzfxVar = (zzfx) obj;
            if (this.zzb.equals(zzfxVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzfxVar.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return (ch == null ? 0 : ch.hashCode()) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                str = ".omitPadding()";
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                str = "')";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    @Override // com.google.android.recaptcha.internal.zzfy
    int zza(byte[] bArr, CharSequence charSequence) {
        zzft zzftVar;
        CharSequence zze = zze(charSequence);
        if (!this.zzb.zzc(zze.length())) {
            throw new zzfw("Invalid input length " + zze.length());
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < zze.length()) {
            long j5 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                zzftVar = this.zzb;
                if (i7 >= zzftVar.zzc) {
                    break;
                }
                j5 <<= zzftVar.zzb;
                if (i5 + i7 < zze.length()) {
                    j5 |= this.zzb.zzb(zze.charAt(i8 + i5));
                    i8++;
                }
                i7++;
            }
            int i9 = zzftVar.zzd;
            int i10 = i8 * zzftVar.zzb;
            int i11 = (i9 - 1) * 8;
            while (i11 >= (i9 * 8) - i10) {
                bArr[i6] = (byte) ((j5 >>> i11) & 255);
                i11 -= 8;
                i6++;
            }
            i5 += this.zzb.zzc;
        }
        return i6;
    }

    @Override // com.google.android.recaptcha.internal.zzfy
    void zzb(Appendable appendable, byte[] bArr, int i5, int i6) {
        int i7 = 0;
        zzff.zzd(0, i6, bArr.length);
        while (i7 < i6) {
            zzf(appendable, bArr, i7, Math.min(this.zzb.zzd, i6 - i7));
            i7 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzfy
    final int zzc(int i5) {
        return (int) (((this.zzb.zzb * i5) + 7) / 8);
    }

    @Override // com.google.android.recaptcha.internal.zzfy
    final int zzd(int i5) {
        zzft zzftVar = this.zzb;
        return zzftVar.zzc * zzga.zza(i5, zzftVar.zzd, RoundingMode.CEILING);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzfy
    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(Appendable appendable, byte[] bArr, int i5, int i6) {
        zzff.zzd(i5, i5 + i6, bArr.length);
        int i7 = 0;
        zzff.zza(i6 <= this.zzb.zzd);
        long j5 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            j5 = (j5 | (bArr[i5 + i8] & 255)) << 8;
        }
        int i9 = (i6 + 1) * 8;
        zzft zzftVar = this.zzb;
        while (i7 < i6 * 8) {
            long j6 = j5 >>> ((i9 - zzftVar.zzb) - i7);
            zzft zzftVar2 = this.zzb;
            appendable.append(zzftVar2.zza(zzftVar2.zza & ((int) j6)));
            i7 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i7 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i7 += this.zzb.zzb;
            }
        }
    }
}
