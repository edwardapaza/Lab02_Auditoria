package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaic  reason: invalid package */
/* loaded from: classes.dex */
public final class zzaic extends zzaib {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzaif zzm;

    private zzaic(InputStream inputStream, int i5) {
        super();
        this.zzl = a.e.API_PRIORITY_OTHER;
        this.zzm = null;
        zzajc.zza(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private static int zza(InputStream inputStream) {
        try {
            return inputStream.available();
        } catch (zzajj e5) {
            e5.zzj();
            throw e5;
        }
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i5, int i6) {
        try {
            return inputStream.read(bArr, i5, i6);
        } catch (zzajj e5) {
            e5.zzj();
            throw e5;
        }
    }

    private static long zza(InputStream inputStream, long j5) {
        try {
            return inputStream.skip(j5);
        } catch (zzajj e5) {
            e5.zzj();
            throw e5;
        }
    }

    private final byte[] zza(int i5, boolean z4) {
        byte[] zzj = zzj(i5);
        if (zzj != null) {
            return zzj;
        }
        int i6 = this.zzi;
        int i7 = this.zzg;
        int i8 = i7 - i6;
        this.zzk += i7;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzf = zzf(i5 - i8);
        byte[] bArr = new byte[i5];
        System.arraycopy(this.zzf, i6, bArr, 0, i8);
        for (byte[] bArr2 : zzf) {
            System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
            i8 += bArr2.length;
        }
        return bArr;
    }

    private final void zzaa() {
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

    private final List<byte[]> zzf(int i5) {
        ArrayList arrayList = new ArrayList();
        while (i5 > 0) {
            int min = Math.min(i5, 4096);
            byte[] bArr = new byte[min];
            int i6 = 0;
            while (i6 < min) {
                int read = this.zze.read(bArr, i6, min - i6);
                if (read == -1) {
                    throw zzajj.zzi();
                }
                this.zzk += read;
                i6 += read;
            }
            i5 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i5) {
        if (zzi(i5)) {
            return;
        }
        if (i5 <= (this.zzc - this.zzk) - this.zzi) {
            throw zzajj.zzi();
        }
        throw zzajj.zzh();
    }

    private final void zzh(int i5) {
        int i6 = this.zzg;
        int i7 = this.zzi;
        if (i5 <= i6 - i7 && i5 >= 0) {
            this.zzi = i7 + i5;
        } else if (i5 < 0) {
            throw zzajj.zzf();
        } else {
            int i8 = this.zzk;
            int i9 = i8 + i7 + i5;
            int i10 = this.zzl;
            if (i9 > i10) {
                zzh((i10 - i8) - i7);
                throw zzajj.zzi();
            }
            this.zzk = i8 + i7;
            int i11 = i6 - i7;
            this.zzg = 0;
            this.zzi = 0;
            while (i11 < i5) {
                try {
                    long j5 = i5 - i11;
                    long zza = zza(this.zze, j5);
                    int i12 = (zza > 0L ? 1 : (zza == 0L ? 0 : -1));
                    if (i12 >= 0 && zza <= j5) {
                        if (i12 == 0) {
                            break;
                        }
                        i11 += (int) zza;
                    } else {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
                    }
                } finally {
                    this.zzk += i11;
                    zzaa();
                }
            }
            if (i11 >= i5) {
                return;
            }
            int i13 = this.zzg;
            int i14 = i13 - this.zzi;
            this.zzi = i13;
            while (true) {
                zzg(1);
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

    private final boolean zzi(int i5) {
        do {
            int i6 = this.zzi;
            int i7 = i6 + i5;
            int i8 = this.zzg;
            if (i7 <= i8) {
                throw new IllegalStateException("refillBuffer() called when " + i5 + " bytes were already available in buffer");
            }
            int i9 = this.zzc;
            int i10 = this.zzk;
            if (i5 > (i9 - i10) - i6 || i10 + i6 + i5 > this.zzl) {
                return false;
            }
            if (i6 > 0) {
                if (i8 > i6) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
                }
                this.zzk += i6;
                this.zzg -= i6;
                this.zzi = 0;
            }
            InputStream inputStream = this.zze;
            byte[] bArr2 = this.zzf;
            int i11 = this.zzg;
            int zza = zza(inputStream, bArr2, i11, Math.min(bArr2.length - i11, (this.zzc - this.zzk) - i11));
            if (zza == 0 || zza < -1 || zza > this.zzf.length) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
            } else if (zza <= 0) {
                return false;
            } else {
                this.zzg += zza;
                zzaa();
            }
        } while (this.zzg < i5);
        return true;
    }

    private final byte[] zzj(int i5) {
        if (i5 == 0) {
            return zzajc.zzb;
        }
        if (i5 >= 0) {
            int i6 = this.zzk;
            int i7 = this.zzi;
            int i8 = i6 + i7 + i5;
            if (i8 - this.zzc <= 0) {
                int i9 = this.zzl;
                if (i8 > i9) {
                    zzh((i9 - i6) - i7);
                    throw zzajj.zzi();
                }
                int i10 = this.zzg - i7;
                int i11 = i5 - i10;
                if (i11 < 4096 || i11 <= zza(this.zze)) {
                    byte[] bArr = new byte[i5];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i10);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i10 < i5) {
                        int zza = zza(this.zze, bArr, i10, i5 - i10);
                        if (zza == -1) {
                            throw zzajj.zzi();
                        }
                        this.zzk += zza;
                        i10 += zza;
                    }
                    return bArr;
                }
                return null;
            }
            throw zzajj.zzh();
        }
        throw zzajj.zzf();
    }

    private final byte zzv() {
        if (this.zzi == this.zzg) {
            zzg(1);
        }
        byte[] bArr = this.zzf;
        int i5 = this.zzi;
        this.zzi = i5 + 1;
        return bArr[i5];
    }

    private final int zzw() {
        int i5 = this.zzi;
        if (this.zzg - i5 < 4) {
            zzg(4);
            i5 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i5 + 4;
        return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
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
            byte[] r2 = r5.zzf
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaic.zzx():int");
    }

    private final long zzy() {
        int i5 = this.zzi;
        if (this.zzg - i5 < 8) {
            zzg(8);
            i5 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i5 + 8;
        return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzaic.zzz():long");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final double zza() {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zza(int i5) {
        if (i5 >= 0) {
            int i6 = i5 + this.zzk + this.zzi;
            int i7 = this.zzl;
            if (i6 <= i7) {
                this.zzl = i6;
                zzaa();
                return i7;
            }
            throw zzajj.zzi();
        }
        throw zzajj.zzf();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final float zzb() {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final void zzb(int i5) {
        if (this.zzj != i5) {
            throw zzajj.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final int zzc() {
        return this.zzk + this.zzi;
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
                byte[] bArr = this.zzf;
                int i8 = this.zzi;
                this.zzi = i8 + 1;
                if (bArr[i8] < 0) {
                    i7++;
                }
            }
            throw zzajj.zze();
            return true;
        } else if (i6 == 1) {
            zzh(8);
            return true;
        } else if (i6 == 2) {
            zzh(zzx());
            return true;
        } else if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 5) {
                    zzh(4);
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
            this.zzj = 0;
            return 0;
        }
        int zzx = zzx();
        this.zzj = zzx;
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
        int zzx = zzx();
        int i5 = this.zzg;
        int i6 = this.zzi;
        if (zzx <= i5 - i6 && zzx > 0) {
            zzahm zza = zzahm.zza(this.zzf, i6, zzx);
            this.zzi += zzx;
            return zza;
        } else if (zzx == 0) {
            return zzahm.zza;
        } else {
            byte[] zzj = zzj(zzx);
            if (zzj != null) {
                return zzahm.zza(zzj);
            }
            int i7 = this.zzi;
            int i8 = this.zzg;
            int i9 = i8 - i7;
            this.zzk += i8;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzf = zzf(zzx - i9);
            byte[] bArr = new byte[zzx];
            System.arraycopy(this.zzf, i7, bArr, 0, i9);
            for (byte[] bArr2 : zzf) {
                System.arraycopy(bArr2, 0, bArr, i9, bArr2.length);
                i9 += bArr2.length;
            }
            return zzahm.zzb(bArr);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final String zzr() {
        int zzx = zzx();
        if (zzx > 0) {
            int i5 = this.zzg;
            int i6 = this.zzi;
            if (zzx <= i5 - i6) {
                String str = new String(this.zzf, i6, zzx, zzajc.zza);
                this.zzi += zzx;
                return str;
            }
        }
        if (zzx == 0) {
            return "";
        }
        if (zzx <= this.zzg) {
            zzg(zzx);
            String str2 = new String(this.zzf, this.zzi, zzx, zzajc.zza);
            this.zzi += zzx;
            return str2;
        }
        return new String(zza(zzx, false), zzajc.zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final String zzs() {
        byte[] zza;
        int zzx = zzx();
        int i5 = this.zzi;
        int i6 = this.zzg;
        if (zzx <= i6 - i5 && zzx > 0) {
            zza = this.zzf;
            this.zzi = i5 + zzx;
        } else if (zzx == 0) {
            return "";
        } else {
            if (zzx <= i6) {
                zzg(zzx);
                zza = this.zzf;
                this.zzi = zzx;
            } else {
                zza = zza(zzx, false);
            }
            i5 = 0;
        }
        return zzaml.zzb(zza, i5, zzx);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final boolean zzt() {
        return this.zzi == this.zzg && !zzi(1);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaib
    public final boolean zzu() {
        return zzz() != 0;
    }
}
