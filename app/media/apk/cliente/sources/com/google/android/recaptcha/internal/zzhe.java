package com.google.android.recaptcha.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhe extends zzhh {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhe(byte[] bArr, int i5, int i6) {
        super(null);
        int length = bArr.length;
        if (((length - i6) | i6) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i6)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i6;
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzb(byte b5) {
        try {
            byte[] bArr = this.zzc;
            int i5 = this.zze;
            this.zze = i5 + 1;
            bArr[i5] = b5;
        } catch (IndexOutOfBoundsException e5) {
            throw new zzhf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
        }
    }

    public final void zzc(byte[] bArr, int i5, int i6) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i6);
            this.zze += i6;
        } catch (IndexOutOfBoundsException e5) {
            throw new zzhf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i6)), e5);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzd(int i5, boolean z4) {
        zzq(i5 << 3);
        zzb(z4 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zze(int i5, zzgw zzgwVar) {
        zzq((i5 << 3) | 2);
        zzq(zzgwVar.zzd());
        zzgwVar.zzi(this);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzf(int i5, int i6) {
        zzq((i5 << 3) | 5);
        zzg(i6);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzg(int i5) {
        try {
            byte[] bArr = this.zzc;
            int i6 = this.zze;
            int i7 = i6 + 1;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.zze = i9 + 1;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzhf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzh(int i5, long j5) {
        zzq((i5 << 3) | 1);
        zzi(j5);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzi(long j5) {
        try {
            byte[] bArr = this.zzc;
            int i5 = this.zze;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) j5) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j5 >> 16)) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j5 >> 24)) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
            this.zze = i12 + 1;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzhf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzj(int i5, int i6) {
        zzq(i5 << 3);
        zzk(i6);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzk(int i5) {
        if (i5 >= 0) {
            zzq(i5);
        } else {
            zzs(i5);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzl(byte[] bArr, int i5, int i6) {
        zzc(bArr, 0, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzm(int i5, String str) {
        zzq((i5 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) {
        int i5 = this.zze;
        try {
            int zzy = zzhh.zzy(str.length() * 3);
            int zzy2 = zzhh.zzy(str.length());
            if (zzy2 != zzy) {
                zzq(zzma.zzc(str));
                byte[] bArr = this.zzc;
                int i6 = this.zze;
                this.zze = zzma.zzb(str, bArr, i6, this.zzd - i6);
                return;
            }
            int i7 = i5 + zzy2;
            this.zze = i7;
            int zzb = zzma.zzb(str, this.zzc, i7, this.zzd - i7);
            this.zze = i5;
            zzq((zzb - i5) - zzy2);
            this.zze = zzb;
        } catch (zzlz e5) {
            this.zze = i5;
            zzC(str, e5);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzhf(e6);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzo(int i5, int i6) {
        zzq((i5 << 3) | i6);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzp(int i5, int i6) {
        zzq(i5 << 3);
        zzq(i6);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzq(int i5) {
        while ((i5 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzc;
                int i6 = this.zze;
                this.zze = i6 + 1;
                bArr[i6] = (byte) ((i5 & 127) | 128);
                i5 >>>= 7;
            } catch (IndexOutOfBoundsException e5) {
                throw new zzhf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
            }
        }
        byte[] bArr2 = this.zzc;
        int i7 = this.zze;
        this.zze = i7 + 1;
        bArr2[i7] = (byte) i5;
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzr(int i5, long j5) {
        zzq(i5 << 3);
        zzs(j5);
    }

    @Override // com.google.android.recaptcha.internal.zzhh
    public final void zzs(long j5) {
        boolean z4;
        z4 = zzhh.zzd;
        if (!z4 || this.zzd - this.zze < 10) {
            while ((j5 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzc;
                    int i5 = this.zze;
                    this.zze = i5 + 1;
                    bArr[i5] = (byte) ((((int) j5) & 127) | 128);
                    j5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new zzhf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
                }
            }
            byte[] bArr2 = this.zzc;
            int i6 = this.zze;
            this.zze = i6 + 1;
            bArr2[i6] = (byte) j5;
            return;
        }
        while (true) {
            int i7 = (int) j5;
            if ((j5 & (-128)) == 0) {
                byte[] bArr3 = this.zzc;
                int i8 = this.zze;
                this.zze = i8 + 1;
                zzlv.zzn(bArr3, i8, (byte) i7);
                return;
            }
            byte[] bArr4 = this.zzc;
            int i9 = this.zze;
            this.zze = i9 + 1;
            zzlv.zzn(bArr4, i9, (byte) ((i7 & 127) | 128));
            j5 >>>= 7;
        }
    }
}
