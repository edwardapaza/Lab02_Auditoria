package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgy extends zzhc {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgy(byte[] bArr, int i5, int i6, boolean z4, zzgx zzgxVar) {
        super(null);
        this.zzj = a.e.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzf = 0;
        this.zzh = 0;
    }

    private final void zzI() {
        int i5 = this.zzf + this.zzg;
        this.zzf = i5;
        int i6 = this.zzj;
        if (i5 <= i6) {
            this.zzg = 0;
            return;
        }
        int i7 = i5 - i6;
        this.zzg = i7;
        this.zzf = i5 - i7;
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final void zzA(int i5) {
        this.zzj = i5;
        zzI();
    }

    public final void zzB(int i5) {
        if (i5 >= 0) {
            int i6 = this.zzf;
            int i7 = this.zzh;
            if (i5 <= i6 - i7) {
                this.zzh = i7 + i5;
                return;
            }
        }
        if (i5 >= 0) {
            throw zzje.zzj();
        }
        throw zzje.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final boolean zzC() {
        return this.zzh == this.zzf;
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
            if (this.zzf - this.zzh < 10) {
                while (i7 < 10) {
                    if (zza() < 0) {
                        i7++;
                    }
                }
                throw zzje.zze();
            }
            while (i7 < 10) {
                byte[] bArr = this.zze;
                int i8 = this.zzh;
                this.zzh = i8 + 1;
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
        int i5 = this.zzh;
        if (i5 != this.zzf) {
            byte[] bArr = this.zze;
            this.zzh = i5 + 1;
            return bArr[i5];
        }
        throw zzje.zzj();
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
        return this.zzh;
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final int zze(int i5) {
        if (i5 >= 0) {
            int i6 = i5 + this.zzh;
            if (i6 >= 0) {
                int i7 = this.zzj;
                if (i6 <= i7) {
                    this.zzj = i6;
                    zzI();
                    return i7;
                }
                throw zzje.zzj();
            }
            throw zzje.zzg();
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
        int i5 = this.zzh;
        if (this.zzf - i5 >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i5 + 4;
            int i6 = (bArr[i5 + 1] & 255) << 8;
            return ((bArr[i5 + 3] & 255) << 24) | i6 | (bArr[i5] & 255) | ((bArr[i5 + 2] & 255) << 16);
        }
        throw zzje.zzj();
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
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzh = r3
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
            r5.zzh = r1
            return r0
        L6d:
            long r0 = r5.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgy.zzj():int");
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
            this.zzi = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzi = zzj;
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
        int i5 = this.zzh;
        if (this.zzf - i5 >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i5 + 8;
            long j5 = bArr[i5 + 2];
            long j6 = bArr[i5 + 3];
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }
        throw zzje.zzj();
    }

    public final long zzr() {
        long j5;
        long j6;
        long j7;
        long j8;
        int i5;
        int i6 = this.zzh;
        int i7 = this.zzf;
        if (i7 != i6) {
            byte[] bArr = this.zze;
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            if (b5 >= 0) {
                this.zzh = i8;
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
                                                    this.zzh = i9;
                                                    return j6;
                                                }
                                            }
                                        }
                                    }
                                }
                                j6 = j7 ^ j10;
                                i9 = i14;
                                this.zzh = i9;
                                return j6;
                            }
                            j8 = 266354560;
                            j5 = j9 ^ j8;
                        }
                    }
                    i9 = i11;
                    j6 = j5;
                    this.zzh = i9;
                    return j6;
                }
                i5 = i10 ^ (-128);
                j6 = i5;
                this.zzh = i9;
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
        if (zzj > 0) {
            int i5 = this.zzf;
            int i6 = this.zzh;
            if (zzj <= i5 - i6) {
                zzgw zzm = zzgw.zzm(this.zze, i6, zzj);
                this.zzh += zzj;
                return zzm;
            }
        }
        if (zzj != 0) {
            if (zzj > 0) {
                int i7 = this.zzf;
                int i8 = this.zzh;
                if (zzj <= i7 - i8) {
                    int i9 = zzj + i8;
                    this.zzh = i9;
                    return new zzgt(Arrays.copyOfRange(this.zze, i8, i9));
                }
            }
            if (zzj <= 0) {
                throw zzje.zzf();
            }
            throw zzje.zzj();
        }
        return zzgw.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final String zzx() {
        int zzj = zzj();
        if (zzj > 0) {
            int i5 = this.zzf;
            int i6 = this.zzh;
            if (zzj <= i5 - i6) {
                String str = new String(this.zze, i6, zzj, zzjc.zzb);
                this.zzh += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj < 0) {
            throw zzje.zzf();
        }
        throw zzje.zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final String zzy() {
        int zzj = zzj();
        if (zzj > 0) {
            int i5 = this.zzf;
            int i6 = this.zzh;
            if (zzj <= i5 - i6) {
                String zzd = zzma.zzd(this.zze, i6, zzj);
                this.zzh += zzj;
                return zzd;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= 0) {
            throw zzje.zzf();
        }
        throw zzje.zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzhc
    public final void zzz(int i5) {
        if (this.zzi != i5) {
            throw zzje.zzb();
        }
    }
}
