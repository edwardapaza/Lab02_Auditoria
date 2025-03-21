package com.google.android.gms.internal.p001firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzahi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(byte[] bArr, int i5) {
        return Double.longBitsToDouble(zzd(bArr, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7, zzahl zzahlVar) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 5) {
                                return i6 + 4;
                            }
                            throw zzajj.zzc();
                        }
                        int i9 = (i5 & (-8)) | 4;
                        int i10 = 0;
                        while (i6 < i7) {
                            i6 = zzc(bArr, i6, zzahlVar);
                            i10 = zzahlVar.zza;
                            if (i10 == i9) {
                                break;
                            }
                            i6 = zza(i10, bArr, i6, i7, zzahlVar);
                        }
                        if (i6 > i7 || i10 != i9) {
                            throw zzajj.zzg();
                        }
                        return i6;
                    }
                    return zzc(bArr, i6, zzahlVar) + zzahlVar.zza;
                }
                return i6 + 8;
            }
            return zzd(bArr, i6, zzahlVar);
        }
        throw zzajj.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7, zzajg<?> zzajgVar, zzahl zzahlVar) {
        zzajd zzajdVar = (zzajd) zzajgVar;
        int zzc = zzc(bArr, i6, zzahlVar);
        while (true) {
            zzajdVar.zzc(zzahlVar.zza);
            if (zzc >= i7) {
                break;
            }
            int zzc2 = zzc(bArr, zzc, zzahlVar);
            if (i5 != zzahlVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzahlVar);
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7, zzame zzameVar, zzahl zzahlVar) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 == 0) {
                int zzd = zzd(bArr, i6, zzahlVar);
                zzameVar.zza(i5, Long.valueOf(zzahlVar.zzb));
                return zzd;
            } else if (i8 == 1) {
                zzameVar.zza(i5, Long.valueOf(zzd(bArr, i6)));
                return i6 + 8;
            } else if (i8 == 2) {
                int zzc = zzc(bArr, i6, zzahlVar);
                int i9 = zzahlVar.zza;
                if (i9 >= 0) {
                    if (i9 <= bArr.length - zzc) {
                        zzameVar.zza(i5, i9 == 0 ? zzahm.zza : zzahm.zza(bArr, zzc, i9));
                        return zzc + i9;
                    }
                    throw zzajj.zzi();
                }
                throw zzajj.zzf();
            } else if (i8 != 3) {
                if (i8 == 5) {
                    zzameVar.zza(i5, Integer.valueOf(zzc(bArr, i6)));
                    return i6 + 4;
                }
                throw zzajj.zzc();
            } else {
                zzame zzd2 = zzame.zzd();
                int i10 = (i5 & (-8)) | 4;
                int i11 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int zzc2 = zzc(bArr, i6, zzahlVar);
                    int i12 = zzahlVar.zza;
                    i11 = i12;
                    if (i12 == i10) {
                        i6 = zzc2;
                        break;
                    }
                    int zza = zza(i11, bArr, zzc2, i7, zzd2, zzahlVar);
                    i11 = i12;
                    i6 = zza;
                }
                if (i6 > i7 || i11 != i10) {
                    throw zzajj.zzg();
                }
                zzameVar.zza(i5, zzd2);
                return i6;
            }
        }
        throw zzajj.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, zzahl zzahlVar) {
        int i7;
        int i8;
        int i9 = i5 & 127;
        int i10 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 < 0) {
            int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 7);
            int i12 = i10 + 1;
            byte b6 = bArr[i10];
            if (b6 >= 0) {
                i7 = b6 << 14;
            } else {
                i9 = i11 | ((b6 & Byte.MAX_VALUE) << 14);
                i10 = i12 + 1;
                byte b7 = bArr[i12];
                if (b7 >= 0) {
                    i8 = b7 << 21;
                } else {
                    i11 = i9 | ((b7 & Byte.MAX_VALUE) << 21);
                    i12 = i10 + 1;
                    byte b8 = bArr[i10];
                    if (b8 >= 0) {
                        i7 = b8 << 28;
                    } else {
                        int i13 = i11 | ((b8 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i14 = i12 + 1;
                            if (bArr[i12] >= 0) {
                                zzahlVar.zza = i13;
                                return i14;
                            }
                            i12 = i14;
                        }
                    }
                }
            }
            zzahlVar.zza = i11 | i7;
            return i12;
        }
        i8 = b5 << 7;
        zzahlVar.zza = i9 | i8;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzalc<?> zzalcVar, int i5, byte[] bArr, int i6, int i7, zzajg<?> zzajgVar, zzahl zzahlVar) {
        int zza = zza(zzalcVar, bArr, i6, i7, zzahlVar);
        while (true) {
            zzajgVar.add(zzahlVar.zzc);
            if (zza >= i7) {
                break;
            }
            int zzc = zzc(bArr, zza, zzahlVar);
            if (i5 != zzahlVar.zza) {
                break;
            }
            zza = zza(zzalcVar, bArr, zzc, i7, zzahlVar);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzalc zzalcVar, byte[] bArr, int i5, int i6, int i7, zzahl zzahlVar) {
        Object zza = zzalcVar.zza();
        int zza2 = zza(zza, zzalcVar, bArr, i5, i6, i7, zzahlVar);
        zzalcVar.zzc(zza);
        zzahlVar.zzc = zza;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzalc zzalcVar, byte[] bArr, int i5, int i6, zzahl zzahlVar) {
        Object zza = zzalcVar.zza();
        int zza2 = zza(zza, zzalcVar, bArr, i5, i6, zzahlVar);
        zzalcVar.zzc(zza);
        zzahlVar.zzc = zza;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Object obj, zzalc zzalcVar, byte[] bArr, int i5, int i6, int i7, zzahl zzahlVar) {
        int zza = ((zzako) zzalcVar).zza((zzako) obj, bArr, i5, i6, i7, zzahlVar);
        zzahlVar.zzc = obj;
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Object obj, zzalc zzalcVar, byte[] bArr, int i5, int i6, zzahl zzahlVar) {
        int i7 = i5 + 1;
        int i8 = bArr[i5];
        if (i8 < 0) {
            i7 = zza(i8, bArr, i7, zzahlVar);
            i8 = zzahlVar.zza;
        }
        int i9 = i7;
        if (i8 < 0 || i8 > i6 - i9) {
            throw zzajj.zzi();
        }
        int i10 = i8 + i9;
        zzalcVar.zza(obj, bArr, i9, i10, zzahlVar);
        zzahlVar.zzc = obj;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i5, zzahl zzahlVar) {
        int zzc = zzc(bArr, i5, zzahlVar);
        int i6 = zzahlVar.zza;
        if (i6 >= 0) {
            if (i6 <= bArr.length - zzc) {
                if (i6 == 0) {
                    zzahlVar.zzc = zzahm.zza;
                    return zzc;
                }
                zzahlVar.zzc = zzahm.zza(bArr, zzc, i6);
                return zzc + i6;
            }
            throw zzajj.zzi();
        }
        throw zzajj.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i5, zzajg<?> zzajgVar, zzahl zzahlVar) {
        zzajd zzajdVar = (zzajd) zzajgVar;
        int zzc = zzc(bArr, i5, zzahlVar);
        int i6 = zzahlVar.zza + zzc;
        while (zzc < i6) {
            zzc = zzc(bArr, zzc, zzahlVar);
            zzajdVar.zzc(zzahlVar.zza);
        }
        if (zzc == i6) {
            return zzc;
        }
        throw zzajj.zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(byte[] bArr, int i5) {
        return Float.intBitsToFloat(zzc(bArr, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i5, zzahl zzahlVar) {
        int zzc = zzc(bArr, i5, zzahlVar);
        int i6 = zzahlVar.zza;
        if (i6 >= 0) {
            if (i6 == 0) {
                zzahlVar.zzc = "";
                return zzc;
            }
            zzahlVar.zzc = zzaml.zzb(bArr, zzc, i6);
            return zzc + i6;
        }
        throw zzajj.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i5, zzahl zzahlVar) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzahlVar.zza = b5;
            return i6;
        }
        return zza(b5, bArr, i6, zzahlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i5, zzahl zzahlVar) {
        byte b5;
        int i6 = i5 + 1;
        long j5 = bArr[i5];
        if (j5 >= 0) {
            zzahlVar.zzb = j5;
            return i6;
        }
        int i7 = i6 + 1;
        byte b6 = bArr[i6];
        long j6 = (j5 & 127) | ((b6 & Byte.MAX_VALUE) << 7);
        int i8 = 7;
        while (b6 < 0) {
            int i9 = i7 + 1;
            i8 += 7;
            j6 |= (b5 & Byte.MAX_VALUE) << i8;
            b6 = bArr[i7];
            i7 = i9;
        }
        zzahlVar.zzb = j6;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(byte[] bArr, int i5) {
        return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
    }
}
