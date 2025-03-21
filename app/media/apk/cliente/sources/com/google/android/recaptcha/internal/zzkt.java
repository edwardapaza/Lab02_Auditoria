package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkt {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzll zzc;
    private static final zzll zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzll zzllVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzllVar = (zzll) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzllVar;
        zzd = new zzln();
    }

    public static void zzA(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzu(i5, list, z4);
    }

    public static void zzB(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzy(i5, list, z4);
    }

    public static void zzC(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzA(i5, list, z4);
    }

    public static void zzD(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzC(i5, list, z4);
    }

    public static void zzE(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzE(i5, list, z4);
    }

    public static void zzF(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzJ(i5, list, z4);
    }

    public static void zzG(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzL(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziuVar = (zziu) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzu(zziuVar.zze(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzu(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhh.zzy(i5 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i5, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhh.zzy(i5 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziuVar = (zziu) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzu(zziuVar.zze(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzu(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjt) {
            zzjt zzjtVar = (zzjt) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzz(zzjtVar.zze(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzz(((Long) list.get(i6)).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i5, Object obj, zzkr zzkrVar) {
        int i6 = i5 << 3;
        if (!(obj instanceof zzjk)) {
            return zzhh.zzy(i6) + zzhh.zzw((zzke) obj, zzkrVar);
        }
        int i7 = zzhh.zzb;
        int zza2 = ((zzjk) obj).zza();
        return zzhh.zzy(i6) + zzhh.zzy(zza2) + zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziuVar = (zziu) list;
            i5 = 0;
            while (i6 < size) {
                int zze = zziuVar.zze(i6);
                i5 += zzhh.zzy((zze >> 31) ^ (zze + zze));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzhh.zzy((intValue >> 31) ^ (intValue + intValue));
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjt) {
            zzjt zzjtVar = (zzjt) list;
            i5 = 0;
            while (i6 < size) {
                long zze = zzjtVar.zze(i6);
                i5 += zzhh.zzz((zze >> 63) ^ (zze + zze));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzhh.zzz((longValue >> 63) ^ (longValue + longValue));
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziuVar = (zziu) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzy(zziuVar.zze(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzy(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjt) {
            zzjt zzjtVar = (zzjt) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzz(zzjtVar.zze(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzhh.zzz(((Long) list.get(i6)).longValue());
                i6++;
            }
        }
        return i5;
    }

    public static zzll zzm() {
        return zzc;
    }

    public static zzll zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i5, List list, zzix zzixVar, Object obj2, zzll zzllVar) {
        if (zzixVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int intValue = ((Integer) list.get(i7)).intValue();
                if (zzixVar.zza(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, Integer.valueOf(intValue));
                    }
                    i6++;
                } else {
                    obj2 = zzp(obj, i5, intValue, obj2, zzllVar);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzixVar.zza(intValue2)) {
                    obj2 = zzp(obj, i5, intValue2, obj2, zzllVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, int i5, int i6, Object obj2, zzll zzllVar) {
        if (obj2 == null) {
            obj2 = zzllVar.zzc(obj);
        }
        zzllVar.zzl(obj2, i5, i6);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzif zzifVar, Object obj, Object obj2) {
        zzij zzb2 = zzifVar.zzb(obj2);
        if (zzb2.zza.isEmpty()) {
            return;
        }
        zzifVar.zzc(obj).zzh(zzb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzr(zzll zzllVar, Object obj, Object obj2) {
        zzllVar.zzo(obj, zzllVar.zze(zzllVar.zzd(obj), zzllVar.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzit.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzt(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzc(i5, list, z4);
    }

    public static void zzu(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzg(i5, list, z4);
    }

    public static void zzv(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzj(i5, list, z4);
    }

    public static void zzw(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzl(i5, list, z4);
    }

    public static void zzx(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzn(i5, list, z4);
    }

    public static void zzy(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzp(i5, list, z4);
    }

    public static void zzz(int i5, List list, zzmd zzmdVar, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmdVar.zzs(i5, list, z4);
    }
}
