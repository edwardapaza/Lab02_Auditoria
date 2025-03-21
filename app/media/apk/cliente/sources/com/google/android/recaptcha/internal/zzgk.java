package com.google.android.recaptcha.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i5, zzgj zzgjVar) {
        int zzi = zzi(bArr, i5, zzgjVar);
        int i6 = zzgjVar.zza;
        if (i6 >= 0) {
            if (i6 <= bArr.length - zzi) {
                if (i6 == 0) {
                    zzgjVar.zzc = zzgw.zzb;
                    return zzi;
                }
                zzgjVar.zzc = zzgw.zzm(bArr, zzi, i6);
                return zzi + i6;
            }
            throw zzje.zzj();
        }
        throw zzje.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i5) {
        int i6 = (bArr[i5 + 1] & 255) << 8;
        return ((bArr[i5 + 3] & 255) << 24) | i6 | (bArr[i5] & 255) | ((bArr[i5 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzkr zzkrVar, byte[] bArr, int i5, int i6, int i7, zzgj zzgjVar) {
        Object zze = zzkrVar.zze();
        int zzm = zzm(zze, zzkrVar, bArr, i5, i6, i7, zzgjVar);
        zzkrVar.zzf(zze);
        zzgjVar.zzc = zze;
        return zzm;
    }

    static int zzd(zzkr zzkrVar, byte[] bArr, int i5, int i6, zzgj zzgjVar) {
        Object zze = zzkrVar.zze();
        int zzn = zzn(zze, zzkrVar, bArr, i5, i6, zzgjVar);
        zzkrVar.zzf(zze);
        zzgjVar.zzc = zze;
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzkr zzkrVar, int i5, byte[] bArr, int i6, int i7, zzjb zzjbVar, zzgj zzgjVar) {
        int zzd = zzd(zzkrVar, bArr, i6, i7, zzgjVar);
        while (true) {
            zzjbVar.add(zzgjVar.zzc);
            if (zzd >= i7) {
                break;
            }
            int zzi = zzi(bArr, zzd, zzgjVar);
            if (i5 != zzgjVar.zza) {
                break;
            }
            zzd = zzd(zzkrVar, bArr, zzi, i7, zzgjVar);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i5, zzjb zzjbVar, zzgj zzgjVar) {
        zziu zziuVar = (zziu) zzjbVar;
        int zzi = zzi(bArr, i5, zzgjVar);
        int i6 = zzgjVar.zza + zzi;
        while (zzi < i6) {
            zzi = zzi(bArr, zzi, zzgjVar);
            zziuVar.zzg(zzgjVar.zza);
        }
        if (zzi == i6) {
            return zzi;
        }
        throw zzje.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i5, zzgj zzgjVar) {
        int zzi = zzi(bArr, i5, zzgjVar);
        int i6 = zzgjVar.zza;
        if (i6 >= 0) {
            if (i6 == 0) {
                zzgjVar.zzc = "";
                return zzi;
            }
            zzgjVar.zzc = new String(bArr, zzi, i6, zzjc.zzb);
            return zzi + i6;
        }
        throw zzje.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i5, byte[] bArr, int i6, int i7, zzlm zzlmVar, zzgj zzgjVar) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 == 0) {
                int zzl = zzl(bArr, i6, zzgjVar);
                zzlmVar.zzj(i5, Long.valueOf(zzgjVar.zzb));
                return zzl;
            } else if (i8 == 1) {
                zzlmVar.zzj(i5, Long.valueOf(zzp(bArr, i6)));
                return i6 + 8;
            } else if (i8 == 2) {
                int zzi = zzi(bArr, i6, zzgjVar);
                int i9 = zzgjVar.zza;
                if (i9 >= 0) {
                    if (i9 <= bArr.length - zzi) {
                        zzlmVar.zzj(i5, i9 == 0 ? zzgw.zzb : zzgw.zzm(bArr, zzi, i9));
                        return zzi + i9;
                    }
                    throw zzje.zzj();
                }
                throw zzje.zzf();
            } else if (i8 != 3) {
                if (i8 == 5) {
                    zzlmVar.zzj(i5, Integer.valueOf(zzb(bArr, i6)));
                    return i6 + 4;
                }
                throw zzje.zzc();
            } else {
                int i10 = (i5 & (-8)) | 4;
                zzlm zzf = zzlm.zzf();
                int i11 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int zzi2 = zzi(bArr, i6, zzgjVar);
                    int i12 = zzgjVar.zza;
                    i11 = i12;
                    if (i12 == i10) {
                        i6 = zzi2;
                        break;
                    }
                    int zzh = zzh(i11, bArr, zzi2, i7, zzf, zzgjVar);
                    i11 = i12;
                    i6 = zzh;
                }
                if (i6 > i7 || i11 != i10) {
                    throw zzje.zzg();
                }
                zzlmVar.zzj(i5, zzf);
                return i6;
            }
        }
        throw zzje.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(byte[] bArr, int i5, zzgj zzgjVar) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzgjVar.zza = b5;
            return i6;
        }
        return zzj(b5, bArr, i6, zzgjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i5, byte[] bArr, int i6, zzgj zzgjVar) {
        int i7;
        int i8;
        byte b5 = bArr[i6];
        int i9 = i6 + 1;
        int i10 = i5 & 127;
        if (b5 < 0) {
            int i11 = i10 | ((b5 & Byte.MAX_VALUE) << 7);
            int i12 = i9 + 1;
            byte b6 = bArr[i9];
            if (b6 >= 0) {
                i7 = b6 << 14;
            } else {
                i10 = i11 | ((b6 & Byte.MAX_VALUE) << 14);
                i9 = i12 + 1;
                byte b7 = bArr[i12];
                if (b7 >= 0) {
                    i8 = b7 << 21;
                } else {
                    i11 = i10 | ((b7 & Byte.MAX_VALUE) << 21);
                    i12 = i9 + 1;
                    byte b8 = bArr[i9];
                    if (b8 >= 0) {
                        i7 = b8 << 28;
                    } else {
                        int i13 = i11 | ((b8 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i14 = i12 + 1;
                            if (bArr[i12] >= 0) {
                                zzgjVar.zza = i13;
                                return i14;
                            }
                            i12 = i14;
                        }
                    }
                }
            }
            zzgjVar.zza = i11 | i7;
            return i12;
        }
        i8 = b5 << 7;
        zzgjVar.zza = i10 | i8;
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i5, byte[] bArr, int i6, int i7, zzjb zzjbVar, zzgj zzgjVar) {
        zziu zziuVar = (zziu) zzjbVar;
        int zzi = zzi(bArr, i6, zzgjVar);
        while (true) {
            zziuVar.zzg(zzgjVar.zza);
            if (zzi >= i7) {
                break;
            }
            int zzi2 = zzi(bArr, zzi, zzgjVar);
            if (i5 != zzgjVar.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzgjVar);
        }
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(byte[] bArr, int i5, zzgj zzgjVar) {
        long j5 = bArr[i5];
        int i6 = i5 + 1;
        if (j5 >= 0) {
            zzgjVar.zzb = j5;
            return i6;
        }
        int i7 = i6 + 1;
        byte b5 = bArr[i6];
        long j6 = (j5 & 127) | ((b5 & Byte.MAX_VALUE) << 7);
        int i8 = 7;
        while (b5 < 0) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            i8 += 7;
            j6 |= (b6 & Byte.MAX_VALUE) << i8;
            i7 = i9;
            b5 = b6;
        }
        zzgjVar.zzb = j6;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzkr zzkrVar, byte[] bArr, int i5, int i6, int i7, zzgj zzgjVar) {
        int zzc = ((zzkh) zzkrVar).zzc(obj, bArr, i5, i6, i7, zzgjVar);
        zzgjVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(Object obj, zzkr zzkrVar, byte[] bArr, int i5, int i6, zzgj zzgjVar) {
        int i7 = i5 + 1;
        int i8 = bArr[i5];
        if (i8 < 0) {
            i7 = zzj(i8, bArr, i7, zzgjVar);
            i8 = zzgjVar.zza;
        }
        int i9 = i7;
        if (i8 < 0 || i8 > i6 - i9) {
            throw zzje.zzj();
        }
        int i10 = i8 + i9;
        zzkrVar.zzi(obj, bArr, i9, i10, zzgjVar);
        zzgjVar.zzc = obj;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i5, byte[] bArr, int i6, int i7, zzgj zzgjVar) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 5) {
                                return i6 + 4;
                            }
                            throw zzje.zzc();
                        }
                        int i9 = (i5 & (-8)) | 4;
                        int i10 = 0;
                        while (i6 < i7) {
                            i6 = zzi(bArr, i6, zzgjVar);
                            i10 = zzgjVar.zza;
                            if (i10 == i9) {
                                break;
                            }
                            i6 = zzo(i10, bArr, i6, i7, zzgjVar);
                        }
                        if (i6 > i7 || i10 != i9) {
                            throw zzje.zzg();
                        }
                        return i6;
                    }
                    return zzi(bArr, i6, zzgjVar) + zzgjVar.zza;
                }
                return i6 + 8;
            }
            return zzl(bArr, i6, zzgjVar);
        }
        throw zzje.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzp(byte[] bArr, int i5) {
        return (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48) | ((bArr[i5 + 7] & 255) << 56);
    }
}
