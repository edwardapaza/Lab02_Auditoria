package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
import i2.a0;
import i2.d0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako  reason: invalid package */
/* loaded from: classes.dex */
public final class zzako<T> implements zzalc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzamh.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzakk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final zzakz zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzaks zzo;
    private final zzajt zzp;
    private final zzamb<?, ?> zzq;
    private final zzair<?> zzr;
    private final zzakh zzs;

    private zzako(int[] iArr, Object[] objArr, int i5, int i6, zzakk zzakkVar, zzakz zzakzVar, boolean z4, int[] iArr2, int i7, int i8, zzaks zzaksVar, zzajt zzajtVar, zzamb<?, ?> zzambVar, zzair<?> zzairVar, zzakh zzakhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i5;
        this.zzf = i6;
        this.zzi = zzakkVar instanceof zzaja;
        this.zzj = zzakzVar;
        this.zzh = zzairVar != null && zzairVar.zza(zzakkVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i7;
        this.zzn = i8;
        this.zzo = zzaksVar;
        this.zzp = zzajtVar;
        this.zzq = zzambVar;
        this.zzr = zzairVar;
        this.zzg = zzakkVar;
        this.zzs = zzakhVar;
    }

    private static <T> double zza(T t5, long j5) {
        return ((Double) zzamh.zze(t5, j5)).doubleValue();
    }

    private final int zza(int i5) {
        if (i5 < this.zze || i5 > this.zzf) {
            return -1;
        }
        return zza(i5, 0);
    }

    private final int zza(int i5, int i6) {
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

    private static int zza(byte[] bArr, int i5, int i6, zzamo zzamoVar, Class<?> cls, zzahl zzahlVar) {
        int zzd;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        int i7;
        long j5;
        switch (zzakr.zza[zzamoVar.ordinal()]) {
            case 1:
                zzd = zzahi.zzd(bArr, i5, zzahlVar);
                valueOf = Boolean.valueOf(zzahlVar.zzb != 0);
                zzahlVar.zzc = valueOf;
                return zzd;
            case 2:
                return zzahi.zza(bArr, i5, zzahlVar);
            case 3:
                valueOf2 = Double.valueOf(zzahi.zza(bArr, i5));
                zzahlVar.zzc = valueOf2;
                return i5 + 8;
            case 4:
            case 5:
                valueOf3 = Integer.valueOf(zzahi.zzc(bArr, i5));
                zzahlVar.zzc = valueOf3;
                return i5 + 4;
            case 6:
            case 7:
                valueOf2 = Long.valueOf(zzahi.zzd(bArr, i5));
                zzahlVar.zzc = valueOf2;
                return i5 + 8;
            case 8:
                valueOf3 = Float.valueOf(zzahi.zzb(bArr, i5));
                zzahlVar.zzc = valueOf3;
                return i5 + 4;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                zzd = zzahi.zzc(bArr, i5, zzahlVar);
                i7 = zzahlVar.zza;
                valueOf = Integer.valueOf(i7);
                zzahlVar.zzc = valueOf;
                return zzd;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
                zzd = zzahi.zzd(bArr, i5, zzahlVar);
                j5 = zzahlVar.zzb;
                valueOf = Long.valueOf(j5);
                zzahlVar.zzc = valueOf;
                return zzd;
            case 14:
                return zzahi.zza(zzaky.zza().zza((Class) cls), bArr, i5, i6, zzahlVar);
            case 15:
                zzd = zzahi.zzc(bArr, i5, zzahlVar);
                i7 = zzaib.zze(zzahlVar.zza);
                valueOf = Integer.valueOf(i7);
                zzahlVar.zzc = valueOf;
                return zzd;
            case 16:
                zzd = zzahi.zzd(bArr, i5, zzahlVar);
                j5 = zzaib.zza(zzahlVar.zzb);
                valueOf = Long.valueOf(j5);
                zzahlVar.zzc = valueOf;
                return zzd;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzahi.zzb(bArr, i5, zzahlVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.android.gms.internal.p001firebaseauthapi.zzako<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.p001firebaseauthapi.zzaki r33, com.google.android.gms.internal.p001firebaseauthapi.zzaks r34, com.google.android.gms.internal.p001firebaseauthapi.zzajt r35, com.google.android.gms.internal.p001firebaseauthapi.zzamb<?, ?> r36, com.google.android.gms.internal.p001firebaseauthapi.zzair<?> r37, com.google.android.gms.internal.p001firebaseauthapi.zzakh r38) {
        /*
            Method dump skipped, instructions count: 1021
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zza(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzaki, com.google.android.gms.internal.firebase-auth-api.zzaks, com.google.android.gms.internal.firebase-auth-api.zzajt, com.google.android.gms.internal.firebase-auth-api.zzamb, com.google.android.gms.internal.firebase-auth-api.zzair, com.google.android.gms.internal.firebase-auth-api.zzakh):com.google.android.gms.internal.firebase-auth-api.zzako");
    }

    private final <K, V, UT, UB> UB zza(int i5, int i6, Map<K, V> map, zzajh zzajhVar, UB ub, zzamb<UT, UB> zzambVar, Object obj) {
        zzakf<?, ?> zza2 = this.zzs.zza(zzf(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzajhVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzambVar.zzc(obj);
                }
                zzahv zzc = zzahm.zzc(zzakc.zza(zza2, next.getKey(), next.getValue()));
                try {
                    zzakc.zza(zzc.zzb(), zza2, next.getKey(), next.getValue());
                    zzambVar.zza((zzamb<UT, UB>) ub, i6, zzc.zza());
                    it.remove();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t5, int i5) {
        zzalc zze = zze(i5);
        long zzc = zzc(i5) & 1048575;
        if (zzc((zzako<T>) t5, i5)) {
            Object object = zzb.getObject(t5, zzc);
            if (zzg(object)) {
                return object;
            }
            Object zza2 = zze.zza();
            if (object != null) {
                zze.zza(zza2, object);
            }
            return zza2;
        }
        return zze.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t5, int i5, int i6) {
        zzalc zze = zze(i6);
        if (zzc((zzako<T>) t5, i5, i6)) {
            Object object = zzb.getObject(t5, zzc(i6) & 1048575);
            if (zzg(object)) {
                return object;
            }
            Object zza2 = zze.zza();
            if (object != null) {
                zze.zza(zza2, object);
            }
            return zza2;
        }
        return zze.zza();
    }

    private final <UT, UB> UB zza(Object obj, int i5, UB ub, zzamb<UT, UB> zzambVar, Object obj2) {
        zzajh zzd;
        int i6 = this.zzc[i5];
        Object zze = zzamh.zze(obj, zzc(i5) & 1048575);
        return (zze == null || (zzd = zzd(i5)) == null) ? ub : (UB) zza(i5, i6, this.zzs.zze(zze), zzd, (zzajh) ub, (zzamb<UT, zzajh>) zzambVar, obj2);
    }

    private static Field zza(Class<?> cls, String str) {
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

    private static void zza(int i5, Object obj, zzanb zzanbVar) {
        if (obj instanceof String) {
            zzanbVar.zza(i5, (String) obj);
        } else {
            zzanbVar.zza(i5, (zzahm) obj);
        }
    }

    private static <UT, UB> void zza(zzamb<UT, UB> zzambVar, T t5, zzanb zzanbVar) {
        zzambVar.zzb((zzamb<UT, UB>) zzambVar.zzd(t5), zzanbVar);
    }

    private final <K, V> void zza(zzanb zzanbVar, int i5, Object obj, int i6) {
        if (obj != null) {
            zzanbVar.zza(i5, this.zzs.zza(zzf(i6)), this.zzs.zzd(obj));
        }
    }

    private final void zza(T t5, int i5, int i6, Object obj) {
        zzb.putObject(t5, zzc(i6) & 1048575, obj);
        zzb((zzako<T>) t5, i5, i6);
    }

    private final void zza(Object obj, int i5, zzald zzaldVar) {
        long j5;
        Object zzp;
        if (zzg(i5)) {
            j5 = i5 & 1048575;
            zzp = zzaldVar.zzr();
        } else {
            int i6 = i5 & 1048575;
            if (this.zzi) {
                j5 = i6;
                zzp = zzaldVar.zzq();
            } else {
                j5 = i6;
                zzp = zzaldVar.zzp();
            }
        }
        zzamh.zza(obj, j5, zzp);
    }

    private final void zza(T t5, int i5, Object obj) {
        zzb.putObject(t5, zzc(i5) & 1048575, obj);
        zzb((zzako<T>) t5, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t5, T t6, int i5) {
        if (zzc((zzako<T>) t6, i5)) {
            long zzc = zzc(i5) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t6, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + String.valueOf(t6));
            }
            zzalc zze = zze(i5);
            if (!zzc((zzako<T>) t5, i5)) {
                if (zzg(object)) {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(t5, zzc, zza2);
                } else {
                    unsafe.putObject(t5, zzc, object);
                }
                zzb((zzako<T>) t5, i5);
                return;
            }
            Object object2 = unsafe.getObject(t5, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(t5, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    private final boolean zza(T t5, int i5, int i6, int i7, int i8) {
        return i6 == 1048575 ? zzc((zzako<T>) t5, i5) : (i7 & i8) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i5, zzalc zzalcVar) {
        return zzalcVar.zzd(zzamh.zze(obj, i5 & 1048575));
    }

    private static <T> float zzb(T t5, long j5) {
        return ((Float) zzamh.zze(t5, j5)).floatValue();
    }

    private final int zzb(int i5) {
        return this.zzc[i5 + 2];
    }

    private final void zzb(T t5, int i5) {
        int zzb2 = zzb(i5);
        long j5 = 1048575 & zzb2;
        if (j5 == 1048575) {
            return;
        }
        zzamh.zza((Object) t5, j5, (1 << (zzb2 >>> 20)) | zzamh.zzc(t5, j5));
    }

    private final void zzb(T t5, int i5, int i6) {
        zzamh.zza((Object) t5, zzb(i6) & 1048575, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t5, T t6, int i5) {
        int i6 = this.zzc[i5];
        if (zzc((zzako<T>) t6, i6, i5)) {
            long zzc = zzc(i5) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t6, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + String.valueOf(t6));
            }
            zzalc zze = zze(i5);
            if (!zzc((zzako<T>) t5, i6, i5)) {
                if (zzg(object)) {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(t5, zzc, zza2);
                } else {
                    unsafe.putObject(t5, zzc, object);
                }
                zzb((zzako<T>) t5, i6, i5);
                return;
            }
            Object object2 = unsafe.getObject(t5, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(t5, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    private final int zzc(int i5) {
        return this.zzc[i5 + 1];
    }

    private static <T> int zzc(T t5, long j5) {
        return ((Integer) zzamh.zze(t5, j5)).intValue();
    }

    private final boolean zzc(T t5, int i5) {
        int zzb2 = zzb(i5);
        long j5 = zzb2 & 1048575;
        if (j5 != 1048575) {
            return (zzamh.zzc(t5, j5) & (1 << (zzb2 >>> 20))) != 0;
        }
        int zzc = zzc(i5);
        long j6 = zzc & 1048575;
        switch ((zzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzamh.zza(t5, j6)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzamh.zzb(t5, j6)) != 0;
            case 2:
                return zzamh.zzd(t5, j6) != 0;
            case 3:
                return zzamh.zzd(t5, j6) != 0;
            case 4:
                return zzamh.zzc(t5, j6) != 0;
            case 5:
                return zzamh.zzd(t5, j6) != 0;
            case 6:
                return zzamh.zzc(t5, j6) != 0;
            case 7:
                return zzamh.zzh(t5, j6);
            case 8:
                Object zze = zzamh.zze(t5, j6);
                if (zze instanceof String) {
                    return !((String) zze).isEmpty();
                } else if (zze instanceof zzahm) {
                    return !zzahm.zza.equals(zze);
                } else {
                    throw new IllegalArgumentException();
                }
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return zzamh.zze(t5, j6) != null;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return !zzahm.zza.equals(zzamh.zze(t5, j6));
            case 11:
                return zzamh.zzc(t5, j6) != 0;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return zzamh.zzc(t5, j6) != 0;
            case 13:
                return zzamh.zzc(t5, j6) != 0;
            case 14:
                return zzamh.zzd(t5, j6) != 0;
            case 15:
                return zzamh.zzc(t5, j6) != 0;
            case 16:
                return zzamh.zzd(t5, j6) != 0;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return zzamh.zze(t5, j6) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzc(T t5, int i5, int i6) {
        return zzamh.zzc(t5, (long) (zzb(i6) & 1048575)) == i5;
    }

    private final boolean zzc(T t5, T t6, int i5) {
        return zzc((zzako<T>) t5, i5) == zzc((zzako<T>) t6, i5);
    }

    private static <T> long zzd(T t5, long j5) {
        return ((Long) zzamh.zze(t5, j5)).longValue();
    }

    private final zzajh zzd(int i5) {
        return (zzajh) this.zzd[((i5 / 3) << 1) + 1];
    }

    private final zzalc zze(int i5) {
        int i6 = (i5 / 3) << 1;
        zzalc zzalcVar = (zzalc) this.zzd[i6];
        if (zzalcVar != null) {
            return zzalcVar;
        }
        zzalc<T> zza2 = zzaky.zza().zza((Class) ((Class) this.zzd[i6 + 1]));
        this.zzd[i6] = zza2;
        return zza2;
    }

    private static zzame zze(Object obj) {
        zzaja zzajaVar = (zzaja) obj;
        zzame zzameVar = zzajaVar.zzb;
        if (zzameVar == zzame.zzc()) {
            zzame zzd = zzame.zzd();
            zzajaVar.zzb = zzd;
            return zzd;
        }
        return zzameVar;
    }

    private static <T> boolean zze(T t5, long j5) {
        return ((Boolean) zzamh.zze(t5, j5)).booleanValue();
    }

    private final Object zzf(int i5) {
        return this.zzd[(i5 / 3) << 1];
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        String valueOf = String.valueOf(obj);
        throw new IllegalArgumentException("Mutating immutable message: " + valueOf);
    }

    private static boolean zzg(int i5) {
        return (i5 & 536870912) != 0;
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzaja) {
            return ((zzaja) obj).zzv();
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d3, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e0, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ed, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01fa, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0207, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0214, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0221, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0223, code lost:
        r1 = (com.google.android.gms.internal.p001firebaseauthapi.zzaii.zzg(r13) + com.google.android.gms.internal.p001firebaseauthapi.zzaii.zzh(r0)) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03d4, code lost:
        if ((r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzahm) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03d7, code lost:
        r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaii.zza(r13, (java.lang.String) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03ed, code lost:
        if (zza((com.google.android.gms.internal.p001firebaseauthapi.zzako<T>) r19, r11, r14, r16, r17) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03ef, code lost:
        r0 = com.google.android.gms.internal.p001firebaseauthapi.zzaii.zza(r13, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:
        if ((r0 instanceof com.google.android.gms.internal.p001firebaseauthapi.zzahm) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e1, code lost:
        if (zzc((com.google.android.gms.internal.p001firebaseauthapi.zzako<T>) r19, r13, r11) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0180, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x018e, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019c, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01aa, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b8, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01c6, code lost:
        if (r0 > 0) goto L85;
     */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v5 */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(T r19) {
        /*
            Method dump skipped, instructions count: 1440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zza(java.lang.Object):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0555, code lost:
        if (r1 == 0) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0557, code lost:
        r13.add(com.google.android.gms.internal.p001firebaseauthapi.zzahm.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x055d, code lost:
        r13.add(com.google.android.gms.internal.p001firebaseauthapi.zzahm.zza(r34, r0, r1));
        r0 = r0 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0565, code lost:
        if (r0 >= r10) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0567, code lost:
        r1 = com.google.android.gms.internal.p001firebaseauthapi.zzahi.zzc(r34, r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x056d, code lost:
        if (r18 != r14.zza) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x056f, code lost:
        r0 = com.google.android.gms.internal.p001firebaseauthapi.zzahi.zzc(r34, r1, r14);
        r1 = r14.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0575, code lost:
        if (r1 < 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0579, code lost:
        if (r1 > (r34.length - r0)) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x057b, code lost:
        if (r1 != 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0582, code lost:
        throw com.google.android.gms.internal.p001firebaseauthapi.zzajj.zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0587, code lost:
        throw com.google.android.gms.internal.p001firebaseauthapi.zzajj.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x06b2, code lost:
        if (r14.zzb != 0) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x06b4, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x06b6, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x06b7, code lost:
        r13.zza(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x06ba, code lost:
        if (r0 >= r5) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x06bc, code lost:
        r8 = com.google.android.gms.internal.p001firebaseauthapi.zzahi.zzc(r34, r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x06c2, code lost:
        if (r2 != r14.zza) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x06c4, code lost:
        r0 = com.google.android.gms.internal.p001firebaseauthapi.zzahi.zzd(r34, r8, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x06cc, code lost:
        if (r14.zzb == 0) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x09c2, code lost:
        throw com.google.android.gms.internal.p001firebaseauthapi.zzajj.zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0cad, code lost:
        if (r14 == 1048575) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0caf, code lost:
        r29.putInt(r7, r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0cb5, code lost:
        r3 = null;
        r9 = r32.zzm;
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:0x0cbc, code lost:
        if (r9 >= r32.zzn) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0cbe, code lost:
        r3 = (com.google.android.gms.internal.p001firebaseauthapi.zzame) zza((java.lang.Object) r33, r32.zzl[r9], (int) r3, (com.google.android.gms.internal.p001firebaseauthapi.zzamb<UT, int>) r32.zzq, (java.lang.Object) r33);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0cd4, code lost:
        if (r3 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0cd6, code lost:
        r32.zzq.zzb((java.lang.Object) r7, (T) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0cdd, code lost:
        if (r12 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0cdf, code lost:
        if (r8 != r36) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0ce6, code lost:
        throw com.google.android.gms.internal.p001firebaseauthapi.zzajj.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0ce7, code lost:
        if (r8 > r36) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0ce9, code lost:
        if (r11 != r12) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0ceb, code lost:
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0cf0, code lost:
        throw com.google.android.gms.internal.p001firebaseauthapi.zzajj.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0637  */
    /* JADX WARN: Type inference failed for: r1v75, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:196:0x055d -> B:197:0x0565). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:204:0x057b -> B:195:0x0557). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:228:0x05e7 -> B:229:0x05eb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:234:0x05fd -> B:226:0x05dc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:248:0x0631 -> B:249:0x0635). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:254:0x0647 -> B:244:0x061e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:285:0x06b6 -> B:286:0x06b7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:291:0x06cc -> B:284:0x06b4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.p001firebaseauthapi.zzahl r38) {
        /*
            Method dump skipped, instructions count: 3462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzahl):int");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05b2 A[Catch: all -> 0x026f, TryCatch #8 {all -> 0x026f, blocks: (B:170:0x0586, B:180:0x05ad, B:182:0x05b2, B:183:0x05b7, B:51:0x00cb, B:52:0x00d8, B:53:0x00dd, B:55:0x00f8, B:54:0x00eb, B:56:0x00fd, B:57:0x010b, B:58:0x0119, B:60:0x0123, B:63:0x012a, B:64:0x0131, B:65:0x013b, B:66:0x0149, B:67:0x0153, B:68:0x0162, B:70:0x016b, B:71:0x017a, B:72:0x0189, B:73:0x0198, B:74:0x01a7, B:75:0x01b6, B:76:0x01c5, B:77:0x01d4, B:78:0x01e3, B:80:0x01f3, B:84:0x0214, B:81:0x01fd, B:83:0x0205, B:85:0x0225, B:86:0x0237, B:87:0x0245, B:88:0x0253, B:89:0x0261), top: B:214:0x0586 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05e9 A[LOOP:3: B:198:0x05e5->B:200:0x05e9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x05bd A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.firebase-auth-api.zzald] */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r18, com.google.android.gms.internal.p001firebaseauthapi.zzald r19, com.google.android.gms.internal.p001firebaseauthapi.zzaip r20) {
        /*
            Method dump skipped, instructions count: 1680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzald, com.google.android.gms.internal.firebase-auth-api.zzaip):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0b33  */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r24, com.google.android.gms.internal.p001firebaseauthapi.zzanb r25) {
        /*
            Method dump skipped, instructions count: 3178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzanb):void");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    public final void zza(T t5, T t6) {
        zzf(t5);
        t6.getClass();
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int zzc = zzc(i5);
            long j5 = 1048575 & zzc;
            int i6 = this.zzc[i5];
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzako<T>) t6, i5)) {
                        zzamh.zza(t5, j5, zzamh.zza(t6, j5));
                        zzb((zzako<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzako<T>) t6, i5)) {
                        zzamh.zza((Object) t5, j5, zzamh.zzb(t6, j5));
                        zzb((zzako<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzd(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 3:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzd(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 4:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzc(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 5:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzd(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 6:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzc(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 7:
                    if (zzc((zzako<T>) t6, i5)) {
                        zzamh.zzc(t5, j5, zzamh.zzh(t6, j5));
                        zzb((zzako<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza(t5, j5, zzamh.zze(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    zza(t5, t6, i5);
                    break;
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza(t5, j5, zzamh.zze(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 11:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzc(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzc(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 13:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzc(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 14:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzd(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 15:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzc(t6, j5));
                    zzb((zzako<T>) t5, i5);
                    break;
                case 16:
                    if (!zzc((zzako<T>) t6, i5)) {
                        break;
                    }
                    zzamh.zza((Object) t5, j5, zzamh.zzd(t6, j5));
                    zzb((zzako<T>) t5, i5);
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
                    this.zzp.zza(t5, t6, j5);
                    break;
                case 50:
                    zzale.zza(this.zzs, t5, t6, j5);
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
                    if (!zzc((zzako<T>) t6, i6, i5)) {
                        break;
                    }
                    zzamh.zza(t5, j5, zzamh.zze(t6, j5));
                    zzb((zzako<T>) t5, i6, i5);
                    break;
                case 60:
                case 68:
                    zzb(t5, t6, i5);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzc((zzako<T>) t6, i6, i5)) {
                        break;
                    }
                    zzamh.zza(t5, j5, zzamh.zze(t6, j5));
                    zzb((zzako<T>) t5, i6, i5);
                    break;
            }
        }
        zzale.zza(this.zzq, t5, t6);
        if (this.zzh) {
            zzale.zza(this.zzr, t5, t6);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    public final void zza(T t5, byte[] bArr, int i5, int i6, zzahl zzahlVar) {
        zza((zzako<T>) t5, bArr, i5, i6, 0, zzahlVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ce, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e0, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zzb(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zza(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zza(r11, r6))) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzale.zza(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzale.zza(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cc, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzale.zza(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f8, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzale.zza(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010e, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzale.zza(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p001firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzh(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzh(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0132, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0145, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0156, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzc(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0169, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x017c, code lost:
        if (com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzd(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0195, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p001firebaseauthapi.zzamh.zzb(r11, r6))) goto L84;
     */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseauthapi.zzako.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    public final void zzc(T t5) {
        int i5;
        if (zzg(t5)) {
            if (t5 instanceof zzaja) {
                zzaja zzajaVar = (zzaja) t5;
                zzajaVar.zzb(a.e.API_PRIORITY_OTHER);
                zzajaVar.zza = 0;
                zzajaVar.zzt();
            }
            int length = this.zzc.length;
            while (i5 < length) {
                int zzc = zzc(i5);
                long j5 = 1048575 & zzc;
                int i6 = (zzc & 267386880) >>> 20;
                if (i6 != 9) {
                    if (i6 != 60 && i6 != 68) {
                        switch (i6) {
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
                                this.zzp.zzb(t5, j5);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t5, j5);
                                if (object == null) {
                                    break;
                                } else {
                                    unsafe.putObject(t5, j5, this.zzs.zzc(object));
                                    break;
                                }
                        }
                    } else {
                        if (!zzc((zzako<T>) t5, this.zzc[i5], i5)) {
                        }
                        zze(i5).zzc(zzb.getObject(t5, j5));
                    }
                }
                i5 = zzc((zzako<T>) t5, i5) ? 0 : i5 + 3;
                zze(i5).zzc(zzb.getObject(t5, j5));
            }
            this.zzq.zzf(t5);
            if (this.zzh) {
                this.zzr.zzc(t5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.firebase-auth-api.zzalc] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.firebase-auth-api.zzalc] */
    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzalc
    public final boolean zzd(T t5) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            boolean z4 = true;
            if (i9 >= this.zzm) {
                return !this.zzh || this.zzr.zza(t5).zzg();
            }
            int i10 = this.zzl[i9];
            int i11 = this.zzc[i10];
            int zzc = zzc(i10);
            int i12 = this.zzc[i10 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i7) {
                if (i13 != 1048575) {
                    i8 = zzb.getInt(t5, i13);
                }
                i6 = i8;
                i5 = i13;
            } else {
                i5 = i7;
                i6 = i8;
            }
            if (((268435456 & zzc) != 0) && !zza((zzako<T>) t5, i10, i5, i6, i14)) {
                return false;
            }
            int i15 = (267386880 & zzc) >>> 20;
            if (i15 != 9 && i15 != 17) {
                if (i15 != 27) {
                    if (i15 == 60 || i15 == 68) {
                        if (zzc((zzako<T>) t5, i11, i10) && !zza((Object) t5, zzc, zze(i10))) {
                            return false;
                        }
                    } else if (i15 != 49) {
                        if (i15 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzd = this.zzs.zzd(zzamh.zze(t5, zzc & 1048575));
                            if (!zzd.isEmpty()) {
                                if (this.zzs.zza(zzf(i10)).zzc.zzb() == zzamy.MESSAGE) {
                                    zzalc<T> zzalcVar = 0;
                                    Iterator<?> it = zzd.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzalcVar == null) {
                                            zzalcVar = zzaky.zza().zza((Class) next.getClass());
                                        }
                                        boolean zzd2 = zzalcVar.zzd(next);
                                        zzalcVar = zzalcVar;
                                        if (!zzd2) {
                                            z4 = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z4) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzamh.zze(t5, zzc & 1048575);
                if (!list.isEmpty()) {
                    ?? zze = zze(i10);
                    int i16 = 0;
                    while (true) {
                        if (i16 >= list.size()) {
                            break;
                        } else if (!zze.zzd(list.get(i16))) {
                            z4 = false;
                            break;
                        } else {
                            i16++;
                        }
                    }
                }
                if (!z4) {
                    return false;
                }
            } else if (zza((zzako<T>) t5, i10, i5, i6, i14) && !zza((Object) t5, zzc, zze(i10))) {
                return false;
            }
            i9++;
            i7 = i5;
            i8 = i6;
        }
    }
}
