package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzha extends zzhc {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzha(InputStream inputStream, int i5, zzgz zzgzVar) {
        super(null);
        this.zzl = a.e.API_PRIORITY_OTHER;
        byte[] bArr = zzjc.zzd;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i5) {
        ArrayList arrayList = new ArrayList();
        while (i5 > 0) {
            int min = Math.min(i5, 4096);
            byte[] bArr = new byte[min];
            int i6 = 0;
            while (i6 < min) {
                int read = this.zze.read(bArr, i6, min - i6);
                if (read == -1) {
                    throw zzje.zzj();
                }
                this.zzk += read;
                i6 += read;
            }
            i5 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i5 = this.zzg + this.zzh;
        this.zzg = i5;
        int i6 = this.zzk + i5;
        int i7 = this.zzl;
        if (i6 <= i7) {
            this.zzh = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzh = i8;
        this.zzg = i5 - i8;
    }

    private final void zzK(int i5) {
        if (zzL(i5)) {
            return;
        }
        if (i5 <= (a.e.API_PRIORITY_OTHER - this.zzk) - this.zzi) {
            throw zzje.zzj();
        }
        throw zzje.zzi();
    }

    private final boolean zzL(int i5) {
        int i6 = this.zzi;
        int i7 = i6 + i5;
        int i8 = this.zzg;
        if (i7 <= i8) {
            throw new IllegalStateException("refillBuffer() called when " + i5 + " bytes were already available in buffer");
        }
        int i9 = this.zzk;
        if (i5 <= (a.e.API_PRIORITY_OTHER - i9) - i6 && i9 + i6 + i5 <= this.zzl) {
            if (i6 > 0) {
                if (i8 > i6) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
                }
                i9 = this.zzk + i6;
                this.zzk = i9;
                i8 = this.zzg - i6;
                this.zzg = i8;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i8, Math.min(4096 - i8, (a.e.API_PRIORITY_OTHER - i9) - i8));
                if (read == 0 || read < -1 || read > 4096) {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.zzg += read;
                    zzJ();
                    if (this.zzg >= i5) {
                        return true;
                    }
                    return zzL(i5);
                } else {
                    return false;
                }
            } catch (zzje e5) {
                e5.zzk();
                throw e5;
            }
        }
        return false;
    }

    private final byte[] zzM(int i5, boolean z4) {
        byte[] zzN = zzN(i5);
        if (zzN != null) {
            return zzN;
        }
        int i6 = this.zzi;
        int i7 = this.zzg;
        int i8 = i7 - i6;
        this.zzk += i7;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzI = zzI(i5 - i8);
        byte[] bArr = new byte[i5];
        System.arraycopy(this.zzf, i6, bArr, 0, i8);
        for (byte[] bArr2 : zzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i8, length);
            i8 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i5) {
        if (i5 == 0) {
            return zzjc.zzd;
        }
        if (i5 >= 0) {
            int i6 = this.zzk;
            int i7 = this.zzi;
            int i8 = i6 + i7 + i5;
            if ((-2147483647) + i8 <= 0) {
                int i9 = this.zzl;
                if (i8 > i9) {
                    zzB((i9 - i6) - i7);
                    throw zzje.zzj();
                }
                int i10 = this.zzg - i7;
                int i11 = i5 - i10;
                if (i11 >= 4096) {
                    try {
                        if (i11 > this.zze.available()) {
                            return null;
                        }
                    } catch (zzje e5) {
                        e5.zzk();
                        throw e5;
                    }
                }
                byte[] bArr = new byte[i5];
                System.arraycopy(this.zzf, this.zzi, bArr, 0, i10);
                this.zzk += this.zzg;
                this.zzi = 0;
                this.zzg = 0;
                while (i10 < i5) {
                    try {
                        int read = this.zze.read(bArr, i10, i5 - i10);
                        if (read == -1) {
                            throw zzje.zzj();
                        }
                        this.zzk += read;
                        i10 += read;
                    } catch (zzje e6) {
                        e6.zzk();
                        throw e6;
                    }
                }
                return bArr;
            }
            throw zzje.zzi();
        }
        throw zzje.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final void zzA(int i5) {
        this.zzl = i5;
        zzJ();
    }

    public final void zzB(int i5) {
        int i6 = this.zzg;
        int i7 = this.zzi;
        int i8 = i6 - i7;
        if (i5 <= i8 && i5 >= 0) {
            this.zzi = i7 + i5;
        } else if (i5 < 0) {
            throw zzje.zzf();
        } else {
            int i9 = this.zzk;
            int i10 = i9 + i7;
            int i11 = this.zzl;
            if (i10 + i5 > i11) {
                zzB((i11 - i9) - i7);
                throw zzje.zzj();
            }
            this.zzk = i10;
            this.zzg = 0;
            this.zzi = 0;
            while (i8 < i5) {
                try {
                    long j5 = i5 - i8;
                    try {
                        long skip = this.zze.skip(j5);
                        int i12 = (skip > 0L ? 1 : (skip == 0L ? 0 : -1));
                        if (i12 < 0 || skip > j5) {
                            throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        } else if (i12 == 0) {
                            break;
                        } else {
                            i8 += (int) skip;
                        }
                    } catch (zzje e5) {
                        e5.zzk();
                        throw e5;
                    }
                } finally {
                    this.zzk += i8;
                    zzJ();
                }
            }
            if (i8 >= i5) {
                return;
            }
            int i13 = this.zzg;
            int i14 = i13 - this.zzi;
            this.zzi = i13;
            while (true) {
                zzK(1);
                int i15 = i5 - i14;
                int i16 = this.zzg;
                if (i15 <= i16) {
                    this.zzi = i15;
                    return;
                } else {
                    i14 += i16;
                    this.zzi = i16;
                }
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final boolean zzC() {
        return this.zzi == this.zzg && !zzL(1);
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final boolean zzD() {
        return zzr() != 0;
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final boolean zzE(int i5) {
        int zzm;
        int i6 = i5 & 7;
        int i7 = 0;
        if (i6 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i7 < 10) {
                    if (zza() < 0) {
                        i7++;
                    }
                }
                throw zzje.zze();
            }
            while (i7 < 10) {
                byte[] bArr = this.zzf;
                int i8 = this.zzi;
                this.zzi = i8 + 1;
                if (bArr[i8] < 0) {
                    i7++;
                }
            }
            throw zzje.zze();
            return true;
        } else if (i6 == 1) {
            zzB(8);
            return true;
        } else if (i6 == 2) {
            zzB(zzj());
            return true;
        } else if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 5) {
                    zzB(4);
                    return true;
                }
                throw zzje.zza();
            }
            return false;
        } else {
            do {
                zzm = zzm();
                if (zzm == 0) {
                    break;
                }
            } while (zzE(zzm));
            zzz(((i5 >>> 3) << 3) | 4);
            return true;
        }
    }

    public final byte zza() {
        if (this.zzi == this.zzg) {
            zzK(1);
        }
        byte[] bArr = this.zzf;
        int i5 = this.zzi;
        this.zzi = i5 + 1;
        return bArr[i5];
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final double zzb() {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final float zzc() {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzd() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zze(int i5) {
        if (i5 >= 0) {
            int i6 = this.zzk + this.zzi;
            int i7 = this.zzl;
            int i8 = i5 + i6;
            if (i8 <= i7) {
                this.zzl = i8;
                zzJ();
                return i7;
            }
            throw zzje.zzj();
        }
        throw zzje.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzf() {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzg() {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzh() {
        return zzj();
    }

    public final int zzi() {
        int i5 = this.zzi;
        if (this.zzg - i5 < 4) {
            zzK(4);
            i5 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i5 + 4;
        int i6 = (bArr[i5 + 1] & 255) << 8;
        return ((bArr[i5 + 3] & 255) << 24) | i6 | (bArr[i5] & 255) | ((bArr[i5 + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzj() {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzi = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6d
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L6a
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L6a
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L6a
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L6a
            goto L6d
        L6a:
            r5.zzi = r1
            return r0
        L6d:
            long r0 = r5.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzha.zzj():int");
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzk() {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzl() {
        return zzhc.zzF(zzj());
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzm() {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzj = zzj;
        if ((zzj >>> 3) != 0) {
            return zzj;
        }
        throw zzje.zzc();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zzn() {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final long zzo() {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final long zzp() {
        return zzr();
    }

    public final long zzq() {
        int i5 = this.zzi;
        if (this.zzg - i5 < 8) {
            zzK(8);
            i5 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i5 + 8;
        long j5 = bArr[i5 + 2];
        long j6 = bArr[i5 + 3];
        return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
    }

    public final long zzr() {
        long j5;
        long j6;
        long j7;
        long j8;
        int i5;
        int i6 = this.zzi;
        int i7 = this.zzg;
        if (i7 != i6) {
            byte[] bArr = this.zzf;
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            if (b5 >= 0) {
                this.zzi = i8;
                return b5;
            } else if (i7 - i8 >= 9) {
                int i9 = i8 + 1;
                int i10 = b5 ^ (bArr[i8] << 7);
                if (i10 >= 0) {
                    int i11 = i9 + 1;
                    int i12 = i10 ^ (bArr[i9] << 14);
                    if (i12 >= 0) {
                        j5 = i12 ^ 16256;
                    } else {
                        i9 = i11 + 1;
                        int i13 = i12 ^ (bArr[i11] << 21);
                        if (i13 < 0) {
                            i5 = i13 ^ (-2080896);
                        } else {
                            i11 = i9 + 1;
                            long j9 = i13 ^ (bArr[i9] << 28);
                            if (j9 < 0) {
                                int i14 = i11 + 1;
                                long j10 = j9 ^ (bArr[i11] << 35);
                                if (j10 < 0) {
                                    j7 = -34093383808L;
                                } else {
                                    i11 = i14 + 1;
                                    j9 = j10 ^ (bArr[i14] << 42);
                                    if (j9 >= 0) {
                                        j8 = 4363953127296L;
                                    } else {
                                        i14 = i11 + 1;
                                        j10 = j9 ^ (bArr[i11] << 49);
                                        if (j10 < 0) {
                                            j7 = -558586000294016L;
                                        } else {
                                            i11 = i14 + 1;
                                            j5 = (j10 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                            if (j5 < 0) {
                                                i14 = i11 + 1;
                                                if (bArr[i11] >= 0) {
                                                    j6 = j5;
                                                    i9 = i14;
                                                    this.zzi = i9;
                                                    return j6;
                                                }
                                            }
                                        }
                                    }
                                }
                                j6 = j7 ^ j10;
                                i9 = i14;
                                this.zzi = i9;
                                return j6;
                            }
                            j8 = 266354560;
                            j5 = j9 ^ j8;
                        }
                    }
                    i9 = i11;
                    j6 = j5;
                    this.zzi = i9;
                    return j6;
                }
                i5 = i10 ^ (-128);
                j6 = i5;
                this.zzi = i9;
                return j6;
            }
        }
        return zzs();
    }

    final long zzs() {
        long j5 = 0;
        for (int i5 = 0; i5 < 64; i5 += 7) {
            byte zza = zza();
            j5 |= (zza & Byte.MAX_VALUE) << i5;
            if ((zza & 128) == 0) {
                return j5;
            }
        }
        throw zzje.zze();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final long zzt() {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final long zzu() {
        return zzhc.zzG(zzr());
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final long zzv() {
        return zzr();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final zzgw zzw() {
        int zzj = zzj();
        int i5 = this.zzg;
        int i6 = this.zzi;
        if (zzj <= i5 - i6 && zzj > 0) {
            zzgw zzm = zzgw.zzm(this.zzf, i6, zzj);
            this.zzi += zzj;
            return zzm;
        } else if (zzj != 0) {
            byte[] zzN = zzN(zzj);
            if (zzN != null) {
                return zzgw.zzm(zzN, 0, zzN.length);
            }
            int i7 = this.zzi;
            int i8 = this.zzg;
            int i9 = i8 - i7;
            this.zzk += i8;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzI = zzI(zzj - i9);
            byte[] bArr = new byte[zzj];
            System.arraycopy(this.zzf, i7, bArr, 0, i9);
            for (byte[] bArr2 : zzI) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i9, length);
                i9 += length;
            }
            return new zzgt(bArr);
        } else {
            return zzgw.zzb;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final String zzx() {
        int zzj = zzj();
        if (zzj > 0) {
            int i5 = this.zzg;
            int i6 = this.zzi;
            if (zzj <= i5 - i6) {
                String str = new String(this.zzf, i6, zzj, zzjc.zzb);
                this.zzi += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= this.zzg) {
            zzK(zzj);
            String str2 = new String(this.zzf, this.zzi, zzj, zzjc.zzb);
            this.zzi += zzj;
            return str2;
        }
        return new String(zzM(zzj, false), zzjc.zzb);
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final String zzy() {
        byte[] zzM;
        int zzj = zzj();
        int i5 = this.zzi;
        int i6 = this.zzg;
        if (zzj <= i6 - i5 && zzj > 0) {
            zzM = this.zzf;
            this.zzi = i5 + zzj;
        } else if (zzj == 0) {
            return "";
        } else {
            if (zzj <= i6) {
                zzK(zzj);
                zzM = this.zzf;
                this.zzi = zzj;
            } else {
                zzM = zzM(zzj, false);
            }
            i5 = 0;
        }
        return zzma.zzd(zzM, i5, zzj);
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final void zzz(int i5) {
        if (this.zzj != i5) {
            throw zzje.zzb();
        }
    }
}
