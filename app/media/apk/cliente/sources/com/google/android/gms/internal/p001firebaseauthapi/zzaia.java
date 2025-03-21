package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaia  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaia extends zzaib {
    private final byte[] zze;
    private final boolean zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    private zzaia(byte[] bArr, int i5, int i6, boolean z4) {
        super();
        this.zzl = a.e.API_PRIORITY_OTHER;
        this.zze = bArr;
        this.zzg = i6 + i5;
        this.zzi = i5;
        this.zzj = i5;
        this.zzf = z4;
    }

    private final void zzaa() {
        int i5 = this.zzg + this.zzh;
        this.zzg = i5;
        int i6 = i5 - this.zzj;
        int i7 = this.zzl;
        if (i6 <= i7) {
            this.zzh = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzh = i8;
        this.zzg = i5 - i8;
    }

    private final void zzf(int i5) {
        if (i5 >= 0) {
            int i6 = this.zzg;
            int i7 = this.zzi;
            if (i5 <= i6 - i7) {
                this.zzi = i7 + i5;
                return;
            }
        }
        if (i5 >= 0) {
            throw zzajj.zzi();
        }
        throw zzajj.zzf();
    }

    private final byte zzv() {
        int i5 = this.zzi;
        if (i5 != this.zzg) {
            byte[] bArr = this.zze;
            this.zzi = i5 + 1;
            return bArr[i5];
        }
        throw zzajj.zzi();
    }

    private final int zzw() {
        int i5 = this.zzi;
        if (this.zzg - i5 >= 4) {
            byte[] bArr = this.zze;
            this.zzi = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }
        throw zzajj.zzi();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzx() {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 == r0) goto L6b
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.zzi = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.zzi = r1
            return r0
        L6b:
            long r0 = r5.zzm()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaia.zzx():int");
    }

    private final long zzy() {
        int i5 = this.zzi;
        if (this.zzg - i5 >= 8) {
            byte[] bArr = this.zze;
            this.zzi = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }
        throw zzajj.zzi();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r2[r0] >= 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzz() {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaia.zzz():long");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final double zza() {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zza(int i5) {
        if (i5 >= 0) {
            int zzc = i5 + zzc();
            if (zzc >= 0) {
                int i6 = this.zzl;
                if (zzc <= i6) {
                    this.zzl = zzc;
                    zzaa();
                    return i6;
                }
                throw zzajj.zzi();
            }
            throw zzajj.zzg();
        }
        throw zzajj.zzf();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final float zzb() {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final void zzb(int i5) {
        if (this.zzk != i5) {
            throw zzajj.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzc() {
        return this.zzi - this.zzj;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final void zzc(int i5) {
        this.zzl = i5;
        zzaa();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzd() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final boolean zzd(int i5) {
        int zzi;
        int i6 = i5 & 7;
        int i7 = 0;
        if (i6 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i7 < 10) {
                    if (zzv() < 0) {
                        i7++;
                    }
                }
                throw zzajj.zze();
            }
            while (i7 < 10) {
                byte[] bArr = this.zze;
                int i8 = this.zzi;
                this.zzi = i8 + 1;
                if (bArr[i8] < 0) {
                    i7++;
                }
            }
            throw zzajj.zze();
            return true;
        } else if (i6 == 1) {
            zzf(8);
            return true;
        } else if (i6 == 2) {
            zzf(zzx());
            return true;
        } else if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 5) {
                    zzf(4);
                    return true;
                }
                throw zzajj.zza();
            }
            return false;
        } else {
            do {
                zzi = zzi();
                if (zzi == 0) {
                    break;
                }
            } while (zzd(zzi));
            zzb(((i5 >>> 3) << 3) | 4);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zze() {
        return zzw();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzf() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzg() {
        return zzw();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzh() {
        return zzaib.zze(zzx());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzi() {
        if (zzt()) {
            this.zzk = 0;
            return 0;
        }
        int zzx = zzx();
        this.zzk = zzx;
        if ((zzx >>> 3) != 0) {
            return zzx;
        }
        throw zzajj.zzc();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzj() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final long zzk() {
        return zzy();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final long zzl() {
        return zzz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final long zzm() {
        long j5 = 0;
        for (int i5 = 0; i5 < 64; i5 += 7) {
            byte zzv = zzv();
            j5 |= (zzv & Byte.MAX_VALUE) << i5;
            if ((zzv & 128) == 0) {
                return j5;
            }
        }
        throw zzajj.zze();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final long zzn() {
        return zzy();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final long zzo() {
        return zzaib.zza(zzz());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final long zzp() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final zzahm zzq() {
        byte[] bArr;
        int zzx = zzx();
        if (zzx > 0) {
            int i5 = this.zzg;
            int i6 = this.zzi;
            if (zzx <= i5 - i6) {
                zzahm zza = zzahm.zza(this.zze, i6, zzx);
                this.zzi += zzx;
                return zza;
            }
        }
        if (zzx == 0) {
            return zzahm.zza;
        }
        if (zzx > 0) {
            int i7 = this.zzg;
            int i8 = this.zzi;
            if (zzx <= i7 - i8) {
                int i9 = zzx + i8;
                this.zzi = i9;
                bArr = Arrays.copyOfRange(this.zze, i8, i9);
                return zzahm.zzb(bArr);
            }
        }
        if (zzx <= 0) {
            if (zzx == 0) {
                bArr = zzajc.zzb;
                return zzahm.zzb(bArr);
            }
            throw zzajj.zzf();
        }
        throw zzajj.zzi();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final String zzr() {
        int zzx = zzx();
        if (zzx > 0) {
            int i5 = this.zzg;
            int i6 = this.zzi;
            if (zzx <= i5 - i6) {
                String str = new String(this.zze, i6, zzx, zzajc.zza);
                this.zzi += zzx;
                return str;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx < 0) {
            throw zzajj.zzf();
        }
        throw zzajj.zzi();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final String zzs() {
        int zzx = zzx();
        if (zzx > 0) {
            int i5 = this.zzg;
            int i6 = this.zzi;
            if (zzx <= i5 - i6) {
                String zzb = zzaml.zzb(this.zze, i6, zzx);
                this.zzi += zzx;
                return zzb;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx <= 0) {
            throw zzajj.zzf();
        }
        throw zzajj.zzi();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final boolean zzt() {
        return this.zzi == this.zzg;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final boolean zzu() {
        return zzz() != 0;
    }
}
