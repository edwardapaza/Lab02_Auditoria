package com.google.android.recaptcha.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzma {
    private static final zzlx zza;

    static {
        if (zzlv.zzx() && zzlv.zzy()) {
            int i5 = zzgi.zza;
        }
        zza = new zzly();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i5, int i6) {
        int i7 = i6 - i5;
        byte b5 = bArr[i5 - 1];
        if (i7 == 0) {
            if (b5 <= -12) {
                return b5;
            }
            return -1;
        } else if (i7 == 1) {
            byte b6 = bArr[i5];
            if (b5 > -12 || b6 > -65) {
                return -1;
            }
            return (b6 << 8) ^ b5;
        } else if (i7 == 2) {
            byte b7 = bArr[i5];
            byte b8 = bArr[i5 + 1];
            if (b5 > -12 || b7 > -65 || b8 > -65) {
                return -1;
            }
            return (b8 << 16) ^ ((b7 << 8) ^ b5);
        } else {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0101, code lost:
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzb(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzma.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        int i6 = 0;
        while (i6 < length && charSequence.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i6);
            if (charAt < 2048) {
                i7 += (127 - charAt) >>> 31;
                i6++;
            } else {
                int length2 = charSequence.length();
                while (i6 < length2) {
                    char charAt2 = charSequence.charAt(i6);
                    if (charAt2 < 2048) {
                        i5 += (127 - charAt2) >>> 31;
                    } else {
                        i5 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i6) < 65536) {
                                throw new zzlz(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i7 += i5;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i7 + 4294967296L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(byte[] bArr, int i5, int i6) {
        int length = bArr.length;
        if ((((length - i5) - i6) | i5 | i6) >= 0) {
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b5 = bArr[i5];
                if (!zzlw.zzd(b5)) {
                    break;
                }
                i5++;
                cArr[i8] = (char) b5;
                i8++;
            }
            while (i5 < i7) {
                int i9 = i5 + 1;
                byte b6 = bArr[i5];
                if (zzlw.zzd(b6)) {
                    int i10 = i8 + 1;
                    cArr[i8] = (char) b6;
                    i5 = i9;
                    while (true) {
                        i8 = i10;
                        if (i5 < i7) {
                            byte b7 = bArr[i5];
                            if (zzlw.zzd(b7)) {
                                i5++;
                                i10 = i8 + 1;
                                cArr[i8] = (char) b7;
                            }
                        }
                    }
                } else if (b6 < -32) {
                    if (i9 >= i7) {
                        throw zzje.zzd();
                    }
                    zzlw.zzc(b6, bArr[i9], cArr, i8);
                    i8++;
                    i5 = i9 + 1;
                } else if (b6 < -16) {
                    if (i9 >= i7 - 1) {
                        throw zzje.zzd();
                    }
                    int i11 = i9 + 1;
                    zzlw.zzb(b6, bArr[i9], bArr[i11], cArr, i8);
                    i8++;
                    i5 = i11 + 1;
                } else if (i9 >= i7 - 2) {
                    throw zzje.zzd();
                } else {
                    int i12 = i9 + 1;
                    byte b8 = bArr[i9];
                    int i13 = i12 + 1;
                    zzlw.zza(b6, b8, bArr[i12], bArr[i13], cArr, i8);
                    i8 += 2;
                    i5 = i13 + 1;
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i5), Integer.valueOf(i6)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzf(byte[] bArr, int i5, int i6) {
        return zza.zzb(bArr, i5, i6);
    }
}
