package com.google.android.gms.internal.maps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public abstract class zzba extends zzaw implements Set {
    @CheckForNull
    private transient zzaz zza;

    static int zzf(int i) {
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
        } while (highestOneBit * 0.7d < max);
        return highestOneBit;
    }

    @SafeVarargs
    public static zzba zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = {"ADMINISTRATIVE_AREA_LEVEL_1", "ADMINISTRATIVE_AREA_LEVEL_2", "COUNTRY", "LOCALITY", "POSTAL_CODE", "SCHOOL_DISTRICT"};
        System.arraycopy(objArr, 0, objArr2, 6, 0);
        return zzk(6, objArr2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzba) && zzj() && ((zzba) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException e) {
            } catch (NullPointerException e2) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzbf iterator();

    public final zzaz zzg() {
        zzaz zzazVar = this.zza;
        if (zzazVar == null) {
            zzaz zzh = zzh();
            this.zza = zzh;
            return zzh;
        }
        return zzazVar;
    }

    zzaz zzh() {
        Object[] array = toArray();
        int i = zzaz.zzd;
        return zzaz.zzg(array, array.length);
    }

    boolean zzj() {
        return false;
    }

    private static zzba zzk(int i, Object... objArr) {
        Object[] objArr2;
        switch (i) {
            case 0:
                return zzbd.zza;
            case 1:
                Object obj = objArr[0];
                obj.getClass();
                return new zzbe(obj);
            default:
                int zzf = zzf(i);
                Object[] objArr3 = new Object[zzf];
                int i2 = zzf - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object obj2 = objArr[i5];
                    if (obj2 == null) {
                        throw new NullPointerException("at index " + i5);
                    }
                    int hashCode = obj2.hashCode();
                    int zza = zzav.zza(hashCode);
                    while (true) {
                        int i6 = zza & i2;
                        Object obj3 = objArr3[i6];
                        if (obj3 != null) {
                            if (!obj3.equals(obj2)) {
                                zza++;
                            }
                        } else {
                            objArr[i4] = obj2;
                            objArr3[i6] = obj2;
                            i3 += hashCode;
                            i4++;
                        }
                    }
                }
                Arrays.fill(objArr, i4, i, (Object) null);
                if (i4 == 1) {
                    Object obj4 = objArr[0];
                    obj4.getClass();
                    return new zzbe(obj4);
                }
                if (zzf(i4) >= zzf / 2) {
                    if (i4 >= 4) {
                        objArr2 = objArr;
                    } else {
                        objArr2 = Arrays.copyOf(objArr, i4);
                    }
                    return new zzbd(objArr2, i3, objArr3, i2, i4);
                }
                return zzk(i4, objArr);
        }
    }
}
