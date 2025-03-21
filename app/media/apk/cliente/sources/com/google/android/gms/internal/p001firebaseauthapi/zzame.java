package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzame  reason: invalid package */
/* loaded from: classes.dex */
public final class zzame {
    private static final zzame zza = new zzame(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzame() {
        this(0, new int[8], new Object[8], true);
    }

    private zzame(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.zze = -1;
        this.zzb = i5;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzame zza(zzame zzameVar, zzame zzameVar2) {
        int i5 = zzameVar.zzb + zzameVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzameVar.zzc, i5);
        System.arraycopy(zzameVar2.zzc, 0, copyOf, zzameVar.zzb, zzameVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzameVar.zzd, i5);
        System.arraycopy(zzameVar2.zzd, 0, copyOf2, zzameVar.zzb, zzameVar2.zzb);
        return new zzame(i5, copyOf, copyOf2, true);
    }

    private final void zza(int i5) {
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

    private static void zza(int i5, Object obj, zzanb zzanbVar) {
        int i6 = i5 >>> 3;
        int i7 = i5 & 7;
        if (i7 == 0) {
            zzanbVar.zzb(i6, ((Long) obj).longValue());
        } else if (i7 == 1) {
            zzanbVar.zza(i6, ((Long) obj).longValue());
        } else if (i7 == 2) {
            zzanbVar.zza(i6, (zzahm) obj);
        } else if (i7 != 3) {
            if (i7 != 5) {
                throw new RuntimeException(zzajj.zza());
            }
            zzanbVar.zzb(i6, ((Integer) obj).intValue());
        } else if (zzanbVar.zza() == zzana.zza) {
            zzanbVar.zzb(i6);
            ((zzame) obj).zzb(zzanbVar);
            zzanbVar.zza(i6);
        } else {
            zzanbVar.zza(i6);
            ((zzame) obj).zzb(zzanbVar);
            zzanbVar.zzb(i6);
        }
    }

    public static zzame zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzame zzd() {
        return new zzame();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        boolean z4;
        boolean z5;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzame)) {
            zzame zzameVar = (zzame) obj;
            int i5 = this.zzb;
            if (i5 == zzameVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzameVar.zzc;
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        z4 = true;
                        break;
                    } else if (iArr[i6] != iArr2[i6]) {
                        z4 = false;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z4) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzameVar.zzd;
                    int i7 = this.zzb;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= i7) {
                            z5 = true;
                            break;
                        } else if (!objArr[i8].equals(objArr2[i8])) {
                            z5 = false;
                            break;
                        } else {
                            i8++;
                        }
                    }
                    if (z5) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.zzb;
        int i6 = (i5 + 527) * 31;
        int[] iArr = this.zzc;
        int i7 = 17;
        int i8 = 17;
        for (int i9 = 0; i9 < i5; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        int i10 = (i6 + i8) * 31;
        Object[] objArr = this.zzd;
        int i11 = this.zzb;
        for (int i12 = 0; i12 < i11; i12++) {
            i7 = (i7 * 31) + objArr[i12].hashCode();
        }
        return i10 + i7;
    }

    public final int zza() {
        int zze;
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            int i8 = this.zzc[i7];
            int i9 = i8 >>> 3;
            int i10 = i8 & 7;
            if (i10 == 0) {
                zze = zzaii.zze(i9, ((Long) this.zzd[i7]).longValue());
            } else if (i10 == 1) {
                zze = zzaii.zza(i9, ((Long) this.zzd[i7]).longValue());
            } else if (i10 == 2) {
                zze = zzaii.zza(i9, (zzahm) this.zzd[i7]);
            } else if (i10 == 3) {
                zze = (zzaii.zzg(i9) << 1) + ((zzame) this.zzd[i7]).zza();
            } else if (i10 != 5) {
                throw new IllegalStateException(zzajj.zza());
            } else {
                zze = zzaii.zzb(i9, ((Integer) this.zzd[i7]).intValue());
            }
            i6 += zze;
        }
        this.zze = i6;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzame zza(zzame zzameVar) {
        if (zzameVar.equals(zza)) {
            return this;
        }
        zzf();
        int i5 = this.zzb + zzameVar.zzb;
        zza(i5);
        System.arraycopy(zzameVar.zzc, 0, this.zzc, this.zzb, zzameVar.zzb);
        System.arraycopy(zzameVar.zzd, 0, this.zzd, this.zzb, zzameVar.zzb);
        this.zzb = i5;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i5, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i5;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzanb zzanbVar) {
        if (zzanbVar.zza() == zzana.zzb) {
            for (int i5 = this.zzb - 1; i5 >= 0; i5--) {
                zzanbVar.zza(this.zzc[i5] >>> 3, this.zzd[i5]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzanbVar.zza(this.zzc[i6] >>> 3, this.zzd[i6]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzakp.zza(sb, i5, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final int zzb() {
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            i6 += zzaii.zzb(this.zzc[i7] >>> 3, (zzahm) this.zzd[i7]);
        }
        this.zze = i6;
        return i6;
    }

    public final void zzb(zzanb zzanbVar) {
        if (this.zzb == 0) {
            return;
        }
        if (zzanbVar.zza() == zzana.zza) {
            for (int i5 = 0; i5 < this.zzb; i5++) {
                zza(this.zzc[i5], this.zzd[i5], zzanbVar);
            }
            return;
        }
        for (int i6 = this.zzb - 1; i6 >= 0; i6--) {
            zza(this.zzc[i6], this.zzd[i6], zzanbVar);
        }
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }
}
