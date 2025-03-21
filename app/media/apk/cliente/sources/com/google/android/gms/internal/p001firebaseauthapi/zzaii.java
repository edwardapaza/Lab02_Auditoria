package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzaii extends zzahn {
    private static final Logger zzb = Logger.getLogger(zzaii.class.getName());
    private static final boolean zzc = zzamh.zzc();
    zzaik zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zza */
    /* loaded from: classes.dex */
    private static class zza extends zzaii {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        zza(byte[] bArr, int i5, int i6) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i6 | 0 | (bArr.length - i6)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i6)));
            }
            this.zzb = bArr;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = i6;
        }

        private final void zzc(byte[] bArr, int i5, int i6) {
            try {
                System.arraycopy(bArr, i5, this.zzb, this.zze, i6);
                this.zze += i6;
            } catch (IndexOutOfBoundsException e5) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i6)), e5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final int zza() {
            return this.zzd - this.zze;
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zza(byte b5) {
            try {
                byte[] bArr = this.zzb;
                int i5 = this.zze;
                this.zze = i5 + 1;
                bArr[i5] = b5;
            } catch (IndexOutOfBoundsException e5) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahn
        public final void zza(byte[] bArr, int i5, int i6) {
            zzc(bArr, i5, i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(int i5, zzakk zzakkVar) {
            zzj(1, 3);
            zzk(2, i5);
            zzj(3, 2);
            zzc(zzakkVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(int i5, String str) {
            zzj(i5, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(int i5, boolean z4) {
            zzj(i5, 0);
            zza(z4 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(zzahm zzahmVar) {
            zzl(zzahmVar.zzb());
            zzahmVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        final void zzb(zzakk zzakkVar, zzalc zzalcVar) {
            zzl(((zzahd) zzakkVar).zza(zzalcVar));
            zzalcVar.zza((zzalc) zzakkVar, (zzanb) this.zza);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(String str) {
            int i5 = this.zze;
            try {
                int zzh = zzaii.zzh(str.length() * 3);
                int zzh2 = zzaii.zzh(str.length());
                if (zzh2 != zzh) {
                    zzl(zzaml.zza(str));
                    this.zze = zzaml.zza(str, this.zzb, this.zze, zza());
                    return;
                }
                int i6 = i5 + zzh2;
                this.zze = i6;
                int zza = zzaml.zza(str, this.zzb, i6, zza());
                this.zze = i5;
                zzl((zza - i5) - zzh2);
                this.zze = zza;
            } catch (zzamp e5) {
                this.zze = i5;
                zza(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new zzd(e6);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(byte[] bArr, int i5, int i6) {
            zzl(i6);
            zzc(bArr, 0, i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzc(int i5, zzahm zzahmVar) {
            zzj(i5, 2);
            zzb(zzahmVar);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        final void zzc(int i5, zzakk zzakkVar, zzalc zzalcVar) {
            zzj(i5, 2);
            zzl(((zzahd) zzakkVar).zza(zzalcVar));
            zzalcVar.zza((zzalc) zzakkVar, (zzanb) this.zza);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzc(zzakk zzakkVar) {
            zzl(zzakkVar.zzk());
            zzakkVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzd(int i5, zzahm zzahmVar) {
            zzj(1, 3);
            zzk(2, i5);
            zzc(3, zzahmVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzf(int i5, long j5) {
            zzj(i5, 1);
            zzf(j5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzf(long j5) {
            try {
                byte[] bArr = this.zzb;
                int i5 = this.zze;
                int i6 = i5 + 1;
                bArr[i5] = (byte) j5;
                int i7 = i6 + 1;
                bArr[i6] = (byte) (j5 >> 8);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (j5 >> 16);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (j5 >> 24);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (j5 >> 32);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (j5 >> 40);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (j5 >> 48);
                this.zze = i12 + 1;
                bArr[i12] = (byte) (j5 >> 56);
            } catch (IndexOutOfBoundsException e5) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzg(int i5, int i6) {
            zzj(i5, 5);
            zzi(i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzh(int i5, int i6) {
            zzj(i5, 0);
            zzj(i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzh(int i5, long j5) {
            zzj(i5, 0);
            zzh(j5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzh(long j5) {
            if (zzaii.zzc && zza() >= 10) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i5 = this.zze;
                    this.zze = i5 + 1;
                    zzamh.zza(bArr, i5, (byte) (((int) j5) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i6 = this.zze;
                this.zze = i6 + 1;
                zzamh.zza(bArr2, i6, (byte) j5);
                return;
            }
            while ((j5 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.zzb;
                    int i7 = this.zze;
                    this.zze = i7 + 1;
                    bArr3[i7] = (byte) (((int) j5) | 128);
                    j5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
                }
            }
            byte[] bArr4 = this.zzb;
            int i8 = this.zze;
            this.zze = i8 + 1;
            bArr4[i8] = (byte) j5;
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzi(int i5) {
            try {
                byte[] bArr = this.zzb;
                int i6 = this.zze;
                int i7 = i6 + 1;
                bArr[i6] = (byte) i5;
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i5 >> 8);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >> 16);
                this.zze = i9 + 1;
                bArr[i9] = (byte) (i5 >>> 24);
            } catch (IndexOutOfBoundsException e5) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzj(int i5) {
            if (i5 >= 0) {
                zzl(i5);
            } else {
                zzh(i5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzj(int i5, int i6) {
            zzl((i5 << 3) | i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzk(int i5, int i6) {
            zzj(i5, 0);
            zzl(i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzl(int i5) {
            while ((i5 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i6 = this.zze;
                    this.zze = i6 + 1;
                    bArr[i6] = (byte) (i5 | 128);
                    i5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e5);
                }
            }
            byte[] bArr2 = this.zzb;
            int i7 = this.zze;
            this.zze = i7 + 1;
            bArr2[i7] = (byte) i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zzb */
    /* loaded from: classes.dex */
    public static abstract class zzb extends zzaii {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        zzb(int i5) {
            super();
            if (i5 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i5, 20)];
            this.zzb = bArr;
            this.zzc = bArr.length;
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void zzb(byte b5) {
            byte[] bArr = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr[i5] = b5;
            this.zze++;
        }

        final void zzi(long j5) {
            byte[] bArr = this.zzb;
            int i5 = this.zzd;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (j5 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j5 >> 8) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j5 >> 16) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (255 & (j5 >> 24));
            int i10 = i9 + 1;
            bArr[i9] = (byte) (j5 >> 32);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (j5 >> 40);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (j5 >> 48);
            this.zzd = i12 + 1;
            bArr[i12] = (byte) (j5 >> 56);
            this.zze += 8;
        }

        final void zzj(long j5) {
            int i5;
            if (zzaii.zzc) {
                long j6 = this.zzd;
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i6 = this.zzd;
                    this.zzd = i6 + 1;
                    zzamh.zza(bArr, i6, (byte) (((int) j5) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                zzamh.zza(bArr2, i7, (byte) j5);
                i5 = this.zze + ((int) (this.zzd - j6));
            } else {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr3 = this.zzb;
                    int i8 = this.zzd;
                    this.zzd = i8 + 1;
                    bArr3[i8] = (byte) (((int) j5) | 128);
                    this.zze++;
                    j5 >>>= 7;
                }
                byte[] bArr4 = this.zzb;
                int i9 = this.zzd;
                this.zzd = i9 + 1;
                bArr4[i9] = (byte) j5;
                i5 = this.zze + 1;
            }
            this.zze = i5;
        }

        final void zzl(int i5, int i6) {
            zzn((i5 << 3) | i6);
        }

        final void zzm(int i5) {
            byte[] bArr = this.zzb;
            int i6 = this.zzd;
            int i7 = i6 + 1;
            bArr[i6] = (byte) i5;
            int i8 = i7 + 1;
            bArr[i7] = (byte) (i5 >> 8);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (i5 >> 16);
            this.zzd = i9 + 1;
            bArr[i9] = (byte) (i5 >>> 24);
            this.zze += 4;
        }

        final void zzn(int i5) {
            if (!zzaii.zzc) {
                while ((i5 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i6 = this.zzd;
                    this.zzd = i6 + 1;
                    bArr[i6] = (byte) (i5 | 128);
                    this.zze++;
                    i5 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                bArr2[i7] = (byte) i5;
                this.zze++;
                return;
            }
            long j5 = this.zzd;
            while ((i5 & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i8 = this.zzd;
                this.zzd = i8 + 1;
                zzamh.zza(bArr3, i8, (byte) (i5 | 128));
                i5 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i9 = this.zzd;
            this.zzd = i9 + 1;
            zzamh.zza(bArr4, i9, (byte) i5);
            this.zze += (int) (this.zzd - j5);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zzc */
    /* loaded from: classes.dex */
    private static final class zzc extends zzb {
        private final OutputStream zzf;

        zzc(OutputStream outputStream, int i5) {
            super(i5);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zzc(byte[] bArr, int i5, int i6) {
            int i7 = this.zzc;
            int i8 = this.zzd;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i5, this.zzb, i8, i6);
                this.zzd += i6;
            } else {
                int i9 = i7 - i8;
                System.arraycopy(bArr, i5, this.zzb, i8, i9);
                int i10 = i5 + i9;
                i6 -= i9;
                this.zzd = this.zzc;
                this.zze += i9;
                zze();
                if (i6 <= this.zzc) {
                    System.arraycopy(bArr, i10, this.zzb, 0, i6);
                    this.zzd = i6;
                } else {
                    this.zzf.write(bArr, i10, i6);
                }
            }
            this.zze += i6;
        }

        private final void zze() {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        private final void zzo(int i5) {
            if (this.zzc - this.zzd < i5) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zza(byte b5) {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzahn
        public final void zza(byte[] bArr, int i5, int i6) {
            zzc(bArr, i5, i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(int i5, zzakk zzakkVar) {
            zzj(1, 3);
            zzk(2, i5);
            zzj(3, 2);
            zzc(zzakkVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(int i5, String str) {
            zzj(i5, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(int i5, boolean z4) {
            zzo(11);
            zzl(i5, 0);
            zzb(z4 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(zzahm zzahmVar) {
            zzl(zzahmVar.zzb());
            zzahmVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        final void zzb(zzakk zzakkVar, zzalc zzalcVar) {
            zzl(((zzahd) zzakkVar).zza(zzalcVar));
            zzalcVar.zza((zzalc) zzakkVar, (zzanb) this.zza);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(String str) {
            int zza;
            try {
                int length = str.length() * 3;
                int zzh = zzaii.zzh(length);
                int i5 = zzh + length;
                int i6 = this.zzc;
                if (i5 > i6) {
                    byte[] bArr = new byte[length];
                    int zza2 = zzaml.zza(str, bArr, 0, length);
                    zzl(zza2);
                    zza(bArr, 0, zza2);
                    return;
                }
                if (i5 > i6 - this.zzd) {
                    zze();
                }
                int zzh2 = zzaii.zzh(str.length());
                int i7 = this.zzd;
                try {
                    if (zzh2 == zzh) {
                        int i8 = i7 + zzh2;
                        this.zzd = i8;
                        int zza3 = zzaml.zza(str, this.zzb, i8, this.zzc - i8);
                        this.zzd = i7;
                        zza = (zza3 - i7) - zzh2;
                        zzn(zza);
                        this.zzd = zza3;
                    } else {
                        zza = zzaml.zza(str);
                        zzn(zza);
                        this.zzd = zzaml.zza(str, this.zzb, this.zzd, zza);
                    }
                    this.zze += zza;
                } catch (zzamp e5) {
                    this.zze -= this.zzd - i7;
                    this.zzd = i7;
                    throw e5;
                } catch (ArrayIndexOutOfBoundsException e6) {
                    throw new zzd(e6);
                }
            } catch (zzamp e7) {
                zza(str, e7);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzb(byte[] bArr, int i5, int i6) {
            zzl(i6);
            zzc(bArr, 0, i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzc() {
            if (this.zzd > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzc(int i5, zzahm zzahmVar) {
            zzj(i5, 2);
            zzb(zzahmVar);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        final void zzc(int i5, zzakk zzakkVar, zzalc zzalcVar) {
            zzj(i5, 2);
            zzb(zzakkVar, zzalcVar);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzc(zzakk zzakkVar) {
            zzl(zzakkVar.zzk());
            zzakkVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzd(int i5, zzahm zzahmVar) {
            zzj(1, 3);
            zzk(2, i5);
            zzc(3, zzahmVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzf(int i5, long j5) {
            zzo(18);
            zzl(i5, 1);
            zzi(j5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzf(long j5) {
            zzo(8);
            zzi(j5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzg(int i5, int i6) {
            zzo(14);
            zzl(i5, 5);
            zzm(i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzh(int i5, int i6) {
            zzo(20);
            zzl(i5, 0);
            if (i6 >= 0) {
                zzn(i6);
            } else {
                zzj(i6);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzh(int i5, long j5) {
            zzo(20);
            zzl(i5, 0);
            zzj(j5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzh(long j5) {
            zzo(10);
            zzj(j5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzi(int i5) {
            zzo(4);
            zzm(i5);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzj(int i5) {
            if (i5 >= 0) {
                zzl(i5);
            } else {
                zzh(i5);
            }
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzj(int i5, int i6) {
            zzl((i5 << 3) | i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzk(int i5, int i6) {
            zzo(20);
            zzl(i5, 0);
            zzn(i6);
        }

        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzaii
        public final void zzl(int i5) {
            zzo(5);
            zzn(i5);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zzd */
    /* loaded from: classes.dex */
    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzaii() {
    }

    public static int zza(double d5) {
        return 8;
    }

    public static int zza(float f5) {
        return 4;
    }

    public static int zza(int i5) {
        return zze(i5);
    }

    public static int zza(int i5, double d5) {
        return zzh(i5 << 3) + 8;
    }

    public static int zza(int i5, float f5) {
        return zzh(i5 << 3) + 4;
    }

    public static int zza(int i5, int i6) {
        return zzh(i5 << 3) + zze(i6);
    }

    public static int zza(int i5, long j5) {
        return zzh(i5 << 3) + 8;
    }

    public static int zza(int i5, zzahm zzahmVar) {
        int zzh = zzh(i5 << 3);
        int zzb2 = zzahmVar.zzb();
        return zzh + zzh(zzb2) + zzb2;
    }

    public static int zza(int i5, zzajo zzajoVar) {
        return (zzh(8) << 1) + zzf(2, i5) + zzb(3, zzajoVar);
    }

    public static int zza(int i5, zzakk zzakkVar) {
        return (zzh(8) << 1) + zzf(2, i5) + zzh(24) + zzb(zzakkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zza(int i5, zzakk zzakkVar, zzalc zzalcVar) {
        return (zzh(i5 << 3) << 1) + ((zzahd) zzakkVar).zza(zzalcVar);
    }

    public static int zza(int i5, String str) {
        return zzh(i5 << 3) + zza(str);
    }

    public static int zza(int i5, boolean z4) {
        return zzh(i5 << 3) + 1;
    }

    public static int zza(long j5) {
        return 8;
    }

    public static int zza(zzahm zzahmVar) {
        int zzb2 = zzahmVar.zzb();
        return zzh(zzb2) + zzb2;
    }

    public static int zza(zzajo zzajoVar) {
        int zzb2 = zzajoVar.zzb();
        return zzh(zzb2) + zzb2;
    }

    @Deprecated
    public static int zza(zzakk zzakkVar) {
        return zzakkVar.zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzakk zzakkVar, zzalc zzalcVar) {
        int zza2 = ((zzahd) zzakkVar).zza(zzalcVar);
        return zzh(zza2) + zza2;
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzaml.zza(str);
        } catch (zzamp unused) {
            length = str.getBytes(zzajc.zza).length;
        }
        return zzh(length) + length;
    }

    public static int zza(boolean z4) {
        return 1;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzh(length) + length;
    }

    public static zzaii zza(OutputStream outputStream, int i5) {
        return new zzc(outputStream, i5);
    }

    public static int zzb(int i5) {
        return 4;
    }

    public static int zzb(int i5, int i6) {
        return zzh(i5 << 3) + 4;
    }

    public static int zzb(int i5, long j5) {
        return zzh(i5 << 3) + zze(j5);
    }

    public static int zzb(int i5, zzahm zzahmVar) {
        return (zzh(8) << 1) + zzf(2, i5) + zza(3, zzahmVar);
    }

    public static int zzb(int i5, zzajo zzajoVar) {
        int zzh = zzh(i5 << 3);
        int zzb2 = zzajoVar.zzb();
        return zzh + zzh(zzb2) + zzb2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, zzakk zzakkVar, zzalc zzalcVar) {
        return zzh(i5 << 3) + zza(zzakkVar, zzalcVar);
    }

    public static int zzb(long j5) {
        return zze(j5);
    }

    public static int zzb(zzakk zzakkVar) {
        int zzk = zzakkVar.zzk();
        return zzh(zzk) + zzk;
    }

    public static zzaii zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzc(int i5) {
        return zze(i5);
    }

    public static int zzc(int i5, int i6) {
        return zzh(i5 << 3) + zze(i6);
    }

    public static int zzc(int i5, long j5) {
        return zzh(i5 << 3) + 8;
    }

    public static int zzc(long j5) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i5) {
        if (i5 > 4096) {
            return 4096;
        }
        return i5;
    }

    public static int zzd(int i5, int i6) {
        return zzh(i5 << 3) + 4;
    }

    public static int zzd(int i5, long j5) {
        return zzh(i5 << 3) + zze(zzi(j5));
    }

    public static int zzd(long j5) {
        return zze(zzi(j5));
    }

    public static int zze(int i5) {
        return 4;
    }

    public static int zze(int i5, int i6) {
        return zzh(i5 << 3) + zzh(zzm(i6));
    }

    public static int zze(int i5, long j5) {
        return zzh(i5 << 3) + zze(j5);
    }

    public static int zze(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public static int zzf(int i5) {
        return zzh(zzm(i5));
    }

    public static int zzf(int i5, int i6) {
        return zzh(i5 << 3) + zzh(i6);
    }

    public static int zzg(int i5) {
        return zzh(i5 << 3);
    }

    public static int zzh(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    private static long zzi(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    private static int zzm(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b5);

    final void zza(String str, zzamp zzampVar) {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzampVar);
        byte[] bytes = str.getBytes(zzajc.zza);
        try {
            zzl(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new zzd(e5);
        }
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzb(double d5) {
        zzf(Double.doubleToRawLongBits(d5));
    }

    public final void zzb(float f5) {
        zzi(Float.floatToRawIntBits(f5));
    }

    public final void zzb(int i5, double d5) {
        zzf(i5, Double.doubleToRawLongBits(d5));
    }

    public final void zzb(int i5, float f5) {
        zzg(i5, Float.floatToRawIntBits(f5));
    }

    public abstract void zzb(int i5, zzakk zzakkVar);

    public abstract void zzb(int i5, String str);

    public abstract void zzb(int i5, boolean z4);

    public abstract void zzb(zzahm zzahmVar);

    abstract void zzb(zzakk zzakkVar, zzalc zzalcVar);

    public abstract void zzb(String str);

    public final void zzb(boolean z4) {
        zza(z4 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i5, int i6);

    public abstract void zzc();

    public abstract void zzc(int i5, zzahm zzahmVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(int i5, zzakk zzakkVar, zzalc zzalcVar);

    public abstract void zzc(zzakk zzakkVar);

    public abstract void zzd(int i5, zzahm zzahmVar);

    public abstract void zzf(int i5, long j5);

    public abstract void zzf(long j5);

    public abstract void zzg(int i5, int i6);

    public final void zzg(int i5, long j5) {
        zzh(i5, zzi(j5));
    }

    public final void zzg(long j5) {
        zzh(zzi(j5));
    }

    public abstract void zzh(int i5, int i6);

    public abstract void zzh(int i5, long j5);

    public abstract void zzh(long j5);

    public abstract void zzi(int i5);

    public final void zzi(int i5, int i6) {
        zzk(i5, zzm(i6));
    }

    public abstract void zzj(int i5);

    public abstract void zzj(int i5, int i6);

    public final void zzk(int i5) {
        zzl(zzm(i5));
    }

    public abstract void zzk(int i5, int i6);

    public abstract void zzl(int i5);
}
