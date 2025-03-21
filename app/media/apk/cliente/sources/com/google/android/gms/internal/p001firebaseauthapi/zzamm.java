package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamm  reason: invalid package */
/* loaded from: classes.dex */
final class zzamm extends zzamn {
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamn
    final int zza(int i5, byte[] bArr, int i6, int i7) {
        while (i6 < i7 && bArr[i6] >= 0) {
            i6++;
        }
        if (i6 >= i7) {
            return 0;
        }
        while (i6 < i7) {
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            if (b5 < 0) {
                if (b5 < -32) {
                    if (i8 >= i7) {
                        return b5;
                    }
                    if (b5 >= -62) {
                        i6 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                } else if (b5 >= -16) {
                    if (i8 >= i7 - 2) {
                        return zzaml.zza(bArr, i8, i7);
                    }
                    int i9 = i8 + 1;
                    byte b6 = bArr[i8];
                    if (b6 <= -65 && (((b5 << 28) + (b6 + 112)) >> 30) == 0) {
                        int i10 = i9 + 1;
                        if (bArr[i9] <= -65) {
                            i8 = i10 + 1;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i8 >= i7 - 1) {
                    return zzaml.zza(bArr, i8, i7);
                } else {
                    int i11 = i8 + 1;
                    byte b7 = bArr[i8];
                    if (b7 <= -65 && ((b5 != -32 || b7 >= -96) && (b5 != -19 || b7 < -96))) {
                        i6 = i11 + 1;
                        if (bArr[i11] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i6 = i8;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzamm.zza(java.lang.String, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzamn
    public final String zza(byte[] bArr, int i5, int i6) {
        if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b5 = bArr[i5];
                if (!(b5 >= 0)) {
                    break;
                }
                i5++;
                zzamk.zza(b5, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 >= 0) {
                    int i11 = i9 + 1;
                    zzamk.zza(b6, cArr, i9);
                    while (i10 < i7) {
                        byte b7 = bArr[i10];
                        if (!(b7 >= 0)) {
                            break;
                        }
                        i10++;
                        zzamk.zza(b7, cArr, i11);
                        i11++;
                    }
                    i5 = i10;
                    i9 = i11;
                } else if (b6 < -32) {
                    if (i10 >= i7) {
                        throw zzajj.zzd();
                    }
                    zzamk.zza(b6, bArr[i10], cArr, i9);
                    i5 = i10 + 1;
                    i9++;
                } else if (b6 < -16) {
                    if (i10 >= i7 - 1) {
                        throw zzajj.zzd();
                    }
                    int i12 = i10 + 1;
                    zzamk.zza(b6, bArr[i10], bArr[i12], cArr, i9);
                    i5 = i12 + 1;
                    i9++;
                } else if (i10 >= i7 - 2) {
                    throw zzajj.zzd();
                } else {
                    int i13 = i10 + 1;
                    byte b8 = bArr[i10];
                    int i14 = i13 + 1;
                    zzamk.zza(b6, b8, bArr[i13], bArr[i14], cArr, i9);
                    i5 = i14 + 1;
                    i9 = i9 + 1 + 1;
                }
            }
            return new String(cArr, 0, i9);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
    }
}
