package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import i2.a0;
import i2.d0;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkh<T> implements zzkr<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzlv.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzke zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzjs zzm;
    private final zzll zzn;
    private final zzif zzo;
    private final zzkk zzp;
    private final zzjz zzq;

    private zzkh(int[] iArr, Object[] objArr, int i5, int i6, zzke zzkeVar, int i7, boolean z4, int[] iArr2, int i8, int i9, zzkk zzkkVar, zzjs zzjsVar, zzll zzllVar, zzif zzifVar, zzjz zzjzVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i5;
        this.zzf = i6;
        this.zzi = zzkeVar instanceof zzit;
        boolean z5 = false;
        if (zzifVar != null && zzifVar.zzj(zzkeVar)) {
            z5 = true;
        }
        this.zzh = z5;
        this.zzj = iArr2;
        this.zzk = i8;
        this.zzl = i9;
        this.zzp = zzkkVar;
        this.zzm = zzjsVar;
        this.zzn = zzllVar;
        this.zzo = zzifVar;
        this.zzg = zzkeVar;
        this.zzq = zzjzVar;
    }

    private final Object zzA(Object obj, int i5) {
        zzkr zzx = zzx(i5);
        int zzu = zzu(i5) & 1048575;
        if (zzN(obj, i5)) {
            Object object = zzb.getObject(obj, zzu);
            if (zzQ(object)) {
                return object;
            }
            Object zze = zzx.zze();
            if (object != null) {
                zzx.zzg(zze, object);
            }
            return zze;
        }
        return zzx.zze();
    }

    private final Object zzB(Object obj, int i5, int i6) {
        zzkr zzx = zzx(i6);
        if (zzR(obj, i5, i6)) {
            Object object = zzb.getObject(obj, zzu(i6) & 1048575);
            if (zzQ(object)) {
                return object;
            }
            Object zze = zzx.zze();
            if (object != null) {
                zzx.zzg(zze, object);
            }
            return zze;
        }
        return zzx.zze();
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i5) {
        if (zzN(obj2, i5)) {
            Unsafe unsafe = zzb;
            long zzu = zzu(i5) & 1048575;
            Object object = unsafe.getObject(obj2, zzu);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + obj2.toString());
            }
            zzkr zzx = zzx(i5);
            if (!zzN(obj, i5)) {
                if (zzQ(object)) {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, zzu, zze);
                } else {
                    unsafe.putObject(obj, zzu, object);
                }
                zzH(obj, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzu);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, zzu, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i5) {
        int i6 = this.zzc[i5];
        if (zzR(obj2, i6, i5)) {
            Unsafe unsafe = zzb;
            long zzu = zzu(i5) & 1048575;
            Object object = unsafe.getObject(obj2, zzu);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + obj2.toString());
            }
            zzkr zzx = zzx(i5);
            if (!zzR(obj, i6, i5)) {
                if (zzQ(object)) {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, zzu, zze);
                } else {
                    unsafe.putObject(obj, zzu, object);
                }
                zzI(obj, i6, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzu);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, zzu, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i5, zzkq zzkqVar) {
        zzlv.zzs(obj, i5 & 1048575, zzM(i5) ? zzkqVar.zzs() : this.zzi ? zzkqVar.zzr() : zzkqVar.zzp());
    }

    private final void zzH(Object obj, int i5) {
        int zzr = zzr(i5);
        long j5 = 1048575 & zzr;
        if (j5 == 1048575) {
            return;
        }
        zzlv.zzq(obj, j5, (1 << (zzr >>> 20)) | zzlv.zzc(obj, j5));
    }

    private final void zzI(Object obj, int i5, int i6) {
        zzlv.zzq(obj, zzr(i6) & 1048575, i5);
    }

    private final void zzJ(Object obj, int i5, Object obj2) {
        zzb.putObject(obj, zzu(i5) & 1048575, obj2);
        zzH(obj, i5);
    }

    private final void zzK(Object obj, int i5, int i6, Object obj2) {
        zzb.putObject(obj, zzu(i6) & 1048575, obj2);
        zzI(obj, i5, i6);
    }

    private final boolean zzL(Object obj, Object obj2, int i5) {
        return zzN(obj, i5) == zzN(obj2, i5);
    }

    private static boolean zzM(int i5) {
        return (i5 & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i5) {
        int zzr = zzr(i5);
        long j5 = zzr & 1048575;
        if (j5 != 1048575) {
            return (zzlv.zzc(obj, j5) & (1 << (zzr >>> 20))) != 0;
        }
        int zzu = zzu(i5);
        long j6 = zzu & 1048575;
        switch (zzt(zzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzlv.zza(obj, j6)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzlv.zzb(obj, j6)) != 0;
            case 2:
                return zzlv.zzd(obj, j6) != 0;
            case 3:
                return zzlv.zzd(obj, j6) != 0;
            case 4:
                return zzlv.zzc(obj, j6) != 0;
            case 5:
                return zzlv.zzd(obj, j6) != 0;
            case 6:
                return zzlv.zzc(obj, j6) != 0;
            case 7:
                return zzlv.zzw(obj, j6);
            case 8:
                Object zzf = zzlv.zzf(obj, j6);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzgw) {
                    return !zzgw.zzb.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return zzlv.zzf(obj, j6) != null;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return !zzgw.zzb.equals(zzlv.zzf(obj, j6));
            case 11:
                return zzlv.zzc(obj, j6) != 0;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return zzlv.zzc(obj, j6) != 0;
            case 13:
                return zzlv.zzc(obj, j6) != 0;
            case 14:
                return zzlv.zzd(obj, j6) != 0;
            case 15:
                return zzlv.zzc(obj, j6) != 0;
            case 16:
                return zzlv.zzd(obj, j6) != 0;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzlv.zzf(obj, j6) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i5, int i6, int i7, int i8) {
        return i6 == 1048575 ? zzN(obj, i5) : (i7 & i8) != 0;
    }

    private static boolean zzP(Object obj, int i5, zzkr zzkrVar) {
        return zzkrVar.zzl(zzlv.zzf(obj, i5 & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzit) {
            return ((zzit) obj).zzG();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i5, int i6) {
        return zzlv.zzc(obj, (long) (zzr(i6) & 1048575)) == i5;
    }

    private static boolean zzS(Object obj, long j5) {
        return ((Boolean) zzlv.zzf(obj, j5)).booleanValue();
    }

    private static final void zzT(int i5, Object obj, zzmd zzmdVar) {
        if (obj instanceof String) {
            zzmdVar.zzG(i5, (String) obj);
        } else {
            zzmdVar.zzd(i5, (zzgw) obj);
        }
    }

    static zzlm zzd(Object obj) {
        zzit zzitVar = (zzit) obj;
        zzlm zzlmVar = zzitVar.zzc;
        if (zzlmVar == zzlm.zzc()) {
            zzlm zzf = zzlm.zzf();
            zzitVar.zzc = zzf;
            return zzf;
        }
        return zzlmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.recaptcha.internal.zzkh zzm(java.lang.Class r33, com.google.android.recaptcha.internal.zzkb r34, com.google.android.recaptcha.internal.zzkk r35, com.google.android.recaptcha.internal.zzjs r36, com.google.android.recaptcha.internal.zzll r37, com.google.android.recaptcha.internal.zzif r38, com.google.android.recaptcha.internal.zzjz r39) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzkh.zzm(java.lang.Class, com.google.android.recaptcha.internal.zzkb, com.google.android.recaptcha.internal.zzkk, com.google.android.recaptcha.internal.zzjs, com.google.android.recaptcha.internal.zzll, com.google.android.recaptcha.internal.zzif, com.google.android.recaptcha.internal.zzjz):com.google.android.recaptcha.internal.zzkh");
    }

    private static double zzn(Object obj, long j5) {
        return ((Double) zzlv.zzf(obj, j5)).doubleValue();
    }

    private static float zzo(Object obj, long j5) {
        return ((Float) zzlv.zzf(obj, j5)).floatValue();
    }

    private static int zzp(Object obj, long j5) {
        return ((Integer) zzlv.zzf(obj, j5)).intValue();
    }

    private final int zzq(int i5) {
        if (i5 < this.zze || i5 > this.zzf) {
            return -1;
        }
        return zzs(i5, 0);
    }

    private final int zzr(int i5) {
        return this.zzc[i5 + 2];
    }

    private final int zzs(int i5, int i6) {
        int length = (this.zzc.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = this.zzc[i8];
            if (i5 == i9) {
                return i8;
            }
            if (i5 < i9) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i5) {
        return (i5 >>> 20) & 255;
    }

    private final int zzu(int i5) {
        return this.zzc[i5 + 1];
    }

    private static long zzv(Object obj, long j5) {
        return ((Long) zzlv.zzf(obj, j5)).longValue();
    }

    private final zzix zzw(int i5) {
        int i6 = i5 / 3;
        return (zzix) this.zzd[i6 + i6 + 1];
    }

    private final zzkr zzx(int i5) {
        Object[] objArr = this.zzd;
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        zzkr zzkrVar = (zzkr) objArr[i7];
        if (zzkrVar != null) {
            return zzkrVar;
        }
        zzkr zzb2 = zzkn.zza().zzb((Class) objArr[i7 + 1]);
        this.zzd[i7] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i5, Object obj2, zzll zzllVar, Object obj3) {
        int i6 = this.zzc[i5];
        Object zzf = zzlv.zzf(obj, zzu(i5) & 1048575);
        if (zzf == null || zzw(i5) == null) {
            return obj2;
        }
        zzjy zzjyVar = (zzjy) zzf;
        zzjx zzjxVar = (zzjx) zzz(i5);
        throw null;
    }

    private final Object zzz(int i5) {
        int i6 = i5 / 3;
        return this.zzd[i6 + i6];
    }

    /* JADX WARN: Code restructure failed: missing block: B:243:0x0512, code lost:
        if ((r1 instanceof com.google.android.recaptcha.internal.zzgw) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0515, code lost:
        r1 = com.google.android.recaptcha.internal.zzhh.zzx((java.lang.String) r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d2, code lost:
        if ((r1 instanceof com.google.android.recaptcha.internal.zzgw) != false) goto L58;
     */
    @Override // com.google.android.recaptcha.internal.zzkr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzkh.zza(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cc, code lost:
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e0, code lost:
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e2, code lost:
        r6 = r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e6, code lost:
        r1 = r1 + r6;
     */
    @Override // com.google.android.recaptcha.internal.zzkr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzkh.zzb(java.lang.Object):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x04f5, code lost:
        if (r1 == 0) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x04f7, code lost:
        r13.add(com.google.android.recaptcha.internal.zzgw.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x04fd, code lost:
        r13.add(com.google.android.recaptcha.internal.zzgw.zzm(r34, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0505, code lost:
        if (r0 >= r7) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0507, code lost:
        r1 = com.google.android.recaptcha.internal.zzgk.zzi(r34, r0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x050d, code lost:
        if (r24 != r12.zza) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x050f, code lost:
        r0 = com.google.android.recaptcha.internal.zzgk.zzi(r34, r1, r12);
        r1 = r12.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0515, code lost:
        if (r1 < 0) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0519, code lost:
        if (r1 > (r34.length - r0)) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x051b, code lost:
        if (r1 != 0) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0522, code lost:
        throw com.google.android.recaptcha.internal.zzje.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0527, code lost:
        throw com.google.android.recaptcha.internal.zzje.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0528, code lost:
        r14 = r0;
        r8 = r12;
        r12 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x065b, code lost:
        if (r1.zzb != 0) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x065d, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x065f, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0660, code lost:
        r13.zze(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0663, code lost:
        if (r8 >= r7) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0665, code lost:
        r9 = com.google.android.recaptcha.internal.zzgk.zzi(r34, r8, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x066b, code lost:
        if (r2 != r1.zza) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x066d, code lost:
        r8 = com.google.android.recaptcha.internal.zzgk.zzl(r34, r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0675, code lost:
        if (r1.zzb == 0) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x0bd2, code lost:
        if (r5 == r11) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:528:0x0bd4, code lost:
        r30.putInt(r7, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0bda, code lost:
        r10 = r12.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0bdf, code lost:
        if (r10 >= r12.zzl) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0be1, code lost:
        zzy(r33, r12.zzj[r10], null, r12.zzn, r33);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:0x0bf6, code lost:
        if (r9 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0bf8, code lost:
        if (r6 != r36) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0bff, code lost:
        throw com.google.android.recaptcha.internal.zzje.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0c00, code lost:
        if (r6 > r36) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0c02, code lost:
        if (r8 != r9) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x0c04, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0c09, code lost:
        throw com.google.android.recaptcha.internal.zzje.zzg();
     */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0a99 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0aad A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:193:0x04fd -> B:194:0x0505). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:201:0x051b -> B:192:0x04f7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:226:0x058f -> B:227:0x0593). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:232:0x05a5 -> B:224:0x0584). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:246:0x05d9 -> B:247:0x05dd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:252:0x05ef -> B:242:0x05c6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:284:0x065f -> B:285:0x0660). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:290:0x0675 -> B:283:0x065d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.android.recaptcha.internal.zzgj r38) {
        /*
            Method dump skipped, instructions count: 3266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzkh.zzc(java.lang.Object, byte[], int, int, int, com.google.android.recaptcha.internal.zzgj):int");
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final Object zze() {
        return ((zzit) this.zzg).zzs();
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzf(Object obj) {
        int i5;
        if (zzQ(obj)) {
            if (obj instanceof zzit) {
                zzit zzitVar = (zzit) obj;
                zzitVar.zzE(a.e.API_PRIORITY_OTHER);
                zzitVar.zza = 0;
                zzitVar.zzC();
            }
            int[] iArr = this.zzc;
            while (i5 < iArr.length) {
                int zzu = zzu(i5);
                int i6 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j5 = i6;
                if (zzt != 9) {
                    if (zzt != 60 && zzt != 68) {
                        switch (zzt) {
                            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zzb(obj, j5);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j5);
                                if (object == null) {
                                    break;
                                } else {
                                    ((zzjy) object).zzc();
                                    unsafe.putObject(obj, j5, object);
                                    break;
                                }
                        }
                    } else {
                        if (!zzR(obj, this.zzc[i5], i5)) {
                        }
                        zzx(i5).zzf(zzb.getObject(obj, j5));
                    }
                }
                i5 = zzN(obj, i5) ? 0 : i5 + 3;
                zzx(i5).zzf(zzb.getObject(obj, j5));
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zzf(obj);
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int zzu = zzu(i5);
            int i6 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i7 = iArr[i5];
            long j5 = i6;
            switch (zzt) {
                case 0:
                    if (zzN(obj2, i5)) {
                        zzlv.zzo(obj, j5, zzlv.zza(obj2, j5));
                        zzH(obj, i5);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i5)) {
                        zzlv.zzp(obj, j5, zzlv.zzb(obj2, j5));
                        zzH(obj, i5);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzr(obj, j5, zzlv.zzd(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 3:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzr(obj, j5, zzlv.zzd(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 4:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzq(obj, j5, zzlv.zzc(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 5:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzr(obj, j5, zzlv.zzd(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 6:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzq(obj, j5, zzlv.zzc(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 7:
                    if (zzN(obj2, i5)) {
                        zzlv.zzm(obj, j5, zzlv.zzw(obj2, j5));
                        zzH(obj, i5);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzs(obj, j5, zzlv.zzf(obj2, j5));
                    zzH(obj, i5);
                    break;
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    zzE(obj, obj2, i5);
                    break;
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzs(obj, j5, zzlv.zzf(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 11:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzq(obj, j5, zzlv.zzc(obj2, j5));
                    zzH(obj, i5);
                    break;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzq(obj, j5, zzlv.zzc(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 13:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzq(obj, j5, zzlv.zzc(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 14:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzr(obj, j5, zzlv.zzd(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 15:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzq(obj, j5, zzlv.zzc(obj2, j5));
                    zzH(obj, i5);
                    break;
                case 16:
                    if (!zzN(obj2, i5)) {
                        break;
                    }
                    zzlv.zzr(obj, j5, zzlv.zzd(obj2, j5));
                    zzH(obj, i5);
                    break;
                case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzc(obj, obj2, j5);
                    break;
                case 50:
                    int i8 = zzkt.zza;
                    zzlv.zzs(obj, j5, zzjz.zzb(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzR(obj2, i7, i5)) {
                        break;
                    }
                    zzlv.zzs(obj, j5, zzlv.zzf(obj2, j5));
                    zzI(obj, i7, i5);
                    break;
                case 60:
                case 68:
                    zzF(obj, obj2, i5);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzR(obj2, i7, i5)) {
                        break;
                    }
                    zzlv.zzs(obj, j5, zzlv.zzf(obj2, j5));
                    zzI(obj, i7, i5);
                    break;
            }
        }
        zzkt.zzr(this.zzn, obj, obj2);
        if (this.zzh) {
            zzkt.zzq(this.zzo, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05d3 A[LOOP:2: B:185:0x05cf->B:187:0x05d3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzkr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r18, com.google.android.recaptcha.internal.zzkq r19, com.google.android.recaptcha.internal.zzie r20) {
        /*
            Method dump skipped, instructions count: 1658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzkh.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzkq, com.google.android.recaptcha.internal.zzie):void");
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final void zzi(Object obj, byte[] bArr, int i5, int i6, zzgj zzgjVar) {
        zzc(obj, bArr, i5, i6, 0, zzgjVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0697  */
    @Override // com.google.android.recaptcha.internal.zzkr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r24, com.google.android.recaptcha.internal.zzmd r25) {
        /*
            Method dump skipped, instructions count: 1862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzkh.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzmd):void");
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final boolean zzk(Object obj, Object obj2) {
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int zzu = zzu(i5);
            long j5 = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i5) && Double.doubleToLongBits(zzlv.zza(obj, j5)) == Double.doubleToLongBits(zzlv.zza(obj2, j5))) {
                        break;
                    }
                    return false;
                case 1:
                    if (zzL(obj, obj2, i5) && Float.floatToIntBits(zzlv.zzb(obj, j5)) == Float.floatToIntBits(zzlv.zzb(obj2, j5))) {
                        break;
                    }
                    return false;
                case 2:
                    if (zzL(obj, obj2, i5) && zzlv.zzd(obj, j5) == zzlv.zzd(obj2, j5)) {
                        break;
                    }
                    return false;
                case 3:
                    if (zzL(obj, obj2, i5) && zzlv.zzd(obj, j5) == zzlv.zzd(obj2, j5)) {
                        break;
                    }
                    return false;
                case 4:
                    if (zzL(obj, obj2, i5) && zzlv.zzc(obj, j5) == zzlv.zzc(obj2, j5)) {
                        break;
                    }
                    return false;
                case 5:
                    if (zzL(obj, obj2, i5) && zzlv.zzd(obj, j5) == zzlv.zzd(obj2, j5)) {
                        break;
                    }
                    return false;
                case 6:
                    if (zzL(obj, obj2, i5) && zzlv.zzc(obj, j5) == zzlv.zzc(obj2, j5)) {
                        break;
                    }
                    return false;
                case 7:
                    if (zzL(obj, obj2, i5) && zzlv.zzw(obj, j5) == zzlv.zzw(obj2, j5)) {
                        break;
                    }
                    return false;
                case 8:
                    if (zzL(obj, obj2, i5) && zzkt.zzH(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5))) {
                        break;
                    }
                    return false;
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    if (zzL(obj, obj2, i5) && zzkt.zzH(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5))) {
                        break;
                    }
                    return false;
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    if (zzL(obj, obj2, i5) && zzkt.zzH(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5))) {
                        break;
                    }
                    return false;
                case 11:
                    if (zzL(obj, obj2, i5) && zzlv.zzc(obj, j5) == zzlv.zzc(obj2, j5)) {
                        break;
                    }
                    return false;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    if (zzL(obj, obj2, i5) && zzlv.zzc(obj, j5) == zzlv.zzc(obj2, j5)) {
                        break;
                    }
                    return false;
                case 13:
                    if (zzL(obj, obj2, i5) && zzlv.zzc(obj, j5) == zzlv.zzc(obj2, j5)) {
                        break;
                    }
                    return false;
                case 14:
                    if (zzL(obj, obj2, i5) && zzlv.zzd(obj, j5) == zzlv.zzd(obj2, j5)) {
                        break;
                    }
                    return false;
                case 15:
                    if (zzL(obj, obj2, i5) && zzlv.zzc(obj, j5) == zzlv.zzc(obj2, j5)) {
                        break;
                    }
                    return false;
                case 16:
                    if (zzL(obj, obj2, i5) && zzlv.zzd(obj, j5) == zzlv.zzd(obj2, j5)) {
                        break;
                    }
                    return false;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    if (zzL(obj, obj2, i5) && zzkt.zzH(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5))) {
                        break;
                    }
                    return false;
                case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    if (zzkt.zzH(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5))) {
                        break;
                    } else {
                        return false;
                    }
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzr = zzr(i5) & 1048575;
                    if (zzlv.zzc(obj, zzr) == zzlv.zzc(obj2, zzr) && zzkt.zzH(zzlv.zzf(obj, j5), zzlv.zzf(obj2, j5))) {
                        break;
                    }
                    return false;
            }
        }
        if (this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            if (this.zzh) {
                return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzkr
    public final boolean zzl(Object obj) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i10 = iArr[i9];
            int i11 = iArr2[i10];
            int zzu = zzu(i10);
            int i12 = this.zzc[i10 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i7) {
                if (i13 != 1048575) {
                    i8 = zzb.getInt(obj, i13);
                }
                i6 = i8;
                i5 = i13;
            } else {
                i5 = i7;
                i6 = i8;
            }
            if ((268435456 & zzu) != 0 && !zzO(obj, i10, i5, i6, i14)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, i11, i10) && !zzP(obj, zzu, zzx(i10))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzjy) zzlv.zzf(obj, zzu & 1048575)).isEmpty()) {
                            zzjx zzjxVar = (zzjx) zzz(i10);
                            throw null;
                        }
                    }
                }
                List list = (List) zzlv.zzf(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzkr zzx = zzx(i10);
                    for (int i15 = 0; i15 < list.size(); i15++) {
                        if (!zzx.zzl(list.get(i15))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzO(obj, i10, i5, i6, i14) && !zzP(obj, zzu, zzx(i10))) {
                return false;
            }
            i9++;
            i7 = i5;
            i8 = i6;
        }
        return !this.zzh || this.zzo.zzb(obj).zzk();
    }
}
