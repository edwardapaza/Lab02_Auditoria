package com.google.android.recaptcha.internal;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzlm {
    private static final zzlm zza = new zzlm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzlm() {
        this(0, new int[8], new Object[8], true);
    }

    private zzlm(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.zze = -1;
        this.zzb = i5;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z4;
    }

    public static zzlm zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlm zze(zzlm zzlmVar, zzlm zzlmVar2) {
        int i5 = zzlmVar.zzb + zzlmVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzlmVar.zzc, i5);
        System.arraycopy(zzlmVar2.zzc, 0, copyOf, zzlmVar.zzb, zzlmVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzlmVar.zzd, i5);
        System.arraycopy(zzlmVar2.zzd, 0, copyOf2, zzlmVar.zzb, zzlmVar2.zzb);
        return new zzlm(i5, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlm zzf() {
        return new zzlm(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i5) {
        int[] iArr = this.zzc;
        if (i5 > iArr.length) {
            int i6 = this.zzb;
            int i7 = i6 + (i6 / 2);
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i5);
            this.zzd = Arrays.copyOf(this.zzd, i5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzlm)) {
            zzlm zzlmVar = (zzlm) obj;
            int i5 = this.zzb;
            if (i5 == zzlmVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzlmVar.zzc;
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        Object[] objArr = this.zzd;
                        Object[] objArr2 = zzlmVar.zzd;
                        int i7 = this.zzb;
                        for (int i8 = 0; i8 < i7; i8++) {
                            if (objArr[i8].equals(objArr2[i8])) {
                            }
                        }
                        return true;
                    } else if (iArr[i6] != iArr2[i6]) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.zzb;
        int i6 = i5 + 527;
        int[] iArr = this.zzc;
        int i7 = 17;
        int i8 = 17;
        for (int i9 = 0; i9 < i5; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        int i10 = ((i6 * 31) + i8) * 31;
        Object[] objArr = this.zzd;
        int i11 = this.zzb;
        for (int i12 = 0; i12 < i11; i12++) {
            i7 = (i7 * 31) + objArr[i12].hashCode();
        }
        return i10 + i7;
    }

    public final int zza() {
        int zzz;
        int zzy;
        int i5;
        int i6 = this.zze;
        if (i6 == -1) {
            int i7 = 0;
            for (int i8 = 0; i8 < this.zzb; i8++) {
                int i9 = this.zzc[i8];
                int i10 = i9 >>> 3;
                int i11 = i9 & 7;
                if (i11 != 0) {
                    if (i11 == 1) {
                        ((Long) this.zzd[i8]).longValue();
                        i5 = zzhh.zzy(i10 << 3) + 8;
                    } else if (i11 == 2) {
                        int i12 = i10 << 3;
                        int i13 = zzhh.zzb;
                        int zzd = ((zzgw) this.zzd[i8]).zzd();
                        i5 = zzhh.zzy(i12) + zzhh.zzy(zzd) + zzd;
                    } else if (i11 == 3) {
                        int i14 = i10 << 3;
                        int i15 = zzhh.zzb;
                        zzz = ((zzlm) this.zzd[i8]).zza();
                        int zzy2 = zzhh.zzy(i14);
                        zzy = zzy2 + zzy2;
                    } else if (i11 != 5) {
                        throw new IllegalStateException(zzje.zza());
                    } else {
                        ((Integer) this.zzd[i8]).intValue();
                        i5 = zzhh.zzy(i10 << 3) + 4;
                    }
                    i7 += i5;
                } else {
                    int i16 = i10 << 3;
                    zzz = zzhh.zzz(((Long) this.zzd[i8]).longValue());
                    zzy = zzhh.zzy(i16);
                }
                i5 = zzy + zzz;
                i7 += i5;
            }
            this.zze = i7;
            return i7;
        }
        return i6;
    }

    public final int zzb() {
        int i5 = this.zze;
        if (i5 == -1) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.zzb; i7++) {
                int i8 = zzhh.zzb;
                int zzd = ((zzgw) this.zzd[i7]).zzd();
                int zzy = zzhh.zzy(zzd) + zzd;
                int zzy2 = zzhh.zzy(16);
                int zzy3 = zzhh.zzy(this.zzc[i7] >>> 3);
                int zzy4 = zzhh.zzy(8);
                i6 += zzy4 + zzy4 + zzy2 + zzy3 + zzhh.zzy(24) + zzy;
            }
            this.zze = i6;
            return i6;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzlm zzd(zzlm zzlmVar) {
        if (zzlmVar.equals(zza)) {
            return this;
        }
        zzg();
        int i5 = this.zzb + zzlmVar.zzb;
        zzm(i5);
        System.arraycopy(zzlmVar.zzc, 0, this.zzc, this.zzb, zzlmVar.zzb);
        System.arraycopy(zzlmVar.zzd, 0, this.zzd, this.zzb, zzlmVar.zzb);
        this.zzb = i5;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzkg.zzb(sb, i5, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i5, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i5;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(zzmd zzmdVar) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzmdVar.zzw(this.zzc[i5] >>> 3, this.zzd[i5]);
        }
    }

    public final void zzl(zzmd zzmdVar) {
        if (this.zzb != 0) {
            for (int i5 = 0; i5 < this.zzb; i5++) {
                int i6 = this.zzc[i5];
                Object obj = this.zzd[i5];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    zzmdVar.zzt(i8, ((Long) obj).longValue());
                } else if (i7 == 1) {
                    zzmdVar.zzm(i8, ((Long) obj).longValue());
                } else if (i7 == 2) {
                    zzmdVar.zzd(i8, (zzgw) obj);
                } else if (i7 == 3) {
                    zzmdVar.zzF(i8);
                    ((zzlm) obj).zzl(zzmdVar);
                    zzmdVar.zzh(i8);
                } else if (i7 != 5) {
                    throw new RuntimeException(zzje.zza());
                } else {
                    zzmdVar.zzk(i8, ((Integer) obj).intValue());
                }
            }
        }
    }
}
