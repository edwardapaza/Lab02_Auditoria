package com.google.android.recaptcha.internal;

import com.google.android.gms.common.api.a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class zziu extends zzgh implements RandomAccess, zziy, zzkm {
    private static final zziu zza = new zziu(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    zziu() {
        this(new int[10], 0, true);
    }

    private zziu(int[] iArr, int i5, boolean z4) {
        super(z4);
        this.zzb = iArr;
        this.zzc = i5;
    }

    public static zziu zzf() {
        return zza;
    }

    private final String zzh(int i5) {
        int i6 = this.zzc;
        return "Index:" + i5 + ", Size:" + i6;
    }

    private final void zzi(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i5));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i5 < 0 || i5 > (i6 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i5));
        }
        int i7 = i5 + 1;
        int[] iArr = this.zzb;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i7, i6 - i5);
        } else {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.zzb, i5, iArr2, i7, this.zzc - i5);
            this.zzb = iArr2;
        }
        this.zzb[i5] = intValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Integer) obj).intValue());
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzjc.zzd;
        collection.getClass();
        if (collection instanceof zziu) {
            zziu zziuVar = (zziu) collection;
            int i5 = zziuVar.zzc;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.zzc;
            if (a.e.API_PRIORITY_OTHER - i6 >= i5) {
                int i7 = i6 + i5;
                int[] iArr = this.zzb;
                if (i7 > iArr.length) {
                    this.zzb = Arrays.copyOf(iArr, i7);
                }
                System.arraycopy(zziuVar.zzb, 0, this.zzb, this.zzc, zziuVar.zzc);
                this.zzc = i7;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zziu) {
            zziu zziuVar = (zziu) obj;
            if (this.zzc != zziuVar.zzc) {
                return false;
            }
            int[] iArr = zziuVar.zzb;
            for (int i5 = 0; i5 < this.zzc; i5++) {
                if (this.zzb[i5] != iArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        zzi(i5);
        return Integer.valueOf(this.zzb[i5]);
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + this.zzb[i6];
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i5 = this.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.zzb[i6] == intValue) {
                    return i6;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        int i6;
        zza();
        zzi(i5);
        int[] iArr = this.zzb;
        int i7 = iArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i6 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i6, iArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.recaptcha.internal.zzgh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        zzi(i5);
        int[] iArr = this.zzb;
        int i6 = iArr[i5];
        iArr[i5] = intValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzjb
    public final /* bridge */ /* synthetic */ zzjb zzd(int i5) {
        if (i5 >= this.zzc) {
            return new zziu(Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zze(int i5) {
        zzi(i5);
        return this.zzb[i5];
    }

    public final void zzg(int i5) {
        zza();
        int i6 = this.zzc;
        int[] iArr = this.zzb;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        iArr3[i7] = i5;
    }
}
