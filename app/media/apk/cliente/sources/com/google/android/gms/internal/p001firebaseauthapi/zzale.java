package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzale  reason: invalid package */
/* loaded from: classes.dex */
public final class zzale {
    private static final Class<?> zza = zzd();
    private static final zzamb<?, ?> zzb = zzc();
    private static final zzamb<?, ?> zzc = new zzamd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, Object obj, zzalc zzalcVar) {
        return obj instanceof zzajo ? zzaii.zzb(i5, (zzajo) obj) : zzaii.zzb(i5, (zzakk) obj, zzalcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, List<zzahm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = size * zzaii.zzg(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            zzg += zzaii.zza(list.get(i6));
        }
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, List<zzakk> list, zzalc zzalcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += zzaii.zza(i5, list.get(i7), zzalcVar);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaii.zza(i5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<?> list) {
        return list.size();
    }

    public static zzamb<?, ?> zza() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i5, int i6, UB ub, zzamb<UT, UB> zzambVar) {
        if (ub == null) {
            ub = zzambVar.zzc(obj);
        }
        zzambVar.zzb(ub, i5, i6);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i5, List<Integer> list, zzajh zzajhVar, UB ub, zzamb<UT, UB> zzambVar) {
        if (zzajhVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int intValue = list.get(i7).intValue();
                if (zzajhVar.zza(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, Integer.valueOf(intValue));
                    }
                    i6++;
                } else {
                    ub = (UB) zza(obj, i5, intValue, ub, zzambVar);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzajhVar.zza(intValue2)) {
                    ub = (UB) zza(obj, i5, intValue2, ub, zzambVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void zza(int i5, List<zzahm> list, zzanb zzanbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zza(i5, list);
    }

    public static void zza(int i5, List<?> list, zzanb zzanbVar, zzalc zzalcVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zza(i5, list, zzalcVar);
    }

    public static void zza(int i5, List<Boolean> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zza(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzaiu<FT>> void zza(zzair<FT> zzairVar, T t5, T t6) {
        zzais<FT> zza2 = zzairVar.zza(t6);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzairVar.zzb(t5).zza(zza2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzakh zzakhVar, T t5, T t6, long j5) {
        zzamh.zza(t5, j5, zzakhVar.zza(zzamh.zze(t5, j5), zzamh.zze(t6, j5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzamb<UT, UB> zzambVar, T t5, T t6) {
        zzambVar.zzc(t5, zzambVar.zza(zzambVar.zzd(t5), zzambVar.zzd(t6)));
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzaja.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int zzg = zzaii.zzg(i5) * size;
        if (list instanceof zzajq) {
            zzajq zzajqVar = (zzajq) list;
            while (i6 < size) {
                Object zzb2 = zzajqVar.zzb(i6);
                zzg += zzb2 instanceof zzahm ? zzaii.zza((zzahm) zzb2) : zzaii.zza((String) zzb2);
                i6++;
            }
        } else {
            while (i6 < size) {
                Object obj = list.get(i6);
                zzg += obj instanceof zzahm ? zzaii.zza((zzahm) obj) : zzaii.zza((String) obj);
                i6++;
            }
        }
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List<?> list, zzalc zzalcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = zzaii.zzg(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            zzg += obj instanceof zzajo ? zzaii.zza((zzajo) obj) : zzaii.zza((zzakk) obj, zzalcVar);
        }
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zza(zzajdVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zza(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static zzamb<?, ?> zzb() {
        return zzc;
    }

    public static void zzb(int i5, List<String> list, zzanb zzanbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzb(i5, list);
    }

    public static void zzb(int i5, List<?> list, zzanb zzanbVar, zzalc zzalcVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzb(i5, list, zzalcVar);
    }

    public static void zzb(int i5, List<Double> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzb(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaii.zzb(i5, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    private static zzamb<?, ?> zzc() {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzamb) zze.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzc(int i5, List<Integer> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzc(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaii.zza(i5, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzd(int i5, List<Integer> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzd(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzc(zzajdVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzc(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i5, List<Long> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zze(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i5, List<Long> list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajz) {
            zzajz zzajzVar = (zzajz) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzb(zzajzVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzb(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    public static void zzf(int i5, List<Float> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzf(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzf(zzajdVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzf(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static void zzg(int i5, List<Integer> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzg(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajz) {
            zzajz zzajzVar = (zzajz) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzd(zzajzVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzd(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    public static void zzh(int i5, List<Long> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzh(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzh(zzajdVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zzh(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static void zzi(int i5, List<Integer> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzi(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaii.zzg(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajz) {
            zzajz zzajzVar = (zzajz) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zze(zzajzVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzaii.zze(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    public static void zzj(int i5, List<Long> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzj(i5, list, z4);
    }

    public static void zzk(int i5, List<Integer> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzk(i5, list, z4);
    }

    public static void zzl(int i5, List<Long> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzl(i5, list, z4);
    }

    public static void zzm(int i5, List<Integer> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzm(i5, list, z4);
    }

    public static void zzn(int i5, List<Long> list, zzanb zzanbVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanbVar.zzn(i5, list, z4);
    }
}
